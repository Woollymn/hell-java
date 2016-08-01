# 헬보드
## 개발환경
* Java 8
* Tomcat 9.0.0.M9 (alpha)
	* Servlet 4.0
	* JSP 2.4

## 서블릿 컴파일
* intelliJ community는 J2EE를 지원하지 않는다.
	* gradle을 붙일수도 있으나 다른걸 공부하는게 귀찮아서 패스.. 다음에 도전해보자.
* $ javac -classpath /path/to/tomcat/lib/servlet-api.jar:classes:. -d classes src/com/hellBoard/path/to/sourceCode.java
	* src와 같은 계층에 classes 디렉터리가 있어야 컴파일 가능
## Action
* 컨트롤러 역할
	* 만들다보니 action으로 굳어짐...
* web.xml에서 HellBoardServlet의 servlet-mapping에 url-pattern을 추가한다.
	* 접근 가능한 경로 제한
	* uri를 파싱해서 자동으로 action 클래스와 메소드를 호출한다.
		* 첫 번째 세그먼트는 클래스명
		* 두 번째 세그먼트는 첫 번째 클래스 내의 메소드명
			* uri depth를 더 깊게 파고 싶으나 시간 관계상 패스
* 메소드 index(Get get)은 필수
	* 메소드명 제한은 없으나 CRUD를 기본 메소드로 제시
* Action 클래스의 메소드 인자로 HTTP Method를 전달해야 한다.
	* Restful 흉내
	* GET/POST 둘중 하나를 고를 수 있고 추후에 다른 HTTP Method 추가 가능
