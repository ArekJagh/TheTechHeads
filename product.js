document.addEventListener('DOMContentLoaded', function() {

    document.getElementById('burger-menu').addEventListener('click', function() {
        const navLinks = document.getElementById('nav-links');
        navLinks.classList.toggle('show');
    });

    
    const products = document.querySelectorAll('.product');
    const navLinks = document.querySelectorAll('.nav-links a');

    navLinks.forEach(link => {
        link.addEventListener('click', function(e) {
            e.preventDefault();
            const category = link.textContent.toLowerCase();

            products.forEach(product => {
                if (category === 'home' || category === 'shop' || category === 'sale' || product.dataset.category === category) {
                    product.style.display = 'block';
                } else {
                    product.style.display = 'none';
                }
            });
        });
    });

    
    var buttons = document.querySelectorAll('.product .btn');
    var cartCount = document.getElementById('cart-count');
    var count = 0;
    var cart = [];  

   
    buttons.forEach(function(button) {
        button.addEventListener('click', function() {
            
            count++;
            if (cartCount) {
                cartCount.textContent = count;
            }

            
            var product = this.parentElement;
            var name = product.querySelector('h2').textContent;
            var price = product.querySelector('.price').textContent;

            
            cart.push({ name: name, price: price });

            
            console.log('Added to cart:', name, price);
        });
    });

    
    var checkoutBtn = document.getElementById('checkout-btn');
    if (checkoutBtn) {
        checkoutBtn.addEventListener('click', function(e) {
            e.preventDefault();
            if (cart.length > 0) {
                let cartDetails = 'Items in your cart:\n\n';
                cart.forEach(item => {
                    cartDetails += `${item.name} - ${item.price}\n`;
                });
                cartDetails += '\nProceed to checkout.';
                alert(cartDetails);
            } else {
                alert('Your cart is empty.');
            }
        });
    }
});


buttons.forEach(function(button) {
    button.addEventListener('click', function() {
        
        count++;
        if (cartCount) {
            cartCount.textContent = count;
        }

    
        var product = this.parentElement;
        var name = product.querySelector('h2').textContent;
        var price = product.querySelector('.price').textContent;

       
        cart.push({ name: name, price: price });

      
        localStorage.setItem('cart', JSON.stringify(cart));

        
        console.log('Added to cart:', name, price);
    });
});

