package com.example.servicerequest;

import com.example.servicerequest.model.*;

import com.example.servicerequest.repository.InMemoryRequestRepository;
import com.example.servicerequest.repository.InMemoryServiceRequestRepository;
import com.example.servicerequest.service.ServiceRequestService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InMemoryServiceRequestRepository repository =
                new InMemoryServiceRequestRepository();

        ServiceRequestService service =
                new ServiceRequestService(repository);

        service.create(new ServiceRequest(
                1L,
                "Portal login failure",
                "Cannot log in",
                "Access",
                Priority.HIGH,
                100L
        ));

        service.create(new ServiceRequest(
                2L,
                "Slow network",
                "Network latency issue",
                "Network",
                Priority.LOW,
                101L
        ));

        service.create(new ServiceRequest(
                3L,
                "Data corruption",
                "Critical data issue",
                "Database",
                Priority.CRITICAL,
                102L
        ));

        System.out.println("Sorted by priority:");

        service.sortedByPriorityDescending()
                .forEach(System.out::println);

        System.out.println("\nHigh priority open requests:");

        service.highPriorityOpenRequests()
                .forEach(System.out::println);

        service.changeStatus(
                1L,
                RequestStatus.IN_PROGRESS
        );

        System.out.println(
                "\nTotal requests: "
                        + service.totalRequests()
        );
    }
}