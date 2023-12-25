package org.example.service;

import org.example.model.Course;
import org.example.repository.CourseRepository;
import org.example.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {
    CourseRepository courseRepository;

    public CourseService() {
    }
    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository=courseRepository;
    }
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    public List<Course> getCourseByName(String name){
        return courseRepository.findByName(name);
    }
    public Optional<Course> getCourseById(Long id){
        return courseRepository.findById(id);
    }

    public Course updateCourse(Long courseId, Course updatedCourse){
        Optional<Course> existingCourseOptional = getCourseById(courseId);
        if (existingCourseOptional.isPresent()) {
            Course existingCourse = existingCourseOptional.get();
            existingCourse.setCourseName(updatedCourse.getCourseName());
            existingCourse.setTeacher(updatedCourse.getTeacher());

            return courseRepository.save(existingCourse);
        } else {
            throw new ResourceNotFoundException("Course not found with ID: " + courseId);
        }
    }
    public Course addCourse(Course course){
        return courseRepository.save(course);
    }
    public void delete(Long id){
        courseRepository.deleteById(id);
    }
}
