package edu.example.training.repository;

import edu.example.training.entity.StudentType;

public interface StudentTypeRepository {
    StudentType  selectByCode(String studentTypeCode);
}
