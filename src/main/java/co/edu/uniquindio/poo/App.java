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
                default -> JOptionPane.showMessageDialog(null, "Opción no válida.");
            }
        } while (opcion != 15);
    }
    private static String menuPrincipal() {
        return "1. Agregar Contacto\n" +
               "2. Mostrar Contactos\n" +
               "3. Eliminar Contacto\n" +
               "4. Modificar Contacto\n" +
               "5. Agregar Grupo\n" +
               "6. Eliminar Grupo\n" +
               "7. Mostrar Grupos\n" +
               "8. Agregar Reunión\n" +
               "9. Mostrar Reunión\n" +
               "10. Eliminar Asistente de una reunión\n" +
               "11. Agregar Contacto a Grupo\n" +
               "12. Mostrar Contactos de Grupo\n" +
               "13. Eliminar Contacto de un Grupo\n" +
               "14. Agregar Asistente a una reunión\n" +
               "15. Salir\n";
    }

    private static void agregarContacto(Agenda agenda) {
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del contacto:");
        String alias = JOptionPane.showInputDialog("Ingrese el alias del contacto:");
        String direccion = JOptionPane.showInputDialog("Ingrese la dirección del contacto:");
        String telefono = JOptionPane.showInputDialog("Ingrese el teléfono del contacto:");
        String email = JOptionPane.showInputDialog("Ingrese el email del contacto:");

        Contacto nuevoContacto = new Contacto(nombre, alias, direccion, telefono, email);
        agenda.agregarContacto(nuevoContacto);
        JOptionPane.showMessageDialog(null, "Contacto agregado.");
    }

    private static void eliminarContacto(Agenda agenda) {
        String nombreEliminar = JOptionPane.showInputDialog("Ingrese el nombre del contacto a eliminar:");
        if (agenda.eliminarContacto(nombreEliminar)) {
            JOptionPane.showMessageDialog(null, "Contacto eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
        }
    }

    private static void modificarContacto(Agenda agenda) {
        String nombreModificar = JOptionPane.showInputDialog("Ingrese el nombre del contacto a modificar:");
        String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre del contacto:");
        String nuevoAlias = JOptionPane.showInputDialog("Ingrese el nuevo alias del contacto:");
        String nuevaDireccion = JOptionPane.showInputDialog("Ingrese la nueva dirección del contacto:");
        String nuevoTelefono = JOptionPane.showInputDialog("Ingrese el nuevo teléfono del contacto:");
        String nuevoEmail = JOptionPane.showInputDialog("Ingrese el nuevo email del contacto:");

        Contacto contactoModificado = new Contacto(nuevoNombre, nuevoAlias, nuevaDireccion, nuevoTelefono, nuevoEmail);
        if (agenda.modificarContacto(nombreModificar, contactoModificado)) {
            JOptionPane.showMessageDialog(null, "Contacto modificado.");
        } else {
            JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
        }
    }

    private static void agregarGrupo(Agenda agenda) {
        String nombreGrupo = JOptionPane.showInputDialog("Ingrese el nombre del grupo:");
        String categoriaString = JOptionPane.showInputDialog("Ingrese la categoría del grupo (FIESTA/OFICINA/AMIGOS/FAMILIA):");
        Categoria categoria = Categoria.valueOf(categoriaString.toUpperCase());
        Grupo grupo = new Grupo(nombreGrupo, categoria);
        agenda.agregarGrupo(grupo);
        JOptionPane.showMessageDialog(null, "Grupo agregado.");
    }

    private static void eliminarGrupo(Agenda agenda) {
        String nombreGrupoEliminar = JOptionPane.showInputDialog("Ingrese el nombre del grupo a eliminar:");
        if (agenda.eliminarGrupo(nombreGrupoEliminar)) {
            JOptionPane.showMessageDialog(null, "Grupo eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Grupo no encontrado.");
        }
    }

    private static void agregarReunion(Agenda agenda) {
        String nombreGrupoReunion = JOptionPane.showInputDialog("Ingrese el nombre del grupo para la reunión:");
        Grupo grupoReunion = agenda.obtenerGrupoPorNombre(nombreGrupoReunion);
        if (grupoReunion != null) {
            String tema = JOptionPane.showInputDialog("Ingrese el tema de la reunión:");
            String descripcion = JOptionPane.showInputDialog("Ingrese la descripción de la reunión:");
            String fechaString = JOptionPane.showInputDialog("Ingrese la fecha de la reunión (YYYY-MM-DD):");
            Date fecha = null;
            try {
                fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaString);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de fecha inválido.");
                return;
            }

            Time hora = new Time(new Date().getTime()); // Usa la hora actual

            Reunion reunion = new Reunion(tema, descripcion, fecha, hora, grupoReunion.getContactos());
            agenda.agregarReunion(reunion);
            JOptionPane.showMessageDialog(null, "Reunión agregada.");
        } else {
            JOptionPane.showMessageDialog(null, "Grupo no encontrado.");
        }
    }

    private static void eliminarAsistenteDeReunion(Agenda agenda) {
        String temaReunionEliminarAsistente = JOptionPane.showInputDialog("Ingrese el tema de la reunión de la que desea eliminar el asistente:");
        String nombreContactoEliminarAsistente = JOptionPane.showInputDialog("Ingrese el nombre del contacto a eliminar:");
        agenda.eliminarAsistenteDeReunion(temaReunionEliminarAsistente, nombreContactoEliminarAsistente);
    }

    private static void agregarContactoAGrupo(Agenda agenda) {
        String nombreContacto = JOptionPane.showInputDialog("Ingrese el nombre del contacto a agregar al grupo:");
        Contacto contacto = agenda.getContactos().stream()
                .filter(c -> c.getNombre().equalsIgnoreCase(nombreContacto))
                .findFirst()
                .orElse(null);
        if (contacto != null) {
            String nombreGrupoAgregar = JOptionPane.showInputDialog("Ingrese el nombre del grupo al que agregar el contacto:");
            Grupo grupoAgregar = agenda.getGrupos().stream()
                    .filter(g -> g.getNombre().equalsIgnoreCase(nombreGrupoAgregar))
                    .findFirst()
                    .orElse(null);
            if (grupoAgregar != null) {
                grupoAgregar.agregarContacto(contacto);
                JOptionPane.showMessageDialog(null, "Contacto agregado al grupo.");
            } else {
                JOptionPane.showMessageDialog(null, "Grupo no encontrado.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Contacto no encontrado.");
        }
    }

    private static void mostrarContactosDeGrupo(Agenda agenda) {
        String nombreGrupoMostrarContactos = JOptionPane.showInputDialog("Ingrese el nombre del grupo para mostrar los contactos:");
        agenda.mostrarContactosDeGrupo(nombreGrupoMostrarContactos);
    }

    private static void eliminarContactoDeGrupo(Agenda agenda) {
        String nombreGrupoEliminarContacto = JOptionPane.showInputDialog("Ingrese el nombre del grupo del que desea eliminar el contacto:");
        String nombreContactoEliminar = JOptionPane.showInputDialog("Ingrese el nombre del contacto a eliminar:");
        agenda.eliminarContactoDeGrupo(nombreGrupoEliminarContacto, nombreContactoEliminar);
    }

    private static void agregarAsistenteAReunion(Agenda agenda) {
        String temaReunionAgregarAsistente = JOptionPane.showInputDialog("Ingrese el tema de la reunión a la que desea agregar el asistente:");
        String nombreContactoAgregarAsistente = JOptionPane.showInputDialog("Ingrese el nombre del contacto a agregar:");
        agenda.agregarContactoAReunion(temaReunionAgregarAsistente, nombreContactoAgregarAsistente);
    }
}