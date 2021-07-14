package com.project.catcaring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CatCaringApplication {

  public static void main(String[] args) {
    SpringApplication.run(CatCaringApplication.class, args);
  }

}
