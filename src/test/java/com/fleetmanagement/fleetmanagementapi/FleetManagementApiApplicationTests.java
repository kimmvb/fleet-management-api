package com.fleetmanagement.fleetmanagementapi;

import com.fleetmanagement.fleetmanagementapi.repositories.TaxiRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class FleetManagementApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	@DisplayName("should successfully request a taxi array")
	void getTaxisSuccess() throws Exception {
		mockMvc.perform(get("/api/v1/taxi")).andExpect(status().isOk())
				.andExpect(jsonPath("$.content").isNotEmpty());
	}

	@Test
	@DisplayName("should return an array with ten taxis")
	void pageParametersSuccess() throws Exception {
		mockMvc.perform(get("/api/v1/taxi?page=0&size=5")).andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(5)));
	}
}
///api/v1/taxi?page=0&size=10