分层索引（Multiple Index）是 Pandas 中非常重要的索引类型，它指的是在一个轴上拥有多个（即两个以上）索引层数，这使得我们可以用低维度的结构来处理更高维的数据。比如，当想要处理三维及以上的高维数据时，就需要用到分层索引。

分层索引的目的是用低维度的结构（Series 或者 DataFrame）更好地处理高维数据。通过分层索引，我们可以像处理二维数据一样，处理三维及以上的数据。分层索引的存在使得分析高维数据变得简单，让抽象的高维数据变得容易理解，同时它比废弃的 Panel 结构更容易使用。

Pandas 可以通过 MultiIndex() 方法来创建分层索引对象，该对象本质上是一个元组序列，序列中每一个元组都是唯一的。下面介绍几种创建分层索引的方式。

### 创建分层索引

#### 1) 直接创建

通过 MultiIndex() 的levels参数能够直接创建分层索引，示例如下：

```
import pandas as pd 
import numpy as np 
#为leves传递一个1行5列的二维数组
df=pd.MultiIndex(levels=[[np.nan, 2, pd.NaT, None, 5]], codes=[[4, -1, 1, 2, 3, 4]]) 
print(df.levels)
print(df)
```

输出结果：

1[[nan, 2, NaT, None, 5]]

2

3MultiIndex([( 5,),

4 (nan,),

5 ( 2,),

6 (nan,),

7 (nan,),

8 ( 5,)],

9 )

上述代码中，levels参数用来创建层级索引，这里只有一层，该层的索引值分别是 np.nan, 2, NaT, None, 5；codes表示按参数值对层级索引值排序（与 levels 中的值相对应），也就说 codes 中数值是 leves 序列的下标索引。需要注意，这里的 -1 代表 NaN。

#### 2) 从元组创建

通过 from_tuples() 实现从元组创建分层索引。

```
#创建元组序列
arrays = [['it', 'it', 'of', 'of', 'for', 'for', 'then', 'then'], 
['one', 'two', 'one', 'two', 'one', 'two', 'one', 'two']] 
#使用zip()函数创建元组
tuples = list(zip(*arrays)) 
print(tuples)
```

输出结果如下：

1[('it', 'one'),

2('it', 'two'),

3('of', 'one'),

4('of', 'two'),

5('for', 'one'),

6('for', 'two'),

7('then', 'one'),

8('then', 'two')]

然后使用 tuples 创建分层索引，如下所示：

```
纯文本复制
import pandas as pd#创建了两层索引，并使用names对它们命名 index = pd.MultiIndex.from_tuples(tuples, names=['first', 'second'])print(index)
```

输出结果：

1MultiIndex([( 'it', 'one'),

2 ( 'it', 'two'),

3 ( 'of', 'one'),

4 ( 'of', 'two'),

5 ( 'for', 'one'),

6 ( 'for', 'two'),

7 ('then', 'one'),

8 ('then', 'two')],

9 names=['first', 'second'])

#### 3) 从DataFrame对象创建

通过 from_frame() 创建分层索引，示例如下：

```
#首先创建一个 DataFrame。
import pandas as pd
df = pd.DataFrame([['bar', 'one'], ['bar', 'two'],
                   ['foo', 'one'], ['foo', 'two']],
                  columns=['first', 'second'])
#然后使用 from_frame()创建分层索引。
index = pd.MultiIndex.from_frame(df)
#将index应用于Series
s=pd.Series(np.random.randn(4), index=index)
print(s)
```

输出结果：

1first second

2bar one 1.151928

3 two -0.694435

4foo one -1.701611

5 two -0.486157

6dtype: float64

#### 4) 笛卡尔积创建

笛卡尔积（又称直积）是数学运算的一种方式，下面使用 from_product() 笛卡尔积创建分层索引。

```
import pandas as pd
#构建数据
numbers = [0, 1, 2]
language = ['Python', 'Java']
#经过笛卡尔积处理后会得到6中组合方式
index = pd.MultiIndex.from_product([numbers, language],names=['number', 'language'])
#将分层索引对象应用于Series
dk_er=pd.Series(np.random.randn(6), index=index)
print(dk_er)
```

输出结果：

1number language

20 Python -0.319739

3 Java 1.599170

