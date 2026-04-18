package com.example.repoService.service;

import com.example.repoService.entity.Programme;
import reactor.core.publisher.Mono;

public interface ProgrammeService {

    Mono<Programme> getProgrammeInfo(String name);
}
