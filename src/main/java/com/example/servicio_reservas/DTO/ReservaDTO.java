package com.example.servicio_reservas.DTO;


public class ReservaDTO {
    private ClienteNotificacionDTO cliente;
    private CitaMedicaDTO cita;

    public ReservaDTO() {}

    public ReservaDTO(ClienteNotificacionDTO cliente, CitaMedicaDTO cita) {
        this.cliente = cliente;
        this.cita = cita;
    }

    public ClienteNotificacionDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteNotificacionDTO cliente) {
        this.cliente = cliente;
    }

    public CitaMedicaDTO getCita() {
        return cita;
    }

    public void setCita(CitaMedicaDTO cita) {
        this.cita = cita;
    }
}

