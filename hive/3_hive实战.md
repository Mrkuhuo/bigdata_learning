### 一、Hive查询

1. WHERE子句

WHERE条件是布尔表达式。例如，下面的查询只返回来自美国地区的金额大于10的销售记录。Hive在WHERE子句中支持许多操作符和自定义函数。

```
select * from student where age > 10;
```

2. ALL和DISTINCT子句

ALL和DISTINCT选项指定是否应该返回重复的行，默认为ALL(返回所有匹配的行)。DISTINCT指定从结果集中删除重复行（注意，Hive从版本1.1.0开始支持DISTINCT）。

```
select distinct id,name,age from student;
```

3. HAVING子句

HAVING子句主要用于对GROUP BY语句产生的分组进行条件过滤。

```
select sum(age) from student group by age having sum(age) > 1 ;
```

4. LIMIT子句

LIMIT子句可用于限制SELECT语句返回的行数。LIMIT有一个或两个数值参数，它们都必须是非负整数常量。第一个参数指定要返回的开始行的偏移量（即行号，从0开始），第二个参数指定要返回的最大行数。当给定一个参数时，表示最大行数，偏移默认值为0。

以下查询返回表student 中的前5条数据：

```
#查看前十条
select id,name,age from student limit 10;
#按年龄排序后查看前十条
select id,name,age from student order by age limit 10;
#查看3到10条
select id,name,age from student limit 3,10;
```

5. GROUP BY子句

GROUP BY子句用于对表中的列进行分组查询。

例如，统计表student中不同性别的用户数量，查询结果显示年龄和数量。因此，可以根据性别字段进行分组：

```
select age ,count(age) from student group by age;
```

在GROUP BY查询中也可以同时指定多个聚合函数，但是多个函数需要指定同一列：

```
select age ,count(age),sum(age) from student group by age;
```

6. ORDER BY和SORT BY

ORDER BY与RDBMS中的ORDER BY一样，对全局结果进行排序。这就意味着，使用ORDER BY，所有数据只能通过一个reducer进行处理（多个reducer无法保证全局有序），当数据量特别大时，处理结果将非常缓慢。

SORT BY只是对进入reducer中的数据进行排序，相当于局部排序。可以保证每个reducer的输出数据都是有序的，但保证不了全局数据的顺序。

当reducer的数量都为1时，使用ORDER BY和SORT BY的排序结果是一样的，但如果reducer的数量大于1，排序结果将不同。

```
#全局排序
select * from student_bucket order by age;
#局部排序
select * from student_bucket sort by age;
```

7. DISTRIBUTE BY和CLUSTER BY

我们已经知道，MapReduce中的数据都是以键值对的方式进行组织的。默认情况下，MapReduce会根据键的哈希值均匀地将键值对分配到多个reducer中。而DISTRIBUTE BY的作用主要是控制键值对是如何划分到reducer中的。使用DISTRIBUTE BY可以保证某一列具有相同值的记录被分发到同一个reducer中进行处理，然后可以结合SORT BY对每一个reducer的数据进行排序，从而达到期望的输出结果。

```
select id , name, age from student distribute by id sort by id ;
相当于
select id , name, age from student cluster id ;
```

8. UNION子句

UNION用于将多个SELECT语句的结果合并到单个结果集中。UNION子句的语法

在1.2.0之前的Hive版本只支持UNION ALL，不会发生重复行删除，结果包含所有SELECT语句中的所有匹配行。在Hive 1.2.0和之后版本中，UNION的默认行为是从结果中删除重复的行。也就是默认为UNION DISTINCT，指定了重复行的删除。当然，也可以在同一个查询中混合UNION ALL和UNION DISTINCT。

```
select id,name from student UNION select uid,name from  student_bucket;
```

9. JOIN连接查询

Hive中没有主外键之分，但是可以进行多表关联查询。

① 内连接

内连接使用关键字JOIN...ON通过关联字段连接两张表，且同一个关联字段的值，两张表中的数据都存在才会在查询结果中显示（类似MySQL中的INNER JOIN）。

```
select a.id ,a.name from student join student_bucket b on a.id = b.id;
```

② 左外连接

左外连接以左表为准，使用关键字LEFT OUTER JOIN...ON通过关联字段连接右表，与内连接不同的是，左表中的所有数据都会显示，若左表中关联字段的值在右表中不存在，则右表中不存在的关联数据将置为空值NULL（类似MySQL中的LEFTJOIN）。

```
select a.id ,a.name from student left join student_bucket b on a.id = b.id;
```
③ 右外连接

