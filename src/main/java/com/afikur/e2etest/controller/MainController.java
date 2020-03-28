package com.afikur.e2etest.controller;

import com.afikur.e2etest.model.CliParams;
import com.afikur.e2etest.model.Container;
import com.afikur.e2etest.services.YmlParserService;
import com.beust.jcommander.JCommander;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@Log4j2
public class MainController {
    private CliParams params;
    private YmlParserService ymlParserService;

    @Autowired
    public MainController(CliParams params, YmlParserService ymlParserService) {
        this.params = params;
        this.ymlParserService = ymlParserService;
    }

    public void run(String... args) {
        JCommander.newBuilder()
                .addObject(params)
                .build()
                .parse(args);

        log.info("akhan:: " + params.getDirectory());
        Path targetAppDir = Paths.get(params.getDirectory(), params.getApplicationName());

        String mainAppYmlfileLocation;
        log.info("akhan:: " + targetAppDir.toString());
        try {
            mainAppYmlfileLocation =  findMainYmlFileName(targetAppDir.toString());
            log.info("akhan:: " + mainAppYmlfileLocation);

            Container container = ymlParserService.parse(mainAppYmlfileLocation);
            System.out.println(container.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private String findMainYmlFileName(String directory) throws FileNotFoundException {
        File dir = new File(directory);

        File[] files = dir.listFiles((dir1, name) ->
                name.startsWith("main") && (name.endsWith(".yml") || name.endsWith(".yaml")));

        if(files != null && files.length > 0) {
            return files[0].getAbsolutePath();
        } else {
            throw new FileNotFoundException("main.yaml / main.yml not found in " + directory);
        }
    }
}
