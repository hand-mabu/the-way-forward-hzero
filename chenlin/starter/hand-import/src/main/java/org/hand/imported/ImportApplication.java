package org.hand.imported;

import org.hzero.autoconfigure.imported.EnableHZeroImport;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableHZeroImport
@EnableDiscoveryClient
@SpringBootApplication
public class ImportApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImportApplication.class, args);
    }
}


