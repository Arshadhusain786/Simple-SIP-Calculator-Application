package com.springSIP.service;

import org.springframework.stereotype.Service;

@Service
public class SIPCalculatorService {

    public double calculateSIP(double principal, double rate, int noOfYears) {
        double rateOfInterest = rate / 100 / 12;
        int totalMonths = noOfYears * 12;
        double futureValue = principal * (Math.pow(1 + rateOfInterest, totalMonths));
        return futureValue;
    }
}

