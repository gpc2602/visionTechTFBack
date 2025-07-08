package upc.com.visiontech2.dto;

public class ListarRolesDTO {
    private Long idRol;
    private String rol;

    public ListarRolesDTO() {}

    public ListarRolesDTO(Long idRol, String rol) {
        this.idRol = idRol;
        this.rol = rol;
    }

    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
