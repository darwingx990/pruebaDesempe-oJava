package io.riwi.model;

import io.riwi.database.ConfigDB;
import io.riwi.entity.Coder;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelCoder {
    public static List<Coder> listarCoder() {
        List<Coder> coders = new ArrayList<>();
        PreparedStatement psCoder;
        ResultSet rsCoder;
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM coder ORDER BY id;";
        try {
            psCoder = connection.prepareStatement(sql);
            rsCoder = psCoder.executeQuery();

            while (rsCoder.next()) {
                Coder coder = new Coder();

                coder.setId(rsCoder.getInt("id"));
                coder.setNombre(rsCoder.getString("nombre"));
                coder.setApellido(rsCoder.getString("apellido"));
                coder.setDocumento(rsCoder.getString("documento"));
                coder.setCohorte(rsCoder.getInt("cohorte"));
                coder.setCv(rsCoder.getString("cv"));
                coder.setClan(rsCoder.getString("clan"));

                coders.add(coder);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar los datos. " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return coders;
    }

    public static boolean agregarCoder(Coder coder) {
        PreparedStatement psCoder;
        Connection connection = ConfigDB.openConnection();
        String sql = "INSERT INTO coder(nombre, apellido, documento,cohorte,cv, clan) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            psCoder = connection.prepareStatement(sql);

            psCoder.setString(1, coder.getNombre());
            psCoder.setString(2, coder.getApellido());
            psCoder.setString(3, coder.getDocumento());
            psCoder.setInt(4, coder.getCohorte());
            psCoder.setString(5, coder.getCv());
            psCoder.setString(6, coder.getClan());

            psCoder.execute();
            JOptionPane.showMessageDialog(null, "Coder agregado correctamente.");

            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar coder >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

    public static boolean modificarCoder(Coder coder) {
        PreparedStatement psCoder;
        Connection connection = ConfigDB.openConnection();
        String sql = "UPDATE coder SET nombre=?, apellido=?, documento=?,cohorte=?, cv=?, clan=? WHERE id=?;";
        try {
            psCoder = connection.prepareStatement(sql);

            psCoder.setString(1, coder.getNombre());
            psCoder.setString(2, coder.getApellido());
            psCoder.setString(3, coder.getDocumento());
            psCoder.setInt(4, coder.getCohorte());
            psCoder.setString(5, coder.getCv());
            psCoder.setString(6, coder.getClan());
            psCoder.setInt(7, coder.getId());

            psCoder.execute();
            JOptionPane.showMessageDialog(null, "Coder actualizado correctamente.");
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al modificar coder >>" + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }

    public static boolean eliminarCoder(Coder coder) {
        PreparedStatement psCoder;
        Connection connection = ConfigDB.openConnection();
        String sql = "DELETE FROM coder WHERE id=?;";
        try {
            psCoder = connection.prepareStatement(sql);
            psCoder.setInt(1, coder.getId());
            psCoder.execute();
            JOptionPane.showMessageDialog(null,"Registro eliminado exitosamente");
            return true;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar Coder >> " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return false;
    }



}

