package com.crm.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Date;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;

import com.crm.entities.Company;
import com.crm.entities.Contacts;
import com.crm.entities.Employee;
import com.crm.entities.PriorityEnum;
import com.crm.entities.RoleEnum;
import com.crm.entities.Tasks;


@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class EntitiesTests {
    
    private Company company;
    private Contacts contact;
    private Employee employee;
    private Tasks task;
    private Company company2;
    private Contacts contact2;
    private Employee employee2;
    private Tasks task2;

    @BeforeAll
    public void setUp() {
        company = new Company();
        company.setId(0);
        company.setName("Company Inc.");
        company.setAddress("1234 Main St.");
        company.setCity("New York");
        company.setState("NY");
        company.setZip("10001");

        contact = new Contacts();
        contact.setId(0);
        contact.setFirstName("Jane");
        contact.setLastName("Doe");
        contact.setPhoneNumber("1234567890");
        contact.setCompany(company);
        contact.setLead(true);

        employee = new Employee();
        employee.setId(0);
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setEmail("john.Doe@email.com");
        employee.setPhoneNumber("1234567890");
        employee.setRole(RoleEnum.ADMIN);

        task = new Tasks();
        task.setId(0);
        task.setSubject("Task 1");
        task.setDueDate(new Date(0));
        task.setPriority(PriorityEnum.HIGH);
        task.setCompany(company);
        task.setContact(contact);
    }

    @Test
    public void testCompany(){
        assertNotNull(company, "Company object is null");
        assertNotNull(company.getName(), "Company name is null");
        assertNotNull(company.getAddress(), "Company address is null");
        assertNotNull(company.getCity(), "Company city is null");
        assertNotNull(company.getState(), "Company state is null");
        assertNotNull(company.getZip(), "Company zip is null");

        assertNull(company2, "Company is not null");
        company2 = new Company();
        assertNull(company2.getName(), "Company name is not null");
        assertNull(company2.getAddress(), "Company address is not null");
        assertNull(company2.getCity(), "Company city is not null");
        assertNull(company2.getState(), "Company state is not null");
        assertNull(company2.getZip(), "Company zip is not null");
    }

    @Test
    public void testContact(){
        assertNotNull(contact, "Contact object is null");
        assertNotNull(contact.getFirstName(), "Contact first name is null");
        assertNotNull(contact.getLastName(), "Contact last name is null");
        assertNotNull(contact.getPhoneNumber(), "Contact phone number is null");
        assertNotNull(contact.getCompany(), "Contact company is null");
        assertNotNull(contact.isLead(), "Contact lead is null");

        assertNull(contact2, "Contact is not null");
        contact2 = new Contacts();
        assertNull(contact2.getFirstName(), "Contact first name is not null");
        assertNull(contact2.getLastName(), "Contact last name is not null");
        assertNull(contact2.getPhoneNumber(), "Contact phone number is not null");
        assertNull(contact2.getCompany(), "Contact company is not null");
        assertEquals(contact2.isLead(), false, "Contact lead is not false");
    }

    @Test
    public void TestEmployee(){
        assertNotNull(employee, "Employee object is null");
        assertNotNull(employee.getFirstName(), "Employee first name is null");
        assertNotNull(employee.getLastName(), "Employee last name is null");
        assertNotNull(employee.getEmail(), "Employee email is null");
        assertNotNull(employee.getPhoneNumber(), "Employee phone number is null");
        assertNotNull(employee.getRole(), "Employee role is null");

        assertNull(employee2, "Employee is not null");
        employee2 = new Employee();
        assertNull(employee2.getFirstName(), "Employee first name is not null");
        assertNull(employee2.getLastName(), "Employee last name is not null");
        assertNull(employee2.getEmail(), "Employee email is not null");
        assertNull(employee2.getPhoneNumber(), "Employee phone number is not null");
        assertNull(employee2.getRole(), "Employee role is not null");
    }

    @Test
    public void TestTask(){
        assertNotNull(task, "Task object is null");
        assertNotNull(task.getSubject(), "Task subject is null");
        assertNotNull(task.getDueDate(), "Task due date is null");
        assertNotNull(task.getPriority(), "Task priority is null");
        assertNotNull(task.getCompany(), "Task company is null");
        assertNotNull(task.getContact(), "Task contact is null");

        assertNull(task2, "Task is not null");
        task2 = new Tasks();
        assertNull(task2.getSubject(), "Task subject is not null");
        assertNull(task2.getDueDate(), "Task due date is not null");
        assertNull(task2.getPriority(), "Task priority is not null");
        assertNull(task2.getCompany(), "Task company is not null");
        assertNull(task2.getContact(), "Task contact is not null");
    }
}
