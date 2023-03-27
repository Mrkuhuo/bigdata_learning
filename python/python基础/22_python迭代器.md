### Python 迭代器

迭代器是一种对象，该对象包含值的可计数数字。

迭代器是可迭代的对象，这意味着您可以遍历所有值。

从技术上讲，在 Python 中，迭代器是实现迭代器协议的对象，它包含方法 \__iter__() 和 \__next__()。

### 迭代器 VS 可迭代对象（Iterable）

列表、元组、字典和集合都是可迭代的对象。它们是可迭代的容器，您可以从中获取迭代器（Iterator）。

所有这些对象都有用于获取迭代器的 iter() 方法：

从元组返回一个迭代器，并打印每个值：

```
mytuple = ("apple", "banana", "cherry")
myit = iter(mytuple)

print(next(myit))
print(next(myit))
print(next(myit))
```

apple

banana

cherry

甚至连字符串都是可迭代的对象，并且可以返回迭代器：

字符串也是可迭代的对象，包含一系列字符：

```
mystr = "banana"
myit = iter(mystr)

print(next(myit))
print(next(myit))
print(next(myit))
print(next(myit))
print(next(myit))
print(next(myit))
```

b

a

n

a

n

a

### 遍历迭代器

我们也可以使用 for 循环遍历可迭代对象：

迭代元组的值：

```
mytuple = ("apple", "banana", "cherry")

for x in mytuple:
  print(x)
```

apple

banana

cherry

迭代字符串中的字符：

```
mystr = "banana"

for x in mystr:
  print(x)
```

b

a

n

a

n

a

**提示：for 循环实际上创建了一个迭代器对象，并为每个循环执行 next() 方法。**
