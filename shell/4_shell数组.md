# 四、Shell 数组

数组中可以存放多个值。Bash Shell 只支持一维数组（不支持多维数组），初始化时不需要定义数组大小（与 PHP 类似）。

与大部分编程语言类似，数组元素的下标由0开始。

Shell 数组用括号来表示，元素用"空格"符号分割开，语法格式如下：

```
array_name=(value1 ... valuen)
```


### 实例

```
#!/bin/bash

my_array=(A B "C" D)
```


我们也可以使用下标来定义数组:

```
array_name[0]=value0
array_name[1]=value1
array_name[2]=value2
```


### 读取数组

读取数组元素值的一般格式是：

```
${array_name[index]}
```


### 实例

```
#!/bin/bash

my_array=(A B "C" D)

echo "第一个元素为: ${my_array[0]}"
echo "第二个元素为: ${my_array[1]}"
echo "第三个元素为: ${my_array[2]}"
echo "第四个元素为: ${my_array[3]}"
```


执行脚本，输出结果如下所示：

$ chmod +x test.sh
$ ./test.sh
第一个元素为: A
第二个元素为: B
第三个元素为: C
第四个元素为: D


### 获取数组中的所有元素

使用@ 或 \* 可以获取数组中的所有元素，例如：

```
#!/bin/bash

my_array[0]=A
my_array[1]=B
my_array[2]=C
my_array[3]=D

echo "数组的元素为: ${my_array[*]}"
echo "数组的元素为: ${my_array[@]}"
```


执行脚本，输出结果如下所示：

$ chmod +x test.sh
$ ./test.sh
数组的元素为: A B C D
数组的元素为: A B C D

### 获取数组的长度

获取数组长度的方法与获取字符串长度的方法相同，例如：

```
#!/bin/bash

my_array[0]=A
my_array[1]=B
my_array[2]=C
my_array[3]=D

echo "数组元素个数为: ${#my_array[*]}"
echo "数组元素个数为: ${#my_array[@]}"
```


执行脚本，输出结果如下所示：

$ chmod +x test.sh
$ ./test.sh
数组元素个数为: 4
数组元素个数为: 4
