### 数组过滤

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
