package com.springSIP.controller;

import com.springSIP.pojo.Parameter;
import com.springSIP.service.SIPCalculatorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class SIPCalculatorController {

    private final SIPCalculatorService sipCalculatorService;

    public SIPCalculatorController(SIPCalculatorService sipCalculatorService) {
        this.sipCalculatorService = sipCalculatorService;
    }

    @GetMapping("/sipcalculator")
    public String showCalculatorForm(Model model) {
        model.addAttribute("parameter", new Parameter());
        return "SIPCalculator";
    }

    @PostMapping("/calculate")
    public String calculateSIP(@ModelAttribute Parameter parameter, Model model) {
        double amount = sipCalculatorService.calculateSIP(parameter.getPrincipal(), parameter.getRate(), parameter.getNoOfYears());
        model.addAttribute("amount", amount);
        return "result";
    }
}
