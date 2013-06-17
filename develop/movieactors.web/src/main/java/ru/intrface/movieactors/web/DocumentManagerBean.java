package ru.intrface.movieactors.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import ru.intrface.movieactors.model.SourceDocument;

@ManagedBean(name = "documentManager")
@ViewScoped
public class DocumentManagerBean {
	private static Logger logger = Logger.getLogger(DocumentManagerBean.class);
	private boolean renderDocTable;
	private boolean renderLoadPage;
	private boolean renderDocInfo;
	
	private UploadedFile docFile;
	
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
		logger.info("File with name "+name+" uploaded to system");
		

		
	}
}
