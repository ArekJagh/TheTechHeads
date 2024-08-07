#ifndef SHIPPING_H
#define SHIPPING_H

#include "order.h"
#include "uuid_generator.h"
#include "address.h"
#include <string>
#include <chrono>

class Shipping {
    public:
        Shipping(const std::string& carrier, const std::string& trackingNumber, double cost, const Address& adress);

        std::string getCarrier() const;
        std::string getTrackingNumber() const;
        double getCost() const;
        const Address& getAddress() const;

        void setCarrier(const std::string& carrier);

        void setStatus(const std::string& status);

    private:
        std::string carrier;
        std::string trackingNumber;
        double cost;
        Address address;
        std::string status;
};
#endif