package com.intuit.craftproject.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.craftproject.exception.AlreadyExistException;
import com.intuit.craftproject.exception.NoSuchDriverException;
import com.intuit.craftproject.model.Driver;
import com.intuit.craftproject.service.IDriverService;

@RestController
@Validated
public class DriverController {

	private static final Logger logger =  LoggerFactory.getLogger(DriverController.class);
	
	@Autowired
	IDriverService driverService;

	@PostMapping("/driver")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Driver save( @Valid @RequestBody Driver driver) throws AlreadyExistException{
		return driverService.Save(driver);
	}
	
	@GetMapping("/driver/{driverId}")
	public Driver get(@PathVariable("driverId") long driverId) throws NoSuchDriverException {
		return driverService.get(driverId);
	}
	
	@PutMapping("/driver/{driverId}/markActive")
	public Driver markActive(@PathVariable("driverId") long driverId) throws NoSuchDriverException {
		return driverService.markActive(driverId);
	}

	@PutMapping("/driver/{driverId}/documentVerified")
	public Driver setVerifiedFlag(@PathVariable("driverId") long driverId) throws NoSuchDriverException {
		return driverService.setVerifiedFlag(driverId);
	}

	@PutMapping("/driver/{driverId}/setDocumentsUploadFlag")
	public Driver setDocumentsUploadFlag(@PathVariable("driverId") long driverId) throws NoSuchDriverException {
		return driverService.setDocumentsUploadFlag(driverId);
	}
	
	
	
}
