package com.intuit.craftproject.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.craftproject.exception.AlreadyExistException;
import com.intuit.craftproject.exception.NoSuchDriverException;
import com.intuit.craftproject.model.Driver;
import com.intuit.craftproject.repository.IDriverRepository;
import com.intuit.craftproject.service.IDriverService;

@Service
public class DriverServiceImpl implements IDriverService {
	
	@Autowired
	IDriverRepository driverRepository;

	@Override
	public Driver Save(Driver driver) throws AlreadyExistException {
		
		Driver driverDb = driverRepository.findByEmail(driver.getEmail());
		
		if(driverDb != null){
			throw new AlreadyExistException("Driver already Exists with this Email");
		}
		return driverRepository.save(driver);
	}

	@Override
	public Driver get(long driverId) throws NoSuchDriverException {
		Optional<Driver> driverDb = driverRepository.findById(driverId);
		
		if(driverDb.isPresent()){
			return driverDb.get();
		}
		else{
			throw new NoSuchDriverException("No Driver exist with this id");
		}
	}

	@Override
	public Driver markActive(long driverId) throws NoSuchDriverException {
		Optional<Driver> driverDb = driverRepository.findById(driverId);

		if(driverDb.isPresent()){
			Driver driver = driverDb.get();
			driver.setActive(true);
			return driverRepository.save(driver);
		}
		else{
			throw new NoSuchDriverException("No Driver exist with this id");
		}
	}

	@Override
	public Driver setVerifiedFlag(long driverId) throws NoSuchDriverException {
		Optional<Driver> driverDb = driverRepository.findById(driverId);

		if(driverDb.isPresent()){
			Driver driver = driverDb.get();
			driver.setVerified(true);
			return driverRepository.save(driver);
		}
		else{
			throw new NoSuchDriverException("No Driver exist with this id");
		}
	}

	@Override
	public Driver setDocumentsUploadFlag(long driverId) throws NoSuchDriverException {
		Optional<Driver> driverDb = driverRepository.findById(driverId);

		if(driverDb.isPresent()){
			Driver driver = driverDb.get();
			driver.setDocumentsUploaded(true);
			return driverRepository.save(driver);
		}
		else{
			throw new NoSuchDriverException("No Driver exist with this id");
		}
	}
	
	


}
