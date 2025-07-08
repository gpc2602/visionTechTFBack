package upc.com.visiontech2.dto;

import upc.com.visiontech2.entities.Users;

public class ListarRolDTO {
    
    private Long idRol;
    private String rol;
    private Users user; // Solo el ID del usuario en lugar de toda la entidad

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
