package com.shaneroach.songr;

import com.shaneroach.songr.controller.HelloController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SongrApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void testHelloWorld() throws Exception
	{
		mockMvc.perform(get("/hello-world"))
				.andDo(print())  // enable for debugging
				.andExpect(content().string(containsString("Hello World")))
				.andExpect(status().isOk());
	}

	@Test
	void testCreateAlbum() throws Exception
	{
		System.out.println("Starting to test cookie store creation POST");
		mockMvc.perform(post("/addAlbum")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
						.param("title", "A Great Album")
						.param("artist", "Wonder Cat")
						.param("songCount","20")
						.param("length", "1200")
						.param("imageUrl", "hello.jpg")
				)
				.andDo(print())
				.andExpect(redirectedUrl("/"))
				.andExpect(status().isFound());
	}





}
