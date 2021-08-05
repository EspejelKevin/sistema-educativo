/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author kevin
 */
public class MatricularAlumnos {
    
    private int cursos_codigo;
    private int alumnos_matricula;
    private String nombreEstudianteMatriculado;
    private String nombreCursoMatriculado;
    private String nombreProfesorMatriculado;

    public int getCursos_codigo() {
        return cursos_codigo;
    }

    public void setCursos_codigo(int cursos_codigo) {
        this.cursos_codigo = cursos_codigo;
    }

    public int getAlumnos_matricula() {
        return alumnos_matricula;
    }

    public void setAlumnos_matricula(int alumnos_matricula) {
        this.alumnos_matricula = alumnos_matricula;
    }

    public String getNombreEstudianteMatriculado() {
        return nombreEstudianteMatriculado;
    }

    public void setNombreEstudianteMatriculado(String nombreEstudianteMatriculado) {
        this.nombreEstudianteMatriculado = nombreEstudianteMatriculado;
    }

    public String getNombreCursoMatriculado() {
        return nombreCursoMatriculado;
    }

    public void setNombreCursoMatriculado(String nombreCursoMatriculado) {
        this.nombreCursoMatriculado = nombreCursoMatriculado;
    }

    public String getNombreProfesorMatriculado() {
        return nombreProfesorMatriculado;
    }

    public void setNombreProfesorMatriculado(String nombreProfesorMatriculado) {
        this.nombreProfesorMatriculado = nombreProfesorMatriculado;
    }
    
    
}
