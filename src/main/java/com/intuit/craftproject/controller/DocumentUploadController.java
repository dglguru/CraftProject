package com.intuit.craftproject.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.intuit.craftproject.exception.FileStorageException;
import com.intuit.craftproject.exception.NoSuchDriverException;
import com.intuit.craftproject.model.DocumentType;
import com.intuit.craftproject.model.UploadFileResponse;
import com.intuit.craftproject.service.IDocumentSerice;
import com.intuit.craftproject.service.IDriverService;

@RestController
public class DocumentUploadController {

	private static final Logger logger =  LoggerFactory.getLogger(DriverController.class);

	@Autowired
	IDocumentSerice storageService;

	@Autowired
	IDriverService driverService;

	@PostMapping("/uploadFile")
	@ResponseStatus(code = HttpStatus.CREATED)
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("driverId") Long driverId,
			@RequestParam("docType") DocumentType docType) throws FileStorageException, IOException, NoSuchDriverException{

		String fileName  = storageService.saveFile(file, driverId, docType);

		driverService.setDocumentsUploadFlag(driverId);

		return new UploadFileResponse(fileName, file.getContentType(), file.getSize());

	}
	
	



}
