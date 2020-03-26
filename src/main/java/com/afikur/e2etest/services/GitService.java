package com.afikur.e2etest.services;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class GitService {

    public Boolean cloneRepository(String repoUrl, String username, String password, String localDir) {
        try {
            Git.cloneRepository()
                    .setURI(repoUrl)
                    .setCredentialsProvider(
                            new UsernamePasswordCredentialsProvider(username, password)
                    )
                    .setDirectory(new File(localDir))
                    .call();
        } catch (GitAPIException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
