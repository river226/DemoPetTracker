package xyz.jriver.PetTracker.Entity.Response;

public record InzoneDetail(
        String trackerType,
        int totalInZone,
        int totalOutZone
) {}
