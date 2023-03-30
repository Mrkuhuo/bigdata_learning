# 连接 NumPy 数组

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