**RegEx 或正则表达式是形成搜索模式的字符序列。**

**RegEx 可用于检查字符串是否包含指定的搜索模式。**

### RegEx 模块

Python 提供名为 re 的内置包，可用于处理正则表达式。

导入 re 模块：

```
import re
```

### Python 中的 RegEx

导入 re 模块后，就可以开始使用正则表达式了：

### 实例

检索字符串以查看它是否以 "China" 开头并以 "country" 结尾：

```
import re

txt = "China is a great country"
x = re.search("^China.*country$", txt)
```

### RegEx 函数

re 模块提供了一组函数，允许我们检索字符串以进行匹配：

| 函数    | 描述                                              |
|---------|---------------------------------------------------|
| findall | 返回包含所有匹配项的列表                          |
| search  | 如果字符串中的任意位置存在匹配，则返回 Match 对象 |
| split   | 返回在每次匹配时拆分字符串的列表                  |
| sub     | 用字符串替换一个或多个匹配项                      |

### findall() 函数

findall() 函数返回包含所有匹配项的列表。

打印所有匹配的列表：

```
import re

str = "China is a great country"
x = re.findall("a", str)
print(x)
```

['a', 'a', 'a']

这个列表以被找到的顺序包含匹配项。

如果未找到匹配项，则返回空列表：

如果未找到匹配，则返回空列表：

```
import re

str = "China is a great country"
x = re.findall("USA", str)
print(x)
```

[]

### search() 函数

search() 函数搜索字符串中的匹配项，如果存在匹配则返回 Match 对象。

如果有多个匹配，则仅返回首个匹配项：

在字符串中搜索第一个字符 is ：

```
import re

str = "China is a great country"
x = re.search("is", str)

print("The first white-space character is located in position:", x.start())
```

如果未找到匹配，则返回值 None：

进行不返回匹配的检索：

```
import re

str = "China is a great country"
x = re.search("USA", str)
print(x)
```

None

Match 对象提供了用于取回有关搜索及结果信息的属性和方法：

-   span() 返回的元组包含了匹配的开始和结束位置
-   .string 返回传入函数的字符串
-   group() 返回匹配的字符串部分

打印首个匹配出现的位置（开始和结束位置）。

正则表达式查找以大写 "C" 开头的任何单词：

```
import re

str = "China is a great country"
x = re.search(r"\bC\w+", str)
print(x.span())
```

(0, 5)

打印传入函数的字符串：

```
import re

str = "China is a great country"
x = re.search(r"\bC\w+", str)
print(x.string)
```

China is a great country

打印匹配的字符串部分。

正则表达式查找以大写 "C" 开头的任何单词：

```
import re

str = "China is a great country"
x = re.search(r"\bC\w+", str)
print(x.group())
```

China

### split() 函数

split() 函数返回一个列表，其中字符串在每次匹配时被拆分：

在每个空白字符处进行拆分：

```
import re

str = "China is a great country"
x = re.split("\s", str)
print(x)
```

['China', 'is', 'a', 'great', 'country']

您可以通过指定 maxsplit 参数来控制出现次数：

仅在首次出现时拆分字符串：

```
import re

str = "China is a great country"
x = re.split("\s", str, 1)
print(x)
```

['China', 'is a great country']

### sub() 函数

sub() 函数把匹配替换为您选择的文本：

用数字 9 替换每个空白字符：

```
import re

str = "China is a great country"
x = re.sub("\s", "9", str)
print(x)
```

China9is9a9great9country

您可以通过指定 count 参数来控制替换次数：

替换前两次出现：

```
import re

str = "China is a great country"
x = re.sub("\s", "9", str, 2)
print(x)
```

China9is9a great country

### 特殊序列

特殊序列指的是 \\ 后跟下表中的某个字符，拥有特殊含义：

| 字符 | 描述                                                                                              | 示例                |
|------|---------------------------------------------------------------------------------------------------|---------------------|
| \\A  | 如果指定的字符位于字符串的开头，则返回匹配项                                                      | "\\AThe"            |
| \\b  | 返回指定字符位于单词的开头或末尾的匹配项                                                          | r"\\bain" r"ain\\b" |
| \\B  | 返回指定字符存在的匹配项，但不在单词的开头（或结尾处）                                            | r"\\Bain" r"ain\\B" |
| \\d  | 返回字符串包含数字的匹配项（数字 0-9）                                                            | "\\d"               |
| \\D  | 返回字符串不包含数字的匹配项                                                                      | "\\D"               |
| \\s  | 返回字符串包含空白字符的匹配项                                                                    | "\\s"               |
| \\S  | 返回字符串不包含空白字符的匹配项                                                                  | "\\S"               |
| \\w  | 返回一个匹配项，其中字符串包含任何单词字符 （从 a 到 Z 的字符，从 0 到 9 的数字和下划线 \_ 字符） | "\\w"               |
| \\W  | 返回一个匹配项，其中字符串不包含任何单词字符                                                      | "\\W"               |
| \\Z  | 如果指定的字符位于字符串的末尾，则返回匹配项                                                      | "Spain\\Z"          |

### 集合（Set）

集合（Set）是一对方括号 [] 内的一组字符，具有特殊含义：

| 集合       | 描述                                                                                            |
|------------|-------------------------------------------------------------------------------------------------|
| [arn]      | 返回一个匹配项，其中存在指定字符（a，r 或 n）之一                                               |
| [a-n]      | 返回字母顺序 a 和 n 之间的任意小写字符匹配项                                                    |
| [\^arn]    | 返回除 a、r 和 n 之外的任意字符的匹配项                                                         |
| [0123]     | 返回存在任何指定数字（0、1、2 或 3）的匹配项                                                    |
| [0-9]      | 返回 0 与 9 之间任意数字的匹配                                                                  |
| [0-5][0-9] | 返回介于 0 到 9 之间的任何数字的匹配项                                                          |
| [a-zA-Z]   | 返回字母顺序 a 和 z 之间的任何字符的匹配，小写或大写                                            |
| [+]        | 在集合中，+、\*、.、\|、()、\$、{} 没有特殊含义，因此 [+] 表示：返回字符串中任何 + 字符的匹配项 |
