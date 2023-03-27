数据重采样是将时间序列从一个频率转换至另一个频率的过程，它主要有两种实现方式，分别是降采样和升采样，降采样指将高频率的数据转换为低频率，升采样则与其恰好相反，说明如下：

| 方法   | 说明                                       |
|--------|--------------------------------------------|
| 降采样 | 将高频率(间隔短)数据转换为低频率(间隔长)。 |
| 升采样 | 将低频率数据转换为高频率。                 |

Pandas 提供了 resample() 函数来实现数据的重采样。

### 降采样

通过 resample() 函数完成数据的降采样，比如按天计数的频率转换为按月计数。

```
import pandas as pd
import numpy as np
rng = pd.date_range('1/1/2021',periods=100,freq='D')
ts = pd.Series(np.random.randn(len(rng)),index=rng)
#降采样后并聚合
ts.resample('M').mean() 
```

输出结果：

12021-01-31 0.210353

22021-02-28 -0.058859

32021-03-31 -0.182952

42021-04-30 0.205254

5Freq: M, dtype: float64

如果您只想看到月份，那么您可以设置kind=period如下所示：

```
ts.resample('M',kind='period').mean()
```

输出结果：

12021-01 -0.153121

22021-02 0.136231

32021-03 -0.238975

42021-04 -0.309502

5Freq: M, dtype: float64

### 升采样

升采样是将低频率（时间间隔）转换为高频率，示例如下：

```
import pandas as pd
import numpy as np
#生成一份时间序列数据
rng = pd.date_range('1/1/2021', periods=20, freq='3D')
ts = pd.Series(np.random.randn(len(rng)), index=rng)
print(ts.head())
#使用asfreq()在原数据基础上实现频率转换
ts.resample('D').asfreq().head()
```

输出结果：

1升采样前：

22021-01-01 0.608716

32021-01-04 1.097451

42021-01-07 -1.280173

52021-01-10 -0.175065

62021-01-13 1.046831

7Freq: 3D, dtype: float64

8升采样后：

92021-01-01 0.608716

102021-01-02 NaN

112021-01-03 NaN

122021-01-04 1.097451

132021-01-05 NaN

14Freq: D, dtype: float64

### 频率转换

asfreq() 方法不仅能够实现频率转换，还可以保留原频率对应的数值，同时它也可以单独使用，示例如下：
```
index = pd.date_range('1/1/2021', periods=6, freq='T')
series = pd.Series([0.0, None, 2.0, 3.0,4.0,5.0], index=index)
df = pd.DataFrame({'s':series})
print(df.asfreq("45s"))
```

输出结果：

1 num

22021-01-01 00:00:00 0.0

32021-01-01 00:00:45 NaN

42021-01-01 00:01:30 NaN

52021-01-01 00:02:15 NaN

62021-01-01 00:03:00 3.0

72021-01-01 00:03:45 NaN

82021-01-01 00:04:30 NaN

### 插值处理

从上述示例不难看出，升采样的结果会产生缺失值，那么就需要对缺失值进行处理，一般有以下几种处理方式：

| 方法                   | 说明                           |
|------------------------|--------------------------------|
| pad/ffill              | 用前一个非缺失值去填充缺失值。 |
| backfill/bfill         | 用后一个非缺失值去填充缺失值。 |
| interpolater('linear') | 线性插值方法。                 |
| fillna(value)          | 指定一个值去替换缺失值。       |

下面使用插值方法处理 NaN 值，示例如下：

```
import pandas as pd
import numpy as np
#创建时间序列数据
rng = pd.date_range('1/1/2021', periods=20, freq='3D')
ts = pd.Series(np.random.randn(len(rng)), index=rng)
print(ts.resample('D').asfreq().head())
#使用ffill处理缺失值
ts.resample('D').asfreq().ffill().head()
```

输出结果：

12021-01-01 0.555580

22021-01-02 NaN

32021-01-03 NaN

42021-01-04 -0.079324

52021-01-05 NaN

6Freq: D, dtype: float64

7

8\#插值处理，注意对比

92021-01-01 0.555580

102021-01-02 0.555580

112021-01-03 0.555580

122021-01-04 -0.079324

132021-01-05 -0.079324

14Freq: D, dtype: float64
