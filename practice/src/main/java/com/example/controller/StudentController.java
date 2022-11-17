package com.example.controller;

import com.example.dto.StudentDto;
import com.example.model.Academic;
import com.example.model.Student;
import com.example.model.classRoom;
import com.example.service.IAcademicService;
import com.example.service.IClassService;
import com.example.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassService classService;


    @Autowired
    private IAcademicService academicService;

    @GetMapping("")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable, Model model) {
        Page<Student> students = studentService.findAll(pageable);
        List<Academic> academics = academicService.findAll();
        List<classRoom> classes = classService.findAll();
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("students", students);
        modelAndView.addObject("academics", academics);
        modelAndView.addObject("classes", classes);
        return modelAndView;
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("studentDto", new StudentDto());
        List<Academic> academics = academicService.findAll();
        List<classRoom> classes = classService.findAll();
        model.addAttribute("academics", academics);
        model.addAttribute("classes", classes);
        return "/create";
    }

    @PostMapping("/create")
    public String addStudent(@ModelAttribute("studentEmptyDto") StudentDto studentDto, Model model, RedirectAttributes redirect) {
        Student student = new Student();
        List<Academic> academics = academicService.findAll();
        List<classRoom> classes = classService.findAll();
        model.addAttribute("academics", academics);
        model.addAttribute("classes", classes);
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return "redirect:/student";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id,
                       @ModelAttribute("studentDto") StudentDto studentDto
            , Model model) {
        Student student = studentService.findById(id);
        List<Academic> academics = academicService.findAll();
        List<classRoom> classes = classService.findAll();
        if (student != null) {
            model.addAttribute("student", student);
            model.addAttribute("academics", academics);
            model.addAttribute("classes", classes);
            return "/edit";
        } else {
            return "/error.404";
        }

    }

    @PostMapping("/edit")
    public String editStudent(@ModelAttribute StudentDto studentDto) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        studentService.save(student);
        return "redirect:/student";
    }

}
