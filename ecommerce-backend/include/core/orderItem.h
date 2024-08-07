#ifndef ORDERITEM_H
#define ORDERITEM_H

#include "database.h"
#include "product.h"
#include "database.h"
#include "uuid_generator.h"
#include <string>



class OrderItem {
    private:
    std::string orderItemId;
    Product product;
    int quantity;
    double unitPrice;


    public:
    OrderItem(const std::string orderItemId, Product& product, int quantity, double unitPrice) : product(product), quantity(quantity), unitPrice(unitPrice) {}
    const Product& getProduct() const;
    int getQuantity() const;
    double getUnitPrice() const;
    void getOrderIteamId() const;
    double getTotalPrice() const;
    
};
#endif