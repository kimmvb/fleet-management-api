package com.fleetmanagement.fleetmanagementapi;

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
    @DisplayName("should return an array with taxis")
    void taxisSuccess() throws Exception {
        mockMvc.perform(get("/api/v1/taxi?pageNumber=0&pageSize=5")).andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(5)));
    }

    @Test
    @DisplayName("should return an array with five taxis")
    void taxisPaginationSuccess() throws Exception {

        mockMvc.perform(get("/api/v1/taxi")
                        .param("pageNumber", "1")
                        .param("pageSize", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pageable.pageNumber").value("1"))
                .andExpect(jsonPath("$.pageable.pageSize").value("10"));
    }

    @Test
    @DisplayName("should return an array with trajectories from a specific taxi")
    void trajectoriesWithIdSuccess() throws Exception {
        mockMvc.perform(get("/api/v1/trajectory/6418?pageNumber=0&pageSize=5")).andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(5)));
    }

    @Test
    @DisplayName("should return an array with trajectories from a specific taxi (focused on pagination)")
    void trajectoriesPaginationWithIdSuccess() throws Exception {

        mockMvc.perform(get("/api/v1/trajectory/{taxi_id}", "6418")
                        .param("pageNumber", "1")
                        .param("pageSize", "10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pageable.pageNumber").value("1"))
                .andExpect(jsonPath("$.pageable.pageSize").value("10"))
                .andExpect(jsonPath("$.content").isArray());
    }

    @Test
    @DisplayName("should return an error when taxiId is not found")
    void trajectoriesWithIdFail() throws Exception {
        mockMvc.perform(get("/api/v1/trajectory/641?pageNumber=0&pageSize=5")).andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("should return an array with trajectories from a specific taxi and date")
    void trajectoriesWithIdAndDateSuccess() throws Exception {
        mockMvc.perform(get("/api/v1/trajectory/6418/02-02-2008?pageNumber=0&pageSize=5")).andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(5)));
    }

    @Test
    @DisplayName("should return an array with trajectories from a specific taxi and date (focused on pagination)")
    void trajectoriesWithIdAndDatePaginationWithIdSuccess() throws Exception {

        mockMvc.perform(get("/api/v1/trajectory/{taxi_id}/{date}","6418","02-02-2008")
                        .param("pageNumber", "1")
                        .param("pageSize", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pageable.pageNumber").value("1"))
                .andExpect(jsonPath("$.pageable.pageSize").value("5"))
                .andExpect(jsonPath("$.content").isArray());
    }

    @Test
    @DisplayName("should return an error when trajectories are not found")
    void trajectoriesWithIdAndDateFail() throws Exception {
        mockMvc.perform(get("/api/v1/trajectory/6418/02-02-2080?pageNumber=0&pageSize=5"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("should return the all last locations")
    void lastLocationsSuccess() throws Exception {
        mockMvc.perform(get("/api/v1/trajectory/last_locations?pageNumber=0&pageSize=5")).andExpect(status().isOk())
                .andExpect(jsonPath("$.content", hasSize(5)));
    }

    @Test
    @DisplayName("should return the all last locations (focused on pagination)")
    void lastLocationsPaginationSuccess() throws Exception {

        mockMvc.perform(get("/api/v1/trajectory/last_locations")
                        .param("pageNumber", "1")
                        .param("pageSize", "5"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.pageable.pageNumber").value("1"))
                .andExpect(jsonPath("$.pageable.pageSize").value("5"))
                .andExpect(jsonPath("$.content").isArray());
    }

}