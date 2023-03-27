### Python 类/对象

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
