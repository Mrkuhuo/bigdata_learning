### Python 继承

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
