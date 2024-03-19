package com.example.songservice.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "song_record_metadata")
public class SongRecordMetadataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;
    private String artist;
    private String album;
    private String length;
    private String resourceId;
    private String year;
    private String genre;

    public SongRecordMetadataEntity() {

    }

}
