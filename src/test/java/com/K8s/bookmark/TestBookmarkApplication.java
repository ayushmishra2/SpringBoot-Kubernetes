package com.K8s.bookmark;

import org.springframework.boot.SpringApplication;

public class TestBookmarkApplication {

	public static void main(String[] args) {
		SpringApplication.from(BookmarkApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
