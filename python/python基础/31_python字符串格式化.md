**为了确保字符串按预期显示，我们可以使用format() 方法对结果进行格式化。**

### 字符串 format()

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
