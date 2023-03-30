# 数组迭代

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