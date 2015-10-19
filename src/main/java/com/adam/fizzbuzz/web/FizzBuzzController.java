package com.adam.fizzbuzz.web;

import com.adam.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;


@Controller
@RequestMapping({"/", "/index", "/homepage"})
public class FizzBuzzController {

    private final FizzBuzzService service;

    @Autowired
    public FizzBuzzController(FizzBuzzService service) {
        this.service = service;
    }


    @RequestMapping(method = GET)
    public String home() {
        return "index";
    }

    @RequestMapping(method=POST)
    public String calculate(@RequestParam("data") String inputData, Model model) {
        List<String> fizzBuzzResult = service.solveFizzBuzz(inputData);

        model.addAttribute("fizzbuzzes", fizzBuzzResult);
        return "index";
    }

}
