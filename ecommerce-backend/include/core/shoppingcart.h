#ifndef SHOPPING_CART_H
#define SHOPPING_CART_H

#include "database.h"
#include <string>
#include <vector>

class Item {
private:
    std::string name;
    double price;
    int quantity;

public:
    Item(std::string n, double p, int q);

    std::string getName() const;
    double getPrice() const;
    int getQuantity() const;
    void setQuantity(int q);
};

class ShoppingCart {
private:
    std::vector<Item> items;

public:
    void addItem(const Item& item);
    void removeItem(const std::string& itemName);
    double getTotalCost() const;
    void displayCart() const;
};

#endif // SHOPPING_CART_H
