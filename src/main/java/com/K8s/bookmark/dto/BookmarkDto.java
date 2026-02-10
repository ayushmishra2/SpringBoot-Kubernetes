package com.K8s.bookmark.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Data
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class BookmarkDto {

    private Long id;
    private String title;
    private String url;
    private Instant createdAt;

    public BookmarkDto(Long id, String title, String url) {
        this.id = id;
        this.title = title;
        this.url = url;
    }
}
