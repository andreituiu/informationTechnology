package com.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Course;

public class CourseMapper {

    private TeacherMapper teacherMapper;

    
    
    public CourseMapper(TeacherMapper teacherMapper) {
        super();
        this.teacherMapper = teacherMapper;
    }



    public List<Course> getList(ResultSet resultSet) {
        List<Course> courses = new ArrayList<>();
        try {
            while(resultSet.next()) {
                Course course = new Course();
                course.setName(resultSet.getString("course_name"));
                course.setSpecialization(resultSet.getString("specialization"));
                course.setTeacher(teacherMapper.getTeacher(resultSet));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return courses;
    }

}
