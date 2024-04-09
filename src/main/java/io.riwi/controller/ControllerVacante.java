package io.riwi.controller;

import io.riwi.entity.Coder;
import io.riwi.entity.Empresa;
import io.riwi.entity.Vacante;
import io.riwi.model.ModelCoder;
import io.riwi.model.ModelEmpresa;
import io.riwi.model.ModelVacante;
import io.riwi.utils.Utils;

import javax.swing.*;

public class ControllerVacante {
    public static void insertarVacante() {
        //List<String> estados;
//    String estado = "Activo";
//    String estado2 = "Innactivo";
        //        Object[] optionsEstado = Utils.listToArray(["Activo", "Inactivo"])

        String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la vacante:");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion de la vacante:");
        String duracion = JOptionPane.showInputDialog("Ingrese la duracion de la vacante:");
        String estado = JOptionPane.showInputDialog("Ingrese el estado de la vacante:");
        String tecnologia = JOptionPane.showInputDialog("Ingrese la tecnologia de la vacante:");

        Object[] options = Utils.listToArray(ModelEmpresa.listarEmpresas());
        Empresa empresaVacante = (Empresa) JOptionPane.showInputDialog(null, "Seleccione una empresa:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        Vacante nuevaVacante = new Vacante(titulo, descripcion, duracion, estado,tecnologia,empresaVacante.getId(), empresaVacante);

        ModelVacante.agregarVacante(nuevaVacante);
//        JOptionPane.showMessageDialog(null, "Vancante agregada correctamente.");
    }

    public static void listarVacante() {
        String listaVacantes = """
                ========================
                     LISTA VACANTES
                ========================
                """;
        for (Vacante vacante : ModelVacante.listarVancante()) {
            listaVacantes += vacante;
        }
        JOptionPane.showMessageDialog(null, listaVacantes);
    }

    public static void modificarVacante() {
        Object[] options = Utils.listToArray(ModelVacante.listarVancante());
        Vacante vacanteModificar = (Vacante) JOptionPane.showInputDialog(null, "Seleecione la vacante que desea modificar:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        String titulo = JOptionPane.showInputDialog("Ingrese el titulo de la vacante:");
        String descripcion = JOptionPane.showInputDialog("Ingrese la descripcion de la vacante:");
        String duracion = JOptionPane.showInputDialog("Ingrese la duracion de la vacante:");
        String estado = JOptionPane.showInputDialog("Ingrese el estado de la vacante:");
        String tecnologia = JOptionPane.showInputDialog("Ingrese la tecnologia de la vacante:");

        Object[] options2 = Utils.listToArray(ModelEmpresa.listarEmpresas());
        Empresa empresaVacante = (Empresa) JOptionPane.showInputDialog(null, "Seleccione una empresa:", "", JOptionPane.QUESTION_MESSAGE, null, options2, options2[0]);

        vacanteModificar.setTitulo(titulo);
        vacanteModificar.setDescripcion(descripcion);
        vacanteModificar.setDuracion(duracion);
        vacanteModificar.setEstado(estado);
        vacanteModificar.setTecnologia(tecnologia);
        vacanteModificar.setEmpresaVacante(empresaVacante);
        vacanteModificar.setIdEmpresa(empresaVacante.getId());

        ModelVacante.modificarVacante(vacanteModificar);
    }

    public static void deleteVacante() {
        Object[] options = Utils.listToArray(ModelVacante.listarVancante());
        Vacante vacanteEliminar = (Vacante) JOptionPane.showInputDialog(null, "Seleecione la vacante a eliminar:", "", JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        ModelVacante.eliminarVacante(vacanteEliminar);
    }
}
