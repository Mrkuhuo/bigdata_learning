我们已经知道，HBase数据库没有类SQL的查询方式，因此在实际的业务中操作和计算数据非常不方便。而Hive支持标准的SQL语法（HiveQL），若将Hive与HBase整合，则可以通过HiveQL直接对HBase的表进行读写操作，让HBase支持JOIN、GROUP等SQL查询语法，完成复杂的数据分析。甚至可以通过连接和联合将对HBase表的访问与Hive表的访问结合起来进行统计与分析。

Hive与HBase整合的实现是利用两者本身对外的API接口互相通信来完成的，其具体工作由Hive安装主目录下的lib文件夹中的hive-hbase-handler-x.y.z.jar工具类来实现。

Hive与HBase整合的核心是将Hive中的表与HBase中的表进行绑定，绑定的关键是HBase中的表如何与Hive中的表在列级别上建立映射关系。例如，HBase中有一张表hbase_table，该表的数据模型如图9-37所示。

| rowkey | column family1 | column family2 |         |         |
|--------|----------------|----------------|---------|---------|
|        | column1        | column2        | column3 | column4 |
|        |                |                |         |         |
|        |                |                |         |         |
|        |                |                |         |         |

则对应Hive表的数据模型如图9-38所示。

| rowkey | column1 | column2 | column3 | column4 |
|--------|---------|---------|---------|---------|
|        |         |         |         |         |
|        |         |         |         |         |
|        |         |         |         |         |
|        |         |         |         |         |

下面具体讲解Hive如何与HBase进行整合，本例中Hive的版本为2.3.3，HBase的版本为1.2.6.1。

