package com.afikur.e2etest.services;

import com.afikur.e2etest.model.Container;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;

@Component
public class YmlParserService {

    public Container parse(String ymlPath) {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream(ymlPath);
        return (Container) yaml.load(inputStream);
    }
}
