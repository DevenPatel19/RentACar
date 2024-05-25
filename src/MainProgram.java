import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


//Define the Vehicle interface
interface Vehicle {
    String getMake();
    String getModel();
    int getYearOfManufacture();
    void setYearOfManufacture(int yearOfManufacture);
}

//Define the CarVehicle interface, extending the Vehicle interface
interface CarVehicle extends Vehicle {
    void setNumberOfDoors(int numberOfDoors);
    int getNumberOfDoors();
    void setFuelType(String fuelType);
    String getFuelType();
}

//Define the MotorVehicle interface, extending the Vehicle interface
interface MotorVehicle extends Vehicle {
    void setNumberOfWheels(int numberOfWheels);
    int getNumberOfWheels();
    void setMotorcycleType(String type);
    String getMotorcycleType();
}


//Define the TruckVehicle interface, extending the Vehicle interface
interface TruckVehicle extends Vehicle {
    void setCargoCapacity(double capacity);
    double getCargoCapacity();
    void setTransmissionType(String type);
    String getTransmissionType();
}

//Define the Car class implementing the CarVehicle interface
class Car implements CarVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfDoors;
    private String fuelType;
    
    // Constructor for Car class
    public Car(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        setYearOfManufacture(yearOfManufacture);
    }
    
    // Implementing methods from the CarVehicle interface
    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    @Override
    public void setYearOfManufacture(int yearOfManufacture) {
        if (yearOfManufacture >= 1001 && yearOfManufacture <= 2024) {
            this.yearOfManufacture = yearOfManufacture;
        } else {
            throw new IllegalArgumentException("Year of manufacture must be between 1001 and 2024.");
        }
    }

    @Override
    public void setNumberOfDoors(int numberOfDoors) {
        if (numberOfDoors > 0) {
            this.numberOfDoors = numberOfDoors;
        } else {
            throw new IllegalArgumentException("Number of doors must be greater than zero.");
        }
    }

    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    @Override
    public void setFuelType(String fuelType) {
        if (isValidFuelType(fuelType)) {
            this.fuelType = fuelType;
        } else {
            throw new IllegalArgumentException("Invalid fuel type. Must be Petrol, Diesel, or Electric.");
        }
    }

    @Override
    public String getFuelType() {
        return fuelType;
    }

    private boolean isValidFuelType(String fuelType) {
        return fuelType.equalsIgnoreCase("Petrol") || 
               fuelType.equalsIgnoreCase("Diesel") || 
               fuelType.equalsIgnoreCase("Electric");
    }

    @Override
    public String toString() {
        return "Car [Make: " + make + ", Model: " + model + ", Year: " + yearOfManufacture +
               ", Doors: " + numberOfDoors + ", Fuel Type: " + fuelType + "]";
    }
}


//Define the Motorcycle class implementing the MotorVehicle interface
class Motorcycle implements MotorVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private int numberOfWheels;
    private String motorcycleType;
    
    // Constructor for Motorcycle class
    public Motorcycle(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        setYearOfManufacture(yearOfManufacture);
    }

    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    @Override
    public void setYearOfManufacture(int yearOfManufacture) {
    	 // Validates year of manufacture
        if (yearOfManufacture >= 1886 && yearOfManufacture <= 2024) {
            this.yearOfManufacture = yearOfManufacture;
        } else {
            throw new IllegalArgumentException("Year of manufacture must be between 1886 and 2024.");
        }
    }

    @Override
    public void setNumberOfWheels(int numberOfWheels) {
    	// Validates number of wheels
        if (numberOfWheels > 0) {
            this.numberOfWheels = numberOfWheels;
        } else {
            throw new IllegalArgumentException("Number of wheels must be greater than zero.");
        }
    }

    @Override
    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    @Override
    public void setMotorcycleType(String type) {
        if (isValidMotorcycleType(type)) {
            this.motorcycleType = type;
        } else {
            throw new IllegalArgumentException("Invalid motorcycle type. Must be Sport, Cruiser, or Off-road.");
        }
    }

    @Override
    public String getMotorcycleType() {
        return motorcycleType;
    }
    
    // Helper method to validate motorcycle type
    private boolean isValidMotorcycleType(String type) {
        return type.equalsIgnoreCase("Sport") || 
               type.equalsIgnoreCase("Cruiser") || 
               type.equalsIgnoreCase("Off-road");
    }

    // Override toString method for Motorcycle class
    @Override
    public String toString() {
        return "Motorcycle [Make: " + make + ", Model: " + model + ", Year: " + yearOfManufacture +
               ", Wheels: " + numberOfWheels + ", Type: " + motorcycleType + "]";
    }
}


//Define the Truck class implementing the TruckVehicle interface
class Truck implements TruckVehicle {
    private String make;
    private String model;
    private int yearOfManufacture;
    private double cargoCapacity;
    private String transmissionType;

    
    // Constructor for Truck class
    public Truck(String make, String model, int yearOfManufacture) {
        this.make = make;
        this.model = model;
        setYearOfManufacture(yearOfManufacture);
    }

