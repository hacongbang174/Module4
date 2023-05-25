package com.codegym.bank_transaction.controller;

import com.codegym.bank_transaction.model.Customer;
import com.codegym.bank_transaction.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class CustomerController {

    @Autowired
    private ICustomerService customerService;
    @GetMapping("/customers")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }
    @GetMapping("/customers/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("/customers/create");
        Customer newCustomer = new Customer();
        modelAndView.addObject("newCustomer", newCustomer);
        return modelAndView;
    }
    @PostMapping("/customers/create")
    public ModelAndView createCustomer(@Validated @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/customers/create");
        String name = customer.getFull_name();
        String phone = customer.getPhone();
        String email = customer.getEmail();
        String address = customer.getAddress();

        if (!bindingResult.hasErrors()) {
            if (customerService.addNewCustomer(name, email, phone, address)) {
                modelAndView.addObject("success", "Successful operation!");
            } else {
                modelAndView.addObject("failure", "Failed operation!");
            }
        }
        modelAndView.addObject("newCustomer", new Customer());
        return modelAndView;
    }
}
