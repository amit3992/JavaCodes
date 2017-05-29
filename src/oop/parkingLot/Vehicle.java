package oop.parkingLot;
import java.util.*;

public abstract class Vehicle {
	
	protected ArrayList<ParkingSpot> parkingSpots;
	private String licensePlate;
	private int spotsNeeded;
	private VehicleSize size;
	
	Vehicle(String licensePlate) {
		parkingSpots = new ArrayList<ParkingSpot>();
		this.licensePlate = licensePlate;
	}
	
	public ArrayList<ParkingSpot> getParkingSpots() {
		return parkingSpots;
	}
	public void setParkingSpots(ArrayList<ParkingSpot> parkingSpots) {
		this.parkingSpots = parkingSpots;
	}
	public String getLicencePlate() {
		return licensePlate;
	}
	public void setLicencePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public int getSpotsNeeded() {
		return spotsNeeded;
	}
	public void setSpotsNeeded(int spotsNeeded) {
		this.spotsNeeded = spotsNeeded;
	}
	public VehicleSize getSize() {
		return size;
	}
	public void setSize(VehicleSize size) {
		this.size = size;
	}
	
	public void parkInSpot(ParkingSpot s) {
		System.out.println("Parked in spot -> " + s.toString());
		parkingSpots.add(s);
	}
	
	public void clearSpots() {
		System.out.println("Cleared from spot -> " + parkingSpots.toString());
		parkingSpots.clear();
	}

}
