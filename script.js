const revealItems = document.querySelectorAll('.reveal');
const revealObserver = new IntersectionObserver((entries) => {
  entries.forEach((entry) => {
    if (entry.isIntersecting) {
      entry.target.classList.add('is-visible');
      revealObserver.unobserve(entry.target);
    }
  });
}, { threshold: 0.12 });

revealItems.forEach((item) => revealObserver.observe(item));

const sections = document.querySelectorAll('main section[id]');
const navLinks = document.querySelectorAll('.nav-link');
const sectionObserver = new IntersectionObserver((entries) => {
  entries.forEach((entry) => {
    if (!entry.isIntersecting) return;
    navLinks.forEach((link) => link.classList.toggle('is-active', link.getAttribute('href') === `#${entry.target.id}`));
  });
}, { rootMargin: '-35% 0px -55% 0px' });

sections.forEach((section) => sectionObserver.observe(section));

const contactForm = document.querySelector('#contact-form');
const formStatus = document.querySelector('#form-status');
const apiBaseUrl = window.PORTFOLIO_API_URL || 'http://localhost:8080';

contactForm?.addEventListener('submit', async (event) => {
  event.preventDefault();
  const submitButton = contactForm.querySelector('button[type="submit"]');
  const formData = new FormData(contactForm);
  const payload = Object.fromEntries(formData.entries());
  submitButton.disabled = true;
  formStatus.textContent = '전송 중입니다...';
  formStatus.className = 'form-status';

  try {
    const response = await fetch(`${apiBaseUrl}/api/contact`, {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(payload),
    });
    const result = await response.json();
    if (!response.ok) throw new Error(result.message || '전송에 실패했습니다.');
    formStatus.textContent = result.message;
    formStatus.classList.add('is-success');
    contactForm.reset();
  } catch (error) {
    formStatus.textContent = error.message || '잠시 후 다시 시도해주세요.';
    formStatus.classList.add('is-error');
  } finally {
    submitButton.disabled = false;
  }
});
