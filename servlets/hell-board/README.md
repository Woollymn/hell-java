# 헬보드
## 개발환경
* Java 8
* Tomcat 9.0.0.M9 (alpha)
	* Servlet 4.0
	* JSP 2.4

## 서블릿 컴파일
* intelliJ community는 J2EE를 지원하지 않는다.
	* gradle을 붙일수도 있으나 다른걸 공부하는게 귀찮아서 패스.. 다음에 도전해보자.
* $ javac -classpath /path/to/tomcat/lib servlet-api.jar:classes:. -d classes src/com/hellBoard/path/to/sourceCode.java
	* src와 같은 계층에 classes 디렉터리가 있어야 컴파일 가능
