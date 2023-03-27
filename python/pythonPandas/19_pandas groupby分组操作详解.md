在数据分析中，经常会遇到这样的情况：根据某一列（或多列）标签把数据划分为不同的组别，然后再对其进行数据分析。比如，某网站对注册用户的性别或者年龄等进行分组，从而研究出网站用户的画像（特点）。在 Pandas 中，要完成数据的分组操作，需要使用 groupby() 函数，它和 SQL 的GROUP BY操作非常相似。

在划分出来的组（group）上应用一些统计函数，从而达到数据分析的目的，比如对分组数据进行聚合、转换，或者过滤。这个过程主要包含以下三步：

-   拆分（Spliting）：表示对数据进行分组；
-   应用（Applying）：对分组数据应用聚合函数，进行相应计算；
-   合并（Combining）：最后汇总计算结果。

下面对 groupby() 函数的应用过程进行具体的讲解。

### 创建DataFrame对象

首先我们创建一个 DataFrame 对象，下面数据描述了某班学生，计算机选修课的考试成绩：

```
import pandas as pd 
import numpy as np 
data = {'Name': ['John', 'Helen', 'Sona', 'Ella'], 
   'score': [82, 98, 91, 87], 
   'option_course': ['C#','Python','Java','C']} 
df = pd.DataFrame(data)
print(df)  
```

输出结果：

1 Name score option_course

20 John 82 C\#

31 Helen 98 Python

42 Sona 91 Java

53 Ella 87 C

### 创建groupby分组对象

使用 groupby() 可以沿着任意轴分组。您可以把分组时指定的键（key）作为每组的组名，方法如下所示：

-   df.groupby("key")
-   df.groupby("key",axis=1)
-   df.groupby(["key1","key2"])

通过上述方法对 DataFrame 对象进行分组操作：

```
import pandas as pd
import numpy as np
data = {'Name': ['John', 'Helen', 'Sona', 'Ella'],
   'score': [82, 98, 91, 87],
   'option_course': ['C#','Python','Java','C']}
df = pd.DataFrame(data)
print(df)
#生成分组groupby对象
print(df.groupby('score'))
```

输出结果：

1\<pandas.core.groupby.generic.DataFrameGroupBy object at 0x0000021DE9A89640\>

### 查看分组结果

#### 1) groups查看分组结果

通过调用groups属性查看分组结果：

```
import pandas as pd
import numpy as np
data = {'Name': ['John', 'Helen', 'Sona', 'Ella'],
   'score': [82, 98, 91, 87],
   'option_course': ['C#','Python','Java','C']}
df = pd.DataFrame(data)
#查看分组
print(df.groupby('score').groups)
```

输出结果：

1{82: Int64Index([0], dtype='int64'),

287: Int64Index([3], dtype='int64'),

391: Int64Index([2], dtype='int64'),

498: Int64Index([1], dtype='int64')}

#### 2) 多个列标签分组

当然也可以指定多个列标签进行分组，示例如下：

```
import pandas as pd
import numpy as np
data = {'Name': ['John', 'Helen', 'Sona', 'Ella'],
   'score': [82, 98, 91, 87],
   'option_course': ['C#','Python','Java','C']}
df = pd.DataFrame(data)
#查看分组
print(df.groupby(['Name','score']).groups)
```

输出结果：

1{('Ella', 87): Int64Index([3], dtype='int64'),

2('Helen', 98): Int64Index([1], dtype='int64'),

3('John', 82): Int64Index([0], dtype='int64'),

4('Sona', 91): Int64Index([2], dtype='int64')}

通过 get_group() 方法可以选择组内的具体数据项：

```
import pandas as pd
import numpy as np
data = {'Name': ['John', 'Helen', 'Sona', 'Ella'],
   'score': [82, 98, 91, 87],
   'option_course': ['C#','Python','Java','C']}
df = pd.DataFrame(data)
#根据score来分组
grouped=df.groupby('score')
#根据对应组的数据值，选择一个组
print(grouped.get_group(91))
```

输出结果：

1 Name score option_course

22 Sona 91 Java

### 遍历分组数据

通过以下方法来遍历分组数据，示例如下：

```
import pandas as pd
import numpy as np
data = {'Name': ['John', 'Helen', 'Sona', 'Ella'],
   'score': [82, 98, 91, 87],
   'option_course': ['C#','Python','Java','C']}
df = pd.DataFrame(data)
#查看分组
grouped=df.groupby('score')
for label, option_course in grouped:
#其中key代表分组后字典的键，也就是score
    print(label)
#字典对应的值选修的科目
    print(option_course)
```

