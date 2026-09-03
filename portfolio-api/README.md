# portfolio-api

Java 17 이상에서 실행되는 Spring Boot 문의 API입니다.

## 실행

```bash
cd /Users/imgwanghwan/portfolio-site/portfolio-api
gradle bootRun
```

Gradle이 설치되어 있지 않다면 IntelliJ에서 `build.gradle`을 열어 실행할 수 있습니다. 이 프로젝트는 Java 17 toolchain을 사용합니다.

## API

- `GET /api/health`: 서버 상태 확인
- `POST /api/contact`: 문의 저장
- `GET /api/admin/contacts`: 관리자 인증이 필요한 문의 목록

관리자 계정은 환경 변수로 설정합니다.

```bash
export PORTFOLIO_ADMIN_USERNAME=admin
export PORTFOLIO_ADMIN_PASSWORD='change-this-password'
```

프론트엔드의 `admin.html`을 열고 같은 계정으로 로그인하면 문의 내역을 볼 수 있습니다. 배포 환경에서는 반드시 기본 비밀번호를 변경하고 HTTPS를 사용합니다.

운영 환경에서는 H2 대신 PostgreSQL을 사용합니다. `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD` 환경 변수를 설정하면 됩니다.

요청 예시:

```json
{
  "name": "홍길동",
  "email": "hello@example.com",
  "message": "프로젝트에 대해 궁금합니다."
}
```
