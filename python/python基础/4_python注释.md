
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