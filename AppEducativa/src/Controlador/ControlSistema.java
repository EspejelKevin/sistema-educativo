package Controlador;

import Modelo.SqlUsuarios;
import Modelo.Usuarios;
import Vista.CursosForm;
import Vista.EstudiantesForm;
import Vista.Backup;
import Vista.Inicio;
import Vista.Login;
import Vista.MatricularAlumnosForm;
import Vista.ProfesoresForm;
import Vista.Registrar;
import Vista.Restore;
import Vista.UsuariosForm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ControlSistema implements ActionListener {

    private Usuarios modUsuarios;
    private SqlUsuarios modSqlUsuarios;
    private Login ventanaLogin;
    private Inicio ventanaPrincipal;
    private UsuariosForm ventanaUsuarios;
    private ProfesoresForm ventanaProfesores;
    private EstudiantesForm ventanaEstudiantes;
    private CursosForm ventanaCursos;
    private MatricularAlumnosForm ventanaMatricularAlumnos;
    private Backup ventanaBackup;
    private Restore ventanaRestore;
    private Registrar ventanaRegistrar;

    
    public ControlSistema(){
        
    }
    
    public ControlSistema(Usuarios modUsuarios, SqlUsuarios modSqlUsuarios,
            Login ventanaLogin, Inicio ventanaPrincipal, UsuariosForm ventanaUsuarios,
            ProfesoresForm ventanaProfesores, EstudiantesForm ventanaEstudiantes,
            CursosForm ventanaCursos, MatricularAlumnosForm venMatricularAlumnosForm, Backup venBackup,
            Restore ventanaRestore, Registrar ventanaRegistrar) {
        this.modUsuarios = modUsuarios;
        this.modSqlUsuarios = modSqlUsuarios;
        this.ventanaLogin = ventanaLogin;
        this.ventanaPrincipal = ventanaPrincipal;
        this.ventanaUsuarios = ventanaUsuarios;
        this.ventanaProfesores = ventanaProfesores;
        this.ventanaEstudiantes = ventanaEstudiantes;
        this.ventanaCursos = ventanaCursos;
        this.ventanaMatricularAlumnos = venMatricularAlumnosForm;
        this.ventanaBackup = venBackup;
        this.ventanaRestore = ventanaRestore;
        this.ventanaRegistrar = ventanaRegistrar;
        this.ventanaLogin.btnLogin.addActionListener(this);
        this.ventanaLogin.btnCancel.addActionListener(this);
        this.ventanaPrincipal.itemMenuSalir.addActionListener(this);
        this.ventanaPrincipal.itemMenuUsuario.addActionListener(this);
        this.ventanaPrincipal.itemMenuProfesores.addActionListener(this);
        this.ventanaPrincipal.itemMenuEstudiantes.addActionListener(this);
        this.ventanaPrincipal.itemMenuCursos.addActionListener(this);
        this.ventanaPrincipal.itemMenuMatricularAlumnos.addActionListener(this);
        this.ventanaPrincipal.itemMenuBackup.addActionListener(this);
        this.ventanaPrincipal.itemMenuRestore.addActionListener(this);
        this.ventanaLogin.btnRegistrarLogin.addActionListener(this);
        this.ventanaRegistrar.btnRegistrar.addActionListener(this);
        this.ventanaRegistrar.btnCancelRegistrar.addActionListener(this);
        //this.ventanaUsuarios.btnNuevoUsuario.addActionListener(this);
     
    }

    public void iniciar() {
        ventanaLogin.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == ventanaLogin.btnLogin) {
            String pass = new String(ventanaLogin.txtPass.getPassword());
            
            if (!ventanaLogin.txtUser.getText().equals("") || !pass.equals("")) {
                modUsuarios.setUsuario(ventanaLogin.txtUser.getText());
                modUsuarios.setClave(pass);
                
                
                if (modSqlUsuarios.loginUsuario(modUsuarios, ventanaLogin)) {
                    ventanaLogin.dispose();
                    ventanaPrincipal.setLocationRelativeTo(null);
                    ventanaPrincipal.setVisible(true);
                    switch (modUsuarios.getIdRol()) {
                        case 1:
                            break;
                        case 2:
                            ventanaPrincipal.itemMenuUsuario.setVisible(false);
                            ventanaPrincipal.itemMenuCursos.setVisible(false);
                            ventanaPrincipal.itemMenuEstudiantes.setVisible(false);
                            ventanaPrincipal.itemMenuMatricularAlumnos.setVisible(false);
                            ventanaPrincipal.menuDatabase.setVisible(false);
                            break;
                        case 3:
                            ventanaPrincipal.itemMenuUsuario.setVisible(false);
                            ventanaPrincipal.itemMenuCursos.setVisible(false);
                            ventanaPrincipal.itemMenuProfesores.setVisible(false);
                            ventanaPrincipal.itemMenuMatricularAlumnos.setVisible(false);
                            ventanaPrincipal.menuDatabase.setVisible(false);
                            break;
                        default:
                            break;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Datos incorrectos");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ingrese todos los campos");
            }
        } else if(event.getSource() == ventanaLogin.btnRegistrarLogin){
            ventanaRegistrar.setVisible(true);
            ventanaRegistrar.setLocationRelativeTo(null);
            ventanaLogin.dispose();
          
        } else if(event.getSource() == ventanaRegistrar.btnRegistrar){
            if(modSqlUsuarios.registrarUsuario(ventanaRegistrar)){
                JOptionPane.showMessageDialog(null, "User created successfully");
                ventanaRegistrar.dispose();
                ventanaLogin.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Save error");
            }
            
            
        } else if(event.getSource() == ventanaRegistrar.btnCancelRegistrar){
            ventanaRegistrar.dispose();
            ventanaLogin.setVisible(true);
        }
        else if (event.getSource() == ventanaLogin.btnCancel) {
            System.exit(0);
        } else if (event.getSource() == ventanaPrincipal.itemMenuSalir) {
            System.exit(0);
        } else if (event.getSource() == ventanaPrincipal.itemMenuUsuario) {
            ventanaPrincipal.dpEscritorio.add(ventanaUsuarios);
            ventanaUsuarios.show();
        } else if (event.getSource() == ventanaPrincipal.itemMenuProfesores) {
            ventanaPrincipal.dpEscritorio.add(ventanaProfesores);
            ventanaProfesores.show();
        } else if (event.getSource() == ventanaPrincipal.itemMenuEstudiantes) {
            ventanaPrincipal.dpEscritorio.add(ventanaEstudiantes);
            ventanaEstudiantes.show();
        } else if (event.getSource() == ventanaPrincipal.itemMenuCursos) {
            ventanaPrincipal.dpEscritorio.add(ventanaCursos);
            ventanaCursos.show();
        } else if(event.getSource() == ventanaPrincipal.itemMenuMatricularAlumnos){
            ventanaPrincipal.dpEscritorio.add(ventanaMatricularAlumnos);
            ventanaMatricularAlumnos.show();
        } else if(event.getSource() == ventanaPrincipal.itemMenuBackup){
            ventanaPrincipal.dpEscritorio.add(ventanaBackup);
            ventanaBackup.show();
        } else if(event.getSource() == ventanaPrincipal.itemMenuRestore){
            ventanaPrincipal.dpEscritorio.add(ventanaRestore);
            ventanaRestore.show();
        }
    }
}
