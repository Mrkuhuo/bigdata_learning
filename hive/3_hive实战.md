本文基本涵盖了Hive日常使用的所有SQL，因为SQL太多，所以将SQL进行了如下分类：

一、DDL语句（数据定义语句）：

1.  对数据库的操作：包含创建、修改数据库
2.  对数据表的操作：分为内部表及外部表，分区表和分桶表

二、DQL语句（数据查询语句）：

1.  单表查询、关联查询
2.  hive函数：包含聚合函数，条件函数，日期函数，字符串函数等
3.  行转列及列转行：lateral view 与 explode 以及 reflect
4.  窗口函数与分析函数
5.  其他一些窗口函数

## Hive的DDL语法

### 对数据库的操作

创建数据库:

```
create database if not exists myhive;
说明：hive的表存放位置模式是由hive-site.xml当中的一个属性指定的 :hive.metastore.warehouse.dir

创建数据库并指定hdfs存储位置 :
create database myhive2 location '/myhive2';
```

修改数据库:

```
alter  database  myhive2  set  dbproperties('createtime'='20210329');
```

说明：可以使用alter database 命令来修改数据库的一些属性。但是数据库的元数据信息是不可更改的，包括数据库的名称以及数据库所在的位置

查看数据库详细信息：

```
查看数据库基本信息
hive (myhive)> desc  database  myhive2;

查看数据库更多详细信息
hive (myhive)> desc database extended  myhive2;
```

删除数据库：

```
删除一个空数据库，如果数据库下面有数据表，那么就会报错
drop  database  myhive2;

强制删除数据库，包含数据库下面的表一起删除
drop  database  myhive  cascade; 
```

### 对数据表的操作

#### 对管理表(内部表)的操作:

建内部表:

```
hive (myhive)> use myhive; -- 使用myhive数据库
hive (myhive)> create table stu(id int,name string);
hive (myhive)> insert into stu values (1,"zhangsan");
hive (myhive)> insert into stu values (1,"zhangsan"),(2,"lisi");  -- 一次插入多条数据
hive (myhive)> select * from stu;
```

hive建表时候的字段类型:

| **分类** | **类型**   | **描述**                                       | **字面量示例**                                                  |
|----------|------------|------------------------------------------------|-----------------------------------------------------------------|
| 原始类型 | BOOLEAN    | true/false                                     | TRUE                                                            |
|          | TINYINT    | 1字节的有符号整数 -128\~127                    | 1Y                                                              |
|          | SMALLINT   | 2个字节的有符号整数，-32768\~32767             | 1S                                                              |
|          | **INT**    | 4个字节的带符号整数                            | 1                                                               |
|          | BIGINT     | 8字节带符号整数                                | 1L                                                              |
|          | FLOAT      | 4字节单精度浮点数1.0                           |                                                                 |
|          | DOUBLE     | 8字节双精度浮点数                              | 1.0                                                             |
|          | DEICIMAL   | 任意精度的带符号小数                           | 1.0                                                             |
|          | **STRING** | 字符串，变长                                   | “a”,’b’                                                         |
|          | VARCHAR    | 变长字符串                                     | “a”,’b’                                                         |
|          | CHAR       | 固定长度字符串                                 | “a”,’b’                                                         |
|          | BINARY     | 字节数组                                       | 无法表示                                                        |
|          | TIMESTAMP  | 时间戳，毫秒值精度                             | 122327493795                                                    |
|          | **DATE**   | 日期                                           | ‘2016-03-29’                                                    |
|          | INTERVAL   | 时间频率间隔                                   |                                                                 |
| 复杂类型 | ARRAY      | 有序的的同类型的集合                           | array(1,2)                                                      |
|          | MAP        | key-value,key必须为原始类型，value可以任意类型 | map(‘a’,1,’b’,2)                                                |
|          | STRUCT     | 字段集合,类型可以不同                          | struct(‘1’,1,1.0), named_stract(‘col1’,’1’,’col2’,1,’clo3’,1.0) |
|          | UNION      | 在有限取值范围内的一个值                       | create_union(1,’a’,63)                                          |

**对decimal类型简单解释下**：  
用法：decimal(11,2) 代表最多有11位数字，其中后2位是小数，整数部分是9位；如果整数部分超过9位，则这个字段就会变成null；如果小数部分不足2位，则后面用0补齐两位，如果小数部分超过两位，则超出部分四舍五入  
也可直接写 decimal，后面不指定位数，默认是 decimal(10,0) 整数10位，没有小数

创建表并指定字段之间的分隔符：

```
create  table if not exists stu2(id int ,name string) row format delimited fields terminated by '\t' stored as textfile location '/user/stu2';
```

row format delimited fields terminated by '\\t' 指定字段分隔符，默认分隔符为 '\\001'  
stored as 指定存储格式  
location 指定存储位置

根据查询结果创建表：

```
create table stu3 as select * from stu2;
```

根据已经存在的表结构创建表：

```
create table stu4 like stu2;
```

查询表的结构：

```
只查询表内字段及属性
desc stu2;

详细查询
desc formatted  stu2;
```

查询创建表的语句：

```
show create table stu2;
```

#### 对外部表操作

外部表因为是指定其他的hdfs路径的数据加载到表当中来，所以hive表会认为自己不完全独占这份数据，所以删除hive表的时候，数据仍然存放在hdfs当中，不会删掉，只会删除表的元数据

构建外部表

```
create external table student (s_id string,s_name string) row format delimited fields terminated by '\t';
```

从本地文件系统向表中加载数据

```
追加操作
load data local inpath '/export/servers/hivedatas/student.csv' into table student;

覆盖操作
load data local inpath '/export/servers/hivedatas/student.csv' overwrite  into table student;
```

从hdfs文件系统向表中加载数据

```
load data inpath '/hivedatas/techer.csv' into table techer;

加载数据到指定分区
load data inpath '/hivedatas/techer.csv' into table techer partition(cur_date=20201210);
```

**注意**：  
1.使用 load data local 表示从本地文件系统加载，文件会拷贝到hdfs上  
2.使用 load data 表示从hdfs文件系统加载，文件会直接移动到hive相关目录下，注意不是拷贝过去，因为hive认为hdfs文件已经有3副本了，没必要再次拷贝了  
3.如果表是分区表，load 时不指定分区会报错  
4.如果加载相同文件名的文件，会被自动重命名

#### 对分区表的操作

创建分区表的语法

```
create table score(s_id string, s_score int) partitioned by (month string);
```

创建一个表带多个分区

```
create table score2 (s_id string, s_score int) partitioned by (year string,month string,day string);
```

**注意：**  
**hive表创建的时候可以用 location 指定一个文件或者文件夹，当指定文件夹时，hive会加载文件夹下的所有文件，当表中无分区时，这个文件夹下不能再有文件夹，否则报错**  
**当表是分区表时，比如 partitioned by (day string)， 则这个文件夹下的每一个文件夹就是一个分区，且文件夹名为 day=20201123 这种格式，然后使用：msck repair table score; 修复表结构，成功之后即可看到数据已经全部加载到表当中去了**

加载数据到一个分区的表中（静态分区）

```
load data local inpath '/export/servers/hivedatas/score.csv' into table score partition (month='201806');
```

加载数据到一个多分区的表中去（静态分区）

```
load data local inpath '/export/servers/hivedatas/score.csv' into table score2 partition(year='2018',month='06',day='01');
```

**按照数据加载到对应的分区**

创建一个普通表

```
create table score5(s_id string, s_score int,month string) row format delimited fields terminated by ',';
```

加载数据到普通表中

```
load data local inpath '/opt/software/hive/data/score.csv' into table score5;
```

动态分区设置相关配置

```
SET hive.exec.dynamic.partition=true;                                    --开启动态分区，默认是false
SET hive.exec.dynamic.partition.mode=nonstric;                           -- 开启允许所有分区都是动态的，否则必须要有静态分区才能使用。
```

从普通表查询数据到分区表中（动态分区）

