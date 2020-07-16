package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@Controller
public class HomeController {
    public ArrayList<Employee> allEmployees = new ArrayList<>();

    @RequestMapping("/home")
    public String index(){
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("message", "New Employee");
        return "addEmployee";
    }

    @PostMapping("/listAll")
    public String listAll(@ModelAttribute Employee employee, Model model){

        allEmployees.add(employee);
        return "redirect:/showAll";
    }


    @RequestMapping("/showAll")
    public String showAll(Model model){

        model.addAttribute("employees", allEmployees);
        return "listAll";
    }

    @RequestMapping("/update/{id}")
    public String updateList(@PathVariable("id") long id, Model model){

        Employee employee = new Employee();
        for (Employee one : allEmployees) {
            if (one.getId() == id){
                employee = one;
                allEmployees.remove(one);
                break;
            }
        }

        model.addAttribute("employee", employee);
        model.addAttribute("message", "Update Employee");
        return "addEmployee";
    }

    @RequestMapping("/delete/{id}")
    public String deleteList(@PathVariable("id") long id, Model model){

        for (Employee employee : allEmployees) {
            if (employee.getId() == id){
                allEmployees.remove(employee);
                break;
            }
        }

        return "redirect:/showAll";
    }


}
