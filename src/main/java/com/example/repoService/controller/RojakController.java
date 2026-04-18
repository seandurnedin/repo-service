package com.example.repoService.controller;

import com.example.repoService.entity.Programme;
import com.example.repoService.service.ProgrammeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/repo")
public class RojakController {

    public final ProgrammeService programmeService;

    @GetMapping("/programme/get-info")
    public Mono<Programme> getProgrammeInfo(String programmeName) {
        return programmeService.getProgrammeInfo(programmeName);
    }

}
