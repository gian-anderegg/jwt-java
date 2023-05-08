package gibb.m183.m183project.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("app")
public class AppConfig {
    private String jwtSecret;
    private String jwtExpirationMs;

    public String getJwtSecret() {
        return jwtSecret;
    }

    public void setJwtSecret(String jwtSecret) {
        this.jwtSecret = jwtSecret;
    }

    public String getJwtExpirationMs() {
        return jwtExpirationMs;
    }

    public void setJwtExpirationMs(String jwtExpirationMs) {
        this.jwtExpirationMs = jwtExpirationMs;
    }
}
