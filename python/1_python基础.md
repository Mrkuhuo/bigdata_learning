# 一、什么是 Python？

Python 是一门流行的编程语言。它由 Guido van Rossum 创建，于 1991 年发布。
它用于：

* Web 开发（服务器端）
* 软件开发
* 数学
* 系统脚本

### Python 可以做什么？
* 可以在服务器上使用 Python 来创建 Web 应用程序。
* Python 可以与软件一起使用来创建工作流。
* Python 可以连接到数据库系统。它还可以读取和修改文件。
* Python 可用于处理大数据并执行复杂的数学运算。
* Python 可用于快速原型设计，也可用于生产就绪的软件开发。

### 为何选择 Python？

* Python 适用于不同的平台（Windows、Mac、Linux、Raspberry Pi 等）。
* Python 有一种类似于英语的简单语法。
* Python 的语法允许开发人员用比其他编程语言更少的代码行编写程序。
* Python 在解释器系统上运行，这意味着代码可以在编写后立即执行。这也意味着原型设计可以非常快。
* Python 可以以程序方式、面向对象的方式或功能方式来处理。

### Python 语法与其他编程语言比较

* Python 是为可读性设计的，与英语有一些相似之处，并受到数学的影响。
* Python 使用新行来完成命令，而不像通常使用分号或括号的其他编程语言。
* Python 依赖缩进，使用空格来定义范围；例如循环、函数和类的范围。其他编程语言通常使用花括号来实现此目的。

# 二、Python 快速入门

Python 是一门解释型编程语言，这意味着作为开发人员，您可以在文本编辑器中编写 Python（.py）文件，然后将这些文件放入 python 解释器中执行。

让我们在juypter中 编写第一个 Python 文件，它可以在任何文本编辑器中完成。
```
print("Hello, World!")
```

Hello, World!

# 三、Python 缩进

缩进指的是代码行开头的空格。

在其他编程语言中，代码缩进仅出于可读性的考虑，而 Python 中的缩进非常重要。

Python 使用缩进来指示代码块。
```
if 5 > 2:    
    print("Five is greater than two!")
```

Five is greater than two!

如果省略缩进，Python 会出错
```
if 5 > 2:
print("Five is greater than two!")
```

File "C:\Users\kuhuo\AppData\Local\Temp\ipykernel_27696\3793329317.py", line 2
print("Five is greater than two!")
IndentationError: expected an indented block

空格数取决于程序员，但至少需要一个。
```
if 5 > 2:
 print("Five is greater than two!")  
if 5 > 2:
        print("Five is greater than two!") 
```

Five is greater than two!
Five is greater than two!

您必须在同一代码块中使用相同数量的空格，否则 Python 会出错：

```
if 5 > 2:
 print("Five is greater than two!") 
        print("Five is greater than two!")
```

File "C:\Users\kuhuo\AppData\Local\Temp\ipykernel_27696\3772748168.py", line 3
print("Five is greater than two!")
IndentationError: unexpected indent
### Python 变量

在 Python 中，变量是在为其赋值时创建的：
```
x = 5
y = "Hello, World!"
```
Python 没有声明变量的命令。
### 注释

Python 拥有对文档内代码进行注释的功能。
注释以 ＃ 开头，Python 将其余部分作为注释呈现：
Python 中的注释：
```
#This is a comment.
print("Hello, World!")
```

# 四、python注释

注释可用于解释 Python 代码。
注释可用于提高代码的可读性。
在测试代码时，可以使用注释来阻止执行。
### 创建注释

注释以 ＃ 开头，Python 将忽略它们：
```
#This is a comment
print("Hello, World!")
```

注释可以放在一行的末尾，Python 将忽略该行的其余部分：
```
print("Hello, World!") #This is a comment
```

注释不必是解释代码的文本，它也可以用来阻止 Python 执行代码：
```
#print("Hello, World!")
print("Cheers, Mate!")
```

### 多行注释

Python 实际上没有多行注释的语法。
要添加多行注释，您可以为每行插入一个 ＃
```
#This is a comment
#written in
#more than just one line
print("Hello, World!")
```

或者，以不完全符合预期的方式，您可以使用多行字符串。
由于 Python 将忽略未分配给变量的字符串文字，因此您可以在代码中添加多行字符串（三引号），并在其中添加注释：
```
"""
This is a comment
written in 
more than just one line
"""
print("Hello, World!")
```

只要字符串未分配给变量，Python 就会读取代码，然后忽略它，这样您就已经完成了多行注释。

# 五、创建变量

变量是存放数据值的容器。
与其他编程语言不同，Python 没有声明变量的命令。
首次为其赋值时，才会创建变量。
```
x = 10
y = "Bill"
print(x)
print(y)
```

Bill

变量不需要使用任何特定类型声明，甚至可以在设置后更改其类型。
```
x = 5 # x is of type int
x = "Steve" # x is now of type str
print(x)
```

Steve

字符串变量可以使用单引号或双引号进行声明：
```
x = "Bill"
print(x)
# is the same as
x = 'Bill'
print(x)
```

Bill
Bill
### 变量名称

变量可以使用短名称（如 x 和 y）或更具描述性的名称（age、carname、total_volume）。
Python 变量命名规则：

* 变量名必须以字母或下划线字符开头
* 变量名称不能以数字开头
* 变量名只能包含字母数字字符和下划线（A-z、0-9 和 _）
*  变量名称区分大小写（age、Age 和 AGE 是三个不同的变量）

变量名称区分大小写（age、Age 和 AGE 是三个不同的变量）
### 向多个变量赋值

Python 允许您在一行中为多个变量赋值：
```
x, y, z = "Orange", "Banana", "Cherry"
print(x)
print(y)
print(z)
```

Orange
Banana
Cherry

您可以在一行中为多个变量分配相同的值：
```
x = y = z = "Orange"
print(x)
print(y)
print(z)
```

Orange
Orange
Orange

### 输出变量

Python 的 print 语句通常用于输出变量。
如需结合文本和变量，Python 使用 + 字符：
```
x = "awesome"
print("Python is " + x)
```

Python is awesome

您还可以使用 + 字符将变量与另一个变量相加：
```
x = "Python is "
y = "awesome"
z =  x + y
print(z)
```

Python is awesome

对于数字，+ 字符用作数学运算符：
```
x = 5
y = 10
print(x + y)
```

15

如果您尝试组合字符串和数字，Python 会给出错误：
```
x = 10
y = "Bill"
print(x + y)
```

TypeError Traceback (most recent call last)~\AppData\Local\Temp\ipykernel_27696\3166262691.py in <module>1 x = 102 y = "Bill"----> 3 print(x + y)TypeError: unsupported operand type(s) for +: 'int' and 'str'
### 全局变量

在函数外部创建的变量（如上述所有实例所示）称为全局变量。
全局变量可以被函数内部和外部的每个人使用。
在函数外部创建变量，并在函数内部使用它：
```
x = "awesome"

def myfunc():
  print("Python is " + x)

myfunc()
```

Python is awesome

如果在函数内部创建具有相同名称的变量，则该变量将是局部变量，并且只能在函数内部使用。具有相同名称的全局变量将保留原样，并拥有原始值。
在函数内部创建一个与全局变量同名的变量：
```
x = "awesome"

def myfunc():
  x = "fantastic"
  print("Python is " + x)

myfunc()

print("Python is " + x)
```

Python is fantastic
Python is awesome

### global 关键字

通常，在函数内部创建变量时，该变量是局部变量，只能在该函数内部使用。
要在函数内部创建全局变量，您可以使用 global 关键字。
如果您用了 global 关键字，则该变量属于全局范围：
```
def myfunc():
  global x
  x = "fantastic"

myfunc()

print("Python is " + x)
```

Python is fantastic

另外，如果要在函数内部更改全局变量，请使用 global 关键字。
要在函数内部更改全局变量的值，请使用 global 关键字引用该变量：
```
x = "awesome"

def myfunc():
  global x
  x = "fantastic"

myfunc()

print("Python is " + x)
```
Python is fantastic

# 六、内置数据类型

在编程中，数据类型是一个重要的概念。
变量可以存储不同类型的数据，并且不同类型可以执行不同的操作。
在这些类别中，Python 默认拥有以下内置数据类型：

文本类型：str

数值类型：int, float, complex

序列类型：list, tuple, range

映射类型：dict

集合类型：set, frozenset

布尔类型：bool

二进制类型：bytes, bytearray, memoryview
### 获取数据类型

您可以使用 type() 函数获取任何对象的数据类型：
```
x = 10
print(type(x))
```
<class 'int'>
### 设置数据类型

在 Python 中，当您为变量赋值时，会设置数据类型：

x = "Hello World" str

x = 29 int

x = 29.5 float

x = 1 jcomplex

x = ["apple", "banana", "cherry"] list

x = ("apple", "banana", "cherry") tuple

x = range(6) range

x = {"name" : "Bill", "age" : 63} dict

x = {"apple", "banana", "cherry"} set

x = frozenset({"apple", "banana", "cherry"}) frozenset

x = True bool

x = b"Hello" bytes

x = bytearray(5) bytearray

x = memoryview(bytes(5)) memoryview
### 设定特定的数据类型

如果希望指定数据类型，则您可以使用以下构造函数：

x = str("Hello World")  str

x = int(29) int

x = float(29.5) float

x = complex(1j) complex

x = list(("apple", "banana", "cherry")) list

x = tuple(("apple", "banana", "cherry")) tuple

x = range(6) range

x = dict(name="Bill", age=36) dict

x = set(("apple", "banana", "cherry")) set

x = frozenset(("apple", "banana", "cherry")) frozenset

x = bool(5) bool

x = bytes(5) bytes

x = bytearray(5) bytearray

x = memoryview(bytes(5) )memoryview

# 七、Python 数字

Python 中有三种数字类型：

* int
* float
* complex

为变量赋值时，将创建数值类型的变量：
```
x = 10   # int
y = 6.3  # float
z = 2j   # complex
print(x)
print(y)
print(z)
```

10
6.3
2j

### Int

Int 或整数是完整的数字，正数或负数，没有小数，长度不限。
```
x = 10
y = 37216654545182186317
z = -465167846
```
### Float

浮动或“浮点数”是包含小数的正数或负数。
```
x = 3.50
y = 2.0
z = -63.78
```
浮点数也可以是带有“e”的科学数字，表示 10 的幂。
```
x = 27e4
y = 15E2
z = -49.8e100
```

### 复数

复数用 "j" 作为虚部编写：
```
x = 2+3j
y = 7j
z = -7j
```
### 类型转换
您可以使用 int()、float() 和 complex() 方法从一种类型转换为另一种类型：
```
x = 10 # int
y = 6.3 # float
z = 1j # complex

# 把整数转换为浮点数

a = float(x)

# 把浮点数转换为整数

b = int(y)

# 把整数转换为复数：

c = complex(x)
print(a)
print(b)
print(c)

print(type(a))
print(type(b))
print(type(c))
```

10.0
6
(10+0j)
<class 'float'>
<class 'int'>
<class 'complex'>

注意：您无法将复数转换为其他数字类型。

# 八、字符串字面量

python 中的字符串字面量由单引号或双引号括起。

'hello' 等同于 "hello"。

您可以使用 print() 函数显示字符串字面量：
```
print("Hello")
print('Hello')
```

Hello
Hello
### 用字符串向变量赋值

通过使用变量名称后跟等号和字符串，可以把字符串赋值给变量：
```
a = "Hello"
print(a)
```

Hello
### 多行字符串

您可以使用三个引号将多行字符串赋值给变量：
```
a = """Python is a widely used general-purpose, high level programming language. 
It was initially designed by Guido van Rossum in 1991 
and developed by Python Software Foundation. 
It was mainly developed for emphasis on code readability, 
and its syntax allows programmers to express concepts in fewer lines of code."""
print(a)
```

Python is a widely used general-purpose, high level programming language
It was initially designed by Guido van Rossum in 1991
and developed by Python Software Foundation
It was mainly developed for emphasis on code readability
and its syntax allows programmers to express concepts in fewer lines of code

或三个单引号：
```
a = '''Python is a widely used general-purpose, high level programming language. 
It was initially designed by Guido van Rossum in 1991 
and developed by Python Software Foundation. 
It was mainly developed for emphasis on code readability, 
and its syntax allows programmers to express concepts in fewer lines of code.'''
print(a)
```
Python is a widely used general-purpose, high level programming language
It was initially designed by Guido van Rossum in 1991
and developed by Python Software Foundation
It was mainly developed for emphasis on code readability
and its syntax allows programmers to express concepts in fewer lines of code

**注意：在结果中，换行符插入与代码中相同的位置。**

### 字符串是数组

像许多其他流行的编程语言一样，Python 中的字符串是表示 unicode 字符的字节数组。

但是，Python 没有字符数据类型，单个字符就是长度为 1 的字符串。

方括号可用于访问字符串的元素。

获取位置 1 处的字符（请记住第一个字符的位置为 0）：
```
a = "Hello, World!"
print(a[1])
```

