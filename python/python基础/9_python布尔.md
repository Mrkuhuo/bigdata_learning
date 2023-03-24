**布尔表示两值之一：True 或 False。**

### 布尔值

在编程中，您通常需要知道表达式是 True 还是 False。
您可以计算 Python 中的任何表达式，并获得两个答案之一，即 True 或 False。
比较两个值时，将对表达式求值，Python 返回布尔值答案：
```
print(8 > 7)
print(8 == 7)
print(8 < 7)
```

True
False
False

当在 if 语句中运行条件时，Python 返回 True 或 False：
```
a = 200
b = 33

if b > a:
  print("b is greater than a")
else:
  print("b is not greater than a")
```

b is not greater than a
### 评估值和变量

bool() 函数可让您评估任何值，并为您返回 True 或 False。
```
print(bool("Hello"))
print(bool(10))
```

True
True

### 大多数值都为 True

如果有某种内容，则几乎所有值都将评估为 True。
除空字符串外，任何字符串均为 True。
除 0 外，任何数字均为 True。
除空列表外，任何列表、元组、集合和字典均为 True。
### 某些值为 False

实际上，除空值（例如 ()、[]、{}、""、数字 0 和值 None）外，没有多少值会被评估为 False。当然，值 False 的计算结果为 False。
```
bool(False)
bool(None)
bool(0)
bool("")
bool(())
bool([])
bool({})
```

False