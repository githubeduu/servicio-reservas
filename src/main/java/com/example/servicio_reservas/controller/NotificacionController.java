package com.example.servicio_reservas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.servicio_reservas.DTO.ReservaDTO;
import com.example.servicio_reservas.services.RabbitMQSender;



@RestController
@RequestMapping("/reserva")
public class NotificacionController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/horaMedica")
    public String sendReserva(@RequestBody ReservaDTO reservaDTO) {
        rabbitMQSender.enviarReserva(reservaDTO);
        return "Reserva procesada: Notificación enviada a " + reservaDTO.getCliente().getNombre() +
               " y cita médica registrada para " + reservaDTO.getCita().getPacienteNombre();
    }
}