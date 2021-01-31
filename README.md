# Web-Project-JSP(이디야)

## 환경
- windows10
- JDK1.8
- tomcat9.0
- sts tool
- mysql8.0
- postman
- lombok
- jstl
- gson(json 파싱)
- git

## MySQL 데이터베이스 생성 및 사용자 생성
```sql
create user 'ediyauser'@'%' identified by 'bitc5600';
GRANT ALL privileges on *.* TO 'ediyauser'@'%';
create database ediyadb;
```

## MySQL 테이블 생성
- ediyauser 사용자로 접속
- 데이터베이스 선택 use ediyadb;

### User 테이블
```sql
create table user(
    id int primary key auto_increment,
    email varchar(100) not null unique,
    username varchar(100) not null,
    phone varchar(11) not null,
    password varchar(100) not null,
    nickname varchar(100),
    userRole varchar(20),
    createDate timestamp
)engine=InnoDB default charset=utf8;
```

### 공지사항 테이블
```sql
create table notice(
	id int primary key auto_increment,
    title varchar(100) not null,
    content longtext not null,
    createDate timestamp,
    importantNotice char(2)
)engine=InnoDB default charset=utf8;
```

### 음료 테이블
```sql
create table drinks (
	id int primary key auto_increment,
    name varchar(50) not null,
    subname varchar(100) not null,
    content varchar(200) not null,
    imageSrc longtext not null,
    kind varchar(20) not null,
    recommend char(1)
)engine=InnoDB default charset=utf8;
```

### 베이커리 테이블
```sql
create table bakery (
	id int primary key auto_increment,
    name varchar(50) not null,
    subname varchar(100) not null,
    content varchar(200) not null,
    imageSrc longtext not null,
    kind varchar(20) not null,
    recommend char(1)
)engine=InnoDB default charset=utf8;
```

### 스낵 테이블
```sql
create table snack (
	id int primary key auto_increment,
    name varchar(50) not null,
    subname varchar(100) not null,
    content varchar(200) not null,
    imageSrc longtext not null,
    kind varchar(20) not null,
    recommend char(1)
)engine=InnoDB default charset=utf8;
```

### MD 테이블
```sql
create table md (
	id int primary key auto_increment,
    name varchar(50) not null,
    content varchar(200) not null,
    imageSrc longtext not null,
    recommend char(1)
)engine=InnoDB default charset=utf8;
```
## DB 연결
- context.xml 설정

```xml
<Resource name="jdbc/TestDB" auth="Container" type="javax.sql.DataSource"
             maxTotal="100" maxIdle="30" maxWaitMillis="10000"
             username="ediyauser" password="bitc5600" driverClassName="com.mysql.cj.jdbc.Driver"
             url="jdbc:mysql://localhost:3306/ediyadb?serverTimezone=Asia/Seoul"/>
```

- web.xml 설정

```xml
<resource-ref>
	<description>DB Connection</description>
	<res-ref-name>jdbc/TestDB</res-ref-name>
	<res-type>javax.sql.DataSource</res-type>
	<res-auth>Container</res-auth>
</resource-ref>
```

- DB.java

```java
package com.cos.serverproject.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DB {
	public static Connection getConnection() {
		try {
			Context initContext = new InitialContext();
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource)envContext.lookup("jdbc/TestDB");
			Connection conn = ds.getConnection();
			return conn;
		} catch(Exception e) {
			System.out.println("DB 연결실패");
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			conn.close();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			conn.close();
			pstmt.close();
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
```

## 디자인
- Bootstrap 4를 이용하여 디자인
