Pandas 提供的 merge() 函数能够进行高效的合并操作，这与 SQL 关系型数据库的 MERGE 用法非常相似。从字面意思上不难理解，merge 翻译为“合并”，指的是将两个 DataFrame 数据表按照指定的规则进行连接，最后拼接成一个新的 DataFrame 数据表。

merge() 函数的法格式如下：

```
pd.merge(left, right, how='inner', on=None, left_on=None, right_on=None,left_index=False, right_index=False, sort=True,suffixes=('_x', '_y'), copy=True)
```

参数说明，如下表所示：

| 参数名称    | 说明                                                                                                                                                              |
|-------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| left/right  | 两个不同的 DataFrame 对象。                                                                                                                                       |
| on          | 指定用于连接的键（即列标签的名字），该键必须同时存在于左右两个 DataFrame 中，如果没有指定，并且其他参数也未指定， 那么将会以两个 DataFrame 的列名交集做为连接键。 |
| left_on     | 指定左侧 DataFrame 中作连接键的列名。该参数在左、右列标签名不相同，但表达的含义相同时非常有用。                                                                   |
| right_on    | 指定左侧 DataFrame 中作连接键的列名。                                                                                                                             |
| left_index  | 布尔参数，默认为 False。如果为 True 则使用左侧 DataFrame 的行索引作为连接键，若 DataFrame 具有多层 索引(MultiIndex)，则层的数量必须与连接键的数量相等。           |
| right_index | 布尔参数，默认为 False。如果为 True 则使用左侧 DataFrame 的行索引作为连接键。                                                                                     |
| how         | 要执行的合并类型，从 {'left', 'right', 'outer', 'inner'} 中取值，默认为“inner”内连接。                                                                            |
| sort        | 布尔值参数，默认为True，它会将合并后的数据进行排序；若设置为 False，则按照 how 给定的参数值进行排序。                                                             |
| suffixes    | 字符串组成的元组。当左右 DataFrame 存在相同列名时，通过该参数可以在相同的列名后附加后缀名，默认为('_x','_y')。                                                    |
| copy        | 默认为 True，表示对数据进行复制。                                                                                                                                 |

**注意：Pandas 库的 merge() 支持各种内外连接，与其相似的还有 join() 函数（默认为左连接）。**

下面创建两个不同的 DataFrame，然后对它们进行合并操作：

```
import pandas as pd 
left = pd.DataFrame({ 
   'id':[1,2,3,4], 
   'Name': ['Smith', 'Maiki', 'Hunter', 'Hilen'], 
   'subject_id':['sub1','sub2','sub4','sub6']}) 
right = pd.DataFrame({ 
    'id':[1,2,3,4], 
   'Name': ['William', 'Albert', 'Tony', 'Allen'], 
   'subject_id':['sub2','sub4','sub3','sub6']}) 
print (left) 
print (right)  
```

输出如下：

1 id Name subject_id

20 1 Smith sub1

31 2 Maiki sub2

42 3 Hunter sub4

53 4 Hilen sub6

6

7 id Name subject_id

80 1 William sub2

91 2 Albert sub4

102 3 Tony sub3

113 4 Allen sub6

#### 1) 在单个键上进行合并操作

通过 on 参数指定一个连接键，然后对上述 DataFrame 进行合并操作：

```
import pandas as pd 
left = pd.DataFrame({ 
   'id':[1,2,3,4], 
   'Name': ['Smith', 'Maiki', 'Hunter', 'Hilen'], 
   'subject_id':['sub1','sub2','sub4','sub6']}) 
right = pd.DataFrame({ 
    'id':[1,2,3,4], 
   'Name': ['William', 'Albert', 'Tony', 'Allen'], 
   'subject_id':['sub2','sub4','sub3','sub6']})
#通过on参数指定合并的键
print(pd.merge(left,right,on='id'))
```

输出结果：

1 id Name_x subject_id_x Name_y subject_id_y

20 1 Smith sub1 William sub2

31 2 Maiki sub2 Albert sub4

42 3 Hunter sub4 Tony sub3

53 4 Hilen sub6 Allen sub6

#### 2) 在多个键上进行合并操作

下面示例，指定多个键来合并上述两个 DataFrame 对象：

```
import pandas as pd 
left = pd.DataFrame({ 
   'id':[1,2,3,4], 
   'Name': ['Smith', 'Maiki', 'Hunter', 'Hilen'], 
   'subject_id':['sub1','sub2','sub4','sub6']}) 
right = pd.DataFrame({ 
    'id':[1,2,3,4], 
   'Name': ['Bill', 'Lucy', 'Jack', 'Mike'], 
   'subject_id':['sub2','sub4','sub3','sub6']}) 
print(pd.merge(left,right,on=['id','subject_id']))
```