e

### 裁切

您可以使用裁切语法返回一定范围的字符。

指定开始索引和结束索引，以冒号分隔，以返回字符串的一部分。

获取从位置 2 到位置 5（不包括）的字符：
```
b = "Hello, World!"
print(b[2:5])
```
orl
### 字符串长度

如需获取字符串的长度，请使用 len() 函数。
```
a = "Hello, World!"
print(len(a))
```
13

### 字符串方法

Python 有一组可用于字符串的内置方法。
strip() 方法删除开头和结尾的空白字符：
```
a = " Hello, World! "
print(a.strip()) # returns "Hello, World!"
```
Hello, World!

lower() 返回小写的字符串：
```
a = "Hello, World!"
print(a.lower())
```
hello, world!
upper() 方法返回大写的字符串：
```
a = "Hello, World!"
print(a.upper())
```
HELLO, WORLD!

replace() 用另一段字符串来替换字符串：
```
a = "Hello, World!"
print(a.replace("World", "Kitty"))
```
Hello, Kitty!

split() 方法在找到分隔符的实例时将字符串拆分为子字符串：
```
a = "Hello, World!"
print(a.split(",")) # returns ['Hello', ' World!']
```
['Hello', ' World!']

### 检查字符串

如需检查字符串中是否存在特定短语或字符，我们可以使用 in 或 not in 关键字。
```
txt = "China is a great country"
x = "ina" in txt
print(x)
```
True
```
txt = "China is a great country"
x = "ain" not in txt
print(x) 
```
True

### 字符串级联（串联）

如需串联或组合两个字符串，您可以使用 + 运算符。
将变量 a 与变量 b 合并到变量 c 中：
```
a = "Hello"
b = "World"
c = a + b
print(c)
```

HelloWorld

### 字符串格式

正如在 Python 变量一章中所学到的，我们不能像这样组合字符串和数字：
```
age = 63
txt = "My name is Bill, I am " + age
print(txt)
```

TypeError Traceback (most recent call last)
~\AppData\Local\Temp\ipykernel_27696\358233695.py in <module>
1 age = 63
----> 2 txt = "My name is Bill, I am " + age3
print(txt)
TypeError: can only concatenate str (not "int") to str

但是我们可以使用 format() 方法组合字符串和数字！
format() 方法接受传递的参数，格式化它们，并将它们放在占位符 {} 所在的字符串中：
使用 format() 方法将数字插入字符串：
```
age = 63 
txt = "My name is Bill, and I am {}"
print(txt.format(age))
```

My name is Bill, and I am 63

format() 方法接受不限数量的参数，并放在各自的占位符中：
```
quantity = 3
itemno = 567
price = 49.95
myorder = "I want {} pieces of item {} for {} dollars."
print(myorder.format(quantity, itemno, price))
```

I want 3 pieces of item 567 for 49.95 dollars.

您可以使用索引号 {0} 来确保参数被放在正确的占位符中：
```
quantity = 3
itemno = 567
price = 49.95
myorder = "I want to pay {2} dollars for {0} pieces of item {1}."
print(myorder.format(quantity, itemno, price))
```

I want to pay 49.95 dollars for 3 pieces of item 567.
### 字符串方法

Python 有一组可以在字符串上使用的内建方法。
注释：所有字符串方法都返回新值。它们不会更改原始字符串。

| 方法                                     | 描述                                               |
|-----------------------------------------|----------------------------------------------------|
| capitalize() | 把首字符转换为大写。                               |
| casefold() | 把字符串转换为小写。                               |
| center() | 返回居中的字符串。                                 |
| count() | 返回指定值在字符串中出现的次数。                   |
| encode() | 返回字符串的编码版本。                             |
| endswith() | 如果字符串以指定值结尾，则返回 true。              |
| expandtabs() | 设置字符串的 tab 尺寸。                            |
| find()  | 在字符串中搜索指定的值并返回它被找到的位置。       |
| format() | 格式化字符串中的指定值。                           |
| format_map()                            | 格式化字符串中的指定值。                           |
| index() | 在字符串中搜索指定的值并返回它被找到的位置。       |
| isalnum() | 如果字符串中的所有字符都是字母数字，则返回 True。  |
| isalpha() | 如果字符串中的所有字符都在字母表中，则返回 True。  |
| isdecimal() | 如果字符串中的所有字符都是小数，则返回 True。      |
| isdigit() | 如果字符串中的所有字符都是数字，则返回 True。      |
| isidentifier() | 如果字符串是标识符，则返回 True。                  |
| islower() | 如果字符串中的所有字符都是小写，则返回 True。      |
| isnumeric() | 如果字符串中的所有字符都是数，则返回 True。        |
| isprintable() | 如果字符串中的所有字符都是可打印的，则返回 True。  |
| isspace() | 如果字符串中的所有字符都是空白字符，则返回 True。  |
| istitle() | 如果字符串遵循标题规则，则返回 True。              |
| isupper() | 如果字符串中的所有字符都是大写，则返回 True。      |
| join()  | 把可迭代对象的元素连接到字符串的末尾。             |
| ljust() | 返回字符串的左对齐版本。                           |
| lower() | 把字符串转换为小写。                               |
| lstrip() | 返回字符串的左修剪版本。                           |
| maketrans()                             | 返回在转换中使用的转换表。                         |
| partition() | 返回元组，其中的字符串被分为三部分。               |
| replace() | 返回字符串，其中指定的值被替换为指定的值。         |
| rfind() | 在字符串中搜索指定的值，并返回它被找到的最后位置。 |
| rindex() | 在字符串中搜索指定的值，并返回它被找到的最后位置。 |
| rjust() | 返回字符串的右对齐版本。                           |
| rpartition() | 返回元组，其中字符串分为三部分。                   |
| rsplit() | 在指定的分隔符处拆分字符串，并返回列表。           |
| rstrip() | 返回字符串的右边修剪版本。                         |
| split() | 在指定的分隔符处拆分字符串，并返回列表。           |
| splitlines() | 在换行符处拆分字符串并返回列表。                   |
| startswith() | 如果以指定值开头的字符串，则返回 true。            |
| strip() | 返回字符串的剪裁版本。                             |
| swapcase() | 切换大小写，小写成为大写，反之亦然。               |
| title() | 把每个单词的首字符转换为大写。                     |
| translate()                             | 返回被转换的字符串。                               |
| upper() | 把字符串转换为大写。                               |
| zfill() | 在字符串的开头填充指定数量的 0 值。                |

# 九、布尔值

**布尔表示两值之一：True 或 False。**

在编程中，您通常需要知道表达式是 True 还是 False。
您可以计算 Python 中的任何表达式，并获得两个答案之一，即 True 或 False。
比较两个值时，将对表达式求值，Python 返回布尔值答案：
```
print(8 > 7)
print(8 == 7)
print(8 < 7)
```

True
False
False

当在 if 语句中运行条件时，Python 返回 True 或 False：
```
a = 200
b = 33

if b > a:
  print("b is greater than a")
else:
  print("b is not greater than a")
```

b is not greater than a
### 评估值和变量

bool() 函数可让您评估任何值，并为您返回 True 或 False。
```
print(bool("Hello"))
print(bool(10))
```

True
True

### 大多数值都为 True

如果有某种内容，则几乎所有值都将评估为 True。
除空字符串外，任何字符串均为 True。
除 0 外，任何数字均为 True。
除空列表外，任何列表、元组、集合和字典均为 True。
### 某些值为 False

实际上，除空值（例如 ()、[]、{}、""、数字 0 和值 None）外，没有多少值会被评估为 False。当然，值 False 的计算结果为 False。
```
bool(False)
bool(None)
bool(0)
bool("")
bool(())
bool([])
bool({})
```

False

# 十、Python 运算符

运算符用于对变量和值执行操作。
Python 在以下组中划分运算符：

* 算术运算符
* 赋值运算符
* 比较运算符
* 逻辑运算符
* 身份运算符
* 成员运算符


### Python 算术运算符

算术运算符与数值一起使用来执行常见的数学运算：
| 运算符 | 名称             | 实例     |
|--------|------------------|----------|
| +      | 加               | x + y    |
| -      | 减               | x - y    |
| \*     | 乘               | x \* y   |
| /      | 除               | x / y    |
| %      | 取模             | x % y    |
| \*\*   | 幂               | x \*\* y |
| //     | 地板除（取整除） | x // y   |
```
x = 5
y = 3

print(x + y)
```

8
```
x = 5
y = 3

print(x - y)
```
2
```
x = 5
y = 3

print(x * y)
```
15
```
x = 15
y = 3

print(x / y)
```
5.0
```
x = 5
y = 2

print(x % y)
```
1
```
x = 2
y = 5

print(x ** y) #same as 2*2*2*2*2
```
32
```
x = 15
y = 2

print(x // y)

#the floor division // rounds the result down to the nearest whole number
```
7

### python赋值运算符

赋值运算符用于为变量赋值：
| 运算符 | 实例      | 等同于       |
|--------|-----------|--------------|
| =      | x = 5     | x = 5        |
| +=     | x += 3    | x = x + 3    |
| -=     | x -= 3    | x = x - 3    |
| \*=    | x \*= 3   | x = x \* 3   |
| /=     | x /= 3    | x = x / 3    |
| %=     | x %= 3    | x = x % 3    |
| //=    | x //= 3   | x = x // 3   |
| \*\*=  | x \*\*= 3 | x = x \*\* 3 |

```
x = 5
print(x)
```
5
```
x = 5
x += 3
print(x)
```
8
```
x = 5
x -= 3
print(x)
```
2
```
x = 5
x *= 3
print(x)
```
15
```
x = 5
x /= 3
print(x)
```

1.6666666666666667
```
x = 5
x%=3
print(x)
```
2
```
x = 5
x//=3
print(x)
```
1
```
x = 5
x **= 3
print(x)
```

125
### Python 比较运算符

比较运算符用于比较两个值：
| 运算符 | 名称       | 实例    |
|--------|------------|---------|
| ==     | 等于       | x == y  |
| !=     | 不等于     | x != y  |
| \>     | 大于       | x \> y  |
| \<     | 小于       | x \< y  |
| \>=    | 大于或等于 | x \>= y |
| \<=    | 小于或等于 | x \<= y |
```
x = 5
y = 3
print(x == y)
# returns False because 5 is not equal to 3
```

False
```
x = 5
y = 3
print(x != y)
# returns True because 5 is not equal to 3
```

True
```
x = 5
y = 3
print(x > y)
# returns True because 5 is greater than 3
```

True
```
x = 5
y = 3
print(x < y)
# returns False because 5 is not less than 3
```

False
```
x = 5
y = 3
print(x >= y)
# returns True because five is greater, or equal, to 3
```

True
```
x = 5
y = 3
print(x <= y)
# returns False because 5 is neither less than or equal to 3
```

False

### python逻辑运算符

逻辑运算符用于组合条件语句：
| 运算符 | 描述                                    | 实例                    |
|--------|-----------------------------------------|-------------------------|
| and    | 如果两个语句都为真，则返回 True。       | x \> 3 and x \< 10      |
| or     | 如果其中一个语句为真，则返回 True。     | x \> 3 or x \< 4        |
| not    | 反转结果，如果结果为 true，则返回 False | not(x \> 3 and x \< 10) |
```
x = 5
print(x > 3 and x < 10)
# returns True because 5 is greater than 3 AND 5 is less than 10
```

True
```
x = 5
print(x > 3 or x < 4)
# returns True because one of the conditions are true (5 is greater than 3, but 5 is not less than 4)
```

True
```
x = 5
print(not(x > 3 and x < 10))
# returns False because not is used to reverse the result
```

False
### Python 身份运算符

身份运算符用于比较对象，不是比较它们是否相等，但如果它们实际上是同一个对象，则具有相同的内存位置：
| 运算符 | 描述                                      | 实例       |
|--------|-------------------------------------------|------------|
| is     | 如果两个变量是同一个对象，则返回 true。   | x is y     |
| is not | 如果两个变量不是同一个对象，则返回 true。 | x is not y |
```
x = ["apple", "banana"]
y = ["apple", "banana"]
z = x
print(x is z)
# returns True because z is the same object as x
print(x is y)
# returns False because x is not the same object as y, even if they have the same content
print(x == y)
# to demonstrate the difference betweeen "is" and "==": this comparison returns True because x is equal to y
```

True
False
True
```
x = ["apple", "banana"]
y = ["apple", "banana"]
z = x
print(x is not z)
# returns False because z is the same object as x
print(x is not y)
# returns True because x is not the same object as y, even if they have the same content
print(x != y)
# to demonstrate the difference betweeen "is not" and "!=": this comparison returns False because x is equal to y
```

False
True
False
### Python 成员运算符

成员资格运算符用于测试序列是否在对象中出现：
| 运算符 | 描述                                            | 实例       |
|--------|-------------------------------------------------|------------|
| in     | 如果对象中存在具有指定值的序列，则返回 True。   | x in y     |
| not in | 如果对象中不存在具有指定值的序列，则返回 True。 | x not in y |
```
x = ["apple", "banana"]

print("banana" in x)
# returns True because a sequence with the value "banana" is in the list
```

