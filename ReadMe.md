### chapter 02 스프링 부트에서 테스트 코드를 작성하자

### 2.1 테스트 코드 소개
- 단위 테스트 코드 작성 이점 (위키피디아)
  - 개발단계 초기에 문제를 발견하는데 도움
  - 코드를 리팩토링하거나 라이브러리 업그레이드 등에서 기존 기능이 올바르게 작동하는지 확인
  - 기능에 대한 불확실성 감소
  - 시스템에 대한 실제 문서를 제공. 단위 테스트 자체를 문서로 사용 가능  
- 서비스 기업에서는 특히나 강조되고 있어 필자의 생각으로는 100% 익혀야할 **기술이자 습관**

[실습]
- 메인 클래스 생성 Application.java
  - @SpringBootApplication 
    - 스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정 
    - 어노테이션이 있는 위치부터 설정을 읽기 때문에 프로젝트 최상단에 위치해야 함 
  - SpringApplication.run
    - 내장 WAS를 실행 
    - 내장 WAS
      - 애플리케이션 실행할 때 내부에서 WAS를 실행 
      - 서버에 톰캣을 설치할 필요가 없고 스프링 부트로 만들어진 Jar 파일 (실행 가능한 Java 패키징 파일)로 실행하면 됨
      - 스프링 부트에서는 내장 WAS 권장 : 같은 환경에서 스프링 부트를 배포할 수 있기 때문  

- 컨트롤러 생성 HelloController.java
  - @RestController
    - 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줌

- 테스트 클래스 생성 HelloControllerTest.java
  * ISSUE 1. 기본적인 실수
    * 패키지 이름 오타(노트북이 고장난 탓이다..ㅠㅠ)
    * 테스트 코드 url 오타 (어떻게 / 없이 요청을 보내려고..)
  * ISSUE 2. [gradle version](https://github.com/jojoldu/freelec-springboot2-webservice/issues/2)
  
- 테스트 코드
  * @RunWith(SpringRunner.class)
    * 테스트를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴
    * 여기서는 SprigRunner라는 스프링 실행자를 사용
    * 즉, 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함
  * @WebMvcTest
    * 여러 스프링 테스트 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션
    * 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있음
    * @Service, @Component, @Repository 등은 사용할 수 없음
  