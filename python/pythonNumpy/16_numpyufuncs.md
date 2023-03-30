# 什么是 ufuncs？

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
