### chapter 04 머스테치로 화면 구성하기  

#### 템플릿 엔진 
- 지정된 템플릿 양식과 데이터가 합쳐져 HTML문서를 출력하는 소프트웨어  

#### 서버 템플릿 엔진
- JSP, Freemaker
- 서버에서 자바 코드로 문자열을 만든 뒤 이 문자열을 HTML로 변환하여 브라우저로 전달  
<img width="350" alt="스크린샷 2021-09-12 오전 10 08 26" src="https://user-images.githubusercontent.com/45681372/132967412-add120e3-3d4f-401f-910d-fdf8990293e0.png">

#### 클라이언트 템플릿 엔진 
- React, Vue  
- 서버에서 Json 혹은 Xml 형식의 데이터만 전달하고 브라우저에서 화면을 생성  
- 최근에는 서버사이드 렌더링을 지원
<img width="350" alt="스크린샷 2021-09-12 오전 10 08 45" src="https://user-images.githubusercontent.com/45681372/132967421-a4367fda-b901-4d73-8954-69f87b581226.png">

---
### 페이지 로딩
- HTML은 위에서부터 코드가 실행된다.
- css는 header에, js는 footer 가 좋다.
  - js 용량이 클수록 body부분 실행이 늦어지기 때문에 body 하단에 두는 것이 좋고 css를 먼저 불러야 사용자가 깨진 화면을 안보게 된다. 
- bootstrap.js가 제이쿼리에 **의존**하기 때문에 제이쿼리를 먼저 호출 