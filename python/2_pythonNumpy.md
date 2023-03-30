# 一、什么是 NumPy？

NumPy 是用于处理数组的 python 库。

它还拥有在线性代数、傅立叶变换和矩阵领域中工作的函数。

NumPy 由 Travis Oliphant 于 2005 年创建。它是一个开源项目，您可以自由使用它。

NumPy 指的是数值 Python（Numerical Python）。

### 为何使用 NumPy？

在 Python 中，我们有满足数组功能的列表，但是处理起来很慢。

NumPy 旨在提供一个比传统 Python 列表快 50 倍的数组对象。

NumPy 中的数组对象称为 ndarray，它提供了许多支持函数，使得利用 ndarray 非常容易。

数组在数据科学中非常常用，因为速度和资源非常重要。

**数据科学：计算机科学的一个分支，研究如何存储、使用和分析数据以从中获取信息。**

### 为什么 NumPy 比列表快？

与列表不同，NumPy 数组存储在内存中的一个连续位置，因此进程可以非常有效地访问和操纵它们。

这种行为在计算机科学中称为引用的局部性。

这是 NumPy 比列表更快的主要原因。它还经过了优化，可与最新的 CPU 体系结构一同使用。

### NumPy 用哪种语言编写？

NumPy 是一个 Python 库，部分用 Python 编写，但是大多数需要快速计算的部分都是用 C 或 C ++ 编写的。

# 二、安装 NumPy

请使用这条命令安装它：

```
pip install numpy
```

如果此命令失败，请使用已经安装了 NumPy 的 python 发行版，例如 Anaconda、Spyder 等。

### 导入 NumPy

安装 NumPy 后，通过添加 import 关键字将其导入您的应用程序：

```
import numpy
```

现在，Numpy 已导入并可以使用。

```
import numpy 

arr = numpy.array([1, 2, 3, 4, 5]) 

print(arr)
```

[1 2 3 4 5]

### NumPy as np

NumPy 通常以 np 别名导入。

别名：在 Python 中，别名是用于引用同一事物的替代名称。

请在导入时使用 as 关键字创建别名：

```
import numpy as np
```

现在，可以将 NumPy 包称为 np 而不是 numpy。

```
import numpy as np 

arr = np.array([1, 2, 3, 4, 5]) 

print(arr)
```

[1 2 3 4 5]

### 检查 NumPy 版本

版本字符串存储在 \__version_\_ 属性中。

```
import numpy as np

print(np.__version__)
```

1.15.4

# 三、创建 NumPy ndarray 对象

NumPy 用于处理数组。 NumPy 中的数组对象称为 ndarray。

我们可以使用 array() 函数创建一个 NumPy ndarray 对象。

```
import numpy as np 

arr = np.array([1, 2, 3, 4, 5])

print(arr)

print(type(arr))
```

[1 2 3 4 5]

print(type(arr))

**type():这个内置的 Python 函数告诉我们传递给它的对象的类型。像上面的代码一样，它表明 arr 是 numpy.ndarray 类型。**

要创建 ndarray，我们可以将列表、元组或任何类似数组的对象传递给 array() 方法，然后它将被转换为 ndarray：

使用元组创建 NumPy 数组：

```
import numpy as np 

arr = np.array((1, 2, 3, 4, 5))

print(arr)
```

[1 2 3 4 5]

### 数组中的维

数组中的维是数组深度（嵌套数组）的一个级别。

**嵌套数组：**指的是将数组作为元素的数组。

### 0-D 数组

0-D 数组，或标量（Scalars），是数组中的元素。数组中的每个值都是一个 0-D 数组。

用值 61 创建 0-D 数组：

```
import numpy as np

arr = np.array(61)

print(arr)
```

### 1-D 数组

其元素为 0-D 数组的数组，称为一维或 1-D 数组。

这是最常见和基础的数组。

创建包含值 1、2、3、4、5、6 的 1-D 数组：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])