41 Python -0.010520

5 Java 0.262068

62 Python -0.124177

7 Java 0.315120

8dtype: float64

#### 5) 数组创建分层索引

通过 from_array() 方法，同样可以创建分层索引。示例如下：

```
import pandas as pd
df=pd.MultiIndex.from_arrays([['a', 'a', 'b', 'b'],[1, 2, 1, 2]])
df
```

输出结果：

1MultiIndex([('a', 1),

2 ('a', 2),

3 ('b', 1),

4 ('b', 2)],

5 )

### 应用分层索引

下面示例讲解了如何在 DataFrame 中应用分层索引。

```
import pandas as pd 
import numpy as np
#创建一个数组
arrays = [[0, 0, 1, 1], ['A', 'B', 'A', 'B']]
#从数组创建
index=pd.MultiIndex.from_arrays(arrays, names=('number', 'letter'))
print(index)
```

输出结果

1MultiIndex([(0, 'A'),

2 (0, 'B'),

3 (1, 'A'),

4 (1, 'B')],

5 names=['number', 'letter'])

上述示例中，第一层为 number，该层有 0、1 两个元素，第二层为 letter，有两个字母 A 和 B。

下面把已经创建的分层索引应用到 DataFrame 中，如下所示：

```
import pandas as pd 
import numpy as np
#创建一个数组
arrays = [[0, 0, 1, 1], ['A', 'B', 'A', 'B']]
index=pd.MultiIndex.from_arrays(arrays, names=('number', 'letter'))
#在行索引位置应用分层索引
df=pd.DataFrame([{'a':11, 'b':22}], index=index)
print(df)
```

输出结果：

1 a b

2number letter

30 A 11 22

4 B 11 22

51 A 11 22

6 B 11 22

#### 通过 set_index() 可以将 DataFrame 的已有列的标索设置为 index 行索引，示例如下：

```
import pandas as pd
df= pd.DataFrame({'a': range(5), 'b': range(5, 0, -1),
                  'c': ['one', 'one', 'one', 'two', 'two'],
                  'd': [0, 1, 2, 0, 1]})
print(df)
df1=df.set_index(['a','d'],drop=False)
print(df1)
df1=df.set_index(['a','d'],drop=False,append=Ture)
print(df2)
```

输出结果：

1转换前：

2 a b c d

30 0 5 one 0

41 1 4 one 1

52 2 3 one 2

63 3 2 two 0

74 4 1 two 1

8转换后：

9 a b c d

10a d

110 0 0 5 one 0

121 1 1 4 one 1

132 2 2 3 one 2

143 0 3 2 two 0

154 1 4 1 two 1

16带append参数：

17 a b c d

18 a d

190 0 0 0 5 one 0

201 1 1 1 4 one 1

212 2 2 2 3 one 2

223 3 0 3 2 two 0

234 4 1 4 1 two 1

通过 set_index() 将列索引转换为了分层行索引，其中 drop=False 表示更新索引的同时，不删除 a、d 列；同时，该函数还提供了一个 append = Ture 参数表示不添加默认的整数索引值（0到4）

### 分层索引切片取值

下面讲解分层索引切片取值操作，示例如下：

#### 1) 分层行索引操作

```
import pandas as pd
#构建多层索引
tuple = [('湖人',2008),('步行者',2008),
      ('湖人',2007),('凯尔特人',2007),
   ('篮网',2007),('热火',2008)]
salary = [10000,20000,11000,30000,19000,22000]
#其次应用于DataFrame
index = pd.MultiIndex.from_tuples(tuple)
s = pd.Series(salary, index=index)
print(s)
#切片取值
print(s['湖人',2007])
print(s['湖人'])
print(s[:,2008])
#比较value
print(s[s<=20000])
```

输出结果：

1湖人 2008 10000

2步行者 2008 20000

3湖人 2007 11000

4凯尔特人 2007 30000

5篮网 2007 19000

6热火 2008 22000

7dtype: int64

8

9湖人队2007年工资：

1011000

11

12湖人队的工资：

132008 10000

142007 11000

15dtype: int64

16

172008年所有队伍工资：

18湖人 10000

19步行者 20000

20热火 22000

21dtype: int64

22

23小于等于20000的年份和队伍：

24湖人 2008 10000

