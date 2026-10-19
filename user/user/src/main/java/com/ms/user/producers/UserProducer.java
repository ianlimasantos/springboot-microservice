package com.ms.user.producers;

import com.ms.user.dtos.EmailDto;
import com.ms.user.dtos.UserResponseDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserResponseDto user){
        var emailDto = new EmailDto(user.id(),
                user.email(),
                "Cadastro realizado com sucesso!",
                user.name() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro!"
                );
        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