print(arr)
```

[1 2 3 4 5 6]

### 2-D 数组

其元素为 1-D 数组的数组，称为 2-D 数组。

它们通常用于表示矩阵或二阶张量。

NumPy 有一个专门用于矩阵运算的完整子模块 numpy.mat。

创建包含值 1、2、3 和 4、5、6 两个数组的 2-D 数组：

```
import numpy as np

arr = np.array([[1, 2, 3], [4, 5, 6]])

print(arr)
```

[[1 2 3]

[4 5 6]]

### 3-D 数组

其元素为 2-D 数组的数组，称为 3-D 数组。

用两个 2-D 数组创建一个 3-D 数组，这两个数组均包含值 1、2、3 和 4、5、6 的两个数组：

```
import numpy as np

arr = np.array([[[1, 2, 3], [4, 5, 6]], [[1, 2, 3], [4, 5, 6]]])

print(arr)
```

[[[1 2 3]

[4 5 6]]

[[1 2 3]

[4 5 6]]]

### 检查维数？

NumPy 数组提供了 ndim 属性，该属性返回一个整数，该整数会告诉我们数组有多少维。

检查数组有多少维：

```
import numpy as np

a = np.array(42)
b = np.array([1, 2, 3, 4, 5])
c = np.array([[1, 2, 3], [4, 5, 6]])
d = np.array([[[1, 2, 3], [4, 5, 6]], [[1, 2, 3], [4, 5, 6]]])

print(a.ndim) 
print(b.ndim) 
print(c.ndim) 
print(d.ndim)
```

0

1

2

3

### 更高维的数组

数组可以拥有任意数量的维。

在创建数组时，可以使用 ndmin 参数定义维数。

创建一个有 5 个维度的数组，并验证它拥有 5 个维度：

```
import numpy as np

arr = np.array([1, 2, 3, 4], ndmin=5)

print(arr)
print('number of dimensions :', arr.ndim)
```

[[[[[1 2 3 4]]]]]

number of dimensions : 5

# 四、访问数组元素

数组索引等同于访问数组元素。

您可以通过引用其索引号来访问数组元素。

NumPy 数组中的索引以 0 开头，这意味着第一个元素的索引为 0，第二个元素的索引为 1，以此类推。

```
import numpy as np

arr = np.array([1, 2, 3, 4])

print(arr[0])
```

1

从以下数组中获取第二个元素：

```
import numpy as np

arr = np.array([1, 2, 3, 4])

print(arr[1])
```

2

从以下数组中获取第三和第四个元素并将其相加：

```
import numpy as np

arr = np.array([1, 2, 3, 4])

print(arr[2] + arr[3])
```

7

### 访问 2-D 数组

要访问二维数组中的元素，我们可以使用逗号分隔的整数表示元素的维数和索引。

访问第一维中的第二个元素：

```
import numpy as np

arr = np.array([[1,2,3,4,5], [6,7,8,9,10]])

print('2nd element on 1st dim: ', arr[0, 1])
```

2nd element on 1st dim: 2

访问第二维中的第五个元素：

```
import numpy as np

arr = np.array([[1,2,3,4,5], [6,7,8,9,10]])

print('5th element on 2nd dim: ', arr[1, 4])
```

5th element on 2nd dim: 10

### 访问 3-D 数组

要访问 3-D 数组中的元素，我们可以使用逗号分隔的整数来表示元素的维数和索引。

访问第一个数组的第二个数组的第三个元素：

```
import numpy as np

arr = np.array([[[1, 2, 3], [4, 5, 6]], [[7, 8, 9], [10, 11, 12]]])

print(arr[0, 1, 2])
```

6

### 工作原理：

第一个数字代表第一个维度，其中包含两个数组：

[[1, 2, 3], [4, 5, 6]]

然后：

[[7, 8, 9], [10, 11, 12]]

由于我们选择了 0，所以剩下第一个数组：

[[1, 2, 3], [4, 5, 6]]

第二个数字代表第二维，它也包含两个数组：

[1, 2, 3]

然后：

[4, 5, 6]

因为我们选择了 1，所以剩下第二个数组：

[4, 5, 6]

第三个数字代表第三维，其中包含三个值：

4  
5  
6

由于我们选择了 2，因此最终得到第三个值：

6

### 负索引

使用负索引从尾开始访问数组。

打印第二个维中的的最后一个元素：

```
import numpy as np

