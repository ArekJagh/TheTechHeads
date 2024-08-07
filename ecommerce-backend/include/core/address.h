#ifndef ADDRESS_H
#define ADDRESS_H

#include <string>
#include <database.h>

class Address
{
    public:
        Address(const std::addressId& addressId, const std::string& street, const std::string& city, const std::string& state, const std::string& zip);

        std::addressId getAddressId() const;
        std::string getStreet() const;
        std::string getCity() const;
        std::string getState() const;
        std::string getZip() const;

    private:
        std::addressId addressId;
        std::string street;
        std::string city;
        std::string state;
        std::string zip;

};
#endif // ADDRESS_H
