package upc.com.visiontech2.dto;

import upc.com.visiontech2.entities.Role;

import java.util.List;

public class UsersDTO {
    
    private Long idUsuario;
    private String username;
    private Boolean enabled;
    private String correoElectronico;
    private int telefono;
    private String nombre;
    private List<Role> rol;

    public List<Role> getRol() {
        return rol;
    }

    public void setRol(List<Role> rol) {
        this.rol = rol;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}