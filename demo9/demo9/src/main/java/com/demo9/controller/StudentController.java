package com.demo9.controller;

import com.demo9.model.Student;
import com.demo9.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping
public class StudentController {
    @Autowired
    private IStudentService studentService;



    @GetMapping("/index")
    public String indexPage(Model model) {

        return "/ep/index";
    }


    @GetMapping("/list")
    public String listPage(Model model) {

        List<Student> students = studentService.findAll();

        model.addAttribute("students", students);

        return "/ep/list";
    }


    @GetMapping("/edit/{studentId}")
    public String editPage(Model model, @PathVariable Long studentId) {
        Optional<Student> studentOptional = studentService.findOne(studentId);
        model.addAttribute("student", studentOptional.get());
        return "/ep/edit";
    }


//    @PostMapping("/edit/{studentId}")
//    public String editPage(Model model, @PathVariable Long studentId, @ModelAttribute Student student) {
//
//        student.setId(studentId);
//        studentService.save(student);
//        model.addAttribute("student", student);
//        return "redirect:/list";
//    }


    @PostMapping("/edit/{studentId}")
    public String editPage(Model model, @PathVariable Long studentId, @Validated @ModelAttribute Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/ep/edit";
        }

        student.setId(studentId);
        studentService.save(student);
        model.addAttribute("student", student);
        return "redirect:/list";
    }



    @GetMapping("/delete/{studentId}")
    public String deletePage(Model model, @PathVariable Long studentId) {
        Optional<Student> employOptional = studentService.findOne(studentId);
        model.addAttribute("student", employOptional.get());
        return "/ep/delete";
    }

    @PostMapping("/delete/{studentId}")
    public String deletePage(Model model, @PathVariable Long studentId, @ModelAttribute Student student) {
        student.setId(studentId);
        studentService.delete(student);
        model.addAttribute("student", student);
        return "redirect:/list";
    }

    @GetMapping("/create")
    public String createPage(Model model) {

        model.addAttribute("student", new Student());

        return "/ep/create";
    }

    @PostMapping("/create")
    public String create(Model model, @ModelAttribute Student student) {
        studentService.save(student);
        return "redirect:/list";
    }

}
