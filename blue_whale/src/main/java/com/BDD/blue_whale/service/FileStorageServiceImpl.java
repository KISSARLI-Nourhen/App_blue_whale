package com.BDD.blue_whale.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.BDD.blue_whale.entities.Excel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.var;

@Service
public class FileStorageServiceImpl implements FileStorageService{
	
	@Autowired
	private FileStorageService fileStorageService;
	
	private final Path root = Paths.get("uploads");//répertoire pour les fichiers téléchargés
	private final Path root2 = Paths.get("output_Data");//répertoire pour les fichiers output
	String ComtradeRefused[] = {"ComtradeM_DataRefused.csv", "ComtradeX_DataRefused.csv"};
	
	@Override
	public void init() { //creation des répertoires
		try {
			Files.createDirectory(root);
			Files.createDirectory(root2);
			
		} catch (IOException e) {
			throw new RuntimeException("could not initialize folder for upload");
		}
	}
	
	 @Override
	public void save(MultipartFile file) {//enregistrer un fichier dans le répertoire upload
	    try {
	      Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
	    } catch (Exception e) {
	      throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
	    }
	  }
	 
	
	@Override
	public void deleteAll() {//supprime les files dans les répertoires lors de démarrage
		FileSystemUtils.deleteRecursively(root.toFile());
		FileSystemUtils.deleteRecursively(root2.toFile());
	}
	

	@Override
	public Stream<Path> loadAll() {//afficher tous les fichiers qui sont dans le répertoire upload input
		try {
			return Files.walk(this.root, 1).filter(path -> !path.equals(this.root)).map(this.root::relativize);
			
		} catch (Exception e) {
			throw new RuntimeException("Could not load the files !");
		}	
	}
	
