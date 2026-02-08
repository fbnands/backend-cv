package com.example.backend.services;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.backend.dto.ContactRequest;


@Service
public class ContactService {

    private final JavaMailSender  mailsender;
    
      
      public ContactService (JavaMailSender mailsender) {
                this.mailsender = mailsender;          
        }
        @Value ("${app.mail.destino}")
        private String DESTINO = "fabian.and96@gmail.com";
        public void procesoMensaje(ContactRequest request){
         
            try {
                   
                      SimpleMailMessage mensaje = new SimpleMailMessage();  
                    
                mensaje.setTo(DESTINO);
            

                mensaje.setText(
                    "Nombre" + request.getNombreCompleto() + "/n"+
                    "Correo" + request.getCorreo() + "/n" +
                    "Asunto" + request.getMensaje() + "/n" +
                    "Mensaje" + request.getMensaje()
                );
                mailsender.send(mensaje);              
            }
            
              
             catch (Exception e) {
                e.printStackTrace();

            }


                
                   
          }
             


}
