package com.example.songservice.controller.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.Year;

public record SongRecordMetadataRequestResponseEntity(

        @NotEmpty
        String name,
        @NotEmpty
        String artist,
        @NotEmpty
        String album,
        @Pattern(regexp = "^(|[0-5])([0-9]):([0-5][0-9])$")
        @NotEmpty
        String length,
        @NotEmpty
        String resourceId,
        @PastOrPresent
        Year year) {
}
