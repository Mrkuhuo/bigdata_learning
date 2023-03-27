当使用 Pandas 做数据分析的时，需要读取事先准备好的数据集，这是做数据分析的第一步。Panda 提供了多种读取数据的方法：

-   read_csv() 用于读取文本文件
-   read_json() 用于读取 json 文件
-   read_sql_query() 读取 sql 语句的，

本节将对上述方法做详细介绍。

### CSV文件读取

CSV 又称逗号分隔值文件，是一种简单的文件格式，以特定的结构来排列表格数据。 CSV 文件能够以纯文本形式存储表格数据，比如电子表格、数据库文件，并具有数据交换的通用格式。CSV 文件会在 Excel 文件中被打开，其行和列都定义了标准的数据格式。

将 CSV 中的数据转换为 DataFrame 对象是非常便捷的。和一般文件读写不一样，它不需要你做打开文件、读取文件、关闭文件等操作。相反，您只需要一行代码就可以完成上述所有步骤，并将数据存储在 DataFrame 中。

下面进行实例演示，首先您需要创建一组数据，并将其保存为 CSV 格式，数据如下：

```
Name,Hire Date,Salary,Leaves Remaining 
John Idle,08/15/14,50000.00,10 
Smith Gilliam,04/07/15,65000.00,6 
Parker Chapman,02/21/14,45000.00,7 
Jones Palin,10/14/13,70000.00,3 
Terry Gilliam,07/22/14,48000.00,9 
Michael Palin,06/28/13,66000.00,8  
```

注意：将上述数据保存到.txt的文本文件中，然后将文件的扩展名后缀修改为 csv，即可完成 csv 文件的创建。

接下来，我们使用下列代码读写数据：

```
import pandas 
#仅仅一行代码就完成了数据读取，但是注意文件路径不要写错
df = pandas.read_csv('C:/Users/Administrator/Desktop/hrd.csv') 
print(df)  
```

输出结果：

1 Name Hire Date Salary Leaves Remaining

20 John Idle 08/15/14 50000.0 10

31 Smith Gilliam 04/07/15 65000.0 6

42 Parker Chapman 02/21/14 45000.0 7

53 Jones Palin 10/14/13 70000.0 3

64 Terry Gilliam 07/22/14 48000.0 9

75 Michael Palin 06/28/13 66000.0 8

在下一节会对 read_csv() 函数做详细讲解。

### json读取文件

您可以通过下列方法来读取一个 json 文件，如下所示：

```
import pandas as pd 
data = pd.read_json('C:/Users/Administrator/Desktop/hrd.json')  
print(data)  
```

输出结果：

1 Name Hire Date Salary Leaves Remaining

20 John Idle 08/15/14 50000.0 10

31 Smith Gilliam 04/07/15 65000.0 6

42 Parker Chapman 02/21/14 45000.0 7

53 Jones Palin 10/14/13 70000.0 3

64 Terry Gilliam 07/22/14 48000.0 9

75 Michael Palin 06/28/13 66000.0 8

### SQL数据库读取

如果想要从 SQL 数据库读取数据，首先您应该使用 Python 和数据库建立连接，然后将查询语句传递给 read_sql_query() 方法，下面做简单地演示：

#### 1) 安装pysqlite3模块

```
pip install pysqlite3
```

#### 2) 建立数据连接

```
import sqlite3 
con = sqlite3.connect("database.db")  
```

#### 3) 数据库读取数据

在 SQLite 数据库中创建一张信息表，您可以随意添加一些信息，最后使用下列方法读取数据即可：

```
#con参数指定操作数据库的引擎，可以指定，也可默认
df = pd.read_sql_query("SELECT * FROM information",con)  
```
