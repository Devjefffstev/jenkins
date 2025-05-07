package com.jeff.parallelTestExecutor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {
    
    // Example URL: http://localhost:8080/add?num1=10&num2=20
    @GetMapping("/add")
    public double add(@RequestParam double num1, @RequestParam double num2) {
        return num1 + num2;
    }

    // Example URL: http://localhost:8080/subtract?num1=15&num2=5
    @GetMapping("/subtract")
    public double subtract(@RequestParam double num1, @RequestParam double num2) {
        return num1 - num2;
    }

    // Example URL: http://localhost:8080/multiply?num1=4&num2=5
    @GetMapping("/multiply")
    public double multiply(@RequestParam double num1, @RequestParam double num2) {
        return num1 * num2;
    }

    // Example URL: http://localhost:8080/divide?num1=20&num2=4
    @GetMapping("/divide")
    public double divide(@RequestParam double num1, @RequestParam double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return num1 / num2;
    }
}