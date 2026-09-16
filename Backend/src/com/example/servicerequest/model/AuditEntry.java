package com.example.servicerequest.model;

import java.time.LocalDateTime;

public class AuditEntry {
    private final long id;
    private final long requestId;
    private final long performedBy;
    private final String action;
    private final LocalDateTime createdAt;

    public AuditEntry(
            long id,
            long requestId,
            long performedBy,
            String action
    ) {
        if (action == null || action.isBlank()) {
            throw new IllegalArgumentException("Audit action cannot be blank");
        }

        this.id = id;
        this.requestId = requestId;
        this.performedBy = performedBy;
        this.action = action;
        this.createdAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public long getRequestId() {
        return requestId;
    }

    public long getPerformedBy() {
        return performedBy;
    }

    public String getAction() {
        return action;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