arr = np.array([[1,2,3,4,5], [6,7,8,9,10]])

print('Last element from 2nd dim: ', arr[1, -1])
```

Last element from 2nd dim: 10

# 五、裁切数组

python中裁切的意思是将元素从一个给定的索引获取到另一个给定的索引。

我们像这样传递切片而不是索引：[start：end]。

我们还可以定义步长，如下所示：[start：end：step]。

如果我们不传递 *start*，则将其视为 0。

如果我们不传递 *end*，则视为该维度内数组的长度。

如果我们不传递 *step*，则视为 1。

从下面的数组中裁切索引 1 到索引 5 的元素：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7])

print(arr[1:5])
```

[2 3 4 5]

**注释：结果包括了开始索引，但不包括结束索引。**

裁切数组中索引 4 到结尾的元素：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7])

print(arr[4:])
```

[5 6 7]

裁切从开头到索引 4（不包括）的元素：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7])

print(arr[:4])
```

[1 2 3 4]

### 负裁切

使用减号运算符从末尾开始引用索引：

从末尾开始的索引 3 到末尾开始的索引 1，对数组进行裁切：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7])

print(arr[-3:-1])
```

[5 6]

### STEP

请使用 step 值确定裁切的步长：

从索引 1 到索引 5，返回相隔的元素：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7])

print(arr[1:5:2])
```

[2 4]

返回数组中相隔的元素：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7])

print(arr[::2])
```

[1 3 5 7]

### 裁切 2-D 数组

从第二个元素开始，对从索引 1 到索引 4（不包括）的元素进行切片：

```
import numpy as np

arr = np.array([[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]])

print(arr[1, 1:4])
```

[7 8 9]

**注释：请记得第二个元素的索引为 1。**

从两个元素中返回索引 2：

```
import numpy as np

arr = np.array([[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]])

print(arr[0:2, 2])
```

[3 8]

从两个元素裁切索引 1 到索引 4（不包括），这将返回一个 2-D 数组：

import numpy as np

arr = np.array([[1, 2, 3, 4, 5], [6, 7, 8, 9, 10]])

print(arr[0:2, 1:4])

[[2 3 4]

[7 8 9]]

# 六、Python 中的数据类型

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

# 七、副本和视图之间的区别

副本和数组视图之间的主要区别在于副本是一个新数组，而这个视图只是原始数组的视图。

副本拥有数据，对副本所做的任何更改都不会影响原始数组，对原始数组所做的任何更改也不会影响副本。

视图不拥有数据，对视图所做的任何更改都会影响原始数组，而对原始数组所做的任何更改都会影响视图。

### 副本：

进行复制，更改原始数组并显示两个数组：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5])
x = arr.copy()
arr[0] = 61

print(arr) 
print(x)
```

[61 2 3 4 5]

[1 2 3 4 5]

该副本不应受到对原始数组所做更改的影响。

### 视图：

创建视图，更改原始数组，然后显示两个数组：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5])
x = arr.view()
arr[0] = 61

print(arr) 
print(x)
```

[61 2 3 4 5]

[61 2 3 4 5]

视图应该受到对原始数组所做更改的影响。

在视图中进行更改：

创建视图，更改视图，并显示两个数组：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5])
x = arr.view()
x[0] = 31

print(arr) 
print(x)
```

[31 2 3 4 5]

[31 2 3 4 5]

原始数组应该受到对视图所做更改的影响。

### 检查数组是否拥有数据

如上所述，副本拥有数据，而视图不拥有数据，但是我们如何检查呢？

每个 NumPy 数组都有一个属性 base，如果该数组拥有数据，则这个 base 属性返回 None。

否则，base 属性将引用原始对象。

打印 base 属性的值以检查数组是否拥有自己的数据：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5])

