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

	@Test
	@DisplayName("should return an array with trajectories from a specific taxi")
	void trajectoriesWithIdSuccess() throws Exception {
		mockMvc.perform(get("/api/v1/trajectory/6418?page=0&size=5")).andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(5)));
	}

	@Test
	@DisplayName("should return an error when taxiId is not found")
	void trajectoriesWithIdFail() throws Exception {
		mockMvc.perform(get("/api/v1/trajectory/641?page=0&size=5")).andExpect(status().is4xxClientError());
	}

	@Test
	@DisplayName("should return an array with trajectories from a specific taxi and date")
	void trajectoriesWithIdAndDateSuccess() throws Exception {
		mockMvc.perform(get("/api/v1/trajectory/6418/02-02-2008?page=0&size=5")).andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(5)));
	}

	@Test
	@DisplayName("should return an error when trajectories are not found")
	void trajectoriesWithIdAndDateFail() throws Exception {
		mockMvc.perform(get("/api/v1/trajectory/6418/02-02-2080?page=0&size=5"))
				.andExpect(status().is4xxClientError());
	}

	@Test
	@DisplayName("should return the last location of a specific taxi")
	void lastLocationSuccess() throws Exception {
		mockMvc.perform(get("/api/v1/trajectory/6418/last_location")).andExpect(status().isOk())
				.andExpect(jsonPath("$.content", hasSize(1)));
	}

	@Test
	@DisplayName("should return an error when last location is not found")
	void lastLocationFail() throws Exception {
		mockMvc.perform(get("/api/v1/trajectory/641/last_location"))
				.andExpect(status().is4xxClientError());
	}
}