package mango.backend.model.repositories;

import org.springframework.data.repository.CrudRepository;

import mango.backend.model.tables.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>{
    
}
