#include "shipping.h"

Shipping::Shipping(const std::string& carrier, const std::string& trackingNumber, double cost, const Address& address)
    : carrier(carrier), trackingNumber(trackingNumber), cost(cost), address(address), status("In Transit") {}


std::string Shipping::getCarrier() const {
    return carrier;
}

std::string Shipping::getTrackingNumber() const {
    return trackingNumber;
}

double Shipping::getCost() const {
    return cost;
}

const Address Shipping::getAddress() const {
    return address;
}

void Shipping::setStatus(const std::string& status) {
    this->status = status;
};

