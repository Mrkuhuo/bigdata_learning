### Python 数字

Python 中有三种数字类型：

* int
* float
* complex

为变量赋值时，将创建数值类型的变量：
```
x = 10   # int
y = 6.3  # float
z = 2j   # complex
print(x)
print(y)
print(z)
```

10
6.3
2j

### Int

Int 或整数是完整的数字，正数或负数，没有小数，长度不限。
```
x = 10
y = 37216654545182186317
z = -465167846
```
### Float

浮动或“浮点数”是包含小数的正数或负数。
```
x = 3.50
y = 2.0
z = -63.78
```
浮点数也可以是带有“e”的科学数字，表示 10 的幂。
```
x = 27e4
y = 15E2
z = -49.8e100
```

### 复数

复数用 "j" 作为虚部编写：
```
x = 2+3j
y = 7j
z = -7j
```
### 类型转换
您可以使用 int()、float() 和 complex() 方法从一种类型转换为另一种类型：
```
x = 10 # int
y = 6.3 # float
z = 1j # complex

# 把整数转换为浮点数

a = float(x)

# 把浮点数转换为整数

b = int(y)

# 把整数转换为复数：

c = complex(x)
print(a)
print(b)
print(c)

print(type(a))
print(type(b))
print(type(c))
```

10.0
6
(10+0j)
<class 'float'>
<class 'int'>
<class 'complex'>

注意：您无法将复数转换为其他数字类型。
