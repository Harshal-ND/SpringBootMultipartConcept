package com.multipartConcept.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.multipartConcept.entity.MultiPart;
import com.multipartConcept.repository.MultipartRepository;

@Service
public class MultipartService {

	@Autowired
	private MultipartRepository multipartRepository;

	private final String uploadDir = "/data/Spring_tool/Spring_workspace/SpringBootMultipartConcept/src/main/resources/static";

	public MultiPart saveFile(MultipartFile file) throws IllegalStateException, IOException {
		// Saving a file to a particular directory

		Path filePath = Paths.get(uploadDir + File.separator + file.getOriginalFilename());
		file.transferTo(filePath.toFile());

		// Now saving the file information to the database

		MultiPart multiPart = new MultiPart();
		multiPart.setFileName(file.getOriginalFilename());
		multiPart.setFileAddress(filePath.toString());
		return multipartRepository.save(multiPart);
	}

}
