package com.example.songservice.controller;

import com.example.songservice.controller.entity.DeletedSongRecordMetadataIdsResponse;
import com.example.songservice.controller.entity.SavedSongRecordMetadataEntityResponse;
import com.example.songservice.controller.entity.SongRecordMetadataRequestResponseEntity;
import com.example.songservice.util.ValidList;
import com.example.songservice.mapper.SongRecordMetadataMapper;
import com.example.songservice.service.SongRecordMetadataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/songs")
@RestController
public class SongController {

    private final SongRecordMetadataService songRecordMetadataService;
    private final SongRecordMetadataMapper mapper;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<SongRecordMetadataRequestResponseEntity> getSongRecordMetadata(@PathVariable String id) {

        log.info("Incoming request to get song metadata by id {}", id);

        return new HttpEntity<>(
                mapper.toSongRecordMetadataRequestResponseEntity(
                        songRecordMetadataService.find(id)));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<SavedSongRecordMetadataEntityResponse> saveSongRecordMetadata(
            @Valid @RequestBody SongRecordMetadataRequestResponseEntity request) {

        log.info("Incoming request to save song metadata for resourceId {}", request.resourceId());

        return new HttpEntity<>(
                new SavedSongRecordMetadataEntityResponse(
                        songRecordMetadataService.save(mapper.toSongRecordMetadataEntity(request))));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public HttpEntity<DeletedSongRecordMetadataIdsResponse> deleteResource(
            @ValidList @RequestParam("id") List<String> ids) {

        songRecordMetadataService.delete(ids);
        return new HttpEntity<>(new DeletedSongRecordMetadataIdsResponse(ids));
    }

}
