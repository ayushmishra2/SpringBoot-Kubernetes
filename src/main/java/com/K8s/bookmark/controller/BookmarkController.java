package com.K8s.bookmark.controller;

import com.K8s.bookmark.dto.BookmarkDto;
import com.K8s.bookmark.dto.BookmarksDto;
import com.K8s.bookmark.dto.CreateBookmarkRequest;
import com.K8s.bookmark.service.BookmarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

//    @GetMapping
//    public BookmarksDto getBookmarks(@RequestParam (name= "page", defaultValue = "1") Integer page) {
//        return bookmarkService.getAllBookmarks(page);
//    }

    // DTO Projection based
    @GetMapping
    public BookmarksDto getBookmarkByDTOProjection(@RequestParam (name= "page", defaultValue = "1") Integer page) {
        return bookmarkService.getBookmarkByDTOProjection(page);
    }

    // Search bookmarks by title
    @GetMapping("/search")
    public BookmarksDto searchBookmark(@RequestParam(name = "query") String query,
                                      @RequestParam(name = "page", defaultValue = "1") Integer page) {

        if(query == null || query.isEmpty()) {
            return bookmarkService.getBookmarkByDTOProjection(page);
        }
        return bookmarkService.searchBookmark(query, page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookmarkDto createBookmark(@RequestBody @Valid CreateBookmarkRequest createBookmarkRequest) {
        // Implementation for creating a bookmark
        return bookmarkService.createBookmark(createBookmarkRequest); // Placeholder return statement
    }
}
