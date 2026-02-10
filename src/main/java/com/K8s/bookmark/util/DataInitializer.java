package com.K8s.bookmark.util;

import com.K8s.bookmark.entity.Bookmark;
import com.K8s.bookmark.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(String... args) throws Exception {
        // Data initialization logic can be added here
//        bookmarkRepository.save(new Bookmark(null,"SivaLabs","https://sivalabs.in", Instant.now()));
//        bookmarkRepository.save(new Bookmark(null,"Springblog","https://springblog.in", Instant.now()));
//        bookmarkRepository.save(new Bookmark(null,"VenkatSub","https://VenkatSub.in", Instant.now()));
//        bookmarkRepository.save(new Bookmark(null,"javatechie","https://javatechie.in", Instant.now()));
//        bookmarkRepository.save(new Bookmark(null,"defogtech","https://defogtech.in", Instant.now()));
//        bookmarkRepository.save(new Bookmark(null,"springIO","https://springIO.in", Instant.now()));
    }
}
