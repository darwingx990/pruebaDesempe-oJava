package io.riwi.entity;

public class Contratacion {
    private int id;
    private int idVacante;
    private int idCoder;
    private String fechaAplicacion;
    private String estado;
    private float salario;

    private Vacante objVacante;
    private Coder objCoder;

    public Contratacion(){

    }

    public Contratacion(int id) {
        this.id = id;
    }

    public Contratacion(int id, int idVacante, int idCoder, String fechaAplicacion, String estado, float salario) {
        this.id = id;
        this.idVacante = idVacante;
        this.idCoder = idCoder;
        this.fechaAplicacion = fechaAplicacion;
        this.estado = estado;
        this.salario = salario;
    }

    public Contratacion(int id, int idVacante, int idCoder, String fechaAplicacion, String estado, float salario, Vacante objVacante, Coder objCoder) {
        this.id = id;
        this.idVacante = idVacante;
        this.idCoder = idCoder;
        this.fechaAplicacion = fechaAplicacion;
        this.estado = estado;
        this.salario = salario;
        this.objVacante = objVacante;
        this.objCoder = objCoder;
    }

    public Contratacion(String estado, String salario, Coder coder, Vacante vacante) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVacante() {
        return idVacante;
    }

    public void setIdVacante(int idVacante) {
        this.idVacante = idVacante;
    }

    public int getIdCoder() {
        return idCoder;
    }

    public void setIdCoder(int idCoder) {
        this.idCoder = idCoder;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Vacante getObjVacante() {
        return objVacante;
    }

    public void setObjVacante(Vacante objVacante) {
        this.objVacante = objVacante;
    }

    public Coder getObjCoder() {
        return objCoder;
    }

    public void setObjCoder(Coder objCoder) {
        this.objCoder = objCoder;
    }

    @Override
    public String toString() {
        return "\nContratacion # " + id+
                "\nTitulo Vacante=" + objVacante.getTitulo() +
                ", Nombre Coder=" + objCoder.getNombre() +'\''+
                ", fecha de Aplicacion='" + fechaAplicacion + '\'' +
                ", estado='" + estado + '\'' +
                ", salario=" + salario;
    }
}
