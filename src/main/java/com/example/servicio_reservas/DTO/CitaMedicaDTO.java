package com.example.servicio_reservas.DTO;

public class CitaMedicaDTO {
    private String pacienteNombre;
    private String especialidad;
    private String fechaHora;
    private String doctor;

    public CitaMedicaDTO() {}

    public CitaMedicaDTO(String pacienteNombre, String especialidad, String fechaHora, String doctor) {
        this.pacienteNombre = pacienteNombre;
        this.especialidad = especialidad;
        this.fechaHora = fechaHora;
        this.doctor = doctor;
    }

    public String getPacienteNombre() {
        return pacienteNombre;
    }

    public void setPacienteNombre(String pacienteNombre) {
        this.pacienteNombre = pacienteNombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }
}
