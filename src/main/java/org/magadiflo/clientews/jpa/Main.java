package org.magadiflo.clientews.jpa;

import jakarta.xml.ws.BindingProvider;
import org.magadiflo.webapp.jaxws.services.Curso;
import org.magadiflo.webapp.jaxws.services.CursoServicioWs;
import org.magadiflo.webapp.jaxws.services.CursoServicioWsImplService;

public class Main {
    public static void main(String[] args) {
        CursoServicioWs service = new CursoServicioWsImplService().getCursoServicioWsImplPort();

        ((BindingProvider)service).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
        ((BindingProvider)service).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "magadiflo");

        Curso curso = new Curso();
        curso.setNombre("TypeScript");
        curso.setDescripcion("Curso básico de TypeScript");
        curso.setDuracion(600D);
        curso.setInstructor("Fernando Herrera");

        Curso respuesta = service.guardar(curso);
        System.out.println("Curso guardado: " + respuesta.getId() + ", " + respuesta.getNombre());

        service.listar().forEach(c -> System.out.println(c.getNombre()));
    }
}
