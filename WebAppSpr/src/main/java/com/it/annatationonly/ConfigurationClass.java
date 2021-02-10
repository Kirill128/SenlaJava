package com.it.annatationonly;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.it.annatationonly")
@PropertySource("musicPlayer.properties")
public class ConfigurationClass {

}
