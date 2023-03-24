### Python 缩进

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