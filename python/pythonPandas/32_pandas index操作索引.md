索引（index）是 Pandas 的重要工具，通过索引可以从 DataFame 中选择特定的行数和列数，这种选择数据的方式称为“子集选择”。

在 Pandas 中，索引值也被称为标签（label），它在 Jupyter 笔记本中以粗体字进行显示。索引可以加快数据访问的速度，它就好比数据的书签，通过它可以实现数据的快速查找。

## 创建索引

通过示例对 index 索引做进一步讲解。下面创建一个带有 index 索引的数据，并使用 read_csv() 这些读取数据：

```
import pandas as pd    
data = pd.read_csv("person.csv") 
print(data)
```

输出结果：

1 ID Name Age City Salary

20 1 Jack 28 Beijing 22000

31 2 Lida 32 Shanghai 19000

42 3 John 43 Shenzhen 12000

53 4 Helen 38 Hengshui 3500

通过列索引（标签）读取多列数据。

```
import pandas as pd  
#设置"Name"为行索引    
data = pd.read_csv("person.csv", index_col ="Name")   
# 通过列标签选取多列数据  
a = data[["City","Salary"]]
print(a)
```

输出结果：

1 City Salary

2Name

3Jack Beijing 22000

4Lida Shanghai 19000

5John Shenzhen 12000

6Helen Hengshui 3500

再看一组简单的示例：

```
import pandas as pd  
info =pd.read_csv("person.csv", index_col ="Name")
#获取单列数据，或者以列表的形式传入["Salary"] 
a =info["Salary"] 
print(a)
```

输出结果：

1 Salary

2Name

3Jack 22000

4Lida 19000

5John 12000

6Helen 3500

## 设置索引

set_index() 将已存在的列标签设置为 DataFrame 行索引。除了可以添加索引外，也可以替换已经存在的索引。比如您也可以把 Series 或者一个 DataFrme 设置成另一个 DataFrame 的索引。示例如下：

```
info = pd.DataFrame({'Name': ['Parker', 'Terry', 'Smith', 'William'],  'Year': [2011, 2009, 2014, 2010], 
'Leaves': [10, 15, 9, 4]})
#设置Name为行索引
print(info.set_index('Name'))
```

输出结果：

1 Year Leaves

2Name

3Parker 2011 10

4Terry 2009 15

5Smith 2014 9

6William 2010 4

## 重置索引

您可以使用 reset_index() 来恢复初始行索引，示例如下：

```
import pandas as pd
import numpy as np
info = pd.DataFrame([('William', 'C'), 
('Smith', 'Java'), 
('Parker', 'Python'), 
('Phill', np.nan)], 
index=[1, 2, 3, 4], 
columns=('name', 'Language')) 
print(info)
print(info.reset_index())
```

输出结果：

1重置前：

2 name Language

31 William C

42 Smith Java

53 Parker Python

64 Phill NaN

7重置后：

8 index name Language

90 1 William C

101 2 Smith Java

112 3 Parker Python

123 4 Phill NaN
