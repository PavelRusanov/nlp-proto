package ru.intrface.movieactors.web;


import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.InvalidXMLException;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import ru.intrface.movieactors.ejb.DocumentManagerEJB;
import ru.intrface.movieactors.ejb.exception.DataManagerException;


@ManagedBean(name = "documentManager")
@ViewScoped
public class DocumentManagerBean {
	private static Logger logger = Logger.getLogger(DocumentManagerBean.class);
	private boolean renderDocTable;
	private boolean renderLoadPage;
	private boolean renderDocInfo;
	
	private UploadedFile docFile;
	
	@EJB
	DocumentManagerEJB docManager;
	
	public boolean isRenderDocTable() {
		return renderDocTable;
	}
	public void setRenderDocTable(boolean renderDocTable) {
		this.renderDocTable = renderDocTable;
	}
	public boolean isRenderDocInfo() {
		return renderDocInfo;
	}
	public void setRenderDocInfo(boolean renderDocInfo) {
		this.renderDocInfo = renderDocInfo;
	}
	
	public boolean isRenderLoadPage() {
		return renderLoadPage;
	}
	public void setRenderLoadPage(boolean renderLoadPage) {
		this.renderLoadPage = renderLoadPage;
	}
	public UploadedFile getDocFile() {
		return docFile;
	}
	public void setDocFile(UploadedFile docFile) {
		this.docFile = docFile;
	}
	@PostConstruct
	public void init(){
		renderDocInfo = false;
		renderDocTable = false;
		renderLoadPage = false;
		logger.info("DocumentManagerBean has been succesfully loaded");
	}

	public void showDocTable(){
		renderDocTable = true;
		renderDocInfo = false;
		renderLoadPage = false;
	}
	
	public void showLoadPage(){
		renderDocTable = false;
		renderDocInfo = false;
		renderLoadPage = true;
	}
	
	public void handleFileUpload(FileUploadEvent event){
		logger.info("File upload started");
		UploadedFile file = event.getFile();
		String name = file.getFileName();
		try {
			docManager.addDocument(name, file.getInputstream());
			logger.info("File with name "+name+" uploaded to system");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void processDocs(){
		try {
			docManager.forceProcessNewDocuments();
		} catch (InvalidXMLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ResourceInitializationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DataManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
