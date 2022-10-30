package com.intuit.craftproject.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.intuit.craftproject.exception.FileStorageException;
import com.intuit.craftproject.model.DocumentType;

public interface IDocumentSerice {
	
	String saveFile(MultipartFile file, long driverId, DocumentType docType) throws FileStorageException, IOException;

}
