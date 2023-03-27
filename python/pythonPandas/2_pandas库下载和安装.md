Python 官方标准发行版并没有自带 Pandas 库，因此需要另行安装。除了标准发行版外，还有一些第三方机构发布的 Python 免费发行版， 它们在官方版本的基础上开发而来，并有针对性的提前安装了一些 Python 模块，从而满足某些特定领域的需求，比如专门适应于科学计算领域的 Anaconda，它就提前安装了多款适用于科学计算的软件包。

对于第三方发行版而言，它们已经自带 Pandas 库，所以无须另行安装。下面介绍了常用的免费发行版：

1.  Anaconda（官网下载：

[Anaconda \| The World's Most Popular Data Science Platform](https://www.anaconda.com/) ）是一个开源的 Python 发行版，包含了 180 多个科学包及其依赖项。除了支持 Windows 系统外，也支持 Linux 和 Mac 系统。

1.  Python(x,y)（下载地址：

[Python-xy.GitHub.io by python-xy](https://python-xy.github.io/) ）是一款基于 Python、Qt （图形用户界面）和 Spyder （交互式开发环境）开发的软件，主要用于数值计算、数据分析和数据可视化等工程项目，目前只支持 Python 2 版本。

1.  WinPython（下载地址：

[WinPython - Browse Files at SourceForge.net](https://sourceforge.net/projects/winpython/files/) ）一个免费的 Python 发行版，包含了常用的科学计算包与 Spyder IDE，但仅支持 Windows 系统。

下面介绍在不同操作系统环境下，标准发行版安装 Pandas 的方法。

### Windows系统安装

使用 pip 包管理器安装 Pandas，是最简单的一种安装方式。在 CMD 命令提示符界面行执行以下命令：

```
pip install pandas
```

### Linux系统安装

对于不同的版本的 Linux 系统，您可以采用它们各自的包管理器来安装 Pandas。

###  Ubuntu用户

Pandas 通常需要与其他软件包一起使用，因此可采用以下命令，一次性安装所有包：

```
sudo apt-get install numpy scipy matplotlib pandas
```

###  Fedora用户

对于 Fedora 用户而言，可采用以下命令安装：

```
sudo yum install numpy scipy matplotlib pandas
```

###  MacOSX系统安装

对于 Mac 用户而言，同样可以直接使用 pip 包管理器来安装，命令如下：

```
pip install pandas
```