package com.example.servicio_reservas.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.servicio_reservas.DTO.ReservaDTO;
import com.example.servicio_reservas.services.RabbitMQSender;



@RestController
@RequestMapping("/reservas")
public class NotificacionController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/horaMedica")
    public ResponseEntity<Map<String, String>> sendReserva(@RequestBody ReservaDTO reservaDTO) {
        rabbitMQSender.enviarReserva(reservaDTO);

        Map<String, String> response = new HashMap<>();
        response.put("mensaje", "Reserva procesada: Notificación enviada a " + reservaDTO.getCliente().getNombre() + 
                    " y cita médica registrada para " + reservaDTO.getCita().getPacienteNombre());

        return ResponseEntity.ok(response);
    }

}