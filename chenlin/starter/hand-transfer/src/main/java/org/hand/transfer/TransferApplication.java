package org.hand.transfer;

import org.hzero.autoconfigure.transfer.EnableHZeroTransfer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableHZeroTransfer
@EnableDiscoveryClient
@SpringBootApplication
public class TransferApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransferApplication.class, args);
    }
}