```
insert into score partition(month)  select s_id,s_score,month from score5;
```

注意：分区表中加载数据的时候，会先保证分区表中的分区字段被填充，其余的业务字段按顺序依次填充，文件中字段不足的，表中用null填充，文件中字段超过的，表中字段满了以后，其余字段舍弃

查看分区

```
show  partitions  score;
```

添加一个分区

```
alter table score add partition(month='201805');
```

同时添加多个分区

```
alter table score add partition(month='201804') partition(month = '201803');
```

注意：添加分区之后就可以在hdfs文件系统当中看到表下面多了一个文件夹

删除分区

```
 alter table score add partition(month='201804') partition(month = '201803');
```

#### 对分桶表操作

将数据按照指定的字段进行分成多个桶中去，就是按照分桶字段进行哈希划分到多个文件当中去  
分区就是分文件夹，分桶就是分文件

分桶优点：

提高join查询效率

提高抽样效率

开启hive的捅表功能

```
set hive.enforce.bucketing=true;
```

设置reduce的个数

```
set mapreduce.job.reduces=3;
```

创建桶表

```
create table course (c_id string,c_name string) clustered by(c_id) into 3 buckets;
```

桶表的数据加载：由于桶表的数据加载通过hdfs dfs -put文件或者通过load data均不可以，只能通过insert overwrite 进行加载  
所以把文件加载到桶表中，需要先创建普通表，并通过insert overwrite的方式将普通表的数据通过查询的方式加载到桶表当中去

通过insert overwrite给桶表中加载数据

```
insert overwrite table course select * from course_common cluster by(c_id);  -- 最后指定桶字段
```

#### 修改表和删除表

修改表名称

```
alter  table  old_table_name  rename  to  new_table_name;
```

增加/修改列信息

```
查询表结构
desc score5;

添加列
alter table score5 add columns (mycol string, mysco string);

更新列
alter table score5 change column mysco mysconew int;
```

删除表操作

```
drop table score5;
```

清空表操作

```
truncate table score6;
```

说明：只能清空管理表，也就是内部表；清空外部表，会产生错误


**注意：truncate 和 drop：**  
**如果 hdfs 开启了回收站，drop 删除的表数据是可以从回收站恢复的，表结构恢复不了，需要自己重新创建；truncate 清空的表是不进回收站的，所以无法恢复truncate清空的表**  
**所以 truncate 一定慎用，一旦清空将无力回天**

#### 向hive表中加载数据

直接向分区表中插入数据

```
insert into table score partition(month ='201807') values ('001','002','100');
```

通过load方式加载数据

```
load data local inpath '/export/servers/hivedatas/score.csv' overwrite into table score partition(month='201806');
```

通过查询方式加载数据

```
insert overwrite table score2 partition(month = '201806') select s_id,c_id,s_score from score1;
```

查询语句中创建表并加载数据

```
create table score2 as select \* from score1;
```

在创建表是通过location指定加载数据的路径

```
create external table score6 (s_id string,c_id string,s_score int) row format delimited fields terminated by ',' location '/myscore';
```

export导出与import 导入 hive表数据（内部表操作）

```
create table techer2 like techer; --依据已有表结构创建表

export table techer to  '/export/techer';

import table techer2 from '/export/techer';
```

#### hive表中数据导出

insert导出

```
将查询的结果导出到本地
insert overwrite local directory '/export/servers/exporthive' select * from score;

将查询的结果格式化导出到本地
insert overwrite local directory '/export/servers/exporthive' row format delimited fields terminated by '\t' collection items terminated by '#' select * from student;

将查询的结果导出到HDFS上(没有local)
insert overwrite directory '/export/servers/exporthive' row format delimited fields terminated by '\t' collection items terminated by '#' select * from score;
```

Hadoop命令导出到本地

```
dfs -get /export/servers/exporthive/000000_0 /export/servers/exporthive/local.txt;
```

hive shell 命令导出

```
基本语法：（hive -f/-e 执行语句或者脚本 > file）

hive -e "select * from myhive.score;" > /export/servers/exporthive/score.txt

hive -f export.sh > /export/servers/exporthive/score.txt
```

export导出到HDFS上

```
export table score to '/export/exporthive/score';
```

## Hive的DQL查询语法

```
SELECT [ALL | DISTINCT] select_expr, select_expr, ... 
FROM table_reference
[WHERE where_condition] 
[GROUP BY col_list [HAVING condition]] 
[CLUSTER BY col_list 
  | [DISTRIBUTE BY col_list] [SORT BY| ORDER BY col_list] 
] 
[LIMIT number]
```

**注意：**  
**1、order by 会对输入做全局排序，因此只有一个reducer，会导致当输入规模较大时，需要较长的计算时间。  
2、sort by不是全局排序，其在数据进入reducer前完成排序。因此，如果用sort by进行排序，并且设置mapred.reduce.tasks\>1，则sort by只保证每个reducer的输出有序，不保证全局有序。  
3、distribute by(字段)根据指定的字段将数据分到不同的reducer，且分发算法是hash散列。  
4、Cluster by(字段) 除了具有Distribute by的功能外，还会对该字段进行排序。  
因此，如果分桶和sort字段是同一个时，此时，cluster by = distribute by + sort by**

WHERE语句

```
select \* from score where s_score \< 60;
```

**注意：  
小于某个值是不包含null的，如上查询结果是把 s_score 为 null 的行剔除的**

GROUP BY 分组

```
select s_id ,avg(s_score) from score group by s_id;

分组后对数据进行筛选，使用having
select s_id ,avg(s_score) avgscore from score group by s_id having avgscore > 85;
```

**注意：  
如果使用 group by 分组，则 select 后面只能写分组的字段或者聚合函数  
where和having区别：  
1 having是在 group by 分完组之后再对数据进行筛选，所以having 要筛选的字段只能是分组字段或者聚合函数  
2 where 是从数据表中的字段直接进行的筛选的，所以不能跟在gruop by后面，也不能使用聚合函数**

join 连接

```
INNER JOIN 内连接：只有进行连接的两个表中都存在与连接条件相匹配的数据才会被保留下来
select * from techer t [inner] join course c on t.t_id = c.t_id; -- inner 可省略

LEFT OUTER JOIN 左外连接：左边所有数据会被返回，右边符合条件的被返回
select * from techer t left join course c on t.t_id = c.t_id; -- outer可省略

RIGHT OUTER JOIN 右外连接：右边所有数据会被返回，左边符合条件的被返回、
select * from techer t right join course c on t.t_id = c.t_id;

FULL OUTER JOIN 满外(全外)连接: 将会返回所有表中符合条件的所有记录。如果任一表的指定字段没有符合条件的值的话，那么就使用NULL值替代。
SELECT * FROM techer t FULL JOIN course c ON t.t_id = c.t_id ;
```

**注：1. hive2版本已经支持不等值连接，就是 join on条件后面可以使用大于小于符号了;并且也支持 join on 条件后跟or (早前版本 on 后只支持 = 和 and，不支持 \> \< 和 or)  
2.如hive执行引擎使用MapReduce，一个join就会启动一个job，一条sql语句中如有多个join，则会启动多个job**

**注意：表之间用逗号(,)连接和 inner join 是一样的  
select \* from table_a,table_b where table_a.id=table_b.id;  
它们的执行效率没有区别，只是书写方式不同，用逗号是sql 89标准，join 是sql 92标准。用逗号连接后面过滤条件用 where ，用 join 连接后面过滤条件是 on。**

order by 排序

```
全局排序，只会有一个reduce
ASC（ascend）: 升序（默认） DESC（descend）: 降序
SELECT * FROM student s LEFT JOIN score sco ON s.s_id = sco.s_id ORDER BY sco.s_score DESC;
```

**注意：order by 是全局排序，所以最后只有一个reduce，也就是在一个节点执行，如果数据量太大，就会耗费较长时间**

sort by 局部排序

