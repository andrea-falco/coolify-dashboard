package xyz.andreafalco.coolify.dashboard.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.andreafalco.coolify.dashboard.model.dto.AllResponseDto;
import xyz.andreafalco.coolify.dashboard.service.ApiService;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/all")
    public AllResponseDto all() {
        return this.apiService.getAll();
    }

}
