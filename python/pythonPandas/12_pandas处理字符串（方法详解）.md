Pandas 提供了一系列的字符串函数，因此能够很方便地对字符串进行处理。在本节，我们使用 Series 对象对常用的字符串函数进行讲解。

常用的字符串处理函数如下表所示：

| 函数名称            | 函数功能和描述                                                            |
|---------------------|---------------------------------------------------------------------------|
| lower()             | 将的字符串转换为小写。                                                    |
| upper()             | 将的字符串转换为大写。                                                    |
| len()               | 得出字符串的长度。                                                        |
| strip()             | 去除字符串两边的空格（包含换行符）。                                      |
| split()             | 用指定的分割符分割字符串。                                                |
| cat(sep="")         | 用给定的分隔符连接字符串元素。                                            |
| get_dummies()       | 返回一个带有独热编码值的 DataFrame 结构。                                 |
| contains(pattern)   | 如果子字符串包含在元素中，则为每个元素返回一个布尔值 True，否则为 False。 |
| replace(a,b)        | 将值 a 替换为值 b。                                                       |
| count(pattern)      | 返回每个字符串元素出现的次数。                                            |
| startswith(pattern) | 如果 Series 中的元素以指定的字符串开头，则返回 True。                     |
| endswith(pattern)   | 如果 Series 中的元素以指定的字符串结尾，则返回 True。                     |
| findall(pattern)    | 以列表的形式返出现的字符串。                                              |
| swapcase()          | 交换大小写。                                                              |
| islower()           | 返回布尔值，检查 Series 中组成每个字符串的所有字符是否都为小写。          |
| issupper()          | 返回布尔值，检查 Series 中组成每个字符串的所有字符是否都为大写。          |
| isnumeric()         | 返回布尔值，检查 Series 中组成每个字符串的所有字符是否都为数字。          |
| repeat(value)       | 以指定的次数重复每个元素。                                                |
| find(pattern)       | 返回字符串第一次出现的索引位置。                                          |

注意：上述所有字符串函数全部适用于 DataFrame 对象，同时也可以与 Python 内置的字符串函数一起使用，这些函数在处理 Series/DataFrame 对象的时候会自动忽略缺失值数据（NaN）。

### lower()

```
import pandas as pd
import numpy as np
s = pd.Series(['C', 'Python', 'java', 'go', np.nan, '1125','javascript'])
print(s.str.lower)
```

输出结果：

10 tom

21 william rick

32 john

43 alber@t

54 NaN

65 1234

76 stevesmith

8dtype: object

### len()

```
import pandas as pd
import numpy as np
s = pd.Series(['C', 'Python', 'java', 'go', np.nan, '1125','javascript'])
print(s.str.len())
```

输出结果：

10 1.0

21 6.0

32 4.0

43 2.0

54 NaN

65 4.0

76 10.0

8dtype: float64

### strip()

```
import pandas as pd
import numpy as np
s = pd.Series(['C ', ' Python', 'java', 'go', np.nan, '1125 ','javascript'])
print(s.str.strip())
```

输出结果：

10 C

21 Python

32 java

43 go

54 NaN

65 1125

76 javascript

8dtype: object

### split(pattern)

```
import pandas as pd
import numpy as np
s = pd.Series(['C ',' Python','java','go','1125 ','javascript'])
print(s.str.split(" "))
```

输出结果：

10 [C, ]

21 [, Python]

32 [java]

43 [go]

54 [1125, ]

65 [javascript]

7dtype: object

### cat(sep="")

```
import pandas as pd
import numpy as np
s = pd.Series(['C', 'Python', 'java', 'go', np.nan, '1125','javascript'])
#会自动忽略NaN
print(s.str.cat(sep="_"))
```

输出结果：

1C_Python_java_go_1125_javascript

### get_dummies()

```
import pandas as pd
import numpy as np
s = pd.Series(['C', 'Python', 'java', 'go', np.nan, '1125','javascript'])
print(s.str.get_dummies())
```

输出结果：

1 1125 C Python go java javascript

20 0 1 0 0 0 0

31 0 0 1 0 0 0

42 0 0 0 0 1 0

53 0 0 0 1 0 0

64 0 0 0 0 0 0

75 1 0 0 0 0 0

86 0 0 0 0 0 1

### contains()

检查 Series 中的每个字符，如果字符中包含空格，则返回 True，否则返回 False。示例如下：

```
import pandas as pd
import numpy as np
s = pd.Series(['C ',' Python','java','go','1125 ','javascript'])
print(s.str.contains(" "))
```

输出结果：

10 True

21 True

32 False

43 False

54 True

65 False

7dtype: bool

### repeat()

```
import pandas as pd
import numpy as np
s = pd.Series(['C ',' Python','java','go','1125 ','javascript'])
print(s.str.repeat(3))
```

输出结果：

10 C C C

21 Python Python Python

32 javajavajava

43 gogogo

54 1125 1125 1125

65 javascriptjavascriptjavascript

7dtype: object

### startswith()

```
import pandas as pd
import numpy as np
s = pd.Series(['C ',' Python','java','go','1125 ','javascript'])
#若以指定的"j"开头则返回True
print(s.str.startswith("j"))
```

输出结果：

10 False

21 False

32 True

43 False

54 False

65 True

7dtype: bool

### find()

```
import pandas as pd
import numpy as np
s = pd.Series(['C ',' Python','java','go','1125 ','javascript'])
print(s.str.find("j"))
```

输出结果：

10 -1

21 -1

32 0

43 -1

54 -1

65 0

7dtype: int64

如果返回 -1 表示该字符串中没有出现指定的字符。

### findall()

```
import pandas as pd
import numpy as np
s = pd.Series(['C ',' Python','java','go','1125 ','javascript'])
print(s.str.findall("j"))
```

输出结果：

10 []

21 []

32 [j]

43 []

54 []

65 [j]

7dtype: object

### swapcase()

```
import pandas as pd
import numpy as np
s = pd.Series(['C ',' Python','java','go','1125 ','javascript'])
print(s.str.swapcase())
```

输出结果：

10 c

21 pYTHON

32 JAVA

43 GO

54 1125

65 JAVASCRIPT

7dtype: object

### isnumeric()

返回一个布尔值，用来判断是否存在数字型字符串。示例如下：

```
import pandas as pd
import numpy as np
s = pd.Series(['C ',' Python','java','go','1125','javascript'])
print(s.str.isnumeric())
```

输出结果：

10 False

21 False

32 False

43 False

54 True

65 False

7dtype: bool