```
每个MapReduce内部进行排序，对全局结果集来说不是排序。

设置reduce个数
set mapreduce.job.reduces=3;

查看设置reduce个数
set mapreduce.job.reduces;

查询成绩按照成绩降序排列
select * from score sort by s_score;
 
将查询结果导入到文件中（按照成绩降序排列）
insert overwrite local directory '/export/servers/hivedatas/sort' select * from score sort by s_score;
```

distribute by 分区排序

```
distribute by：类似MR中partition，进行分区，结合sort by使用

设置reduce的个数，将我们对应的s_id划分到对应的reduce当中去
set mapreduce.job.reduces=7;

通过distribute by  进行数据的分区
select * from score distribute by s_id sort by s_score;
```

**注意：Hive要求 distribute by 语句要写在 sort by 语句之前**

cluster by

```
当distribute by和sort by字段相同时，可以使用cluster by方式.
cluster by除了具有distribute by的功能外还兼具sort by的功能。但是排序只能是正序排序，不能指定排序规则为ASC或者DESC。

以下两种写法等价
select * from score cluster by s_id;
select * from score distribute by s_id sort by s_id;
```

## Hive函数

### 聚合函数

```
hive支持 count(),max(),min(),sum(),avg() 等常用的聚合函数
```

```
注意：  
聚合操作时要注意null值  
count(\*) 包含null值，统计所有行数  
count(id) 不包含null值  
min 求最小值是不包含null，除非所有值都是null  
avg 求平均值也是不包含null
```

非空集合总体变量函数: var_pop

```
语法: var_pop(col)
返回值: double
说明: 统计结果集中col非空集合的总体变量（忽略null）
```

非空集合样本变量函数: var_samp

```
语法: var_pop(col)
返回值: double
说明: 统计结果集中col非空集合的总体变量（忽略null）
```

总体标准偏离函数: stddev_pop

```
语法: stddev_pop(col)
返回值: double
说明: 该函数计算总体标准偏离，并返回总体变量的平方根，其返回值与VAR_POP函数的平方根相同
```

中位数函数: percentile

```
语法: percentile(BIGINT col, p)
返回值: double
说明: 求准确的第pth个百分位数，p必须介于0和1之间，但是col字段目前只支持整数，不支持浮点数类型
```

### 关系运算

```
支持：等值(=)、不等值(!= 或 <>)、小于(<)、小于等于(<=)、大于(>)、大于等于(>=)

空值判断(is null)、非空判断(is not null)
```

LIKE比较: LIKE

```
语法: A LIKE B
操作类型: strings
描述: 如果字符串A或者字符串B为NULL，则返回NULL；如果字符串A符合表达式B 的正则语法，则为TRUE；否则为FALSE。B中字符”_”表示任意单个字符，而字符”%”表示任意数量的字符。
```

JAVA的LIKE操作: RLIKE

```
语法: A RLIKE B
操作类型: strings
描述: 如果字符串A或者字符串B为NULL，则返回NULL；如果字符串A符合JAVA正则表达式B的正则语法，则为TRUE；否则为FALSE。
```

REGEXP操作: REGEXP

```
语法: A REGEXP B
操作类型: strings
描述: 功能与RLIKE相同
示例：select 1 from tableName where 'footbar' REGEXP '^f.*r$';
结果：1
```

### 数学运算

```
支持所有数值类型：加(+)、减(-)、乘(*)、除(/)、取余(%)、位与(&)、位或(|)、位异或(^)、位取反(~)
```

### 逻辑运算

```
支持：逻辑与(and)、逻辑或(or)、逻辑非(not)
```

### 数值运算

取整函数: round

```
语法: round(double a)
返回值: BIGINT
说明: 返回double类型的整数值部分 （遵循四舍五入）
示例：select round(3.1415926) from tableName;
结果：3
```

指定精度取整函数: round

```
语法: round(double a, int d)
返回值: DOUBLE
说明: 返回指定精度d的double类型
hive> select round(3.1415926,4) from tableName;
3.1416
```

向下取整函数: floor

```
语法: floor(double a)
返回值: BIGINT
说明: 返回等于或者小于该double变量的最大的整数
hive> select floor(3.641) from tableName;
3
```

向上取整函数: ceil

```
语法: ceil(double a)
返回值: BIGINT
说明: 返回等于或者大于该double变量的最小的整数
hive> select ceil(3.1415926) from tableName;
4
```

取随机数函数: rand

```
语法: rand(),rand(int seed)
返回值: double
说明: 返回一个0到1范围内的随机数。如果指定种子seed，则会等到一个稳定的随机数序列
hive> select rand() from tableName; -- 每次执行此语句得到的结果都不同
0.5577432776034763

hive> select rand(100) ;  -- 只要指定种子，每次执行此语句得到的结果一样的
0.7220096548596434
```

自然指数函数: exp

```
语法: exp(double a)
返回值: double
说明: 返回自然对数e的a次方
hive> select exp(2) ;
7.38905609893065
```

以10为底对数函数: log10

```
语法: log10(double a)
返回值: double
说明: 返回以10为底的a的对数
hive> select log10(100) ;
2.0
```

**此外还有：以2为底对数函数: log2()、对数函数: log()**

幂运算函数: pow

```
语法: pow(double a, double p)
返回值: double
说明: 返回a的p次幂
hive> select pow(2,4) ;
16.0
```

开平方函数: sqrt

```
语法: sqrt(double a)
返回值: double
说明: 返回a的平方根
hive> select sqrt(16) ;
4.0
```

二进制函数: bin

```
语法: bin(BIGINT a)
返回值: string
说明: 返回a的二进制代码表示
hive> select bin(7) ;
111
```

**十六进制函数: hex()、将十六进制转化为字符串函数: unhex()  
进制转换函数: conv(bigint num, int from_base, int to_base) 说明: 将数值num从from_base进制转化到to_base进制**

**此外还有很多数学函数：绝对值函数: abs()、正取余函数: pmod()、正弦函数: sin()、反正弦函数: asin()、余弦函数: cos()、反余弦函数: acos()、positive函数: positive()、negative函数: negative()**

### 条件函数

If函数: if

```
语法: if(boolean testCondition, T valueTrue, T valueFalseOrNull)
返回值: T
说明: 当条件testCondition为TRUE时，返回valueTrue；否则返回valueFalseOrNull
hive> select if(1=2,100,200) ;
200
hive> select if(1=1,100,200) ;
100
```

非空查找函数: coalesce

```
语法: coalesce(T v1, T v2, …)
返回值: T
说明: 返回参数中的第一个非空值；如果所有值都为NULL，那么返回NULL
hive> select coalesce(null,'100','50') ;
100
```

条件判断函数：case when (两种写法，其一)

```
语法: case a when b then c [when d then e]* [else f] end
返回值: T
说明：如果a等于b，那么返回c；如果a等于d，那么返回e；否则返回f
hive> Select case 100 when 50 then 'tom' when 100 then 'mary' else 'tim' end from tableName;
mary
```

条件判断函数：case when (两种写法，其二)

```
语法: case a when b then c [when d then e]* [else f] end
返回值: T
说明：如果a等于b，那么返回c；如果a等于d，那么返回e；否则返回f
hive> Select case 100 when 50 then 'tom' when 100 then 'mary' else 'tim' end from tableName;
mary
```

### 日期函数

**注：以下SQL语句中的 from tableName 可去掉，不影响查询结果**

获取当前UNIX时间戳函数: unix_timestamp

```
语法: unix_timestamp()
返回值: bigint
说明: 获得当前时区的UNIX时间戳
hive> select unix_timestamp() from tableName;
1616906976
```

UNIX时间戳转日期函数: from_unixtime

```
语法: from_unixtime(bigint unixtime[, string format])
返回值: string
说明: 转化UNIX时间戳（从1970-01-01 00:00:00 UTC到指定时间的秒数）到当前时区的时间格式
hive> select from_unixtime(1616906976,'yyyyMMdd') from tableName;
20210328
```

日期转UNIX时间戳函数: unix_timestamp

