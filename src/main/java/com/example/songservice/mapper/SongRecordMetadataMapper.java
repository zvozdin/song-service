package com.example.songservice.mapper;

import com.example.songservice.controller.entity.SongRecordMetadataRequestResponseEntity;
import com.example.songservice.repository.entity.SongRecordMetadataEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SongRecordMetadataMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "year", expression = "java(String.valueOf(request.year().getValue()))")
    SongRecordMetadataEntity toSongRecordMetadataEntity(SongRecordMetadataRequestResponseEntity request);

    @Mapping(target = "year", expression = "java(Year.parse(entity.getYear()))")
    SongRecordMetadataRequestResponseEntity toSongRecordMetadataRequestResponseEntity(SongRecordMetadataEntity entity);

}
