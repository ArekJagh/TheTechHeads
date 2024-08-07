#ifndef ORDER_H
#define ORDER_H

#include "database.h"
#include "user.h"
#include "orderItem.h"
#include "uuid_generator.h"
#include <chrono>
#include <vector>

#include <string>



class Order {
    private:
    std::string orderId;
    std::string orderDate;
    std::chrono::system_clock::time_point orderTime;
    std::string orderStatus;
    std::string userId;
    std::vector<OrderItem> orderItems;

    public:
    Order(const std::string& userId, const std::vector<OrderItem>& orderItems, const std::string& orderDate, const std::string& orderTime, const std::string& orderStatus);
    bool saveToDatabase(Database& db);

    std::string getOrderId() const;
    std::strig getorderDate() const;
    std::string getorderTime() const;
    std::string getorderStatus() const;
    std::string getUserId() const;
    std::vector<OrderItem> getOrderItems() const;
    double getTotalPrice() const;

};
#endif