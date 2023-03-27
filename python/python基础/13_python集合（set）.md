
集合是无序和无索引的集合。在 Python 中，集合用花括号编写。

创建集合：

```
thisset = {"apple", "banana", "cherry"}
print(thisset)
```

{'banana', 'apple', 'cherry'}


**注意：集合是无序的，因此您无法确定项目的显示顺序。**
### 访问项目

您无法通过引用索引来访问 set 中的项目，因为 set 是无序的，项目没有索引。

但是您可以使用 for 循环遍历 set 项目，或者使用 in 关键字查询集合中是否存在指定值。

遍历集合，并打印值：

```
thisset = {"apple", "banana", "cherry"}
for x in thisset:
  print(x)
```

banana
apple
cherry

检查 set 中是否存在 “banana”：

```
thisset = {"apple", "banana", "cherry"}
print("banana" in thisset)
```

True

### 更改项目

集合一旦创建，您就无法更改项目，但是您可以添加新项目。
### 添加项目

要将一个项添加到集合，请使用 add() 方法。

要向集合中添加多个项目，请使用 update() 方法。

使用 add() 方法向 set 添加项目：

```
thisset = {"apple", "banana", "cherry"}
thisset.add("orange")
print(thisset)
```

{'banana', 'apple', 'cherry', 'orange'}


使用 update() 方法将多个项添加到集合中：

```
thisset = {"apple", "banana", "cherry"}
thisset.update(["orange", "mango", "grapes"])
print(thisset)
```

{'banana', 'orange', 'mango', 'apple', 'grapes', 'cherry'}

### 获取 Set 的长度

要确定集合中有多少项，请使用 len() 方法。

获取集合中的项目数：

```
thisset = {"apple", "banana", "cherry"}
print(len(thisset))
```
3
### 删除项目

要删除集合中的项目，请使用 remove() 或 discard() 方法。

使用 remove() 方法来删除 “banana”：

```
thisset = {"apple", "banana", "cherry"}
thisset.remove("banana")
print(thisset)
```

{'apple', 'cherry'}

注释：如果要删除的项目不存在，则 remove() 将引发错误。

使用 discard() 方法来删除 “banana”：

```
thisset = {"apple", "banana", "cherry"}
thisset.discard("banana")
print(thisset)
```

{'apple', 'cherry'}


注释：如果要删除的项目不存在，则 discard() 不会引发错误。

您还可以使用 pop() 方法删除项目，但此方法将删除最后一项。请记住，set 是无序的，因此您不会知道被删除的是什么项目。

pop() 方法的返回值是被删除的项目

使用 pop() 方法删除最后一项：

```
thisset = {"apple", "banana", "cherry"}
x = thisset.pop()
print(x)
print(thisset)
```

set()

del 彻底删除集合：
```
thisset = {"apple", "banana", "cherry"}
del thisset
print(thisset)
```

NameError Traceback (most recent call last)~\AppData\Local\Temp\ipykernel_27696\3077915618.py in <module>3 del thisset4----> 5 print(thisset)NameError: name 'thisset' is not defined

### 合并两个集合

在 Python 中，有几种方法可以连接两个或多个集合。

您可以使用 union() 方法返回包含两个集合中所有项目的新集合，也可以使用 update() 方法将一个集合中的所有项目插入另一个集合中：

union() 方法返回一个新集合，其中包含两个集合中的所有项目：

```
set1 = {"a", "b" , "c"}
set2 = {1, 2, 3}
set3 = set1.union(set2)
print(set3)
```

{1, 2, 3, 'b', 'a', 'c'}


update() 方法将 set2 中的项目插入 set1 中：
```
set1 = {"a", "b" , "c"}
set2 = {1, 2, 3}
set1.update(set2)
print(set1)
```

{1, 2, 3, 'b', 'a', 'c'}

注释：union() 和 update() 都将排除任何重复项。
### set() 构造函数

也可以使用 set() 构造函数来创建集合。

使用 set() 构造函数来创建集合：
```
thisset = set(("apple", "banana", "cherry")) # 请留意这个双括号
print(thisset)
```

{'banana', 'apple', 'cherry'}

