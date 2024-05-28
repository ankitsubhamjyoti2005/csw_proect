#ifndef DATASTORE_H
#define DATASTORE_H

#include "Vehicle.h"
#include <vector>
#include <string>

class DataStore {
public:
    static void addVehicle(const Vehicle& vehicle);
    static std::vector<Vehicle> searchVehicles(const std::string& searchQuery);

private:
    static std::vector<Vehicle> vehicles;
};

#endif // DATASTORE_H
