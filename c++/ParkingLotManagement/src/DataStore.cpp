#include "DataStore.h"

std::vector<Vehicle> DataStore::vehicles;

void DataStore::addVehicle(const Vehicle& vehicle)
{
    vehicles.push_back(vehicle);
}

std::vector<Vehicle> DataStore::searchVehicles(const std::string& searchQuery)
{
    std::vector<Vehicle> result;
    for (const auto& vehicle : vehicles)
    {
        if (vehicle.getRegistrationNumber() == searchQuery || vehicle.getColor() == searchQuery)
        {
            result.push_back(vehicle);
        }
    }
    return result;
}
