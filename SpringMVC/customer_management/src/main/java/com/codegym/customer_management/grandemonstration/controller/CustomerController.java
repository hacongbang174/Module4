package com.codegym.customer_management.grandemonstration.controller;

import com.codegym.customer_management.grandemonstration.model.Customer;
import com.codegym.customer_management.grandemonstration.service.CustomerService;
import com.codegym.customer_management.grandemonstration.service.impl.SimpleCustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping ("/info")
    public ModelAndView showInfo(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
    @PostMapping("/customers")
    public ModelAndView update(@RequestParam Long id, @RequestParam String name, @RequestParam String email, @RequestParam String address, Model model) {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        for (Customer customer : customers) {
            if(customer.getId() == id) {
                customer = customerService.save(new Customer(customer.getId(), name, email, address));
            }
        }
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
}
