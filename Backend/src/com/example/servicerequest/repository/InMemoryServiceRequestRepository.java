package com.example.servicerequest.repository;

import com.example.servicerequest.model.ServiceRequest;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class InMemoryServiceRequestRepository implements Repository<ServiceRequest,Long> {
    private final Map<Long, ServiceRequest> store = new LinkedHashMap<>();
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


    @Override
    public ServiceRequest save(ServiceRequest entity){
        lock.writeLock().lock();
        try {
            store.put(entity.getId(), entity);
            return entity;
        }
        finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public Optional<ServiceRequest> findById(Long id) {
        lock.readLock().lock();
        try {
            return Optional.ofNullable(store.get(id));
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public List<ServiceRequest> findAll() {
        lock.readLock().lock();
        try {
            return List.copyOf(store.values());
        } finally {
            lock.readLock().unlock();
        }
    }

    @Override
    public boolean deleteById(Long id) {
        lock.writeLock().lock();
        try {
            return store.remove(id) != null;
        } finally {
            lock.writeLock().unlock();
        }
    }

    @Override
    public long count() {
        lock.readLock().lock();
        try {
            return store.size();
        } finally {
            lock.readLock().unlock();
        }
    }
}
