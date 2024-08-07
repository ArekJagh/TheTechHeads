#ifndef CARTITEM_H
#define CARTITEM_H

#include "product.h"
#include <string>

class CartItem {
    private:
    Product product;
    int quantity;
    std::string cartItemId;

    public:
    CartItem(Product& product, int quantity) : product(product), quantity(quantity) {}
    const Product& getProduct() const;
    int getQuantity() const;
    double getTotalPrice() const;
    void getCartItemId() const;
};

#endif 