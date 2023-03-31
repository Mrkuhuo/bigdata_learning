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

### 五、Hive 窗口函数

窗口函数最重要的关键字是 partition by 和 order by

具体语法如下：XXX over (partition by xxx order by xxx)

特别注意：over()里面的 partition by 和 order by 都不是必选的，over()里面可以只有partition by，也可以只有order by，也可以两个都没有，大家需根据需求灵活运用。

窗口函数我划分了几个大类，我们一类一类的讲解。

1. SUM、AVG、MIN、MAX
   讲解这几个窗口函数前，先创建一个表，以实际例子讲解大家更容易理解。

首先创建用户访问页面表：user_pv

```
create table user_pv(
cookieid string,  -- 用户登录的cookie，即用户标识
createtime string, -- 日期
pv int -- 页面访问量
); 
```

给上面这个表加上如下数据：

```
cookie1,2021-05-10,1
cookie1,2021-05-11,5
cookie1,2021-05-12,7
cookie1,2021-05-13,3
cookie1,2021-05-14,2
cookie1,2021-05-15,4
cookie1,2021-05-16,4
```

**SUM()使用**

执行如下查询语句：

```
select cookieid,createtime,pv,
sum(pv) over(partition by cookieid order by createtime) as pv1 
from user_pv;
```

结果如下：（因命令行原因，下图字段名和值是错位的，请注意辨别！）

![](../images/img_178.png)

执行如下查询语句：

```
select cookieid,createtime,pv,
sum(pv) over(partition by cookieid ) as pv1 
from user_pv;
```

结果如下：

![](../images/img_179.png)

第一条SQL的over()里面加 order by ，第二条SQL没加order by ，结果差别很大

所以要注意了：

**over()里面加 order by 表示**：分组内从起点到当前行的pv累积，如，11号的pv1=10号的pv+11号的pv, 12号=10号+11号+12号；

**over()里面不加 order by 表示**：将分组内所有值累加。

AVG，MIN，MAX，和SUM用法一样，这里就不展开讲了，但是要注意 AVG，MIN，MAX 的over()里面加不加 order by 也和SUM一样，如 AVG 求平均值，如果加上 order by，表示分组内从起点到当前行的平局值，不是全部的平局值。MIN，MAX 同理。

2. ROW_NUMBER、RANK、DENSE_RANK、NTILE

还是用上述的用户登录日志表：user_pv，里面的数据换成如下所示：

```
cookie1,2021-05-10,1
cookie1,2021-05-11,5
cookie1,2021-05-12,7
cookie1,2021-05-13,3
cookie1,2021-05-14,2
cookie1,2021-05-15,4
cookie1,2021-05-16,4
cookie2,2021-05-10,2
cookie2,2021-05-11,3
cookie2,2021-05-12,5
cookie2,2021-05-13,6
cookie2,2021-05-14,3
cookie2,2021-05-15,9
cookie2,2021-05-16,7
```

**ROW_NUMBER()使用：**

ROW_NUMBER()从1开始，按照顺序，生成分组内记录的序列。

```
SELECT 
cookieid,
createtime,
pv,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY pv desc) AS rn 
FROM user_pv;
```

结果如下：

![](../images/img_180.png)

**RANK 和 DENSE_RANK 使用：**

RANK() 生成数据项在分组中的排名，排名相等会在名次中留下空位。

DENSE_RANK()生成数据项在分组中的排名，排名相等会在名次中不会留下空位。

```
SELECT 
cookieid,
createtime,
pv,
RANK() OVER(PARTITION BY cookieid ORDER BY pv desc) AS rn1,
DENSE_RANK() OVER(PARTITION BY cookieid ORDER BY pv desc) AS rn2,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY pv DESC) AS rn3 
FROM user_pv 
WHERE cookieid = 'cookie1';
```

结果如下

![](../images/img_181.png)

**NTILE的使用：**

有时会有这样的需求:如果数据排序后分为三部分，业务人员只关心其中的一部分，如何将这中间的三分之一数据拿出来呢?NTILE函数即可以满足。

