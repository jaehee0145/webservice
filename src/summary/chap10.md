### chapter 10 24시간 365일 중단 없는 서비스를 만들자

### 무중단 배포 방식
  - AWS에서 Blue-Green
  - 도커
  - L4 스위치
  - Ngnix 등등
  
### Ngnix
  - 웹서버, 리버스 프록시, 캐싱, 로드 밸런싱, 미디어 스트리밍 등을 위한 오픈소스 소프트웨어
  - 가장 유명한 웹서버이자 오픈 소스
  - 리버스 프록시를 통해 무중단 배포 환경 구축
      - 리버스 프록시: 외부의 요청을 받아 백엔드 서버로 요청을 전달하는 행위
  - 무중단 배포 방식중 저렴하고 쉽다.
  - 구조: Ngnix 1대와 스프링 부터 Jar 2대 사용
      - Ngnix와 연결되지 않은 스프링에 배포하고 배포가 끝나면 연결

 TODO p.375 실습