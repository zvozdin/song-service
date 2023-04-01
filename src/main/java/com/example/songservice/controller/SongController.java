package com.example.songservice.controller;

import com.example.songservice.controller.entity.SavedSongRecordMetadataEntityResponse;
import com.example.songservice.controller.entity.SongRecordMetadataRequestEntity;
import com.example.songservice.mapper.SongRecordMetadataMapper;
import com.example.songservice.service.SongRecordMetadataService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/v1/songs")
@RestController
public class SongController {

    private final SongRecordMetadataService songRecordMetadataService;
    private final SongRecordMetadataMapper mapper;

    @PostMapping(produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<SavedSongRecordMetadataEntityResponse> storeResource(
            @Valid @RequestBody SongRecordMetadataRequestEntity request) {
        return new HttpEntity<>(
                new SavedSongRecordMetadataEntityResponse(
                        songRecordMetadataService.save(mapper.toSongRecordMetadataEntity(request))));
    }

}
