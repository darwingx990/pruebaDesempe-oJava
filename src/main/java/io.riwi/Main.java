package io.riwi;

import io.riwi.controller.ControllerCoder;
import io.riwi.controller.ControllerContratacion;
import io.riwi.controller.ControllerEmpresa;
import io.riwi.controller.ControllerVacante;
import io.riwi.model.ModelVacante;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int option1 = 0, option2 = 0;

        do {
            try {
                option1 = Integer.parseInt(JOptionPane.showInputDialog("""
                        =========================
                         AGENCIA DE EMPLEOS RIWI
                        =========================
                        1. Administrar Coders
                        2. Administrar Vacantes
                        3. Mostrar Empresas
                        4. Administrar Contrataciones
                        5. Salir
                                            
                        Ingrese una opción:
                        """));

                switch (option1) {
                    case 1:
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Agregar Coder
                                2. Listar Coder
                                3. Actualizar Coder
                                4. Eliminar Coder
                                5. Regresar
                                                    
                                Ingrese un opción:
                                """));
                        switch (option2) {
                            case 1:
                                ControllerCoder.insertarCoder();
                                break;

                            case 2:
                                ControllerCoder.listarPaciente();
                                break;

                            case 3:
                                ControllerCoder.modificarPaciente();
                                break;

                            case 4:
                                ControllerCoder.deleteCoder();
                                break;

                            case 5:
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no valida.");
                                break;
                        }
                        break;

                    case 2:
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Agregar Vacante
                                2. Listar Vacantes
                                3. Actualizar Vacante
                                4. Eliminar Vacante
                                5. Regresar
                                                    
                                Ingrese un opción:
                                """));
                        switch (option2) {
                            case 1:
                                ControllerVacante.insertarVacante();
                                break;

                            case 2:
                                ControllerVacante.listarVacante();
                                break;

                            case 3:
                                ControllerVacante.modificarVacante();
                                break;

                            case 4:
                                ControllerVacante.deleteVacante();
                                break;

                            case 5:
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no valida.");
                                break;
                        }
                        break;
                    case 3:
                        ControllerEmpresa.listarEmpresa();

                    case 4:
                        option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                1. Agregar Contratación
                                2. Listar Contrataciones
                                3. Actualizar Contratación
                                4. Eliminar Contratación
                                5. Regresar
                                                    
                                Ingrese un opción:
                                """));
                        switch (option2) {
                            case 1:
                                ControllerContratacion.insertarContratacion();
                                break;

                            case 2:
                                ControllerContratacion.listarContrataciones();
                                break;



                            case 5:
                                break;

                            default:
                                JOptionPane.showMessageDialog(null, "Opcion no valida.");
                                break;
                        }
                        break;

                    case 5:
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida. Intentalo nuevamente.");
                        break;
                }
            } catch (Exception error) {
                JOptionPane.showMessageDialog(null, "Opcion no valida. Intentalo nuevamente.");
            }
        } while (option1 != 5);
        JOptionPane.showMessageDialog(null, "Gracias por utilizar nuestros servicios. Hasta pronto 👍");
    }
}