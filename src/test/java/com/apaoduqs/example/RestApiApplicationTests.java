package com.apaoduqs.example;

import com.apaoduqs.example.DTO.DataPerson;
import com.apaoduqs.example.DTO.StatusPerson;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RestApiApplicationTests {

	private final Gson gson = new Gson();

	@Autowired
	private MockMvc mvc;

	@Test
	void getApiRest() throws Exception {
		String response = gson.toJson(new StatusPerson(1, "Hello, Maria!", true));
		mvc.perform(MockMvcRequestBuilders.get("/my-api-rest").queryParam("name","Maria"))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo(response)));
	}

	@Test
	void postApiRest() throws Exception {
		String response = gson.toJson(new DataPerson(1, "Maria", 35,  true));
		mvc.perform(MockMvcRequestBuilders.post("/my-api-rest").contentType(MediaType.APPLICATION_JSON)
				.content(response))
				.andExpect(status().isOk())
				.andExpect(content().string(equalTo("x")));
	}

}