True
```
x = ["apple", "banana"]
print("pineapple" not in x)
# returns True because a sequence with the value "pineapple" is not in the list
```

True

# 十一、Python 集合（数组）

Python 编程语言中有四种集合数据类型：
* 列表（List）是一种有序和可更改的集合。允许重复的成员。
* 元组（Tuple）是一种有序且不可更改的集合。允许重复的成员。
* 集合（Set）是一个无序和无索引的集合。没有重复的成员。
* 典（Dictionary）是一个无序，可变和有索引的集合。没有重复的成员。

选择集合类型时，了解该类型的属性很有用。

为特定数据集选择正确的类型可能意味着保留含义，并且可能意味着提高效率或安全性。
### 列表

列表是一个有序且可更改的集合。在 Python 中，列表用方括号编写。

创建列表：
```
thislist = ["apple", "banana", "cherry"]
print(thislist)
```

['apple', 'banana', 'cherry']

### 访问项目

您可以通过引用索引号来访问列表项：

打印列表的第二项：
```
thislist = ["apple", "banana", "cherry"]
print(thislist[1])
```

banana
### 负的索引

负索引表示从末尾开始，-1 表示最后一个项目，-2 表示倒数第二个项目，依此类推。

打印列表的最后一项：
```
thislist = ["apple", "banana", "cherry"]
print(thislist[-1])
```

cherry
### 索引范围

您可以通过指定范围的起点和终点来指定索引范围。

指定范围后，返回值将是包含指定项目的新列表。

返回第三、第四、第五项：
```
thislist = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(thislist[2:5])
```

['cherry', 'orange', 'kiwi']


**注意：搜索将从索引 2（包括）开始，到索引 5（不包括）结束。请记住，第一项的索引为 0。**
### 负索引的范围

如果要从列表末尾开始搜索，请指定负索引：

此例将返回从索引 -4（包括）到索引 -1（排除）的项目：
```
thislist = ["apple", "banana", "cherry", "orange", "kiwi", "melon", "mango"]
print(thislist[-4:-1])
```

['orange', 'kiwi', 'melon']

### 更改项目值

如需更改特定项目的值，请引用索引号：
```
thislist = ["apple", "banana", "cherry"]
thislist[1] = "mango"
print(thislist)
```

['apple', 'mango', 'cherry']

### 遍历列表

您可以使用 for 循环遍历列表项：

逐个打印列表中的所有项目：
```
thislist = ["apple", "banana", "cherry"]
for x in thislist:
  print(x)
```

apple
banana
cherry
### 检查项目是否存在

如需确定列表中是否存在指定的项，请使用 in 关键字：

检查列表中是否存在 “apple”：
```
thislist = ["apple", "banana", "cherry"]
if "apple" in thislist:
  print("Yes, 'apple' is in the fruits list")
```

Yes, 'apple' is in the fruits list

### 列表长度

如需确定列表中有多少项，请使用 len() 方法：

打印列表中的项目数：
```
thislist = ["apple", "banana", "cherry"]
print(len(thislist))
```
3
### 添加项目

如需将项目添加到列表的末尾，请使用 append() 方法：
```
thislist = ["apple", "banana", "cherry"]
thislist.append("orange")
print(thislist)
```

['apple', 'banana', 'cherry', 'orange']


要在指定的索引处添加项目，请使用 insert() 方法：
```
thislist = ["apple", "banana", "cherry"]
thislist.insert(1, "orange")
print(thislist)
```

['apple', 'orange', 'banana', 'cherry']

### 删除项目

有几种方法可以从列表中删除项目：

remove() 方法删除指定的项目：

```
thislist = ["apple", "banana", "cherry"]
thislist.remove("banana")
print(thislist)
```

['apple', 'cherry']


pop() 方法删除指定的索引（如果未指定索引，则删除最后一项）：
```
thislist = ["apple", "banana", "cherry"]
thislist.pop()
print(thislist)
```

['apple', 'banana']


del 关键字删除指定的索引：

```
thislist = ["apple", "banana", "cherry"]
del thislist[0]
print(thislist)
```

['banana', 'cherry']


del 关键字也能完整地删除列表：
```
thislist = ["apple", "banana", "cherry"]
del thislist
print(thislist)
```

NameError Traceback (most recent call last)~\AppData\Local\Temp\ipykernel_27696\3386762020.py in <module>1 thislist = ["apple", "banana", "cherry"]2 del thislist----> 3 print(thislist)NameError: name 'thislist' is not defined

clear() 方法清空列表：
```
thislist = ["apple", "banana", "cherry"]
thislist.clear()
print(thislist)
```

[]

### 复制列表

您只能通过键入 list2 = list1 （浅拷贝）来复制列表，因为：list2 将只是对 list1 的引用，list1 中所做的更改也将自动在 list2 中进行。

有一些方法可以进行复制，一种方法是使用内置的 List 方法 copy()（深拷贝）。

使用 copy() 方法来复制列表：
```
thislist = ["apple", "banana", "cherry"]
mylist = thislist.copy()
print(mylist)
```

['apple', 'banana', 'cherry']


使用 list() （深拷贝）方法复制列表：
```
thislist = ["apple", "banana", "cherry"]
mylist = list(thislist)
print(mylist)
```
### 合并两个列表

在 Python 中，有几种方法可以连接或串联两个或多个列表。

最简单的方法之一是使用 + 运算符。

合并两个列表：

```
list1 = ["a", "b" , "c"]
list2 = [1, 2, 3]
list3 = list1 + list2
print(list3)
```

['a', 'b', 'c', 1, 2, 3]


连接两个列表的另一种方法是将 list2 中的所有项一个接一个地追加到 list1 中：

把 list2 追加到 list1 中：
```
list1 = ["a", "b" , "c"]
list2 = [1, 2, 3]
for x in list2:
  list1.append(x)
print(list1)
```

['a', 'b', 'c', 1, 2, 3]


或者，您可以使用 extend() 方法，其目的是将一个列表中的元素添加到另一列表中：

使用 extend() 方法将 list2 添加到 list1 的末尾：
```
list1 = ["a", "b" , "c"]
list2 = [1, 2, 3]
list1.extend(list2)
print(list1)
```

['a', 'b', 'c', 1, 2, 3]
### list() 构造函数

也可以使用 list() 构造函数创建一个新列表。

使用 list() 构造函数创建列表：
```
thislist = list(("apple", "banana", "cherry")) # 请注意双括号
print(thislist)
```

['apple', 'banana', 'cherry']

### 列表方法

Python 有一组可以在列表上使用的内建方法。
| 方法      | 描述                                                 |
|-----------|------------------------------------------------------|
| append()  | 在列表的末尾添加一个元素                             |
| clear()   | 删除列表中的所有元素                                 |
| copy()    | 返回列表的副本                                       |
| count()   | 返回具有指定值的元素数量。                           |
| extend()  | 将列表元素（或任何可迭代的元素）添加到当前列表的末尾 |
| index()   | 返回具有指定值的第一个元素的索引                     |
| insert()  | 在指定位置添加元素                                   |
| pop()     | 删除指定位置的元素                                   |
| remove()  | 删除具有指定值的项目                                 |
| reverse() | 颠倒列表的顺序                                       |
| sort()    | 对列表进行排序                                       |
向 fruits 列表添加元素：
```
fruits = ['apple', 'banana', 'cherry']
fruits.append("orange")
print(fruits)
```

['apple', 'banana', 'cherry', 'orange']


从 fruits 列表删除所有元素：

```
fruits = ['apple', 'banana', 'cherry', 'orange']
fruits.clear()
print(fruits)
```

[]

拷贝 fruits 列表：
```
fruits = ['apple', 'banana', 'cherry', 'orange']
x = fruits.copy()
print(x)
```

['apple', 'banana', 'cherry', 'orange']


返回 "cherry" 在 fruits 列表中出现的次数：

```
fruits = ['apple', 'banana', 'cherry']
x = fruits.count("cherry")
print(x)
```
1

把 cars 中的元素添加到 fruits 列表：
```
fruits = ['apple', 'banana', 'cherry']
cars = ['Porsche', 'BMW', 'Volvo']
fruits.extend(cars)
print(fruits)
```

['apple', 'banana', 'cherry', 'Porsche', 'BMW', 'Volvo']


值 "cherry" 的位置是：
```
fruits = ['apple', 'banana', 'cherry']
x = fruits.index("cherry")
print(x)
```
2

把值 "orange" 作为第二个元素插入 fruits 列表：
```
fruits = ['apple', 'banana', 'cherry']
fruits.insert(1, "orange")
print(fruits)
```

['apple', 'orange', 'banana', 'cherry']


删除 fruits 列表的第二个元素：
```
fruits = ['apple', 'banana', 'cherry']
fruits.pop(1)
print(fruits)
```

['apple', 'cherry']


删除 fruits 列表的 "banana" 元素：
```
fruits = ['apple', 'banana', 'cherry']
fruits.remove("banana")
print(fruits)
```

['apple', 'cherry']


反转 fruits 列表的顺序：
```
fruits = ['apple', 'banana', 'cherry']
fruits.reverse()
print(fruits)
```

['cherry', 'banana', 'apple']


以字母顺序对列表进行排序：
```
cars = ['Porsche', 'BMW', 'Volvo']
cars.sort()
print(cars)
```

['BMW', 'Porsche', 'Volvo']

# 十二、元组（Tuple）

元组是有序且不可更改的集合。在 Python 中，元组是用圆括号编写的。

创建元组：
```
thistuple = ("apple", "banana", "cherry")
print(thistuple)
```

('apple', 'banana', 'cherry')
### 访问元组项目

您可以通过引用方括号内的索引号来访问元组项目：

打印元组中的第二个项目：
```
thistuple = ("apple", "banana", "cherry")
print(thistuple[1])
```

banana
### 负索引

负索引表示从末尾开始，-1 表示最后一个项目，-2 表示倒数第二个项目，依此类推。

打印元组的最后一个项目：

```
thistuple = ("apple", "banana", "cherry")
print(thistuple[-1])
```

cherry
### 索引范围

您可以通过指定范围的起点和终点来指定索引范围。

指定范围后，返回值将是带有指定项目的新元组。

返回第三、第四、第五个项目：
```
thistuple = ("apple", "banana", "cherry", "orange", "kiwi", "melon", "mango")
print(thistuple[2:5])
```

('cherry', 'orange', 'kiwi')


**注意：搜索将从索引 2（包括）开始，到索引 5（不包括）结束。请记住，第一项的索引为 0。**
### 负索引范围

如果要从元组的末尾开始搜索，请指定负索引：

此例将返回从索引 -4（包括）到索引 -1（排除）的项目：

```
thistuple = ("apple", "banana", "cherry", "orange", "kiwi", "melon", "mango")
print(thistuple[-4:-1])
```
('orange', 'kiwi', 'melon')
### 更改元组值

创建元组后，您将无法更改其值。元组是不可变的，或者也称为恒定的。

但是有一种解决方法。您可以将元组转换为列表，更改列表，然后将列表转换回元组。

把元组转换为列表即可进行更改：

```
x = ("apple", "banana", "cherry")
y = list(x)
y[1] = "kiwi"
x = tuple(y)

print(x)
```

('apple', 'kiwi', 'cherry')

### 遍历元组

您可以使用 for 循环遍历元组项目。

遍历项目并打印值：

```
thistuple = ("apple", "banana", "cherry")
for x in thistuple:
  print(x)
```

apple
banana
cherry
### 检查项目是否存在

要确定元组中是否存在指定的项，请使用 in 关键字：

检查元组中是否存在 "apple"：

```
thistuple = ("apple", "banana", "cherry")
if "apple" in thistuple:
  print("Yes, 'apple' is in the fruits tuple")
```

Yes, 'apple' is in the fruits tuple

### 元组长度

要确定元组有多少项，请使用 len() 方法：

打印元组中的项目数量：
```
thistuple = ("apple", "banana", "cherry")
print(len(thistuple))
```
3
### 添加项目

元组一旦创建，您就无法向其添加项目。元组是不可改变的。

您无法向元组添加项目：

```
thistuple = ("apple", "banana", "cherry")
thistuple[3] = "orange" # 会引发错误
print(thistuple)
```

TypeError Traceback (most recent call last)~\AppData\Local\Temp\ipykernel_27696\3823058999.py in <module>1 thistuple = ("apple", "banana", "cherry")----> 2 thistuple[3] = "orange" # 会引发错误3 print(thistuple)TypeError: 'tuple' object does not support item assignment
### 创建有一个项目的元组

如需创建仅包含一个项目的元组，您必须在该项目后添加一个逗号，否则 Python 无法将变量识别为元组。

单项元组，别忘了逗号：
```
thistuple = ("apple",)
print(type(thistuple))

#不是元组
thistuple = ("apple")
print(type(thistuple))
```

