package com.intuit.craftproject.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "driver_documents")
public class Document {

	@Id
	@Column(name = "document_id",nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long documentId;
	
	@Column(name="document_name")
	private String documentName;
	
	@Column(name="document_type")
	private DocumentType documentType;
	
	@ManyToOne
	@JoinColumn(name="driver_id")
	private Driver driver;
	
    @Lob
	private byte[] data;
	
	public Document() {
		
	}

	public Document(String documentName, DocumentType documentType, Driver driver, byte[] data) {
		this.documentName = documentName;
		this.documentType = documentType;
		this.driver = driver;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", documentName=" + documentName + ", documentType="
				+ documentType + ", driver=" + driver + ", data=" + Arrays.toString(data) + "]";
	}
	
	
	
	
}
 