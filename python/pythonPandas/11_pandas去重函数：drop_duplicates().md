“去重”通过字面意思不难理解，就是删除重复的数据。在一个数据集中，找出重复的数据删并将其删除，最终只保存一个唯一存在的数据项，这就是数据去重的整个过程。删除重复数据是数据分析中经常会遇到的一个问题。通过数据去重，不仅可以节省内存空间，提高写入性能，还可以提升数据集的精确度，使得数据集不受重复数据的影响。

Panda DataFrame 对象提供了一个数据去重的函数 drop_duplicates()，本节对该函数的用法做详细介绍。

### 函数格式

drop_duplicates()函数的语法格式如下：

```
df.drop_duplicates(subset=['A','B','C'],keep='first',inplace=True)
```

参数说明如下：

-   subset：表示要进去重的列名，默认为 None。
-   keep：有三个可选参数，分别是 first、last、False，默认为 first，表示只保留第一次出现的重复项，删除其余重复项，last 表示只保留最后一次出现的重复项，False 则表示删除所有重复项。
-   inplace：布尔值参数，默认为 False 表示删除重复项后返回一个副本，若为 Ture 则表示直接在原数据上删除重复项。

### 实际应用

首先创建一个包含有重复值的 DataFrame 对象，如下所示：

```
import pandas as pd
data={
   
    'A':[1,0,1,1],
    'B':[0,2,5,0],
    'C':[4,0,4,4],
    'D':[1,0,1,1]
}
df=pd.DataFrame(data=data)
print(df)
```

输出结果：

1 A B C D

20 1 0 4 1

31 0 2 0 0

42 1 5 4 1

53 1 0 4 1

#### 1) 默认保留第一次出现的重复项

```
import pandas as pd
data={
  
    'A':[1,0,1,1],
    'B':[0,2,5,0],
    'C':[4,0,4,4],
    'D':[1,0,1,1]
}
df=pd.DataFrame(data=data)
#默认保留第一次出现的重复项
df.drop_duplicates()
```

输出结果：

1 A B C D

20 1 0 4 1

31 0 2 0 0

42 1 5 4 1

#### 2) keep=False删除所有重复项

```
import pandas as pd
data={
    'A':[1,0,1,1],
    'B':[0,2,5,0],
    'C':[4,0,4,4],
    'D':[1,0,1,1]
}
df=pd.DataFrame(data=data)
#默认保留第一次出现的重复项
df.drop_duplicates(keep=False)
```

输出结果：

1 A B C D

21 0 2 0 0

32 1 5 4 1

#### 3) 根据指定列标签去重

```
import pandas as pd
data={
   
    'A':[1,3,3,3],
    'B':[0,1,2,0],
    'C':[4,5,4,4],
    'D':[3,3,3,3]
}
df=pd.DataFrame(data=data)
#去除所有重复项，对于B列来说两个0是重复项
df.drop_duplicates(subset=['B'],keep=False)
#简写，省去subset参数
#df.drop_duplicates(['B'],keep=False)
print(df)
```

输出结果：

1 A B C D

21 3 1 5 3

32 3 2 4 3

从上述示例可以看出，删除重复项后，行标签使用的数字是原来的，并没有从 0 重新开始，那么我们应该怎么从 0 重置索引呢？Pandas 提供的 reset_index() 函数会直接使用重置后的索引。如下所示：

```
import pandas as pd

data={
   
    'A':[1,3,3,3],
    'B':[0,1,2,0],
    'C':[4,5,4,4],
    'D':[3,3,3,3]
}
df=pd.DataFrame(data=data)
#去除所有重复项，对于B来说两个0是重复项
df=df.drop_duplicates(subset=['B'],keep=False)
#重置索引，从0重新开始
df.reset_index(drop=True)
```

输出结果：

1 A B C D

20 3 1 5 3

31 3 2 4 3

#### 4) 指定多列同时去重

创建一个 DataFrame 对象，如下所示：

```
import numpy as np
import pandas as pd
df = pd.DataFrame({'Country ID':[1,1,2,12,34,23,45,34,23,12,2,3,4,1],
                    'Age':[12,12,15,18, 19, 25, 21, 25, 25, 18, 25,12,32,18],
                   'Group ID':['a','z','c','a','b','s','d','a','b','s','a','d','a','f']})
#last只保留最后一个重复项
df.drop_duplicates(['Age','Group ID'],keep='last')
```

输出结果：

1 Country ID Age Group ID

20 1 12 a

31 1 12 z

42 2 15 c

53 3 18 a

64 4 19 b

75 3 25 s

86 4 21 d

98 2 25 b

109 1 18 s

1110 2 25 a

1211 3 12 d

1312 4 32 a

1413 1 18 f

上述数据集中，第 7 行、第 10 行对应的列标签数据相同，我们使用参数值“last”保留最后一个重复项，也就是第 10 行数据。
