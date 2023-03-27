### 应用聚合函数

首先让我们创建一个 DataFrame 对象，然后对聚合函数进行应用。

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 4),index = pd.date_range('12/14/2020', periods=5),columns = ['A', 'B', 'C', 'D'])
print (df)
#窗口大小为3，min_periods 最小观测值为1
r = df.rolling(window=3,min_periods=1)
print(r) 
```

输出结果：

1 A B C D

22020-12-14 0.941621 1.205489 0.473771 -0.348169

32020-12-15 -0.276954 0.076387 0.104194 1.537357

42020-12-16 0.582515 0.481999 -0.652332 -1.893678

52020-12-17 -0.286432 0.923514 0.285255 -0.739378

62020-12-18 2.063422 -0.465873 -0.946809 1.590234

7

8Rolling [window=3,min_periods=1,center=False,axis=0]

#### 1) 对整体聚合

您可以把一个聚合函数传递给 DataFrame，示例如下：

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 4),index = pd.date_range('12/14/2020', periods=5),columns = ['A', 'B', 'C', 'D'])
print (df)
#窗口大小为3，min_periods 最小观测值为1
r = df.rolling(window=3,min_periods=1)
#使用 aggregate()聚合操作
print(r.aggregate(np.sum))
```

输出结果：

1 A B C D

22020-12-14 0.133713 0.746781 0.499385 0.589799

32020-12-15 -0.777572 0.531269 0.600577 -0.393623

42020-12-16 0.408115 -0.874079 0.584320 0.507580

52020-12-17 -1.033055 -1.185399 -0.546567 2.094643

62020-12-18 0.469394 -1.110549 -0.856245 0.260827

7

8 A B C D

92020-12-14 0.133713 0.746781 0.499385 0.589799

102020-12-15 -0.643859 1.278050 1.099962 0.196176

112020-12-16 -0.235744 0.403971 1.684281 0.703756

122020-12-17 -1.402513 -1.528209 0.638330 2.208601

132020-12-18 -0.155546 -3.170027 -0.818492 2.863051

#### 2) 对任意某一列聚合

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 4),index = pd.date_range('12/14/2020', periods=5),columns = ['A', 'B', 'C', 'D'])
#窗口大小为3，min_periods 最小观测值为1
r = df.rolling(window=3,min_periods=1)
#对 A 列聚合
print(r['A'].aggregate(np.sum))
```

输出结果：

12020-12-14 1.051501

22020-12-15 1.354574

32020-12-16 0.896335

42020-12-17 0.508470

52020-12-18 2.333732

6Freq: D, Name: A, dtype: float64

#### 3) 对多列数据聚合

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 4),index = pd.date_range('12/14/2020', periods=5),columns = ['A', 'B', 'C', 'D'])
#窗口大小为3，min_periods 最小观测值为1
r = df.rolling(window=3,min_periods=1)
#对 A/B 两列聚合
print(r['A','B'].aggregate(np.sum))
```

输出结果：

1 A B

22020-12-14 0.639867 -0.229990

32020-12-15 0.352028 0.257918

42020-12-16 0.637845 2.643628

52020-12-17 0.432715 2.428604

62020-12-18 -1.575766 0.969600

#### 4) 对单列应用多个函数

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 4),index = pd.date_range('12/14/2020', periods=5),columns = ['A', 'B', 'C', 'D'])
#窗口大小为3，min_periods 最小观测值为1
r = df.rolling(window=3,min_periods=1)
#对 A/B 两列聚合
print(r['A','B'].aggregate([np.sum,np.mean]))
```

输出结果：

1 sum mean

22020-12-14 -0.469643 -0.469643

32020-12-15 -0.626856 -0.313428

42020-12-16 -1.820226 -0.606742

52020-12-17 -2.007323 -0.669108

62020-12-18 -0.595736 -0.198579

#### 5) 对不同列应用多个函数

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(5, 4),
   index = pd.date_range('12/11/2020', periods=5),
   columns = ['A', 'B', 'C', 'D'])
r = df.rolling(window=3,min_periods=1)
print( r['A','B'].aggregate([np.sum,np.mean]))
```

输出结果：

1 A B

2 sum mean sum mean

32020-12-14 -1.428882 -1.428882 -0.417241 -0.417241

42020-12-15 -1.315151 -0.657576 -1.580616 -0.790308

52020-12-16 -2.093907 -0.697969 -2.260181 -0.753394

62020-12-17 -1.324490 -0.441497 -1.578467 -0.526156

72020-12-18 -2.400948 -0.800316 -0.452740 -0.150913

#### 6) 对不同列应用不同函数

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.randn(3, 4),
    index = pd.date_range('12/14/2020', periods=3),
    columns = ['A', 'B', 'C', 'D'])
r = df.rolling(window=3,min_periods=1)
print(r.aggregate({'A': np.sum,'B': np.mean}))
```

输出结果：

1 A B

22020-12-14 0.503535 -1.301423

32020-12-15 0.170056 -0.550289

42020-12-16 -0.086081 -0.140532
