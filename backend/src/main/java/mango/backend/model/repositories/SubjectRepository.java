package mango.backend.model.repositories;

import org.springframework.data.repository.CrudRepository;

import mango.backend.model.tables.Subject;

public interface SubjectRepository extends CrudRepository<Subject, Integer>{
    
}