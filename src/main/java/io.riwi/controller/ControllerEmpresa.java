package io.riwi.controller;

import io.riwi.entity.Coder;
import io.riwi.entity.Empresa;
import io.riwi.model.ModelCoder;
import io.riwi.model.ModelEmpresa;

import javax.swing.*;

public class ControllerEmpresa {
    public static void listarEmpresa() {
        String listaEmpresas = """
                =========================
                   LISTADO DE EMPRESAS
                =========================
                """;

        for (Empresa empresa : ModelEmpresa.listarEmpresas()) {
            listaEmpresas += empresa;
        }
        JOptionPane.showMessageDialog(null, listaEmpresas);
    }

}
