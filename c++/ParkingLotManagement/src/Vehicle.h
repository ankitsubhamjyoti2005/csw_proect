#ifndef VEHICLE_H
#define VEHICLE_H

#include "Driver.h"
#include <string>

class Vehicle {
public:
    Vehicle(const std::string& registrationNumber, const std::string& color, const std::string& model, const Driver& driver);

    std::string getRegistrationNumber() const;
    std::string getColor() const;
    std::string getModel() const;
    Driver getDriver() const;

private:
    std::string registrationNumber;
    std::string color;
    std::string model;
    Driver driver;
};

#endif // VEHICLE_H
