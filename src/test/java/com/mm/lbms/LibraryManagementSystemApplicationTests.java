package com.mm.lbms;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
class LibraryManagementSystemApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;
	
	// Testing Start Books End-Points
	
	@Test
    public void testAddBookEndpoint() throws Exception {
        String requestBody = "{"
                + "\"title\": \"\","
                + "\"author\": \"F. Scott Fitzgerald\","
                + "\"publicationYear\": \"2024-12-14\","
                + "\"isbn\": \"9780743273565\""
                + "}";

        mockMvc.perform(post("/api/books/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }
	
	@Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/all-books")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	@Test
    public void testGetBookById() throws Exception {
        Long bookId = 1L; // Replace with the actual book ID you want to test

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/{id}", bookId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	@Test
    public void testUpdateBook() throws Exception {
		
        String requestBody = "{"
        		+  "\"id\":\"752\","
                + "\"title\": \"The Great Gatsby\","
                + "\"author\": \"F. Scott Fitzgerald\","
                + "\"publicationYear\": \"2024-12-16\","
                + "\"isbn\": \"9780743273510\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/books/update")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	@Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/books/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	// Start Testing Patrons End-Points
	@Test
    public void testAddPatronEndpoint() throws Exception {
        String requestBody = "{"
                + "\"name\": \"Aung Ko Lin\","
                + "\"phoneNo\": \"09450821620\","
                + "\"email\": \"aungko.linn404@gmail.com\","
                + "\"address\": \"Yangon,Myanmar\""
                + "}";

        mockMvc.perform(post("/api/patrons/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(status().isOk());
    }
	
	@Test
    public void testGetAllPatrons() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/patrons/all-patrons")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	@Test
    public void testGetPatronsById() throws Exception {
        Long patronId = 1L; // Replace with the actual book ID you want to test

        mockMvc.perform(MockMvcRequestBuilders.get("/api/patrons/{id}", patronId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	@Test
    public void testUpdatePatrons() throws Exception {
		String requestBody = "{"
				+ "\"id\":\"752\","
                + "\"name\": \"Aung Ko Lin\","
                + "\"phoneNo\": \"09450821620\","
                + "\"email\": \"aungko.linn404@gmail.com\","
                + "\"address\": \"Yangon,Myanmar\""
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/patrons/update")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	@Test
    public void testDeletePatrons() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/patrons/{id}", 1)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	// Start Testing Borrowing End-Points
	
	@Test
    public void testBorrowBook() throws Exception {
        Long bookId = 1L; // Replace with actual book ID
        Long patronId = 1L; // Replace with actual patron ID

        mockMvc.perform(MockMvcRequestBuilders.post("/api/borrow/{bookId}/patron/{patronId}", bookId, patronId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
	
	@Test
    public void testReturnBook() throws Exception {
        Long bookId = 1L; // Replace with actual book ID
        Long patronId = 1L; // Replace with actual patron ID

        mockMvc.perform(MockMvcRequestBuilders.put("/api/return/{bookId}/patron/{patronId}", bookId, patronId)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}