<class 'tuple'>
<class 'str'>
### 删除项目

注释：您无法删除元组中的项目。

元组是不可更改的，因此您无法从中删除项目，但您可以完全删除元组：

del 关键字可以完全删除元组：
```
thistuple = ("apple", "banana", "cherry")
del thistuple

print(thistuple) # 这会引发错误，因为元组已不存在。
```

NameError Traceback (most recent call last)~\AppData\Local\Temp\ipykernel_27696\2512008026.py in <module>2 del thistuple3----> 4 print(thistuple) # 这会引发错误，因为元组已不存在。NameError: name 'thistuple' is not defined
### 合并两个元组

如需连接两个或多个元组，您可以使用 + 运算符：

合并这个元组：

```
tuple1 = ("a", "b" , "c")
tuple2 = (1, 2, 3)

tuple3 = tuple1 + tuple2
print(tuple3)
```

('a', 'b', 'c', 1, 2, 3)

### tuple() 构造函数

也可以使用 tuple() 构造函数来创建元组。

使用 tuple() 方法来创建元组：

```
thistuple = tuple(("apple", "banana", "cherry")) # 请注意双括号
print(thistuple)
```

('apple', 'banana', 'cherry')
### 元组方法

Python 提供两个可以在元组上使用的内建方法。
| 方法    | 描述                                       |
|---------|--------------------------------------------|
| count() | 返回元组中指定值出现的次数。               |
| index() | 在元组中搜索指定的值并返回它被找到的位置。 |
返回值 5 在元组中出现的次数:

```
thistuple = (1, 3, 7, 8, 7, 5, 4, 6, 8, 5)
x = thistuple.count(5)
print(x)
```
2

检索首次出现的值 8，并返回其位置：

```
thistuple = (1, 3, 7, 8, 7, 5, 4, 6, 8, 5)
x = thistuple.index(8)
print(x)
```
3

# 十三、python集合

集合是无序和无索引的集合。在 Python 中，集合用花括号编写。

创建集合：

```
thisset = {"apple", "banana", "cherry"}
print(thisset)
```

{'banana', 'apple', 'cherry'}


**注意：集合是无序的，因此您无法确定项目的显示顺序。**
### 访问项目

您无法通过引用索引来访问 set 中的项目，因为 set 是无序的，项目没有索引。

但是您可以使用 for 循环遍历 set 项目，或者使用 in 关键字查询集合中是否存在指定值。

遍历集合，并打印值：

```
thisset = {"apple", "banana", "cherry"}
for x in thisset:
  print(x)
```

banana
apple
cherry

检查 set 中是否存在 “banana”：

```
thisset = {"apple", "banana", "cherry"}
print("banana" in thisset)
```

True

### 更改项目

集合一旦创建，您就无法更改项目，但是您可以添加新项目。
### 添加项目

要将一个项添加到集合，请使用 add() 方法。

要向集合中添加多个项目，请使用 update() 方法。

使用 add() 方法向 set 添加项目：

```
thisset = {"apple", "banana", "cherry"}
thisset.add("orange")
print(thisset)
```

{'banana', 'apple', 'cherry', 'orange'}


使用 update() 方法将多个项添加到集合中：

```
thisset = {"apple", "banana", "cherry"}
thisset.update(["orange", "mango", "grapes"])
print(thisset)
```

{'banana', 'orange', 'mango', 'apple', 'grapes', 'cherry'}

### 获取 Set 的长度

要确定集合中有多少项，请使用 len() 方法。

获取集合中的项目数：

```
thisset = {"apple", "banana", "cherry"}
print(len(thisset))
```
3
### 删除项目

要删除集合中的项目，请使用 remove() 或 discard() 方法。

使用 remove() 方法来删除 “banana”：

```
thisset = {"apple", "banana", "cherry"}
thisset.remove("banana")
print(thisset)
```

{'apple', 'cherry'}

注释：如果要删除的项目不存在，则 remove() 将引发错误。

使用 discard() 方法来删除 “banana”：

```
thisset = {"apple", "banana", "cherry"}
thisset.discard("banana")
print(thisset)
```

{'apple', 'cherry'}


注释：如果要删除的项目不存在，则 discard() 不会引发错误。

您还可以使用 pop() 方法删除项目，但此方法将删除最后一项。请记住，set 是无序的，因此您不会知道被删除的是什么项目。

pop() 方法的返回值是被删除的项目

使用 pop() 方法删除最后一项：

```
thisset = {"apple", "banana", "cherry"}
x = thisset.pop()
print(x)
print(thisset)
```

set()

del 彻底删除集合：
```
thisset = {"apple", "banana", "cherry"}
del thisset
print(thisset)
```

NameError Traceback (most recent call last)~\AppData\Local\Temp\ipykernel_27696\3077915618.py in <module>3 del thisset4----> 5 print(thisset)NameError: name 'thisset' is not defined

### 合并两个集合

在 Python 中，有几种方法可以连接两个或多个集合。

您可以使用 union() 方法返回包含两个集合中所有项目的新集合，也可以使用 update() 方法将一个集合中的所有项目插入另一个集合中：

union() 方法返回一个新集合，其中包含两个集合中的所有项目：

```
set1 = {"a", "b" , "c"}
set2 = {1, 2, 3}
set3 = set1.union(set2)
print(set3)
```

{1, 2, 3, 'b', 'a', 'c'}


update() 方法将 set2 中的项目插入 set1 中：
```
set1 = {"a", "b" , "c"}
set2 = {1, 2, 3}
set1.update(set2)
print(set1)
```

{1, 2, 3, 'b', 'a', 'c'}

注释：union() 和 update() 都将排除任何重复项。
### set() 构造函数

也可以使用 set() 构造函数来创建集合。

使用 set() 构造函数来创建集合：
```
thisset = set(("apple", "banana", "cherry")) # 请留意这个双括号
print(thisset)
```

{'banana', 'apple', 'cherry'}

### Set 方法
| 方法                          | 描述                                         |
|-------------------------------|----------------------------------------------|
| add()                         | 向集合添加元素。                             |
| clear()                       | 删除集合中的所有元素。                       |
| copy()                        | 返回集合的副本。                             |
| difference()                  | 返回包含两个或更多集合之间差异的集合。       |
| difference_update()           | 删除此集合中也包含在另一个指定集合中的项目。 |
| discard()                     | 删除指定项目。                               |
| intersection()                | 返回为两个其他集合的交集的集合。             |
| intersection_update()         | 删除此集合中不存在于其他指定集合中的项目。   |
| isdisjoint()                  | 返回两个集合是否有交集。                     |
| issubset()                    | 返回另一个集合是否包含此集合。               |
| issuperset()                  | 返回此集合是否包含另一个集合。               |
| pop()                         | 从集合中删除一个元素。                       |
| remove()                      | 删除指定元素。                               |
| symmetric_difference()        | 返回具有两组集合的对称差集的集合。           |
| symmetric_difference_update() | 插入此集合和另一个集合的对称差集。           |
| union()                       | 返回包含集合并集的集合。                     |
| update()                      | 用此集合和其他集合的并集来更新集合。         |
向 fruits 集合添加一个元素：
```
fruits = {"apple", "banana", "cherry"}
fruits.add("orange") 
print(fruits)
```

{'banana', 'apple', 'cherry', 'orange'}


从 fruits 集合删除所有元素：
```
fruits = {"apple", "banana", "cherry"}
fruits.clear()
print(fruits)
```

set()


复制 fruits 集合：
```
fruits = {"apple", "banana", "cherry"}
x = fruits.copy()
print(x)
```

{'banana', 'apple', 'cherry'}

返回一个集合，其中包含仅存在于集合 x 中而不存在于集合 y 中的项目：
```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
z = x.difference(y) 
print(z)
```
{'banana', 'cherry'}

删除两个集合中都存在的项目：
```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
x.difference_update(y) 
print(x)
```

{'banana', 'cherry'}


**注意：different_update() 方法将删除两个集合中都存在的项目。**

difference_update() 方法与 difference() 方法不同，因为 difference() 方法返回一个新集合，其中没有不需要的项目，而 difference_update() 方法从原始集中删除了不需要的项目。

从集合中删除 "banana"：

```
fruits = {"apple", "banana", "cherry"}
fruits.discard("banana") 
print(fruits)
```

{'apple', 'cherry'}


**注意：discard() 方法从集合中删除指定项目。**

此方法与 remove() 方法不同，因为如果指定的项目不存在，则 remove() 方法将引发错误，而 discard() 方法不会。

返回包含存在于集合 x 和集合 y 中的项目的集合：

```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
z = x.intersection(y) 
print(z)
```

{'apple'}


**注意：intersection() 方法返回包含两个或更多集合之间相似性的集合。**

含义：返回的集合仅包含两个集合中都存在的项目，或者如果使用两个以上的集合进行比较，则在所有集合中都存在。

删除集合 x 和集合 y 都不存在的项目：
```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
x.intersection_update(y) 
print(x)
```

{'apple'}

**注意：intersection_update() 方法会删除各集合中都不存在的项目。**

intersection_update() 方法与 intersection() 方法不同，因为 intersection() 方法返回一个新集合，其中没有不需要的项目，而 intersection_update() 方法从原始集中删除了不需要的项目。

**所有集合 x 中没有项目存在于集合 y 中，则返回 True：**
```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "facebook"}
z = x.isdisjoint(y) 
print(z)
```

True

注意：如果没有项目同时存在于不同集合中，则 isdisjoint() 方法返回 True，否则返回 False。

如果集合 y 中存在集合 x 中的所有项目，则返回 True：

```
x = {"a", "b", "c"}
y = {"f", "e", "d", "c", "b", "a"}
z = x.issubset(y) 
print(z)
```

True

假如集合 y 中的所有项目都存在于集合 x 中，则返回 True：
```
x = {"f", "e", "d", "c", "b", "a"}
y = {"a", "b", "c"}
z = x.issuperset(y) 
print(z)
```

True

从集合中删除一个随机的项目：
```
fruits = {"apple", "banana", "cherry"}
fruits.pop() 
print(fruits)
```

{'apple', 'cherry'}


从集合中删除 "banana"：
```
fruits = {"apple", "banana", "cherry"}
fruits.remove("banana") 
print(fruits)
```
{'apple', 'cherry'}

返回一个集合，其中包含两个集合中的所有项目，但两个集合中都存在的项目除外：
```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
z = x.symmetric_difference(y) 
print(z)
```

{'banana', 'google', 'microsoft', 'cherry'}


删除两集合中不是都有的项目:

```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
x.symmetric_difference_update(y) 
print(x)
```

{'banana', 'google', 'microsoft', 'cherry'}


返回包含两个集合中所有项目的集合，重复项被排除在外：

```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
z = x.union(y) 
print(z)
```

{'banana', 'apple', 'cherry', 'google', 'microsoft'}


把集合 y 中的项目插入集合 x：

```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
x.update(y) 
print(x)
```

{'banana', 'apple', 'cherry', 'google', 'microsoft'}

# 十四、字典（Dictionary）

字典是一个无序、可变和有索引的集合。在 Python 中，字典用花括号编写，拥有键和值。

创建并打印字典：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
print(thisdict)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963}

### 访问项目

您可以通过在方括号内引用其键名来访问字典的项目：

获取 "model" 键的值：

```
x = thisdict["model"]
print(x)
```

911

还有一个名为 get() 的方法会给你相同的结果：

获取 "model" 键的值：

```
x = thisdict.get("model")
print(x)
```

911
### 更改值

您可以通过引用其键名来更改特定项的值：

把 "year" 改为 2019：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
thisdict["year"] = 2019
print(thisdict)
```

{'brand': 'Porsche', 'model': '911', 'year': 2019}

### 遍历字典

您可以使用 for 循环遍历字典。

循环遍历字典时，返回值是字典的键，但也有返回值的方法。

逐个打印字典中的所有键名：


brand
model
year

逐个打印字典中的所有值：

```
for x in thisdict:
  print(thisdict[x])
```

Porsche
911
2019

您还可以使用 values() 函数返回字典的值：

```
for x in thisdict.values():
  print(x)
```

Porsche
911
2019

通过使用 items() 函数遍历键和值：
```
for x, y in thisdict.items():
  print(x, y)
```

brand Porsche
model 911
year 2019
### 检查键是否存在

要确定字典中是否存在指定的键，请使用 in 关键字：

检查字典中是否存在 "model"：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
if "model" in thisdict:
  print("Yes, 'model' is one of the keys in the thisdict dictionary")
```

Yes, 'model' is one of the keys in the thisdict dictionary

### 字典长度

要确定字典有多少项目（键值对），请使用 len() 方法。

打印字典中的项目数：

```
print(len(thisdict))
```
3
### 添加项目

通过使用新的索引键并为其赋值，可以将项目添加到字典中：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
thisdict["color"] = "red"
print(thisdict)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963, 'color': 'red'}

### 删除项目

有几种方法可以从字典中删除项目：

