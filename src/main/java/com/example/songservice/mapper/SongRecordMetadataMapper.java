package com.example.songservice.mapper;

import com.example.songservice.controller.entity.SongRecordMetadataRequestEntity;
import com.example.songservice.repository.entity.SongRecordMetadataEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SongRecordMetadataMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "year", expression = "java(String.valueOf(songRecordMetadataRequest.year().getValue()))")
    SongRecordMetadataEntity toSongRecordMetadataEntity(SongRecordMetadataRequestEntity songRecordMetadataRequest);

}
