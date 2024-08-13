document.addEventListener('DOMContentLoaded', function() {
    
    var cart = JSON.parse(localStorage.getItem('cart')) || [];
    var cartItemsDiv = document.getElementById('cart-items');
    var totalPriceDiv = document.getElementById('total-price');

    if (cart.length > 0) {
        let total = 0;
        let cartDetails = '<ul>';
        cart.forEach(item => {
            cartDetails += `<li>${item.name} - ${item.price}</li>`;
            total += parseFloat(item.price.replace('$', ''));
        });
        cartDetails += '</ul>';
        cartItemsDiv.innerHTML = cartDetails;
        totalPriceDiv.innerHTML = `Total Price: $${total.toFixed(2)}`;
    } else {
        cartItemsDiv.innerHTML = 'Your cart is empty.';
    }

   
    var paymentForm = document.getElementById('payment-form');
    paymentForm.addEventListener('submit', function(e) {
        e.preventDefault();
        alert('Payment successful! Thank you for your purchase.');
        
        localStorage.removeItem('cart');
        window.location.href = 'index.html'; 
    });
});
