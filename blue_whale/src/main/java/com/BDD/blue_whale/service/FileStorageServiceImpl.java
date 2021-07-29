package com.BDD.blue_whale.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.var;

@Service
public class FileStorageServiceImpl implements FileStorageService{
	
	@Autowired
	FileStorageService fileStorageService;
	
	private final Path root = Paths.get("uploads");
	private final Path root2 = Paths.get("output_Data");
	//String filename ="file.xlsx";
	
	@Override
	public void init() {
		try {
			Files.createDirectory(root);
			Files.createDirectory(root2);
			
		} catch (IOException e) {
			throw new RuntimeException("could not initialize folder for upload");
		}
	}
	
	 @Override
	public void save(MultipartFile file) {
	    try {
	      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
	    } catch (Exception e) {
	      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
	    }
	  }
	 
	
	

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(root.toFile());
		FileSystemUtils.deleteRecursively(root2.toFile());
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
			
		} catch (Exception e) {
			throw new RuntimeException("Could not load the files !");
		}
		
	}
	
	//load methode for accepted or refused data from talend
	public Stream<Path> loadAllOutPutData() {
		try {
			return Files.walk(this.root2, 1).filter(path -> !path.equals(this.root2)).map(this.root2::relativize);
			
		} catch (Exception e) {
			throw new RuntimeException("Could not load the files !");
		}
		
	}
	
	
	@Override
	public Resource load(String filename) {
		
		Path file= root.resolve(filename);
		try {
			Resource resource = new UrlResource(file.toUri());
			
			if(resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file !");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Eroor:" +e.getMessage());
			
		}
		
	}
	
	@Override
	public Resource loadOutPutData(String filename) {
		
		Path file= root2.resolve(filename);
		try {
			Resource resource = new UrlResource(file.toUri());
			
			if(resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the file !");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Eroor:" +e.getMessage());
			
		}
		
	}

	/*@Override
	public List<List<String>> getRefusedData() {
		
		List<List<String>> records = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("root2/faostat_DataRefused"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		        String[] values = line.split(";");
		        records.add(Arrays.asList(values));
		    }
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		return records;
	}*/
	
	public String getRefusedData() {
		
		 List<String> csvRows = null;
	        try(var reader = Files.lines(Paths.get("output_Data\\\\faostat_DataRefused.csv"))){
	            csvRows = reader.collect(Collectors.toList());
	        }catch(Exception e){
	            e.printStackTrace();
	        }

	        if(csvRows != null){

	            String json = csvToJson(csvRows);
	            System.out.println(json);
	            return json;
	        }
			return null;
		
	}
	
	public static String csvToJson(List<String> csv){

        //remove empty lines
        //this will affect permanently the list. 
        //be careful if you want to use this list after executing this method
        csv.removeIf(e -> e.trim().isEmpty());

        //csv is empty or have declared only columns
        if(csv.size() <= 1){
            return "[]";
        }

        //get first line = columns names
        String[] columns = csv.get(0).split(";");

        //get all rows
        StringBuilder json = new StringBuilder("[\n");
        csv.subList(1, csv.size()) //substring without first row(columns)
            .stream()
            .map(e -> e.split(";"))
            .filter(e -> e.length == columns.length) //values size should match with columns size
            .forEach(row -> {

                json.append("\t{\n");

                    for(int i = 0; i < columns.length; i++){
                        json.append("\t\t\"")
                            .append(columns[i])
                            .append("\" : \"")
                            .append(row[i])
                            .append("\",\n"); //comma-1
                    }

                    //replace comma-1 with \n
                    json.replace(json.lastIndexOf(","), json.length(), "\n");

                json.append("\t},"); //comma-2

            });

        //remove comma-2
        json.replace(json.lastIndexOf(","), json.length(), "");

        json.append("\n]");

        return json.toString();

    }

	/*public static void main(String [] args) {
		    int i=0;
		    String filename="output_Data\\faostat_DataRefused.csv";
		    Path pathToFile = Paths.get(filename);
		    System.out.println(pathToFile.toAbsolutePath());
			
			 fileStorageService.getRefusedData();
		}*/
	
	

}


