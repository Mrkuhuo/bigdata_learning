通常情况下，数据集中会存在许多同一类别的信息，比如相同国家、相同行政编码、相同性别等，当这些相同类别的数据多次出现时，就会给数据处理增添许多麻烦，导致数据集变得臃肿，不能直观、清晰地展示数据。

针对上述问题，Pandas 提供了分类对象（Categorical Object），该对象能够实现有序排列、自动去重的功能，但是它不能执行运算。本节，我们了解一下分类对象的使用。

### 对象创建

我们可以通过多种方式创建分类对象，下面介绍以下两种方法：

#### 1) 指定dtype创建

```
import pandas as pd
s = pd.Series(["a","b","c","a"], dtype="category")
print(s)
```

输出结果：

10 a

21 b

32 c

43 a

5dtype: category

6Categories (3, object): [a, b, c]

通过上述示例，您可能会注意到，虽然传递给 Series 四个元素值，但是它的类别为 3，这是因为 a 的类别存在重复。

#### 2) pd.Categorical

通过 Category 的构造函数，您可以创建一个类别对象。构造函数，如下所示：

```
pandas.Categorical(values, categories, ordered)
```

values：以列表的形式传参，表示要分类的值。  
ordered：布尔值，默认为 False，若为 Ture，表示对分类的数据进行排序。  
dtype：返回一个 category 类型，表示分类对象。

示例如下：

```
import pandas as pd
#自动按a、b、c分类
cat = pd.Categorical(['a', 'b', 'c', 'a', 'b', 'c'])
print(cat)
```

输出结果：

1[a, b, c, a, b, c]

2Categories (3, object): [a, b, c]

再看一组示例：

```
import pandas as pd
cat=pd.Categorical(['a','b','c','a','b','c','d'], ['c', 'b', 'a'])
print(cat)
```

输出结果：

1[a, b, c, a, b, c, NaN]

2Categories (3, object): [c, b, a]

上述示例中，第二个参数值表示类别，当列表中不存在某一类别时，会自动将类别值设置为 NA。

通过指定ordered=True来实现有序分类。示例如下：

```
import pandas as pd
cat=pd.Categorical(['a','b','c','a','b','c','d'], ['c', 'b', 'a'],ordered=True)
print(cat)
#求最小值
print(cat.min())
```

输出结果：

1[a, b, c, a, b, c, NaN]

2Categories (3, object): [c \< b \< a]

3c

### 获取统计信息

对已经分类的数据使用 describe() 方法，您会得到和数据统计相关的摘要信息。

```
import pandas as pd
import numpy as np
cat = pd.Categorical(["a", "c", "c", np.nan], categories=["b", "a", "c"])
df = pd.DataFrame({"cat":cat, "s":["a", "c", "c", np.nan]})
print(df.describe())
print(df["cat"].describe())
```

输出结果：

1 cat s

2count 3 3

3unique 2 2

4top c c

5freq 2 2

6

7count 3

8unique 2

9top c

10freq 2

11Name: cat, dtype: object

### 获取类别属性

使用obj.categories命令可以获取对象的类别信息。示例如下：

```
import pandas as pd
import numpy as np
s = pd.Categorical(["a", "c", "c", np.nan], categories=["b", "a", "c"])
print (s.categories)
```

输出结果：

Index(['b', 'a', 'c'], dtype='object')

通过 obj.order 可以获取 order 指定的布尔值：

```
import pandas as pd
import numpy as np
cat = pd.Categorical(["a", "c", "c", np.nan], categories=["b", "a", "c"])
#False表示未指定排序
print (cat.ordered)
```

输出结果：

1False

### 重命名类别

要想对类别实现重命名，可以通过 Series.cat.categories 来实现的，示例如下：

```
import pandas as pd
s = pd.Series(["a","b","c","a"], dtype="category")
#对类名重命名
s.cat.categories = ["Group %s" % g for g in s.cat.categories]
print(s.cat.categories)
```

输出结果：

1Index(['Group a', 'Group b', 'Group c'], dtype='object')

### 追加新类别

使用 s.cat.add_categories() 方法，可以追加新类别。

```
import pandas as pd
s = pd.Series(["a","b","c","a"], dtype="category")
#追加新类别
s = s.cat.add_categories([5])
#查看现有类别
print(s.cat.categories)
```

输出结果：

1Index(['a', 'b', 'c', 5], dtype='object')

### 删除类别

使用 remove_categories() 方法，可以删除不需要的类别。示例如下：

```
import pandas as pd
s = pd.Series(["a","b","c","a"], dtype="category")
#原序列
print(s)
#删除后序列
print(s.cat.remove_categories("a"))
```

输出结果

10 a

21 b

32 c

43 a

5dtype: category

6Categories (3, object): [a, b, c]

7

80 NaN

91 b

102 c

113 NaN

12dtype: category

13Categories (2, object): [b, c]

### 分类对象比较

在下述两种情况下，我们可以对分类对象进行比较：

-   当两个类别对象长度相同时，可以进行比较运算；
-   当两个类别的 ordered 均等于 True，并且类别相同时，可以进行比较运算，比如 ==，！=，\>，\>=，\< 和 \<=。

示例如下：

```
import pandas as pd
s1=['a','a','b','d','c']
#当满足两个类别长度相同时
ss0=pd.Categorical(s1,categories=['a','d','b','c'])
ss1 = pd.Categorical(s1)
print(ss0==ss1)
```

输出结果：

1array([ True, True, True, True, True])

示例如下：

```
import pandas as pd
s1=['a','a','b','d','c']
s2=['a','b','b','d','c']
#满足上述第二个条件，类别相同，并且ordered均为True
ss0=pd.Categorical(s1,categories=['a','d','b','c'],ordered=True)
ss1 = pd.Categorical(s2,categories=['a','d','b','c'],ordered=True)
print(ss0<ss1)
```
输出结果：

1array([False, True, False, False, False])
