package xyz.andreafalco.coolify.dashboard.model.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApplicationDto {

    private String uuid;
    private String name;
    private String description;
    private List<String> domains;

}
