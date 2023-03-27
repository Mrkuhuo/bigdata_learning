重置索引（reindex）可以更改原 DataFrame 的行标签或列标签，并使更改后的行、列标签与 DataFrame 中的数据逐一匹配。通过重置索引操作，您可以完成对现有数据的重新排序。如果重置的索引标签在原 DataFrame 中不存在，那么该标签对应的元素值将全部填充为 NaN。

### 重置行列标签

看一组简单示例：

```
import pandas as pd
import numpy as np
N=20
df = pd.DataFrame({
   'A': pd.date_range(start='2016-01-01',periods=N,freq='D'),
   'x': np.linspace(0,stop=N-1,num=N),
   'y': np.random.rand(N),
   'C': np.random.choice(['Low','Medium','High'],N).tolist(),
   'D': np.random.normal(100, 10, size=(N)).tolist()
})
#重置行、列索引标签
df_reindexed = df.reindex(index=[0,2,5], columns=['A', 'C', 'B'])
print(df_reindexed)
```

输出结果：

1 A C B

20 2020-12-07 Medium NaN

32 2020-12-09 Low NaN

45 2020-12-12 High NaN

现有 a、b 两个 DataFrame 对象，如果想让 a 的行索引与 b 相同，您可以使用 reindex_like() 方法。示例如下：

```
import pandas as pd
import numpy as np
a = pd.DataFrame(np.random.randn(10,3),columns=['col1','col2','col3'])
b = pd.DataFrame(np.random.randn(7,3),columns=['col1','col2','col3'])
a= a.reindex_like(b)
print(a)
```

输出结果：

1 col1 col2 col3

20 1.776556 -0.821724 -1.220195

31 -1.401443 0.317407 -0.663848

42 0.300353 -1.010991 0.939143

53 0.444041 -1.875384 0.846112

64 0.967159 0.369450 -0.414128

75 0.320863 -1.223477 -0.337110

86 -0.933665 0.909382 1.129481

上述示例，a 会按照 b 的形式重建行索引。需要特别注意的是，a 与 b 的列索引标签必须相同。

### 填充元素值

reindex_like() 提供了一个可选的参数method，使用它来填充相应的元素值，参数值介绍如下：

-   pad/ffill：向前填充值；
-   bfill/backfill：向后填充值；
-   nearest：从距离最近的索引值开始填充。

示例如下：

```
import pandas as pd
import numpy as np
df1 = pd.DataFrame(np.random.randn(6,3),columns=['col1','col2','col3'])
df2 = pd.DataFrame(np.random.randn(2,3),columns=['col1','col2','col3'])
#使df2和df1行标签相同
print(df2.reindex_like(df1))
#向前填充
print(df2.reindex_like(df1,method='ffill'))
```

输出结果：

1\#填充前

2 col1 col2 col3

30 0.129055 0.835440 0.383065

41 -0.357231 0.379293 1.211549

52 NaN NaN NaN

63 NaN NaN NaN

74 NaN NaN NaN

85 NaN NaN NaN

9\#填充后

10 col1 col2 col3

110 0.129055 0.835440 0.383065

121 -0.357231 0.379293 1.211549

132 -0.357231 0.379293 1.211549

143 -0.357231 0.379293 1.211549

154 -0.357231 0.379293 1.211549

165 -0.357231 0.379293 1.211549

### 限制填充行数

reindex_like() 还提供了一个额外参数 limit，该参数用来控制填充的最大行数。示例如下：

```
import pandas as pd
import numpy as np
df1 = pd.DataFrame(np.random.randn(6,3),columns=['col1','col2','col3'])
df2 = pd.DataFrame(np.random.randn(2,3),columns=['col1','col2','col3'])
print (df2.reindex_like(df1))
#最多填充2行
print (df2.reindex_like(df1,method='ffill',limit=2))
```

输出结果：

1 col1 col2 col3

20 -1.829469 0.310332 -2.008861

31 -1.038512 0.749333 -0.094335

42 NaN NaN NaN

53 NaN NaN NaN

64 NaN NaN NaN

75 NaN NaN NaN

8

9 col1 col2 col3

100 -1.829469 0.310332 -2.008861

111 -1.038512 0.749333 -0.094335

122 -1.038512 0.749333 -0.094335

133 -1.038512 0.749333 -0.094335

144 NaN NaN NaN

155 NaN NaN NaN

由上述示例可以看出，填充了 2、3 行 缺失值，也就是只填充了 2 行数据。

### 重命名标签

rename() 方法允许您使用某些映射(dict或Series)或任意函数来对行、列标签重新命名，示例如下：

```
import pandas as pd
import numpy as np
df1 = pd.DataFrame(np.random.randn(6,3),columns=['col1','col2','col3'])
print (df1)
#对行和列重新命名
print (df1.rename(columns={'col1' : 'c1', 'col2' : 'c2'},index = {0 : 'apple', 1 : 'banana', 2 : 'durian'}))
```

输出结果：

1 col1 col2 col3

20 -1.762133 -0.636819 -0.309572

31 -0.093965 -0.924387 -2.031457

42 -1.231485 -0.738667 1.415724

53 -0.826322 0.206574 -0.731701

64 1.863816 -0.175705 0.491907

75 0.677361 0.870041 -0.636518

8

9 c1 c2 col3

10apple -1.762133 -0.636819 -0.309572

11banana -0.093965 -0.924387 -2.031457

12durian -1.231485 -0.738667 1.415724

133 -0.826322 0.206574 -0.731701

144 1.863816 -0.175705 0.491907

155 0.677361 0.870041 -0.636518

rename() 方法提供了一个 inplace 参数，默认值为 False，表示拷贝一份原数据，并在复制后的数据上做重命名操作。若 inplace=True 则表示在原数据的基础上重命名。
