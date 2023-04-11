package com.api.apis;

import com.api.apis.Controlador.ControladorDao;
import com.api.apis.Modelo.Colaborador;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApisApplication {
    
    @GetMapping("/listar/colaboradores")
    public List<Colaborador> listarColaboradores() throws SQLException, ClassNotFoundException {
        ControladorDao cd = new ControladorDao();
        return cd.listarColaboradores();
    }
    
    @GetMapping("/login")
    public Map<String, Object> login(@RequestParam(value = "user") String user, @RequestParam(value = "pass") String pass) throws SQLException, ClassNotFoundException {
       
        Map<String, Object> response = new HashMap<>();
        Colaborador colaborador = new Colaborador();
        try {
            
            colaborador.setRut(user);
            colaborador.setPassword(pass);

            ControladorDao cd = new ControladorDao();
            Colaborador col = cd.loginUsuario(colaborador);
            response.put("id", col.getId());
            response.put("nombres", col.getNombres());
            response.put("apellidos", col.getApellidos());
            
            boolean exists = true;
            response.put("existe", exists);
        
            return response;
        } catch (SQLException | ClassNotFoundException ex) {
           
            boolean exists = false;
            response.put("existe", exists);
            return response;
        }
    }

    public static void main(String[] args) {
            SpringApplication.run(ApisApplication.class, args);
    }
}
