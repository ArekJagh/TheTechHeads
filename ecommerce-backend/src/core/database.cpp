#include "database.h"
#include <cppconn/exception.h>
#include <iostream>

// Constructor
Database::Database(const std::string& host, const std::string& user, const std::string& password, const std::string& schema): schema(schema){
    try{
        driver = get_driver_instance();
        con = driver->connect(host, user, password);
        con->setSchema(schema);
    }catch(sql::SQLException &e){
        std::cerr << "Error: " << e.what() << std::endl;
    }
}

Database::~Database(){
    delete con;
}
// get connection
sql::Connection* Database::getConnection(){
    return con;
}

// execute a non-select query
void Database::executeQuery(const std::string& query){
    try {
        sql::Statement* stmt = con->createStatement();
        stmt->execute(query);
        delete stmt;
        catch (sql::SQLException &e) {
            std::cerr << "Error excuting query: " << e->what() << std::endl;
        }
    }
}

// execute a select query
sql::ResultSet* Database::executeSelect(const std::string& query){
    try {
        sql::Statement* stmt = con->createStatement();
        sql::ResultSet* res = stmt->executeQuery(query);
        delete stmt;
        return res;
    }
    catch (sql::SQLException &e) {
        std::cerr << "Error excuting query: " << e.what() << std::endl;
        return nullptr;
    }
}
