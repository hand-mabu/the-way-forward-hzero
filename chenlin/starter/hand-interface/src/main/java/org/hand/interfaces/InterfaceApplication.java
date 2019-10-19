package org.hand.interfaces;

import org.hzero.autoconfigure.interfaces.EnableHZeroInterface;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableHZeroInterface
@EnableDiscoveryClient
@SpringBootApplication
public class InterfaceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InterfaceApplication.class, args);
    }
}


