### 在服务器上打开文件

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
