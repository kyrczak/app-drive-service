package pg.student;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

import java.util.Arrays;
import java.util.Collections;


@SpringBootApplication
public class AuiSpringGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuiSpringGatewayApplication.class,args);
    }

    @Bean
    public RouteLocator routeLocator (
            RouteLocatorBuilder builder,
            @Value("${application.module.url}") String applicationUrl,
            @Value("${disk.module.url}") String diskUrl,
            @Value("${gateway.module.host}") String host
    ) {
        return builder.routes()
                .route("disks", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/disks/{uuid}",
                                "/api/disks"
                        )
                        .uri(diskUrl)
                )
                .route("applications", route -> route
                        .host(host)
                        .and()
                        .path(
                                "/api/applications",
                                "/api/applications/**",
                                "/api/disks/{uuid}/applications",
                                "/api/disks/{uuid}/applications/**"
                        )
                        .uri(applicationUrl)
                )
                .build();
    }
}