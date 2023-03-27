当进行数据分析时，我们会遇到很多带有日期、时间格式的数据集，在处理这些数据集时，可能会遇到日期格式不统一的问题，此时就需要对日期时间做统一的格式化处理。比如“Wednesday, June 6, 2020”可以写成“6/6/20”，或者写成“06-06-2020。

### 日期格式化符号

在对时间进行格式化处理时，它们都有固定的表示格式，比如小时的格式化符号为%H ,分钟简写为%M ，秒简写为%S。下表对常用的日期格式化符号做了总结：

|      | 日期格式化符号                            |
|------|-------------------------------------------|
| 符号 | 说明                                      |
| %y   | 两位数的年份表示（00-99）                 |
| %Y   | 四位数的年份表示（000-9999）              |
| %m   | 月份（01-12）                             |
| %d   | 月内中的一天（0-31）                      |
| %H   | 24小时制小时数（0-23）                    |
| %I   | 12小时制小时数（01-12）                   |
| %M   | 分钟数（00=59）                           |
| %S   | 秒（00-59）                               |
| %a   | 本地英文缩写星期名称                      |
| %A   | 本地英文完整星期名称                      |
| %b   | 本地缩写英文的月份名称                    |
| %B   | 本地完整英文的月份名称                    |
| %w   | 星期（0-6），星期天为星期的开始           |
| %W   | 一年中的星期数（00-53）星期一为星期的开始 |
| %x   | 本地相应的日期表示                        |
| %X   | 本地相应的时间表示                        |
| %Z   | 当前时区的名称                            |
| %U   | 一年中的星期数（00-53）星期天为星期的开始 |
| %j   | 年内的一天（001-366）                     |
| %c   | 本地相应的日期表示和时间表示              |

### Python处理

Python 内置的 strptime() 方法能够将字符串日期转换为 datetime 类型，下面看一组示例：

```
from datetime import datetime
#将日期定义为字符串    
date_str1 = 'Wednesday, July 18, 2020' 
date_str2 = '18/7/20' 
date_str3 = '18-07-2020'  
#将日期转化为datetime对象 
dmy_dt1 = datetime.strptime(date_str1, '%A,%B%d,%Y') 
dmy_dt2 = datetime.strptime(date_str2, '%d/%m/%y') 
dmy_dt3 = datetime.strptime(date_str3, '%d-%m-%Y')  
#处理为相同格式，并打印输出
print(dmy_dt1) 
print(dmy_dt2) 
print(dmy_dt3) 
```

输出结果：

12020-07-18 00:00:00

22020-07-18 00:00:00

32020-07-18 00:00:00

注意：strftime() 可以将 datetime 类型转换为字符串类型，恰好与 strptime() 相反。

### Pandas处理

除了使用 Python 内置的 strptime() 方法外，你还可以使用 Pandas 模块的 pd.to_datetime() 和 pd.DatetimeIndex() 进行转换。

#### 1) to_datetime()

通过 to_datetime() 直接转换为 datetime 类型

```
import pandas as pd
import numpy as np
date = ['2012-05-06 11:00:00','2012-05-16 11:00:00']
pd_date=pd.to_datetime(date)
df=pd.Series(np.random.randn(2),index=pd_date)
```

#### 2) DatetimeIndex()

使用 Datetimeindex() 函数设置时间序，示例如下：

```
date = pd.DatetimeIndex(['1/1/2008', '1/2/2008', '1/3/2008', '1/4/2008', '1/5/2008'])
dt = pd.Series(np.random.randn(5),index = date)
print(dt)
```

输出结果：

12008-01-01 1.965619

22008-01-02 -2.897374

32008-01-03 0.625929

42008-01-04 1.204926

52008-01-05 1.755680

6dtype: float64
