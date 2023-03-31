# MapReduce 实战

### 1.基本信息
尽管Hadoop的基本框架是用java实现的，但hadoop程序不限于java，可以用python、C++及ruby等等。
Hadoop Streaming提供一个在MapReduce下进行编程的工具包，用户可以基于一些可执行命令、脚本语言或者其他编程语言来创建Map和Reduce任务。

本例中利用Hadoop Streaming + Python 实现统计输入文本的单词的频数。

操作系统：CentOS7.6
Hadoop版本： Hadoop 2.8.2单机版环境
Python版本： Python2.7.5

### 2.实例代码
#### 2.1 Map阶段
通过stdin读取文本字符串；

对字符串进行分割等处理；

统计每个单词的频数并输出；

将mapper.py保存到 /usr/local/code 文件夹内，内容如下：

```
#coding=utf-8
import sys

# stdin标准化输入
for line in sys.stdin:
	# 移除字符串头尾的空格
	line = line.strip()
	# 空格作为分隔符对字符串进行分割
	words = line.split()
	for word in words：
		print "%s\t%s" % (word, 1)
```

#### 2.2 Reduce阶段
* 通过stdin读取Map阶段的输出；
* 利用split等解析Map阶段的输出；
* 当单词相同时将频数累积；

同样将reducer.py保存到 /usr/local/code 文件夹内，内容如下：

```
#coding=utf-8

import sys

curr_word = None
curr_count = 0

for line in sys.stdin:
    line = line.strip()
    # 以tab作分割符，解析mapper.py的输出
    word, count = line.split('\t', 1)
    
    if not curr_word: 
        curr_word = word
    if curr_word != word:
        print curr_word + "\t" + str(curr_count)
        curr_count = 0
        curr_word = word
    curr_count += int(count)

# 最后一个单词的频数
print curr_word + "\t" + str(curr_count)
```

#### 2.3 本地测试

**mapper.py测试**

我们先可以在本地对mapper.py进行测试，确保能够实现正确的逻辑。

```
[root@DW1 code]# echo 'sing dance rap baskerball dance sing' | python mapper.py 
sing	1
dance	1
rap	1
baskerball	1
dance	1
sing	1
```

输出每个单词及后面的数量1，符合我们的预先设想。

**reducer.py测试**

然后再加上reducer.py进行测试，在本地模拟整个MapReduce的过程：

```
[root@DW1 code]# echo 'sing dance rap baskerball dance sing' | python mapper.py | sort -k 1 | python reducer.py
baskerball	1
dance	2
rap	1
sing	2
```

可以看到相同单词的频数已经完成了累积，实现了统计文本单词数的目的。

**sort -k 1的作用**

其中sort -k 1起到了将mapper的输出按key排序的作用：-k， -key = POS1[,POS2] .

pos1是key开始的位置，pos2是key结束的位置。

```
# mapper.py 的输出
sing	1
dance	1
rap	1
baskerball	1
dance	1
sing	1

# sort -k 1 排序后
baskerball	1
dance	1
dance	1
rap	1
sing	1
sing	1
```

### 3.在Hadoop上运行WordCount实例

#### 3.1 数据准备

在开始之前，先准备一个文本作为我们的测试数据，再上传到HDFS的input文件夹：

```
[root@DW1 test]# hadoop fs -put word.txt /input
[root@DW1 test]# hadoop fs -ls /input
Found 1 items
-rw-r--r--   2 root supergroup     528628 2019-08-02 05:28 /input/word.txt
```

#### 3.2 MapReduce job

然后我们来写一个work.sh脚本，完成MapReduce job，脚本内容如下：

```
HADOOP_CMD="$HADOOP_HOME/bin/hadoop"
HADOOP_STREAM_PATH="$HADOOP_HOME/share/hadoop/tools/lib/hadoop-streaming-2.8.2.jar"

# 要先删除输出目录，不能为已存在的文件夹
$HADOOP_CMD fs -rm -r /output
$HADOOP_CMD jar $HADOOP_STREAM_PATH \
-file "/usr/local/code/mapper.py" -mapper "python mapper.py" \
-file "/usr/local/code/reducer.py" -reducer "python reducer.py" \
-input "/input/README.txt"  \
-output "/output"
```

#### 3.3 可能遇到的问题

脚本内容主要就是一些文件存放的路径，但要注意以下几个点：

**3.3.1 输出文件夹不能为已有的文件夹，否则会报以下的错误：**

`ERROR streaming.StreamJob: Error Launching job : Output directory hdfs://DW1:9000/output already exists`

3.3.2 集群开启要执行start-all.sh而不是start-dfs.sh脚本

具体原因是因为过程中要用到资源管理器(ResourceManager)，如果执行start-dfs.sh则不会开启。

3.3.3 如果遇到以下错误，请配置$HADOOP_HOME/etc/hadoop下的mapred-site.xml

`Error: Could not find or load main class org.apache.hadoop.mapreduce.v2.app.MRAppMaster`

添加如下内容：

```
<property>
  <name>yarn.app.mapreduce.am.env</name>
  <value>HADOOP_MAPRED_HOME=${HADOOP_HOME}</value>
</property>
<property>
  <name>mapreduce.map.env</name>
  <value>HADOOP_MAPRED_HOME=${HADOOP_HOME}</value>
</property>
<property>
  <name>mapreduce.reduce.env</name>
  <value>HADOOP_MAPRED_HOME=${HADOOP_HOME}</value>
</property>
```

#### 3.4 执行实例

```
# 执行我们刚才的编写脚本
[root@DW1 code]# sh work.sh
# 最后一行的输出，表示已成功
...
2019-08-02 08:40:19,598 INFO streaming.StreamJob: Output directory: /output

# 查看output文件夹，发现多了两个items
[root@DW1 code]# hadoop fs -ls /output
Found 2 items
-rw-r--r--   2 root supergroup          0 2019-08-02 09:02 /output/_SUCCESS
-rw-r--r--   2 root supergroup       5606 2019-08-02 09:02 /output/part-00000

# 查看实例完成后的结果
[root@DW1 code]# hadoop fs -cat /output/*
"I'm	1
"hell	1
''Hey	1
'em	4
'til	1
...
```

因为只是简单地用空格作为分隔符，其实分割地不够好，但可以看出还是达到了我们预想的要求。