x = arr.copy()
y = arr.view()

print(x.base)
print(y.base)
```

None

[1 2 3 4 5]

副本返回 None。

视图返回原始数组。

# 八、数组重塑

重塑意味着更改数组的形状。

数组的形状是每个维中元素的数量。

通过重塑，我们可以添加或删除维度或更改每个维度中的元素数量。

### 从 1-D 重塑为 2-D

将以下具有 12 个元素的 1-D 数组转换为 2-D 数组。

最外面的维度将有 4 个数组，每个数组包含 3 个元素：

import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12])

newarr = arr.reshape(4, 3)

print(newarr)

[[ 1 2 3]

[ 4 5 6]

[ 7 8 9]

[10 11 12]]

### 从 1-D 重塑为 3-D

将以下具有 12 个元素的 1-D 数组转换为 3-D 数组。

最外面的维度将具有 2 个数组，其中包含 3 个数组，每个数组包含 2 个元素：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12])

newarr = arr.reshape(2, 3, 2)

print(newarr)
```

[[[ 1 2]

[ 3 4]

[ 5 6]]

[[ 7 8]

[ 9 10]

[11 12]]]

### 我们可以重塑成任何形状吗？

是的，只要重塑所需的元素在两种形状中均相等。

我们可以将 8 元素 1D 数组重塑为 2 行 2D 数组中的 4 个元素，但是我们不能将其重塑为 3 元素 3 行 2D 数组，因为这将需要 3x3 = 9 个元素。

尝试将具有 8 个元素的 1D 数组转换为每个维度中具有 3 个元素的 2D 数组（将产生错误）：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7, 8])

newarr = arr.reshape(3, 3)

print(newarr)
```

ValueError Traceback (most recent call last)

\~\\AppData\\Local\\Temp\\ipykernel_1376\\1520178591.py in \<module\>

3 arr = np.array([1, 2, 3, 4, 5, 6, 7, 8])

4

\----\> 5 newarr = arr.reshape(3, 3)

6

7 print(newarr)

ValueError: cannot reshape array of size 8 into shape (3,3)

### 返回副本还是视图？

检查返回的数组是副本还是视图：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7, 8])

print(arr.reshape(2, 4).base)
```

[1 2 3 4 5 6 7 8]

上面的例子返回原始数组，因此它是一个视图。

### 未知的维

您可以使用一个“未知”维度。

这意味着您不必在 reshape 方法中为维度之一指定确切的数字。

传递 -1 作为值，NumPy 将为您计算该数字。

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7, 8])

newarr = arr.reshape(2, 2, -1)

print(newarr)
```

[[[1 2]

[3 4]]

[[5 6]

[7 8]]]

**注释：**我们不能将 -1 传递给一个以上的维度。

### 展平数组

展平数组（Flattening the arrays）是指将多维数组转换为 1D 数组。

我们可以使用 reshape(-1) 来做到这一点。

把数组转换为 1D 数组：

```
import numpy as np

arr = np.array([[1, 2, 3], [4, 5, 6]])

newarr = arr.reshape(-1)

print(newarr)
```

[1 2 3 4 5 6]

# 九、数组迭代

迭代意味着逐一遍历元素。

当我们在 numpy 中处理多维数组时，可以使用 python 的基本 for 循环来完成此操作。

如果我们对 1-D 数组进行迭代，它将逐一遍历每个元素。

迭代以下一维数组的元素：

```
import numpy as np

arr = np.array([1, 2, 3])

for x in arr:
  print(x)
```

1

2

3

### 迭代 2-D 数组

在 2-D 数组中，它将遍历所有行。

迭代以下二维数组的元素：

```
import numpy as np

arr = np.array([[1, 2, 3], [4, 5, 6]])

for x in arr:
  print(x)
```

[1 2 3]

[4 5 6]

如果我们迭代一个 n-D 数组，它将逐一遍历第 n-1 维。

如需返回实际值、标量，我们必须迭代每个维中的数组。

迭代 2-D 数组的每个标量元素：

```
import numpy as np

