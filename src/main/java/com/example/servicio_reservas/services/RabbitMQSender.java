package com.example.servicio_reservas.services;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicio_reservas.DTO.ReservaDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RabbitMQSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    private final String NOTIFICACIONES_QUEUE = "notificaciones";
    private final String CITAS_QUEUE = "citas";

    public void enviarReserva(ReservaDTO reservaDTO) {
        try {
            // Convertir Cliente a JSON y enviarlo a la cola de notificaciones
            if (reservaDTO.getCliente() != null) {
                String clienteJson = objectMapper.writeValueAsString(reservaDTO.getCliente());
                rabbitTemplate.convertAndSend(NOTIFICACIONES_QUEUE, clienteJson);
                System.out.println("Notificación enviada a RabbitMQ: " + clienteJson);
            }

            // Convertir Cita Médica a JSON y enviarla a la cola de citas
            if (reservaDTO.getCita() != null) {
                String citaJson = objectMapper.writeValueAsString(reservaDTO.getCita());
                rabbitTemplate.convertAndSend(CITAS_QUEUE, citaJson);
                System.out.println("Cita médica enviada a RabbitMQ: " + citaJson);
            }

        } catch (JsonProcessingException e) {
            System.err.println("Error al convertir el mensaje a JSON: " + e.getMessage());
        }
    }
}