```
语法: unix_timestamp(string date)
返回值: bigint
说明: 转换格式为"yyyy-MM-dd HH:mm:ss"的日期到UNIX时间戳。如果转化失败，则返回0。
hive>  select unix_timestamp('2021-03-08 14:21:15') from tableName;
1615184475
```

指定格式日期转UNIX时间戳函数: unix_timestamp

```
语法: unix_timestamp(string date, string pattern)
返回值: bigint
说明: 转换pattern格式的日期到UNIX时间戳。如果转化失败，则返回0。
hive>  select unix_timestamp('2021-03-08 14:21:15','yyyyMMdd HH:mm:ss') from tableName;
1615184475
```

日期时间转日期函数: to_date

```
语法: to_date(string timestamp)
返回值: string
说明: 返回日期时间字段中的日期部分。
hive> select to_date('2021-03-28 14:03:01') from tableName;
2021-03-28
```

日期转年函数: year

```
语法: year(string date)
返回值: int
说明: 返回日期中的年。
hive> select year('2021-03-28 10:03:01') from tableName;
2021
hive> select year('2021-03-28') from tableName;
2021
```

日期转月函数: month

```
语法: month (string date)
返回值: int
说明: 返回日期中的月份。
hive> select month('2020-12-28 12:03:01') from tableName;
12
hive> select month('2021-03-08') from tableName;
8
```

日期转天函数: day

```
语法: day (string date)
返回值: int
说明: 返回日期中的天。
hive> select day('2020-12-08 10:03:01') from tableName;
8
hive> select day('2020-12-24') from tableName;
24
```

日期转小时函数: hour

```
语法: hour (string date)
返回值: int
说明: 返回日期中的小时。
hive> select hour('2020-12-08 10:03:01') from tableName;
10
```

日期转分钟函数: minute

```
语法: minute (string date)
返回值: int
说明: 返回日期中的分钟。
hive> select minute('2020-12-08 10:03:01') from tableName;
3
```

日期转秒函数: second

```
语法: second (string date)
返回值: int
说明: 返回日期中的秒。
hive> select second('2020-12-08 10:03:01') from tableName;
1
```

日期转周函数: weekofyear

```
语法: weekofyear (string date)
返回值: int
说明: 返回日期在当前的周数。
hive> select weekofyear('2020-12-08 10:03:01') from tableName;
49
```

日期比较函数: datediff

```
语法: datediff(string enddate, string startdate)
返回值: int
说明: 返回结束日期减去开始日期的天数。
hive> select datediff('2020-12-08','2012-05-09') from tableName;
213
```

日期增加函数: date_add

```
语法: date_add(string startdate, int days)
返回值: string
说明: 返回开始日期startdate增加days天后的日期。
hive> select date_add('2020-12-08',10) from tableName;
2020-12-18
```

日期减少函数: date_sub

```
语法: date_sub (string startdate, int days)
返回值: string
说明: 返回开始日期startdate减少days天后的日期。
hive> select date_sub('2020-12-08',10) from tableName;
2020-11-28
```

### 字符串函数

字符串长度函数：length

```
语法: length(string A)
返回值: int
说明：返回字符串A的长度
hive> select length('abcedfg') from tableName;
7
```

字符串反转函数：reverse

```
语法: reverse(string A)
返回值: string
说明：返回字符串A的反转结果
hive> select reverse('abcedfg') from tableName;
gfdecba
```

字符串连接函数：concat

```
语法: concat(string A, string B…)
返回值: string
说明：返回输入字符串连接后的结果，支持任意个输入字符串
hive> select concat('abc','def’,'gh')from tableName;
abcdefgh
```

带分隔符字符串连接函数：concat_ws

```
语法: concat_ws(string SEP, string A, string B…)
返回值: string
说明：返回输入字符串连接后的结果，SEP表示各个字符串间的分隔符
hive> select concat_ws(',','abc','def','gh')from tableName;
abc,def,gh
```

字符串截取函数：substr,substring

```
语法: substr(string A, int start),substring(string A, int start)
返回值: string
说明：返回字符串A从start位置到结尾的字符串
hive> select substr('abcde',3) from tableName;
cde
hive> select substring('abcde',3) from tableName;
cde
hive> select substr('abcde',-1) from tableName; （和ORACLE相同）
e
```

字符串截取函数：substr,substring

```
语法: substr(string A, int start, int len),substring(string A, int start, int len)
返回值: string
说明：返回字符串A从start位置开始，长度为len的字符串
hive> select substr('abcde',3,2) from tableName;
cd
hive> select substring('abcde',3,2) from tableName;
cd
hive>select substring('abcde',-2,2) from tableName;
de
```

字符串转大写函数：upper,ucase

```
语法: upper(string A) ucase(string A)
返回值: string
说明：返回字符串A的大写格式
hive> select upper('abSEd') from tableName;
ABSED
hive> select ucase('abSEd') from tableName;
ABSED
```

字符串转小写函数：lower,lcase

```
语法: lower(string A) lcase(string A)
返回值: string
说明：返回字符串A的小写格式
hive> select lower('abSEd') from tableName;
absed
hive> select lcase('abSEd') from tableName;
absed
```

去空格函数：trim

```
语法: trim(string A)
返回值: string
说明：去除字符串两边的空格
hive> select trim(' abc ') from tableName;
abc
```

左边去空格函数：ltrim

```
语法: ltrim(string A)
返回值: string
说明：去除字符串左边的空格
hive> select ltrim(' abc ') from tableName;
abc
```

右边去空格函数：rtrim

```
语法: rtrim(string A)
返回值: string
说明：去除字符串右边的空格
hive> select rtrim(' abc ') from tableName;
abc
```

正则表达式替换函数：regexp_replace

```
语法: regexp_replace(string A, string B, string C)
返回值: string
说明：将字符串A中的符合java正则表达式B的部分替换为C。注意，在有些情况下要使用转义字符,类似oracle中的regexp_replace函数。
hive> select regexp_replace('foobar', 'oo|ar', '') from tableName;
fb
```

正则表达式解析函数：regexp_extract

```
语法: regexp_extract(string subject, string pattern, int index)
返回值: string
说明：将字符串subject按照pattern正则表达式的规则拆分，返回index指定的字符。
hive> select regexp_extract('foothebar', 'foo(.*?)(bar)', 1) from tableName;
the
hive> select regexp_extract('foothebar', 'foo(.*?)(bar)', 2) from tableName;
bar
hive> select regexp_extract('foothebar', 'foo(.*?)(bar)', 0) from tableName;
foothebar
strong>注意，在有些情况下要使用转义字符，下面的等号要用双竖线转义，这是java正则表达式的规则。
select data_field,
regexp_extract(data_field,'.*?bgStart\\=([^&]+)',1) as aaa,
regexp_extract(data_field,'.*?contentLoaded_headStart\\=([^&]+)',1) as bbb,
regexp_extract(data_field,'.*?AppLoad2Req\\=([^&]+)',1) as ccc 
from pt_nginx_loginlog_st 
where pt = '2021-03-28' limit 2;
```

URL解析函数：parse_url

```
语法: parse_url(string urlString, string partToExtract [, string keyToExtract])
返回值: string
说明：返回URL中指定的部分。partToExtract的有效值为：HOST, PATH, QUERY, REF, PROTOCOL, AUTHORITY, FILE, and USERINFO.
hive> select parse_url
('https://www.tableName.com/path1/p.php?k1=v1&k2=v2#Ref1', 'HOST') 
from tableName;
www.tableName.com 
hive> select parse_url
('https://www.tableName.com/path1/p.php?k1=v1&k2=v2#Ref1', 'QUERY', 'k1')
 from tableName;
v1
```

json解析函数：get_json_object

```
语法: get_json_object(string json_string, string path)
返回值: string
说明：解析json的字符串json_string,返回path指定的内容。如果输入的json字符串无效，那么返回NULL。
hive> select  get_json_object('{"store":{"fruit":\[{"weight":8,"type":"apple"},{"weight":9,"type":"pear"}], "bicycle":{"price":19.95,"color":"red"} },"email":"amy@only_for_json_udf_test.net","owner":"amy"}','$.owner') from tableName;
```

