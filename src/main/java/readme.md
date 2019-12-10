#使用test数据库
use test;
#定义游标类型
CREATE OR replace package types
AS
	TYPE cursorType IS REF CURSOR
END;
#建测试表，并插入数据
DROP TABLE emp;
CREATE TABLE emp(id string,deptno string);
INSERT INTO emp SELECT "a","aa" FROM SYSTEM.dual;
SELECT * FROM emp;
#建存储过程
create or replace procedure getEmpByDeptno(dno in string,emps out types.cursorType)
is
begin
open emps for select * from test.emp where deptno=dno;
end;
#手动执行，验收可正常运行
DECLARE
r types.cursorType
BEGIN
test.getEmpByDeptno("a",r)
END;
#程序运行结果
```
D:\Java\jdk1.8.0_202\bin\java.exe "-javaagent:D:\Java\JetBrains\IntelliJ IDEA 2018.3.1\lib\idea_rt.jar=52077:D:\Java\JetBrains\IntelliJ IDEA 2018.3.1\bin" -Dfile.encoding=UTF-8 -classpath D:\Java\jdk1.8.0_202\jre\lib\charsets.jar;D:\Java\jdk1.8.0_202\jre\lib\deploy.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\access-bridge-64.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\cldrdata.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\dnsns.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\jaccess.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\jfxrt.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\localedata.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\nashorn.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\sunec.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\sunjce_provider.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\sunmscapi.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\sunpkcs11.jar;D:\Java\jdk1.8.0_202\jre\lib\ext\zipfs.jar;D:\Java\jdk1.8.0_202\jre\lib\javaws.jar;D:\Java\jdk1.8.0_202\jre\lib\jce.jar;D:\Java\jdk1.8.0_202\jre\lib\jfr.jar;D:\Java\jdk1.8.0_202\jre\lib\jfxswt.jar;D:\Java\jdk1.8.0_202\jre\lib\jsse.jar;D:\Java\jdk1.8.0_202\jre\lib\management-agent.jar;D:\Java\jdk1.8.0_202\jre\lib\plugin.jar;D:\Java\jdk1.8.0_202\jre\lib\resources.jar;D:\Java\jdk1.8.0_202\jre\lib\rt.jar;C:\Users\gzliufu\IdeaProjects\transwarp-demo\demo-inceptor\target\classes;D:\Java\apache-maven-3.6.1-bin\LoalWarehouse\io\transwarp\inceptor\jdbc-driver\6.0.2\jdbc-driver-6.0.2.jar;D:\Java\apache-maven-3.6.1-bin\LoalWarehouse\oracle\ojdbc6\11.2.0.4\ojdbc6-11.2.0.4.jar CussorTest
log4j:WARN No appenders could be found for logger (org.apache.hive.jdbc.Utils).
log4j:WARN Please initialize the log4j system properly.
log4j:WARN See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.
aa

Process finished with exit code 0
```

