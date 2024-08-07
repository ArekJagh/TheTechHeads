#ifndef PRODUCT_H
#define PRODUCT_H

#include <string>
#include <chrono>
#include "database.h"
#include "uuid_generator.h"

class Product {
    private:
        std::string productId;
        std::string name;
        std::string description;
        double price;
        int quantity;
        std::string category;
        std::chrono::system_clock::time_point created_at;
        std::chrono::system_clock::time_point updated_at;

        //helper function
        std::string formatTimestamp(const std::chrono::system_clock::time_point& timestamp) const;
    public:
        Product(std::string& name, std::string& description, double price, int quantity, std::string& category);
        bool saveToDatabase(Database& db);

        std::string getProductId() const;
        std::string getName() const;
        std::string getDescription() const;
        double getPrice() const;
        int getQuantity() const;
        std::string getCategory() const;
        std::string getCreatedAt() const;
        std::string getUpdatedAt() const;
};

#endif