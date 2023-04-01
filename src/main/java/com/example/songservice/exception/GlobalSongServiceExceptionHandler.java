package com.example.songservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalSongServiceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleConstraintViolationException(MethodArgumentNotValidException e) {
        log.error(e.getFieldErrors().toString());

        return ResponseEntity.badRequest().body("Song metadata missing validation error");
    }

    @ExceptionHandler(SongRecordMetadataNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleSongRecordMetadataNotFoundException(SongRecordMetadataNotFoundException e) {
        log.error("SongRecordMetadata not found by id '{}'", e.getMessage());

        return new ResponseEntity<>(
                String.format("The song metadata with the specified id '%s' does not exist", e.getMessage()),
                HttpStatus.NOT_FOUND);
    }

}
