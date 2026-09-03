# Lim Gwanghwan Portfolio

채용 담당자가 첫 화면에서 개발자의 방향성과 프로젝트 경험을 빠르게 파악할 수 있도록 만든 정적 포트폴리오 사이트입니다.

## 로컬 확인

파일 탐색기에서 `index.html`을 열거나, 터미널에서 다음 명령을 실행합니다.

```bash
cd /Users/imgwanghwan/portfolio-site
python3 -m http.server 8000
```

브라우저에서 `http://localhost:8000`을 엽니다.

## 배포

GitHub 저장소에 이 폴더를 올린 뒤 `Settings > Pages`에서 배포할 브랜치와 `/ (root)`를 선택하면 됩니다.

운영 배포 전 `api-config.js`의 API 주소를 Render에 배포한 Spring Boot 주소로 변경합니다.

```javascript
window.PORTFOLIO_API_URL = 'https://your-api.onrender.com';
```

Spring Boot API는 루트의 `Dockerfile`로 배포할 수 있습니다. Render PostgreSQL의 연결 정보로 `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, `SPRING_DATASOURCE_PASSWORD`를 설정하고, `APP_CORS_ALLOWED_ORIGINS`에는 GitHub Pages 주소를 입력합니다.
