package com.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

}
