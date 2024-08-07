#include "user.h"
#include <openssl/sha.h>
#include <iostream>
#include <sstream>
#include <iomanip>

// constructor to initialize a user object with username, password, and email
User::User(const std::string& username, const std::string& password, const std::string& email)
    : userId(UUIDGenerator.generate()), username(username), password(hashPassword(password)), email(email) {}

// save user to database
bool User::saveToDatabase(Database& db) {
    try {
        sql::PreparedStatement* pstmt = db.getConnection() -> prepareStatement("INSERT INTO users (user_id, username, password, email) VALUES (?, ?, ?, ?)");
        pstmt -> setString(1, userId);
        pstmt -> setString(2, username);
        pstmt -> setString(3, password);
        pstmt -> setString(4, email);
        pstmt -> execute();
        delete pstmt;
        return true;
    } catch (sql::SQLException& e) {
        std::cerr << "Error saving user to database: " << e.what() << std::endl;
        return false;
    }
}

// authenticate user with given password
bool User::authenticate(const std::string& password) {
    unsigned char hash[SHA256_DIGEST_LENGTH];
    SHA256(reinterpret_cast<const unsigned char*>(password.c_str()), password.size(), hash);
    std::stringstream ss;
    for (int i = 0; i < SHA256_DIGEST_LENGTH; ++i) {
        ss << std::hex << std::setw(2) << std::setfill('0') << static_cast<int>(hash[i]);
    }
    return ss.str() == this -> password; // compare the hashed password with the stored password
}

std::string User::hashPassword(const std::string& password){
    unsigned char has[SHA256_DIGEST_LENGTH];
    SHA256(reinterpret_cast<const unsigned char*>(password.c_str()), password.size(), hash);
    std::stringstream ss;
    for (int i = 0; i < SHA256_DIGEST_LENGTH; ++i) {
        ss << std::hex << std::setw(2) << std::setfill('0') << static_cast<int>(hash[i]);
    }
    return ss.str();
}