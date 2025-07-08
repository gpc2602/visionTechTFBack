package upc.com.visiontech2.dto;

import java.util.List;

public class AsignarRolesDTO {
    private Long idUsuario;
    private List<Long> roleIds;

    public AsignarRolesDTO() {}

    public AsignarRolesDTO(Long idUsuario, List<Long> roleIds) {
        this.idUsuario = idUsuario;
        this.roleIds = roleIds;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
