package com.afikur.e2etest.services;

import com.afikur.e2etest.model.Container;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.introspector.Property;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.Tag;
import org.yaml.snakeyaml.representer.Representer;

import java.io.FileInputStream;
import java.io.InputStream;

@Component
public class YmlParserService {

    public Container parse(String ymlPath) {

        Representer representer = new Representer() {
            @Override
            protected NodeTuple representJavaBeanProperty(Object javaBean, Property property, Object propertyValue, Tag customTag) {
                if (propertyValue == null) {
                    return null;
                } else {
                    return super.representJavaBeanProperty(javaBean, property, propertyValue, customTag);
                }
            }
        };

        representer.getPropertyUtils().setSkipMissingProperties(true);

        Yaml yaml = new Yaml(representer);

        try {
            InputStream inputStream = new FileInputStream(ymlPath);
            return yaml.loadAs(inputStream, Container.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
