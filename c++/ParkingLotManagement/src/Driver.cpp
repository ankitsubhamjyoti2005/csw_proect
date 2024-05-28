#include "Driver.h"

Driver::Driver(const std::string& name, const std::string& licenseNumber)
    : name(name), licenseNumber(licenseNumber) {}

std::string Driver::getName() const
{
    return name;
}

std::string Driver::getLicenseNumber() const
{
    return licenseNumber;
}

