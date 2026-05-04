package dev.expopush.harness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.awspring.cloud.autoconfigure.sqs.SqsAutoConfiguration;

@SpringBootApplication(exclude = SqsAutoConfiguration.class)
public class HarnessApplication {
    public static void main(String[] args) {
        SpringApplication.run(HarnessApplication.class, args);
    }
}
