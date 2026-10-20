package controladores;

import java.time.LocalDate;
import modelos.Cliente;

/**
 * Ejercicio 02 — Controlador de clientes (Instanciamiento).
 * Crea un objeto Cliente con "new" y muestra sus datos.
 */
public class ClienteController {

    public String verPerfil(int id) {
        // Datos "quemados" (hardcodeados), como pide el ejercicio
        Cliente cliente = new Cliente(id, "ana@mail.com", "Ana", LocalDate.now().minusDays(10));

        String perfil = "Perfil #" + cliente.getId()
                + " | Nombre: " + cliente.getNombre()
                + " | Email: " + cliente.getEmail();
        System.out.println(perfil);   // sale en la consola (y en la de Tomcat)
        return perfil;                // y también se devuelve para mostrarlo en la web
    }
}
