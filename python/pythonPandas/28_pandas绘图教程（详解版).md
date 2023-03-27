Pandas 在数据分析、数据可视化方面有着较为广泛的应用，Pandas 对 Matplotlib 绘图软件包的基础上单独封装了一个plot()接口，通过调用该接口可以实现常用的绘图操作。本节我们深入讲解一下 Pandas 的绘图操作。

Pandas 之所以能够实现了数据可视化，主要利用了 Matplotlib 库的 plot() 方法，它对 plot() 方法做了简单的封装，因此您可以直接调用该接口。下面看一组简单的示例：

```
import pandas as pd
import numpy as np
#创建包含时间序列的数据
df = pd.DataFrame(np.random.randn(8,4),index=pd.date_range('2/1/2020',periods=8), columns=list('ABCD'))
df.plot()
```


如上图所示，如果行索引中包含日期，Pandas 会自动调用 gct().autofmt_xdate() 来格式化 x 轴。

除了使用默认的线条绘图外，您还可以使用其他绘图方式，如下所示：

-   柱状图：bar() 或 barh()
-   直方图：hist()
-   箱状箱：box()
-   区域图：area()
-   散点图：scatter()

通过关键字参数kind可以把上述方法传递给 plot()

### 柱状图

创建一个柱状图，如下所示：

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.rand(10,4),columns=['a','b','c','d','e'])
#或使用df.plot(kind="bar")
df.plot.bar()
```


通过设置参数stacked=True可以生成柱状堆叠图，示例如下：

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.rand(10,5),columns=['a','b','c','d','e'])
df.plot(kind="bar",stacked=True)
#或者使用df.plot.bar(stacked="True")
```


如果要绘制水平柱状图，您可以使用以下方法：

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.rand(10,4),columns=['a','b','c','d'])
print(df)
df.plot.barh(stacked=True)
```


### 直方图

plot.hist() 可以实现绘制直方图，并且它还可以指定 bins（构成直方图的箱数）。

```
import pandas as pd
import numpy as np
df = pd.DataFrame({'A':np.random.randn(100)+2,'B':np.random.randn(100),'C':
np.random.randn(100)-2}, columns=['A', 'B', 'C'])
print(df)
#指定箱数为15
df.plot.hist(bins=15)
```


给每一列数据都绘制一个直方图，需要使以下方法：

```
import pandas as pd
import numpy as np
df = pd.DataFrame({'A':np.random.randn(100)+2,'B':np.random.randn(100),'C':
np.random.randn(100)-2,'D':np.random.randn(100)+3},columns=['A', 'B', 'C','D'])
#使用diff绘制
df.diff().hist(color="r",alpha=0.5,bins=15)
```


### 箱型图

通过调用 Series.box.plot() 、DataFrame.box.plot() 或者 DataFrame.boxplot() 方法来绘制箱型图，它将每一列数据的分布情况，以可视化的图像展现出来。

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.rand(10, 4), columns=['A', 'B', 'C', 'D'])
df.plot.box()
```


### 区域图

您可以使用 Series.plot.area() 或 DataFrame.plot.area() 方法来绘制区域图。

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.rand(5, 4), columns=['a', 'b', 'c', 'd'])
df.plot.area()
```

### 散点图

使用 DataFrame.plot.scatter() 方法来绘制散点图，如下所示：

```
import pandas as pd
import numpy as np
df = pd.DataFrame(np.random.rand(30, 4), columns=['a', 'b', 'c', 'd'])
df.plot.scatter(x='a',y='b')
```


### 饼状图

饼状图可以通过 DataFrame.plot.pie() 方法来绘制。示例如下：

```
import pandas as pd
import numpy as np
df = pd.DataFrame(3 * np.random.rand(4), index=['go', 'java', 'c++', 'c'], columns=['L'])
df.plot.pie(subplots=True)
```
