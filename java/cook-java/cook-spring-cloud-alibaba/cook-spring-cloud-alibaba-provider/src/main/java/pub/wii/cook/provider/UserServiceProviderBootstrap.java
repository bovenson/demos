package pub.wii.cook.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableAutoConfiguration
public class UserServiceProviderBootstrap {
    public static void main(String[] args) {
        try {
            SpringApplication.run(UserServiceProviderBootstrap.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}