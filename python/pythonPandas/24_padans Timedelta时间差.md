Timedelta 表示时间差（或者时间增量），我们可以使用不同的时间单位来表示它，比如，天、小时、分、秒。时间差的最终的结果可以是正时间差，也可以是负时间差。

本节主要介绍创建 Timedelta （时间差）的方法以及与时间差相关的运算法则。

### 字符串

通过传递字符串可以创建 Timedelta 对象，示例如下：

```
import pandas as pd
print(pd.Timedelta('5 days 8 hours 6 minutes 59 seconds'))
```

输出结果：

15 days 08:06:59

### 整数

通过传递整数值和unit参数也可以创建一个 Timedelta 对象。

```
import pandas as pd
print(pd.Timedelta(19,unit='h'))
```

输出结果：

10 days 19:00:00

### 数据偏移量

数据偏移量， 比如，周(weeks)、天(days)、小时(hours)、分钟(minutes)、秒(milliseconds)、毫秒、微秒、纳秒都可以使用。

```
import pandas as pd
print (pd.Timedelta(days=2,hours=6))
```

输出结果：

12 days 06:00:00

### to_timedelta()

您可以使用pd.to_timedelta()方法，将具有 timedelta 格式的值 (标量、数组、列表或 Series）转换为 Timedelta 类型。如果输入是 Series，则返回 Series；如果输入是标量，则返回值也为标量，其他情况输出 TimedeltaIndex。示例如下：

```
import pandas as pd
print(pd.to_timedelta(['1 days 06:05:01.00003', '15.5us', 'nan']))
print(pd.to_timedelta(np.arange(5), unit='s'))
```

输出结果：

1TimedeltaIndex(['1 days 06:05:01.000030', '0 days 00:00:00.000015', NaT],dtype='timedelta64[ns]', freq=None)

2

3TimedeltaIndex(['0 days 00:00:00', '0 days 00:00:01', '0 days 00:00:02','0 days 00:00:03',

4'0 days 00:00:04'],dtype='timedelta64[ns]', freq=None)

### 算术操作

通过对datetime64[ns]类型的时间序列或时间戳做算术运算，其运算结果依然是datetime64[ns]数据类型。接下来，我们创建一个带有 Timedelta 与 datetime 的 DataFrame 对象，并对其做一些算术运算。

```
import pandas as pd
s = pd.Series(pd.date_range('2020-1-1', periods=5, freq='D'))
#推导式用法
td = pd.Series([ pd.Timedelta(days=i) for i in range(5)])
df = pd.DataFrame(dict(A = s, B = td))
print(df)
```

输出结果：

1 A B

20 2020-01-01 0 days

31 2020-01-02 1 days

42 2020-01-03 2 days

53 2020-01-04 3 days

64 2020-01-05 4 days

### 加法运算

```
import pandas as pd
s = pd.Series(pd.date_range('20120-1-1', periods=3, freq='D'))
td = pd.Series([ pd.Timedelta(days=i) for i in range(3) ])
df = pd.DataFrame(dict(A = s, B = td))
#加法运算
df['C']=df['A']+df['B']
print(df)
```

输出结果：

1 A B C

20 2020-01-01 0 days 2020-01-01

31 2020-01-02 1 days 2020-01-03

42 2020-01-03 2 days 2020-01-05

### 减法运算

```
import pandas as pd
s = pd.Series(pd.date_range('2012-1-1', periods=3, freq='D'))
td = pd.Series([ pd.Timedelta(days=i) for i in range(3) ])
df = pd.DataFrame(dict(A = s, B = td))
df['C']=df['A']+df['B']
df['D']=df['C']-df['B']
print(df)
```

输出结果：

1 A B C D

20 2019-01-01 0 days 2019-01-01 2019-01-01

31 2019-01-02 1 days 2019-01-03 2019-01-02

42 2019-01-03 2 days 2019-01-05 2019-01-03
