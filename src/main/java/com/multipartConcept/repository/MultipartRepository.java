package com.multipartConcept.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multipartConcept.entity.MultiPart;

@Repository
public interface MultipartRepository extends JpaRepository<MultiPart, Integer> {

}
