#include "Vehicle.h"

Vehicle::Vehicle(const std::string& registrationNumber, const std::string& color, const std::string& model, const Driver& driver)
    : registrationNumber(registrationNumber), color(color), model(model), driver(driver) {}

std::string Vehicle::getRegistrationNumber() const
{
    return registrationNumber;
}

std::string Vehicle::getColor() const
{
    return color;
}

std::string Vehicle::getModel() const
{
    return model;
}

Driver Vehicle::getDriver() const
{
    return driver;
}