	//load methode for accepted or refused data from talend
	@Override
	public Stream<Path> loadAllOutPutData() {//afficher tous les fichiers qui sont dans le répertoire output_Data
		try {
			return Files.walk(this.root2, 1).filter(path -> !path.equals(this.root2)).map(this.root2::relativize);
			
		} catch (Exception e) {
			throw new RuntimeException("Could not load the files !");
		}
	}
	
	
	@Override
	public Resource load(String filename) {//téléchargement du fichier input
		
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
	public Resource loadOutPutData(String filename) {//téléchargement des fichiers output
		
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

	/**
	 * use this method to get refused data from faostat and show it in angular
	 * pour cela on doit récupérer les données sous forme de Json pour le front
	 */
	@Override
	public String convertCSV2Json(String filename) {
		//open and read csv file faostat_DataRefused.csv ComtradeM_DataRefused.csv
		 List<String> csvRows = null;
	        try(var reader = Files.lines(Paths.get("output_Data\\\\"+filename))){
	        	
	            csvRows = reader.collect(Collectors.toList());
	        } catch(Exception e){
	            e.printStackTrace();
	        }

	        if(csvRows != null){
	        	//convert csv to json 
	            String json = csvToJson(csvRows);
	            System.out.println(json);
	            return json;
	        }
	        return null;
	}
	
	
	//method to covert csv file to json
	public static String csvToJson(List<String> csv){

        //remove empty lines this will affect permanently the list. 
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
            .map(e -> e.split(";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"))
            .filter(e -> e.length == columns.length) //values size should match with columns size
            .forEach(row -> {

                json.append("\t{\n");

                    for(int i = 0; i < columns.length; i++){
                        json.append("\t\t\"")
                            .append(columns[i])
                            .append("\" : ")
                            .append(row[i])
                            .append(",\n"); //comma-1
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
	
	/**
	 * method to convert excel file resource trade earth to json 
	 */
	@Override
	public String convertExcel2Json() {
		//String filename = "ressource_trade_earth_DataRefused.xls";
		// Step 1: Read Excel File into Java List Objects
		List files = readExcelFile("output_Data\\\\ressource_trade_earth_DataRefused.xls");
		// Step 2: Convert Java Objects to JSON String
		String jsonString = convertObjects2JsonString(files);
		System.out.println(jsonString);
		return jsonString;
	}
	
	/**
	 * Read excel file into java List Objects
	 */
	public static List readExcelFile(String filePath) {
		try {
			FileInputStream excelFile = new FileInputStream(new File(filePath));
			//workbook is a collection of one or more spreadsheets, also called worksheets, in a single file
			HSSFWorkbook workbook = new HSSFWorkbook(excelFile);
			//Workbook workbook = WorkbookFactory.create(new File(filePath));
			//Get an Excel Sheet from above Workbook
			HSSFSheet sheet=workbook.getSheetAt(0);  
			
			Iterator<Row> rows = sheet.iterator();
			
			List listeLigne = new ArrayList();
			
			int rowNumber = 0;
			while (rows.hasNext()) {
    			Row currentRow = rows.next();
    			
    			// skip header
    			if(rowNumber == 0) {
    				rowNumber++;
    				continue;
    			}
    			Iterator<org.apache.poi.ss.usermodel.Cell> cellsInRow = currentRow.iterator();
    			 
    			Excel excel = new Excel();
    			
    			int cellIndex = 0;
    			while (cellsInRow.hasNext()) {
    				Cell currentCell = (Cell) cellsInRow.next();
    				
    				
    				 if(cellIndex==0) { // trade_flow
    					excel.setTradeflow(new DataFormatter().formatCellValue((Cell) currentCell));
    				} 
    				else if(cellIndex==1) { // country_exporter_name
    					excel.setCountry_expo(new DataFormatter().formatCellValue((Cell) currentCell));
    				} 
    				else if(cellIndex==2) { // country_importer_name
    					excel.setCountry_impo(new DataFormatter().formatCellValue((Cell) currentCell));
    				} 
    				else if(cellIndex==3) { // produit_name
    					excel.setProduct( new DataFormatter().formatCellValue((Cell) currentCell));

    				}
    				else if(cellIndex==4) { // variety
    					excel.setVariety(new DataFormatter().formatCellValue((Cell) currentCell));
    				}
    				else if(cellIndex==5) { // years
    					excel.setYears(new DataFormatter().formatCellValue((Cell) currentCell));
    				}
    				else if(cellIndex==6) { // months
    					excel.setMonths(new DataFormatter().formatCellValue((Cell) currentCell));
					} 
    				else if(cellIndex==7) { // value
						excel.setValue(new DataFormatter().formatCellValue((Cell) currentCell));
					}
					else if(cellIndex==8) { // unit_value
						excel.setUnit_value( new DataFormatter().formatCellValue((Cell) currentCell));
					}
					else if(cellIndex==9) { // netweight
						excel.setNetweight(new DataFormatter().formatCellValue((Cell) currentCell));
					}
					else if(cellIndex==10) { // unit_netweight
						excel.setUnit_netweight(new DataFormatter().formatCellValue((Cell) currentCell));

					}
					else if(cellIndex==11) { // source
						excel.setSource(new DataFormatter().formatCellValue((Cell) currentCell));
					}
    				cellIndex++;
    			}
    			listeLigne.add(excel);
			}
			
			// Close WorkBook
    		workbook.close();
    		
    		return listeLigne;
    		
		} catch(IOException e) {
			throw new RuntimeException("fail to parse Excel file = " + e.getMessage());
		}
	}
	
	/**
	 * Convert Java Objects to JSON String
	 */
	private static String convertObjects2JsonString(List files) {
		
    	ObjectMapper mapper = new ObjectMapper();
    	String jsonString = "";
    	try {
    		jsonString = mapper.writeValueAsString(files);
    	} catch (JsonProcessingException e) {
    		e.printStackTrace();
    	}
    	
    	return jsonString; 
	}
	
	/**
	 * get refused data from comtrade to show it in angular
	 * step 1 : merge csv file comtradex and comtradeM into file comtrade
	 * step 2 : converte comtrade.csv to json with method convertCSV2Json(filename) (used in faostat)
	 */
	
	@Override
	public String mergeComtradeAndConvertCs2Json() {
		String filename = mergeComtrade();
		return convertCSV2Json(filename);
	}
	
	
	public String mergeComtrade() {
		
		try {
			
			PrintWriter pw = new PrintWriter("output_Data\\\\Comtrade_DataRefused.csv"); 
	
		    // BufferedReader object for file1.txt 
		    BufferedReader br1 = new BufferedReader(new FileReader("output_Data\\\\ComtradeX_DataRefused.csv")); 
		    BufferedReader br2 = new BufferedReader(new FileReader("output_Data\\\\ComtradeM_DataRefused.csv")); 
	
		    String line1 = br1.readLine(); //header comtradeX
		   
		    String line2 = br2.readLine();  //header comtradeM
		   
		    
		    // loop to copy lines of ComtradeX and ComtradeM  to  Comtrade alternatively 
		    while (line1 != null || line2 !=null) { 
		        while(line1 != null) 
		        { 
		            pw.println(line1); 
		            line1 = br1.readLine();
		           // System.out.println(line1);
		        }
		        
		        while(line2 != null) 
		        { 
		        	//System.out.println(line2);
		        	if(line2.startsWith("tradeflow")) {
		        		line2 = br2.readLine();
		        		break;
		        	} else {
		        		 pw.println(line2); 
				         line2 = br2.readLine(); 
		        	}
		        } 
		    } 
	
		    pw.flush(); 
	
		    // closing resources 
		    br1.close(); 
		    br2.close(); 
		    pw.close(); 
	       
		} catch (IOException e) {
			
			e.printStackTrace();
		}	
		return  "Comtrade_DataRefused.csv";	
}
	


	
	
	
}