ntile可以看成是：把有序的数据集合平均分配到指定的数量（num）个桶中, 将桶号分配给每一行。如果不能平均分配，则优先分配较小编号的桶，并且各个桶中能放的行数最多相差1。

然后可以根据桶号，选取前或后 n分之几的数据。数据会完整展示出来，只是给相应的数据打标签；具体要取几分之几的数据，需要再嵌套一层根据标签取出。

```
SELECT 
cookieid,
createtime,
pv,
NTILE(2) OVER(PARTITION BY cookieid ORDER BY createtime) AS rn1,
NTILE(3) OVER(PARTITION BY cookieid ORDER BY createtime) AS rn2,
NTILE(4) OVER(ORDER BY createtime) AS rn3
FROM user_pv 
ORDER BY cookieid,createtime;
```

结果如下：

![](../images/img_182.png)

3. LAG、LEAD、FIRST_VALUE、LAST_VALUE
   
讲解这几个窗口函数时还是以实例讲解，首先创建用户访问页面表：user_url


```
CREATE TABLE user_url (
cookieid string,
createtime string,  --页面访问时间
url string       --被访问页面
);
```

表中加入如下数据：

```
cookie1,2021-06-10 10:00:02,url2
cookie1,2021-06-10 10:00:00,url1
cookie1,2021-06-10 10:03:04,1url3
cookie1,2021-06-10 10:50:05,url6
cookie1,2021-06-10 11:00:00,url7
cookie1,2021-06-10 10:10:00,url4
cookie1,2021-06-10 10:50:01,url5
cookie2,2021-06-10 10:00:02,url22
cookie2,2021-06-10 10:00:00,url11
cookie2,2021-06-10 10:03:04,1url33
cookie2,2021-06-10 10:50:05,url66
cookie2,2021-06-10 11:00:00,url77
cookie2,2021-06-10 10:10:00,url44
cookie2,2021-06-10 10:50:01,url55
```

**LAG的使用：**

LAG(col,n,DEFAULT) 用于统计窗口内往上第n行值。

第一个参数为列名，第二个参数为往上第n行（可选，默认为1），第三个参数为默认值（当往上第n行为NULL时候，取默认值，如不指定，则为NULL）

```
SELECT cookieid,
createtime,
url,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
LAG(createtime,1,'1970-01-01 00:00:00') OVER(PARTITION BY cookieid ORDER BY createtime) AS last_1_time,
LAG(createtime,2) OVER(PARTITION BY cookieid ORDER BY createtime) AS last_2_time 
FROM user_url;
```

结果如下：

![](../images/img_183.png)

解释：

```
last_1_time: 指定了往上第1行的值，default为'1970-01-01 00:00:00'  
                 cookie1第一行，往上1行为NULL,因此取默认值 1970-01-01 00:00:00
                 cookie1第三行，往上1行值为第二行值，2021-06-10 10:00:02
                 cookie1第六行，往上1行值为第五行值，2021-06-10 10:50:01
last_2_time: 指定了往上第2行的值，为指定默认值
       cookie1第一行，往上2行为NULL
       cookie1第二行，往上2行为NULL
       cookie1第四行，往上2行为第二行值，2021-06-10 10:00:02
       cookie1第七行，往上2行为第五行值，2021-06-10 10:50:01
```

**LEAD的使用：**

与LAG相反

LEAD(col,n,DEFAULT) 用于统计窗口内往下第n行值。

第一个参数为列名，第二个参数为往下第n行（可选，默认为1），第三个参数为默认值（当往下第n行为NULL时候，取默认值，如不指定，则为NULL）

```
SELECT cookieid,
createtime,
url,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
LEAD(createtime,1,'1970-01-01 00:00:00') OVER(PARTITION BY cookieid ORDER BY createtime) AS next_1_time,
LEAD(createtime,2) OVER(PARTITION BY cookieid ORDER BY createtime) AS next_2_time 
FROM user_url;
```

结果如下：

![](../images/img_184.png)

**FIRST_VALUE的使用：**

取分组内排序后，截止到当前行，第一个值。

```
SELECT cookieid,
createtime,
url,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
FIRST_VALUE(url) OVER(PARTITION BY cookieid ORDER BY createtime) AS first1 
FROM user_url;
```

