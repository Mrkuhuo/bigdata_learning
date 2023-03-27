**lambda 函数是一种小的匿名函数。**

**lambda 函数可接受任意数量的参数，但只能有一个表达式。**

一个 lambda 函数，它把作为参数传入的数字加 10，然后打印结果：

```
x = lambda a : a + 10
print(x(5))
```

15

lambda 函数可接受任意数量的参数：

一个 lambda 函数，它把参数 a 与参数 b 相乘并打印结果：

```
x = lambda a, b : a * b
print(x(5, 6))
```

30

一个 lambda 函数，它把参数 a、b 和 c 相加并打印结果：

```
x = lambda a, b, c : a + b + c
print(x(5, 6, 2))
```

13
