package com.example.servicerequest.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ServiceRequest {
    private final long id;
    private final String title;
    private final String description;
    private final String category;
    private final Priority priority;
    private final long createdByUserId;

    private RequestStatus status;
    private Long assignedAgentId;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private final List<RequestComment> comments;
    private final List<AuditEntry> auditEntries;

    public ServiceRequest(
            long id,
            String title,
            String description,
            String category,
            Priority priority,
            long createdByUserId
    ){
        validateText(title, "Title");
        validateText(description, "Description");
        validateText(category, "Category");
        Objects.requireNonNull(priority, "Priority cannot be null");

        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.priority = priority;
        this.createdByUserId = createdByUserId;
        this.status = RequestStatus.OPEN;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = this.createdAt;
        this.comments = new ArrayList<>();
        this.auditEntries = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Priority getPriority() {
        return priority;
    }

    public long getCreatedByUserId() {
        return createdByUserId;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public Long getAssignedAgentId() {
        return assignedAgentId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public List<RequestComment> getComments() {
        return List.copyOf(comments);
    }

    public List<AuditEntry> getAuditEntries() {
        return List.copyOf(auditEntries);
    }

    public void assignTo(long agentId) {
        if (status == RequestStatus.CLOSED ||
                status == RequestStatus.REJECTED) {
            throw new IllegalStateException(
                    "Closed or rejected requests cannot be assigned"
            );
        }

        this.assignedAgentId = agentId;
        this.status = RequestStatus.IN_PROGRESS;
        touch();
    }

    public void changeStatus(RequestStatus newStatus) {
        Objects.requireNonNull(newStatus, "Status cannot be null");

        if (status == RequestStatus.CLOSED) {
            throw new IllegalStateException(
                    "A closed request cannot change status"
            );
        }

        this.status = newStatus;
        touch();
    }

    public void addComment(RequestComment comment) {
        comments.add(Objects.requireNonNull(comment));
        touch();
    }

    public void addAuditEntry(AuditEntry auditEntry) {
        auditEntries.add(Objects.requireNonNull(auditEntry));
        touch();
    }

    private void touch() {
        updatedAt = LocalDateTime.now();
    }

    private void validateText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    fieldName + " cannot be blank"
            );
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof ServiceRequest other)) {
            return false;
        }

        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }

    @Override
    public String toString() {
        return "ServiceRequest{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", priority=" + priority +
                ", status=" + status +
                ", assignedAgentId=" + assignedAgentId +
                ", createdByUserId=" + createdByUserId +
                '}';
    }

}
