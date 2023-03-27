### 什么是 PIP？

PIP 是 Python 包或模块的包管理器。

**注释：如果您使用的是 Python 3.4 或更高版本，则默认情况下会包含 PIP。**

### 什么是包（Package）？

包中包含模块所需的所有文件。

模块是您可以包含在项目中的 Python 代码库。

### 检查是否已安装 PIP

将命令行导航到 Python 脚本目录所在的位置，然后键入以下内容：

### 下载包

下载包非常容易。

打开命令行界面并告诉 PIP 下载您需要的软件包。

将命令行导航到 Python 脚本目录的位置，然后键入以下内容：

```
pip install camelcase
```
现在，您已经下载并安装了第一个包！

### 使用包

安装包后，即可使用。

把 "camelcase" 包导入您的项目中。

导入并使用 "camelcase"：

```
import camelcase

c = camelcase.CamelCase()

txt = "hello world"

print(c.hump(txt))
```

### 删除包

请使用 uninstall 命令来删除包：

```
pip uninstall camelcase
```

PIP 包管理器会要求您确认是否需要删除 camelcase 包：

```
Uninstalling camelcase-02.1:
  Would remove:
    c:\...\python\python36-32\lib\site-packages\camecase-0.2-py3.6.egg-info
    c:\...\python\python36-32\lib\site-packages\camecase\*
Proceed (y/n)?
```

### 列出包

请使用 list 命令列出系统上安装的所有软件包：

```
pip list
```

Package         Version
-----------------------
camelcase       0.2
mysql-connector 2.1.6
pip             18.1
pymongo         3.6.1
setuptools      39.0.1
