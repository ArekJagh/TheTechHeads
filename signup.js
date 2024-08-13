document.getElementById('signup-form').addEventListener('submit', function(event) {
    event.preventDefault(); 

   
    const username = document.getElementById('signup-username').value;
    const password = document.getElementById('signup-password').value;
    const email = document.getElementById('signup-email').value;

    
    const newUser = new UserAccount(username, password, email);

   
    saveUserToLocalStorage(newUser);

    
    saveCurrentUserID(newUser.userID);

  
    window.location.href = 'confirmation.html';
});
