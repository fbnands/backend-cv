package com.example.backend.controller; //dice en que carpeta fisica del disco duro se encuentra el archivp
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;//permite la conexion de otros puertos
import org.springframework.web.bind.annotation.PostMapping;//este metodo solo sirve para recibir informacion nueva y crear info nueva
import org.springframework.web.bind.annotation.RequestBody;//toma el paquete json de internet y lo convierte en un objeto de java (dto)
import org.springframework.web.bind.annotation.RequestMapping;//define la direccion url para entrar al controlador del proyecto
import org.springframework.web.bind.annotation.RestController;//define la clase como un componenteq ue recibe y entrega datos en json
import com.example.backend.dto.ContactRequest;    // Es el molde o constructor de los datos 
import com.example.backend.services.ContactService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contact")
@CrossOrigin(origins = "http://localhost:4200/")

public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }
    
    @PostMapping
    public ResponseEntity<?> recibirMensaje(@Valid @RequestBody ContactRequest request) {
       
        
        System.out.println("Nombre: " + request.getNombreCompleto());
        System.out.println("Correo: " + request.getCorreo());
        System.out.println("Asunto: " + request.getAsunto());
        System.out.println("Mensaje: " + request.getMensaje());
        
         contactService.procesoMensaje(request);

            return ResponseEntity.ok(
                    java.util.Map.of(
                        "status", "ok",
                            "message", "Mensaje recibido correctamente"
                    )
        );
               
    }
    
    

}

    