25步行者 2008 20000

26湖人 2007 11000

27篮网 2007 19000

28dtype: int64

#### 2) 行、列多层索引操作

下面看一种更加复杂的情况，就是行、列同时存在多层索引时候，应该如何通过切片取值。示例如下：

```
df = pd.DataFrame(np.arange(1,13).reshape((4, 3)),
               index=[['a', 'a', 'b', 'b'], [1, 2, 1, 2]],
               columns=[['Jack', 'Jack', 'Helen'],
              ['Python', 'Java', 'Python']])
#选择同一层级的索引,切记不要写成['Jack','Helen']
print(df[['Jack','Helen']])
#在不同层级分别选择索引
print(df['Jack','Python'])
#iloc整数索引
print(df.iloc[:3,:2])
#loc列标签索引
print(df.loc[:,('Helen','Python')])
```

输出结果：

1 Jack Helen

2 Python Java Python

3a 1 1 2 3

4 2 4 5 6

5b 1 7 8 9

6 2 10 11 12

7

8a 1 1

9 2 4

10b 1 7

11 2 10

12Name: (Jack, Python), dtype: int32

13

14 Jack

15 Python Java

16a 1 1 2

17 2 4 5

18b 1 7 8

19

20a 1 3

21 2 6

22b 1 9

23 2 12

24Name: (Helen, Python), dtype: int32

### 聚合函数应用

通过给level传递参数值，您可以指定在哪个层上进行聚合操作，比如求和、求均值等。示例如下：

```
import pandas as pd 
df = pd.DataFrame(np.arange(1,13).reshape((4, 3)),
               index=[['a', 'a', 'b', 'b'], [1, 2, 1, 2]],
               columns=[['Jack', 'Jack', 'Helen'],
              ['Python', 'Java', 'Python']])
#第一步，给行列层级起名字
df.index.names=['key1','key2']
df.columns.names=['name','course']
print(df.sum(level='key2'))
print(df.mean(level="course",axis=1))
```

输出结果：

1\#对key2层1/2对应的元素值求和

2name Jack Helen

3course Python Java Python

4key2

51 8 10 12

62 14 16 18

7

8\#axis=1沿着水平方向求均值

9course Python Java

10key1 key2

11a 1 2 2

12 2 5 5

13b 1 8 8

14 2 11 11

在数据分析的过程中，我们把大部分时间都花费在数据的准备和预处理上，Pandas 作为一个灵活、高效的数据预处理工具，提供了诸多数据处理的方法，分层索引（Multiple Index）就是其中之一，分层索引（或多层索引）是 Pandas 的基本特性，它能够增强 Pands 数据预处理的能力。

对于 Series 结构来说，通过给index参数传递一个二维数组就可以创建一个具有两层索引的 MultiIndex 对象，示例如下：

```
import pandas as pd 
info = pd.Series([11, 14, 17, 24, 19, 32, 34, 27],
index = [['x', 'x', 'x', 'x', 'y', 'y', 'y', 'y'],
['obj1', 'obj2', 'obj3', 'obj4', 'obj1', 'obj2', 'obj3', 'obj4']]) 
print(info)
```

输出结果：

1x obj1 11

2 obj2 14

3 obj3 17

4 obj4 24

5y obj1 19

6 obj2 32

7 obj3 34

8 obj4 27

9dtype: int64

上述示例，创建了两个层级的索引，即 (x, y) 和 (obj1，…， obj4)，您可以使用 'index' 命令查看索引。

```
info.index
```

输出结果：

1MultiIndex([('x', 'obj1'),

2 ('x', 'obj2'),

3 ('x', 'obj3'),

4 ('x', 'obj4'),

5 ('y', 'obj1'),

6 ('y', 'obj2'),

7 ('y', 'obj3'),

8 ('y', 'obj4')],

9 )

此外，您还可以基于内部索引层（也就是'obj'）来选择数据。如下所示：

```
info [:,'obj2' ]
```

输出结果：

1x 14

2y 32

3dtype: int64

### 局部索引

局部索引可以理解为：从分层索引中选择特定索引层的一种方法。比如在下列数据中，选择所有'y'索引指定的数据，示例如下：

