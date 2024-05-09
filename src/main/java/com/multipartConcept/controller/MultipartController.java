package com.multipartConcept.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.multipartConcept.entity.MultiPart;
import com.multipartConcept.service.MultipartService;

@RestController
@RequestMapping("/files")
public class MultipartController {

	@Autowired
	private MultipartService multipartService;

	@PostMapping("/upload")
	public ResponseEntity<MultiPart> uploadFiles(@RequestBody MultipartFile file)
			throws IllegalStateException, IOException {

		return ResponseEntity.ok(multipartService.saveFile(file));
	}

	@GetMapping("/getFiles")
	public ResponseEntity<List<MultiPart>> getAllFiles() throws IllegalStateException, IOException {

		return ResponseEntity.ok(multipartService.getAllFiles());
	}

}
