package com.afikur.e2etest;

import com.afikur.e2etest.controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class E2eApplication implements  CommandLineRunner {
    private MainController mainController;

    @Autowired
    public E2eApplication(MainController mainController) {
        this.mainController = mainController;
    }

    public static void main(String[] args) {
        SpringApplication.run(E2eApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        mainController.run(args);
    }
}
