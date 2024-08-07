document.getElementById('burger-menu').addEventListener('click', function() {
    const navLinks = document.getElementById('nav-links');
    navLinks.classList.toggle('show');
});

function addToCart(productName, price) {
    const cartItems = JSON.parse(localStorage.getItem('cart')) || [];
    cartItems.push({ name: productName, price: price });
    localStorage.setItem('cart', JSON.stringify(cartItems));
    updateCartDropdown();
    alert(`${productName} has been added to your cart.`);
}

function updateCartDropdown() {
    const cartItems = JSON.parse(localStorage.getItem('cart')) || [];
    const cartItemsContainer = document.getElementById('cart-items');
    
    if (cartItems.length === 0) {
        cartItemsContainer.innerHTML = '<p class="text-center">Your cart is empty.</p>';
        return;
    }

    cartItemsContainer.innerHTML = '';
    cartItems.forEach(item => {
        const itemElement = document.createElement('div');
        itemElement.className = 'cart-item';
        itemElement.innerHTML = `
            <span>${item.name}</span>
            <span>$${item.price.toFixed(2)}</span>
        `;
        cartItemsContainer.appendChild(itemElement);
    });
}

document.addEventListener('DOMContentLoaded', updateCartDropdown);