    // Implementing methods from the TruckVehicle interface
    @Override
    public String getMake() {
        return make;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    @Override
    public void setYearOfManufacture(int yearOfManufacture) {
    	// Validate year of manufacture
        if (yearOfManufacture >= 1886 && yearOfManufacture <= 2024) {
            this.yearOfManufacture = yearOfManufacture;
        } else {
            throw new IllegalArgumentException("Year of manufacture must be between 1886 and 2024.");
        }
    }

    @Override
    public void setCargoCapacity(double cargoCapacity) {
    	// Validate cargo capacity
        if (cargoCapacity > 0) {
            this.cargoCapacity = cargoCapacity;
        } else {
            throw new IllegalArgumentException("Cargo capacity must be greater than zero.");
        }
    }

    @Override
    public double getCargoCapacity() {
        return cargoCapacity;
    }

    @Override
    public void setTransmissionType(String transmissionType) {
    	// Validate transmission type
        if (isValidTransmissionType(transmissionType)) {
            this.transmissionType = transmissionType;
        } else {
            throw new IllegalArgumentException("Invalid transmission type. Must be Manual or Automatic.");
        }
    }

    @Override
    public String getTransmissionType() {
        return transmissionType;
    }

    // Helper method to validate transmission type
    private boolean isValidTransmissionType(String transmissionType) {
        return transmissionType.equalsIgnoreCase("Manual") || 
               transmissionType.equalsIgnoreCase("Automatic");
    }

    // Override toString method for Truck class
    @Override
    public String toString() {
        return "Truck [Make: " + make + ", Model: " + model + ", Year: " + yearOfManufacture +
               ", Cargo Capacity: " + cargoCapacity + " tons, Transmission Type: " + transmissionType + "]";
    }
}


//Define the MainProgram class
public class MainProgram {
    private static List<Car> cars = new ArrayList<>();
    private static List<Motorcycle> motorcycles = new ArrayList<>();
    private static List<Truck> trucks = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    // Main method
    public static void main(String[] args) {
        while (true) {
            try {
            	// Display menu options
                System.out.println("Welcome to the Vehicle/Automobile Administration App");
                System.out.println("-------------------------------------");
                System.out.println("Select an operation:");
                System.out.println("1. Add Car");
                System.out.println("2. Add Motorcycle");
                System.out.println("3. Add Truck");
                System.out.println("4. Display all Cars");
                System.out.println("5. Display all Motorcycles");
                System.out.println("6. Display all Trucks");
                System.out.println("7. Exit");
                System.out.println("-------------------------------------");
                System.out.print("Your Choice =>: ");

                // Get user input for choice
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                
                // Menu logic
                switch (choice) {
                    case 1:
                        String carDetails = addCar();
                        System.out.println(carDetails);
                        
                        break;
                    case 2:
                        String motorcycleDetails = addMotorcycle();
                        System.out.println(motorcycleDetails);
                        
                        break;
                    case 3:
                        String truckDetails = addTruck();
                        System.out.println(truckDetails);
                        
                        break;
                    case 4:
                        displayAllCars();
                        break;
                    case 5:
                        displayAllMotorcycles();
                        break;
                    case 6:
                        displayAllTrucks();
                        break;
                    case 7:
                        System.out.println("You chose to exit the program. Bye for now");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please select a number between 1 and 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 7.");
                scanner.next(); // consume the invalid input
            }
        }
    }

    // Method to add a car
    private static String addCar() {
        System.out.print("Enter the car make: ");
        String make = scanner.nextLine();

        System.out.print("Enter the car model: ");
        String model = scanner.nextLine();

        int yearOfManufacture = getValidYearOfManufacture();

        Car car = new Car(make, model, yearOfManufacture);

        int numberOfDoors = getValidNumberOfDoors();
        car.setNumberOfDoors(numberOfDoors);

        String fuelType = getValidFuelType();
        car.setFuelType(fuelType);

        cars.add(car);
        System.out.println("Car added successfully!");
        
        return car.toString();
    }

    // Method to add a motorcycle
    private static String addMotorcycle() {
        System.out.print("Enter the motorcycle make: ");
        String make = scanner.nextLine();

        System.out.print("Enter the motorcycle model: ");
        String model = scanner.nextLine();

        int yearOfManufacture = getValidYearOfManufacture();

        Motorcycle motorcycle = new Motorcycle(make, model, yearOfManufacture);

        int numberOfWheels = getValidNumberOfWheels();
        motorcycle.setNumberOfWheels(numberOfWheels);

        String motorcycleType = getValidMotorcycleType();
        motorcycle.setMotorcycleType(motorcycleType);

        motorcycles.add(motorcycle);
        System.out.println("Motorcycle added successfully!");
        
        return motorcycle.toString();
    }

    // Method to add a truck
    private static String addTruck() {
        System.out.print("Enter the truck make: ");
        String make = scanner.nextLine();

        System.out.print("Enter the truck model: ");
        String model = scanner.nextLine();

        int yearOfManufacture = getValidYearOfManufacture();

        Truck truck = new Truck(make, model, yearOfManufacture);

        double cargoCapacity = getValidCargoCapacity();
        truck.setCargoCapacity(cargoCapacity);

        String transmissionType = getValidTransmissionType();
        truck.setTransmissionType(transmissionType);

        trucks.add(truck);
        System.out.println("Truck added successfully!");
        
        return truck.toString();
    }

    // Method to get valid year of manufacture    
    private static int getValidYearOfManufacture() {
        while (true) {
            try {
                System.out.print("Enter the year of manufacture (1001-2024): ");
                int yearOfManufacture = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (yearOfManufacture >= 1001 && yearOfManufacture <= 2024) {
                    return yearOfManufacture;
                } else {
                    System.out.println("Year of manufacture must be between 1001 and 2024.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.next(); // consume the invalid input
            }
        }
    }

    // Method to get valid number of doors
    private static int getValidNumberOfDoors() {
        while (true) {
            try {
                System.out.print("Enter the number of doors: ");
                int numberOfDoors = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (numberOfDoors > 0) {
                    return numberOfDoors;
                } else {
                    System.out.println("Number of doors must be greater than zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number of doors.");
                scanner.next(); // consume the invalid input
            }
        }
    }

    // Method to get valid fuel type
    private static String getValidFuelType() {
        while (true) {
            System.out.print("Enter the fuel type (Petrol, Diesel, Electric): ");
            String fuelType = scanner.nextLine();

            if (fuelType.equalsIgnoreCase("Petrol") || 
                fuelType.equalsIgnoreCase("Diesel") || 
                fuelType.equalsIgnoreCase("Electric")) {
                return fuelType;
            } else {
                System.out.println("Invalid fuel type. Must be Petrol, Diesel, or Electric.");
            }
        }
    }

    // Method to get valid number of wheels
    private static int getValidNumberOfWheels() {
        while (true) {
            try {
                System.out.print("Enter the number of wheels: ");
                int numberOfWheels = scanner.nextInt();
                scanner.nextLine(); // consume newline

                if (numberOfWheels > 0) {
                    return numberOfWheels;
                } else {
                    System.out.println("Number of wheels must be greater than zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number of wheels.");
                scanner.next(); // consume the invalid input
            }
        }
    }

    // Method to get valid motorcycle type
    private static String getValidMotorcycleType() {
        while (true) {
            System.out.print("Enter the motorcycle type (Sport, Cruiser, Off-road): ");
            String motorcycleType = scanner.nextLine();

            if (motorcycleType.equalsIgnoreCase("Sport") || 
                motorcycleType.equalsIgnoreCase("Cruiser") || 
                motorcycleType.equalsIgnoreCase("Off-road")) {
                return motorcycleType;
            } else {
                System.out.println("Invalid motorcycle type. Must be Sport, Cruiser, or Off-road.");
            }
        }
    }

    // Method to get valid cargo capacity
    private static double getValidCargoCapacity() {
        while (true) {
            try {
                System.out.print("Enter the cargo capacity in tons: ");
                double cargoCapacity = scanner.nextDouble();
                scanner.nextLine(); // consume newline

                if (cargoCapacity > 0) {
                    return cargoCapacity;
                } else {
                    System.out.println("Cargo capacity must be greater than zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid cargo capacity.");
                scanner.next(); // consume the invalid input
            }
        }
    }

    // Method to get valid transmission type
    private static String getValidTransmissionType() {
        while (true) {
            System.out.print("Enter the transmission type (Manual, Automatic): ");
            String transmissionType = scanner.nextLine();

            if (transmissionType.equalsIgnoreCase("Manual") || 
                transmissionType.equalsIgnoreCase("Automatic")) {
                return transmissionType;
            } else {
                System.out.println("Invalid transmission type. Must be Manual or Automatic.");
            }
        }
    }

    // Method to display all cars
    private static void displayAllCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available.");
        } else {
            for (Car car : cars) {
                System.out.println(car);
            }
        }
    }

    // Method to display all motorcycles
    private static void displayAllMotorcycles() {
        if (motorcycles.isEmpty()) {
            System.out.println("No motorcycles available.");
        } else {
            for (Motorcycle motorcycle : motorcycles) {
                System.out.println(motorcycle);
            }
        }
    }

    // Method to display all trucks
    private static void displayAllTrucks() {
        if (trucks.isEmpty()) {
            System.out.println("No trucks available.");
        } else {
            for (Truck truck : trucks) {
                System.out.println(truck);
            }
        }
    }
}


	
