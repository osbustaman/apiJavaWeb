package com.api.apis.Modelo;

public class Colaborador {
    private int id;
    private String rut;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String estadoCivil;
    private String sexo;
    private String fechaIngreso;
    private String password;
    private int perfil;
    private String tokenSesion;
    private String pathColaborador;
    private String imageColaborador;

    public Colaborador(int id, String rut, String nombres, String apellidos, String direccion, String estadoCivil, String sexo, String fechaIngreso, String password, int perfil, String tokenSesion, String pathColaborador, String imageColaborador) {
        this.id = id;
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.fechaIngreso = fechaIngreso;
        this.password = password;
        this.perfil = perfil;
        this.tokenSesion = tokenSesion;
        this.pathColaborador = pathColaborador;
        this.imageColaborador = imageColaborador;
    }

    public Colaborador(String rut, String nombres, String apellidos, String direccion, String estadoCivil, String sexo, String fechaIngreso, String password, int perfil, String tokenSesion, String pathColaborador, String imageColaborador) {
        this.rut = rut;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.fechaIngreso = fechaIngreso;
        this.password = password;
        this.perfil = perfil;
        this.tokenSesion = tokenSesion;
        this.pathColaborador = pathColaborador;
        this.imageColaborador = imageColaborador;
    }

    public Colaborador(int id, String rut) {
        this.id = id;
        this.rut = rut;
    }
    
    

    public Colaborador() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPerfil() {
        return perfil;
    }

    public void setPerfil(int perfil) {
        this.perfil = perfil;
    }

    public String getTokenSesion() {
        return tokenSesion;
    }

    public void setTokenSesion(String tokenSesion) {
        this.tokenSesion = tokenSesion;
    }

    public String getPathColaborador() {
        return pathColaborador;
    }

    public void setPathColaborador(String pathColaborador) {
        this.pathColaborador = pathColaborador;
    }

    public String getImageColaborador() {
        return imageColaborador;
    }

    public void setImageColaborador(String imageColaborador) {
        this.imageColaborador = imageColaborador;
    }
    
    
}
