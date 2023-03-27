在一些数据分析业务中，数据缺失是我们经常遇见的问题，缺失值会导致数据质量的下降，从而影响模型预测的准确性，这对于机器学习和数据挖掘影响尤为严重。因此妥善的处理缺失值能够使模型预测更为准确和有效。

### 为什么会存在缺失值？

前面章节的示例中，我们遇到过很多 NaN 值，关于缺失值您可能会有很多疑问，数据为什么会丢失数据呢，又是从什么时候丢失的呢？通过下面场景，您会得到答案。

其实在很多时候，人们往往不愿意过多透露自己的信息。假如您正在对用户的产品体验做调查，在这个过程中您会发现，一些用户很乐意分享自己使用产品的体验，但他是不愿意透露自己的姓名和联系方式；还有一些用户愿意分享他们使用产品的全部经过，包括自己的姓名和联系方式。因此，总有一些数据会因为某些不可抗力的因素丢失，这种情况在现实生活中会经常遇到。

### 什么是稀疏数据？

稀疏数据，指的是在数据库或者数据集中存在大量缺失数据或者空值，我们把这样的数据集称为稀疏数据集。稀疏数据不是无效数据，只不过是信息不全而已，只要通过适当的方法就可以“变废为宝”。

稀疏数据的来源与产生原因有很多种，大致归为以下几种：

-   由于调查不当产生的稀疏数据；
-   由于天然限制产生的稀疏数据；
-   文本挖掘中产生的稀疏数据。

### 缺失值处理

那么 Pandas 是如何处理缺失值的呢，下面让我们一起看一下。

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 3), index=['a', 'c', 'e', 'f','h'])
df = df.reindex(['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'])
print(df)
```

输出结果：

1 0 1 2

2a 0.187208 -0.951407 0.316340

3b NaN NaN NaN

4c -0.365741 -1.983977 -1.052170

5d NaN NaN NaN

6e -1.024180 1.550515 0.317156

7f -0.799921 -0.686590 1.383229

8g NaN NaN NaN

9h -0.207958 0.426733 -0.325951

上述示例，通过使用 reindex（重构索引），我们创建了一个存在缺少值的 DataFrame 对象。

### 检查缺失值

为了使检测缺失值变得更容易，Pandas 提供了 isnull() 和 notnull() 两个函数，它们同时适用于 Series 和 DataFrame 对象。

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 3), index=['a', 'c', 'e', 'f','h'])
df = df.reindex(['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'])
print(df['noe'].isnull())
```

输出结果：

1a False

2b True

3c False

4d True

5e False

6f False

7g True

8h False

9Name: 1, dtype: bool

notnull() 函数，使用示例：

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 3), index=['a', 'c', 'e', 'f','h'])
df = df.reindex(['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'])
print df['one'].notnull()
```

输出结果：

1a True

2b False

3c True

4d False

5e True

6f True

7g False

8h True

9Name: 1, dtype: bool

### 缺失数据计算

计算缺失数据时，需要注意两点：首先数据求和时，将 NA 值视为 0 ，其次，如果要计算的数据为 NA，那么结果就是 NA。示例如下：

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 3), index=['a', 'c', 'e', 'f','h'],columns=['one', 'two', 'three'])
df = df.reindex(['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'])
print (df['one'].sum())
print()
```

输出结果：

13.4516595395128

### 清理并填充缺失值

Pandas 提供了多种方法来清除缺失值。fillna() 函数可以实现用非空数据“填充”NaN 值。

#### 1) 用标量值替换NaN值

下列程序将 NaN 值 替换为了 0，如下所示：

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(3, 3), index=['a', 'c', 'e'],columns=['one',
'two', 'three'])
df = df.reindex(['a', 'b', 'c'])
print(df)
#用 0 填充 NaN
print (df.fillna(0))
```

输出结果：

1 one two three

2a 1.497185 -0.703897 -0.050513

3b NaN NaN NaN

4c 2.008315 1.342690 -0.255855

5

6 one two three

7a 1.497185 -0.703897 -0.050513

8b 0.000000 0.000000 0.000000

9c 2.008315 1.342690 -0.255855

当然根据您自己的需求，您也可以用其他值进行填充。

#### 2) 向前和向后填充NA

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 3), index=['a', 'c', 'e', 'f','h'],columns=['one', 'two', 'three'])
df = df.reindex(['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'])
print df.fillna(method='ffill')
```

输出结果：

1 one two three

2a 0.871741 0.311057 0.091005

3b 0.871741 0.311057 0.091005

4c 0.107345 -0.662864 0.826716

5d 0.107345 -0.662864 0.826716

6e 1.630221 0.482504 -0.728767

7f 1.283206 -0.145178 0.109155

8g 1.283206 -0.145178 0.109155

9h 0.222176 0.886768 0.347820

或者您也可以采用向后填充的方法。

#### 3) 使用replace替换通用值

在某些情况下，您需要使用 replace() 将 DataFrame 中的通用值替换成特定值，这和使用 fillna() 函数替换 NaN 值是类似的。示例如下：

```
import pandas as pd
import numpy as np
df = pd.DataFrame({'one':[10,20,30,40,50,666], 'two':[99,0,30,40,50,60]})
#使用replace()方法
print (df.replace({99:10,666:60,0:20}))
```

### 删除缺失值

如果想删除缺失值，那么使用 dropna() 函数与参数 axis 可以实现。在默认情况下，按照 axis=0 来按行处理，这意味着如果某一行中存在 NaN 值将会删除整行数据。示例如下：

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 3), index=['a', 'c', 'e', 'f','h'],columns=['one', 'two', 'three'])
df = df.reindex(['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'])
print(df)
#删除缺失值
print (df.dropna())
```

输出结果：

1 one two three

2a -2.025435 0.617616 0.862096

3b NaN NaN NaN

4c -1.710705 1.780539 -2.313227

5d NaN NaN NaN

6e -2.347188 -0.498857 -1.070605

7f -0.159588 1.205773 -0.046752

8g NaN NaN NaN

9h -0.549372 -1.740350 0.444356

10

11 one two three

12a -2.025435 0.617616 0.862096

13c -1.710705 1.780539 -2.313227

14e -2.347188 -0.498857 -1.070605

15f -0.159588 1.205773 -0.046752

16h -0.549372 -1.740350 0.444356

axis = 1 表示按列处理，处理结果是一个空的 DataFrame 对象。
