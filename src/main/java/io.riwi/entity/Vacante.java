package io.riwi.entity;

public class Vacante {
    private int id;
    private String titulo;
    private String descripcion;
    private String duracion;
    private String estado;
    private String tecnologia;
    private int idEmpresa;

    private Empresa empresaVacante;

    public Vacante() {
    }

    public Vacante(int id) {
        this.id = id;
    }

    public Vacante(int id, String titulo, String descripcion, String duracion, String estado, String tecnologia, int idEmpresa) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = estado;
        this.tecnologia = tecnologia;
        this.idEmpresa = idEmpresa;
    }

    public Vacante(String titulo, String descripcion, String duracion, String estado, String tecnologia, int idEmpresa, Empresa empresaVacante) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.estado = estado;
        this.tecnologia = tecnologia;
        this.empresaVacante = empresaVacante;
        this.idEmpresa= idEmpresa;
    }

    public Vacante(String estado, String salario, Coder coder, Vacante vacante) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public Empresa getEmpresaVacante() {
        return empresaVacante;
    }

    public void setEmpresaVacante(Empresa empresaVacante) {
        this.empresaVacante = empresaVacante;
    }

    @Override
    public String toString() {
        return "\nVacante # " + id +
                "\nTitulo: '" + titulo + '\'' +
                ", description de la vacante: '" + descripcion + '\'' +
                ", duracion: '" + duracion + '\'' +
                ", estado: '" + estado + '\'' +
                ", tecnologia: '" + tecnologia + '\'' +
                ", info de la empresa: " + empresaVacante +"\n";
    }
}
