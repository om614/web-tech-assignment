const form = document.getElementById('contact-form');
const submitBtn = document.getElementById('submit-btn');
const clearBtn = document.getElementById('clear-btn');
const successEl = document.getElementById('success');

const nameInput = document.getElementById('name');
const emailInput = document.getElementById('email');
const messageInput = document.getElementById('message');

const nameErr = document.getElementById('name-error');
const emailErr = document.getElementById('email-error');
const messageErr = document.getElementById('message-error');

function isValidEmail(email) {
  // Simple and practical email check (not full RFC)
  return /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(email);
}

function setError(el, msg) {
  el.textContent = msg || '';
}

function clearErrors() {
  setError(nameErr, '');
  setError(emailErr, '');
  setError(messageErr, '');
  successEl.textContent = '';
}

function validate() {
  clearErrors();

  const name = nameInput.value.trim();
  const email = emailInput.value.trim();
  const message = messageInput.value.trim();

  let ok = true;

  if (name.length < 2) {
    setError(nameErr, 'Name must be at least 2 characters.');
    ok = false;
  }

  if (!isValidEmail(email)) {
    setError(emailErr, 'Enter a valid email address.');
    ok = false;
  }

  if (message.length < 5) {
    setError(messageErr, 'Message must be at least 5 characters.');
    ok = false;
  }

  return ok;
}

function setSubmitting(isSubmitting) {
  submitBtn.disabled = isSubmitting;
  clearBtn.disabled = isSubmitting;
}

form.addEventListener('input', () => {
  // Validate gently as user types (only when something is present)
  // This keeps UX responsive.
  if (!form.dataset.touched) return;
  validate();
});

form.addEventListener('submit', (e) => {
  e.preventDefault();
  form.dataset.touched = 'true';

  if (!validate()) return;

  setSubmitting(true);

  // Demo interactivity: simulate a request
  window.setTimeout(() => {
    setSubmitting(false);
    successEl.textContent = `Thanks, ${nameInput.value.trim()}! Your message has been queued.`;
  }, 350);
});

clearBtn.addEventListener('click', () => {
  form.reset();
  form.dataset.touched = '';
  clearErrors();
});

// Extra button-click demo (no-op if form IDs change)
submitBtn.addEventListener('click', () => {
  // Nothing required; submit handler does the work.
});


