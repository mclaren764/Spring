package com.artemlunkov.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class MyController1 {

    @RequestMapping("/")
    public String showFirstView(){
        return "first_view";
    }

    @RequestMapping("/askDetails")
    public String askEmployeeDetails(Model model){

//        Employee emp = new Employee();
//        emp.setName("Artem");
//        emp.setSurname("Lunkov");
//        emp.setSalary(500);
        model.addAttribute("employee", new Employee());
        return "ask_emp_details_view";
    }

    @RequestMapping("/showDetails")
    public String showEmployeeDetails(@Valid @ModelAttribute("employee") Employee emp,
                                      BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "ask_emp_details_view";
        }
        else{
            return "show_emp_details_view";
        }
    }
}
