# 访问数组元素

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
