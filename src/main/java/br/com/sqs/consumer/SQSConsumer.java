package br.com.sqs.consumer;

import br.com.sqs.dto.CustomerJson;
import br.com.sqs.entities.Customer;
import br.com.sqs.repositories.CustomerRepository;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SQSConsumer {

    private static final Logger logger = LoggerFactory.getLogger(SQSConsumer.class);

    private final CustomerRepository customerRepository;

    public SQSConsumer(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @SqsListener("aws-sqs-simple-queue")
    public void receiveMessage(CustomerJson request) {
        logger.info("Received customer from queue: {}", request);
        customerRepository.save(Customer.of(request.firstName(), request.lastName()));
    }
}
