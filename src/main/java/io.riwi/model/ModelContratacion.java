package io.riwi.model;

import io.riwi.database.ConfigDB;
import io.riwi.entity.Coder;
import io.riwi.entity.Contratacion;
import io.riwi.entity.Vacante;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ModelContratacion {
    public static List<Contratacion> listarContrataciones() {
        List<Contratacion> Contrataciones = new ArrayList<>();
        PreparedStatement psContratacion;
        ResultSet rsContractacion;
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM contratacion INNER JOIN vacante ON vacante.id= contratacion.fk_id_vacante " +
                "INNER JOIN coder ON coder.id = contratacion.fk_id_coder;";
        try {
            psContratacion = connection.prepareStatement(sql);
            rsContractacion = psContratacion.executeQuery();

            while (rsContractacion.next()) {
                Contratacion contratacion = new Contratacion();
                Vacante vacante = new Vacante();
                Coder coder = new Coder();

                contratacion.setId(rsContractacion.getInt("Contratacion.id"));
                contratacion.setFechaAplicacion(rsContractacion.getString("Contratacion.fecha_aplicacion"));
                contratacion.setEstado(rsContractacion.getString("Contratacion.estado"));
                contratacion.setIdVacante(rsContractacion.getInt("Contratacion.fk_id_vacante"));
                contratacion.setIdCoder(rsContractacion.getInt("Contratacion.fk_id_coder"));
                contratacion.setSalario(rsContractacion.getFloat("Contratacion.salario"));


                coder.setId(rsContractacion.getInt("coder.id"));
                coder.setNombre(rsContractacion.getString("coder.nombre"));
                coder.setApellido(rsContractacion.getString("coder.apellido"));
                coder.setDocumento(rsContractacion.getString("coder.documento"));
                coder.setCohorte(rsContractacion.getInt("coder.cohorte"));
                coder.setCv(rsContractacion.getString("coder.cv"));
                coder.setClan(rsContractacion.getString("coder.clan"));


                vacante.setId(rsContractacion.getInt("Vacante.id"));
                vacante.setTitulo(rsContractacion.getString("Vacante.titulo"));
                vacante.setDescripcion(rsContractacion.getString("Vacante.descripcion"));
                vacante.setDuracion(rsContractacion.getString("Vacante.duracion"));
                vacante.setEstado(rsContractacion.getString("Vacante.estado"));
                vacante.setTecnologia(rsContractacion.getString("Vacante.tecnologia"));
                vacante.setIdEmpresa(rsContractacion.getInt("Vacante.fk_id_empresa"));

                contratacion.setObjCoder(coder);
                contratacion.setObjVacante(vacante);
                Contrataciones.add(contratacion);
            }
            JOptionPane.showMessageDialog(null, Contrataciones);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar los datos. " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return Contrataciones;
    }

    public static boolean agregarContratacion(Contratacion contratacion) {
        PreparedStatement psContratacion;

        Connection connection = ConfigDB.openConnection();
        String sql = "INSERT INTO Contratacion(fk_id_vacante, fk_id_coder, fecha_aplicacion, estado, salario) VALUES (?, ?, ?, ?, ?);";
        try {
            psContratacion = connection.prepareStatement(sql);
            Vacante vacante = new Vacante();
            Coder coder = new Coder();

            psContratacion.setInt(1, contratacion.getIdVacante());
            psContratacion.setInt(2, contratacion.getIdCoder());
            psContratacion.setDate(3, Date.valueOf(contratacion.getFechaAplicacion()));
            psContratacion.setTime(4, Time.valueOf(contratacion.getEstado()));
            psContratacion.setFloat(5, contratacion.getSalario());
            psContratacion.execute();
            JOptionPane.showMessageDialog(null, "Registro agregado correctamente.");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar Contratacion >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

}

