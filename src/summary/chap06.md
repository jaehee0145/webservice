### chapter 06 AWS 서버 환경을 만들어보자 - AWS EC2  

### 클라우드 서비스
- 인터넷(클라우드)을 통해 서버, 스토리지(파일 저장소), 데이터베이스, 네트웤, 소프트웨어, 모니터링 등의 컴퓨팅 서비스를 제공  
- 예. AWS의 EC2는 서버 장비를 대여하는 것 + 로그 관리, 모니터링, 하드웨어 교체, 네트워크 관리 등을 지원

### 클라우드 형태
  1. Infrastructure as a Service(IaaS)
     - 기존 물리 장비를 미들웨어와 함께 묶어둔 추상화 서비스
     - 가상머신, 스토리지, 네트워크, 운영체제 등의 IT인프라를 대여해 주는 서비스
     - AWS의 EC2, S3 등
  2. Platform as a Service(PaaS)
     - IaaS에서 한번 더 추상화한 서비스
     - 추상화해서 많은 기능이 자동화 되어 있음
     - AWS의 Beanstalk, Heroku 등
  3. Software as a Service(Saas)
     - 스프트웨어 서비스
     - 구글 드라이브, 드랍박스, 와탭 등 
