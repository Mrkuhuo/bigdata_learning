### Python 循环

Python 有两个原始的循环命令：

* while 循环
* for 循环

### while 循环

如果使用 while 循环，只要条件为真，我们就可以执行一组语句。

只要 i 小于 7，打印 i：

```
i = 1
while i < 7:
  print(i)
  i += 1
```

1
2
3
4
5
6

**注意：请记得递增 i，否则循环会永远继续。**

while 循环需要准备好相关的变量。在这个实例中，我们需要定义一个索引变量 i，我们将其设置为 1。
### break 语句

如果使用 break 语句，即使 while 条件为真，我们也可以停止循环：

```
i = 1
while i < 7:
  print(i)
  if i == 3:
    break
  i += 1
```

1
2
3
### continue 语句

如果使用 continue 语句，我们可以停止当前的迭代，并继续下一个：

如果 i 等于 3，则继续下一个迭代：

```
i = 0
while i < 7:
  i += 1 
  if i == 3:
    continue
  print(i)
```

1
2
4
5
6
7
### else 语句

通过使用 else 语句，当条件不再成立时，我们可以运行一次代码块：

```
i = 1
while i < 6:
  print(i)
  i += 1
else:
  print("i is no longer less than 6")
```

1
2
3
4
5
i is no longer less than 6