package com.K8s.bookmark.dto;

import com.K8s.bookmark.entity.Bookmark;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
public class BookmarksDto {

    private List<BookmarkDto> bookmarkList;
    private Integer totalElements;
    private Integer totalPages;
    private Integer currentPage;
    private Integer isFirstPage;
    private Integer isLastPage;
    private Boolean hasNext;
    private Boolean hasPrevious;

    public BookmarksDto(Page<BookmarkDto> bookmarkPage) {
        this.bookmarkList = bookmarkPage.getContent();
        this.totalElements = (int) bookmarkPage.getTotalElements();
        this.totalPages = bookmarkPage.getTotalPages();
        this.currentPage = bookmarkPage.getNumber() + 1; // Page number is zero-based
        this.isFirstPage = bookmarkPage.isFirst() ? 1 : 0;
        this.isLastPage = bookmarkPage.isLast() ? 1 : 0;
        this.hasNext = bookmarkPage.hasNext();
        this.hasPrevious = bookmarkPage.hasPrevious();
    }

//    public BookmarksDto(Page<BookmarkVM> bookmarkPage) {
//        this.bookmarkList = bookmarkPage.getContent();
//        this.totalElements = (int) bookmarkPage.getTotalElements();
//        this.totalPages = bookmarkPage.getTotalPages();
//        this.currentPage = bookmarkPage.getNumber() + 1; // Page number is zero-based
//        this.isFirstPage = bookmarkPage.isFirst() ? 1 : 0;
//        this.isLastPage = bookmarkPage.isLast() ? 1 : 0;
//        this.hasNext = bookmarkPage.hasNext();
//        this.hasPrevious = bookmarkPage.hasPrevious();
//    }


}