arr = np.array([[1, 2, 3], [4, 5, 6]])

for x in arr:
  for y in x:
    print(y)
```

1

2

3

4

5

6

### 迭代 3-D 数组

在 3-D 数组中，它将遍历所有 2-D 数组。

迭代以下 3-D 数组的元素：

```
import numpy as np

arr = np.array([[[1, 2, 3], [4, 5, 6]], [[7, 8, 9], [10, 11, 12]]])

for x in arr:
  print(x)
```

[[1 2 3]

[4 5 6]]

[[ 7 8 9]

[10 11 12]]

要返回实际值、标量，我们必须迭代每个维中的数组。

迭代到标量：

```
import numpy as np

arr = np.array([[[1, 2, 3], [4, 5, 6]], [[7, 8, 9], [10, 11, 12]]])

for x in arr:
  for y in x:
    for z in y:
      print(z)
```

1

2

3

4

5

6

7

8

9

10

11

12

### 使用 nditer() 迭代数组

函数 nditer() 是一个辅助函数，从非常基本的迭代到非常高级的迭代都可以使用。它解决了我们在迭代中面临的一些基本问题，让我们通过例子进行介绍。

### 迭代每个标量元素

在基本的 for 循环中，迭代遍历数组的每个标量，我们需要使用 n 个 for 循环，对于具有高维数的数组可能很难编写。

遍历以下 3-D 数组：

```
import numpy as np

arr = np.array([[[1, 2], [3, 4]], [[5, 6], [7, 8]]])

for x in np.nditer(arr):
  print(x)
```

1

2

3

4

5

6

7

8

### 迭代不同数据类型的数组

我们可以使用 op_dtypes 参数，并传递期望的数据类型，以在迭代时更改元素的数据类型。

NumPy 不会就地更改元素的数据类型（元素位于数组中），因此它需要一些其他空间来执行此操作，该额外空间称为 buffer，为了在 nditer() 中启用它，我们传参 flags=['buffered']。

以字符串形式遍历数组：

```
import numpy as np

arr = np.array([1, 2, 3])

for x in np.nditer(arr, flags=['buffered'], op_dtypes=['S']):
  print(x)
```

b'1'

b'2'

b'3'

### 使用 ndenumerate() 进行枚举迭代

枚举是指逐一提及事物的序号。

有时，我们在迭代时需要元素的相应索引，对于这些用例，可以使用 ndenumerate() 方法。

枚举以下 1D 数组元素：

```
import numpy as np

arr = np.array([1, 2, 3])

for idx, x in np.ndenumerate(arr):
  print(idx, x)
```

(0,) 1

(1,) 2

(2,) 3

### 实例

枚举以下 2D 数组元素：

```
import numpy as np

arr = np.array([[1, 2, 3, 4], [5, 6, 7, 8]])

for idx, x in np.ndenumerate(arr):
  print(idx, x)
```

(0, 0) 1

(0, 1) 2

(0, 2) 3

(0, 3) 4

(1, 0) 5

(1, 1) 6

(1, 2) 7

(1, 3) 8

# 十、连接 NumPy 数组

连接意味着将两个或多个数组的内容放在单个数组中。

在 SQL 中，我们基于键来连接表，而在 NumPy 中，我们按轴连接数组。

我们传递了一系列要与轴一起连接到 concatenate() 函数的数组。如果未显式传递轴，则将其视为 0。

连接两个数组：

```
import numpy as np

arr1 = np.array([1, 2, 3])

arr2 = np.array([4, 5, 6])

arr = np.concatenate((arr1, arr2))

print(arr)
```

[1 2 3 4 5 6]

沿着行 (axis=1) 连接两个 2-D 数组：

```
import numpy as np

arr1 = np.array([[1, 2], [3, 4]])

arr2 = np.array([[5, 6], [7, 8]])

arr = np.concatenate((arr1, arr2), axis=1)

