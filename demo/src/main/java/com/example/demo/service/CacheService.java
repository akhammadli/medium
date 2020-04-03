package com.example.demo.service;

import com.example.demo.model.CachedDatum;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CacheService {

    private final String CACHE_HOST = "redis-server";
    private final Jedis JEDIS = new Jedis(CACHE_HOST);

    protected void save(String key, String value) {
        JEDIS.set(key, value);
    }

    protected List<CachedDatum> findAll() {
        List<CachedDatum> cachedData = new ArrayList<>();
        Set keys = JEDIS.keys("*");
        for (Object key : keys) {
            cachedData.add(new CachedDatum(key.toString(), JEDIS.get(key.toString())));
        }
        return cachedData;
    }
}
