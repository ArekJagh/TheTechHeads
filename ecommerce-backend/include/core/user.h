#ifndef USER_H
#define USER_H

#include "uuid_generator.h"
#include "database.h"
#include <string>

class User {
public:
    User(const std::string& userId, const std::string& username, const std::string& password, const std::string& email);
    bool saveToDatabase(Database& db);
    bool authenticate(const std::string& username, const std::string& password);

    std::string getUserId() const;
    std::string getUsername() const;
    std::string getEmail() const;

private:
    std::string userId;
    std::string username;
    std::string password;
    std::string email;

    std::string hashPassword(const std::string& password);
    std::string generateUUID();
};

#endif
