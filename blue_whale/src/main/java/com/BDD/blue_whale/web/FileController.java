package com.BDD.blue_whale.web;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.BDD.blue_whale.entities.FileInfo;
import com.BDD.blue_whale.message.ResponseMessage;
import com.BDD.blue_whale.service.FileStorageService;

import test.comtradem_csv_0_1.comtradeM_CSV;
import test.comtradex_csv_0_1.comtradeX_CSV;
import test.faostat_0_1.faostat;
import test.faostat_tableau_croise_dynamique_0_1.faostat_tableau_croise_dynamique;
import test.resourcetradeearth_0_1.resourcetradeearth;

@RestController
public class FileController {
	
	@Autowired
	private FileStorageService filestorageService;
	
	@PostMapping("/upload")
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
	
	@PostMapping("/upload/resourcetradeearth")
	public ResponseEntity<ResponseMessage> resourcetradeearth(@RequestParam("file") MultipartFile file) {
		String message ="";
		try {
			resourcetradeearth talendJob = new resourcetradeearth();
			String resourcetradeearth="uploads\\\\\\\\"+ file.getOriginalFilename();
			String [] context=new String[] {"--context_param resource_file_resourcetradeearth="+resourcetradeearth};
			talendJob.runJob(context);
			
			message ="file :" + file.getOriginalFilename()+" uploaded to the database ";
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			
		} catch (Exception e) {
			 message = "Could not upload the file: " + file.getOriginalFilename() + " to the database !" ;
		      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
		}
		
	}
	
	@PostMapping("/upload/comtrade")
	public void comtrade(@RequestParam("file") MultipartFile file) {
		
		//jar for file with X
		comtradeX_CSV talendJobX = new comtradeX_CSV(); 
		String resource_file_comtradeX="uploads\\\\\\\\"+ file.getOriginalFilename();
		String [] context=new String[] {"--context_param resource_file_comtradeX="+resource_file_comtradeX};
		talendJobX.runJob(context);
		
		//jar for file with X
		comtradeM_CSV talendJobM = new comtradeM_CSV(); 
		String resource_file_comtradeM="uploads\\\\\\\\"+ file.getOriginalFilename();
		String [] context2=new String[] {"--context_param resource_file_comtradeM="+resource_file_comtradeM};
		talendJobM.runJob(context2);
	}
	
	@PostMapping("/upload/faostat")
	public void faostat(@RequestParam("file") MultipartFile file) {
		
		//convert table with tableau croisee dynamique
		faostat_tableau_croise_dynamique talendJob = new faostat_tableau_croise_dynamique();
		String faostat="uploads\\\\\\\\"+ file.getOriginalFilename();
		String outfaostat="target\\outfaostat.csv";
		String [] context=new String[] {"--context_param resource_file_faostat="+faostat, "--context_param resource_file_outfaostat="+outfaostat};
		talendJob.runJob(context);
		
		//copy data to database
		faostat talendJob2 = new faostat();
		String faostat2=outfaostat;
		String [] context2=new String[] {"--context_param resource_file_faostat2="+faostat2};
		
		talendJob2.runJob(context2);
		
	}
	
	
	 @GetMapping("/files")
	  public ResponseEntity<List<FileInfo>> getListFiles() {
	    List<FileInfo> fileInfos = filestorageService.loadAll().map(path -> {
	      String filename = path.getFileName().toString();
	      String url = MvcUriComponentsBuilder
	          .fromMethodName(FileController.class, "getFile", path.getFileName().toString()).build().toString();

	      return new FileInfo(filename, url);
	    }).collect(Collectors.toList());

	    return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	  }

	  @GetMapping("/files/{filename:.+}")
	  @ResponseBody
	  public ResponseEntity<Resource> getFile(@PathVariable String filename) {
	    Resource file = filestorageService.load(filename);
	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	  }
	  
	  
	
	
}
