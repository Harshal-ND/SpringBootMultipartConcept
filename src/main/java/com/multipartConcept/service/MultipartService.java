package com.multipartConcept.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.multipartConcept.entity.FileData;
import com.multipartConcept.repository.MultipartRepository;

@Service
public class MultipartService {

	@Autowired
	private MultipartRepository multipartRepository;

	private final String uploadDir = "/data/Spring_tool/Spring_workspace/SpringBootMultipartConcept/src/main/resources/static/Files";

	public FileData saveFile(String data, MultipartFile file1, MultipartFile file2)
			throws IllegalStateException, IOException {
		// Saving a file to a particular directory

		ObjectMapper objectMapper = new ObjectMapper();

		Path filePath1 = Paths.get(uploadDir + File.separator + file1.getOriginalFilename());
		file1.transferTo(filePath1.toFile());

		Path filePath2 = Paths.get(uploadDir + File.separator + file2.getOriginalFilename());
		file2.transferTo(filePath2.toFile());
		// Now saving the file information to the database

		FileData fileData = new FileData();
		fileData = objectMapper.readValue(data, FileData.class);
		fileData.setFileName1(file1.getOriginalFilename());
		fileData.setFileName2(file2.getOriginalFilename());
		fileData.setFileAddress1(filePath1.toString());
		fileData.setFileAddress2(filePath2.toString());
		return multipartRepository.save(fileData);
	}

	public List<FileData> getAllFiles() {
		return multipartRepository.findAll();
	}

}
