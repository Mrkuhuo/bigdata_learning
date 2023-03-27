### 写入已有文件

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