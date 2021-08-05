
package App;

import Controlador.ControlBackup;
import Controlador.ControlCursos;
import Controlador.ControlEstudiantes;
import Controlador.ControlMatricularAlumnos;
import Controlador.ControlProfesores;
import Controlador.ControlRestore;
import Controlador.ControlSistema;
import Controlador.ControlUsuarios;
import Modelo.Cursos;
import Modelo.Estudiantes;
import Modelo.MatricularAlumnos;
import Modelo.Profesores;
import Modelo.SqlCursos;
import Modelo.SqlEstudiantes;
import Modelo.SqlMatricularAlumnos;
import Modelo.SqlProfesores;
import Modelo.SqlUsuarios;
import Modelo.Usuarios;
import Vista.CursosForm;
import Vista.EstudiantesForm;
import Vista.Backup;
import Vista.Login;
import Vista.Inicio;
import Vista.MatricularAlumnosForm;
import Vista.ProfesoresForm;
import Vista.Registrar;
import Vista.Restore;
import Vista.UsuariosForm;

public class Main {
    public static void main(String[] args) {
        
        Usuarios modUsuarios = new Usuarios();
        Profesores modProfesores = new Profesores();
        Estudiantes modEstudiantes = new Estudiantes();
        Cursos modCursos = new Cursos();
        MatricularAlumnos modMatricularAlumnos = new MatricularAlumnos();
        SqlUsuarios modSqlUsuarios = new SqlUsuarios();
        SqlProfesores modSqlProfesores = new SqlProfesores();
        SqlEstudiantes modSqlEstudiantes = new SqlEstudiantes();
        SqlCursos modSqlCursos = new SqlCursos();
        SqlMatricularAlumnos modSqlMatricularAlumnos = new SqlMatricularAlumnos();
        Login ventanaLogin = new Login();
        Inicio ventanaPrincipal = new Inicio();
        UsuariosForm ventanaUsuarios = new UsuariosForm();
        ProfesoresForm ventanaProfesores = new ProfesoresForm();
        EstudiantesForm ventanaEstudiantes = new EstudiantesForm();
        CursosForm ventanaCursos = new CursosForm();
        MatricularAlumnosForm ventanaMatricularAlumnos = new MatricularAlumnosForm();
        Backup ventanaBackup = new Backup();
        Restore ventanaRestore = new Restore();
        Registrar ventanaRegistrar = new Registrar();
        
        ControlSistema sistema = new ControlSistema(modUsuarios, modSqlUsuarios, 
                                                    ventanaLogin, ventanaPrincipal,
                                                    ventanaUsuarios, ventanaProfesores,
                                                    ventanaEstudiantes, ventanaCursos,
                                                    ventanaMatricularAlumnos, ventanaBackup,
                                                    ventanaRestore, ventanaRegistrar);
        
        ControlUsuarios controlUsuarios = new ControlUsuarios(ventanaLogin, modUsuarios, ventanaUsuarios, modSqlUsuarios) {};
        ControlProfesores controlProfesores = new ControlProfesores(ventanaLogin, modProfesores, ventanaProfesores, 
                                                                    modSqlProfesores) {};
        ControlEstudiantes controlEstudiantes = new ControlEstudiantes(ventanaLogin, modEstudiantes, ventanaEstudiantes,
                                                                       modSqlEstudiantes) {};
        ControlCursos controlCursos = new ControlCursos(ventanaLogin, modCursos, modSqlCursos, ventanaCursos) {};
        ControlMatricularAlumnos controlMatricularAlumnos = new ControlMatricularAlumnos(ventanaLogin, modMatricularAlumnos, 
                                                                                         modSqlMatricularAlumnos, 
                                                                                         ventanaMatricularAlumnos) {};
        ControlBackup backup = new ControlBackup(ventanaBackup) {};
        
        ControlRestore restore = new ControlRestore(ventanaRestore) {};
        
        sistema.iniciar();
        ventanaLogin.setVisible(true);
        
                
    }
}
