package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.Role;
import upc.com.visiontech2.repositories.RolRepository;
import upc.com.visiontech2.serviceinterfaces.IRolService;

import java.util.List;

@Service
public class RolServiceImplement implements IRolService {
    
    @Autowired
    private RolRepository rR;

    @Override
    public List<Role> list() {
        return rR.findAll();
    }

    @Override
    public void insert(Role r) {
        rR.save(r);
    }

    @Override
    public Role listId(Long idRol) {
        return rR.findById(idRol).orElse(new Role());
    }

    @Override
    public void update(Role r) {
        rR.save(r);
    }

    @Override
    public void delete(Long idRol) {
        rR.deleteById(idRol);
    }
}
