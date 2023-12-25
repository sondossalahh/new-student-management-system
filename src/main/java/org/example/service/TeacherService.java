package org.example.service;

import org.example.model.Teacher;
import org.example.repository.TeacherRepository;
import org.example.util.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Service
@Transactional
public class TeacherService {
    TeacherRepository teacherRepository;
    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
    public List<Teacher> getTeachersByName(String name){
        return teacherRepository.findByName(name);
    }
    public Teacher getTeacherById(Long teacherId) {
        Optional<Teacher> optionalTeacher = teacherRepository.findById(teacherId);
        return optionalTeacher.orElseThrow(() -> new ResourceNotFoundException("Teacher not found with ID: " + teacherId));
    }
    public Teacher addTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }
    public Teacher updateTeacher(Long teacherId, Teacher updatedTeacher){
        Teacher existingTeacher = getTeacherById(teacherId);
        existingTeacher.setName(updatedTeacher.getName());
        return teacherRepository.save(existingTeacher);
    }
    public void deleteTeacher(Long id){
        teacherRepository.deleteById(id);
    }
}
