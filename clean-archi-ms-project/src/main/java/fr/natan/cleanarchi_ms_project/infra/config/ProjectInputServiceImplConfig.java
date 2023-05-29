package fr.natan.cleanarchi_ms_project.infra.config;

import fr.natan.cleanarchi_ms_project.domain.ports.output.ProjectOutputService;
import fr.natan.cleanarchi_ms_project.domain.usecase.ProjectInputServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProjectInputServiceImplConfig {
    @Bean
    public ProjectInputServiceImpl projectInputService(@Autowired ProjectOutputService projectOutputService){
        return new ProjectInputServiceImpl(projectOutputService);
    }
}
