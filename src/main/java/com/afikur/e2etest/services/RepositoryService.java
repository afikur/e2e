package com.afikur.e2etest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService {
    private GitService gitService;
    private CliParamService params;

    @Autowired
    public RepositoryService(GitService gitService, CliParamService params) {
        this.gitService = gitService;
        this.params = params;
    }

    public void getRepository() {
        gitService.cloneRepository(params.getRepository(),
                params.getUsername(),
                params.getPassword(),
                params.getDirectory());
    }
}
