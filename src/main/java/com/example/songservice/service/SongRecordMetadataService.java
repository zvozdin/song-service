package com.example.songservice.service;

import com.example.songservice.exception.SongRecordMetadataNotFoundException;
import com.example.songservice.repository.SongRecordMetadataRepository;
import com.example.songservice.repository.entity.SongRecordMetadataEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SongRecordMetadataService {

    private final SongRecordMetadataRepository repository;

    public int save(SongRecordMetadataEntity songRecordMetadata) {
        return repository.save(songRecordMetadata).getId().intValue();
    }

    public SongRecordMetadataEntity find(String id) {
        return repository.findById(Long.parseLong(id))
                .orElseThrow(() -> new SongRecordMetadataNotFoundException(id));
    }

}
