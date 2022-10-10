package com.example.demo.message;


import java.util.List;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;



@JsonNaming(PropertyNamingStrategy.UpperCamelCaseStrategy.class)
@Getter
@Setter
public class CarrierInfo {

	    private String carrierName;

	    private String accountNumber;
	    
	    private Integer digits;
	    
	    private Integer lastUsedIndex;
	    
	    private Integer rangeStart;
	    
	    private Integer rangeEnd;

}
