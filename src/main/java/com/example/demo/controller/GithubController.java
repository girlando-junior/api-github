package com.example.demo.controller;

import com.example.demo.client.GithubClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.RepositoryResponse;

import java.util.List;

@RestController
@RequestMapping("/github")
public class GithubController {

    private final GithubClient githubClient;

    public GithubController(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @GetMapping("/repositories")
    public ResponseEntity<List<RepositoryResponse>> listRepos(@RequestHeader("token") String token) {

        var repos = githubClient.listRepos("Bearer " + token, null, "public");

        return ResponseEntity.ok(repos);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