```
import pandas as pd 
info = pd.Series([11, 14, 17, 24, 19, 32, 34, 27], 
index = [['x', 'x', 'x', 'x', 'y', 'y', 'y', 'y'], 
['obj1', 'obj2', 'obj3', 'obj4', 'obj1', 'obj2', 'obj3', 'obj4']]) 
info['y']
```

输出结果：

1obj1 19

2obj2 32

3obj3 34

4obj4 27

5dtype: int64

当然您也可以基于内层索引选择数据。

### 行索引层转换为列索引

unstack() 用来将行索引转变成列索引，相当于转置操作。通过 unstack() 可以将 Series（一维序列）转变为 DataFrame（二维序列）。示例如下：

```
import pandas as pd 
info = pd.Series([11, 14, 17, 24, 19, 32, 34, 27], 
index = [['x', 'x', 'x', 'x', 'y', 'y', 'y', 'y'], 
['obj1', 'obj2', 'obj3', 'obj4', 'obj1', 'obj2', 'obj3', 'obj4']]) 
#行索引标签默认是最外层的 x, y
#0代表第一层索引，而1代表第二层
print(info.unstack(0))
```

输出结果：

1 x y

2obj1 11 19

3obj2 14 32

4obj3 17 34

5obj4 24 27

从示例可以看出，unstack(0) 表示选择第一层索引作为列，unstack(1) 表示选择第二层，如下所示：

```
import pandas as pd 
info = pd.Series([11, 14, 17, 24, 19, 32, 34, 27], 
index = [['x', 'x', 'x', 'x', 'y', 'y', 'y', 'y'], 
['obj1', 'obj2', 'obj3', 'obj4', 'obj1', 'obj2', 'obj3', 'obj4']]) 
print(info.unstack(1))
```

输出结果：

1 obj1 obj2 obj3 obj4

2x 11 14 17 24

3y 19 32 34 27

### 列索引实现分层

我们知道，列索引存在于 DataFrame 结构中，下面创建一个 DataFrame 来演示列索引如何实现分层。

```
import numpy as np  
info = pd.DataFrame(np.arange(12).reshape(4, 3), 
index = [['a', 'a', 'b', 'b'], ['one', 'two', 'three', 'four']],  
columns = [['num1', 'num2', 'num3'], ['x', 'y', 'x']] )  
print(info)
```

输出结果：

1 num1 num2 num3

2 x y x

3a one 0 1 2

4 two 3 4 5

5b three 6 7 8

6 four 9 10 11

查看所有列索引：

```
info.columns
```

输出结果：

1MultiIndex([('num1', 'x'),

2 ('num2', 'y'),

3 ('num3', 'x')],)

### 交换层和层排序

#### 1) 交换层

通过 swaplevel() 方法轻松地实现索引层交换，示例如下：

```
import pandas as pd
frame = pd.DataFrame(np.arange(12).reshape((4, 3)),
                  index=[['a', 'a', 'b', 'b'], [1, 2, 1, 2]],
                  columns=[['Ohio', 'Ohio', 'Colorado'],
                           ['Green', 'Red', 'Green']])
#设置index的levels名称                         
frame.index.names = ['key1', 'key2']
#设置columns的levels名称
frame.columns.names = ['state','color']
#交换key1层与key层
frame.swaplevel('key1','key2')
```

输出结果：

1state Ohio Colorado

2color Green Red Green

3key2 key1

41 a 0 1 2

52 a 3 4 5

61 b 6 7 8

72 b 9 10 11

#### 2) 层排序

通过 sort_index() 的level参数实现对层的排序。下面示例，按“key1”的字母顺序重新排序。

import pandas as pd
frame = pd.DataFrame(np.arange(12).reshape((4, 3)),
index=[['a', 'a', 'b', 'b'], [1, 2, 1, 2]],
columns=[['Ohio', 'Ohio', 'Colorado'],
['Green', 'Red', 'Green']])
#设置index的levels的名称，key1 与 key2分别对应不同的层                         
frame.index.names = ['key1', 'key2']
#设置columns的levels的名称
frame.columns.names = ['state','color']
print(frame.sort_index(level='key1'))

输出结果：

1state Ohio Colorado

2color Green Red Green

3key1 key2

4a 1 0 1 2

5 2 3 4 5

6b 1 6 7 8

7 2 9 10 11
