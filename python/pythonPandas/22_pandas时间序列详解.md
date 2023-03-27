顾名思义，时间序列（time series），就是由时间构成的序列，它指的是在一定时间内按照时间顺序测量的某个变量的取值序列，比如一天内的温度会随时间而发生变化，或者股票的价格会随着时间不断的波动，这里用到的一系列时间，就可以看做时间序列。时间序列包含三种应用场景，分别是：

-   特定的时刻（timestamp），也就是时间戳；
-   固定的日期（period），比如某年某月某日；
-   时间间隔（interval），每隔一段时间具有规律性；

在处理时间序列的过程中，我们一般会遇到两个问题，第一，如何创建时间序列；第二，如何更改已生成时间序列的频率。 Pandas 为解决上述问题提供了一套简单、易用的方法。

下面用 Python 内置的 datetime 模块来获取当前时间，通过该模块提供的now()方法即可实现。

```
from datetime import datetime
#数据类型为datetime
print(datetime.now())
```

输出结果：

12020-12-16 16:36:18.791297

### 创建时间戳

TimeStamp（时间戳） 是时间序列中的最基本的数据类型，它将数值与时间点完美结合在一起。Pandas 使用下列方法创建时间戳：

```
import pandas as pd
print (pd.Timestamp('2017-03-01'))
```

输出结果：

2017-03-01 00:00:00

同样，可以将整型或浮点型表示的时间转换为时间戳。默认的单位是纳秒(时间戳单位)，示例如下：

```
import pandas as pd
print(pd.Timestamp(1587687255,unit='s'))
```

输出结果：

12022-03-19 14:26:39

### 创建时间范围

通过 date_range() 方法可以创建某段连续的时间或者固定间隔的时间时间段。该函数提供了三个参数，分别是：

-   start：开始时间
-   end：结束时间
-   freq：时间频率，默认为 "D"（天）

示例如下：

```
import pandas as pd
#freq表示时间频率，每30min变化一次
print(pd.date_range("9:00", "18:10", freq="30min").time)
```

输出结果：

1[datetime.time(9, 0) datetime.time(9, 30) datetime.time(10, 0)

2datetime.time(10, 30) datetime.time(11, 0) datetime.time(11, 30)

3datetime.time(12, 0) datetime.time(12, 30) datetime.time(13, 0)

4datetime.time(13, 30) datetime.time(14, 0) datetime.time(14, 30)

5datetime.time(15, 0) datetime.time(15, 30) datetime.time(16, 0)

6datetime.time(16, 30) datetime.time(17, 0) datetime.time(17, 30)

7datetime.time(18, 0)]

### 更改时间频率

```
import pandas as pd
#修改为按小时
print(pd.date_range("6:10", "11:45", freq="H").time)
```

输出结果：

1[datetime.time(6, 10) datetime.time(7, 10) datetime.time(8, 10)

2datetime.time(9, 10) datetime.time(10, 10) datetime.time(11, 10)]

### 转化为时间戳

您可以使用 to_datetime() 函数将 series 或 list 转换为日期对象，其中 list 会转换为DatetimeIndex。示例如下：

```
import pandas as pd
print(pd.to_datetime(pd.Series(['Jun 3, 2020','2020-12-10', None])))
```

输出结果：

10

22020-06-031

32020-12-10

42 NaT

5dtype: datetime64[ns]

注意：NaT 表示的不是时间 ，它等效于 NaN。

最后再来看一个示例：

```
import pandas as pd
#传入list，生成Datetimeindex
print(pd.to_datetime(['Jun 31, 2020','2020-12-10', None]))
```

输出结果：

1DatetimeIndex(['2020-06-03', '2020-12-10', 'NaT'], dtype='datetime64[ns]', freq=None)

### 频率和周期转换

Time Periods 表示时间跨度，一段时间周期，它被定义在 Pandas Periods 类中，通过该类提供的方法可以实现将频率转换为周期。比如 Periods() 方法，可以将频率 "M"（月）转换为 Period（时间段）。

下面示例，使用 asfreq() 和 start 参数，打印 "01" ，若使用 end 参数，则打印 "31"。示例如下：

```
import pandas as pd 
x = pd.Period('2014', freq='M')
#start参数
x.asfreq('D', 'start')
#end参数
x.asfreq('D', 'end')
```

输出结果:

1Period('2014-01-01', 'D')

2Period('2014-01-31', 'D')

对于常用的时间序列频率，Pandas 为其规定了一些字符串别名，我们将这些别名称为“offset（偏移量）”。如下表所示：

| 别名 | 描述             | 别名  | 描述             |
|------|------------------|-------|------------------|
| B    | 工作日频率       | BQS   | 工作季度开始频率 |
| D    | 日历日频率       | A     | 年终频率         |
| W    | 每周频率         | BA    | 工作年度结束频率 |
| M    | 月末频率         | BAS   | 工作年度开始频率 |
| SM   | 半月结束频率     | BH    | 营业时间频率     |
| BM   | 工作月结束频率   | H     | 小时频率         |
| MS   | 月开始频率       | T,min | 每分钟频率       |
| SMS  | 半月开始频率     | S     | 每秒钟频率       |
| BMS  | 工作月开始频率   | L,ms  | 毫秒             |
| Q    | 季末频率         | U,us  | 微妙             |
| BQ   | 工作季度结束频率 | N     | 纳秒             |
| QS   | 季度开始频率     |       |                  |

