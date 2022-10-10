package com.example.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.message.CarrierInfo;

import lombok.extern.log4j.Log4j2;

@RestController()
@RequestMapping("/gtw")
@Log4j2
public class CarrierNoteController {
	
	 @PostMapping("/carriernote")
	    public ResponseEntity<Object> ProcessNote(@RequestBody CarrierInfo a)
	    {
		 int lastUsedIndex = a.getLastUsedIndex() + 1;
         int checkSum3;
         int checkSum;
         int checkSum7;
         int check =0 ;
         int checkSum37;
         int nextMultiple;
         String containerNote = null;
         
         try
	        {
			 log.info(" Message " + a.getAccountNumber());
			  if ( lastUsedIndex >= a.getRangeStart() && lastUsedIndex <= a.getRangeEnd()){
		            
	            	 String formatted = String.format("%"+a.getDigits()+"d", lastUsedIndex).replace(' ', '0');
	            	 for (int i = formatted.length()-1; i >= 0; i =i-2) 
	            	 {
	         			char ch = formatted.charAt(i);
	         			int n = Integer.parseInt(Character.toString(ch));
	         			check += n;
	         		 }
	         		 checkSum3 = check*3;
	         		 check =0; 
					 for (int i = formatted.length()-2; i >= 0; i =i-2) 
					 {
					    char ch = formatted.charAt(i);
						int n = Integer.parseInt(Character.toString(ch)); 
						check += n; 
					 }
						 
         		    checkSum7 = check*7;
         		    checkSum37 = checkSum3 + checkSum7;
	      		    nextMultiple = checkSum37 + (10 - checkSum37 % 10);   
	                checkSum = nextMultiple - checkSum37;
	                containerNote = "FMCC"+a.getAccountNumber() +  formatted + checkSum;
	                log.info(" containerNote " + containerNote); 
	            } 
	        }
		 catch (Exception e)
	        {
	            log.error("Could not process HOST Message",e);
	        }
		 return new ResponseEntity<>("Message Processed. containerNote: " +containerNote, HttpStatus.OK);
	    }
}
