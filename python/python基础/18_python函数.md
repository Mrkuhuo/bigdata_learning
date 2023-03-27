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