输出结果：

182

2 Name score option_course

30 John 82 C\#

487

5 Name score option_course

63 Ella 87 C

791

8 Name score option_course

92 Sona 91 Java

1098

11 Name score option_course

121 Helen 98 Python

如上所示， groupby 对象的组名称与 score 中的的元素值一一对应。

### 应用聚合函数

当您在创建 groupby 对象时，通过 agg() 函数可以对分组对象应用多个聚合函数：

```
import pandas as pd 
import numpy as np 
data = {'name': ['John', 'Helen', 'Sona', 'Ella'], 
   'score': [82, 98, 91, 87], 
   'option_course': ['C#','Python','Java','C']} 
df = pd.DataFrame(data)
grouped=df.groupby('name')
#应用一个聚合函数求均值
print(grouped['score']).agg(np.mean)
```

输出结果：

1name

2Ella 87

3Helen 98

4John 82

5Sona 91

6Name: score, dtype: int64

当然，您也可以一次性应有多个聚合函数，示例如下：

```
import pandas as pd
import numpy as np
data = {'name': ['John', 'Helen', 'Sona', 'Ella'],
   'score': [82, 98, 91, 87],
   'option_course': ['C#','Python','Java','C']}
df = pd.DataFrame(data)
grouped=df.groupby('name')
print(grouped['score'].agg([np.size,np.mean,np.std]))
```

输出结果：

1 size mean std

2name

3Ella 1 87 NaN

4Helen 1 98 NaN

5John 1 82 NaN

6Sona 1 91 NaN

### 组的转换操作

在组的行或列上可以执行转换操作，最终会返回一个与组大小相同的索引对象。示例如下：

```
import pandas as pd
import numpy as np
df = pd.DataFrame({'种类':['水果','水果','水果','蔬菜','蔬菜','肉类','肉类'],
                '产地':['朝鲜','中国','缅甸','中国','菲律宾','韩国','中国'],
                '水果':['橘子','苹果','哈密瓜','番茄','椰子','鱼肉','牛肉'],
                '数量':[3,5,5,3,2,15,9],
                '价格':[2,5,12,3,4,18,20]})
#分组求均值，水果、蔬菜、肉类
#对可执行计算的数值列求均值
print(df.groupby('种类').transform(np.mean))
#transform()直接应用demean，实现去均值操作
demean = lambda arr:arr-arr.mean()
print(df.groupby('种类').transform(demean))
#自定义函数
# 返回分组的前n行数据
def get_rows(df,n): 
     #从1到n行的所有列
    return df.iloc[:n,:]
#分组后的组名作为行索引
print(df.groupby('种类').apply(get_rows,n=1))
```

输出结果：

1 数量 价格

20 4.333333 6.333333

31 4.333333 6.333333

42 4.333333 6.333333

53 2.500000 3.500000

64 2.500000 3.500000

75 12.000000 19.000000

86 12.000000 19.000000

9

10 数量 价格

110 -1.333333 -4.333333

121 0.666667 -1.333333

132 0.666667 5.666667

143 0.500000 -0.500000

154 -0.500000 0.500000

165 3.000000 -1.000000

176 -3.000000 1.000000

18

19 种类 产地 水果 数量 价格

20种类

21水果 0 水果 朝鲜 橘子 3 2

22肉类 5 肉类 韩国 鱼肉 15 18

23蔬菜 3 蔬菜 中国 番茄 3 3

### 组的数据过滤操作

通过 filter() 函数可以实现数据的筛选，该函数根据定义的条件过滤数据并返回一个新的数据集。

下面，筛选出参加比赛超过两次的球队（包含两次）：

```
import pandas as pd
import numpy as np
data = {'Team': ['Riders', 'Riders', 'Devils', 'Devils', 'Kings',
   'kings', 'Kings', 'Kings', 'Riders', 'Royals', 'Royals', 'Riders'],
   'Rank': [1, 2, 2, 3, 3,4 ,1 ,1,2 , 4,1,2],
   'Year': [2014,2015,2014,2015,2014,2015,2016,2017,2016,2014,2015,2017],
   'Points':[874,789,863,663,741,802,756,788,694,701,812,698]}
df = pd.DataFrame(data)
#定义lambda函数来筛选数据
print (df.groupby('Team').filter(lambda x: len(x) >= 2))
```

输出结果：

1 Team Rank Year Points

20 Riders 1 2014 874

31 Riders 2 2015 789

44 Kings 3 2014 741

56 Kings 1 2016 756

67 Kings 1 2017 788

78 Riders 2 2016 694

811 Riders 2 2017 698
