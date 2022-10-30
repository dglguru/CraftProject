package com.intuit.craftproject.service;

import com.intuit.craftproject.exception.AlreadyExistException;
import com.intuit.craftproject.exception.NoSuchDriverException;
import com.intuit.craftproject.model.Driver;

public interface IDriverService {

	Driver Save(Driver driver) throws AlreadyExistException; 
	Driver get(long driverId) throws NoSuchDriverException;
	Driver markActive(long driverId) throws NoSuchDriverException;
	Driver setVerifiedFlag(long driverId) throws NoSuchDriverException;
	Driver setDocumentsUploadFlag(long driverId) throws NoSuchDriverException;
	
}
