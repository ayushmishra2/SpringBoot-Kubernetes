package com.K8s.bookmark.service;

import com.K8s.bookmark.dto.BookmarkDto;
import com.K8s.bookmark.dto.BookmarkVM;
import com.K8s.bookmark.dto.BookmarksDto;
import com.K8s.bookmark.dto.CreateBookmarkRequest;
import com.K8s.bookmark.entity.Bookmark;
import com.K8s.bookmark.repository.BookmarkRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

//    @Transactional(readOnly = true)
//    public BookmarksDto getAllBookmarks(Integer page) {
//        int pageNo = page < 1 ? 0 : page -1;
//        Pageable pageable = (Pageable) PageRequest.of(pageNo,2,Sort.Direction.ASC, "createdAt");
//        return  new BookmarksDto(bookmarkRepository.findAll(pageable));
//    }

    @Transactional(readOnly = true)
    public BookmarksDto getBookmarkByDTOProjection(Integer page) {

        int pageNo = page < 1 ? 0 : page -1;
        Pageable pageable = (Pageable) PageRequest.of(pageNo,2,Sort.Direction.ASC, "createdAt");
        Page<BookmarkDto> bookmarkPage = bookmarkRepository.findBookmarks(pageable);
        return new BookmarksDto(bookmarkPage);
    }

    @Transactional(readOnly = true)
    public BookmarksDto searchBookmark(String title, Integer page){

        int pageNo = page < 1 ? 0 : page -1;
        Pageable pageable = PageRequest.of(pageNo, 2, Sort.Direction.ASC, "createdAt");
        Page<BookmarkDto> bookmarkDtos = bookmarkRepository.searchBookmark(title, pageable);
        //Page<BookmarkVM> bookmarkVMDtos = bookmarkRepository.findByTitleContainsIgnoreCase(title, pageable);
        return new BookmarksDto(bookmarkDtos);
    }

    public BookmarkDto createBookmark(@Valid CreateBookmarkRequest createBookmarkRequest) {

        Bookmark bookmark = new Bookmark(null, createBookmarkRequest.getTitle(),createBookmarkRequest.getUrl(), Instant.now());
        Bookmark savedBookmark = bookmarkRepository.save(bookmark);
        return BookmarkDto.builder().id(savedBookmark.getId())
                .title(savedBookmark.getTitle())
                .url(savedBookmark.getUrl())
                .createdAt(savedBookmark.getCreatedAt())
                .build();
    }
}
