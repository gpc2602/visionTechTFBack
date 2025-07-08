package upc.com.visiontech2.serviceinterfaces;

import upc.com.visiontech2.entities.Notificacion;

import java.util.List;

public interface INotifiacionService {
    
    public List<Notificacion> list();

    public void insert(Notificacion n);

    public Notificacion listId(int idNotificacion);

    public void update(Notificacion n);

    public void delete(int idNotificacion);
}
