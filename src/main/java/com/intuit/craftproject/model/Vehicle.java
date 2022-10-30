package com.intuit.craftproject.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Vehicle {

	@NotNull
	private int year;
	
	@NotNull
	private String make;
	
	@NotNull
	private String model;
	
	@NotNull
	private String vehicleNumber;
	
	@NotNull
	private VehicleType vehicleType;
	
	@NotNull
	private String color;
	
	@NotNull
	private String insuranceNumber;

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVehicleNumber() {
		return vehicleNumber;
	}

	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(String insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
	}
	
	public Vehicle(){
		
	}

	public Vehicle(@NotNull int year, @NotNull String make, @NotNull String model, @NotNull String vehicleNumber,
			@NotNull VehicleType vehicleType, @NotNull String color, @NotNull String insuranceNumber) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.vehicleNumber = vehicleNumber;
		this.vehicleType = vehicleType;
		this.color = color;
		this.insuranceNumber = insuranceNumber;
	}
	
	
	
}
