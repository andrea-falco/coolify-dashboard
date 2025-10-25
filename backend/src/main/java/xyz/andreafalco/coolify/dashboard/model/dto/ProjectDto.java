package xyz.andreafalco.coolify.dashboard.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProjectDto {

    private String uuid;
    private String name;
    private String description;
    private List<EnvironmentDto> environments = new ArrayList<>();

}