### 时间周期计算

周期计算，指的是对时间周期进行算术运算，所有的操作将在“频率”的基础上执行。

```
import pandas as pd 
#S表示秒
x = pd.Period('2014', freq='S')  
x 
```

输出结果：

1Period('2014-01-01 00:00:00', 'S')

执行计算示例：

```
import pandas as pd 
x = pd.Period('2014', freq='S')
#加1s的时间
print(x+1)
```

输出结果：

1Period('2014-01-01 00:00:01', 'S')

再看一组完整的示例：

```
#定义时期period，默认freq="Y"年份
p1=pd.Period('2020')
p2=pd.Period('2019')
#使用f''格式化输出
print(f'p1={p1}年')
print(f'p2={p2}年')
print(f'p1和p2间隔{p1-p2}年')
#f''表示字符串格式化输出
print(f'五年前是{p1-5}年')
```

输出结果：

1p1=2020年

2p2=2019年

3p1和p2间隔\<YearEnd: month=12\>年

4五年前是2015年

### 创建时间周期

我们可以使用 period_range() 方法来创建时间周期范围。示例如下：

```
import pandas as pd
#Y表示年
p = pd.period_range('2016','2018', freq='Y')
p
```
输出结果：

1PeriodIndex(['2016', '2017', '2018'], dtype='period[A-DEC]', freq='A-DEC')

### 时间序列转换

如果想要把字符串日期转换为 Period，首先需要将字符串转换为日期格式，然后再将日期转换为 Period。示例如下：

```
# 创建时间序列
index=pd.date_range("2020-03-17","2020-03-30",freq="1.5H")
#随机选取4个互不相同的数
loc=np.random.choice(np.arange(len(index)),size=4,replace=False)
loc.sort()
ts_index=index[loc]
ts_index
pd_index=ts_index.to_periods('D')
pd_index()
```

输出结果：

1DatetimeIndex(['2020-03-17 12:00:00', '2020-03-22 04:30:00',

2 '2020-03-27 03:00:00', '2020-03-30 00:00:00'],

3 dtype='datetime64[ns]', freq=None)

4

5PeriodIndex(['2020-03-17', '2020-03-19', '2020-03-19', '2020-03-27'], dtype='period[D]', freq='D')

使用 to_timestamp() 能够将 Period 时期转换为时间戳（timestamp），示例如下：

```
import pandas as pd
p1=pd.Periods("2020-2-3")
p1.to_timestamp()
```

输出结果：

1Timestamp('2020-02-03 00:00:00')

### 创建日期范围

Pandas 提供了用来创建日期序列的函数 date_range()，该函数的默认频率为 "D"， 也就是“天”。日期序列只包含年、月、日，不包含时、分、秒。

下面是一组简单的示例，如下所示：

```
import pandas as pd
print(pd.date_range('12/15/2020', periods=10))
```

输出结果：

DatetimeIndex(['2020-12-15', '2020-12-16', '2020-12-17', '2020-12-18',
'2020-12-19', '2020-12-20', '2020-12-21', '2020-12-22',
'2020-12-23', '2020-12-24'],
dtype='datetime64[ns]', freq='D')

当我们使用 date_range() 来创建日期范围时，该函数包含结束的日期，用数学术语来说就是区间左闭右闭，即包含起始值，也包含结束值。示例如下：

```
import pandas as pd
#建议使用Python的datetime模块创建时间
start = pd.datetime(2019, 1, 1)
end = pd.datetime(2019, 1, 5)
print pd.date_range(start,end)
```

输出结果：

1DatetimeIndex(['2019-01-01', '2019-01-02', '2019-01-03', '2019-01-04','2019-01-05']

2,dtype='datetime64[ns]', freq='D')

### 更改日频率

使用下列方法可以修改频率，比如按“天”为按“月”，示例如下：

```
import pandas as pd
print(pd.date_range('12/15/2011', periods=5,freq='M'))
```

输出结果：

1DatetimeIndex(['2020-12-31', '2021-01-31', '2021-02-28', '2021-03-31',

2 '2021-04-30'],dtype='datetime64[ns]', freq='M')

### 工作日时间

bdate_range() 表示创建工作日的日期范围，它与 date_range() 不同，它不包括周六、周日。

```
import pandas as pd
print(pd.date_range('11/25/2020', periods=8))
```

输出结果：

1DatetimeIndex(['2020-11-25', '2020-11-26', '2020-11-27', '2020-11-28','2020-11-29', '2020-11-30', '2020-12-01', '2020-12-02'],dtype='datetime64[ns]', freq='D')

上述方法中，date_range() 默认频率是日历日，而 bdate_range() 的默认频率是工作日。
