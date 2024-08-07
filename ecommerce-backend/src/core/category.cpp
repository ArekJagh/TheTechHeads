#include "category.h"

Category::Category(const std::string& categoryName, const string& categoryDescription)
    : categoryName(categoryName), categoryDescription(categoryDescription) {
        categoryId = UUID::generateUUID();
    }

std::string Category::getCategoryId() const {
    return categoryId;
}

std::string Category::getCategoryName() const {
    return categoryName;
}

std::string Category::getCategoryDescription() const {
    return categoryDescription;
}

const std::vector<Product>& Category::getProducts() const {
    return products;
}

void Category::setCategoryName(const std::string& categoryName) {
    this->categoryName = categoryName;
}

void Category::setCategoryDescription(const std::string& categoryDescription) {
    this->categoryDescription = categoryDescription;
}

void Category::addProduct(const Product& product) {
    products.push_back(product);
};

