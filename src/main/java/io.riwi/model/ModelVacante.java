package io.riwi.model;

import io.riwi.database.ConfigDB;
import io.riwi.entity.Coder;
import io.riwi.entity.Empresa;
import io.riwi.entity.Vacante;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelVacante {
    public static List<Vacante> listarVancante() {
        List<Vacante> vacantes = new ArrayList<>();
        PreparedStatement psVacante;
        ResultSet rsVacante;
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM vacante INNER JOIN empresa ON vacante.fk_id_empresa = empresa.id;";
        try {
            psVacante = connection.prepareStatement(sql);
            rsVacante = psVacante.executeQuery();

            while (rsVacante.next()) {
                Vacante vacante = new Vacante();
                Empresa empresa = new Empresa();

                vacante.setId(rsVacante.getInt("vacante.id"));
                vacante.setDescripcion(rsVacante.getString("vacante.descripcion"));
                vacante.setDuracion(rsVacante.getString("vacante.duracion"));
                vacante.setEstado(rsVacante.getString("vacante.estado"));
                vacante.setTecnologia(rsVacante.getString("vacante.tecnologia"));
                vacante.setTitulo(rsVacante.getString("vacante.titulo"));
                System.out.println("llegue hasta aqui.");

                empresa.setId(rsVacante.getInt("id"));
                empresa.setNombre(rsVacante.getString("empresa.nombre"));
                empresa.setSector(rsVacante.getString("empresa.sector"));
                empresa.setUbicacion(rsVacante.getString("empresa.ubicacion"));
                empresa.setContacto(rsVacante.getString("empresa.contacto"));
                vacante.setEmpresaVacante(empresa);
                vacantes.add(vacante);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar los datos. " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return vacantes;
    }

    public static boolean agregarVacante(Vacante vacante) {
        PreparedStatement psVacante;
        Connection connection = ConfigDB.openConnection();
        String sql = "INSERT INTO vacante(titulo, descripcion, duracion,estado,tecnologia, fk_id_empresa) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            psVacante = connection.prepareStatement(sql);

            psVacante.setString(1, vacante.getTitulo());
            psVacante.setString(2, vacante.getDescripcion());
            psVacante.setString(3, vacante.getDuracion());
            psVacante.setString(4, vacante.getEstado());
            psVacante.setString(5, vacante.getTecnologia());
            psVacante.setInt(6, vacante.getIdEmpresa());

            psVacante.execute();
            JOptionPane.showMessageDialog(null, "Registro agregado correctamente.");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar coder >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

    public static boolean modificarVacante(Vacante vacante) {
        PreparedStatement psVacante;
        Connection connection = ConfigDB.openConnection();
        String sql = "UPDATE vacante SET titulo=?, descripcion=?, duracion=?,estado=?, tecnologia=?, fk_id_empresa=? WHERE id=?;";
        try {
            System.out.println(vacante);
            psVacante = connection.prepareStatement(sql);

            psVacante.setString(1, vacante.getTitulo());
            psVacante.setString(2, vacante.getDescripcion());
            psVacante.setString(3, vacante.getDuracion());
            psVacante.setString(4, vacante.getEstado());
            psVacante.setString(5, vacante.getTecnologia());
            psVacante.setInt(6, vacante.getIdEmpresa());
            psVacante.setInt(7, vacante.getId());

            psVacante.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado correctamente.");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar vacante >>" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

    public static boolean eliminarVacante(Vacante vacante) {
        PreparedStatement psVacante;
        Connection connection = ConfigDB.openConnection();
        String sql = "DELETE FROM vacante WHERE id=?;";
        try {
            psVacante = connection.prepareStatement(sql);
            psVacante.setInt(1, vacante.getId());
            psVacante.execute();
            JOptionPane.showMessageDialog(null,"Registro eliminado exitosamente");
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Vacante >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }



}

