package com.example.repoService.controller;

import com.example.repoService.entity.Programme;
import com.example.repoService.service.ProgrammeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RojakControllerTest {

    @Mock
    private ProgrammeService programmeService;
    @InjectMocks
    private RojakController underTest;


    @Test
    void retrieveProgrammeInfo() {
        String programmeName = "Cardio HIIT";
        Programme programme = new Programme();
        when(programmeService.getProgrammeInfo(programmeName)).thenReturn(
                Mono.just(programme));

        Programme result = underTest.getProgrammeInfo(programmeName).block();
        Assertions.assertNotNull(result);
    }

}