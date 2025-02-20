package com.example.servicio_reservas.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue notificacionesQueue() {
        return new Queue("notificaciones", true);
    }

    @Bean
    public Queue citasQueue() {
        return new Queue("citas", true);
    }
}