print(arr)
```

[[1 2 5 6]

[3 4 7 8]]

# 十一、拆分 NumPy 数组

拆分是连接的反向操作。

连接（Joining）是将多个数组合并为一个，拆分（Spliting）将一个数组拆分为多个。

我们使用 array_split() 分割数组，将要分割的数组和分割数传递给它。

将数组分为 3 部分：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])

newarr = np.array_split(arr, 3)

print(newarr)
```

[array([1, 2]), array([3, 4]), array([5, 6])]

**注释：返回值是一个包含三个数组的数组。**

如果数组中的元素少于要求的数量，它将从末尾进行相应调整。

将数组分为 4 部分：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])

newarr = np.array_split(arr, 4)

print(newarr)
```

[array([1, 2]), array([3, 4]), array([5]), array([6])]

**提示：**我们也有 split() 方法可用，但是当源数组中的元素较少用于拆分时，它将不会调整元素，如上例那样，array_split() 正常工作，但 split() 会失败。

### 拆分为数组

array_split() 方法的返回值是一个包含每个分割的数组。

如果将一个数组拆分为 3 个数组，则可以像使用任何数组元素一样从结果中访问它们：

访问拆分的数组：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6])

newarr = np.array_split(arr, 3)

print(newarr[0])
print(newarr[1])
print(newarr[2])
```

[1 2]

[3 4]

[5 6]

### 分割二维数组

拆分二维数组时，请使用相同的语法。

使用 array_split() 方法，传入要分割的数组和想要分割的数目。

把这个 2-D 拆分为三个 2-D 数组。

```
import numpy as np

arr = np.array([[1, 2], [3, 4], [5, 6], [7, 8], [9, 10], [11, 12]])

newarr = np.array_split(arr, 3)

print(arr)

print(newarr)
```

[[ 1 2]

[ 3 4]

[ 5 6]

[ 7 8]

[ 9 10]

[11 12]]

[array([[1, 2],

[3, 4]]), array([[5, 6],

[7, 8]]), array([[ 9, 10],

[11, 12]])]

# 十二、搜索数组

您可以在数组中搜索（检索）某个值，然后返回获得匹配的索引。

要搜索数组，请使用 where() 方法。

查找值为 4 的索引：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 4, 4])

x = np.where(arr == 4)

print(x)
```

(array([3, 5, 6], dtype=int64),)

查找值为偶数的索引：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7, 8])

x = np.where(arr%2 == 0)

print(x)

```
(array([1, 3, 5, 7], dtype=int64),)

查找值为奇数的索引：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7, 8])

x = np.where(arr%2 == 1)

print(x)
```

(array([0, 2, 4, 6], dtype=int64),)

### 搜索排序

有一个名为 searchsorted() 的方法，该方法在数组中执行二进制搜索，并返回将在其中插入指定值以维持搜索顺序的索引。

假定 searchsorted() 方法用于排序数组。

查找应在其中插入值 7 的索引：
```
import numpy as np

arr = np.array([6, 7, 8, 9])

x = np.searchsorted(arr, 7)

print(x)
```

1

**例子解释：应该在索引 1 上插入数字 7，以保持排序顺序。**

该方法从左侧开始搜索，并返回第一个索引，其中数字 7 不再大于下一个值。

### 从右侧搜索

默认情况下，返回最左边的索引，但是我们可以给定 side='right'，以返回最右边的索引。

从右边开始查找应该插入值 7 的索引：

```
import numpy as np

arr = np.array([6, 7, 8, 9])

x = np.searchsorted(arr, 7, side='right')

print(x)
```

2

**例子解释：应该在索引 2 上插入数字 7，以保持排序顺序。**

该方法从右边开始搜索，并返回第一个索引，其中数字 7 不再小于下一个值。

要搜索多个值，请使用拥有指定值的数组。

查找应在其中插入值 2、4 和 6 的索引：

```
import numpy as np

arr = np.array([1, 3, 5, 7])

x = np.searchsorted(arr, [2, 4, 6])

