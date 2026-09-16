package com.example.servicerequest.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class RequestComment {
    private final long id;
    private final long authorId;
    private final String message;
    private final LocalDateTime createdAt;

    public RequestComment(
            long id,
            long authorId,
            String message
    ) {
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("Comment cannot be blank");
        }

        this.id = id;
        this.authorId = authorId;
        this.message = message;
        this.createdAt = LocalDateTime.now();
    }

    public long getId() {
        return id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof RequestComment other)) {
            return false;
        }

        return id == other.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "RequestComment{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

