package com.example.demo.service;

import com.example.demo.dao.ValueEntity;
import com.example.demo.dao.ValueRepository;
import com.example.demo.model.CachedDatum;
import com.example.demo.model.CheckResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PalindromeService {

    @Autowired
    CacheService cacheService;

    @Autowired
    ValueRepository valueRepository;

    public CheckResult check(String value) {
        boolean isPalindrome = isPalindrome(value);
        cacheService.save(value, String.valueOf(isPalindrome));
        valueRepository.save(ValueEntity.builder().value(value).build());
        return isPalindrome ? CheckResult.PALINDROME : CheckResult.NOT_PALINDROME;
    }

    public boolean isPalindrome(String value) {
        if (StringUtils.isEmpty(value) || value.length() < 2) {
            throw new IllegalArgumentException("Minimum length for value is 2");
        } else {
            for (int i = 0; i < value.length() / 2; i++) {
                if (value.charAt(i) != value.charAt(value.length() - i - 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<CachedDatum> retreiveCacheData() {
        return cacheService.findAll();
    }

    public List<String> retrieveCheckList() {
        return valueRepository.findAll().stream().map(ValueEntity::getValue).collect(Collectors.toList());
    }
}
