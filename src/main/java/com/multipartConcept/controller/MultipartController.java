package com.multipartConcept.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.multipartConcept.entity.FileData;
import com.multipartConcept.service.MultipartService;

@RestController
@RequestMapping("/files")
public class MultipartController {

	@Autowired
	private MultipartService multipartService;

	@PostMapping(value = "/upload", consumes = { 
			MediaType.APPLICATION_JSON_VALUE, 
			MediaType.MULTIPART_FORM_DATA_VALUE,
			MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity<FileData> uploadFiles(@RequestPart("data") String data,
			@RequestPart("file1") MultipartFile file1, @RequestPart("file2") MultipartFile file2)
			throws IllegalStateException, IOException {

		return ResponseEntity.ok(multipartService.saveFile(data, file1, file2));
	}

	@GetMapping("/getFiles")
	public ResponseEntity<List<FileData>> getAllFiles() throws IllegalStateException, IOException {

		return ResponseEntity.ok(multipartService.getAllFiles());
	}

}
