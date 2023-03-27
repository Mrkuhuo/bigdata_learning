### 命令行输入

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