输出结果：

1 id Name_x subject_id Name_y

20 4 Hilen sub6 Mike

### 使用how参数合并

通过how参数可以确定 DataFrame 中要包含哪些键，如果在左表、右表都不存的键，那么合并后该键对应的值为 NaN。为了便于大家学习，我们将 how 参数和与其等价的 SQL 语句做了总结：

| Merge方法 | 等效 SQL         | 描述                      |
|-----------|------------------|---------------------------|
| left      | LEFT OUTER JOIN  | 使用左侧对象的key         |
| right     | RIGHT OUTER JOIN | 使用右侧对象的key         |
| outer     | FULL OUTER JOIN  | 使用左右两侧所有key的并集 |
| inner     | INNER JOIN       | 使用左右两侧key的交集     |

#### 1) left join

```
import pandas as pd 
left = pd.DataFrame({ 
   'id':[1,2,3,4], 
   'Name': ['Smith', 'Maiki', 'Hunter', 'Hilen'], 
   'subject_id':['sub1','sub2','sub4','sub6']}) 
right = pd.DataFrame({ 
    'id':[1,2,3,4], 
   'Name': ['Bill', 'Lucy', 'Jack', 'Mike'], 
   'subject_id':['sub2','sub4','sub3','sub6']}) 
#以left侧的subject_id为键
print(pd.merge(left,right,on='subject_id',how="left"))
```

输出结果：

1 id_x Name_x subject_id id_y Name_y

20 1 Smith sub1 NaN NaN

31 2 Maiki sub2 1.0 Bill

42 3 Hunter sub4 2.0 Lucy

53 4 Hilen sub6 4.0 Mike

#### 2) right join

```
import pandas as pd 
left = pd.DataFrame({ 
   'id':[1,2,3,4], 
   'Name': ['Smith', 'Maiki', 'Hunter', 'Hilen'], 
   'subject_id':['sub1','sub2','sub4','sub6']}) 
right = pd.DataFrame({ 
    'id':[1,2,3,4], 
   'Name': ['Bill', 'Lucy', 'Jack', 'Mike'], 
   'subject_id':['sub2','sub4','sub3','sub6']}) 
#以right侧的subject_id为键
print(pd.merge(left,right,on='subject_id',how="right"))
```

输出结果：

1 id_x Name_x subject_id id_y Name_y

20 2.0 Maiki sub2 1 Bill

31 3.0 Hunter sub4 2 Lucy

42 4.0 Hilen sub6 4 Mike

53 NaN NaN sub3 3 Jack

#### 3) outer join(并集)

```
import pandas as pd 
left = pd.DataFrame({ 
   'id':[1,2,3,4], 
   'Name': ['Smith', 'Maiki', 'Hunter', 'Hilen'], 
   'subject_id':['sub1','sub2','sub4','sub6']}) 
right = pd.DataFrame({ 
    'id':[1,2,3,4], 
   'Name': ['Bill', 'Lucy', 'Jack', 'Mike'], 
   'subject_id':['sub2','sub4','sub3','sub6']}) 
#求出两个subject_id的并集，并作为键
print(pd.merge(left,right,on='subject_id',how="outer"))
```

输出结果：

1 id_x Name_x subject_id id_y Name_y

20 1.0 Smith sub1 NaN NaN

31 2.0 Maiki sub2 1.0 Bill

42 3.0 Hunter sub4 2.0 Lucy

53 4.0 Hilen sub6 4.0 Mike

64 NaN NaN sub3 3.0 Jack

#### 4) inner join(交集)

```
import pandas as pd 
left = pd.DataFrame({ 
   'id':[1,2,3,4], 
   'Name': ['Smith', 'Maiki', 'Hunter', 'Hilen'], 
   'subject_id':['sub1','sub2','sub4','sub6']}) 
right = pd.DataFrame({ 
    'id':[1,2,3,4], 
   'Name': ['Bill', 'Lucy', 'Jack', 'Mike'], 
   'subject_id':['sub2','sub4','sub3','sub6']}) 
#求出两个subject_id的交集，并将结果作为键
print(pd.merge(left,right,on='subject_id',how="inner"))
```

输出结果：

1 id_x Name_x subject_id id_y Name_y

20 2 Maiki sub2 1 Bill

31 3 Hunter sub4 2 Lucy

42 4 Hilen sub6 4 Mike

注意：当 a 与 b 进行内连操作时 a.join(b) 不等于 b.join(a)。
