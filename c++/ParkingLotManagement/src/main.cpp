#define CROW_MAIN
#include "crow_all.h"
#include "DataStore.h"
#include "Vehicle.h"
#include "Driver.h"

int main()
{
    crow::SimpleApp app;

    CROW_ROUTE(app, "/addVehicle").methods(crow::HTTPMethod::POST)([](const crow::request& req) {
        auto body = crow::json::load(req.body);
        if (!body)
            return crow::response(400);

        std::string regNumber = body["registrationNumber"].s();
        std::string color = body["color"].s();
        std::string model = body["model"].s();
        std::string driverName = body["driverName"].s();
        std::string licenseNumber = body["licenseNumber"].s();

        Driver driver(driverName, licenseNumber);
        Vehicle vehicle(regNumber, color, model, driver);

        DataStore::addVehicle(vehicle);

        return crow::response(200);
    });

    CROW_ROUTE(app, "/searchVehicle").methods(crow::HTTPMethod::GET)([](const crow::request& req) {
        auto params = req.url_params;
        std::string searchQuery = params.get("searchQuery");

        auto vehicles = DataStore::searchVehicles(searchQuery);

        crow::json::wvalue result;
        for (const auto& vehicle : vehicles)
        {
            crow::json::wvalue v;
            v["registrationNumber"] = vehicle.getRegistrationNumber();
            v["color"] = vehicle.getColor();
            v["model"] = vehicle.getModel();
            v["driverName"] = vehicle.getDriver().getName();
            v["licenseNumber"] = vehicle.getDriver().getLicenseNumber();
            result["vehicles"].push_back(v);
        }
        return crow::response(result);
    });

    app.port(8080).multithreaded().run();
}
