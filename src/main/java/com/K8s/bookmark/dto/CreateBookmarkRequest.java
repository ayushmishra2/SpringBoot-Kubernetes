package com.K8s.bookmark.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBookmarkRequest {

    @NotEmpty(message = "title should not be empty")
    private String title;
    @NotEmpty(message = "url should not be empty")
    private String url;
}
