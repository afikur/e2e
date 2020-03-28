package com.afikur.e2etest.model;

import lombok.Data;

import java.util.Set;

@Data
public class Container {
    private String name;
    private Set<String> dependencies;
}
