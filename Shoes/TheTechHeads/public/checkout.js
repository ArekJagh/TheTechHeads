document.getElementById('payment-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const cardName = document.getElementById('card-name').value;
    const cardNumber = document.getElementById('card-number').value;
    const expiryDate = document.getElementById('expiry-date').value;
    const cvv = document.getElementById('cvv').value;

    fetch('/api/checkout', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ cardName, cardNumber, expiryDate, cvv })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            alert('Payment successful!');
        } else {
            alert('Payment failed.');
        }
    });
});
