interface Vehicle {
    String getType();
}

class Car implements Vehicle {
    @Override
    public String getType() {
        return "Car";
    }
}

class Bike implements Vehicle {
    @Override
    public String getType() {
        return "Bike";
    }
}

class Truck implements Vehicle {
    @Override
    public String getType() {
        return "Truck";
    }
}

abstract class VehicleFactory {
    abstract Vehicle createVehicle();
}

class CarFactory extends VehicleFactory {
    Vehicle vehicle;
    Vehicle createVehicle(){
        this.vehicle = new Car();
        return this.vehicle;
    }
}

class BikeFactory extends VehicleFactory {
    Vehicle vehicle;
    Vehicle createVehicle(){
        this.vehicle = new Bike();
        return this.vehicle;
    }
}

class TruckFactory extends VehicleFactory {
    Vehicle vehicle;
    Vehicle createVehicle(){
        this.vehicle = new Truck();
        return this.vehicle;
    }
}
