package com.example.demo.controller;

import com.example.demo.client.GithubClient;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<?> listRepos(@RequestHeader(value = "token", required = false) String token) {
        if (token == null || token.isBlank()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("A autenticação é obrigatória para acessar este recurso. Por favor, forneça um token válido.");
        }

        var repos = githubClient.listRepos("Bearer " + token, null, "public");
        return ResponseEntity.ok(repos);
    }
}
