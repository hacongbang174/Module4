package com.codegym.convert_money.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ConvertMoneyController {
    @GetMapping("/convert")
    public String show() {
        return "index";
    }
    @PostMapping("/convert")
    public String convert(@RequestParam Integer usd, Model model) {
        Integer vnd = usd * 23000;
        model.addAttribute("vnd", vnd);
        return "index";
    }
}
