package com.afikur.e2etest.controller;

import com.afikur.e2etest.model.CliParams;
import com.beust.jcommander.JCommander;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MainController {
    private CliParams params;

    @Autowired
    public MainController(CliParams params) {
        this.params = params;
    }

    public void run(String... args) {
        JCommander.newBuilder()
                .addObject(params)
                .build()
                .parse(args);
    }
}
