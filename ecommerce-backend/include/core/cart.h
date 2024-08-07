#ifndef CART_H
#define CART_H

#include "user.h"

class Cart {
    public:
    Cart::Cart(User* user);
    void addProduct(Product* product);
    void removeProduct(Product* product);
    void checkout();

    const void getCartId();

    private:
    User* user;
    std::vector<Product*> products;
    std::string cartId;
};
#endif
