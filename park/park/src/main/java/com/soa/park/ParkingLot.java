package com.soa.park;
//
//import java.util.*;
//
//public class ParkingLot {
//	public static void main(String[] args) {
//		ParkingLotManager parkingLotManager = new ParkingLotManager();
//
//		// Add vehicles dynamically based on user input
//		Scanner scanner = new Scanner(System.in);
//		String input;
//		do {
//			System.out.println("Add a new vehicle (Enter 'done' to finish):");
//			System.out.print("Registration Number: ");
//			String regNumber = scanner.nextLine();
//			if (regNumber.equals("done")) {
//				break;
//			}
//			System.out.print("Make: ");
//			String make = scanner.nextLine();
//			System.out.print("Model: ");
//			String model = scanner.nextLine();
//			System.out.print("Color: ");
//			String color = scanner.nextLine();
//			System.out.print("Driver's First Name: ");
//			String firstName = scanner.nextLine();
//			System.out.print("Driver's Last Name: ");
//			String lastName = scanner.nextLine();
//			parkingLotManager.addVehicle(new Vehicle(regNumber, make, model, color, new Driver(firstName, lastName)));
//
//			System.out.print("Do you want to add another vehicle? (yes/no): ");
//			input = scanner.nextLine();
//		} while (!input.equalsIgnoreCase("no"));
//
//		// Display all vehicles
//		System.out.println("\nAll Vehicles:");
//		parkingLotManager.displayAllVehicles();
//
//		scanner.close();
//	}
//}
//
//class Vehicle {
//	private String registrationNumber;
//	private String make;
//	private String model;
//	private String color;
//	private Driver driver;
//
//	public Vehicle(String registrationNumber, String make, String model, String color, Driver driver) {
//		this.registrationNumber = registrationNumber;
//		this.make = make;
//		this.model = model;
//		this.color = color;
//		this.driver = driver;
//	}
//
//	// Getters
//	public String getRegistrationNumber() {
//		return registrationNumber;
//	}
//
//	public String getMake() {
//		return make;
//	}
//
//	public String getModel() {
//		return model;
//	}
//
//	public String getColor() {
//		return color;
//	}
//
//	public Driver getDriver() {
//		return driver;
//	}
//}
//
//class Driver {
//	private String firstName;
//	private String lastName;
//
//	public Driver(String firstName, String lastName) {
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
//
//	// Getters
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//}
//
//class ParkingLotManager {
//	private List<Vehicle> vehicles;
//
//	public ParkingLotManager() {
//		vehicles = new ArrayList<>();
//	}
//
//	public void addVehicle(Vehicle vehicle) {
//		vehicles.add(vehicle);
//	}
//
//	public void displayAllVehicles() {
//		for (Vehicle vehicle : vehicles) {
//			System.out.println("Registration Number: " + vehicle.getRegistrationNumber() +
//					", Make: " + vehicle.getMake() +
//					", Model: " + vehicle.getModel() +
//					", Color: " + vehicle.getColor() +
//					", Driver: " + vehicle.getDriver().getFirstName() + " " + vehicle.getDriver().getLastName());
//		}
//	}
//}


import spark.*;

import java.util.*;

public class ParkingLot {
	public static void main(String[] args) {
		ParkingLotManager parkingLotManager = new ParkingLotManager();

		// Spark setup
		Spark.port(8080);

		// Serve index.html
		Spark.get("/", (req, res) -> {
			res.type("text/html");
			return new Scanner(ParkingLot.class.getResourceAsStream("/index.html")).useDelimiter("\\A").next();
		});

		// Handle form submission
		Spark.post("/addVehicle", (req, res) -> {
			String regNumber = req.queryParams("regNumber");
			String make = req.queryParams("make");
			String model = req.queryParams("model");
			String color = req.queryParams("color");
			String firstName = req.queryParams("firstName");
			String lastName = req.queryParams("lastName");
			parkingLotManager.addVehicle(new Vehicle(regNumber, make, model, color, new Driver(firstName, lastName)));
			return "Vehicle added successfully!";
		});
	}
}

class Vehicle {
	private String registrationNumber;
	private String make;
	private String model;
	private String color;
	private Driver driver;

	public Vehicle(String registrationNumber, String make, String model, String color, Driver driver) {
		this.registrationNumber = registrationNumber;
		this.make = make;
		this.model = model;
		this.color = color;
		this.driver = driver;
	}

	// Getters
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public Driver getDriver() {
		return driver;
	}
}

class Driver {
	private String firstName;
	private String lastName;

	public Driver(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Getters
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}

class ParkingLotManager {
	private List<Vehicle> vehicles;

	public ParkingLotManager() {
		vehicles = new ArrayList<>();
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
}
