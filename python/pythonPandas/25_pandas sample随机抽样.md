随机抽样，是统计学中常用的一种方法，它可以帮助我们从大量的数据中快速地构建出一组数据分析模型。在 Pandas 中，如果想要对数据集进行随机抽样，需要使用 sample() 函数。

sample() 函数的语法格式如下：

1DataFrame.sample(n=None, frac=None, replace=False, weights=None, random_state=None, axis=None)

参数说明如下表所示：

| 参数名称     | 参数说明                                                                               |
|--------------|----------------------------------------------------------------------------------------|
| n            | 表示要抽取的行数。                                                                     |
| frac         | 表示抽取的比例，比如 frac=0.5，代表抽取总体数据的50%。                                 |
| replace      | 布尔值参数，表示是否以有放回抽样的方式进行选择，默认为 False，取出数据后不再放回。     |
| weights      | 可选参数，代表每个样本的权重值，参数值是字符串或者数组。                               |
| random_state | 可选参数，控制随机状态，默认为 None，表示随机数据不会重复；若为 1 表示会取得重复数据。 |
| axis         | 表示在哪个方向上抽取数据(axis=1 表示列/axis=0 表示行)。                                |

该函数返回与数据集类型相同的新对象，相当于 numpy.random.choice()。实例如下：

```
import pandas as pd  
dict = {'name':["Jack", "Tom", "Helen", "John"],'age': [28, 39, 34, 36],'score':[98,92,91,89]} 
info = pd.DataFrame(dict)
#默认随机选择两行
info.sample(n=2)
#随机选择两列
info.sample(n=2,axis=1)
```

输出结果：

1 name age score

23 John 36 89

30 Jack 28 98

4

5 score name

60 98 Jack

71 92 Tom

82 91 Helen

93 89 John

再来看一组示例：

```
import pandas as pd
info = pd.DataFrame({'data1': [2, 6, 8, 0], 'data2': [2, 5, 0, 8], 'data3': [12, 2, 1, 8]}, index=['John', 'Parker', 'Smith', 'William'])
info
#随机抽取3个数据
info['data1'].sample(n=3)
#总体的50%
info.sample(frac=0.5, replace=True)
#data3序列为权重值，并且允许重复数据出现
info.sample(n=2, weights='data3', random_state=1)
```

输出结果：

1随机选择3行数据：

2William 0

3Smith 8

4Parker 6

5Name: data1, dtype: int64

6

7 data1 data2 data3

8John 2 2 12

9William 0 8 8

10

11 data1 data2 data3

12John 2 2 12

13William 0 8 8
