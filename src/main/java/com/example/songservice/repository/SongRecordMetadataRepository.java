package com.example.songservice.repository;

import com.example.songservice.repository.entity.SongRecordMetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongRecordMetadataRepository extends JpaRepository<SongRecordMetadataEntity, Long> {
}
