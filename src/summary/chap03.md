### chapter 03 스프링 부트에서 JPA로 데이터베이스 다뤄보자
### 3.4 등록/수정/조회 API 만들기 
JPA와 H2에 대한 기본적인 기능과 설정을 진행했으니, 본격적으로 API를 만들어보겠습니다.
API를 만들기 위해 총 3개의 클래스가 필요합니다.
- Request 데이터를 받을 DTO
- API 요청을 받을 Controller
- 트랜잭션, 도메인 기능 간의 순서를 보장하는 Service

---
여기서 많은 분들이 오해하고 계신 것이, Service에서 비지니스 로직을 처리해야 한다는 것입니다.
Service는 **트랜잭션, 도메인 간 순서 보장**의 역할만 합니다.

<img width="300" alt="스크린샷 2021-09-12 오전 12 53 40" src="https://user-images.githubusercontent.com/45681372/132953710-ffe44896-bde6-469a-9cac-6155d2818904.png">

[Spring 웹 계층]
- Web Layer
  - @Controller, JSP 등 뷰 템플릿 영역
  - 이외에도 @Filter, 인터셉터, 컨트롤러 어드바이스 등 **외부 요청과 응답**에 대한 전반적인 영역
- Service Layer
  - @Service에 사용되는 서비스 영역
  - 일반적으로 Controller와 Dao의 중간 영역
  - @Transactional이 사용되어야 하는 영역 
- Repository Layer
  - Database와 같이 데이터 저장소에 접근하는 영역
  - DAO(Data Access Object) 영역
- DTOs
  - DTO(Data Transfer Object)는 **계층 간에 데이터 교환을 위한 객체**를 이야기하며 DTOs는 이들의 영역을 의미
  - 예를 들어 뷰 템플릿 엔진에서 사용될 객체나 Repository Layer에서 결과로 넘겨준 객체 등
- Domain Model
  - @Entity가 사용된 영역 역시 도메인 모델이라고 이해하면 된다.
  - 다만, 무조건 DB의 테이블과 관계가 있어야만 하는 것은 아닙니다.
  - VO처럼 값 객체들도 이 영역에 해당하기 때문
  - 비즈니스 처리를 담당해야 할 곳
---

- @RequiredArgsConstructor : final이 선언된 모든 필드를 인자값으로 하는 생성자를 생성

- 생성자를 직접 안 쓰고 롬복 어노테이션을 사용하는 이유 : 
해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속 수정하는 번거로움을 해결

---
- Entity 클래스를 Request / Response 클래스로 사용해서는 안됩니다.
  - DTO는 view를 위한 클래스라 자주 변경됨 -> 테이블과 연결된 Entity를 변경하는 것은 위험
---
- @WebMvcTest : JPA 기능이 작동하지 않아 Controller, ControllerAdvice 등 외부 연동과 관려된 부분만 활성화
- @SpringBootTest, TestRestTemplate : JPA 기능까지 한번에 테스트 할 때 