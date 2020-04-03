package com.example.demo.controller;

import com.example.demo.model.CachedDatum;
import com.example.demo.model.CheckResult;
import com.example.demo.service.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/palindrome")
@CrossOrigin(origins = {"*"})
public class PalindromeController {

    @Autowired
    PalindromeService palindromeService;

    @GetMapping("/check/{value}")
    public CheckResult check(@PathVariable(value = "value") String value) {
        return palindromeService.check(value);
    }

    @GetMapping("/cache/list")
    public List<CachedDatum> getCacheList() {
        return palindromeService.retreiveCacheData();
    }

    @GetMapping("/check-list")
    public List<String> getCheckList() {
        return palindromeService.retrieveCheckList();
    }

}
