# 拆分 NumPy 数组

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