package app;

public class Equipo {
   private int id_equipo;
   private String nombre;
   private String sede;
   private String direccion;
   private String celular;

    public Equipo(int id_equipo, String nombre, String sede, String direccion, String celular) {
        this.id_equipo = id_equipo;
        this.nombre = nombre;
        this.sede = sede;
        this.direccion = direccion;
        this.celular = celular;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
