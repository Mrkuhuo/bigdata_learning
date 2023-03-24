### 创建变量

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