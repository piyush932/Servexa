package com.example.servicerequest.repository;

import com.example.servicerequest.model.User;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements Repository<User,Long> {
    private final Map<Long, User> store = new LinkedHashMap<>();

    @Override
    public User save(User entity) {
        store.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<User> findAll() {
        return List.copyOf(store.values());
    }

    @Override
    public boolean deleteById(Long id) {
        return store.remove(id) != null;
    }

    @Override
    public long count() {
        return store.size();
    }
}
