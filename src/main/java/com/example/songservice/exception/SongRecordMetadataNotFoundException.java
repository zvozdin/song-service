package com.example.songservice.exception;

public class SongRecordMetadataNotFoundException extends RuntimeException {

    public SongRecordMetadataNotFoundException(String id) {
        super(id);
    }

}