结果如下：

![](../images/img_185.png)

**LAST_VALUE的使用**：

取分组内排序后，截止到当前行，最后一个值。

```
SELECT cookieid,
createtime,
url,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
LAST_VALUE(url) OVER(PARTITION BY cookieid ORDER BY createtime) AS last1 
FROM user_url;
```

结果如下：

![](../images/img_186.png)

如果想要取分组内排序后最后一个值，则需要变通一下：

```
SELECT cookieid,
createtime,
url,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
LAST_VALUE(url) OVER(PARTITION BY cookieid ORDER BY createtime) AS last1,
FIRST_VALUE(url) OVER(PARTITION BY cookieid ORDER BY createtime DESC) AS last2 
FROM user_url 
ORDER BY cookieid,createtime;
```

注意上述SQL，使用的是 FIRST_VALUE 的倒序取出分组内排序最后一个值！

结果如下：

![](../images/img_187.png)

**此处要特别注意order  by**

如果不指定ORDER BY，则进行排序混乱，会出现错误的结果

```
SELECT cookieid,
createtime,
url,
FIRST_VALUE(url) OVER(PARTITION BY cookieid) AS first2  
FROM user_url;
```

结果如下：

![](../images/img_188.png)

上述 url2 和 url55 的createtime即不属于最靠前的时间也不属于最靠后的时间，所以结果是混乱的。

4. CUME_DIST

先创建一张员工薪水表：staff_salary

```
CREATE EXTERNAL TABLE staff_salary (
dept string,
userid string,
sal int
);
```

表中加入如下数据：

```
d1,user1,1000
d1,user2,2000
d1,user3,3000
d2,user4,4000
d2,user5,5000
```

**CUME_DIST的使用：**

此函数的结果和order by的排序顺序有关系。

CUME_DIST：小于等于当前值的行数/分组内总行数。  order默认顺序 ：正序

比如，统计小于等于当前薪水的人数，所占总人数的比例。

```
SELECT 
dept,
userid,
sal,
CUME_DIST() OVER(ORDER BY sal) AS rn1,
CUME_DIST() OVER(PARTITION BY dept ORDER BY sal) AS rn2 
FROM staff_salary;
```

结果如下：

![](../images/img_189.png)

解释：

```
rn1: 没有partition,所有数据均为1组，总行数为5，
     第一行：小于等于1000的行数为1，因此，1/5=0.2
     第三行：小于等于3000的行数为3，因此，3/5=0.6
rn2: 按照部门分组，dpet=d1的行数为3,
     第二行：小于等于2000的行数为2，因此，2/3=0.6666666666666666
```

5. GROUPING SETS、GROUPING__ID、CUBE、ROLLUP

这几个分析函数通常用于OLAP中，不能累加，而且需要根据不同维度上钻和下钻的指标统计，比如，分小时、天、月的UV数。

还是先创建一个用户访问表：user_date

```
CREATE TABLE user_date (
month STRING,
day STRING, 
cookieid STRING 
);
```

表中加入如下数据：

```
2021-03,2021-03-10,cookie1
2021-03,2021-03-10,cookie5
2021-03,2021-03-12,cookie7
2021-04,2021-04-12,cookie3
2021-04,2021-04-13,cookie2
2021-04,2021-04-13,cookie4
2021-04,2021-04-16,cookie4
2021-03,2021-03-10,cookie2
2021-03,2021-03-10,cookie3
2021-04,2021-04-12,cookie5
2021-04,2021-04-13,cookie6
2021-04,2021-04-15,cookie3
2021-04,2021-04-15,cookie2
2021-04,2021-04-16,cookie1
```

**GROUPING SETS的使用：**

grouping sets是一种将多个group by 逻辑写在一个sql语句中的便利写法。

等价于将不同维度的GROUP BY结果集进行UNION ALL。

```
SELECT 
month,
day,
COUNT(DISTINCT cookieid) AS uv,
GROUPING__ID 
FROM user_date 
GROUP BY month,day 
GROUPING SETS (month,day) 
ORDER BY GROUPING__ID;
```

