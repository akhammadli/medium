package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PalindromeServiceTest {

    @Autowired
    PalindromeService palindromeService;

    @Test
    public void testInvalidValueWithNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            palindromeService.isPalindrome(null);
        });
    }

    @Test
    public void testInvalidValueLengthIsOne() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            palindromeService.isPalindrome("a");
        });
    }

    @Test
    public void testInValidValueLengthIsTwo() {
        Assertions.assertFalse(palindromeService.isPalindrome("ab"));
    }

    @Test
    public void testInValidValueLengthIsThree() {
        Assertions.assertFalse(palindromeService.isPalindrome("abc"));
    }

    @Test
    public void testValidValueLengthIsTwo() {
        Assertions.assertTrue(palindromeService.isPalindrome("aa"));
    }

    @Test
    public void testValidValueLengthIsThree() {
        Assertions.assertTrue(palindromeService.isPalindrome("aba"));
    }

    @Test
    public void testValidValueLengthIsFour() {
        Assertions.assertTrue(palindromeService.isPalindrome("boob"));
    }

}