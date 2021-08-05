package Controlador;

import Modelo.MatricularAlumnos;
import Modelo.SqlMatricularAlumnos;
import Vista.Login;
import Vista.MatricularAlumnosForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public abstract class ControlMatricularAlumnos implements ActionListener {
    
    private Login login;
    private MatricularAlumnos modMatricularAlumnos;
    private SqlMatricularAlumnos modSqlMatricularAlumnos;
    private MatricularAlumnosForm ventanaMatricularAlumnos;

    public ControlMatricularAlumnos(Login login, MatricularAlumnos modMatricularAlumnos, SqlMatricularAlumnos modSqlMatricularAlumnos,
            MatricularAlumnosForm venMatricularAlumnosForm) {
        
        this.login = login;
        this.modMatricularAlumnos = modMatricularAlumnos;
        this.modSqlMatricularAlumnos = modSqlMatricularAlumnos;
        this.ventanaMatricularAlumnos = venMatricularAlumnosForm;
        this.ventanaMatricularAlumnos.btnBuscarAlumnoMatriculado.addActionListener(this);
        this.ventanaMatricularAlumnos.btnEliminarAlumnoMatriculado.addActionListener(this);
        this.ventanaMatricularAlumnos.btnGuardarAlumnoMatriculado.addActionListener(this);
        this.ventanaMatricularAlumnos.btnHabilitarCamposAlumnosMatriculados.addActionListener(this);
        this.ventanaMatricularAlumnos.btnLimpiarCamposAlumnosMatriculados.addActionListener(this);
        this.ventanaMatricularAlumnos.btnNuevoAlumnoMatriculado.addActionListener(this);
    }

    public void limpiar() {
        ventanaMatricularAlumnos.txtIdCursoMatricular.setText(null);
        ventanaMatricularAlumnos.txtIdEstudianteCursoMatricular.setText(null);
        ventanaMatricularAlumnos.txtNombreCursoMatricular.setText(null);
        ventanaMatricularAlumnos.txtNombreAlumnoMatricular.setText(null);
        ventanaMatricularAlumnos.txtNombreProfesorCursoMatricular.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == ventanaMatricularAlumnos.btnNuevoAlumnoMatriculado) {
            ventanaMatricularAlumnos.txtNombreCursoMatricular.setEnabled(true);
            ventanaMatricularAlumnos.txtNombreAlumnoMatricular.setEnabled(true);
            ventanaMatricularAlumnos.txtNombreProfesorCursoMatricular.setEnabled(true);

        } else if (event.getSource() == ventanaMatricularAlumnos.btnGuardarAlumnoMatriculado) {
            modMatricularAlumnos.setCursos_codigo(Integer.parseInt(ventanaMatricularAlumnos.txtIdCursoMatricular.getText()));
            modMatricularAlumnos.setAlumnos_matricula(Integer.parseInt(ventanaMatricularAlumnos.txtIdEstudianteCursoMatricular.getText()));
            modMatricularAlumnos.setNombreCursoMatriculado(ventanaMatricularAlumnos.txtNombreCursoMatricular.getText());
            modMatricularAlumnos.setNombreEstudianteMatriculado(ventanaMatricularAlumnos.txtNombreAlumnoMatricular.getText());
            modMatricularAlumnos.setNombreProfesorMatriculado(ventanaMatricularAlumnos.txtNombreProfesorCursoMatricular.getText());

            if (modSqlMatricularAlumnos.crearAlumnoMatriculado(modMatricularAlumnos, login)) {
                JOptionPane.showMessageDialog(null, "Enroll student saved successfully");
                limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "Save error");
                limpiar();
            }

        } else if (event.getSource() == ventanaMatricularAlumnos.btnBuscarAlumnoMatriculado) {
            try {
                modMatricularAlumnos.setCursos_codigo(Integer.parseInt(ventanaMatricularAlumnos.txtIdCursoMatricular.getText()));
                modMatricularAlumnos.setAlumnos_matricula(Integer.parseInt(ventanaMatricularAlumnos.txtIdEstudianteCursoMatricular.getText()));

                if (modSqlMatricularAlumnos.buscarAlumnoMatriculado(modMatricularAlumnos, login)) {
                    ventanaMatricularAlumnos.txtIdCursoMatricular.setText(String.valueOf(modMatricularAlumnos.getCursos_codigo()));
                    ventanaMatricularAlumnos.txtIdEstudianteCursoMatricular.setText(String.valueOf(modMatricularAlumnos.getAlumnos_matricula()));
                    ventanaMatricularAlumnos.txtNombreCursoMatricular.setText(modMatricularAlumnos.getNombreCursoMatriculado());
                    ventanaMatricularAlumnos.txtNombreAlumnoMatricular.setText(modMatricularAlumnos.getNombreEstudianteMatriculado());
                    ventanaMatricularAlumnos.txtNombreProfesorCursoMatricular.setText(modMatricularAlumnos.getNombreProfesorMatriculado());
                } else {
                    JOptionPane.showMessageDialog(null, "Enroll student not found");
                    limpiar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Empty fields");
            }

        } else if (event.getSource() == ventanaMatricularAlumnos.btnEliminarAlumnoMatriculado) {
            try {
                modMatricularAlumnos.setCursos_codigo(Integer.parseInt(ventanaMatricularAlumnos.txtIdCursoMatricular.getText()));

                modMatricularAlumnos.setAlumnos_matricula(Integer.parseInt(ventanaMatricularAlumnos.txtIdEstudianteCursoMatricular.getText()));

                if (modSqlMatricularAlumnos.eliminarCurso(modMatricularAlumnos, login)) {
                    JOptionPane.showMessageDialog(null, "Enroll student deleted successfully");
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Delete error");
                    limpiar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Empty fields");
            }
        } else if (event.getSource() == ventanaMatricularAlumnos.btnHabilitarCamposAlumnosMatriculados) {
            ventanaMatricularAlumnos.txtNombreCursoMatricular.setEnabled(true);
            ventanaMatricularAlumnos.txtNombreAlumnoMatricular.setEnabled(true);
            ventanaMatricularAlumnos.txtNombreProfesorCursoMatricular.setEnabled(true);

        } else if (event.getSource() == ventanaMatricularAlumnos.btnLimpiarCamposAlumnosMatriculados) {
            limpiar();
        }
    }
}
