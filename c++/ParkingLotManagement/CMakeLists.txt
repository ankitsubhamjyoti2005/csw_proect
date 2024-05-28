cmake_minimum_required(VERSION 3.10)
project(ParkingLotManagement)

set(CMAKE_CXX_STANDARD 17)

# Add Boost
find_package(Boost REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

add_executable(ParkingLotManagement src/main.cpp src/DataStore.cpp src/Vehicle.cpp src/Driver.cpp)

target_include_directories(ParkingLotManagement PRIVATE src)
