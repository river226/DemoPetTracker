package xyz.jriver.PetTracker.Entity.Response;

import java.util.List;

public record InzoneResponse(
        List<InzoneDetail> dogs,
        List<InzoneDetail> cats) {}
