package pg.student;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AuiSpringGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuiSpringGatewayApplication.class,args);
    }

    @Bean
    public RouteLocator routeLocator (
            RouteLocatorBuilder builder,
            @Value("${spring.application.url}") String applicationUrl,
            @Value("${spring.disk.url}") String diskUrl,
            @Value("${spring.gateway.host}") String host
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