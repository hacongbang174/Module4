package com.cg.controller;

import com.cg.model.Transfer;
import com.cg.model.dto.CustomerDTO;
import com.cg.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ModelAndView showCustomerList() {
        ModelAndView modelAndView = new ModelAndView("/customers/list");
        List<CustomerDTO> customerList = customerService.findAllDTO();
        modelAndView.addObject("customerList", customerList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/customers/create");
        CustomerDTO newCustomerDTO = new CustomerDTO();
        modelAndView.addObject("customerDTO", newCustomerDTO);
        return modelAndView;
    }
    @PostMapping("/create")
    public ModelAndView createCustomerForm(@Validated @ModelAttribute("customerDTO") CustomerDTO customerDTO, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView("/customers/create");

        String name = customerDTO.getFullName().trim();
        String phone = customerDTO.getPhone().trim();
        String email = customerDTO.getEmail().trim().toLowerCase();
        String address = customerDTO.getAddress().trim();

        if (customerService.existsByPhone(phone)) {
            bindingResult.addError(new ObjectError("phoneExists", "Phone number has existed!"));
        }

        if (customerService.existsByEmail(email)) {
            bindingResult.addError(new ObjectError("emailExists", "Email address has existed!"));
        }

        if (!bindingResult.hasErrors()) {
            if (customerService.addNewCustomer(name, email, phone, address)) {
                modelAndView.addObject("success", "Successful operation!");
            } else {
                modelAndView.addObject("failure", "Failed operation!");
            }
            modelAndView.addObject("customerDTO", new CustomerDTO());
        } else {
            modelAndView.addObject("hasError", true);
        }

        return modelAndView;
    }
}
