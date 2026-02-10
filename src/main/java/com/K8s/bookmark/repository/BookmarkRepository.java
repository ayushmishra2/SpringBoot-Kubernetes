package com.K8s.bookmark.repository;

import com.K8s.bookmark.dto.BookmarkDto;
import com.K8s.bookmark.dto.BookmarkVM;
import com.K8s.bookmark.entity.Bookmark;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {

    @Query("select new com.K8s.bookmark.dto.BookmarkDto(b.id, b.title, b.url) from Bookmark b")
    Page<BookmarkDto> findBookmarks(Pageable pageable);

    @Query("select new com.K8s.bookmark.dto.BookmarkDto(b.id, b.title, b.url) from Bookmark b where lower(b.title) like lower(concat('%', :title, '%'))")
    Page<BookmarkDto> searchBookmark(String title, Pageable pageable);

    Page<BookmarkVM> findByTitleContainsIgnoreCase(String title, Pageable pageable);
}
