package com.afikur.e2etest;

import com.afikur.e2etest.services.CliParamService;
import com.beust.jcommander.JCommander;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class E2eTestApplication implements CommandLineRunner {
    private CliParamService params;

    @Autowired
    public E2eTestApplication(CliParamService params) {
        this.params = params;
    }

    public static void main(String[] args) {
        SpringApplication.run(E2eTestApplication.class, args);
    }


    @Override
    public void run(String... args) {
        JCommander.newBuilder()
                .addObject(params)
                .build()
                .parse(args);
    }
}
