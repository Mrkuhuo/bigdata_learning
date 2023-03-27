### Python 中的数据类型

默认情况下，Python 拥有以下数据类型：

-   strings - 用于表示文本数据，文本用引号引起来。例如 "ABCD"。
-   integer - 用于表示整数。例如 1, -2, -3。
-   float - 用于表示实数。例如 1.2, 42.42。
-   boolean - 用于表示 True 或 False。
-   complex - 用于表示复平面中的数字。例如 1.0 + 2.0j，1.5 + 2.5j。

### NumPy 中的数据类型

NumPy 有一些额外的数据类型，并通过一个字符引用数据类型，例如 i 代表整数，u 代表无符号整数等。

以下是 NumPy 中所有数据类型的列表以及用于表示它们的字符。

-   i - 整数
-   b - 布尔
-   u - 无符号整数
-   f - 浮点
-   c - 复合浮点数
-   m - timedelta
-   M - datetime
-   O - 对象
-   S - 字符串
-   U - unicode 字符串
-   V - 固定的其他类型的内存块 ( void )

### 检查数组的数据类型

NumPy 数组对象有一个名为 dtype 的属性，该属性返回数组的数据类型：

获取数组对象的数据类型：

```
import numpy as np

arr = np.array([1, 2, 3, 4])

print(arr.dtype)
```

```
int32

获取包含字符串的数组的数据类型：

import numpy as np

arr = np.array(['apple', 'banana', 'cherry'])

print(arr.dtype)
```

\<U6

### 用已定义的数据类型创建数组

我们使用 array() 函数来创建数组，该函数可以使用可选参数：dtype，它允许我们定义数组元素的预期数据类型：

用数据类型字符串创建数组：

```
import numpy as np

arr = np.array([1, 2, 3, 4], dtype='S')

print(arr)
print(arr.dtype)
```

[b'1' b'2' b'3' b'4']

\|S1

对于 i、u、f、S 和 U，我们也可以定义大小。

创建数据类型为 4 字节整数的数组：

```
import numpy as np

arr = np.array([1, 2, 3, 4], dtype='i4')

print(arr)
print(arr.dtype)
```

[1 2 3 4]

int32

### 假如值无法转换会怎样？

如果给出了不能强制转换元素的类型，则 NumPy 将引发 ValueError。

ValueError：在 Python 中，如果传递给函数的参数的类型是非预期或错误的，则会引发 ValueError。

无法将非整数字符串（比如 'a'）转换为整数（将引发错误）：

```
import numpy as np

arr = np.array(['a', '2', '3'], dtype='i')
```

ValueError Traceback (most recent call last)

\~\\AppData\\Local\\Temp\\ipykernel_52696\\1513465246.py in \<module\>

1 import numpy as np

2

\----\> 3 arr = np.array(['a', '2', '3'], dtype='i')

ValueError: invalid literal for int() with base 10: 'a'

### 转换已有数组的数据类型

更改现有数组的数据类型的最佳方法，是使用 astype() 方法复制该数组。

astype() 函数创建数组的副本，并允许您将数据类型指定为参数。

数据类型可以使用字符串指定，例如 'f' 表示浮点数，'i' 表示整数等。或者您也可以直接使用数据类型，例如 float 表示浮点数，int 表示整数。

通过使用 'i' 作为参数值，将数据类型从浮点数更改为整数：

```
import numpy as np

arr = np.array([1.1, 2.1, 3.1])

newarr = arr.astype('i')

print(newarr)
print(newarr.dtype)
```

[1 2 3]

int32

通过使用 int 作为参数值，将数据类型从浮点数更改为整数：

```
import numpy as np

arr = np.array([1.1, 2.1, 3.1])

newarr = arr.astype(int)

print(newarr)
print(newarr.dtype)
```

[1 2 3]

### 实例

将数据类型从整数更改为布尔值：

```
import numpy as np

arr = np.array([1, 0, 3])

newarr = arr.astype(bool)

print(newarr)
print(newarr.dtype)
```

[ True False True]

bool