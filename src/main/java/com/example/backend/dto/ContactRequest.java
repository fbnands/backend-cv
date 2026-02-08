package com.example.backend.dto;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


public class ContactRequest {
    @NotBlank
    @JsonProperty("NombreCompleto")
    private String NombreCompleto;
    @NotBlank
    @Email
    @JsonProperty("Correo")
    private String Correo;
    @NotBlank
    @JsonProperty("asunto")
    private String asunto;
    @NotBlank
    @JsonProperty("mensaje")
    private String mensaje;

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        NombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}


