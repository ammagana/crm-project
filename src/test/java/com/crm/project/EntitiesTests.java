package com.crm.project;

import java.sql.Date;

import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;

import com.crm.entities.Company;
import com.crm.entities.Contacts;
import com.crm.entities.Employee;
import com.crm.entities.PriorityEnum;
import com.crm.entities.RoleEnum;
import com.crm.entities.Tasks;


@SpringBootTest
public class EntitiesTests {
    @BeforeAll
    public void setUp() {
        Company company = new Company();
        company.setId(0);
        company.setName("Company Inc.");
        company.setAddress("1234 Main St.");
        company.setCity("New York");
        company.setState("NY");
        company.setZip("10001");

        Contacts contact = new Contacts();
        contact.setId(0);
        contact.setFirstName("Jane");
        contact.setLastName("Doe");
        contact.setPhoneNumber("1234567890");
        contact.setCompany(company);
        contact.setLead(true);

        Employee employee = new Employee();
        employee.setId(0);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("john.Doe@email.com");
        employee.setPhoneNumber("1234567890");
        employee.setRole(RoleEnum.ADMIN);

        Tasks task = new Tasks();
        task.setId(0);
        task.setSubject("Task 1");
        task.setDueDate(new Date(0));
        task.setPriority(PriorityEnum.HIGH);
        task.setCompany(company);
        task.setContact(contact);
    }

    

}
