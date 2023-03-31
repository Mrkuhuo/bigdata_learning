# hadoop shell 命令

1.  HDFS命令行

（1）ls

使用ls命令可以查看HDFS系统中的目录和文件。例如，查看HDFS文件系统根目录下的目录和文件，命令如下：

```
hdfs dfs -ls /
```

递归列出HDFS文件系统根目录下的所有目录和文件，命令如下：

```
hdfs dfs -ls -R /
```

（2）put

使用put命令可以将本地文件上传到HDFS系统中。例如，将本地当前目录文件a.txt上传到HDFS文件系统根目录的input文件夹中，命令如下：

```
hdfs dfs -put a.txt /input/
```

（3）moveFromLocal

使用moveFromLocal命令可以将本地文件移动到HDFS文件系统中，可以一次移动多个文件。／与put命令类似，不同的是，该命令执行后源文件将被删除。例如，将本地文件a.txt移动到HDFS根目录的input文件夹中，命令如下：

```
hdfs dfs -moveFromLocal a.txt /input/
```

（4）get

使用get命令可以将HDFS文件系统中的文件下载到本地，注意下载时的文件名不能与本地文件相同，否则会提示文件已经存在。下载多个文件或目录到本地时，要将本地路径设置为文件夹。例如，将HDFS根目录的input文件夹中的文件a.txt下载到本地当前目录，命令如下：

```
hdfs dfs -get /input/a.txt /tmp/
```

将HDFS根目录的input文件夹下载到本地当前目录，命令如下：

```
hdfs dfs -get /input/ ./
```

（5）rm

使用rm命令可以删除HDFS系统中的文件或文件夹，每次可以删除多个文件或目录。例如，删除HDFS根目录的input文件夹中的文件a.txt，命令如下：

```
hdfs dfs -rm /input/a.txt
```

递归删除HDFS根目录的output文件夹及该文件夹下的所有内容，命令如下：

```
hdfs dfs -rm -r /output
```

（6）mkdir

使用mkdir命令可以在HDFS系统中创建文件或目录。例如，在HDFS根目录下创建文件夹input，命令如下：

```
hdfs dfs -mkdir /input/
```

也可使用-p参数创建多级目录，如果父目录不存在，则会自动创建父目录。命令如下：

```
hdfs dfs -mkdir -p /input/file
```

（7）cp

```
hdfs dfs -cp /input/a.txt /input/b.txt
```

（8）mv

使用mv命令可以移动HDFS文件到另一个文件，相当于给文件重命名并保存，源文件已不存在。例如，将/input/a.txt移动到/input/b.txt，命令如下：

```
hdfs dfs -mv /input/a.txt /input/b.txt
```

（9）appendToFile

使用appendToFile命令可以将单个或多个文件的内容从本地系统追加到HDFS系统的文件中。例如，将本地当前目录的文件a.txt的内容追加到HDFS系统的/input/b.txt文件中，命令如下：

```
hdfs dfs -appendToFile a.txt /input/b.txt
```

若需要一次追加多个本地系统文件的内容，则多个文件用“空格”隔开。例如，将本地文件a.txt和b.txt的内容追加到HDFS系统的/input/c.txt文件中，命令如下：

```
hdfs dfs -appendToFile a.txt b.txt /input/c.txt
```

（10）cat

使用cat命令可以查看并输出HDFS系统中某个文件的所有内容。例如，查看HDFS系统中的文件/input/a.txt的所有内容，命令如下：

```
hdfs dfs -cat /input/a.txt
```

也可以同时查看并输出HDFS中的多个文件内容，结果会将多个文件的内容按照顺序合并输出。例如，查看HDFS中的文件/input/a.txt和文件/input/b.txt的所有内容，命令如下：

```
hdfs dfs -cat /input/a.txt /input/b.txt
```