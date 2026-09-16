package com.example.servicerequest.repository;

import com.example.servicerequest.model.ServiceRequest;

import java.util.*;

public class InMemoryRequestRepository {
    private final Map<Long, ServiceRequest> requests;

    public InMemoryRequestRepository(){
        requests = new LinkedHashMap<>();
    }

    public ServiceRequest save(ServiceRequest request){
        requests.put(request.getId(), request);
        return request;
    }

    public Optional<ServiceRequest> findById(long requestId) {
        return Optional.ofNullable(requests.get(requestId));
    }

    public List<ServiceRequest> findAll() {
        return new ArrayList<>(requests.values());
    }

    public boolean deleteById(long requestId) {
        return requests.remove(requestId) != null;
    }

    public int count() {
        return requests.size();
    }
}
