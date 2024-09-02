import co.edu.uniquindio.tallerAgenda.model.Agenda;
import co.edu.uniquindio.tallerAgenda.model.Contacto;
import co.edu.uniquindio.tallerAgenda.model.Grupo;
import co.edu.uniquindio.tallerAgenda.model.Reunion;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AgendaTest {
    private Agenda agenda;

    @BeforeEach
    void setUp() {
        agenda = new Agenda();
    }

    @Test
    public void testAgregarContacto() {
        Contacto contacto = new Contacto("Juan", "123456789", "juan@example.com");
        agenda.agregarContacto(contacto);
        List<Contacto> contactos = agenda.getContactos();
        assertEquals(1, contactos.size());
        assertEquals("Juan", contactos.get(0).getNombre());
    }

    @Test
    public void testEliminarContacto() {
        Contacto contacto = new Contacto("Juan", "123456789", "juan@example.com");
        agenda.agregarContacto(contacto);
        boolean eliminado = agenda.eliminarContacto("Juan");
        assertTrue(eliminado);
        assertEquals(0, agenda.getContactos().size());
    }

    @Test
    public void testModificarContacto() {
        Contacto contacto = new Contacto("Juan", "123456789", "juan@example.com");
        agenda.agregarContacto(contacto);
        Contacto contactoModificado = new Contacto("Juan", "987654321", "juanNuevo@example.com");
        boolean modificado = agenda.modificarContacto("Juan", contactoModificado);
        assertTrue(modificado);
        assertEquals("987654321", agenda.getContactos().get(0).getTelefono());
    }

    @Test
    public void testAgregarGrupo() {
        Grupo grupo = new Grupo("Amigos");
        agenda.agregarGrupo(grupo);
        List<Grupo> grupos = agenda.getGrupos();
        assertEquals(1, grupos.size());
        assertEquals("Amigos", grupos.get(0).getNombre());
    }

    @Test
    public void testEliminarGrupo() {
        Grupo grupo = new Grupo("Amigos");
        agenda.agregarGrupo(grupo);
        boolean eliminado = agenda.eliminarGrupo("Amigos");
        assertTrue(eliminado);
        assertEquals(0, agenda.getGrupos().size());
    }

    @Test
    public void testAgregarReunion() {
        Reunion reunion = new Reunion("Reunión de Proyecto", "10/09/2024");
        agenda.agregarReunion(reunion);
        List<Reunion> reuniones = agenda.getReuniones();
        assertEquals(1, reuniones.size());
        assertEquals("Reunión de Proyecto", reuniones.get(0).getTema());
    }

    @Test
    public void testEliminarAsistenteDeReunion() {
        Contacto contacto = new Contacto("Juan", "123456789", "juan@example.com");
        agenda.agregarContacto(contacto);
        Reunion reunion = new Reunion("Reunión de Proyecto", "10/09/2024");
        agenda.agregarReunion(reunion);
        agenda.agregarContactoAReunion("Reunión de Proyecto", "Juan");
        agenda.eliminarAsistenteDeReunion("Reunión de Proyecto", "Juan");
        assertTrue(reunion.getAsistentes().isEmpty());
    }
}
