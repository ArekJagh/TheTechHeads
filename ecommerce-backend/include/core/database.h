#ifndef DATABASE_H // check if DATABASE_H is not defined
#define DATABASE_H // Define DATABASE_H


#include <mysql_driver.h>
#include <mysql_connection.h>
#include <cppconn/statement.h>
#include <cppconn/resultset.h>
#include <cppconn/prepared_statement.h>
#include <string>

class Database {
    public:
    // initial a Database object with connection details. (constructor)
    Database(const std::string& host, const std::string& user, const std::string& password, const std::string& schema);
    // destructor
    ~Database(); 
    // return the connection object
    sql::Connection* getConnection();
    // execute a non-select query (insert, update, delete)
    void executeQuery(const std::string& query);
    // execute a select query
    sql::ResultSet* executeSelect(const std::string& query);

    private:
    sql::mysql::MySQL_Driver* driver; // MySQL driver object
    sql::Connection* con; // MySQL connection object
    std::string schema; // database schema
};

#endif // End of the conditional, 'include guard'


