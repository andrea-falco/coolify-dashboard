package xyz.andreafalco.coolify.dashboard.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class EnvironmentDto {

    private String uuid;
    private String name;
    private List<ApplicationDto> applications = new ArrayList<>();
    private List<ServiceDto> services = new ArrayList<>();

}
