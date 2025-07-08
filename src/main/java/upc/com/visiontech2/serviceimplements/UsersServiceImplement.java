package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import upc.com.visiontech2.dto.UsersDTO;
import upc.com.visiontech2.entities.Role;
import upc.com.visiontech2.entities.Users;
import upc.com.visiontech2.repositories.IRoleRepository;
import upc.com.visiontech2.repositories.IUserRepository;
import upc.com.visiontech2.serviceinterfaces.IUsersService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersServiceImplement implements IUsersService {
    
    @Autowired
    private IUserRepository uR;
    @Autowired
    private IRoleRepository roleRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Users> list() {
        return uR.findAllByOrderByIdUsuario();
    }

    @Override
    public void insert(Users u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        uR.save(u);
    }

    @Override
    public void update(Users existingUser, UsersDTO dto) {
        existingUser.setUsername(dto.getUsername());
        existingUser.setEnabled(dto.getEnabled());
        existingUser.setCorreoElectronico(dto.getCorreoElectronico());
        existingUser.setTelefono(dto.getTelefono());
        existingUser.setNombre(dto.getNombre());

        if (dto.getRol() != null && !dto.getRol().isEmpty()) {
            List<Long> roleIds = dto.getRol().stream()
                    .map(Role::getIdRol)
                    .collect(Collectors.toList());

            List<Role> existingRoles = roleRepository.findAllById(roleIds);
            existingUser.getRoles().clear();
            existingUser.getRoles().addAll(existingRoles);
        }

        uR.save(existingUser);
    }

    @Override
    public void delete(long id) {
        uR.deleteById(id);
    }

    @Override
    public Users listId(long id) {
        return uR.findById(id).orElse(new Users());
    }

    @Override
    public List<Users> obtenerUsuariosConMuchosRegistros(long minCantidad) {
        return uR.findUsuariosConMuchosRegistros(minCantidad);
    }

    @Override
    public Users findOneByUsername(String username) {
        return uR.findOneByUsername(username);
    }
}