（1）前提条件。在整合之前，应先[安装好Hive](https://kinggence.atlassian.net/wiki/pages/resumedraft.action?draftId=819201)，并确保Hive能正常使用。Hive可安装于HBase集群的任意一个节点上。

（2）启动[ZooKeeper](https://kinggence.atlassian.net/wiki/spaces/KINGGENCE2/pages/884737)与HBase。

（3）修改Hive配置文件hive-site.xml。修改\$HIVE_HOME/conf下的配置文件hive-site.xml，添加Hive的HBase和ZooKeeper依赖包，内容如下：

```
<!--配置zookeeper链接地址-->
<property>
  <name>hive.zookeeper.quorum</name>
  <value>hadoop001:2181,hadoop002:2181,hadoop003:2181</value>
</property>
<!--配置依赖的Hbase、Zookeeper的jar文件-->
<property>
  <name>hive.aux.jars.path</name>
  <value>
  file:///${HBASE_HOME}/lib/hbase-common-1.2.6.1.jar
  file:///${HBASE_HOME}/lib/hbase-client-1.2.6.1.jar
  file:///${HBASE_HOME}/lib/hbase-server-1.2.6.1.jar
  file:///${HBASE_HOME}/lib/hbase-hadoop2-compat-1.2.6.1.jar
  file:///${HBASE_HOME}/lib/netty-all-4.0.23.Final.jar
  file:///${HBASE_HOME}/lib/hbase-protocol-1.2.6.1.jar
  file:///${HBASE_HOME}/lib/zookeeper-3.4.10.jar
  </value>
</property>
```


上述配置中首先指定了ZooKeeper集群的访问地址，若ZooKeeper集群端口统一为2181，此配置项可以省略，因为Hive默认将本地节点的2181端口作为ZooKeeper集群的访问地址。

然后指定了HBase、Hive和ZooKeeper安装目录下的lib文件夹中的相关jar文件，Hive在启动的时候会将上述配置的本地jar文件加入到ClassPath中。

在Hive2.3中，Hive安装主目录下的lib文件夹中实际上已经存在了上述jar文件，但是版本不同，为了防止产生兼容性问题，需要引用HBase与ZooKeeper中的jar文件。

到此，Hive与HBase整合完毕。目前，Hive中操作HBase的方式主要有以下两种，下面分别进行介绍。

1\. Hive创建表的同时创建HBase表

（1）在Hive中创建学生表“hive_student”：

```
create table hive_student(id int,name string) stored by 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' 
with serdeproperties("hbase.columns.mapping"=":key,cf1:name")
tblproperties ("hbase.table.name"="hive_student");
```


上述创建命令中的参数含义如下。 STORED BY ：指定用于Hive与HBase通信的工具类HBaseStorageHandler。 WITH SERDEPROPERTIES：指定HBase表与Hive表对应的列。此处":key,cf1:name"中的key指的是HBase表的rowkey列，对应Hive表的id列；cf1:name指的是HBase表中的列族cf1和cf1中的列name，对应Hive表的name列。Hive列与HBase列的对应不是通过列名称对应的，而是通过列的顺序。 TBLPROPERTIES：指定HBase表的属性信息。参数值“hive_student”代表HBase的表名。

（2）创建成功后，新开一个XShell窗口，在HBase Shell中查看创建的表：

```
list
```

可以看到，在HBase中成功创建了表“hive_student”。

（3）在Hive中向表“hive_student”添加一条数据（底层将开启MapReduce任务执行）：

```
insert into hive_student values(1,'zhangsan');
```

添加成功后，查看Hive数据仓库对应HDFS目录的表数据，发现数据为空，命令如下：

```
hadoop fs -ls -R /user/hive/warehouse/hive_student
```

然后查看HBase中的表“hive_student”的数据：
```
scan  'hive_student'
```

从上述查询信息可以看到，在Hive中成功地将一条数据添加到了HBase表中。

（4）修改HBase表数据。

修改HBase表“hive_student”，将姓名zhangsan改为lisi：

修改成功后，在Hive中查看表“hive_student”的数据：
```
put 'hive_student','1','cf1:name','lisi'
```
可以看到，表“hive_student”的数据已被修改。
```
scan  'hive_student'
```

（5）停止HBase。

停止HBase集群后，再次在Hive中查看表“hive_student”的数据：

```
select * from hive_student;
```

从上述输出信息可以看出，HBase集群停止后，在Hive中只能查看到表的元数据信息，查看不到实际表数据，并且会抛出IO连接异常错误。到此，我们可以得出一个结论：Hive与HBase整合后，实际上是将HBase作为Hive的数据源，数据存储在HBase中（实际上存储在由HRegionServer管理的HDFS中）而不是Hive的数据仓库中。

2.  Hive创建外部表关联已存在的HBase表

（1）在HBase中创建表“hbase_student”，并向表中添加两条数据：
```
create 'hbase_student', 'cf1'
put 'hbase_student' ,'1','cf1:name','zhangsan'
put 'hbase_student' ,'1','cf1:age','18'
put 'hbase_student' ,'1','cf1:name','lisi'
put 'hbase_student' ,'1','cf1:age','20'
```

（2）在Hive中创建外部表“hive_hbase_student”，并关联HBase表“hbase_student”：
```
create external table hive_hbase_student(id int ,name string,age int) 
stored by 'org.apache.hadoop.hive.hbase.HbaseStorageHandler'
with serdeproperties(
"hbase.columns.mapping" = ":key,cf1:name,cf1:age"
)
tblproperties("hbase.table.name" = "hbase_student")
```

（3）创建成功后，在Hive中查询表“hive_hbase_student”的数据：
```
select * from hive_hbase_student
```

可以看到，在Hive中成功查询到了HBase表“hbase_student”中的数据，即Hive外部表“hive_hbase_student”与HBase表“hbase_student”关联成功。

从上述两种操作方式可以得出以下结论：

在Hive中创建的HBase映射表的数据都只存在于HBase中，Hive的数据仓库中不存在数据。

HBase是Hive的数据源，Hive相当于HBase的一个客户端工具，可以对HBase数据进行查询与统计。 若HBase集群停止，Hive将查询不到HBase中的数据。

通过HBase的put语句添加一条数据比Hive的insert语句效率要高，因为Hive的insert语句需要开启MapReduce任务执行数据添加操作。
