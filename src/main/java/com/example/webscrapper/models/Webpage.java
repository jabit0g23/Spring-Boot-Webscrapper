package com.example.webscrapper.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "webpage")
public class Webpage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rank;
    private String domain;
    private String url;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String descripcion;
    private String imagen;

}
