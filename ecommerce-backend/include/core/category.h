#ifndef CATEGORY_H
#define CATEGORY_H

#include <string>
#include <vector>
#include "database.h"
#include "product.h"
#include "uuid_generator.h"
#include <chrono>

class Category {
    public:
        Category(std::string categoryId, std::string categoryName, std::string categoryDescription);

        std::string getCategoryId() const;
        std::string getCategoryName() const;
        std::string getCategoryDescription() const;
        std::vector<Product>& getProducts() const;

        void setCategoryName(const std::string& name);
        void setCategoryDescription(const std::string& description);

        void addProduct(const Product& product);
        void removeProduct(const std::string& productId);

    private:
        std::string categoryId;
        std::string categoryName;
        std::string categoryDescription;
        std::vector<Product> products;
};

#endif


