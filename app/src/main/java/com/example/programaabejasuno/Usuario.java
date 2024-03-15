package com.example.programaabejasuno;

public class Usuario {

    int Id;
    String NomUsuario, Contrasena;

    public Usuario() {

    }

    public Usuario(String nomUsuario, String contrasena) {
        NomUsuario = nomUsuario;
        Contrasena = contrasena;
    }

    public boolean isNull(){
        if(NomUsuario.equals("")&&Contrasena.equals("")){
            return false;
        } else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "Id=" + Id +
                ", NomUsuario='" + NomUsuario + '\'' +
                ", Contrasena='" + Contrasena + '\'' +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNomUsuario() {
        return NomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        NomUsuario = nomUsuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }
}
