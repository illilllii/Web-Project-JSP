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
- userRole 종류 : USER, USERADMIN, MENUADMIN, BOARDADMIN

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
- importantNotice : 중요 공지사항(Y, N)

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
- kind : 음료 종류 (COFFEE, BEVERAGE, BLENDING TEA, FLATCCINO, ICE FLAKES, RTD)
- recommend : 추천 여부 (Y, N)

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
- kind : 베이커리 종류 (BREAD, DESSERT, COFFEE&ETC)
- recommend : 추천 여부 (Y, N)

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
- kind : 스낵 종류 (DESSERT, COOKIE&ETC)
- recommend : 추천 여부 (Y, N)

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

## 디자인 및 주요 기능
- Bootstrap 4를 이용하여 디자인

### 메인화면
<p align = "center">
	<img src="./mdImg/main.png" width="800" />
</p>

### 메뉴화면
<p align = "center">
	<img src="./mdImg/menuIntro.png" width="800" />
</p>

<p align = "center">
	<img src="./mdImg/menu.png" width="800" />
</p>

### 회원가입화면
<p align = "center">
	<img src="./mdImg/join.png" width="800" />
</p>

### 로그인화면
<p align = "center">
	<img src="./mdImg/login.png" width="800" />
</p>

## 필터
### 인코딩 필터

```java
package com.cos.serverproject.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharConfig implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		
		chain.doFilter(request, response);
		
	}

}
```
- web.xml 설정

```xml
	<filter>
		<filter-name>charConfig</filter-name>
		<filter-class>com.cos.serverproject.config.CharConfig</filter-class>
	</filter>
	
	<filter-mapping>
		<filter-name>charConfig</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
```

### XSS 방어 필터 : lucy-xss-servlet-filter 사용

<a>https://github.com/naver/lucy-xss-filter</a>

- lucy-xss-servlet-filter-rule.xml

```xml
	<?xml version="1.0" encoding="UTF-8"?>
<config xmlns="http://www.navercorp.com/lucy-xss-servlet">
	<defenders>
		<!-- XssPreventer 등록 -->
		<defender>
			<name>xssPreventerDefender</name>
			<class>com.navercorp.lucy.security.xss.servletfilter.defender.XssPreventerDefender
			</class>
		</defender>
	</defenders>

	<!-- XssSaxFilter 등록 -->
	<defender>
		<name>xssSaxFilterDefender</name>
		<class>com.navercorp.lucy.security.xss.servletfilter.defender.XssSaxFilterDefender
		</class>
		<init-param>
			<param-value>lucy-xss-sax.xml</param-value>   <!-- lucy-xss-filter의 sax용 설정파일 -->
			<param-value>false</param-value>        <!-- 필터링된 코멘트를 남길지 여부, 성능 효율상 false 추천 -->
		</init-param>
	</defender>

	<!-- default defender 선언, 필터링 시 지정한 defender가 없으면 여기 정의된 default defender를 
		사용해 필터링 한다. -->
	<default>
		<defender>xssPreventerDefender</defender>
	</default>

	<!-- global 필터링 룰 선언 -->
	<global>
		<params>
			<param name="content" useDefender="false" />
		</params>
	</global>

	<url-rule-set>
		<url-rule>
			<url>/*</url>
			<params>
				<param name="content">
					<defender>xssSaxFilterDefender</defender>
				</param>
			</params>
		</url-rule>
	</url-rule-set>
</config>
```
- lucy-xss-sax.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>