print(x)
```

[1 2 3]

# 十三、数组排序

排序是指将元素按有序顺序排列。

有序序列是拥有与元素相对应的顺序的任何序列，例如数字或字母、升序或降序。

NumPy ndarray 对象有一个名为 sort() 的函数，该函数将对指定的数组进行排序。

对数组进行排序：

```
import numpy as np

arr = np.array([3, 2, 0, 1])

print(np.sort(arr))
```

[0 1 2 3]

**注释：此方法返回数组的副本，而原始数组保持不变。**

您还可以对字符串数组或任何其他数据类型进行排序：

对数组以字母顺序进行排序：

```
import numpy as np

arr = np.array(['banana', 'cherry', 'apple'])

print(np.sort(arr))
```

['apple' 'banana' 'cherry']

对布尔数组进行排序：

```
import numpy as np

arr = np.array([True, False, True])

print(np.sort(arr))
```

[False True True]

### 对 2-D 数组排序

如果在二维数组上使用 sort() 方法，则将对两个数组进行排序：

对 2-D 数组排序

```
import numpy as np

arr = np.array([[3, 2, 4], [5, 0, 1]])

print(np.sort(arr))
```

[[2 3 4]

[0 1 5]]

# 十四、数组过滤

从现有数组中取出一些元素并从中创建新数组称为过滤（filtering）。

在 NumPy 中，我们使用布尔索引列表来过滤数组。

布尔索引列表是与数组中的索引相对应的布尔值列表。

如果索引处的值为 True，则该元素包含在过滤后的数组中；如果索引处的值为 False，则该元素将从过滤后的数组中排除。

用索引 0 和 2、4 上的元素创建一个数组：

```
import numpy as np

arr = np.array([61, 62, 63, 64, 65])

x = [True, False, True, False, True]

newarr = arr[x]

print(newarr)
```

[61 63 65]

上例将返回 [61, 63, 65]，为什么？

因为新过滤器仅包含过滤器数组有值 True 的值，所以在这种情况下，索引为 0 和 2、4。

### 创建过滤器数组

在上例中，我们对 True 和 False 值进行了硬编码，但通常的用途是根据条件创建过滤器数组。

创建一个仅返回大于 62 的值的过滤器数组：

```
import numpy as np

arr = np.array([61, 62, 63, 64, 65])

# 创建一个空列表
filter_arr = []

# 遍历 arr 中的每个元素
for element in arr:
  # 如果元素大于 62，则将值设置为 True，否则为 False：
  if element > 62:
    filter_arr.append(True)
  else:
    filter_arr.append(False)

newarr = arr[filter_arr]

print(filter_arr)
print(newarr)
```

[False, False, True, True, True]

[63 64 65]

创建一个过滤器数组，该数组仅返回原始数组中的偶数元素：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7])

# 创建一个空列表
filter_arr = []

# 遍历 arr 中的每个元素
for element in arr:
  # 如果元素可以被 2 整除，则将值设置为 True，否则设置为 False
  if element % 2 == 0:
    filter_arr.append(True)
  else:
    filter_arr.append(False)

newarr = arr[filter_arr]

print(filter_arr)
print(newarr)
```

[False, True, False, True, False, True, False]

[2 4 6]

### 直接从数组创建过滤器

上例是 NumPy 中非常常见的任务，NumPy 提供了解决该问题的好方法。

我们可以在条件中直接替换数组而不是 iterable 变量，它会如我们期望地那样工作。

创建一个仅返回大于 62 的值的过滤器数组：

```
import numpy as np

arr = np.array([61, 62, 63, 64, 65])

filter_arr = arr > 62

newarr = arr[filter_arr]

print(filter_arr)
print(newarr)
```

[False False True True True]

[63 64 65]

创建一个过滤器数组，该数组仅返回原始数组中的偶数元素：

```
import numpy as np

arr = np.array([1, 2, 3, 4, 5, 6, 7])

filter_arr = arr % 2 == 0

newarr = arr[filter_arr]

print(filter_arr)
print(newarr)
```

[False True False True False True False]

[2 4 6]


# 十五、什么是随机数？