**注：上述SQL中的GROUPING__ID，是个关键字，表示结果属于哪一个分组集合，根据grouping sets中的分组条件month，day，1是代表month，2是代表day。**

结果如下：

![](../images/img_190.png)

上述SQL等价于：

```
SELECT month,
NULL as day,
COUNT(DISTINCT cookieid) AS uv,
1 AS GROUPING__ID 
FROM user_date 
GROUP BY month 

UNION ALL 

SELECT NULL as month,
day,
COUNT(DISTINCT cookieid) AS uv,
2 AS GROUPING__ID 
FROM user_date 
GROUP BY day;
```

**CUBE的使用：**

根据GROUP BY的维度的所有组合进行聚合。

```
SELECT 
month,
day,
COUNT(DISTINCT cookieid) AS uv,
GROUPING__ID 
FROM user_date 
GROUP BY month,day 
WITH CUBE 
ORDER BY GROUPING__ID;
```

结果如下：

![](../images/img_191.png)

上述SQL等价于：

```
SELECT NULL,NULL,COUNT(DISTINCT cookieid) AS uv,0 AS GROUPING__ID FROM user_date

UNION ALL 

SELECT month,NULL,COUNT(DISTINCT cookieid) AS uv,1 AS GROUPING__ID FROM user_date GROUP BY month 

UNION ALL 

SELECT NULL,day,COUNT(DISTINCT cookieid) AS uv,2 AS GROUPING__ID FROM user_date GROUP BY day

UNION ALL 

SELECT month,day,COUNT(DISTINCT cookieid) AS uv,3 AS GROUPING__ID FROM user_date GROUP BY month,day;
```

**ROLLUP的使用：**

是CUBE的子集，以最左侧的维度为主，从该维度进行层级聚合。

比如，以month维度进行层级聚合：

```
SELECT 
month,
day,
COUNT(DISTINCT cookieid) AS uv,
GROUPING__ID  
FROM user_date 
GROUP BY month,day
WITH ROLLUP 
ORDER BY GROUPING__ID;
```

结果如下：

![](../images/img_192.png)

把month和day调换顺序，则以day维度进行层级聚合：

```
SELECT 
day,
month,
COUNT(DISTINCT cookieid) AS uv,
GROUPING__ID  
FROM user_date 
GROUP BY day,month 
WITH ROLLUP 
ORDER BY GROUPING__ID;
```
结果如下：

![](../images/img_193.png)

这里，根据日和月进行聚合，和根据日聚合结果一样，因为有父子关系，如果是其他维度组合的话，就会不一样。

**窗口函数实际应用**

1. **第二高的薪水**
   难度简单。

编写一个 SQL 查询，获取 Employee 表中第二高的薪水（Salary）。

```
+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
```

例如上述 Employee 表，SQL查询应该返回 200 作为第二高的薪水。如果不存在第二高的薪水，那么查询应返回 null。

```
+---------------------+
| SecondHighestSalary |
+---------------------+
| 200                 |
+---------------------+
```

这道题可以用 row_number 函数解决。

参考代码：

```
SELECT
  *
  FROM(
    SELECT Salary, row_number() over(order by Salary desc) rk 
    FROM Employee
  ) t WHERE t.rk = 2;
```

更简单的代码：

```
SELECT DISTINCT Salary
FROM Employee
ORDER BY Salary DESC
LIMIT 1 OFFSET 1
```

OFFSET：偏移量，表示从第几条数据开始取，0代表第1条数据。

2. **分数排名**
   难度简单。

编写一个 SQL 查询来实现分数排名。

如果两个分数相同，则两个分数排名（Rank）相同。请注意，平分后的下一个名次应该是下一个连续的整数值。换句话说，名次之间不应该有“间隔”。

```
+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
```

例如，根据上述给定的 Scores 表，你的查询应该返回（按分数从高到低排列）：

```
+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+
```

参考代码：

```
SELECT Score,
dense_rank() over(order by Score desc) as `Rank`
FROM Scores;
```

3. **连续出现的数字**
   难度中等。

编写一个 SQL 查询，查找所有至少连续出现三次的数字。

