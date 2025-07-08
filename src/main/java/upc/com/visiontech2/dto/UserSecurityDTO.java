package upc.com.visiontech2.dto;

import upc.com.visiontech2.entities.Role;

import java.util.List;

public class UserSecurityDTO {
    
    private Long idUsuario;
    private String username;
    private String password;
    private Boolean enabled;
    private String correoElectronico;
    private int telefono;
    private String nombre;
    private List<Role> rol;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Role> getRol() {
        return rol;
    }

    public void setRol(List<Role> rol) {
        this.rol = rol;
    }
}
