package co.edu.uniquindio.poo.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reunion {
    // Atributos de la clase
    private String tema;            // Tema de la reunión
    private String descripcion;     // Descripción de la reunión
    private Date fecha;             // Fecha de la reunión
    private Time hora;              // Hora de la reunión
    private List<Contacto> asistentes;  // Lista de asistentes a la reunión

    /**
     * Constructor principal de la clase Reunion.
     * @param tema Tema de la reunión.
     * @param descripcion Descripción de la reunión.
     * @param fecha Fecha de la reunión.
     * @param hora Hora de la reunión.
     * @param asistentes Lista de contactos que asistirán a la reunión.
     */
    public Reunion(String tema, String descripcion, Date fecha, Time hora, List<Contacto> asistentes) {
        this.tema = tema;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.asistentes = new ArrayList<>(asistentes);
    }

    /**
     * Agrega un asistente a la reunión.
     * @param contacto El contacto a agregar a la lista de asistentes.
     */
    public void agregarAsistente(Contacto contacto) {
        if (!asistentes.contains(contacto)) {
            asistentes.add(contacto);
        }
    }

    /**
     * Elimina un asistente de la reunión.
     * @param contacto El contacto a eliminar de la lista de asistentes.
     */
    public void eliminarAsistente(Contacto contacto) {
        asistentes.remove(contacto);
    }

    /**
     * Obtiene la descripción de la reunión.
     * @return La descripción de la reunión.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece la descripción de la reunión.
     * @param descripcion La nueva descripción de la reunión.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la fecha de la reunión.
     * @return La fecha de la reunión.
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la reunión.
     * @param fecha La nueva fecha de la reunión.
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene la hora de la reunión.
     * @return La hora de la reunión.
     */
    public Time getHora() {
        return hora;
    }

    /**
     * Establece la hora de la reunión.
     * @param hora La nueva hora de la reunión.
     */
    public void setHora(Time hora) {
        this.hora = hora;
    }

    /**
     * Obtiene la lista de asistentes de la reunión.
     * @return La lista de asistentes.
     */
    public List<Contacto> getAsistentes() {
        return asistentes;
    }

    /**
     * Establece la lista de asistentes de la reunión.
     * @param asistentes La nueva lista de asistentes.
     */
    public void setAsistentes(List<Contacto> asistentes) {
        this.asistentes = asistentes;
    }

    /**
     * Obtiene el tema de la reunión.
     * @return El tema de la reunión.
     */
    public String getTema() {
        return tema;
    }

    /**
     * Establece el tema de la reunión.
     * @param tema El nuevo tema de la reunión.
     */
    public void setTema(String tema) {
        this.tema = tema;
    }

    /**
     * Retorna una representación en cadena de la reunión.
     * @return Una cadena con la información de la reunión.
     */
    @Override
    public String toString() {
        return "Reunion: " +
                ", tema: '" + tema + '\'' +
                ", descripcion: " + descripcion +
                ", fecha: " + fecha +
                ", hora: " + hora +
                ", asistentes: " + asistentes;
    }
}
