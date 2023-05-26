package com.example.UsingHibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UsingHibernate.model.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

}
