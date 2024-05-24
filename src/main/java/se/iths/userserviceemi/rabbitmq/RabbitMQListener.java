package se.iths.userserviceemi.rabbitmq;

import lombok.AllArgsConstructor;
import se.iths.userserviceemi.service.UserService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



@Component
@AllArgsConstructor
public class RabbitMQListener {

    private final UserService userService;

    @Bean
    public Queue myQueue(){
        return new Queue("messages", false);
    }

    @RabbitListener(queues = "messages")
    public void listenToMessageQueue(String jsonMessage) {

        try {
            System.out.println(jsonMessage);
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonMessage);
            String userID = jsonNode.get("from").asText();

            userService.incrementMessageCount(userID);

        } catch (Exception e) {
            System.out.println("Error in RabbitMQListener: " + e.getMessage());
        }
    }
}