```
+----+-----+
| Id | Num |
+----+-----+
| 1  |  1  |
| 2  |  1  |
| 3  |  1  |
| 4  |  2  |
| 5  |  1  |
| 6  |  2  |
| 7  |  2  |
+----+-----+
```

例如，给定上面的 Logs 表， 1 是唯一连续出现至少三次的数字。

```
+-----------------+
| ConsecutiveNums |
+-----------------+
| 1               |
+-----------------+
```

参考代码：

```
SELECT DISTINCT `Num` as ConsecutiveNums
FROM
  (
    SELECT Num,
    lead(Num, 1, null) over(order by id) n2,
    lead(Num, 2, null) over(order by id) n3 
    FROM Logs
  ) t1
WHERE Num = n2 and Num = n3
```

4. **连续N天登录**
   难度困难。

写一个 SQL 查询,  找到活跃用户的 id 和 name，活跃用户是指那些至少连续 5 天登录账户的用户，返回的结果表按照 id 排序。

表 Accounts：

```
+----+-----------+
| id | name      |
+----+-----------+
| 1  | Winston   |
| 7  | Jonathan  |
+----+-----------+
```

表 Logins：

```
+----+-------------+
| id | login_date  |
+----+-------------+
| 7  | 2020-05-30  |
| 1  | 2020-05-30  |
| 7  | 2020-05-31  |
| 7  | 2020-06-01  |
| 7  | 2020-06-02  |
| 7  | 2020-06-02  |
| 7  | 2020-06-03  |
| 1  | 2020-06-07  |
| 7  | 2020-06-10  |
+----+-------------+
```

例如，给定上面的Accounts和Logins表，至少连续 5 天登录账户的是id=7的用户

```
+----+-----------+
| id | name      |
+----+-----------+
| 7  | Jonathan  |
+----+-----------+
```

思路：

1. 去重：由于每个人可能一天可能不止登陆一次，需要去重
2. 排序：对每个ID的登录日期排序
3. 差值：计算登录日期与排序之间的差值，找到连续登陆的记录
4. 连续登录天数计算：select id, count(*) group by id, 差值（伪代码）
5. 取出登录5天以上的记录
6. 通过表合并，取出id对应用户名

参考代码：

```
SELECT DISTINCT b.id, name
FROM
  (SELECT id, login_date,
    DATE_SUB(login_date, ROW_NUMBER() OVER(PARTITION BY id ORDER BY login_date)) AS diff 
   FROM(SELECT DISTINCT id, login_date FROM Logins) a) b
INNER JOIN Accounts ac
ON b.id = ac.id
GROUP BY b.id, diff
HAVING COUNT(b.id) >= 5
```

**注意点：**

DATE_SUB的应用：DATE_SUB (DATE, X)，注意，X为正数表示当前日期的前X天；

如何找连续日期：通过排序与登录日期之间的差值，因为排序连续，因此若登录日期连续，则差值一致；

GROUP BY和HAVING的应用：通过id和差值的GROUP BY，用COUNT找到连续天数大于5天的id，注意COUNT不是一定要出现在SELECT后，可以直接用在HAVING中

5. **给定数字的频率查询中位数**
   难度困难。

Numbers 表保存数字的值及其频率。

```
+----------+-------------+
|  Number  |  Frequency  |
+----------+-------------|
|  0       |  7          |
|  1       |  1          |
|  2       |  3          |
|  3       |  1          |
+----------+-------------+
```

在此表中，数字为 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3，所以中位数是 (0 + 0) / 2 = 0。

```
+--------+
| median |
+--------|
| 0.0000 |
+--------+
```

请编写一个查询来查找所有数字的中位数并将结果命名为 median 。

参考代码：

```
select
avg(cast(number as float)) as median
from
  (
    select Number,
    Frequency,
    sum(Frequency) over(order by Number) - Frequency as prev_sum,
    sum(Frequency) over(order by Number) as curr_sum 
    from Numbers
  ) t1, (
    select sum(Frequency) as total_sum 
    from Numbers
  ) t2
where
t1.prev_sum <= (cast(t2.total_sum as float) / 2) 
and
t1.curr_sum >= (cast(t2.total_sum as float) / 2)
```