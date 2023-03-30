# 安装 NumPy

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