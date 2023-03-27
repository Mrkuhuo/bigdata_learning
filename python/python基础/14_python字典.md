### 字典（Dictionary）

字典是一个无序、可变和有索引的集合。在 Python 中，字典用花括号编写，拥有键和值。

创建并打印字典：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
print(thisdict)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963}

### 访问项目

您可以通过在方括号内引用其键名来访问字典的项目：

获取 "model" 键的值：

```
x = thisdict["model"]
print(x)
```

911

还有一个名为 get() 的方法会给你相同的结果：

获取 "model" 键的值：

```
x = thisdict.get("model")
print(x)
```

911
### 更改值

您可以通过引用其键名来更改特定项的值：

把 "year" 改为 2019：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
thisdict["year"] = 2019
print(thisdict)
```

{'brand': 'Porsche', 'model': '911', 'year': 2019}

### 遍历字典

您可以使用 for 循环遍历字典。

循环遍历字典时，返回值是字典的键，但也有返回值的方法。

逐个打印字典中的所有键名：


brand
model
year

逐个打印字典中的所有值：

```
for x in thisdict:
  print(thisdict[x])
```

Porsche
911
2019

您还可以使用 values() 函数返回字典的值：

```
for x in thisdict.values():
  print(x)
```

Porsche
911
2019

通过使用 items() 函数遍历键和值：
```
for x, y in thisdict.items():
  print(x, y)
```

brand Porsche
model 911
year 2019
### 检查键是否存在

要确定字典中是否存在指定的键，请使用 in 关键字：

检查字典中是否存在 "model"：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
if "model" in thisdict:
  print("Yes, 'model' is one of the keys in the thisdict dictionary")
```

Yes, 'model' is one of the keys in the thisdict dictionary

### 字典长度

要确定字典有多少项目（键值对），请使用 len() 方法。

打印字典中的项目数：

```
print(len(thisdict))
```
3
### 添加项目

通过使用新的索引键并为其赋值，可以将项目添加到字典中：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
thisdict["color"] = "red"
print(thisdict)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963, 'color': 'red'}

### 删除项目

有几种方法可以从字典中删除项目：

pop() 方法删除具有指定键名的项：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
thisdict.pop("model")
print(thisdict)
```

{'brand': 'Porsche', 'year': 1963}


popitem() 方法删除最后插入的项目（在 3.7 之前的版本中，删除随机项目）：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
thisdict.popitem()
print(thisdict)
```

{'brand': 'Porsche', 'model': '911'}


### 实例

del 关键字删除具有指定键名的项目：
```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
del thisdict["model"]
print(thisdict)
```

{'brand': 'Porsche', 'year': 1963}


del 关键字也可以完全删除字典：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
del thisdict

print(thisdict) #this 会导致错误，因为 "thisdict" 不再存在。
```

NameError Traceback (most recent call last)~\AppData\Local\Temp\ipykernel_27696\3564800855.py in <module>6 del thisdict7----> 8 print(thisdict) #this 会导致错误，因为 "thisdict" 不再存在。NameError: name 'thisdict' is not defined

clear() 关键字清空字典：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
thisdict.clear()
print(thisdict)
```
{}
### 复制字典

您不能通过键入 dict2 = dict1 来复制字典，因为：dict2 只是对 dict1 的引用，而 dict1 中的更改也将自动在 dict2 中进行。


有一些方法可以进行复制，一种方法是使用内建的字典方法 copy()。

使用 copy() 方法来复制字典：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
mydict = thisdict.copy()
print(mydict)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963}


制作副本的另一种方法是使用内建方法 dict()。

使用 dict() 方法创建字典的副本：

```
thisdict =	{
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
mydict = dict(thisdict)
print(mydict)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963}

### 嵌套字典

词典也可以包含许多词典，这被称为嵌套词典。

创建包含三个字典的字典：

```
myfamily = {
  "child1" : {
    "name" : "Phoebe Adele",
    "year" : 2002
  },
  "child2" : {
    "name" : "Jennifer Katharine",
    "year" : 1996
  },
  "child3" : {
    "name" : "Rory John",
    "year" : 1999
  }
}
print(myfamily)
```

{'child1': {'name': 'Phoebe Adele', 'year': 2002}, 'child2': {'name': 'Jennifer Katharine', 'year': 1996}, 'child3': {'name': 'Rory John', 'year': 1999}}

或者，如果您想嵌套三个已经作为字典存在的字典：

创建三个字典，然后创建一个包含其他三个字典的字典：

```
child1 = {
  "name" : "Phoebe Adele",
  "year" : 2002
}
child2 = {
  "name" : "Jennifer Katharine",
  "year" : 1996
}
child3 = {
  "name" : "Rory John",
  "year" : 1999
}

myfamily = {
  "child1" : child1,
  "child2" : child2,
  "child3" : child3
}
print(myfamily)
```

{'child1': {'name': 'Phoebe Adele', 'year': 2002}, 'child2': {'name': 'Jennifer Katharine', 'year': 1996}, 'child3': {'name': 'Rory John', 'year': 1999}}
### dict() 构造函数

也可以使用 dict() 构造函数创建新的字典：

```
thisdict = dict(brand="Porsche", model="911", year=1963)
# 请注意，关键字不是字符串字面量
# 请注意，使用了等号而不是冒号来赋值
print(thisdict)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963}

### 字典方法

Python 提供一组可以在字典上使用的内建方法。

| 方法         | 描述                                                   |
|--------------|--------------------------------------------------------|
| clear()      | 删除字典中的所有元素                                   |
| copy()       | 返回字典的副本                                         |
| fromkeys()   | 返回拥有指定键和值的字典                               |
| get()        | 返回指定键的值                                         |
| items()      | 返回包含每个键值对的元组的列表                         |
| keys()       | 返回包含字典键的列表                                   |
| pop()        | 删除拥有指定键的元素                                   |
| popitem()    | 删除最后插入的键值对                                   |
| setdefault() | 返回指定键的值。如果该键不存在，则插入具有指定值的键。 |
| update()     | 使用指定的键值对字典进行更新                           |
| values()     | 返回字典中所有值的列表                                 |
删除 car 列表中的所有元素：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
car.clear()
print(car)
```

{}

复制 car 字典：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.copy()
print(x)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963}


创建拥有 3 个键的字典，值均为 0：

```
x = ('key1', 'key2', 'key3')
y = 0
thisdict = dict.fromkeys(x, y)
print(thisdict)
```

{'key1': 0, 'key2': 0, 'key3': 0}


获取 "model" 项的值：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.get("model")
print(x)
```

911

返回字典的键值对：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.items()
print(x)
```

dict_items([('brand', 'Porsche'), ('model', '911'), ('year', 1963)])


返回键：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.keys()
print(x)
```

dict_keys(['brand', 'model', 'year'])


从字典中删除 "model"：
```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
car.pop("model")
print(car)
```

{'brand': 'Porsche', 'year': 1963}


从字典中删除最后一个项目：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
car.popitem()
print(car)
```

{'brand': 'Porsche', 'model': '911'}


获取 "model" 项的值：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.setdefault("map", "Macan")
print(x)
```

Macan

向字典插入项目：
```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
car.update({"color": "White"})
print(car)
```

{'brand': 'Porsche', 'model': '911', 'year': 1963, 'color': 'White'}


返回值：

```
car = {
  "brand": "Porsche",
  "model": "911",
  "year": 1963
}
x = car.values()
print(x)
```

dict_values(['Porsche', '911', 1963])