pop() 方法删除具有指定键名的项：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
thisdict.pop("model")
print(thisdict)
```

{'brand': 'Porsche', 'year': 1963}


popitem() 方法删除最后插入的项目（在 3.7 之前的版本中，删除随机项目）：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
thisdict.popitem()
print(thisdict)
```

{'brand': 'Porsche', 'model': '911'}


### 实例

del 关键字删除具有指定键名的项目：
```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
del thisdict["model"]
print(thisdict)
```

{'brand': 'Porsche', 'year': 1963}


del 关键字也可以完全删除字典：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
del thisdict

print(thisdict) #this 会导致错误，因为 "thisdict" 不再存在。
```

NameError Traceback (most recent call last)~\AppData\Local\Temp\ipykernel_27696\3564800855.py in <module>6 del thisdict7----> 8 print(thisdict) #this 会导致错误，因为 "thisdict" 不再存在。NameError: name 'thisdict' is not defined

clear() 关键字清空字典：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
thisdict.clear()
print(thisdict)
```
{}
### 复制字典

您不能通过键入 dict2 = dict1 来复制字典，因为：dict2 只是对 dict1 的引用，而 dict1 中的更改也将自动在 dict2 中进行。


有一些方法可以进行复制，一种方法是使用内建的字典方法 copy()。

使用 copy() 方法来复制字典：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
mydict = thisdict.copy()
print(mydict)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963}


制作副本的另一种方法是使用内建方法 dict()。

使用 dict() 方法创建字典的副本：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
mydict = dict(thisdict)
print(mydict)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963}

### 嵌套字典

词典也可以包含许多词典，这被称为嵌套词典。

创建包含三个字典的字典：

```
myfamily = {
  "child1" : {
    "name" : "Phoebe Adele",
    "year" : 2002
  },
  "child2" : {
    "name" : "Jennifer Katharine",
    "year" : 1996
  },
  "child3" : {
    "name" : "Rory John",
    "year" : 1999
  }
}
print(myfamily)
```

{'child1': {'name': 'Phoebe Adele', 'year': 2002}, 'child2': {'name': 'Jennifer Katharine', 'year': 1996}, 'child3': {'name': 'Rory John', 'year': 1999}}

或者，如果您想嵌套三个已经作为字典存在的字典：

创建三个字典，然后创建一个包含其他三个字典的字典：

```
child1 = {
  "name" : "Phoebe Adele",
  "year" : 2002
}
child2 = {
  "name" : "Jennifer Katharine",
  "year" : 1996
}
child3 = {
  "name" : "Rory John",
  "year" : 1999
}

myfamily = {
  "child1" : child1,
  "child2" : child2,
  "child3" : child3
}
print(myfamily)
```

{'child1': {'name': 'Phoebe Adele', 'year': 2002}, 'child2': {'name': 'Jennifer Katharine', 'year': 1996}, 'child3': {'name': 'Rory John', 'year': 1999}}
### dict() 构造函数

也可以使用 dict() 构造函数创建新的字典：

```
thisdict = dict(brand="Porsche", model="911", year=1963)
# 请注意，关键字不是字符串字面量
# 请注意，使用了等号而不是冒号来赋值
print(thisdict)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963}

### 字典方法

Python 提供一组可以在字典上使用的内建方法。

| 方法         | 描述                                                   |
|--------------|--------------------------------------------------------|
| clear()      | 删除字典中的所有元素                                   |
| copy()       | 返回字典的副本                                         |
| fromkeys()   | 返回拥有指定键和值的字典                               |
| get()        | 返回指定键的值                                         |
| items()      | 返回包含每个键值对的元组的列表                         |
| keys()       | 返回包含字典键的列表                                   |
| pop()        | 删除拥有指定键的元素                                   |
| popitem()    | 删除最后插入的键值对                                   |
| setdefault() | 返回指定键的值。如果该键不存在，则插入具有指定值的键。 |
| update()     | 使用指定的键值对字典进行更新                           |
| values()     | 返回字典中所有值的列表                                 |
删除 car 列表中的所有元素：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
car.clear()
print(car)
```

{}

复制 car 字典：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.copy()
print(x)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963}


创建拥有 3 个键的字典，值均为 0：

```
x = ('key1', 'key2', 'key3')
y = 0
thisdict = dict.fromkeys(x, y)
print(thisdict)
```

{'key1': 0, 'key2': 0, 'key3': 0}


获取 "model" 项的值：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.get("model")
print(x)
```

911

返回字典的键值对：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.items()
print(x)
```

dict_items([('brand', 'Porsche'), ('model', '911'), ('year', 1963)])


返回键：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.keys()
print(x)
```

dict_keys(['brand', 'model', 'year'])


从字典中删除 "model"：
```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
car.pop("model")
print(car)
```

{'brand': 'Porsche', 'year': 1963}


从字典中删除最后一个项目：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
car.popitem()
print(car)
```

{'brand': 'Porsche', 'model': '911'}


获取 "model" 项的值：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.setdefault("map", "Macan")
print(x)
```

Macan

向字典插入项目：
```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
car.update({"color": "White"})
print(car)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963, 'color': 'White'}


返回值：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.values()
print(x)
```

dict_values(['Porsche', '911', 1963])

# Python 条件和 If 语句

Python 支持来自数学的常用逻辑条件：

* 等于：a == b
* 不等于：a != b
* 小于：a < b
* 小于等于：a <= b
* 大于：a > b
* 大于等于：a >= b

这些条件能够以多种方式使用，最常见的是“if 语句”和循环。

if 语句使用 if 关键词来写。


If 语句：

```
a = 66
b = 200
if b > a:
  print("b is greater than a")
```

b is greater than a


在这个例子中，我们使用了两个变量，a 和 b，作为 if 语句的一部分，它们用于测试 b 是否大于 a。因为 a 是 66，而 b 是 200，我们知道 200 大于 66，所以我们将“b大于a”打印到屏幕。
### 缩进

Python 依赖缩进，使用空格来定义代码中的范围。其他编程语言通常使用花括号来实现此目的。

没有缩进的 If 语句（会引发错误）：
```
a = 66
b = 200
if b > a:
print("b is greater than a") # 会报错
```

File "C:\Users\kuhuo\AppData\Local\Temp\ipykernel_27696\1297857038.py", line 4print("b is greater than a") # 会报错IndentationError: expected an indented block

### Elif

elif 关键字是 python 对“如果之前的条件不正确，那么试试这个条件”的表达方式。

```
a = 66
b = 66
if b > a:
  print("b is greater than a")
elif a == b:
  print("a and b are equal")
```

a and b are equal


在这个例子中，a 等于 b，所以第一个条件不成立，但 elif 条件为 true，所以我们打印屏幕“a 和 b 相等”。
### Else

else 关键字捕获未被之前的条件捕获的任何内容。

```
a = 200
b = 66
if b > a:
  print("b is greater than a")
elif a == b:
  print("a and b are equal")
else:
  print("a is greater than b")
```

a is greater than b

在这个例子中，a 大于 b，所以第一个条件不成立，elif 条件也不成立，所以我们转到 else 条件并打印到屏幕“a 大于 b”。

您也可以使用没有 elif 的 else：

```
a = 200
b = 66
if b > a:
  print("b is greater than a")
else:
  print("b is not greater than a")
```

b is not greater than a

简写 If

如果只有一条语句要执行，则可以将其与 if 语句放在同一行。

```
a = 200
b = 66
if a > b: print("a is greater than b")
```

a is greater than b

### 简写 If ... Else

如果只有两条语句要执行，一条用于 if，另一条用于 else，则可以将它们全部放在同一行：

```
a = 200
b = 66
print("A") if a > b else print("B")
```

A

您还可以在同一行上使用多个 else 语句：

```
a = 200
b = 66
print("A") if a > b else print("=") if a == b else print("B")
```

A
### And

and 关键字是一个逻辑运算符，用于组合条件语句：
```
a = 200
b = 66
c = 500
if a > b and c > a:
  print("Both conditions are True")
```

Both conditions are True

### Or

or 关键字也是逻辑运算符，用于组合条件语句：

```
a = 200
b = 66
c = 500
if a > b or a > c:
  print("At least one of the conditions is True")
```

At least one of the conditions is True


您可以在 if 语句中包含 if 语句，这称为嵌套 if 语句。
```
x = 52

if x > 10:
  print("Above ten,")
  if x > 20:
    print("and also above 20!")
  else:
    print("but not above 20.")
```

Above ten,
and also above 20!
### pass 语句

if 语句不能为空，但是如果您处于某种原因写了无内容的 if 语句，请使用 pass 语句来避免错误。

```
a = 66
b = 200

if b > a:
  pass
```

# 十五、Python 循环

Python 有两个原始的循环命令：

* while 循环
* for 循环

### while 循环

如果使用 while 循环，只要条件为真，我们就可以执行一组语句。

只要 i 小于 7，打印 i：

```
i = 1
while i < 7:
  print(i)
  i += 1
```

1
2
3
4
5
6

**注意：请记得递增 i，否则循环会永远继续。**

while 循环需要准备好相关的变量。在这个实例中，我们需要定义一个索引变量 i，我们将其设置为 1。
### break 语句

如果使用 break 语句，即使 while 条件为真，我们也可以停止循环：

```
i = 1
while i < 7:
  print(i)
  if i == 3:
    break
  i += 1
```

1
2
3
### continue 语句

如果使用 continue 语句，我们可以停止当前的迭代，并继续下一个：

如果 i 等于 3，则继续下一个迭代：

```
i = 0
while i < 7:
  i += 1 
  if i == 3:
    continue
  print(i)
```

1
2
4
5
6
7
### else 语句

通过使用 else 语句，当条件不再成立时，我们可以运行一次代码块：

```
i = 1
while i < 6:
  print(i)
  i += 1
else:
  print("i is no longer less than 6")
```

1
2
3
4
5
i is no longer less than 6

# 十六、Python For 循环

for 循环用于迭代序列（即列表，元组，字典，集合或字符串）。

这与其他编程语言中的 for 关键字不太相似，而是更像其他面向对象编程语言中的迭代器方法。

通过使用 for 循环，我们可以为列表、元组、集合中的每个项目等执行一组语句。

打印 fruits 列表中的每种水果：
```
fruits = ["apple", "banana", "cherry"] 
for x in fruits: 
 print(x)
```
apple

banana

cherry

**提示：for 循环不需要预先设置索引变量。**

### 循环遍历字符串

甚至连字符串都是可迭代的对象，它们包含一系列的字符：

循环遍历单词 "banana" 中的字母：

```
for x in "banana": 
 print(x)
```
b
a
n
a
n
a

### break 语句

通过使用 break 语句，我们可以在循环遍历所有项目之前停止循环：

如果 x 是 "banana"，则退出循环：

```
fruits = ["apple", "banana", "cherry"]
for x in fruits:
  print(x) 
  if x == "banana":
    break
```
apple
banana

### continue 语句

通过使用 continue 语句，我们可以停止循环的当前迭代，并继续下一个：

不打印香蕉：

```
fruits = ["apple", "banana", "cherry"]
for x in fruits:
  if x == "banana":
    continue
  print(x)
```
apple
cherry

### range() 函数

如需循环一组代码指定的次数，我们可以使用 range() 函数，

range() 函数返回一个数字序列，默认情况下从 0 开始，并递增 1（默认地），并以指定的数字结束。

```
for x in range(10):
  print(x)
```
0
1
2
3
4
5
6
7
8
9

**注意：range(10) 不是 0 到 10 的值，而是值 0 到 9。**

range() 函数默认 0 为起始值，不过可以通过添加参数来指定起始值：range(3, 10)，这意味着值为 3 到 10（但不包括 10）：

```
for x in range(3, 10):
  print(x)
```

3

4

5

6

7

8

9

range() 函数默认将序列递增 1，但是可以通过添加第三个参数来指定增量值：range(2, 30, 3)：

使用 3 递增序列（默认值为 1）：

```
for x in range(3, 50, 6):
  print(x)
```

3

9

15

21

27

33

39

45

### For 循环中的 Else

for 循环中的 else 关键字指定循环结束时要执行的代码块：

打印 0 到 9 的所有数字，并在循环结束时打印一条消息：

```
for x in range(10):
  print(x)
else:
  print("Finally finished!")
```

0

1

2

3

4

5

6

7

8

9

Finally finished!

## 嵌套循环

嵌套循环是循环内的循环。

“外循环”每迭代一次，“内循环”将执行一次：

打印每个水果的每个形容词：
```
adj = ["red", "big", "tasty"]
fruits = ["apple", "banana", "cherry"]

for x in adj:
  for y in fruits:
    print(x, y)
```

red apple

red banana

red cherry

big apple

big banana

big cherry

tasty apple

tasty banana

tasty cherry

## pass 语句

for 语句不能为空，但是如果您处于某种原因写了无内容的 for 语句，请使用 pass 语句来避免错误。
```
for x in [0, 1, 2]:
  pass
