package io.riwi.controller;

import io.riwi.entity.Coder;
import io.riwi.model.ModelCoder;
import io.riwi.utils.Utils;

import javax.swing.*;

public class ControllerCoder {
    public static void insertarCoder() {
//        Object[] optionsEstado = Utils.listToArray(["Activo", "Inactivo"])
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del coder:");
        String apellido = JOptionPane.showInputDialog("Ingrese apellido del coder:");
        String documento = JOptionPane.showInputDialog("Ingrese el documento del coder:");
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cohorte del coder:"));
        String cv = JOptionPane.showInputDialog("Ingrese perfil profesional del coder:");
        String clan = JOptionPane.showInputDialog("Ingrese el clan del coder:");

        Coder coder = new Coder(nombre, apellido, documento,cohorte,cv, clan);
        ModelCoder.agregarCoder(coder);
    }

    public static void listarPaciente() {
        String listaCoder = """
                ========================
                     LISTA CODERS
                ========================
                """;
//        List<Coder> listPacientes = ModelPaciente.listarPaciente();
        for (Coder coder : ModelCoder.listarCoder()) {
            listaCoder += coder;
        }
        JOptionPane.showMessageDialog(null, listaCoder);
    }

    public static void modificarPaciente() {
        Object[] options = Utils.listToArray(ModelCoder.listarCoder());
        Coder coderModificar = (Coder) JOptionPane.showInputDialog(null, "Seleecione el Coder que quiere modificar:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del coder:");
        String apellido = JOptionPane.showInputDialog("Ingrese apellido del coder:");
        String documento = JOptionPane.showInputDialog("Ingrese el documento del coder:");
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cohorte del coder:"));
        String cv = JOptionPane.showInputDialog("Ingrese perfil profesional del coder:");
        String clan = JOptionPane.showInputDialog("Ingrese el clan del coder:");

        coderModificar.setNombre(nombre);
        coderModificar.setApellido(apellido);
        coderModificar.setDocumento(documento);
        coderModificar.setCohorte(cohorte);
        coderModificar.setCv(cv);
        coderModificar.setClan(clan);

        ModelCoder.modificarCoder(coderModificar);
    }

    public static void deleteCoder() {
        Object[] options = Utils.listToArray(ModelCoder.listarCoder());
        Coder coderEliminar = (Coder) JOptionPane.showInputDialog(null, "Seleecione un paciente:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        ModelCoder.eliminarCoder(coderEliminar);
    }
}
