package org.example.controller;

import org.example.model.Teacher;
import org.example.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService teacherService;
@Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @GetMapping("/{teacherId}")
    public Teacher getTeacherById(@PathVariable Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.addTeacher(teacher);
    }

    @PutMapping("/{teacherId}")
    public Teacher updateTeacher(@PathVariable Long teacherId, @RequestBody Teacher updatedTeacher) {
        return teacherService.updateTeacher(teacherId, updatedTeacher);
    }

    @DeleteMapping("/{teacherId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable Long teacherId) {
        teacherService.deleteTeacher(teacherId);
    }
    @GetMapping
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

}
