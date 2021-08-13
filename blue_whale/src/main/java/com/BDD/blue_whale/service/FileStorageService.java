package com.BDD.blue_whale.service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	public void init();
	public void save(MultipartFile file);
	public Resource load(String filename);
	public Resource loadOutPutData(String filename);
	public void deleteAll();
	public Stream<Path> loadAll();
	public Stream<Path> loadAllOutPutData();
	
	public String convertExcel2Json();
	public String convertCSV2Json(String filename);
	
	public String mergeComtradeAndConvertCs2Json();
		
	
	
}
