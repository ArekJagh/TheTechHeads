#include "ShoppingCart.h"
#include <iostream>

// Item Class Implementation
Item::Item(std::string n, double p, int q) : name(n), price(p), quantity(q) {}

std::string Item::getName() const { return name; }
double Item::getPrice() const { return price; }
int Item::getQuantity() const { return quantity; }
void Item::setQuantity(int q) { quantity = q; }

// ShoppingCart Class Implementation
void ShoppingCart::addItem(const Item& item) {
    for (auto& existingItem : items) {
        if (existingItem.getName() == item.getName()) {
            existingItem.setQuantity(existingItem.getQuantity() + item.getQuantity());
            return;
        }
    }
    items.push_back(item);
}

void ShoppingCart::removeItem(const std::string& itemName) {
    for (auto it = items.begin(); it != items.end(); ++it) {
        if (it->getName() == itemName) {
            items.erase(it);
            return;
        }
    }
    std::cout << "Item not found in the cart.\n";
}

double ShoppingCart::getTotalCost() const {
    double total = 0.0;
    for (const auto& item : items) {
        total += item.getPrice() * item.getQuantity();
    }
    return total;
}

void ShoppingCart::displayCart() const {
    std::cout << "Shopping Cart:\n";
    for (const auto& item : items) {
        std::cout << "Item: " << item.getName() 
                  << ", Price: $" << item.getPrice() 
                  << ", Quantity: " << item.getQuantity() 
                  << "\n";
    }
    std::cout << "Total Cost: $" << getTotalCost() << "\n";
}
