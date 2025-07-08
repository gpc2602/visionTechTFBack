package upc.com.visiontech2.serviceimplements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upc.com.visiontech2.entities.Notificacion;
import upc.com.visiontech2.repositories.NotificacionRepository;
import upc.com.visiontech2.serviceinterfaces.INotifiacionService;

import java.util.List;

@Service
public class NotificacionServiceImplement implements INotifiacionService {
    
    @Autowired
    private NotificacionRepository nR;

    @Override
    public List<Notificacion> list() {
        return nR.findAll();
    }

    @Override
    public void insert(Notificacion n) {
        nR.save(n);
    }

    @Override
    public Notificacion listId(int idNotificacion) {
        return nR.findById(idNotificacion).orElse(new Notificacion());
    }

    @Override
    public void update(Notificacion n) {
        nR.save(n);
    }

    @Override
    public void delete(int idNotificacion) {
        nR.deleteById(idNotificacion);
    }
}
