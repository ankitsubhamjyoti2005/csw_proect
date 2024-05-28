#ifndef DRIVER_H
#define DRIVER_H

#include <string>

class Driver {
public:
    Driver(const std::string& name, const std::string& licenseNumber);

    std::string getName() const;
    std::string getLicenseNumber() const;

private:
    std::string name;
    std::string licenseNumber;
};

#endif // DRIVER_H
