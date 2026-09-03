const loginForm = document.querySelector('#login-form');
const loginPanel = document.querySelector('#login-panel');
const contentPanel = document.querySelector('#content-panel');
const contactList = document.querySelector('#contact-list');
const loginStatus = document.querySelector('#login-status');
const logoutButton = document.querySelector('#logout-button');
const apiBaseUrl = window.PORTFOLIO_API_URL || 'http://localhost:8080';
let credentials = '';

loginForm.addEventListener('submit', async (event) => {
  event.preventDefault();
  const username = document.querySelector('#username').value;
  const password = document.querySelector('#password').value;
  credentials = `Basic ${btoa(`${username}:${password}`)}`;
  loginStatus.textContent = '확인 중입니다...';
  try {
    const response = await fetch(`${apiBaseUrl}/api/admin/contacts`, { headers: { Authorization: credentials } });
    if (!response.ok) throw new Error('아이디 또는 비밀번호를 확인해주세요.');
    renderContacts(await response.json());
    loginPanel.classList.add('is-hidden');
    contentPanel.classList.remove('is-hidden');
  } catch (error) {
    credentials = '';
    loginStatus.textContent = error.message;
  }
});

logoutButton.addEventListener('click', () => {
  credentials = '';
  contentPanel.classList.add('is-hidden');
  loginPanel.classList.remove('is-hidden');
  loginForm.reset();
});

function renderContacts(contacts) {
  if (contacts.length === 0) {
    contactList.innerHTML = '<div class="empty-state">아직 접수된 문의가 없습니다.</div>';
    return;
  }
  contactList.innerHTML = contacts.map((contact) => `<article class="contact-item"><div class="contact-item-meta"><span>${escapeHtml(contact.createdAt || '')}</span><a href="mailto:${escapeHtml(contact.email)}">답장 ↗</a></div><h2>${escapeHtml(contact.name)}</h2><p>${escapeHtml(contact.email)}</p><div class="contact-message">${escapeHtml(contact.message)}</div></article>`).join('');
}

function escapeHtml(value) {
  return String(value).replace(/[&<>'"]/g, (character) => ({ '&': '&amp;', '<': '&lt;', '>': '&gt;', "'": '&#39;', '"': '&quot;' }[character]));
}
