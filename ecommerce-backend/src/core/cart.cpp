#include "cart.h"

Cart::Cart(User* user) : user(user) {
    cartId = UUIDGenerator::generateUUID();
}

void Cart::addProduct(Product* product) {
    products.push_back(product);
}

void Cart::removeProduct(Product* product) {
    products.erase(std::remove(products.begin(), products.end(), product), products.end());
};