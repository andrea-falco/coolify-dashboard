package xyz.andreafalco.coolify.dashboard.service;

import org.springframework.stereotype.Service;
import xyz.andreafalco.coolify.api.ProjectsApi;
import xyz.andreafalco.coolify.dashboard.model.dto.AllResponseDto;
import xyz.andreafalco.coolify.dashboard.model.dto.ApplicationDto;
import xyz.andreafalco.coolify.dashboard.model.dto.EnvironmentDto;
import xyz.andreafalco.coolify.dashboard.model.dto.ProjectDto;
import xyz.andreafalco.coolify.dashboard.model.dto.ServiceDto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class ApiService {

    private final ProjectsApi coolifyProjectsApi;

    public ApiService(
            ProjectsApi coolifyProjectsApi
    ) {
        this.coolifyProjectsApi = coolifyProjectsApi;
    }

    public AllResponseDto getAll() {
        // Get all Coolify projects
        var projects = this.coolifyProjectsApi.listProjects();

        AllResponseDto all = new AllResponseDto();
        projects.forEach(p -> {
            // Compose project
            ProjectDto pDto = new ProjectDto();
            pDto.setUuid(p.getUuid());
            pDto.setName(p.getName());
            pDto.setDescription(p.getDescription());
            // Compose environments
            var project = this.coolifyProjectsApi.getProjectByUuid(p.getUuid());
            if (Objects.isNull(project.getEnvironments()))
                return;

            project.getEnvironments().forEach(e -> {
                EnvironmentDto eDto = new EnvironmentDto();
                eDto.setUuid(e.getUuid());
                eDto.setName(e.getName());
                // Compose applications
                var env = this.coolifyProjectsApi.getEnvironmentByNameOrUuid(p.getUuid(), e.getName());
                if (Objects.isNull(env.getApplications()))
                    return;

                eDto.setApplications(env.getApplications().stream()
                        .map(a -> {
                            ApplicationDto aDto = new ApplicationDto();
                            aDto.setUuid(a.getUuid());
                            aDto.setName(a.getName());
                            aDto.setDescription(a.getDescription());
                            aDto.setDomains(Objects.nonNull(a.getFqdn()) ? Arrays.stream(a.getFqdn().split(",")).toList() : List.of());
                            return aDto;
                        })
                        .toList()
                );

                // Compose services
                if (Objects.isNull(env.getServices()))
                    return;
                eDto.setServices(env.getServices().stream()
                        .map(s -> {
                            ServiceDto sDto = new ServiceDto();
                            sDto.setUuid(s.getUuid());
                            sDto.setName(s.getName());
                            sDto.setDescription(s.getDescription());
                            sDto.setDomains(List.of()); // TODO AF - Get service domains
                            return sDto;
                        })
                        .toList()
                );
                pDto.getEnvironments().add(eDto);
            });

            all.getProjects().add(pDto);
        });
        return all;
    }
}
