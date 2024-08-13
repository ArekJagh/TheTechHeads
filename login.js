document.getElementById('login-form').addEventListener('submit', function(event) {
    event.preventDefault(); 

    const username = document.getElementById('login-username').value;
    const password = document.getElementById('login-password').value;
    const resultElement = document.getElementById('result');

    
    resultElement.textContent = '';

    
    if (!username || !password) {
        resultElement.textContent = 'Please fill in both username and password.';
        resultElement.classList.add('error');
        return;
    }

    
    for (let i = 0; i < localStorage.length; i++) {
        const key = localStorage.key(i);
        if (key.startsWith('user_')) {
            const user = getUserFromLocalStorage(key);
            if (user.username === username && user.password === password) {
                resultElement.textContent = 'Login successful!';
                resultElement.classList.remove('error');
                resultElement.classList.add('success');
                saveCurrentUserID(user.userID);
                window.location.href = 'product.html'; 
                return;
            }
        }
    }

    resultElement.textContent = 'Invalid username or password.';
    resultElement.classList.add('error');
});

function getUserFromLocalStorage(userID) {
    return JSON.parse(localStorage.getItem(userID));
}

function saveCurrentUserID(userID) {
    localStorage.setItem('currentUserID', userID);
}