```

# 十七、python函数

**函数是一种仅在调用时运行的代码块。**

**您可以将数据（称为参数）传递到函数中。**

**函数可以把数据作为结果返回。**

### 创建函数

在 Python 中，使用 def 关键字定义函数：

```
def my_function():
  print("Hello from a function")
```

### 调用函数

如需调用函数，请使用函数名称后跟括号：

```
def my_function():
  print("Hello from a function")

my_function()
```

Hello from a function

### 参数

信息可以作为参数传递给函数。

参数在函数名后的括号内指定。您可以根据需要添加任意数量的参数，只需用逗号分隔即可。

下面的例子有一个带参数（fname）的函数。当调用此函数时，我们传递一个名字，在函数内部使用它来打印全名：

```
def my_function(fname):
  print(fname + " Gates")

my_function("Bill")
my_function("Steve")
my_function("Elon")
```
Bill Gates

Steve Gates

Elon Gates

### 默认参数值

下面的例子展示如何使用默认参数值。

如果我们调用了不带参数的函数，则使用默认值：

```
def my_function(country = "China"):
  print("I am from " + country)

my_function("Sweden")
my_function("India")
my_function()
my_function("Brazil")
```

I am from Sweden

I am from India

I am from China

I am from Brazil

### 以 List 传参

您发送到函数的参数可以是任何数据类型（字符串、数字、列表、字典等），并且在函数内其将被视为相同数据类型。

例如，如果您将 List 作为参数发送，它到达函数时仍将是 List（列表）：

```
def my_function(food):
  for x in food:
    print(x)

fruits = ["apple", "banana", "cherry"]

my_function(fruits)
```

apple

banana

cherry

### 返回值

如需使函数返回值，请使用 return 语句：

15

25

45

### 关键字参数

您还可以使用 key = value 语法发送参数。

参数的顺序无关紧要。

```
def my_function(child3, child2, child1):
  print("The youngest child is " + child3)

my_function(child1 = "Phoebe", child2 = "Jennifer", child3 = "Rory")
```

The youngest child is Rory

### 任意参数

如果您不知道将传递给您的函数多少个参数，请在函数定义的参数名称前添加 \*。

这样，函数将接收一个参数元组，并可以相应地访问各项：

```
def my_function(*kids):
  print("The youngest child is " + kids[2])

my_function("Phoebe", "Jennifer", "Rory")
```

The youngest child is Rory

### pass 语句

函数定义不能为空，但是如果您出于某种原因写了无内容的函数定义，请使用 pass 语句来避免错误。

1def myfunction:

2 pass

### 递归

Python 也接受函数递归，这意味着定义的函数能够调用自身。

递归是一种常见的数学和编程概念。它意味着函数调用自身。这样做的好处是可以循环访问数据以达成结果。

开发人员应该非常小心递归，因为它可以很容易地编写一个永不终止的，或者使用过量内存或处理器能力的函数。但是，在被正确编写后，递归可能是一种非常有效且数学上优雅的编程方法。

在这个例子中，tri_recursion() 是我们定义为调用自身 ("recurse") 的函数。我们使用 k 变量作为数据，每次递归时递减（-1）。当条件不大于 0 时（比如当它为 0 时），递归结束。

对于新的开发人员来说，可能需要一些时间来搞清楚其工作原理，最好的方法是测试并修改它。

```
def tri_recursion(k):
  if(k>0):
    result = k+tri_recursion(k-1)
    print(result)
  else:
    result = 0
  return result

print("\n\nRecursion Example Results")
tri_recursion(6)
```
Recursion Example Results

1

3

6

10

15

21

# 十八、python Lambda

**lambda 函数是一种小的匿名函数。**

**lambda 函数可接受任意数量的参数，但只能有一个表达式。**

一个 lambda 函数，它把作为参数传入的数字加 10，然后打印结果：

```
x = lambda a : a + 10
print(x(5))
```

15

lambda 函数可接受任意数量的参数：

一个 lambda 函数，它把参数 a 与参数 b 相乘并打印结果：

```
x = lambda a, b : a * b
print(x(5, 6))
```

30

一个 lambda 函数，它把参数 a、b 和 c 相加并打印结果：

```
x = lambda a, b, c : a + b + c
print(x(5, 6, 2))
```

13

# 十九、Python 类/对象

Python 是一种面向对象的编程语言。

Python 中的几乎所有东西都是对象，拥有属性和方法。

类（Class）类似对象构造函数，或者是用于创建对象的“蓝图”。

### 创建类

如需创建类，请使用 class 关键字：

使用名为 x 的属性，创建一个名为 MyClass 的类：

```
class MyClass:
  x = 5
```

### 创建对象

现在我们可以使用名为 myClass 的类来创建对象：

创建一个名为 p1 的对象，并打印 x 的值：

```
p1 = MyClass()
print(p1.x)
```

5

### \__init__() 函数

上面的例子是最简单形式的类和对象，在实际应用程序中并不真正有用。

要理解类的含义，我们必须先了解内置的 \__init__() 函数。

所有类都有一个名为 \__init__() 的函数，它始终在启动类时执行。

使用 \__init__() 函数将值赋给对象属性，或者在创建对象时需要执行的其他操作：

创建名为 Person 的类，使用 \__init__() 函数为 name 和 age 赋值：

```
class Person:
  def __init__(self, name, age):
    self.name = name
    self.age = age

p1 = Person("Bill", 63)

print(p1.name)
print(p1.age)
```

Bill

63

**注释：**每次使用类创建新对象时，都会*自动调用* \__init__() 函数。

### 对象方法

对象也可以包含方法。对象中的方法是属于该对象的函数。

让我们在 Person 类中创建方法：

插入一个打印问候语的函数，并在 p1 对象上执行它：

```
class Person:
  def __init__(self, name, age):
    self.name = name
    self.age = age

  def myfunc(self):
    print("Hello my name is " + self.name)

p1 = Person("Bill", 63)
p1.myfunc()
```

Hello my name is Bill

### 修改对象属性

您可以这样修改对象的属性：

把 p1 的年龄设置为 40：

```
class Person:
  def __init__(self, name, age):
    self.name = name
    self.age = age

  def myfunc(self):
    print("Hello my name is " + self.name + "and her age is {}".format(self.age))

p1 = Person("Bill", 63)
p1.myfunc()
p1.age = 40
p1.myfunc()
```

Hello my name is Billand her age is 63

Hello my name is Billand her age is 40

### 删除对象属性

您可以使用 del 关键字删除对象的属性：

删除 p1 对象的 age 属性：

```
del p1.age
```

### 删除对象

使用 del 关键字删除对象：

删除 p1 对象：

```
del p1
```

### pass 语句

类定义不能为空，但是如果您处于某种原因写了无内容的类定义语句，请使用 pass 语句来避免错误。

```
class Person:
  pass
```
# 二十、Python 继承

继承允许我们定义继承另一个类的所有方法和属性的类。

*父类*是继承的类，也称为基类。

*子类*是从另一个类继承的类，也称为派生类。

### 创建父类

任何类都可以是父类，因此语法与创建任何其他类相同：

创建一个名为 Person 的类，其中包含 firstname 和 lastname 属性以及 printname 方法：

```
class Person:
  def __init__(self, fname, lname):
    self.firstname = fname
    self.lastname = lname

  def printname(self):
    print(self.firstname, self.lastname)

# 使用 Person 来创建对象，然后执行 printname 方法：

x = Person("Bill", "Gates")
x.printname()
```

Bill Gates

### 创建子类

要创建从其他类继承功能的类，请在创建子类时将父类作为参数发送：

创建一个名为 Student 的类，它将从 Person 类继承属性和方法：

```
class Student(Person):
  pass
```

**注释：如果您不想向该类添加任何其他属性或方法，请使用 pass 关键字。**

现在，Student 类拥有与 Person 类相同的属性和方法。

使用 Student 类创建一个对象，然后执行 printname 方法：

```
x = Student("Elon", "Musk")
x.printname()
```

Elon Musk

### 添加 \__init__() 函数

到目前为止，我们已经创建了一个子类，它继承了父类的属性和方法。

我们想要把 \__init__() 函数添加到子类（而不是 pass 关键字）。

**注释：每次使用类创建新对象时，都会自动调用 \__init__() 函数。**

为 Student 类添加 \__init__() 函数：

```
class Student(Person):
  def __init__(self, fname, lname):
    # 添加属性等
```

当您添加 \__init__() 函数时，子类将不再继承父的 \__init__() 函数。

**注释：子的 \__init__() 函数会覆盖对父的 \__init__() 函数的继承。**

如需保持父的 \__init__() 函数的继承，请添加对父的 \__init__() 函数的调用：

```
class Student(Person):
  def __init__(self, fname, lname):
    Person.__init__(self, fname, lname)
```

现在，我们已经成功添加了 \__init__() 函数，并保留了父类的继承，我们准备好在 \__init__() 函数中添加功能了。

### 使用 super() 函数

Python 还有一个 super() 函数，它会使子类从其父继承所有方法和属性：

```
class Student(Person):
  def __init__(self, fname, lname):
    super().__init__(fname, lname)
```

通过使用 super() 函数，您不必使用父元素的名称，它将自动从其父元素继承方法和属性。

### 添加属性

把名为 graduationyear 的属性添加到 Student 类：

```
class Student(Person):
  def __init__(self, fname, lname):
    super().__init__(fname, lname)
    self.graduationyear = 2019
```

在这例子中，2019 年应该是一个变量，并在创建 student 对象时传递到 Student 类。为此，请在 \__init__() 函数中添加另一个参数：

```
class Student(Person):
  def __init__(self, fname, lname, year):
    super().__init__(fname, lname)
    self.graduationyear = year

x = Student("Elon", "Musk", 2019)
```

2019

### 添加方法

把名为 welcome 的方法添加到 Student 类：

```
class Person:
  def __init__(self, fname, lname):
    self.firstname = fname
    self.lastname = lname

  def printname(self):
    print(self.firstname, self.lastname)

class Student(Person):
  def __init__(self, fname, lname, year):
    super().__init__(fname, lname)
    self.graduationyear = year

  def welcome(self):
    print("Welcome", self.firstname, self.lastname, "to the class of", self.graduationyear)

x = Student("Elon", "Musk", 2019)
x.welcome()
```

Welcome Elon Musk to the class of 2019

**提示：如果您在子类中添加一个与父类中的函数同名的方法，则将覆盖父方法的继承。**

# 二十一、Python 迭代器

迭代器是一种对象，该对象包含值的可计数数字。

迭代器是可迭代的对象，这意味着您可以遍历所有值。

从技术上讲，在 Python 中，迭代器是实现迭代器协议的对象，它包含方法 \__iter__() 和 \__next__()。

### 迭代器 VS 可迭代对象（Iterable）

列表、元组、字典和集合都是可迭代的对象。它们是可迭代的容器，您可以从中获取迭代器（Iterator）。

所有这些对象都有用于获取迭代器的 iter() 方法：

从元组返回一个迭代器，并打印每个值：

```
mytuple = ("apple", "banana", "cherry")
myit = iter(mytuple)

print(next(myit))
print(next(myit))
print(next(myit))
```

apple

banana

cherry

甚至连字符串都是可迭代的对象，并且可以返回迭代器：

字符串也是可迭代的对象，包含一系列字符：

```
mystr = "banana"
myit = iter(mystr)

print(next(myit))
print(next(myit))
print(next(myit))
print(next(myit))
print(next(myit))
print(next(myit))
```

b

a

n

a

n

a

### 遍历迭代器

我们也可以使用 for 循环遍历可迭代对象：

迭代元组的值：

```
mytuple = ("apple", "banana", "cherry")

for x in mytuple:
  print(x)
```

apple

banana

cherry

迭代字符串中的字符：

```
mystr = "banana"

for x in mystr:
  print(x)
```

b

a

n

a

n

a

**提示：for 循环实际上创建了一个迭代器对象，并为每个循环执行 next() 方法。**

# 二十二、作用域

**变量仅在创建区域内可用。这称为作用域。**

### 局部作用域

在函数内部创建的变量属于该函数的局部作用域，并且只能在该函数内部使用。

在函数内部创建的变量在该函数内部可用：

```
def myfunc():
  x = 100
  print(x)

myfunc()
```

100

### 函数内部的函数

如上例中所示，变量 x 在函数外部不可用，但对于函数内部的任何函数均可用：

能够从函数内的一个函数访问局部变量：

```
def myfunc():
  x = 100
  def myinnerfunc():
    print(x)
  myinnerfunc()

myfunc()
```

100

### 全局作用域

在 Python 代码主体中创建的变量是全局变量，属于全局作用域。

全局变量在任何范围（全局和局部）中可用。

在函数外部创建的变量是全局变量，任何人都可以使用：

```
x = 100

def myfunc():
  print(x)

myfunc()

print(x)
```

100

100

### 命名变量

如果在函数内部和外部操作同名变量，Python 会将它们视为两个单独的变量，一个在全局范围内可用（在函数外部），而一个在局部范围内可用（在函数内部）：

该函数将打印局部变量 x，然后代码还会打印全局变量 x：

```
x = 100

