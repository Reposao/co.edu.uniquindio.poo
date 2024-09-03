
import java.sql.Time;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
