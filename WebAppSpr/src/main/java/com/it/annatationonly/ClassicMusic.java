package com.it.annatationonly;

import org.springframework.stereotype.Component;

@Component
public class ClassicMusic implements Music{
    @Override
    public String getMusic() {
        return "ClassicMusic";
    }
}
