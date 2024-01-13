package org.tims.aliasnetwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class AliasNetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(AliasNetworkApplication.class, args);
    }

}
