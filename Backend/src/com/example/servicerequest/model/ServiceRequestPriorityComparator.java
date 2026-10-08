package com.example.servicerequest.model;

import java.util.Comparator;

public class ServiceRequestPriorityComparator implements Comparator<ServiceRequest> {
    private static final Comparator<Priority> PRIORITY_ORDER =
            Comparator.comparingInt(
                    ServiceRequestPriorityComparator::rank
            );

    @Override
    public int compare(
            ServiceRequest first,
            ServiceRequest second) {

        return PRIORITY_ORDER.reversed()
                .compare(first.getPriority(), second.getPriority());
    }

    private static int rank(Priority priority) {
        return switch (priority) {
            case LOW -> 0;
            case MEDIUM -> 1;
            case HIGH -> 2;
            case CRITICAL -> 3;
        };
    }

}
