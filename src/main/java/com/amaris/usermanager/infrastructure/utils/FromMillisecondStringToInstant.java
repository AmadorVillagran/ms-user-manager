package com.amaris.usermanager.infrastructure.utils;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component public class FromMillisecondStringToInstant {

    public Instant execute(String dateMillSec){
        return Instant.ofEpochMilli(Long.parseLong(dateMillSec));
    }
}
