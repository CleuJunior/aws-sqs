package br.com.sqs;

import br.com.sqs.dto.CustomerJson;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwsSqsApplication implements CommandLineRunner {

    @Autowired
    private SqsTemplate sqsTemplate;
    private final Faker faker = new Faker();

    public static void main(String[] args) {
        SpringApplication.run(AwsSqsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        var url = "https://localhost.localstack.cloud:4566/000000000000/aws-sqs-simple-queue";
        var index = 0;

        while (index < 10) {
            sqsTemplate.send(url, new CustomerJson(faker.name().firstName(), faker.name().lastName()));
            index++;
        }
    }
}