空格字符串函数：space

```
语法: space(int n)
返回值: string
说明：返回长度为n的字符串
hive> select space(10) from tableName;
hive> select length(space(10)) from tableName;
10
```

重复字符串函数：repeat

```
语法: repeat(string str, int n)
返回值: string
说明：返回重复n次后的str字符串
hive> select repeat('abc',5) from tableName;
abcabcabcabcabc
```

首字符ascii函数：ascii

```
语法: ascii(string str)
返回值: int
说明：返回字符串str第一个字符的ascii码
hive> select ascii('abcde') from tableName;
97
```

左补足函数：lpad

```
语法: lpad(string str, int len, string pad)
返回值: string
说明：将str进行用pad进行左补足到len位
hive> select lpad('abc',10,'td') from tableName;
tdtdtdtabc
注意：与GP，ORACLE不同，pad 不能默认
```

右补足函数：rpad

```
语法: rpad(string str, int len, string pad)
返回值: string
说明：将str进行用pad进行右补足到len位
hive> select rpad('abc',10,'td') from tableName;
abctdtdtdt
```

分割字符串函数: split

```
语法: split(string str, string pat)
返回值: array
说明: 按照pat字符串分割str，会返回分割后的字符串数组
hive> select split('abtcdtef','t') from tableName;
["ab","cd","ef"]
```

集合查找函数: find_in_set

```
语法: find_in_set(string str, string strList)
返回值: int
说明: 返回str在strlist第一次出现的位置，strlist是用逗号分割的字符串。如果没有找该str字符，则返回0
hive> select find_in_set('ab','ef,ab,de') from tableName;
2
hive> select find_in_set('at','ef,ab,de') from tableName;
0
```

### 复合类型构建操作

Map类型构建: map

```
语法: map (key1, value1, key2, value2, …)
说明：根据输入的key和value对构建map类型
hive> Create table mapTable as select map('100','tom','200','mary') as t from tableName;
hive> describe mapTable;
t       map<string ,string>
hive> select t from tableName;
{"100":"tom","200":"mary"}
```

Struct类型构建: struct

```
语法: struct(val1, val2, val3, …)
说明：根据输入的参数构建结构体struct类型
hive> create table struct_table as select struct('tom','mary','tim') as t from tableName;
hive> describe struct_table;
t       struct<col1:string ,col2:string,col3:string>
hive> select t from tableName;
{"col1":"tom","col2":"mary","col3":"tim"}
```

array类型构建: array

```
语法: array(val1, val2, …)
说明：根据输入的参数构建数组array类型
hive> create table arr_table as select array("tom","mary","tim") as t from tableName;
hive> describe tableName;
t       array<string>
hive> select t from tableName;
["tom","mary","tim"]
```

### 复杂类型访问操作

array类型访问: A[n]

```
语法: A[n]
操作类型: A为array类型，n为int类型
说明：返回数组A中的第n个变量值。数组的起始下标为0。比如，A是个值为['foo', 'bar']的数组类型，那么A[0]将返回'foo',而A[1]将返回'bar'
hive> create table arr_table2 as select array("tom","mary","tim") as t
 from tableName;
hive> select t[0],t[1] from arr_table2;
tom     mary    tim
```

map类型访问: M[key]

```
语法: M[key]
操作类型: M为map类型，key为map中的key值
说明：返回map类型M中，key值为指定值的value值。比如，M是值为{'f' -> 'foo', 'b' -> 'bar', 'all' -> 'foobar'}的map类型，那么M['all']将会返回'foobar'
hive> Create table map_table2 as select map('100','tom','200','mary') as t from tableName;
hive> select t['200'],t['100'] from map_table2;
mary    tom
```

struct类型访问: S.x

```
语法: S.x
操作类型: S为struct类型
说明：返回结构体S中的x字段。比如，对于结构体struct foobar {int foo, int bar}，foobar.foo返回结构体中的foo字段
hive> create table str_table2 as select struct('tom','mary','tim') as t from tableName;
hive> describe tableName;
t       struct<col1:string ,col2:string,col3:string>
hive> select t.col1,t.col3 from str_table2;
tom     tim
```

### 复杂类型长度统计函数

Map类型长度函数: size(Map\<k .V\>)

```
语法: size(Map<k .V>)
返回值: int
说明: 返回map类型的长度
hive> select size(t) from map_table2;
2
```

array类型长度函数: size(Array)

```
语法: size(Array<T>)
返回值: int
说明: 返回array类型的长度
hive> select size(t) from arr_table2;
4
```

类型转换函数 \*\*\*

```
类型转换函数: cast
语法: cast(expr as <type>)
返回值: Expected "=" to follow "type"
说明: 返回转换后的数据类型
hive> select cast('1' as bigint) from tableName;
1
```

## hive当中的lateral view 与 explode以及reflect和窗口函数

### 使用explode函数将hive表中的Map和Array字段数据进行拆分

lateral view用于和split、explode等UDTF一起使用的，能将一行数据拆分成多行数据，在此基础上可以对拆分的数据进行聚合，lateral view首先为原始表的每行调用UDTF，UDTF会把一行拆分成一行或者多行，lateral view在把结果组合，产生一个支持别名表的虚拟表。

其中explode还可以用于将hive一列中复杂的array或者map结构拆分成多行

需求：现在有数据格式如下

```
zhangsan child1,child2,child3,child4 k1:v1,k2:v2

lisi child5,child6,child7,child8 k3:v3,k4:v4
```

字段之间使用\\t分割，需求将所有的child进行拆开成为一列

```
+----------+--+
| mychild  |
+----------+--+
| child1   |
| child2   |
| child3   |
| child4   |
| child5   |
| child6   |
| child7   |
| child8   |
+----------+--+
```

将map的key和value也进行拆开，成为如下结果

```
+-----------+-------------+--+
| mymapkey  | mymapvalue  |
+-----------+-------------+--+
| k1        | v1          |
| k2        | v2          |
| k3        | v3          |
| k4        | v4          |
+-----------+-------------+--+
```

创建hive数据库

```
创建hive数据库
hive (default)> create database hive_explode;
hive (default)> use hive_explode;
```

创建hive表，然后使用explode拆分map和array

```
hive (hive_explode)> create  table t3(name string,children array<string>,address Map<string,string>) row format delimited fields terminated by '\t'  collection items terminated by ',' map keys terminated by ':' stored as textFile;
```

加载数据

```
node03执行以下命令创建表数据文件
 mkdir -p /export/servers/hivedatas/
 cd /export/servers/hivedatas/
 vim maparray
内容如下:
zhangsan child1,child2,child3,child4 k1:v1,k2:v2
lisi child5,child6,child7,child8 k3:v3,k4:v4

hive表当中加载数据
hive (hive_explode)> load data local inpath '/export/servers/hivedatas/maparray' into table t3;
```

使用explode将hive当中数据拆开

```
将array当中的数据拆分开
hive (hive_explode)> SELECT explode(children) AS myChild FROM t3;

将map当中的数据拆分开

hive (hive_explode)> SELECT explode(address) AS (myMapKey, myMapValue) FROM t3;
```

### 使用explode拆分json字符串

需求：现在有一些数据格式如下：

```
a:shandong,b:beijing,c:hebei|1,2,3,4,5,6,7,8,9|[{"source":"7fresh","monthSales":4900,"userCount":1900,"score":"9.9"},{"source":"jd","monthSales":2090,"userCount":78981,"score":"9.8"},{"source":"jdmart","monthSales":6987,"userCount":1600,"score":"9.0"}]
```

其中字段与字段之间的分隔符是 \|

我们要解析得到所有的monthSales对应的值为以下这一列（行转列）

```
4900
2090
6987
```

创建hive表

