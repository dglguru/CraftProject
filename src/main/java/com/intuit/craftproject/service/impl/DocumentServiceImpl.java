package com.intuit.craftproject.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.intuit.craftproject.exception.FileStorageException;
import com.intuit.craftproject.exception.NoSuchDriverException;
import com.intuit.craftproject.model.Document;
import com.intuit.craftproject.model.DocumentType;
import com.intuit.craftproject.model.Driver;
import com.intuit.craftproject.repository.IDocumentRepository;
import com.intuit.craftproject.repository.IDriverRepository;
import com.intuit.craftproject.service.IDocumentSerice;

@Service
public class DocumentServiceImpl implements IDocumentSerice{

	@Autowired
	IDocumentRepository documentRepository;

	@Autowired
	IDriverRepository driverRepository;
	
	Path fileStorageLocation;



	@Override
	public String saveFile(MultipartFile file, long driverId, DocumentType docType) throws FileStorageException, IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		//check if filename contains invalid character
		if(fileName.contains("..")){
			throw new FileStorageException("Filename contains invalid characte");
		}

		SaveFileLocation(file, driverId, docType);
		Optional<Driver> driverDb = driverRepository.findById(driverId);

		if(driverDb.isPresent()){
			Driver driver = driverDb.get();
			Document document = new Document(fileName, docType, driver, file.getBytes());
			documentRepository.save(document);
		}
		else{
			throw new FileStorageException("No Driver Exist with this id");
		}
		return fileName;
	}
	
	public void SaveFileLocation(MultipartFile file, long driverId, DocumentType docType) throws FileStorageException, IOException{
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains("..")){
			throw new FileStorageException("Filename contains invalid characte");
		}
		this.fileStorageLocation = Paths.get("C:/Users/Guru/Desktop/Intuit").toAbsolutePath().normalize();
		Path targetLocation = this.fileStorageLocation.resolve(fileName);
		Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

		
	}

}