右外连接与左外连接正好相反，以右表为准，使用关键字RIGHT OUTERJOIN...ON通过关联字段连接左表，右表中的所有数据都会显示，若右表中关联字段的值在左表中不存在，则左表中不存在的关联数据将置为空值NULL（类似MySQL中的RIGHT JOIN）。

```
select a.id ,a.name from student right join student_bucket b on a.id = b.id;
```

④ 全外连接

全外连接是左外连接与右外连接的综合，使用关键字FULL OUTER JOIN...ON通过关联字段连接两张表，将会显示两张表中的所有数据。若其中一张表中的关联字段的值在另一张表中不存在，则另一张表的查询数据将以空值NULL代替。

```
select a.id ,a.name from student FULL OUTER join student_bucket b on a.id = b.id;
```

⑤ 半连接

半连接使用关键字LEFT SEMI JOIN...ON通过关联字段连接右表，与外连接不同的是，半连接的查询结果只显示左表的内容，即显示与右表相关联的左表数据（类似于MySQL中的IN和EXISTS查询）。

```
select a.id ,a.name from student LEFT SEMI join student_bucket b on a.id = b.id;
```

### 三、Hive 其他命令

1. --database

启动Hive CLI时，指定要使用的数据库。例如，在Linux Shell中执行以下命令，指定使用数据库“test_db”。执行成功后将直接进入Hive命令行模式。

```
hive --database test_db.db;
```

2. -e

在Linux Shell中执行需要使用的SQL语句。

例如，在Linux Shell中执行以下命令，将直接使用默认数据库“default”查询表“student”的数据且不会进入到Hive命令行模式：

```
hive -e "select * from student";
```

3. -f

批量执行本地系统或HDFS系统中指定文件中的SQL语句。

例如，在本地系统目录/home/hadoop中创建一个文件hive.sql，并向其写入以下SQL命令：

```
hive -f /usr/local/src/data/hive.sql
```

4. --hiveconf

启动Hive CLI时，给指定属性设置值。

例如，执行以下命令，启动Hive CLI时将当前日志级别改为DEBUG（开启调试模式）。启动后，在Hive CLI中执行的所有命令将输出详细的日志信息。

```
hive -hive conf mapred.reduce.task = 0
```

5. 在Hive CLI中执行Linux Shell命令

在Hive CLI中也可以执行Linux Shell命令，只需要在Shell命令前面加上感叹号并以分号结尾即可。例如，在Hive CLI中查看当前系统启动的Java进程：

```
!jps
```

此外，Hive也提供了专门操作HDFS的命令，命令前缀为dfs：

```
dfs -ls /usr/hive
```

### 三、Hive中with…as的用法

1.Hive可以通过with…as方法来提高查询性能，先通过with语法将数据查询结果存到with后的表的内存中，后续的sql均可以访问这个with结果,作用与视图或临时表类似。

2.当这个表中的数据会被经常用到的话，用with…as这个方法会比较方便。

（一）基础格式

```
with A as (select * from B)
select * from A;
```

（二）同级格式

同级的多个表之间用,分割with只需要一次,as后的子句必须用()。

```
with A as (selesc B from C),
B as (select D from E)
select * from (select XXX from A) a;
```

（三）嵌套格式

```
with A as(
	with B as (
		select * from C
	)
	select * fron B
)
select * from A;

#其间只在结尾处有一个英文封号。
```

（四）只能在一条SQL语句中使用

```
with A as(
	select * from B
)
select * from A;

select XXX from A; #此处就会报错，一个封号就代表一个with语句结束
```

### 四、合并小文件

设置map输入的小文件合并

```
set mapred.max.split.size=256000000;
//一个节点上split的至少的大小(这个值决定了多个DataNode上的文件是否需要合并)
set mapred.min.split.size.per.node=100000000;
//一个交换机下split的至少的大小(这个值决定了多个交换机上的文件是否需要合并)
set mapred.min.split.size.per.rack=100000000;
//执行Map前进行小文件合并
set hive.input.format=org.apache.hadoop.hive.ql.io.CombineHiveInputFormat;

设置map输出和reduce输出进行合并的相关参数
//设置map端输出进行合并，默认为true
set hive.merge.mapfiles = true
//设置reduce端输出进行合并，默认为false
set hive.merge.mapredfiles = true
//设置合并文件的大小
set hive.merge.size.per.task = 25610001000
//当输出文件的平均大小小于该值时，启动一个独立的MapReduce任务进行文件merge。
set hive.merge.smallfiles.avgsize=16000000
```

