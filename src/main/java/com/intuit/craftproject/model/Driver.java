package com.intuit.craftproject.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "drivers")
public class Driver {
	
	//primary key of table
	@Id
	@Column(name ="driverId",nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	
	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	@NotNull
	@Email
	@Column(unique = true)
	private String email;
	
	@NotNull
	private String password;
	
	@NotNull
	@Embedded
	private Address address;
	
	@NotNull
	@Embedded
	private Vehicle vehicle;
	
	@NotNull
	private String phoneNumber;
	
	@Column(name = "joined_Date",nullable=false,updatable=false)
	private LocalDateTime joinedDate;
	
	@NotBlank
    private String driverLicenceNumber;
	
	private double rating;
	
	private boolean documentsUploaded;
	
	private boolean isVerified;
	
	private boolean isActive;
	
	private double longitude;
	
	private double latitude;
	
	@OneToMany(mappedBy="driver",fetch=FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Document> document;
	
	
	public Long getId() {
		
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDateTime getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(LocalDateTime joinedDate) {
		this.joinedDate = joinedDate;
	}

	public String getDriverLicenceNumber() {
		return driverLicenceNumber;
	}

	public void setDriverLicenceNumber(String driverLicenceNumber) {
		this.driverLicenceNumber = driverLicenceNumber;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public boolean isDocumentsUploaded() {
		return documentsUploaded;
	}

	public void setDocumentsUploaded(boolean documentsUploaded) {
		this.documentsUploaded = documentsUploaded;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public List<Document> getDocument() {
		return document;
	}

	public void setDocument(List<Document> document) {
		this.document = document;
	}

	public Driver(Long id, @NotNull String firstName, @NotNull String lastName, @NotNull @Email String email,
			@NotNull String password, @NotNull Address address, @NotNull Vehicle vehicle, @NotNull String phoneNumber,
			LocalDateTime joinedDate, @NotBlank String driverLicenceNumber, double rating, boolean documentsUploaded,
			boolean isVerified, boolean isActive,double longitude, double latitude, List<Document> document) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.address = address;
		this.vehicle = vehicle;
		this.phoneNumber = phoneNumber;
		this.joinedDate = joinedDate;
		this.driverLicenceNumber = driverLicenceNumber;
		this.rating = rating;
		this.documentsUploaded = documentsUploaded;
		this.isVerified = isVerified;
		this.isActive = isActive;
		this.longitude = longitude;
		this.latitude = latitude;
		this.document = document;
	}
	
	public Driver(){
		
	}

	
	
}
