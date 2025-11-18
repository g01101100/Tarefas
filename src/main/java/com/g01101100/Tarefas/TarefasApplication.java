package com.g01101100.Tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TarefasApplication {

    @RequestMapping("/")
    String home(){
        return "Hello mtfk!";
    }

	public static void main(String[] args) {

        SpringApplication.run(TarefasApplication.class, args);

	}

}
