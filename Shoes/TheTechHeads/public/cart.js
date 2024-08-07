function loadCart() {
    fetch('/api/cart')
        .then(response => response.json())
        .then(cartItems => {
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
        });
}

function addToCart(productName, price) {
    fetch('/api/cart/add', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name: productName, price })
    })
    .then(response => response.json())
    .then(data => {
        if (data.success) {
            updateCartDropdown(data.cartItems);
            alert(`${productName} has been added to your cart.`);
        } else {
            alert('Failed to add item to cart.');
        }
    });
}

function updateCartDropdown(cartItems) {
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

document.addEventListener('DOMContentLoaded', loadCart);
