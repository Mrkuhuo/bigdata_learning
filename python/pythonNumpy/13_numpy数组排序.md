### 数组排序

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