随机数并不意味着每次都有不同的数字。随机意味着无法在逻辑上预测的事物。

### 伪随机和真随机

计算机在程序上工作，程序是权威的指令集。因此，这意味着必须有某种算法来生成随机数。

如果存在生成随机数的程序，则可以预测它，因此它就不是真正的随机数。

通过生成算法生成的随机数称为伪随机数。

我们可以生成真正的随机数吗？

是的。为了在我们的计算机上生成一个真正的随机数，我们需要从某个外部来源获取随机数据。外部来源通常是我们的击键、鼠标移动、网络数据等。

我们不需要真正的随机数，除非它与安全性（例如加密密钥）有关或应用的基础是随机性（例如数字轮盘赌轮）。

在本教程中，我们将使用伪随机数。

### 生成随机数

NumPy 提供了 random 模块来处理随机数。

生成一个 0 到 100 之间的随机整数：

```
from numpy import random

x = random.randint(100)

print(x)
```

53

### 生成随机浮点

random 模块的 rand() 方法返回 0 到 1 之间的随机浮点数。

生成一个 0 到 100 之间的随机浮点数：

```
from numpy import random

x = random.rand()

print(x)
```

0.38847973700502725

### 生成随机数组

在 NumPy 中，我们可以使用上例中的两种方法来创建随机数组。

### 整数

randint() 方法接受 size 参数，您可以在其中指定数组的形状。

生成一个 1-D 数组，其中包含 5 个从 0 到 100 之间的随机整数：

```
from numpy import random

x=random.randint(100, size=(5))

print(x)
```

[65 84 27 38 23]

生成有 3 行的 2-D 数组，每行包含 5 个从 0 到 100 之间的随机整数：

```
from numpy import random

x = random.randint(100, size=(3, 5))

print(x)
```

[[55 98 89 72 19]

[58 64 45 59 61]

[40 65 62 25 61]]

### 浮点数

rand() 方法还允许您指定数组的形状。

生成包含 5 个随机浮点数的 1-D 数组：

```
from numpy import random

x = random.rand(5)

print(x)
```

[0.5479626 0.62153442 0.58551643 0.70627722 0.41044108]

生成有 3 行的 2-D 数组，每行包含 5 个随机数：

```
from numpy import random

x = random.rand(3, 5)

print(x)
```

[[0.68104869 0.31826133 0.31965176 0.35030968 0.45555737]

[0.2235311 0.09288664 0.73314334 0.72278927 0.5847335 ]

[0.48137041 0.81143246 0.50843836 0.77316004 0.73599801]]

# 十六、什么是 ufuncs？

ufuncs 指的是“通用函数”（Universal Functions），它们是对 ndarray 对象进行操作的 NumPy 函数。

### 为什么要使用 ufuncs？

ufunc 用于在 NumPy 中实现矢量化，这比迭代元素要快得多。

它们还提供广播和其他方法，例如减少、累加等，它们对计算非常有帮助。

ufuncs 还接受其他参数，比如：

where 布尔值数组或条件，用于定义应在何处进行操作。

dtype 定义元素的返回类型。

out 返回值应被复制到的输出数组。

### 什么是向量化？

将迭代语句转换为基于向量的操作称为向量化。

由于现代 CPU 已针对此类操作进行了优化，因此速度更快。

### 对两个列表的元素进行相加：

list 1: [1, 2, 3, 4]

list 2: [4, 5, 6, 7]

一种方法是遍历两个列表，然后对每个元素求和。

如果没有 ufunc，我们可以使用 Python 的内置 zip() 方法：

```
x = [1, 2, 3, 4]
y = [4, 5, 6, 7]
z = []

for i, j in zip(x, y):
  z.append(i + j)
print(z)
```

[5, 7, 9, 11]

对此，NumPy 有一个 ufunc，名为 add(x, y)，它会输出相同的结果。

```
import numpy as np

x = [1, 2, 3, 4]
y = [4, 5, 6, 7]
z = np.add(x, y)

print(z)
```

[ 5 7 9 11]