def myfunc():
  x = 200
  print(x)

myfunc()

print(x)
```

200

100

### Global 关键字

如果您需要创建一个全局变量，但被卡在本地作用域内，则可以使用 global 关键字。

global 关键字使变量成为全局变量。

如果使用 global 关键字，则该变量属于全局范围：

```
def myfunc():
  global x
  x = 100

myfunc()

print(x)
```

100

另外，如果要在函数内部更改全局变量，也请使用 global 关键字。

要在函数内部更改全局变量的值，请使用 global 关键字引用该变量：

```
x = 100

def myfunc():
  global x
  x = 200

myfunc()

print(x)
```

200

# 二十三、什么是模块？

请思考与代码库类似的模块。

模块是包含一组函数的文件，希望在应用程序中引用。

### 创建模块

如需创建模块，只需将所需代码保存在文件扩展名为 .py 的文件中：

在名为 mymodule.py 的文件中保存代码：

```
def greeting(name):
  print("Hello, " + name)
```

### 使用模块

现在，我们就可以用 import 语句来使用我们刚刚创建的模块：

导入名为 mymodule 的模块，并调用 greeting 函数：

```
import mymodule

mymodule.greeting("Bill")
```

**注释：如果使用模块中的函数时，请使用以下语法：**

### 模块中的变量

模块可以包含已经描述的函数，但也可以包含各种类型的变量（数组、字典、对象等）：

在文件 mymodule.py 中保存代码：

```
person1 = {
  "name": "Bill",
  "age": 63,
  "country": "USA"
}
```

导入名为 mymodule 的模块，并访问 person1 字典：

```
import mymodule

a = mymodule.person1["age"]
print(a)
```

### 为模块命名

您可以随意对模块文件命名，但是文件扩展名必须是 .py。

### 重命名模块

您可以在导入模块时使用 as 关键字创建别名：

为 mymodule 创建别名 mx：

```
import mymodule as mx

a = mx.person1["age"]
print(a)
```

### 内建模块

Python 中有几个内建模块，您可以随时导入。

导入并使用 platform 模块：

```
import platform

x = platform.system()
print(x)
```

### 使用 dir() 函数

有一个内置函数可以列出模块中的所有函数名（或变量名）。dir() 函数

列出属于 platform 模块的所有已定义名称：

```
import platform

x = dir(platform)
print(x)
```

**注释：dir() 函数可用于所有模块，也可用于您自己创建的模块。**

### 从模块导入

您可以使用 from 关键字选择仅从模块导入部件。

名为 mymodule 的模块拥有一个函数和一个字典：

```
def greeting(name):
  print("Hello, " + name)

person1 = {
  "name": "Bill",
  "age": 63,
  "country": "USA"
}
```

仅从模块导入 person1 字典：

```
from mymodule import person1

print (person1["age"])
```

**提示：在使用 from 关键字导入时，请勿在引用模块中的元素时使用模块名称。示例：person1["age"]，而不是 mymodule.person1["age"]。**

# 二十四、Python 日期

Python 中的日期不是其自身的数据类型，但是我们可以导入名为 datetime 的模块，把日期视作日期对象进行处理。

导入 datetime 模块并显示当前日期：

```
import datetime

x = datetime.datetime.now()
print(x)
```

2022-06-13 17:39:51.685577

日期包含年、月、日、小时、分钟、秒和微秒。

datetime 模块有许多方法可以返回有关日期对象的信息。

以下是一些例子，您将在本章稍后详细学习它们：

返回 weekday 的名称和年份：

```
import datetime

x = datetime.datetime.now()

print(x.year)
print(x.strftime("%A"))
```

2022

Monday

### 创建日期对象

如需创建日期，我们可以使用 datetime 模块的 datetime() 类（构造函数）。

datetime() 类需要三个参数来创建日期：年、月、日。

创建日期对象：

```
import datetime

x = datetime.datetime(2020, 5, 17)

print(x)
```

2020-05-17 00:00:00

datetime() 类还接受时间和时区（小时、分钟、秒、微秒、tzone）的参数，不过它们是可选的，默认值为 0，（时区默认为 None）。

### strftime() 方法

datetime 对象拥有把日期对象格式化为可读字符串的方法。

该方法称为 strftime()，并使用一个 format 参数来指定返回字符串的格式：

显示月份的名称：

```
import datetime

x = datetime.datetime(2019, 10, 1)

print(x.strftime("%B"))
```

October

| 指令 | 描述                            | 实例                     |
|------|---------------------------------|--------------------------|
| 指令 | 描述                            | 实例                     |
| %a   | Weekday，短版本                 | Wed                      |
| %A   | Weekday，完整版本               | Wednesday                |
| %w   | Weekday，数字 0-6，0 为周日     | 3                        |
| %d   | 日，数字 01-31                  | 31                       |
| %b   | 月名称，短版本                  | Dec                      |
| %B   | 月名称，完整版本                | December                 |
| %m   | 月，数字01-12                   | 12                       |
| %y   | 年，短版本，无世纪              | 18                       |
| %Y   | 年，完整版本                    | 2018                     |
| %H   | 小时，00-23                     | 17                       |
| %I   | 小时，00-12                     | 05                       |
| %p   | AM/PM                           | PM                       |
| %M   | 分，00-59                       | 41                       |
| %S   | 秒，00-59                       | 08                       |
| %f   | 微妙，000000-999999             | 548513                   |
| %z   | UTC 偏移                        | +0100                    |
| %Z   | 时区                            | CST                      |
| %j   | 天数，001-366                   | 365                      |
| %U   | 周数，每周的第一天是周日，00-53 | 52                       |
| %W   | 周数，每周的第一天是周一，00-53 | 52                       |
| %c   | 日期和时间的本地版本            | Mon Dec 31 17:41:00 2018 |
| %x   | 日期的本地版本                  | 12/31/18                 |
| %X   | 时间的本地版本                  | 17:41:00                 |
| %%   | A % character                   | %                        |

# 二十五、python Json

**JSON 是用于存储和交换数据的语法。**

**JSON 是用 JavaScript 对象表示法（JavaScript object notation）编写的文本。**

## Python 中的 JSON

Python 有一个名为 json 的内置包，可用于处理 JSON 数据。

导入 json 模块：

```
import json
```

## 解析 JSON - 把 JSON 转换为 Python

若有 JSON 字符串，则可以使用 json.loads() 方法对其进行解析。

结果将是 Python 字典。

把 JSON 转换为 Python：

```
import json

# 一些 JSON:
x =  '{ "name":"Bill", "age":63, "city":"Seatle"}'

# 解析 x:
y = json.loads(x)

# 结果是 Python 字典：
print(y["age"])
```

63

## 把 Python 转换为 JSON

若有 Python 对象，则可以使用 json.dumps() 方法将其转换为 JSON 字符串。

把 Python 转换为 JSON：

```
import json

# Python 对象（字典）：
x = {
  "name": "Bill",
  "age": 63,
  "city": "Seatle"
}

# 转换为 JSON：
y = json.dumps(x)

# 结果是 JSON 字符串：
print(y)
```

{"name": "Bill", "age": 63, "city": "Seatle"}

您可以把以下类型的 Python 对象转换为 JSON 字符串：

-   dict
-   list
-   tuple
-   string
-   int
-   float
-   True
-   False
-   None

将 Python 对象转换为 JSON 字符串，并打印值：

```
import json

print(json.dumps({"name": "Bill", "age": 63}))
print(json.dumps(["apple", "bananas"]))
print(json.dumps(("apple", "bananas")))
print(json.dumps("hello"))
print(json.dumps(42))
print(json.dumps(31.76))
print(json.dumps(True))
print(json.dumps(False))
print(json.dumps(None))
```

{"name": "Bill", "age": 63}

["apple", "bananas"]

["apple", "bananas"]

"hello"

42

31.76

true

false

null

当 Python 转换为 JSON 时，Python 对象会被转换为 JSON（JavaScript）等效项：

| Python | JSON   |
|--------|--------|
| dict   | Object |
| list   | Array  |
| tuple  | Array  |
| str    | String |
| int    | Number |
| float  | Number |
| True   | true   |
| False  | false  |
| None   | null   |

转换包含所有合法数据类型的 Python 对象：

```
import json

x = {
  "name": "Bill",
  "age": 63,
  "married": True,
  "divorced": False,
  "children": ("Jennifer","Rory","Phoebe"),
  "pets": None,
  "cars": [
    {"model": "Porsche", "mpg": 38.2},
    {"model": "BMW M5", "mpg": 26.9}
  ]
}

print(json.dumps(x))
```

{"name": "Bill", "age": 63, "married": true, "divorced": false, "children": ["Jennifer", "Rory", "Phoebe"], "pets": null, "cars": [{"model": "Porsche", "mpg": 38.2}, {"model": "BMW M5", "mpg": 26.9}]}

## 格式化结果

上面的实例打印一个 JSON 字符串，但它不是很容易阅读，没有缩进和换行。

json.dumps() 方法提供了令结果更易读的参数：

使用 indent 参数定义缩进数：

```
json.dumps(x, indent=4)
```

您还可以定义分隔符，默认值为（", ", ": "），这意味着使用逗号和空格分隔每个对象，使用冒号和空格将键与值分开：

使用 separators 参数来更改默认分隔符：

```
json.dumps(x, indent=4, separators=(". ", " = "))
```

## 对结果排序

json.dumps() 方法提供了对结果中的键进行排序的参数：

使用 sort_keys 参数来指定是否应对结果进行排序：

```
json.dumps(x, indent=4, sort_keys=True)
```

# 二十六、pythonRegEx

**RegEx 或正则表达式是形成搜索模式的字符序列。**

**RegEx 可用于检查字符串是否包含指定的搜索模式。**

### RegEx 模块

Python 提供名为 re 的内置包，可用于处理正则表达式。

导入 re 模块：

```
import re
```

### Python 中的 RegEx

导入 re 模块后，就可以开始使用正则表达式了：

### 实例

检索字符串以查看它是否以 "China" 开头并以 "country" 结尾：

```
import re

txt = "China is a great country"
x = re.search("^China.*country$", txt)
```

### RegEx 函数

re 模块提供了一组函数，允许我们检索字符串以进行匹配：

| 函数    | 描述                                              |
|---------|---------------------------------------------------|
| findall | 返回包含所有匹配项的列表                          |
| search  | 如果字符串中的任意位置存在匹配，则返回 Match 对象 |
| split   | 返回在每次匹配时拆分字符串的列表                  |
| sub     | 用字符串替换一个或多个匹配项                      |

### findall() 函数

findall() 函数返回包含所有匹配项的列表。

打印所有匹配的列表：

```
import re

str = "China is a great country"
x = re.findall("a", str)
print(x)
```

['a', 'a', 'a']

这个列表以被找到的顺序包含匹配项。

如果未找到匹配项，则返回空列表：

如果未找到匹配，则返回空列表：

```
import re

str = "China is a great country"
x = re.findall("USA", str)
print(x)
```

[]

### search() 函数

search() 函数搜索字符串中的匹配项，如果存在匹配则返回 Match 对象。

如果有多个匹配，则仅返回首个匹配项：

在字符串中搜索第一个字符 is ：

```
import re

str = "China is a great country"
x = re.search("is", str)

print("The first white-space character is located in position:", x.start())
```

如果未找到匹配，则返回值 None：

进行不返回匹配的检索：

```
import re

str = "China is a great country"
x = re.search("USA", str)
print(x)
```

None

Match 对象提供了用于取回有关搜索及结果信息的属性和方法：

-   span() 返回的元组包含了匹配的开始和结束位置
-   .string 返回传入函数的字符串
-   group() 返回匹配的字符串部分

打印首个匹配出现的位置（开始和结束位置）。

正则表达式查找以大写 "C" 开头的任何单词：

```
import re

str = "China is a great country"
x = re.search(r"\bC\w+", str)
print(x.span())
```

(0, 5)

打印传入函数的字符串：

```
import re

str = "China is a great country"
x = re.search(r"\bC\w+", str)
print(x.string)
```

China is a great country

打印匹配的字符串部分。

正则表达式查找以大写 "C" 开头的任何单词：

```
import re

str = "China is a great country"
x = re.search(r"\bC\w+", str)
print(x.group())
```

China

### split() 函数

split() 函数返回一个列表，其中字符串在每次匹配时被拆分：

在每个空白字符处进行拆分：

```
import re

str = "China is a great country"
x = re.split("\s", str)
print(x)
```

['China', 'is', 'a', 'great', 'country']

您可以通过指定 maxsplit 参数来控制出现次数：

仅在首次出现时拆分字符串：

```
import re

str = "China is a great country"
x = re.split("\s", str, 1)
print(x)
```

['China', 'is a great country']

### sub() 函数

sub() 函数把匹配替换为您选择的文本：

用数字 9 替换每个空白字符：

```
import re

