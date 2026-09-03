const isLocalhost = ['localhost', '127.0.0.1'].includes(window.location.hostname);
window.PORTFOLIO_API_URL = isLocalhost
    ? 'http://localhost:8080'
    : 'https://portfolio-api-jzee.onrender.com';
