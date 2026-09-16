package com.example.servicerequest.model;

import java.util.HashSet;
import java.util.Set;

public class SupportAgent extends User{
    private final String team;
    private final Set<Long> assignedRequestIds;

    public SupportAgent(
            long id,
            String name,
            String email,
            String team
    ) {
        super(id, name, email, UserRole.SUPPORT_AGENT);

        if (team == null || team.isBlank()) {
            throw new IllegalArgumentException("Team cannot be blank");
        }

        this.team = team;
        this.assignedRequestIds = new HashSet<>();
    }

    public String getTeam() {
        return team;
    }

    public void assignRequest(long requestId) {
        assignedRequestIds.add(requestId);
    }

    public void unassignRequest(long requestId) {
        assignedRequestIds.remove(requestId);
    }

    public Set<Long> getAssignedRequestIds() {
        return Set.copyOf(assignedRequestIds);
    }



}
