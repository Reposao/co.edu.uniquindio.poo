package co.edu.uniquindio.poo;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import co.edu.uniquindio.poo.model.Agenda;
import co.edu.uniquindio.poo.model.Categoria;
import co.edu.uniquindio.poo.model.Contacto;
import co.edu.uniquindio.poo.model.Grupo;
import co.edu.uniquindio.poo.model.Reunion;

public class App {

    /**
     * Método principal de la aplicación. 
     * Inicia la agenda y maneja la interacción del usuario con el menú principal.
     *
     * @param args Argumentos de línea de comando (no se utilizan).
     */
    public static void main(String[] args) {
        // Crear una instancia de Agenda
        Agenda agenda = new Agenda();

        // Agregar contactos y grupos iniciales
        agenda.agregarContacto(new Contacto("Juan Pérez", "Juanito", "Calle 1", "3001234567", "juan.perez@example.com"));
        agenda.agregarContacto(new Contacto("María López", "Mari", "Calle 2", "3007654321", "maria.lopez@example.com"));
        agenda.agregarGrupo(new Grupo("Amigos", Categoria.FIESTA));
        agenda.agregarGrupo(new Grupo("Trabajo", Categoria.OFICINA));

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menuPrincipal()));
            switch (opcion) {
                case 1 -> agregarContacto(agenda);
                case 2 -> agenda.mostrarContactos();
                case 3 -> eliminarContacto(agenda);
                case 4 -> modificarContacto(agenda);
                case 5 -> agregarGrupo(agenda);
                case 6 -> eliminarGrupo(agenda);
                case 7 -> agenda.mostrarGrupos();
                case 8 -> agregarReunion(agenda);
                case 9 -> agenda.mostrarReuniones();
                case 10 -> eliminarAsistenteDeReunion(agenda);
                case 11 -> agregarContactoAGrupo(agenda);
                case 12 -> mostrarContactosDeGrupo(agenda);
                case 13 -> eliminarContactoDeGrupo(agenda);
                case 14 -> agregarAsistenteAReunion(agenda);
                case 15 -> JOptionPane.showMessageDialog(null, "Saliendo...");
                default -> JOptionPane.showMessageDialog(null, "Opción no válida, por favor intente de nuevo.");
            }
        } while (opcion != 15);
    }

    /**
     * Muestra el menú principal de la aplicación.
     *
     * @return String con las opciones del menú.
     */
    public static String menuPrincipal() {
        return "Menú principal:\n" +
                "1. Agregar Contacto\n" +
                "2. Mostrar Contactos\n" +
                "3. Eliminar Contacto\n" +
                "4. Modificar Contacto\n" +
                "5. Agregar Grupo\n" +
                "6. Eliminar Grupo\n" +
                "7. Mostrar Grupos\n" +
                "8. Agregar Reunión\n" +
                "9. Mostrar Reuniones\n" +
                "10. Eliminar Asistente de Reunión\n" +
                "11. Agregar Contacto a Grupo\n" +
                "12. Mostrar Contactos de Grupo\n" +
                "13. Eliminar Contacto de Grupo\n" +
                "14. Agregar Asistente a Reunión\n" +
                "15. Salir";
    }

    /**
     * Solicita al usuario los datos para agregar un nuevo contacto a la agenda.
     *
     * @param agenda La agenda a la cual se añadirá el contacto.
     */
    public static void agregarContacto(Agenda agenda) {
        // Implementación de la lógica para agregar un contacto
    }

    /**
     * Solicita al usuario los datos para eliminar un contacto de la agenda.
     *
     * @param agenda La agenda de la cual se eliminará el contacto.
     */
    public static void eliminarContacto(Agenda agenda) {
        // Implementación de la lógica para eliminar un contacto
    }

    /**
     * Solicita al usuario los datos para modificar un contacto existente en la agenda.
     *
     * @param agenda La agenda donde se encuentra el contacto a modificar.
     */
    public static void modificarContacto(Agenda agenda) {
        // Implementación de la lógica para modificar un contacto
    }

    /**
     * Solicita al usuario los datos para agregar un nuevo grupo a la agenda.
     *
     * @param agenda La agenda a la cual se añadirá el grupo.
     */
    public static void agregarGrupo(Agenda agenda) {
        // Implementación de la lógica para agregar un grupo
    }

    /**
     * Solicita al usuario los datos para eliminar un grupo de la agenda.
     *
     * @param agenda La agenda de la cual se eliminará el grupo.
     */
    public static void eliminarGrupo(Agenda agenda) {
        // Implementación de la lógica para eliminar un grupo
    }

    /**
     * Solicita al usuario los datos para agregar una nueva reunión a la agenda.
     *
     * @param agenda La agenda a la cual se añadirá la reunión.
     */
    public static void agregarReunion(Agenda agenda) {
        // Implementación de la lógica para agregar una reunión
    }

    /**
     * Solicita al usuario los datos para eliminar un asistente de una reunión en la agenda.
     *
     * @param agenda La agenda que contiene la reunión.
     */
    public static void eliminarAsistenteDeReunion(Agenda agenda) {
        // Implementación de la lógica para eliminar un asistente de una reunión
    }

    /**
     * Solicita al usuario los datos para agregar un contacto a un grupo en la agenda.
     *
     * @param agenda La agenda que contiene el grupo.
     */
    public static void agregarContactoAGrupo(Agenda agenda) {
        // Implementación de la lógica para agregar un contacto a un grupo
    }

    /**
     * Muestra los contactos que pertenecen a un grupo específico.
     *
     * @param agenda La agenda que contiene los grupos y contactos.
     */
    public static void mostrarContactosDeGrupo(Agenda agenda) {
        // Implementación de la lógica para mostrar los contactos de un grupo
    }

    /**
     * Solicita al usuario los datos para eliminar un contacto de un grupo en la agenda.
     *
     * @param agenda La agenda que contiene el grupo.
     */
    public static void eliminarContactoDeGrupo(Agenda agenda) {
        // Implementación de la lógica para eliminar un contacto de un grupo
    }

    /**
     * Solicita al usuario los datos para agregar un asistente a una reunión en la agenda.
     *
     * @param agenda La agenda que contiene la reunión.
     */
    public static void agregarAsistenteAReunion(Agenda agenda) {
        // Implementación de la lógica para agregar un asistente a una reunión
    }
}
