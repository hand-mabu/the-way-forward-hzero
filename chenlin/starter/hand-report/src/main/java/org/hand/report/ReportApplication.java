package org.hand.report;

import org.hzero.autoconfigure.report.EnableHZeroReport;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableHZeroReport
@EnableDiscoveryClient
@SpringBootApplication
public class ReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReportApplication.class, args);
    }
}


