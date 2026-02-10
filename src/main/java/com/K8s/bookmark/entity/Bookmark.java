package com.K8s.bookmark.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Instant;

@Entity
@Table(name = "bookmarks")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Bookmark {

    @Id
    @SequenceGenerator(name = "bm_id_seq_gen", sequenceName = "bm_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bm_id_seq_gen")
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String url;
    private Instant createdAt;

}
