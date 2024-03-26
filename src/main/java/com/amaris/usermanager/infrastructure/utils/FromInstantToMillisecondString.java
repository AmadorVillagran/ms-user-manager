package com.amaris.usermanager.infrastructure.utils;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component public class FromInstantToMillisecondString {

    public String execute(Instant instant){
        if(instant!=null){
            return String.valueOf(instant.toEpochMilli());
        }else{
            return null;
        }
    }
}
