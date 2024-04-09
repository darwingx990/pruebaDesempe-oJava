package io.riwi.model;

import io.riwi.database.ConfigDB;
import io.riwi.entity.Empresa;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelEmpresa {
    public static List<Empresa> listarEmpresas() {
        List<Empresa> listEmpresas = new ArrayList<>();
        PreparedStatement psEmpresa;
        ResultSet rsEmpresa;
        Connection connection = ConfigDB.openConnection();
        String sql = "SELECT * FROM empresa ORDER BY nombre;";
        try {
            psEmpresa = connection.prepareStatement(sql);
            rsEmpresa = psEmpresa.executeQuery();

            while (rsEmpresa.next()) {
                Empresa empresa = new Empresa();

                empresa.setId(rsEmpresa.getInt("id"));
                empresa.setNombre(rsEmpresa.getString("nombre"));
                empresa.setSector(rsEmpresa.getString("sector"));
                empresa.setUbicacion(rsEmpresa.getString("ubicacion"));
                empresa.setContacto(rsEmpresa.getString("contacto"));

                listEmpresas.add(empresa);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al mostrar los datos. " + e.getMessage());
        } finally {
            ConfigDB.closeConnection();
        }
        return listEmpresas;
    }

}

