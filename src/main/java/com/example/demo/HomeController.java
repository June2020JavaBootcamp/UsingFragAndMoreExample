package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
public class HomeController {
    public ArrayList<Employee> allEmployees = new ArrayList<>();

    @GetMapping("/add")
    public String index(Model model) {
        model.addAttribute("employee", new Employee());
        return "addEmployee";
    }

    @PostMapping("/listAll")
    public String listAll(@ModelAttribute Employee employee, Model model){
        allEmployees.add(employee);
        model.addAttribute("employees", allEmployees);
        return "listAll";
    }

}
