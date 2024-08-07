#include <iostream>
#include "core/user.h"
#include "core/database.h"

int main() {
    Database db("tcp://database-1.cvkssckyc4iw.us-east-2.rds.amazonaws.com", "admin", "3vpRm!I}p-a~![uRa<SNr(~PXoCI")

    User user(1, "testuser", "testpassword", "testemail.com");
    if (user.saveToDatabase(db)) {
        std::cout << "User saved to database" << std::endl;
    } else {
        std::cout << "Failed to save user to database" << std::endl;
    }

    if (user.authenticate("password123")) {
        std::cout << "User authenticated" << std::endl;
    } else {
        std::cout << "Failed to authenticate user" << std::endl;
    }
    return 0;
}