package com.BDD.blue_whale.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.BDD.blue_whale.entities.Excel;
import com.BDD.blue_whale.entities.FileInfo;
import com.BDD.blue_whale.message.ResponseMessage;
import com.BDD.blue_whale.service.FileStorageService;

import test.comtradem_csv_0_1.comtradeM_CSV;
import test.comtradex_csv_0_1.comtradeX_CSV;
import test.faostat_0_1.faostat;
import test.faostat_tableau_croise_dynamique_0_1.faostat_tableau_croise_dynamique;
import test.resourcetradeearth_0_1.resourcetradeearth;


@RestController
@CrossOrigin("*")
public class FileController {
	
	@Autowired
	private FileStorageService filestorageService;
	
	@PostMapping("/upload")//téléchargement du fichier dans le répertoire uploads
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file){
		String message ="";
		try {
			filestorageService.save(file);
			message ="Uploaded the file successfully : " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	}
	
	
	//charger les données dans la base de données
	@PostMapping("/upload/resourcetradeearth")
	public ResponseEntity<ResponseMessage> resourcetradeearth(@RequestParam("file") MultipartFile file) {
		String message ="";
		
			resourcetradeearth talendJob = new resourcetradeearth();
			String resourcetradeearth="uploads\\\\\\\\"+ file.getOriginalFilename();//input file
			String DataAccepted = "output_Data\\\\ressource_trade_earth_DataAccepted.xls";//output file with data accepted
			String DataRefused ="output_Data\\\\ressource_trade_earth_DataRefused.xls";//output file with data refused
			
			String [] context=new String[] {"--context_param resource_file_resourcetradeearth="+resourcetradeearth,
					"--context_param resource_file_ressourcetradeearthAccepted="+DataAccepted,
					"--context_param resource_file_ressourcetradeearthRefused="+DataRefused};
			//talendJob.runJob(context);
			int exitCode = talendJob.runJobInTOS(context);//code retour après execution de talend
			
			if (exitCode == 0) {
				message ="file :" + file.getOriginalFilename()+" uploaded to the database ";
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} else {
				message = "Could not upload the file: " + file.getOriginalFilename() + " to the database !" ;
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
			}
			
	}
	
	@PostMapping("/upload/comtrade")
	public ResponseEntity<ResponseMessage> comtrade(@RequestParam("file") MultipartFile file) {
		String message ="";
		
		
		//jar for file with X (X: export M: import)
		comtradeX_CSV talendJobX = new comtradeX_CSV(); 
		String resource_file_comtradeX="uploads\\\\\\\\"+ file.getOriginalFilename();//input file
		String DataAcceptedX = "output_Data\\\\ComtradeX_DataAccepted.csv";//output file with data accepted X
		String DataRefusedX ="output_Data\\\\ComtradeX_DataRefused.csv";//output file with data refused X
		
		String[] context=new String[] {"--context_param resource_file_comtradeX="+resource_file_comtradeX,
				"--context_param resource_file_comtradeX_Accepted="+DataAcceptedX, "--context_param resource_file_comtradeX_Refused="+DataRefusedX};
		//talendJobX.runJob(context);
		int exitCode1 = talendJobX.runJobInTOS(context);
		

		//jar for file with M (M : import)
		comtradeM_CSV talendJobM = new comtradeM_CSV(); 
		String resource_file_comtradeM="uploads\\\\\\\\"+ file.getOriginalFilename();
		String DataAcceptedM = "output_Data\\\\ComtradeM_DataAccepted.csv";//output file with data accepted M
		String DataRefusedM ="output_Data\\\\ComtradeM_DataRefused.csv";//output file with data refused M
		
		String[] context2=new String[] {"--context_param resource_file_comtradeM="+resource_file_comtradeM, 
				"--context_param resource_file_comtradeM_Accepted="+DataAcceptedM, "--context_param resource_file_comtradeM_Refused="+DataRefusedM};
		//talendJobM.runJob(context2);
		int exitCode2 = talendJobM.runJobInTOS(context2);
		
		
		if (exitCode1 == 0 && exitCode2 == 0) {
			message ="Data in file : " + file.getOriginalFilename()+" uploaded to the database ";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} else {
			message = "Could not upload the Data in file : " + file.getOriginalFilename() + " to the database !" ;
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
		}
	}
	
	@PostMapping("/upload/faostat")
	public ResponseEntity<ResponseMessage> faostat(@RequestParam("file") MultipartFile file) {
		
		String message ="";
		if(!file.getOriginalFilename().endsWith(".csv")) {
			
			//convert table with tableau croisee dynamique
			faostat_tableau_croise_dynamique talendJob = new faostat_tableau_croise_dynamique();
			String faostat="uploads\\\\\\\\"+ file.getOriginalFilename(); //input file
			String outfaostat="target\\outfaostat.csv"; //output file from faostat tableau croise dynamique
			String [] context=new String[] {"--context_param resource_file_faostat="+faostat, "--context_param resource_file_outfaostat="+outfaostat};
			//talendJob.runJob(context);
			int exitCode1 = talendJob.runJobInTOS(context);
			
			
			//copy data to database
			faostat talendJob2 = new faostat();
			String faostat2=outfaostat;
			String DataAccepted = "output_Data\\\\faostat_DataAccepted.csv";
			String DataRefused ="output_Data\\\\\\\\faostat_DataRefused.csv";
			String [] context2=new String[] {"--context_param resource_file_faostat2="+faostat2, "--context_param resource_file_DataAccepted="+DataAccepted,
					"--context_param resource_file_DataRefused="+DataRefused};
			//talendJob2.runJob(context2);
			int exitCode2 = talendJob2.runJobInTOS(context2);
			
			
			
			if (exitCode1 == 0 && exitCode2 == 0) {
				message ="file :" + file.getOriginalFilename()+" uploaded to the database ";
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} else {
				//message = "Could not upload the file: " + file.getOriginalFilename() + " to the database !" ;
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
			} 
		} 
		else {
			
			//copy data to database
			faostat talendJob2 = new faostat();
			String faostat2="uploads\\\\\\\\"+ file.getOriginalFilename();
			String DataAccepted = "output_Data\\\\faostat_DataAccepted.csv";
			String DataRefused ="output_Data\\\\\\\\faostat_DataRefused.csv";
			String [] context2=new String[] {"--context_param resource_file_faostat2="+faostat2, "--context_param resource_file_DataAccepted="+DataAccepted,
					"--context_param resource_file_DataRefused="+DataRefused};
			//talendJob2.runJob(context2);
			int exitCode2 = talendJob2.runJobInTOS(context2);
			
			
			if (exitCode2 == 0) {
				message ="file :" + file.getOriginalFilename()+" uploaded to the database ";
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} else {
				//message = "Could not upload the file: " + file.getOriginalFilename() + " to the database !" ;
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
			} 
		}
	}
	
	
	 @GetMapping("/files")
	  public ResponseEntity<List<FileInfo>> getListFiles() {
	    List<FileInfo> fileInfos = filestorageService.loadAll().map(path -> {
	      String filename = path.getFileName().toString();
	      
	      //url pour pouvoir télécharger le fichier
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();

	      return new FileInfo(filename, url);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	  }
	 
	 @GetMapping("/files/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) {//controller pour télécharger un fichier
	    Resource file = filestorageService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }
	 
	 @GetMapping("/files/outputData")
	  public ResponseEntity<List<FileInfo>> getListOutPutData() {//récupérer tous les fichiers output
	    List<FileInfo> fileInfos = filestorageService.loadAllOutPutData().map(path -> {
	      String filename = path.getFileName().toString();
	      //rendre le fichier de sortie comme url pour le télécharger 
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(FileController.class, "getFileOutputData", path.getFileName().toString()).build().toString();

	      return new FileInfo(filename, url);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	  }
	  
	  @GetMapping("/file/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFileOutputData(@PathVariable String filename) {//télécharger le fichier
	    Resource file = filestorageService.loadOutPutData(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }
	  
	  @GetMapping("/readCsv/{filename}")
	  public ResponseEntity<String> getRefusedData(@PathVariable("filename") String filename){
		  
		 String refusedJson= filestorageService.convertCSV2Json(filename);
		 return new ResponseEntity<>(refusedJson, HttpStatus.OK);
	  }
	  
	  @GetMapping("/readExcel")
	  public ResponseEntity<String> convertExcel2Json(){
		  
		 String refusedJson= filestorageService.convertExcel2Json();
		  
		 return new ResponseEntity<>(refusedJson, HttpStatus.OK);
	  }
	  
	  @GetMapping("/readCsvAfterMerge")
	  public ResponseEntity<String> mergeComtradeAndConvertCs2Json(){
		  
		 String refusedJson= filestorageService.mergeComtradeAndConvertCs2Json();
		 return new ResponseEntity<>(refusedJson, HttpStatus.OK);
	  }
	  
	 
	  
	
	
}
