package xyz.andreafalco.coolify.dashboard.model.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AllResponseDto {

    private List<ProjectDto> projects = new ArrayList<>();

}
