#include "cartitem.h"


CartItem::CartItem(const std::string cartItemId, const Product& product, int quantity)
    : product(product), quantity(quantity) {
    cartItemId = UUIDGenerator::generateUUID();
    }
const Product& CartItem::getProduct() const {
    return product;
}

int CartItem::getQuantity() const {
    return quantity;
};