package oop.parkingLot;

public class Car extends Vehicle {
	
	Car(String licensePlate) {
		super(licensePlate);
		setSpotsNeeded(1);
		setSize(VehicleSize.Compact);
	}
	
}