### Set 方法
| 方法                          | 描述                                         |
|-------------------------------|----------------------------------------------|
| add()                         | 向集合添加元素。                             |
| clear()                       | 删除集合中的所有元素。                       |
| copy()                        | 返回集合的副本。                             |
| difference()                  | 返回包含两个或更多集合之间差异的集合。       |
| difference_update()           | 删除此集合中也包含在另一个指定集合中的项目。 |
| discard()                     | 删除指定项目。                               |
| intersection()                | 返回为两个其他集合的交集的集合。             |
| intersection_update()         | 删除此集合中不存在于其他指定集合中的项目。   |
| isdisjoint()                  | 返回两个集合是否有交集。                     |
| issubset()                    | 返回另一个集合是否包含此集合。               |
| issuperset()                  | 返回此集合是否包含另一个集合。               |
| pop()                         | 从集合中删除一个元素。                       |
| remove()                      | 删除指定元素。                               |
| symmetric_difference()        | 返回具有两组集合的对称差集的集合。           |
| symmetric_difference_update() | 插入此集合和另一个集合的对称差集。           |
| union()                       | 返回包含集合并集的集合。                     |
| update()                      | 用此集合和其他集合的并集来更新集合。         |
向 fruits 集合添加一个元素：
```
fruits = {"apple", "banana", "cherry"}
fruits.add("orange") 
print(fruits)
```

{'banana', 'apple', 'cherry', 'orange'}


从 fruits 集合删除所有元素：
```
fruits = {"apple", "banana", "cherry"}
fruits.clear()
print(fruits)
```

set()


复制 fruits 集合：
```
fruits = {"apple", "banana", "cherry"}
x = fruits.copy()
print(x)
```

{'banana', 'apple', 'cherry'}

返回一个集合，其中包含仅存在于集合 x 中而不存在于集合 y 中的项目：
```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
z = x.difference(y) 
print(z)
```
{'banana', 'cherry'}

删除两个集合中都存在的项目：
```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
x.difference_update(y) 
print(x)
```

{'banana', 'cherry'}


**注意：different_update() 方法将删除两个集合中都存在的项目。**

difference_update() 方法与 difference() 方法不同，因为 difference() 方法返回一个新集合，其中没有不需要的项目，而 difference_update() 方法从原始集中删除了不需要的项目。

从集合中删除 "banana"：

```
fruits = {"apple", "banana", "cherry"}
fruits.discard("banana") 
print(fruits)
```

{'apple', 'cherry'}


**注意：discard() 方法从集合中删除指定项目。**

此方法与 remove() 方法不同，因为如果指定的项目不存在，则 remove() 方法将引发错误，而 discard() 方法不会。

返回包含存在于集合 x 和集合 y 中的项目的集合：

```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
z = x.intersection(y) 
print(z)
```

{'apple'}


**注意：intersection() 方法返回包含两个或更多集合之间相似性的集合。**

含义：返回的集合仅包含两个集合中都存在的项目，或者如果使用两个以上的集合进行比较，则在所有集合中都存在。

删除集合 x 和集合 y 都不存在的项目：
```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
x.intersection_update(y) 
print(x)
```

{'apple'}

**注意：intersection_update() 方法会删除各集合中都不存在的项目。**

intersection_update() 方法与 intersection() 方法不同，因为 intersection() 方法返回一个新集合，其中没有不需要的项目，而 intersection_update() 方法从原始集中删除了不需要的项目。

**所有集合 x 中没有项目存在于集合 y 中，则返回 True：**
```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "facebook"}
z = x.isdisjoint(y) 
print(z)
```

True

注意：如果没有项目同时存在于不同集合中，则 isdisjoint() 方法返回 True，否则返回 False。

如果集合 y 中存在集合 x 中的所有项目，则返回 True：

```
x = {"a", "b", "c"}
y = {"f", "e", "d", "c", "b", "a"}
z = x.issubset(y) 
print(z)
```

True

假如集合 y 中的所有项目都存在于集合 x 中，则返回 True：
```
x = {"f", "e", "d", "c", "b", "a"}
y = {"a", "b", "c"}
z = x.issuperset(y) 
print(z)
```

True

从集合中删除一个随机的项目：
```
fruits = {"apple", "banana", "cherry"}
fruits.pop() 
print(fruits)
```

{'apple', 'cherry'}


从集合中删除 "banana"：
```
fruits = {"apple", "banana", "cherry"}
fruits.remove("banana") 
print(fruits)
```
{'apple', 'cherry'}

返回一个集合，其中包含两个集合中的所有项目，但两个集合中都存在的项目除外：
```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
z = x.symmetric_difference(y) 
print(z)
```

{'banana', 'google', 'microsoft', 'cherry'}


删除两集合中不是都有的项目:

```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
x.symmetric_difference_update(y) 
print(x)
```

{'banana', 'google', 'microsoft', 'cherry'}


返回包含两个集合中所有项目的集合，重复项被排除在外：

```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
z = x.union(y) 
print(z)
```

{'banana', 'apple', 'cherry', 'google', 'microsoft'}


把集合 y 中的项目插入集合 x：

```
x = {"apple", "banana", "cherry"}
y = {"google", "microsoft", "apple"}
x.update(y) 
print(x)
```

{'banana', 'apple', 'cherry', 'google', 'microsoft'}