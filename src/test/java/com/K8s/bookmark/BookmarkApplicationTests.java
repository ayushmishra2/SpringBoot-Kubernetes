package com.K8s.bookmark;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Import(TestcontainersConfiguration.class)
@SpringBootTest
class BookmarkApplicationTests {

	@Test
	void contextLoads() {
	}

}
