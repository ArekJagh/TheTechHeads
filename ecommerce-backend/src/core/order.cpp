#include "order.h"


Order::Order(const std::string& userId, const std::vector<orderItem>& items)
    : id(UUIDGenerator::generateUUID()), userId(userId), items(items) {}

bool Order::saveToDatabase(Database& db) {
    return db.saveOrder(*this);
}

std::string Order::getId() const {
    return id;
}

std::string Order::getUserId() const {
    return userId;
}

std::vector<OrderItem> Order::getItems() const {
    return iteams;
}

double Order::getTotalPrice() const {
    double total = 0;
    for (const auto& item : items) {
        total += product.getPrice();
    }
    return total;
}