```
hive (hive_explode)> create table explode_lateral_view
                   > (`area` string,
                   > `goods_id` string,
                   > `sale_info` string)
                   > ROW FORMAT DELIMITED
                   > FIELDS TERMINATED BY '|'
                   > STORED AS textfile;
```

准备数据并加载数据

```
准备数据如下
cd /export/servers/hivedatas
vim explode_json

a:shandong,b:beijing,c:hebei|1,2,3,4,5,6,7,8,9|[{"source":"7fresh","monthSales":4900,"userCount":1900,"score":"9.9"},{"source":"jd","monthSales":2090,"userCount":78981,"score":"9.8"},{"source":"jdmart","monthSales":6987,"userCount":1600,"score":"9.0"}]

加载数据到hive表当中去
hive (hive_explode)> load data local inpath '/export/servers/hivedatas/explode_json' overwrite into table explode_lateral_view;
```

使用explode拆分Array

```
hive (hive_explode)> select explode(split(goods_id,',')) as goods_id from explode_lateral_view;
```

使用explode拆解Map

1hive (hive_explode)\> select explode(split(area,',')) as area from explode_lateral_view;

拆解json字段

```
hive (hive_explode)> select explode(split(regexp_replace(regexp_replace(sale_info,'\\[\\{',''),'}]',''),'},\\{')) as  sale_info from explode_lateral_view;

然后我们想用get_json_object来获取key为monthSales的数据：

hive (hive_explode)> select get_json_object(explode(split(regexp_replace(regexp_replace(sale_info,'\\[\\{',''),'}]',''),'},\\{')),'$.monthSales') as  sale_info from explode_lateral_view;


然后挂了FAILED: SemanticException [Error 10081]: UDTF's are not supported outside the SELECT clause, nor nested in expressions
UDTF explode不能写在别的函数内
如果你这么写，想查两个字段，select explode(split(area,',')) as area,good_id from explode_lateral_view;
会报错FAILED: SemanticException 1:40 Only a single expression in the SELECT clause is supported with UDTF's. Error encountered near token 'good_id'
使用UDTF的时候，只支持一个字段，这时候就需要LATERAL VIEW出场了
```

### 配合LATERAL VIEW使用

配合lateral view查询多个字段

```
hive (hive_explode)> select goods_id2,sale_info from explode_lateral_view LATERAL VIEW explode(split(goods_id,','))goods as goods_id2;

其中LATERAL VIEW explode(split(goods_id,','))goods相当于一个虚拟表，与原表explode_lateral_view笛卡尔积关联
```

也可以多重使用

```
hive (hive_explode)> select goods_id2,sale_info,area2
                    from explode_lateral_view 
                    LATERAL VIEW explode(split(goods_id,','))goods as goods_id2 
                    LATERAL VIEW explode(split(area,','))area as area2;也是三个表笛卡尔积的结果
```

最终，我们可以通过下面的句子，把这个json格式的一行数据，完全转换成二维表的方式展现

```
hive (hive_explode)> select get_json_object(concat('{',sale_info_1,'}'),'$.source') as source,get_json_object(concat('{',sale_info_1,'}'),'$.monthSales') as monthSales,get_json_object(concat('{',sale_info_1,'}'),'$.userCount') as monthSales,get_json_object(concat('{',sale_info_1,'}'),'$.score') as monthSales from explode_lateral_view LATERAL VIEW explode(split(regexp_replace(regexp_replace(sale_info,'\\[\\{',''),'}]',''),'},\\{'))sale_info as sale_info_1;
```

**总结：**

**Lateral View通常和UDTF一起出现，为了解决UDTF不允许在select字段的问题。Multiple Lateral View可以实现类似笛卡尔乘积。Outer关键字可以把不输出的UDTF的空结果，输出成NULL，防止丢失数据。**

### 行转列

相关参数说明:

CONCAT(string A/col, string B/col…)：返回输入字符串连接后的结果，支持任意个输入字符串;

CONCAT_WS(separator, str1, str2,...)：它是一个特殊形式的 CONCAT()。第一个参数剩余参数间的分隔符。分隔符可以是与剩余参数一样的字符串。如果分隔符是 NULL，返回值也将为 NULL。这个函数会跳过分隔符参数后的任何 NULL 和空字符串。分隔符将被加到被连接的字符串之间;

COLLECT_SET(col)：函数只接受基本数据类型，它的主要作用是将某字段的值进行去重汇总，产生array类型字段。

数据准备:

| name   | constellation | blood_type |
|--------|---------------|------------|
| 孙悟空 | 白羊座        | A          |
| 老王   | 射手座        | A          |
| 宋宋   | 白羊座        | B          |
| 猪八戒 | 白羊座        | A          |
| 凤姐   | 射手座        | A          |

需求: 把星座和血型一样的人归类到一起。结果如下：

```
射手座,A            老王|凤姐
白羊座,A            孙悟空|猪八戒
白羊座,B            宋宋
```

实现步骤

创建本地constellation.txt，导入数据

```
node03服务器执行以下命令创建文件，注意数据使用\t进行分割
cd /export/servers/hivedatas
vim constellation.txt

数据如下: 
孙悟空 白羊座 A
老王 射手座 A
宋宋 白羊座 B       
猪八戒 白羊座 A
凤姐 射手座 A
```

创建hive表并导入数据

```
创建hive表并加载数据
hive (hive_explode)> create table person_info(
                    name string, 
                    constellation string, 
                    blood_type string) 
                    row format delimited fields terminated by "\t";
                    
加载数据
hive (hive_explode)> load data local inpath '/export/servers/hivedatas/constellation.txt' into table person_info;
```

按需求查询数据

```
hive (hive_explode)> select
                        t1.base,
                        concat_ws('|', collect_set(t1.name)) name
                    from
                        (select
                            name,
                            concat(constellation, "," , blood_type) base
                        from
                            person_info) t1
                    group by
                        t1.base;
```

### 列转行

所需函数:

EXPLODE(col)：将hive一列中复杂的array或者map结构拆分成多行。

LATERAL VIEW

用法：LATERAL VIEW udtf(expression) tableAlias AS columnAlias

解释：用于和split, explode等UDTF一起使用，它能够将一列数据拆成多行数据，在此基础上可以对拆分后的数据进行聚合。

数据准备:

```
cd /export/servers/hivedatas
vim movie.txt
文件内容如下:  数据字段之间使用\t进行分割
《疑犯追踪》 悬疑,动作,科幻,剧情
《Lie to me》 悬疑,警匪,动作,心理,剧情
《战狼2》 战争,动作,灾难
```

需求: 将电影分类中的数组数据展开。结果如下：

```
《疑犯追踪》 悬疑
《疑犯追踪》 动作
《疑犯追踪》 科幻
《疑犯追踪》 剧情
《Lie to me》 悬疑
《Lie to me》 警匪
《Lie to me》 动作
《Lie to me》 心理
《Lie to me》 剧情
《战狼2》 战争
《战狼2》 动作
《战狼2》 灾难
```

实现步骤:

创建hive表

```
create table movie_info(
    movie string, 
    category array<string>) 
row format delimited fields terminated by "\t"
collection items terminated by ",";
```

加载数据

```
load data local inpath "/export/servers/hivedatas/movie.txt" into table movie_info;
```

按需求查询数据

```
select
    movie,
    category_name
from 
    movie_info lateral view explode(category) table_tmp as category_name;
```

### reflect函数

reflect函数可以支持在sql中调用java中的自带函数，秒杀一切udf函数。

需求1: 使用java.lang.Math当中的Max求两列中最大值

实现步骤:

创建hive表

```
create table test_udf(col1 int,col2 int) row format delimited fields terminated by ',';
```

准备数据并加载数据

```
cd /export/servers/hivedatas
vim test_udf 

文件内容如下:
1,2
4,3
6,4
7,5
5,6
```

加载数据

```
hive (hive_explode)> load data local inpath '/export/servers/hivedatas/test_udf' overwrite into table test_udf;
```

使用java.lang.Math当中的Max求两列当中的最大值

```
hive (hive_explode)> select reflect("java.lang.Math","max",col1,col2) from test_udf;
```

