package com.afikur.e2etest.services;

import com.afikur.e2etest.model.CliParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepositoryService {
    private GitService gitService;
    private CliParams params;

    @Autowired
    public RepositoryService(GitService gitService, CliParams params) {
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
