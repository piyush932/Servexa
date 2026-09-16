package com.example.servicerequest;

import com.example.servicerequest.model.Employee;
import com.example.servicerequest.model.Priority;
import com.example.servicerequest.model.ServiceRequest;
import com.example.servicerequest.model.SupportAgent;

import com.example.servicerequest.repository.InMemoryRequestRepository;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(
                1L,
                "Piyush Kumar Nayak",
                "piyush@example.com",
                "Engineering"
        );

        SupportAgent agent = new SupportAgent(
                2L,
                "Support Agent",
                "support@example.com",
                "Platform Support"
        );

        ServiceRequest request = new ServiceRequest(
                1001L,
                "Unable to access internal portal",
                "The employee cannot log in to the internal portal.",
                "Access",
                Priority.HIGH,
                employee.getId()
        );

        request.assignTo(agent.getId());
        agent.assignRequest(request.getId());

        InMemoryRequestRepository repository =
                new InMemoryRequestRepository();

        repository.save(request);

        repository.findAll().forEach(System.out::println);
    }
}