<config xmlns="http://www.nhncorp.com/lucy-xss"
	extends="lucy-xss-default-sax.xml">

	<elementRule>
        <element name="p"/>
        <element name="a" />
        <element name="abbr"/>
        <element name="acronym"/>
        <element name="adress"/>
        <element name="applet"/>
        <element name="area"/>
        <element name="b"/>
        <element name="base"/>
        <element name="basefont"/>
        <element name="bdo"/>
        <element name="big"/>
        <element name="blockquote"/>
        <element name="body"/>
        <element name="br"/>
        <element name="button"/>
        <element name="caption"/>
        <element name="center"/>
        <element name="cite"/>
        <element name="code"/>
        <element name="col"/>
        <element name="colgroup"/>
        <element name="dd"/>
        <element name="del"/>
        <element name="dfn"/>
        <element name="dir"/>
        <element name="div"/>
        <element name="dl"/>
        <element name="dt"/>
        <element name="em"/>
        <element name="embed"/>
        <element name="fieldset"/>
        <element name="font"/>
        <element name="form"/>
        <element name="frame"/>
        <element name="frameset"/>
        <element name="h1"/>
        <element name="h2"/>
        <element name="h3"/>
        <element name="h4"/>
        <element name="h5"/>
        <element name="h6"/>
        <element name="head"/>
        <element name="hr"/>
        <element name="html"/>
        <element name="i"/>
        <element name="iframe"/>
        <element name="img"/>
        <element name="input"/>
        <element name="ins"/>
        <element name="isindex"/>
        <element name="kbd"/>
        <element name="label"/>
        <element name="legend"/>
        <element name="li"/>
        <element name="link"/>
        <element name="map"/>
        <element name="marquee"/>
        <element name="menu"/>
        <element name="meta"/>
        <element name="nobr"/>
        <element name="noframes"/>
        <element name="noscript"/>
        <element name="object"/>
        <element name="ol"/>
        <element name="optgroup"/>
        <element name="option"/>
        <element name="p"/>
        <element name="param"/>
        <element name="pre"/>
        <element name="q"/>
        <element name="rt"/>
        <element name="ruby"/>
        <element name="s"/>
        <element name="samp"/>
        <!-- <element name="script"/> -->
        <element name="select"/>
        <element name="small"/>
        <element name="span"/>
        <element name="strike"/>
        <element name="strong"/>
        <element name="style"/>
        <element name="sub"/>
        <element name="sup"/>
        <element name="table"/>
        <element name="tbody"/>
        <element name="td"/>
        <element name="textarea"/>
        <element name="tfoot"/>
        <element name="th"/>
        <element name="thead"/>
        <element name="title"/>
        <element name="tr"/>
        <element name="tt"/>
        <element name="u"/>
        <element name="ul"/>
        <element name="var"/>
        <element name="wbr"/>
        <element name="xml"/>
        <element name="xmp"/>
        
        <!-- HTML5 added at 2012.04.10 Start-->
        <element name="article"/>
        <element name="aside"/>
        <element name="audio"/>
        <element name="bdi"/>
        <element name="canvas"/>
        <element name="command"/>
        <element name="datalist"/>
        <element name="details"/>
        <element name="figcaption"/>
        <element name="figure"/>
        <element name="footer"/>
        <element name="header"/>
        <element name="hgroup"/>
        <element name="keygen"/>
        <element name="mark"/>
        <element name="meter"/>
        <element name="nav"/>
        <element name="output"/>
        <element name="progress"/>
        <element name="rp"/>
        <element name="section"/>
        <element name="source"/>
        <element name="summary"/>
        <element name="time"/>
        <element name="track"/>
        <element name="video"/>
        <!-- HTML5 added at 2012.04.10 End-->
        
        <!-- IE핵 처리를 위해 추가-->
        <element name="IEHackExtension" disable="ture" >
        </element>
    </elementRule>
 
    <attributeRule>
        <attribute name="src">
            <allowedPattern><![CDATA[['"]?\s*http://.*]]></allowedPattern>
        </attribute>
        <attribute name="href">
            <notAllowedPattern><![CDATA[(?i:script)]]></notAllowedPattern>
            <notAllowedPattern><![CDATA[(?i:\.css)]]></notAllowedPattern>
        </attribute>
        <attribute name="style" disable="false" exceptionTagList="a"/>
    </attributeRule>


</config>
```

-web.xml 설정

``` xml
	<filter>
		<filter-name>xssEscapeServletFilter</filter-name>
		<filter-class>com.navercorp.lucy.security.xss.servletfilter.XssEscapeServletFilter</filter-class>
	</filter>
	
	<filter-mapping>
		<filter-name>xssEscapeServletFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>
```