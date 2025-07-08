package upc.com.visiontech2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import upc.com.visiontech2.entities.Users;

import java.util.List;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {

    List<Users> findAllByOrderByIdUsuario();

    public Users findOneByUsername(String username);

    public @Query("SELECT u FROM Users u WHERE SIZE(u.roles) > 0 AND " +
            "(SELECT COUNT(ne) FROM NumeroEmergencia ne WHERE ne.usuario = u) > :minCantidad") List<Users> findUsuariosConMuchosRegistros(
                    @Param("minCantidad") long minCantidad);

}