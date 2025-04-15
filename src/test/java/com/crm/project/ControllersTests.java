package com.crm.project;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crm.controllers.CompanyController;
import com.crm.dtos.CompanyDTO;
import com.crm.entities.Company;
import com.crm.services.CompanyService;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ControllersTests {
    private MockMvc mvc;
    @Mock
    private CompanyService companyService;
    @InjectMocks
    private CompanyController companyController;

    @BeforeAll
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(companyController).build();
    }

    @Test
    public void testAddCompany() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/add")
        .content(asJsonString(new CompanyDTO("Company Inc.", "1234 Main St.", "New York", "NY", "10001")))
        .contentType("application/json"))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
        
    
    }

    public static String asJsonString(final Object obj) {
	    try {
	        final ObjectMapper mapper = new ObjectMapper();
	        final String jsonContent = mapper.writeValueAsString(obj);
	        return jsonContent;
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    }
	}
}
