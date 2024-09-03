package co.edu.uniquindio.poo.model;

public class Contacto {
            /**
     * Nombre del contacto.
     */
    public String nombre;

    /**
     * Alias del contacto.
     */
    public String alias;

    /**
     * Dirección del contacto.
     */
    public String direccion;

    /**
     * Teléfono del contacto.
     */
    public String telefono;

    /**
     * Correo electrónico del contacto.
     */
    public String email;

    /**
     * Constructor por defecto de la clase Contacto.
     */
    public Contacto() {
    }

    /**
     * Constructor que inicializa un contacto con todos sus atributos.
     *
     * @param nombre    Nombre del contacto.
     * @param alias     Alias del contacto.
     * @param direccion Dirección del contacto.
     * @param telefono  Teléfono del contacto.
     * @param email     Correo electrónico del contacto.
     */
    public Contacto(String nombre, String alias, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.alias = alias;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve una representación en cadena del contacto.
     *
     * @return Una cadena con la información del contacto.
     */
    @Override
    public String toString() {
        return "Contacto: " +
                "nombre='" + nombre + '\'' +
                ", alias='" + alias + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'';
    }
}
