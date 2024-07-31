#include <string>
#include <iostream>


#include <mysql_driver.h>
#include <mysql_connection.h>
#include <cppconn/statement.h>
#include <cppconn/resultset.h>
#include <cppconn/prepared_statement.h>

#include "IdGenerator.h"

class User {
    private:
        std::string name;
        std::string email;
        std::string password;
        std::string userID;
        std::string phoneNumber;

        static sql::mysql::MySQL_Driver *driver;
        static sql::Connection *con;
    public:
        User(const std::string &name): name(name), email(""), password(""), phoneNumber("") {
            userID = generateUniqueUserID();
            saveToDatabase();
        }

        static void initializeDatabase(const std::string &endpoint, const std::string &username, const std::string &password, const std::string &dbName){
            // initialize MySQL driver
            driver = sql::mysql::get_mysql_driver_instance();
        
            con->setSchema("database-1");

            // Create users table if it doesn't exist
            sql::Statement *stmt = con->createStatement();
            stmt->execute("CREATE TABLE IF NOT EXISTS Users (userID INT(0) PRIMARY KEY, Name VARCHAR(100), Email VARCHAR(100), Password VARCHAR(100), PhoneNumber VARCHAR(100)");
            delete stmt;

        }

        ~User(){
            //Clean up the database connection
            delete con;
        }

        void saveToDatabase(){
            sql::PreparedStatement *pstmt;
            pstmt = con->prepareStatement("INSERT INTO Users(userID, Name, Email, Password, Username, UserType, PhoneNumber) VALUES(?, ?, ?, ?, ?, ?, ?)");
            pstmt->setString(1, userID);
            pstmt->setString(2, name);
            pstmt->setString(3, email);
            pstmt->setString(4, password);
            pstmt->setString(5, phoneNumber);
            pstmt->execute();
            delete pstmt;
        }

        std::string getUserID() const {
            return userID;
        }
        std::string getName() const {
            return name;
        }
        std::string getEmail() const {
            return email;
        }
        std::string getPhoneNumber() const {
            return phoneNumber;
        }

        void setEmail(const std::string &email){
            this->email = email;
        }
        void setPassword(const std::string &password){
            this->password = password;
        }
        void setPhoneNumber(const std::string &phoneNumber){
            this->phoneNumber = phoneNumber;
        }

        // initialize static member variables
        sql::mysql::MySQL_Driver *User::driver = nullptr;
        sql::Connection *User::con = nullptr;

}
