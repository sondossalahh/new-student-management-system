package org.example.controller;

import org.example.model.Course;
import org.example.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    @GetMapping("/{courseId}")
    public Optional<Course> getCourseById(@PathVariable Long courseId) {
        return courseService.getCourseById(courseId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/{courseId}")
    public Course updateCourse(@PathVariable Long courseId, @RequestBody Course updatedCourse) {
         return courseService.updateCourse(courseId, updatedCourse);
    }

    @DeleteMapping("/{courseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Long courseId) {
        courseService.delete(courseId);
    }
}