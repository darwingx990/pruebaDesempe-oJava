package io.riwi.controller;

import io.riwi.entity.Coder;
import io.riwi.entity.Contratacion;
import io.riwi.entity.Empresa;
import io.riwi.entity.Vacante;
import io.riwi.model.ModelCoder;
import io.riwi.model.ModelContratacion;
import io.riwi.model.ModelEmpresa;
import io.riwi.model.ModelVacante;
import io.riwi.utils.Utils;

import javax.swing.*;

public class ControllerContratacion {
    public static void listarContrataciones() {
        String listaContrataciones = """
                ========================
                  LISTA CONTRATACIONES
                ========================
                """;
        for (Contratacion contratacion : ModelContratacion.listarContrataciones()) {
            listaContrataciones += contratacion;
        }
        JOptionPane.showMessageDialog(null, listaContrataciones);
    }

    public static void insertarContratacion() {

        String estado = JOptionPane.showInputDialog("Ingrese el estado de la contratacion:");
        String salario = JOptionPane.showInputDialog("Ingrese el salario:");

        Object[] options = Utils.listToArray(ModelCoder.listarCoder());
        Coder coder = (Coder) JOptionPane.showInputDialog(null, "Seleccione el coder:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        Object[] options2 = Utils.listToArray(ModelVacante.listarVancante());
        Vacante vacante = (Vacante) JOptionPane.showInputDialog(null, "Seleccione la vacante:", "", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);


        Contratacion nuevaContratacion = new Contratacion(estado, salario, coder, vacante);

        ModelContratacion.agregarContratacion(nuevaContratacion);
//        JOptionPane.showMessageDialog(null, "Vancante agregada correctamente.");
    }

}
