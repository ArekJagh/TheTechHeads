#include "orderItem.h"

OrderItem::OrderItem(const std::string orderItemId, const Product& product, int quantity)
 : product(product), quantity(quantity), unitPrice(product.getPrice){
    orderItemId = UUIDGenerator::generateUUID();
 }

 const Product& OrderItem::getProduct() const {
     return product;
 }

    int OrderItem::getQuantity() const {
        return quantity;
    }
    double OrderItem::getUnitPrice() const {
        return unitPrice;
    }
    
    double OrderItem::getTotalPrice() const {
        return product.getPrice() * quantity;
    }


