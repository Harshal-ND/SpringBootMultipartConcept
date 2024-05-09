package com.multipartConcept.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "filedata")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		private String userFirstName;
		private String userLastName;
		private String userPhnNumber;

	private String fileName1;
	private String fileAddress1;

	private String fileName2;
	private String fileAddress2;

}
