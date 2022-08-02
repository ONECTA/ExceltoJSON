package com.xlsx.read.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;


@Controller
public class ConvertAPI {
	
	@Value("${app.pathtoexcel}")
	private String pathtoexcel;
	
	@RequestMapping(value = "/parseExcel", method = RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	String auth(@RequestParam Map<String,String> allParams) {
		System.out.println("Parameters are " + allParams.entrySet());
		allParams.forEach((k,v) -> System.out.println("Key = " + k + ", Value = " + v));
		String FILE_NAME = pathtoexcel;
		FileInputStream excelFile;
		try {
			excelFile = new FileInputStream(FILE_NAME);
			// System.out.println(excel.getExcelDataAsJsonObject(excelFile));
			    return excel.getExcelDataAsJsonObject(excelFile).toString();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			 JsonObject jsonObject = new JsonObject();
			 jsonObject.addProperty("ERROR", e.getMessage());
			 return jsonObject.toString();
		}
		
	}
	
}
