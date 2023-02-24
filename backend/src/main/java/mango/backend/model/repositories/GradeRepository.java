package mango.backend.model.repositories;

import org.springframework.data.repository.CrudRepository;

import mango.backend.model.tables.Grade;

public interface GradeRepository extends CrudRepository<Grade, Integer>{
    
}