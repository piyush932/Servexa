package com.example.servicerequest.service;

import com.example.servicerequest.exception.InvalidRequestStateException;
import com.example.servicerequest.exception.ResourceNotFoundException;
import com.example.servicerequest.model.Priority;
import com.example.servicerequest.model.RequestStatus;
import com.example.servicerequest.model.ServiceRequest;
import com.example.servicerequest.model.ServiceRequestPriorityComparator;
import com.example.servicerequest.repository.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ServiceRequestService {
    private final Repository<ServiceRequest, Long> requestRepository;

    public ServiceRequestService(
            Repository<ServiceRequest, Long> requestRepository) {

        this.requestRepository = requestRepository;
    }

    public ServiceRequest create(ServiceRequest request) {
        return requestRepository.save(request);
    }

    public ServiceRequest getById(long id) {
        return requestRepository.findById(id)
                .orElseThrow(
                        () -> ResourceNotFoundException
                                .forId("ServiceRequest", id)
                );
    }

    public void assign(long requestId, long agentId) {

        ServiceRequest request = getById(requestId);

        if (request.getStatus() == RequestStatus.CLOSED
                || request.getStatus() == RequestStatus.REJECTED) {

            throw new InvalidRequestStateException(
                    "Cannot assign a request that is "
                            + request.getStatus()
            );
        }

        request.assignTo(agentId);
        requestRepository.save(request);
    }

    public void changeStatus(
            long requestId,
            RequestStatus newStatus) {

        ServiceRequest request = getById(requestId);

        request.changeStatus(newStatus);

        requestRepository.save(request);
    }

    public List<ServiceRequest> findByStatus(
            RequestStatus status) {

        return requestRepository.findAll()
                .stream()
                .filter(request -> request.getStatus() == status)
                .collect(Collectors.toList());
    }

    public List<ServiceRequest> findByCategory(
            String category) {

        return requestRepository.findAll()
                .stream()
                .filter(request ->
                        request.getCategory()
                                .equalsIgnoreCase(category))
                .collect(Collectors.toList());
    }

    public List<ServiceRequest> sortedByPriorityDescending() {

        return requestRepository.findAll()
                .stream()
                .sorted(new ServiceRequestPriorityComparator())
                .collect(Collectors.toList());
    }

    public List<ServiceRequest> sortedByCreationDate() {

        return requestRepository.findAll()
                .stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public List<ServiceRequest> highPriorityOpenRequests() {

        return requestRepository.findAll()
                .stream()
                .filter(request ->
                        request.getStatus() == RequestStatus.OPEN)
                .filter(request ->
                        request.getPriority() == Priority.HIGH
                                || request.getPriority() == Priority.CRITICAL)
                .collect(Collectors.toList());
    }

    public boolean delete(long requestId) {
        return requestRepository.deleteById(requestId);
    }

    public long totalRequests() {
        return requestRepository.count();
    }
}