需求2: 文件中不同的记录来执行不同的java的内置函数

实现步骤:

创建hive表

```
hive (hive_explode)> create table test_udf2(class_name string,method_name string,col1 int , col2 int) row format delimited fields terminated by ',';
```

准备数据

```
cd /export/servers/hivedatas
vim test_udf2

文件内容如下:
java.lang.Math,min,1,2
java.lang.Math,max,2,3
```

加载数据

```
hive (hive_explode)> load data local inpath '/export/servers/hivedatas/test_udf2' overwrite into table test_udf2;
```

执行查询

```
hive (hive_explode)> select reflect(class_name,method_name,col1,col2) from test_udf2;
```

需求3: 判断是否为数字

实现方式:

使用apache commons中的函数，commons下的jar已经包含在hadoop的classpath中，所以可以直接使用。

```
select reflect("org.apache.commons.lang.math.NumberUtils","isNumber","123")
```

## 窗口函数与分析函数

在sql中有一类函数叫做聚合函数,例如sum()、avg()、max()等等,这类函数可以将多行数据按照规则聚集为一行,一般来讲聚集后的行数是要少于聚集前的行数的。但是有时我们想要既显示聚集前的数据,又要显示聚集后的数据,这时我们便引入了窗口函数。窗口函数又叫OLAP函数/分析函数，窗口函数兼具分组和排序功能。

窗口函数最重要的关键字是 **partition by** 和 **order by。**

具体语法如下：**over (partition by xxx order by xxx)**

### sum、avg、min、max

准备数据

```
建表语句:
create table test_t1(
cookieid string,
createtime string,   --day 
pv int
) row format delimited 
fields terminated by ',';

加载数据：
load data local inpath '/root/hivedata/test_t1.dat' into table test_t1;

cookie1,2020-04-10,1
cookie1,2020-04-11,5
cookie1,2020-04-12,7
cookie1,2020-04-13,3
cookie1,2020-04-14,2
cookie1,2020-04-15,4
cookie1,2020-04-16,4

开启智能本地模式
SET hive.exec.mode.local.auto=true;
```

SUM函数和窗口函数的配合使用：结果和ORDER BY相关,默认为升序。

```
select cookieid,createtime,pv,
sum(pv) over(partition by cookieid order by createtime) as pv1 
from test_t1;

select cookieid,createtime,pv,
sum(pv) over(partition by cookieid order by createtime rows between unbounded preceding and current row) as pv2
from test_t1;

select cookieid,createtime,pv,
sum(pv) over(partition by cookieid) as pv3
from test_t1;

select cookieid,createtime,pv,
sum(pv) over(partition by cookieid order by createtime rows between 3 preceding and current row) as pv4
from test_t1;

select cookieid,createtime,pv,
sum(pv) over(partition by cookieid order by createtime rows between 3 preceding and 1 following) as pv5
from test_t1;

select cookieid,createtime,pv,
sum(pv) over(partition by cookieid order by createtime rows between current row and unbounded following) as pv6
from test_t1;


pv1: 分组内从起点到当前行的pv累积，如，11号的pv1=10号的pv+11号的pv, 12号=10号+11号+12号
pv2: 同pv1
pv3: 分组内(cookie1)所有的pv累加
pv4: 分组内当前行+往前3行，如，11号=10号+11号， 12号=10号+11号+12号，
                        13号=10号+11号+12号+13号， 14号=11号+12号+13号+14号
pv5: 分组内当前行+往前3行+往后1行，如，14号=11号+12号+13号+14号+15号=5+7+3+2+4=21
pv6: 分组内当前行+往后所有行，如，13号=13号+14号+15号+16号=3+2+4+4=13，
        14号=14号+15号+16号=2+4+4=10
```

如果不指定rows between,默认为从起点到当前行;

如果不指定order by，则将分组内所有值累加;

关键是理解rows between含义,也叫做window子句：

preceding：往前

following：往后

current row：当前行

unbounded：起点

unbounded preceding 表示从前面的起点

unbounded following：表示到后面的终点

AVG，MIN，MAX，和SUM用法一样。

### row_number、rank、dense_rank、ntile

准备数据

```
cookie1,2020-04-10,1
cookie1,2020-04-11,5
cookie1,2020-04-12,7
cookie1,2020-04-13,3
cookie1,2020-04-14,2
cookie1,2020-04-15,4
cookie1,2020-04-16,4
cookie2,2020-04-10,2
cookie2,2020-04-11,3
cookie2,2020-04-12,5
cookie2,2020-04-13,6
cookie2,2020-04-14,3
cookie2,2020-04-15,9
cookie2,2020-04-16,7
 
CREATE TABLE test_t2 (
cookieid string,
createtime string,   --day 
pv INT
) ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ',' 
stored as textfile;
  
加载数据：
load data local inpath '/root/hivedata/test_t2.dat' into table test_t2;
```

ROW_NUMBER()使用

ROW_NUMBER()从1开始，按照顺序，生成分组内记录的序列。

```
SELECT 
cookieid,
createtime,
pv,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY pv desc) AS rn 
FROM test_t2;
```

RANK 和 DENSE_RANK使用

RANK() 生成数据项在分组中的排名，排名相等会在名次中留下空位 。

DENSE_RANK()生成数据项在分组中的排名，排名相等会在名次中不会留下空位。

```
SELECT 
cookieid,
createtime,
pv,
RANK() OVER(PARTITION BY cookieid ORDER BY pv desc) AS rn1,
DENSE_RANK() OVER(PARTITION BY cookieid ORDER BY pv desc) AS rn2,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY pv DESC) AS rn3 
FROM test_t2 
WHERE cookieid = 'cookie1';
```

NTILE

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
FROM test_t2 
ORDER BY cookieid,createtime;
```

## 其他一些窗口函数

### lag,lead,first_value,last_value

LAG

**LAG(col,n,DEFAULT) 用于统计窗口内往上第n行值**第一个参数为列名，第二个参数为往上第n行（可选，默认为1），第三个参数为默认值（当往上第n行为NULL时候，取默认值，如不指定，则为NULL）

```
SELECT cookieid,
createtime,
url,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
LAG(createtime,1,'1970-01-01 00:00:00') OVER(PARTITION BY cookieid ORDER BY createtime) AS last_1_time,
LAG(createtime,2) OVER(PARTITION BY cookieid ORDER BY createtime) AS last_2_time 
FROM test_t4;


last_1_time: 指定了往上第1行的值，default为'1970-01-01 00:00:00'  
                 cookie1第一行，往上1行为NULL,因此取默认值 1970-01-01 00:00:00
                 cookie1第三行，往上1行值为第二行值，2015-04-10 10:00:02
                 cookie1第六行，往上1行值为第五行值，2015-04-10 10:50:01
last_2_time: 指定了往上第2行的值，为指定默认值
         cookie1第一行，往上2行为NULL
         cookie1第二行，往上2行为NULL
         cookie1第四行，往上2行为第二行值，2015-04-10 10:00:02
         cookie1第七行，往上2行为第五行值，2015-04-10 10:50:01
```

LEAD

与LAG相反**LEAD(col,n,DEFAULT) 用于统计窗口内往下第n行值**第一个参数为列名，第二个参数为往下第n行（可选，默认为1），第三个参数为默认值（当往下第n行为NULL时候，取默认值，如不指定，则为NULL）

```
SELECT cookieid,
createtime,
url,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
LEAD(createtime,1,'1970-01-01 00:00:00') OVER(PARTITION BY cookieid ORDER BY createtime) AS next_1_time,
LEAD(createtime,2) OVER(PARTITION BY cookieid ORDER BY createtime) AS next_2_time 
FROM test_t4;
```

FIRST_VALUE

取分组内排序后，截止到当前行，第一个值

```
SELECT cookieid,
 createtime,
 url,
 ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
 FIRST_VALUE(url) OVER(PARTITION BY cookieid ORDER BY createtime) AS first1 
 FROM test_t4;
