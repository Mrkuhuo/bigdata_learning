我们知道，使用 SQL 语句能够完成对 table 的增删改查操作，Pandas 同样也可以实现 SQL 语句的基本功能。本节主要讲解 Pandas 如何执行 SQL 操作。

首先加载一个某连锁咖啡厅地址分布的数据集，通过该数据集对本节内容进行讲解。

```
import pandas as pd
url = 'C:/Users/Administrator/Desktop/coffee/kafei.xlsx'
coffee_df=pd.read_excel(url)
coffee_df.head()
```

输出结果如下：

1 address category id tel

20 北京市东城区南竹竿胡同2号1幢2层30212号银河SOHOC座 娱乐休闲:咖啡厅 1874263549184796345 010-85179080

31 北京市东城区东直门内大街277-31号档口 娱乐休闲:咖啡厅 1461638360847848424 400-669-2002

42 北京市东城区王府井东街8号澳门中心L117商场102室 娱乐休闲:咖啡厅 1308505235389562852 400-010-0100

53 北京市东城区前门大街108号底商 娱乐休闲:咖啡厅 15442844740539053384

64 北京市东城区和平里西街51号雍和宫壹中心A座负一层 娱乐休闲:咖啡厅 2357391864111641256 4000100100

### SELECT

在 SQL 中，SELECT 查询语句使用,把要查询的每个字段分开，当然您也可以使用\*来选择所有的字段。如下所示：

```
SELECT address, category, id, tel FROM tips LIMIT 5;
```

对于 Pandas 而言，要完成 SELECT 查询，需要把数据集每一列（columns）的名称传递给 DataFrame 对象。如下所示：

```
coffee_df[['address','category','id','tel']].head()
```

下面代码是 Pandas 执行 SELECT 查询的完整程序：

```
import pandas as pd
url = 'C:/Users/Administrator/Desktop/coffee/kafei.xlsx'
coffee_df=pd.read_excel(url)
#只查看尾3行
coffee_df[['address', 'category', 'id', 'tel']].tail(3)
```

输出结果如下：

1 address category id tel

228912 新疆维吾尔自治区北屯市芳园路69-2-12 娱乐休闲:咖啡厅 7443833746160692626

328913 新疆维吾尔自治区北屯市北屯购物公园7-1-7 娱乐休闲:咖啡厅 15288143245642241877

428914 新疆维吾尔自治区可克达拉市人民西路与育才路交叉口西北50米 娱乐休闲:咖啡厅 17884214706482955

假如您传入的是一个空列表， 那最终结果将输出所有的行索引标签。

### WHERE

SQL 中的条件查询是通过 WHERE 子句完成的。格式如下所示：

```
SELECT * FROM coffee_df WHERE tel = '010-85179080';
```

然而 DataFrame 可以通过多种方式实现条件筛选，最直观的方法是通过布尔索引：

```
coffee_df[coffee_df['id'] == '1461638360847848424']
```

完整程序如下：

```
import pandas as pd
url = 'C:/Users/Administrator/Desktop/coffee/kafei.xlsx'
coffee_df=pd.read_excel(url)
coffee_df[coffee_df['tel'] == '400-010-0100'].head(5)
```

输出结果如下：

1address category id tel

22 北京市东城区王府井东街8号澳门中心L117商场102室 娱乐休闲:咖啡厅 1308505235389562852 400-010-0100

35 北京市东城区崇文门外大街3号崇文新世界百货一期南门一层 娱乐休闲:咖啡厅 3294587167648650139 400-010-0100

46 北京市东城区东四北大街265号文化金融大厦1层大堂 娱乐休闲:咖啡厅 3046481700882245722 400-010-0100

57 北京市东城区珠市口东大街2号丰泰中心1层 娱乐休闲:咖啡厅 3218554253235914037 400-010-0100

69 北京市东城区怡生健身居然大厦店休闲区 娱乐休闲:咖啡厅 3141197020974020427 400-010-0100

上面的语句通过布尔运算将 True 或 False 对象传递给 DataFrame 对象，然后返回所有为 True 的行。

### GroupBy

在 SQL 语句中，通过 GroupBy 操作可以获取 table 中一组记录的计数。示例如下：

```
SELECT id, count(*) FROM tips GROUP BY id;
```

而 Pandas 可通过以下代码实现：

```
coffe_df.groupby('id').size()
```

完整的程序如下所示：

```
import pandas as pd
url = 'C:/Users/Administrator/Desktop/coffee/kafei.xlsx'
coffee_df=pd.read_excel(url)
print(coffee_df.groupby('id').size())
```

输出结果：

1id

2938817537566269 1

31343221331916894 1

42068013370184103 1

52147497429057385 1

64021181356852391 1

7 ..

818443951046631684378 1

918444337559943971606 1

1018444494959108924300 1

1118445005868173060838 1

1218446259420330511125 1

13Length: 23240, dtype: int64

### LIMIT

在 SQL 中，LIMIT 语句主要起到限制作用，比如查询前 n 行记录：

```
SELECT * FROM coffee_df LIMIT n;
```

而在 Pandas 中，您可以通过 head() 来实现（默认前 5 行），示例如下：

```
import pandas as pd
url = 'C:/Users/Administrator/Desktop/coffee/kafei.xlsx'
coffee_df=pd.read_excel(url)
coffee_df[['address',  'tel']].head(3)
```

输出结果：

1 address tel

20 北京市东城区南竹竿胡同2号1幢2层30212号银河SOHOC座 010-85179080

31 北京市东城区东直门内大街277-31号档口 400-669-2002

42 北京市东城区王府井东街8号澳门中心L117商场102室 400-010-0100

本节主要通过对比的方式对 SQL 和 Pandas 做了简单讲解，希望对您有所帮助。
