package com.K8s.bookmark.controller;

import com.K8s.bookmark.entity.Bookmark;
import com.K8s.bookmark.repository.BookmarkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class BookmarkControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookmarkRepository bookmarkRepository;

    private List<Bookmark> bookmarks;

    @BeforeEach
    public void setup(){
        bookmarkRepository.deleteAllInBatch();
        bookmarks = new ArrayList<>();
        bookmarks.add(new Bookmark(null,"SivaLabs","https://sivalabs.in", Instant.now()));
        bookmarks.add(new Bookmark(null,"Springblog","https://springblog.in", Instant.now()));
        bookmarks.add(new Bookmark(null,"VenkatSub","https://VenkatSub.in", Instant.now()));
        bookmarks.add(new Bookmark(null,"javatechie","https://javatechie.in", Instant.now()));
        bookmarks.add(new Bookmark(null,"defogtech","https://defogtech.in", Instant.now()));
        bookmarks.add(new Bookmark(null,"springIO","https://springIO.in", Instant.now()));
        bookmarkRepository.saveAll(bookmarks);
    }
    @Test
    void shouldGetBookmarks() throws Exception {
        // Test implementation will go here
        mockMvc.perform(MockMvcRequestBuilders.get("/api/bookmarks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPages").value(3))
                .andExpect(jsonPath("$.totalElements").value(6))
                .andExpect(jsonPath("$.hasNext").value(true));
    }

    @ParameterizedTest
    @CsvSource({
            "1,3,1,6,true"
    })
    void shouldGetBookmarksParameterized(int pageNo, int totalPage, int currentPage,int totalElements, boolean hasNext) throws Exception {
        // Test implementation will go here
        mockMvc.perform(MockMvcRequestBuilders.get("/api/bookmarks?pageNo="+pageNo))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPages").value(totalPage))
                .andExpect(jsonPath("$.totalElements").value(totalElements))
                .andExpect(jsonPath("$.hasNext").value(hasNext))
                .andExpect(jsonPath("$.currentPage").value(currentPage));
    }

    @Test
    void shouldCreateBookmarkSuccessfully() throws Exception {
        // Test implementation will go here
        mockMvc.perform(post("/api/bookmarks")
                        .contentType("application/json")
                        .content("""
                {
                "title": "Test Bookmark", 
                "url": "https://testbookmark.com"
                }
                """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").value("Test Bookmark"))
                .andExpect(jsonPath("$.url").value("https://testbookmark.com"));
    }

    @Test
    void shouldFailToCreateBookmarkWithoutUrl() throws Exception {
        // Test implementation will go here
        mockMvc.perform(post("/api/bookmarks")
                        .contentType("application/json")
                        .content("""
                {
                "title": "Test Bookmark"
                }
                """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.type").value("https://zalando.github.io/problem/constraint-violation"))
                .andExpect(jsonPath("$.violations[0].field").value("url"));
    }


}