```

LAST_VALUE

取分组内排序后，截止到当前行，最后一个值

```
SELECT cookieid,
createtime,
url,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
LAST_VALUE(url) OVER(PARTITION BY cookieid ORDER BY createtime) AS last1 
FROM test_t4;
```

如果想要取分组内排序后最后一个值，则需要变通一下：

```
SELECT cookieid,
createtime,
url,
ROW_NUMBER() OVER(PARTITION BY cookieid ORDER BY createtime) AS rn,
LAST_VALUE(url) OVER(PARTITION BY cookieid ORDER BY createtime) AS last1,
FIRST_VALUE(url) OVER(PARTITION BY cookieid ORDER BY createtime DESC) AS last2 
FROM test_t4 
ORDER BY cookieid,createtime;
```

**特别注意order by**

如果不指定ORDER BY，则进行排序混乱，会出现错误的结果

```
SELECT cookieid,
createtime,
url,
FIRST_VALUE(url) OVER(PARTITION BY cookieid) AS first2  
FROM test_t4;
```

### cume_dist,percent_rank

这两个序列分析函数不是很常用，**注意：序列函数不支持WINDOW子句**

数据准备

```
d1,user1,1000
d1,user2,2000
d1,user3,3000
d2,user4,4000
d2,user5,5000
 
CREATE EXTERNAL TABLE test_t3 (
dept STRING,
userid string,
sal INT
) ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ',' 
stored as textfile;

加载数据：
load data local inpath '/root/hivedata/test_t3.dat' into table test_t3;
```

CUME_DIST 和order byd的排序顺序有关系

CUME_DIST 小于等于当前值的行数/分组内总行数 order 默认顺序 正序 升序 比如，统计小于等于当前薪水的人数，所占总人数的比例

```
SELECT 
 dept,
 userid,
 sal,
 CUME_DIST() OVER(ORDER BY sal) AS rn1,
 CUME_DIST() OVER(PARTITION BY dept ORDER BY sal) AS rn2 
 FROM test_t3;
 
 rn1: 没有partition,所有数据均为1组，总行数为5，
      第一行：小于等于1000的行数为1，因此，1/5=0.2
      第三行：小于等于3000的行数为3，因此，3/5=0.6
 rn2: 按照部门分组，dpet=d1的行数为3,
      第二行：小于等于2000的行数为2，因此，2/3=0.6666666666666666
```

PERCENT_RANK

PERCENT_RANK 分组内当前行的RANK值-1/分组内总行数-1

经调研 该函数显示现实意义不明朗 有待于继续考证

```
SELECT 
  dept,
  userid,
  sal,
  PERCENT_RANK() OVER(ORDER BY sal) AS rn1,   --分组内
  RANK() OVER(ORDER BY sal) AS rn11,          --分组内RANK值
  SUM(1) OVER(PARTITION BY NULL) AS rn12,     --分组内总行数
  PERCENT_RANK() OVER(PARTITION BY dept ORDER BY sal) AS rn2 
  FROM test_t3;
  
  rn1: rn1 = (rn11-1) / (rn12-1) 
      第一行,(1-1)/(5-1)=0/4=0
      第二行,(2-1)/(5-1)=1/4=0.25
      第四行,(4-1)/(5-1)=3/4=0.75
  rn2: 按照dept分组，
       dept=d1的总行数为3
       第一行，(1-1)/(3-1)=0
       第三行，(3-1)/(3-1)=1
```

### grouping sets,grouping__id,cube,rollup

这几个分析函数通常用于OLAP中，不能累加，而且需要根据不同维度上钻和下钻的指标统计，比如，分小时、天、月的UV数。

数据准备

```
2020-03,2020-03-10,cookie1
2020-03,2020-03-10,cookie5
2020-03,2020-03-12,cookie7
2020-04,2020-04-12,cookie3
2020-04,2020-04-13,cookie2
2020-04,2020-04-13,cookie4
2020-04,2020-04-16,cookie4
2020-03,2020-03-10,cookie2
2020-03,2020-03-10,cookie3
2020-04,2020-04-12,cookie5
2020-04,2020-04-13,cookie6
2020-04,2020-04-15,cookie3
2020-04,2020-04-15,cookie2
2020-04,2020-04-16,cookie1
 
CREATE TABLE test_t5 (
month STRING,
day STRING, 
cookieid STRING 
) ROW FORMAT DELIMITED 
FIELDS TERMINATED BY ',' 
stored as textfile;

加载数据：
load data local inpath '/root/hivedata/test_t5.dat' into table test_t5;
```

GROUPING SETS

grouping sets是一种将多个group by 逻辑写在一个sql语句中的便利写法。

等价于将不同维度的GROUP BY结果集进行UNION ALL。

**GROUPING__ID**，表示结果属于哪一个分组集合。

```
SELECT 
month,
day,
COUNT(DISTINCT cookieid) AS uv,
GROUPING__ID 
FROM test_t5 
GROUP BY month,day 
GROUPING SETS (month,day) 
ORDER BY GROUPING__ID;

grouping_id表示这一组结果属于哪个分组集合，
根据grouping sets中的分组条件month，day，1是代表month，2是代表day

等价于 
SELECT month,NULL,COUNT(DISTINCT cookieid) AS uv,1 AS GROUPING__ID FROM test_t5 GROUP BY month UNION ALL 
SELECT NULL as month,day,COUNT(DISTINCT cookieid) AS uv,2 AS GROUPING__ID FROM test_t5 GROUP BY day;
```

再如：

```
SELECT 
month,
day,
COUNT(DISTINCT cookieid) AS uv,
GROUPING__ID 
FROM test_t5 
GROUP BY month,day 
GROUPING SETS (month,day,(month,day)) 
ORDER BY GROUPING__ID;

等价于
SELECT month,NULL,COUNT(DISTINCT cookieid) AS uv,1 AS GROUPING__ID FROM test_t5 GROUP BY month 
UNION ALL 
SELECT NULL,day,COUNT(DISTINCT cookieid) AS uv,2 AS GROUPING__ID FROM test_t5 GROUP BY day
UNION ALL 
SELECT month,day,COUNT(DISTINCT cookieid) AS uv,3 AS GROUPING__ID FROM test_t5 GROUP BY month,day;
```

CUBE

根据GROUP BY的维度的所有组合进行聚合。

```
SELECT 
month,
day,
COUNT(DISTINCT cookieid) AS uv,
GROUPING__ID 
FROM test_t5 
GROUP BY month,day 
WITH CUBE 
ORDER BY GROUPING__ID;

等价于
SELECT NULL,NULL,COUNT(DISTINCT cookieid) AS uv,0 AS GROUPING__ID FROM test_t5
UNION ALL 
SELECT month,NULL,COUNT(DISTINCT cookieid) AS uv,1 AS GROUPING__ID FROM test_t5 GROUP BY month 
UNION ALL 
SELECT NULL,day,COUNT(DISTINCT cookieid) AS uv,2 AS GROUPING__ID FROM test_t5 GROUP BY day
UNION ALL 
SELECT month,day,COUNT(DISTINCT cookieid) AS uv,3 AS GROUPING__ID FROM test_t5 GROUP BY month,day;
```

ROLLUP

是CUBE的子集，以最左侧的维度为主，从该维度进行层级聚合。

```
比如，以month维度进行层级聚合：
SELECT 
month,
day,
COUNT(DISTINCT cookieid) AS uv,
GROUPING__ID  
FROM test_t5 
GROUP BY month,day
WITH ROLLUP 
ORDER BY GROUPING__ID;

--把month和day调换顺序，则以day维度进行层级聚合：
 
SELECT 
day,
month,
COUNT(DISTINCT cookieid) AS uv,
GROUPING__ID  
FROM test_t5 
GROUP BY day,month 
WITH ROLLUP 
ORDER BY GROUPING__ID;
（这里，根据天和月进行聚合，和根据天聚合结果一样，因为有父子关系，如果是其他维度组合的话，就会不一样）
```
