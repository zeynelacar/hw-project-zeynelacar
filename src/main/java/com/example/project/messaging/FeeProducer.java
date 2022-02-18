package com.example.project.messaging;



import com.example.project.config.RabbitMQConfig;
import com.example.project.model.Fee;
import com.example.project.service.interfaces.FeeService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messaging/send")
public class FeeProducer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private FeeService feeService;

    @PostMapping("/{message}")
    public String publishMessage(@PathVariable String message) {
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);
        return "Message sent successfully";
    }

    @PostMapping("/fee/{id}")
    public String publishPassenger(@PathVariable Integer id) {
        Fee fee = feeService.getFee(id);
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, fee);
        return "Fee sent successfully";
    }
}
