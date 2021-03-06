package com.afikur.e2etest.model;

import com.beust.jcommander.Parameter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class CliParams {
    @Parameter(names={"--user", "-u"})
    @Value("${git.username}")
    private String username;

    @Parameter(names = {"--password", "-p"})
    @Value("${git.password}")
    private String password;

    @Parameter(names={"--repository", "--repo", "-r"})
    @Value("${git.repository}")
    private String repository;

    @Parameter(names={"--directory", "-d"})
    @Value("${git.directory}")
    private String directory;

    @Parameter(names={"--applicationName", "--application", "-app"})
    @Value("${application.name}")
    private String applicationName;
}
