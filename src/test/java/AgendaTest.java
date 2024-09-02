
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Time;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import co.edu.uniquindio.poo.model.Agenda;
import co.edu.uniquindio.poo.model.Categoria;
import co.edu.uniquindio.poo.model.Contacto;
import co.edu.uniquindio.poo.model.Grupo;
import co.edu.uniquindio.poo.model.Reunion;

public class AgendaTest {

    private Agenda agenda;

    @BeforeEach
    public void setUp() {
        agenda = new Agenda();
    }

    @Test
    public void testAgregarContacto() {
        Contacto contacto = new Contacto("JuanES","Pacho","Las americas",
        
        "3054795632","juanesgaleano@prueba.com");
        agenda.agregarContacto(contacto);

        List<Contacto> contactos = agenda.getContactos();
        assertEquals(1, contactos.size());
        assertEquals("Juan Pérez", contactos.get(0).getNombre());
    }

    @Test
    public void testEliminarContacto() {
        Contacto contacto = new Contacto("Juanes","Pacho","Las americas",
        "3054795632","juanesgaleano@prueba.com");
        agenda.agregarContacto(contacto);

        boolean eliminado = agenda.eliminarContacto("Juan Pérez");
        assertTrue(eliminado);

        List<Contacto> contactos = agenda.getContactos();
        assertEquals(0, contactos.size());
    }

    @Test
    public void testModificarContacto() {
        Contacto contacto = new Contacto("Juanes","Pacho","Las americas",
        
        "3054795632","juanesgaleano@prueba.com");
        agenda.agregarContacto(contacto);

        Contacto contactoModificado = new Contacto("Juan Modificado", "JuanitoM","acacias","3054795621","prueba25@gmail.com");
        boolean modificado = agenda.modificarContacto("Juan Pérez", contactoModificado);

        assertTrue(modificado);

        Contacto contactoActualizado = agenda.getContactos().get(0);
        assertEquals("Juan Modificado", contactoActualizado.getNombre());
    }

    @Test
    public void testAgregarGrupo() {
        Grupo grupo = new Grupo("Amigos",Categoria.FIESTA);
        agenda.agregarGrupo(grupo);

        List<Grupo> grupos = agenda.getGrupos();
        assertEquals(1, grupos.size());
        assertEquals("Amigos", grupos.get(0).getNombre());
    }

    @Test
    public void testEliminarGrupo() {
        Grupo grupo = new Grupo("Amigos",Categoria.FIESTA);
        agenda.agregarGrupo(grupo);

        boolean eliminado = agenda.eliminarGrupo("Amigos");
        assertTrue(eliminado);

        List<Grupo> grupos = agenda.getGrupos();
        assertEquals(0, grupos.size());
    }

    @Test
    public void testAgregarReunion() {
        Grupo grupo = new Grupo("Trabajo",Categoria.OFICINA);
        agenda.agregarGrupo(grupo);

        Reunion reunion = new Reunion("Reunión de Trabajo", "Discusión de proyectos", new Date(), new Time(System.currentTimeMillis()), grupo.getContactos());
        agenda.agregarReunion(reunion);

        List<Reunion> reuniones = agenda.getReuniones();
        assertEquals(1, reuniones.size());
        assertEquals("Reunión de Trabajo", reuniones.get(0).getTema());
    }

    @Test
    public void testEliminarAsistenteDeReunion() {
        Grupo grupo = new Grupo("Trabajo", Categoria.OFICINA);
        Contacto contacto = new Contacto("Pedro Gómez", "Pedro","Las americas","38728721","prueba124@gmail.com");
        grupo.agregarContacto(contacto);
        agenda.agregarGrupo(grupo);

        Reunion reunion = new Reunion("Reunión de Trabajo", "Discusión de proyectos", new Date(), new Time(System.currentTimeMillis()), grupo.getContactos());
        agenda.agregarReunion(reunion);

        agenda.eliminarAsistenteDeReunion("Reunión de Trabajo", "Pedro Gómez");

        List<Contacto> asistentes = agenda.getReuniones().get(0).getAsistentes();
        assertEquals(1, asistentes.size());
    }
}
