package com.example.demo.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.message.CarrierInfo;

@FeignClient(name = "SorterCore", url = "localhost:9901")
public interface HostFeignClient {

	  @RequestMapping(method = RequestMethod.POST, value = "/gtw/carriernote", consumes = "application/json")
	  public ResponseEntity<String> processMessageCarrierNote(@RequestBody CarrierInfo a); 
}
