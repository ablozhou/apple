# Apple 语言
这是为儿童创建的一门简单编程语言。
基于JVM，可以有较好的扩展。

# 依赖
- Java 1.8+
- Maven 3+

# 编译
进入项目目录。
```
$ mvn package
```

# 运行
hello.ap 是一个测试用文件.

```bash
$ java -jar compiler-1.0-SNAPSHOT-jar-with-dependencies.jar hello.ap
```

## hello.ap 
内容如下：
```
// test data
 // Computer v1.0
/* 这是一个多行的apple语言测试
    第一版主要实现复杂表达式，变量和注释

*/ //UTF-8

4+3*2
7 - 10 / 2  //with spaces.
 a=3;
3+a
3*(2+3)
b=3*2
c=b/ \
2 //another line
 e = 2+ (3*(3+2)-5)
 x = 3;
x
/* test other */
f=x+2
```
output:
```bash
10
2
3
6
15
6
3
12
3
3
5
out:5
```