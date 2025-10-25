package xyz.andreafalco.coolify.dashboard.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.andreafalco.coolify.ApiClient;
import xyz.andreafalco.coolify.api.ApplicationsApi;
import xyz.andreafalco.coolify.api.DatabasesApi;
import xyz.andreafalco.coolify.api.DefaultApi;
import xyz.andreafalco.coolify.api.DeploymentsApi;
import xyz.andreafalco.coolify.api.GitHubAppsApi;
import xyz.andreafalco.coolify.api.PrivateKeysApi;
import xyz.andreafalco.coolify.api.ProjectsApi;
import xyz.andreafalco.coolify.api.ResourcesApi;
import xyz.andreafalco.coolify.api.ServersApi;
import xyz.andreafalco.coolify.api.ServicesApi;
import xyz.andreafalco.coolify.api.TeamsApi;

@Configuration
public class CoolifyClientConfiguration {

    private final String host;
    private final String token;

    public CoolifyClientConfiguration(
            @Value("${coolify.api.host}") String host,
            @Value("${coolify.api.token}") String token
    ) {
        this.host = host;
        this.token = token;
    }

    @Bean
    public ApiClient coolifyApiClient() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(String.format("%s/api/v1", this.host));
        apiClient.setBearerToken(this.token);
        return apiClient;
    }

    @Bean
    public ApplicationsApi coolifyApplicationsApi(ApiClient apiClient) {
        return new ApplicationsApi(apiClient);
    }

    @Bean
    public DatabasesApi coolifyDatabasesApi(ApiClient apiClient) {
        return new DatabasesApi(apiClient);
    }

    @Bean
    public DeploymentsApi coolifyDeploymentsApi(ApiClient apiClient) {
        return new DeploymentsApi(apiClient);
    }

    @Bean
    public GitHubAppsApi coolifyGitHubAppsApi(ApiClient apiClient) {
        return new GitHubAppsApi(apiClient);
    }

    @Bean
    public ProjectsApi coolifyProjectsApi(ApiClient apiClient) {
        return new ProjectsApi(apiClient);
    }

    @Bean
    public ResourcesApi coolifyResourcesApi(ApiClient apiClient) {
        return new ResourcesApi(apiClient);
    }

    @Bean
    public PrivateKeysApi coolifyPrivateKeysApi(ApiClient apiClient) {
        return new PrivateKeysApi(apiClient);
    }

    @Bean
    public ServersApi coolifyServersApi(ApiClient apiClient) {
        return new ServersApi(apiClient);
    }

    @Bean
    public ServicesApi coolifyServicesApi(ApiClient apiClient) {
        return new ServicesApi(apiClient);
    }

    @Bean
    public TeamsApi coolifyTeamsApi(ApiClient apiClient) {
        return new TeamsApi(apiClient);
    }

    @Bean
    public DefaultApi coolifyDefaultApi(ApiClient apiClient) {
        return new DefaultApi(apiClient);
    }
}