str = "China is a great country"
x = re.sub("\s", "9", str)
print(x)
```

China9is9a9great9country

您可以通过指定 count 参数来控制替换次数：

替换前两次出现：

```
import re

str = "China is a great country"
x = re.sub("\s", "9", str, 2)
print(x)
```

China9is9a great country

### 特殊序列

特殊序列指的是 \\ 后跟下表中的某个字符，拥有特殊含义：

| 字符 | 描述                                                                                              | 示例                |
|------|---------------------------------------------------------------------------------------------------|---------------------|
| \\A  | 如果指定的字符位于字符串的开头，则返回匹配项                                                      | "\\AThe"            |
| \\b  | 返回指定字符位于单词的开头或末尾的匹配项                                                          | r"\\bain" r"ain\\b" |
| \\B  | 返回指定字符存在的匹配项，但不在单词的开头（或结尾处）                                            | r"\\Bain" r"ain\\B" |
| \\d  | 返回字符串包含数字的匹配项（数字 0-9）                                                            | "\\d"               |
| \\D  | 返回字符串不包含数字的匹配项                                                                      | "\\D"               |
| \\s  | 返回字符串包含空白字符的匹配项                                                                    | "\\s"               |
| \\S  | 返回字符串不包含空白字符的匹配项                                                                  | "\\S"               |
| \\w  | 返回一个匹配项，其中字符串包含任何单词字符 （从 a 到 Z 的字符，从 0 到 9 的数字和下划线 \_ 字符） | "\\w"               |
| \\W  | 返回一个匹配项，其中字符串不包含任何单词字符                                                      | "\\W"               |
| \\Z  | 如果指定的字符位于字符串的末尾，则返回匹配项                                                      | "Spain\\Z"          |

### 集合（Set）

集合（Set）是一对方括号 [] 内的一组字符，具有特殊含义：

| 集合       | 描述                                                                                            |
|------------|-------------------------------------------------------------------------------------------------|
| [arn]      | 返回一个匹配项，其中存在指定字符（a，r 或 n）之一                                               |
| [a-n]      | 返回字母顺序 a 和 n 之间的任意小写字符匹配项                                                    |
| [\^arn]    | 返回除 a、r 和 n 之外的任意字符的匹配项                                                         |
| [0123]     | 返回存在任何指定数字（0、1、2 或 3）的匹配项                                                    |
| [0-9]      | 返回 0 与 9 之间任意数字的匹配                                                                  |
| [0-5][0-9] | 返回介于 0 到 9 之间的任何数字的匹配项                                                          |
| [a-zA-Z]   | 返回字母顺序 a 和 z 之间的任何字符的匹配，小写或大写                                            |
| [+]        | 在集合中，+、\*、.、\|、()、\$、{} 没有特殊含义，因此 [+] 表示：返回字符串中任何 + 字符的匹配项 |

# 二十七、什么是 PIP？

PIP 是 Python 包或模块的包管理器。

**注释：如果您使用的是 Python 3.4 或更高版本，则默认情况下会包含 PIP。**

### 什么是包（Package）？

包中包含模块所需的所有文件。

模块是您可以包含在项目中的 Python 代码库。

### 检查是否已安装 PIP

将命令行导航到 Python 脚本目录所在的位置，然后键入以下内容：

### 下载包

下载包非常容易。

打开命令行界面并告诉 PIP 下载您需要的软件包。

将命令行导航到 Python 脚本目录的位置，然后键入以下内容：

```
pip install camelcase
```
现在，您已经下载并安装了第一个包！

### 使用包

安装包后，即可使用。

把 "camelcase" 包导入您的项目中。

导入并使用 "camelcase"：

```
import camelcase

c = camelcase.CamelCase()

txt = "hello world"

print(c.hump(txt))
```

### 删除包

请使用 uninstall 命令来删除包：

```
pip uninstall camelcase
```

PIP 包管理器会要求您确认是否需要删除 camelcase 包：

```
Uninstalling camelcase-02.1:
  Would remove:
    c:\...\python\python36-32\lib\site-packages\camecase-0.2-py3.6.egg-info
    c:\...\python\python36-32\lib\site-packages\camecase\*
Proceed (y/n)?
```

### 列出包

请使用 list 命令列出系统上安装的所有软件包：

```
pip list
```

Package         Version
-----------------------
camelcase       0.2
mysql-connector 2.1.6
pip             18.1
pymongo         3.6.1
setuptools      39.0.1

# 二十八、pythonTryException

try 块允许您测试代码块以查找错误。

except 块允许您处理错误。

finally 块允许您执行代码，无论 try 和 except 块的结果如何。

### 异常处理

当我们调用 Python 并发生错误或异常时，通常会停止并生成错误消息。

可以使用 try 语句处理这些异常：

try 块将生成异常，因为 x 未定义：

```
try:
  print(x)
except:
  print("An exception occurred")
```

\<re.Match object; span=(0, 5), match='China'\>

由于 try 块引发错误，因此会执行 except 块。

如果没有 try 块，程序将崩溃并引发错误：

该语句将引发错误，因为未定义 x：

```
print(x)
```

### 多个异常

您可以根据需要定义任意数量的 exception 块，例如，假如您要为特殊类型的错误执行特殊代码块：

如果 try 块引发 NameError，则打印一条消息，如果是其他错误则打印另一条消息：

```
try:
  print(x)
except NameError:
  print("Variable x is not defined")
except:
  print("Something else went wrong")
```

\<re.Match object; span=(0, 5), match='China'\>

在本例中，try 块不会生成任何错误：

```
try:
  print("Hello")
except:
  print("Something went wrong")
else:
  print("Nothing went wrong")
```

Hello

Nothing went wrong

### Finally

如果指定了 finally 块，则无论 try 块是否引发错误，都会执行 finally 块。

```
try:
  print(x)
except:
  print("Something went wrong")
finally:
  print("The 'try except' is finished")
```

\<re.Match object; span=(0, 5), match='China'\>

The 'try except' is finished

这对于关闭对象并清理资源非常有用：

试图打开并写入不可写的文件：

```
try:
  f = open("demofile.txt")
  f.write("Lorum Ipsum")
except:
  print("Something went wrong when writing to the file")
finally:
  f.close()
```

### 引发异常

作为 Python 开发者，您可以选择在条件发生时抛出异常。

如需抛出（引发）异常，请使用 raise 关键词。

假如 x 小于 0，则引发异常并终止程序：

```
x = -1

if x < 0:
  raise Exception("Sorry, no numbers below zero")
```

raise 关键字用于引发异常。

您能够定义所引发异常的类型、以及打印给用户的文本。

如果 x 不是整数，则引发 TypeError：

```
x = "hello"

if not type(x) is int:
  raise TypeError("Only integers are allowed")
```

# 二十九、命令行输入

Python 允许命令行输入。

这意味着我们能够要求用户输入。

Python 3.6 中的方法与 Python 2.7 略有不同。

Python 3.6 使用 input() 方法。

Python 2.7 使用 raw_input() 方法。

下面的例子会询问用户的姓名，当您输入名字时，名字将打印到屏幕上：

### Python 3.6

```
print("Enter your name:")
x = input()
print("Hello ", x)
```

Enter your name:

1

Hello 1

### Python 2.7

```
print("Enter your name:")
x = raw_input()
print("Hello ", x)
```

# 字符串 format()

**为了确保字符串按预期显示，我们可以使用format() 方法对结果进行格式化。**

format() 方法允许您格式化字符串的选定部分。

有时文本的一部分是你无法控制的，也许它们来自数据库或用户输入？

要控制此类值，请在文本中添加占位符（花括号 {}），然后通过 format() 方法运行值：

添加要显示价格的占位符：

```
price = 52
txt = "The price is {} dollars"
print(txt.format(price))
```

The price is 52 dollars

您可以在花括号内添加参数以指定如何转换值：

将价格格式化为带有两位小数的数字：

```
txt = "The price is {:.2f} dollars"
print(txt.format(price))
```

The price is 52.00 dollars

### 多个值

如需使用更多值，只需向 format() 方法添加更多值：

```
print(txt.format(price, itemno, count))
```

并添加更多占位符：

```
quantity = 3
itemno = 567
price = 52
myorder = "I want {} pieces of item number {} for {:.2f} dollars."
print(myorder.format(quantity, itemno, price))
```

I want 3 pieces of item number 567 for 52.00 dollars.

### 索引号

您可以使用索引号（花括号 {0} 内的数字）来确保将值放在正确的占位符中：

```
quantity = 3
itemno = 567
price = 52
myorder = "I want {0} pieces of item number {1} for {2:.2f} dollars."
print(myorder.format(quantity, itemno, price))
```

I want 3 pieces of item number 567 for 52.00 dollars.

此外，如果要多次引用相同的值，请使用索引号：

```
age = 63
name = "Bill"
txt = "His name is {1}. {1} is {0} years old."
print(txt.format(age, name))
```

His name is Bill. Bill is 63 years old.

### 命名索引

您还可以通过在花括号 {carname} 中输入名称来使用命名索引，但是在传递参数值 txt.format(carname = "Ford") 时，必须使用名称：

```
myorder = "I have a {carname}, it is a {model}."
print(myorder.format(carname = "Porsche", model = "911"))
```

I have a Porsche, it is a 911.

# 三十、文件处理

**文件处理是任何 Web 应用程序的重要组成部分。**

**Python 有几个用于创建、读取、更新和删除文件的函数。**



在 Python 中使用文件的关键函数是 open() 函数。

open() 函数有两个参数：文件名和模式。

有四种打开文件的不同方法（模式）：

-   "r" - 读取 - 默认值。打开文件进行读取，如果文件不存在则报错。
-   "a" - 追加 - 打开供追加的文件，如果不存在则创建该文件。
-   "w" - 写入 - 打开文件进行写入，如果文件不存在则创建该文件。
-   "x" - 创建 - 创建指定的文件，如果文件存在则返回错误。

此外，您可以指定文件是应该作为二进制还是文本模式进行处理。

-   "t" - 文本 - 默认值。文本模式。
-   "b" - 二进制 - 二进制模式（例如图像）。

### 语法

此外，您可以指定文件是应该作为二进制还是文本模式进行处理：

```
f = open("demofile.txt")
```

以上代码等同于：

```
f = open("demofile.txt", "rt")
```

因为 "r" (读取)和 "t" (文本)是默认值，所以不需要指定它们。

**注释：请确保文件存在，否则您将收到错误消息。**

# 三十一、在服务器上打开文件

假设我们有以下文件，位于与 Python 相同的文件夹中：

### demofile.txt

```
Hello! Welcome to demofile.txt
This file is for testing purposes.
Good Luck!
```


如需打开文件，请使用内建的 open() 函数。

open() 函数返回文件对象，此对象有一个 read() 方法用于读取文件的内容：

```
f = open("demofile.txt", "r")
print(f.read())
```

### 只读取文件的一部分

默认情况下，read() 方法返回整个文本，但您也可以指定要返回的字符数：

返回文件中的前五个字符：

```
f = open("demofile.txt", "r")
print(f.read(5))
```

### 读行

您可以使用 readline() 方法返回一行：

读取文件中的一行：

```
f = open("demofile.txt", "r")
print(f.readline())
```

通过两次调用 readline()，您可以读取前两行：

读取文件中的两行：

```
f = open("demofile.txt", "r")
print(f.readline())
print(f.readline())
```

通过循环遍历文件中的行，您可以逐行读取整个文件：

逐行遍历文件：

```
f = open("demofile.txt", "r")
for x in f:
  print(x)
```

### 关闭文件

完成后始终关闭文件是一个好习惯。

完成后关闭文件：

```
f = open("demofile.txt", "r")
print(f.readline())
f.close()
```

# 三十二、写入已有文件

如需写入已有的文件，必须向 open() 函数添加参数：

-   "a" - 追加 - 会追加到文件的末尾
-   "w" - 写入 - 会覆盖任何已有的内容

打开文件 "demofile2.txt" 并将内容追加到文件中：

```
f = open("demofile2.txt", "a")
f.write("Now the file has more content!")
f.close()

# 追加后，打开并读取该文件：
f = open("demofile2.txt", "r")
print(f.read())
```

打开文件 "demofile3.txt" 并覆盖内容：

```
f = open("demofile3.txt", "w")
f.write("Woops! I have deleted the content!")
f.close()

# 写入后，打开并读取该文件：
f = open("demofile3.txt", "r")
print(f.read())
```

**注释：**"w" 方法会覆盖全部内容。

### 创建新文件

如需在 Python 中创建新文件，请使用 open() 方法，并使用以下参数之一：

-   "x" - 创建 - 将创建一个文件，如果文件存在则返回错误
-   "a" - 追加 - 如果指定的文件不存在，将创建一个文件
-   "w" - 写入 - 如果指定的文件不存在，将创建一个文件

创建名为 "myfile.txt" 的文件：

```
f = open("myfile.txt", "x")
```

结果：已创建新的空文件！

如果不存在，则创建新文件：

```
f = open("myfile.txt", "w")
```