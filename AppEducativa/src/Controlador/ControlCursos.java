
package Controlador;

import Modelo.Cursos;
import Modelo.SqlCursos;
import Vista.CursosForm;
import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public abstract class ControlCursos implements ActionListener{
    
    private Login login;
    private Cursos modCursos;
    private SqlCursos modSqlCursos;
    private CursosForm ventanaCursos;
    
    public ControlCursos(Login login, Cursos modCursos, SqlCursos modSqlCursos, CursosForm ventanaCursos){
        this.login = login;
        this.modCursos = modCursos;
        this.modSqlCursos = modSqlCursos;
        this.ventanaCursos = ventanaCursos;
        this.ventanaCursos.btnBuscarCurso.addActionListener(this);
        this.ventanaCursos.btnEliminarCurso.addActionListener(this);
        this.ventanaCursos.btnGuardarCurso.addActionListener(this);
        this.ventanaCursos.btnHabilitarCamposCursos.addActionListener(this);
        this.ventanaCursos.btnLimpiarCamposCursos.addActionListener(this);
        this.ventanaCursos.btnModificarCurso.addActionListener(this);
        this.ventanaCursos.btnNuevoCurso.addActionListener(this);
    }
    
    public void limpiar(){
        ventanaCursos.txtIdCurso.setText(null);
        ventanaCursos.txtNombreCurso.setText(null);
        ventanaCursos.txtRFCProfesorCurso.setText(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == ventanaCursos.btnNuevoCurso){
            ventanaCursos.txtNombreCurso.setEnabled(true);
            ventanaCursos.txtRFCProfesorCurso.setEnabled(true);
            
        }else if(event.getSource() == ventanaCursos.btnGuardarCurso){
            modCursos.setCodigoCurso(Integer.parseInt(ventanaCursos.txtIdCurso.getText()));
            modCursos.setNombreCurso(ventanaCursos.txtNombreCurso.getText());
            modCursos.setRfcProfesorCurso(ventanaCursos.txtRFCProfesorCurso.getText());
            
            if(modSqlCursos.crearCurso(modCursos, login)){
                JOptionPane.showMessageDialog(null, "Course saved successfully");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Save error");
                limpiar();
            }
            ventanaCursos.txtRFCProfesorCurso.setEnabled(false);
            
        }else if(event.getSource() == ventanaCursos.btnBuscarCurso){
            modCursos.setCodigoCurso(Integer.parseInt(ventanaCursos.txtIdCurso.getText()));
            
            if(modSqlCursos.buscarCurso(modCursos, login)){
                ventanaCursos.txtIdCurso.setText(String.valueOf(modCursos.getCodigoCurso()));
                ventanaCursos.txtNombreCurso.setText(modCursos.getNombreCurso());
                ventanaCursos.txtRFCProfesorCurso.setText(modCursos.getRfcProfesorCurso());
            }else{
                JOptionPane.showMessageDialog(null, "Course not found");
                limpiar();
            }
            
        }else if(event.getSource() == ventanaCursos.btnModificarCurso){
            modCursos.setCodigoCurso(Integer.parseInt(ventanaCursos.txtIdCurso.getText()));
            modCursos.setNombreCurso(ventanaCursos.txtNombreCurso.getText());
            modCursos.setRfcProfesorCurso(ventanaCursos.txtRFCProfesorCurso.getText());
            
            if(modSqlCursos.actualizarCurso(modCursos, login)){
                JOptionPane.showMessageDialog(null, "Course updated successfully");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Update error");
                limpiar();
            }
            
        }else if(event.getSource() == ventanaCursos.btnEliminarCurso){
            modCursos.setCodigoCurso(Integer.parseInt(ventanaCursos.txtIdCurso.getText()));
            
            if(modSqlCursos.eliminarCurso(modCursos, login)){
                JOptionPane.showMessageDialog(null, "Course deleted successfully");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "Delete error");
                limpiar();
            }
            
        }else if(event.getSource() == ventanaCursos.btnHabilitarCamposCursos){
            ventanaCursos.txtNombreCurso.setEnabled(true);
    
        }else if(event.getSource() == ventanaCursos.btnLimpiarCamposCursos){
            limpiar();
        }
    }
}
