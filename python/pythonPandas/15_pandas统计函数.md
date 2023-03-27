Pandas 的本质是统计学原理在计算机领域的一种应用实现，通过编程的方式达到分析、描述数据的目的。而统计函数则是统计学中用于计算和分析数据的一种工具。在数据分析的过程中，使用统计函数有助于我们理解和分析数据。本节将学习几个常见的统计函数，比如百分比函数、协方差函数、相关系数等。

### 百分比变化(pct_change)

Series 和 DatFrames 都可以使用 pct_change() 函数。该函数将每个元素与其前一个元素进行比较，并计算前后数值的百分比变化。示例如下：

```
import pandas as pd
import numpy as np
#Series结构
s = pd.Series([1,2,3,4,5,4])
print (s.pct_change())
#DataFrame
df = pd.DataFrame(np.random.randn(5, 2))
print(df.pct_change())
```

输出结果：

10 NaN

21 1.000000

32 0.500000

43 0.333333

54 0.250000

65 -0.200000

7dtype: float64

8 0 1

90 NaN NaN

101 74.779242 0.624260

112 -0.353652 -1.104352

123 -2.422813 -13.994103

134 -3.828316 -1.853092

默认情况下，pct_change() 对列进行操作，如果想要操作行，则需要传递参数 axis=1 参数。示例如下：

```
import pandas as pd
import numpy as np
#DataFrame
df = pd.DataFrame(np.random.randn(3, 2))
print(df.pct_change(axis=1))
```

输出结果：

1 0 1

20 NaN 3.035670

31 NaN -0.318259

42 NaN 0.227580

### 协方差(cov)

Series 对象提供了一个cov方法用来计算 Series 对象之间的协方差。同时，该方法也会将缺失值(NAN )自动排除。

示例如下：

```
import pandas as pd
import numpy as np
s1 = pd.Series(np.random.randn(10))
s2 = pd.Series(np.random.randn(10))
print (s1.cov(s2))
```

输出结果：

10.20789380904226645

当应用于 DataFrame 时，协方差（cov）将计算所有列之间的协方差。

```
import pandas as pd
import numpy as np
frame = pd.DataFrame(np.random.randn(10, 5), columns=['a', 'b', 'c', 'd', 'e'])
#计算a与b之间的协方差值
print (frame['a'].cov(frame['b']))
#计算所有数列的协方差值
print (frame.cov())
```

输出结果：

1-0.37822395480394827

2 a b c d e

3a 1.643529 -0.378224 0.181642 0.049969 -0.113700

4b -0.378224 1.561760 -0.054868 0.144664 -0.231134

5c 0.181642 -0.054868 0.628367 -0.125703 0.324442

6d 0.049969 0.144664 -0.125703 0.480301 -0.388879

7e -0.113700 -0.231134 0.324442 -0.388879 0.848377

### 相关系数(corr)

相关系数显示任意两个 Series 之间的线性关系。Pandas 提供了计算相关性的三种方法，分别是 pearson(default)、spearman() 和 kendall()。

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(10, 5), columns=['a', 'b', 'c', 'd', 'e'])
print (df['b'].corr(frame['c']))
print (df.corr())
```

输出结果：

10.5540831507407936

2 a b c d e

3a 1.000000 -0.500903 -0.058497 -0.767226 0.218416

4b -0.500903 1.000000 -0.091239 0.805388 -0.020172

5c -0.058497 -0.091239 1.000000 0.115905 0.083969

6d -0.767226 0.805388 0.115905 1.000000 0.015028

7e 0.218416 -0.020172 0.083969 0.015028 1.000000

注意：如果 DataFrame 存在非数值(NAN），该方法会自动将其删除。

### 排名(rank)

rank() 按照某种规则（升序或者降序）对序列中的元素值排名，该函数的返回值的也是一个序列，包含了原序列中每个元素值的名次。如果序列中包含两个相同的的元素值，那么会为其分配两者的平均排名。示例如下：

```
import pandas as pd
import numpy as np
#返回5个随机值，然后使用rank对其排名
s = pd.Series(np.random.randn(5), index=list('abcde'))
s['d'] = s['b']
print(s) 
#a/b排名分别为2和3，其平均排名为2.5
print(s.rank())
```

输出结果：

1a -0.689585

2b -0.545871

3c 0.148264

4d -0.545871

5e -0.205043

6dtype: float64

7

8排名后输出:

9a 1.0

10b 2.5

11c 5.0

12d 2.5

13e 4.0

14dtype: float64

#### 1) method参数

rank() 提供了 method 参数，可以针对相同数据，进行不同方式的排名。如下所示：

-   average：默认值，如果数据相同则分配平均排名；
-   min：给相同数据分配最低排名；
-   max：给相同数据分配最大排名；
-   first：对于相同数据，根据出现在数组中的顺序进行排名。

#### 2) aisx&ascening

rank() 有一个ascening参数， 默认为 True 代表升序；如果为 False，则表示降序排名（将较大的数值分配给较小的排名）。

rank() 默认按行方向排名（axis=0），也可以更改为 axis =1，按列排名。示例如下：

```
import pandas as pd
import numpy as np
a = pd.DataFrame(np.arange(12).reshape(3,4),columns = list("abdc"))
a =a.sort_index(axis=1,ascending=False)
a.iloc[[1,1],[1,2]] = 6
#按行排名，将相同数值设置为所在行数值的最大排名
print(a.rank(axis=1,method="max"))
```

输出结果：

1 d c b a

20 3.0 4.0 2.0 1.0

31 4.0 4.0 4.0 1.0

42 3.0 4.0 2.0 1.0

与 method="min"进行对比，如下所示：

```
import pandas as pd
import numpy as np
a = pd.DataFrame(np.arange(12).reshape(3,4),columns = list("abdc"))
a =a.sort_index(axis=1,ascending=False)
a.iloc[[1,1],[1,2]] = 6
#按行排名，将相同数值设置为所在行数值的最小排名
print(a.rank(axis=1,method="min"))
```

输出结果：

1 d c b a

20 3.0 4.0 2.0 1.0

31 2.0 2.0 2.0 1.0

42 3.0 4.0 2.0 1.0