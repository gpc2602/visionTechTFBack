package upc.com.visiontech2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import upc.com.visiontech2.entities.*;
import upc.com.visiontech2.repositories.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
public class Visiontech2Application implements CommandLineRunner {

    @Autowired
    private IRoleRepository roleRepository;
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RutaRepository rutaRepository;
    @Autowired
    private MetricaRepository metricaRepository;
    @Autowired
    private CondicionAtmosfericaRepository condicionAtmosfericaRepository;
    @Autowired
    private IncidenteRepository incidenteRepository;
    @Autowired
    private ContactoEmergenciaRepository contactoEmergenciaRepository;
    @Autowired
    private NumeroEmergenciaRepository numeroEmergenciaRepository;
    // @Autowired
    // private NotificacionRepository notificacionRepository;
    @Autowired
    private RecomendacionRepository recomendacionRepository;
    @Autowired
    private TemaForoRepository temaForoRepository;
    @Autowired
    private RespuestaRepository respuestaRepository;

    public static void main(String[] args) {
        SpringApplication.run(Visiontech2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initializeRoles();
        initializeUsers();
        initializeRutas();
        initializeMetricas();
        initializeCondicionesAtmosfericas();
        initializeIncidentes();
        initializeContactosEmergencia();
        initializeNumerosEmergencia();
        // initializeNotificaciones();
        initializeRecomendaciones();
        initializeTemasForoAndRespuestas();
    }

    private void initializeRoles() {
        if (roleRepository.findByRol("ROLE_USER") == null) {
            Role userRole = new Role();
            userRole.setRol("ROLE_USER");
            roleRepository.save(userRole);
            System.out.println("Rol ROLE_USER creado correctamente");
        }

        if (roleRepository.findByRol("ROLE_ADMIN") == null) {
            Role adminRole = new Role();
            adminRole.setRol("ROLE_ADMIN");
            roleRepository.save(adminRole);
            System.out.println("Rol ROLE_ADMIN creado correctamente");
        }

        if (roleRepository.findByRol("ROLE_TESTER") == null) {
            Role testerRole = new Role();
            testerRole.setRol("ROLE_TESTER");
            roleRepository.save(testerRole);
            System.out.println("Rol ROLE_TESTER creado correctamente");
        }
    }

    private void initializeUsers() {
        // Usuario Admin
        if (userRepository.findOneByUsername("admin@visiontech.com") == null) {
            Users admin = new Users();
            admin.setUsername("admin@visiontech.com");
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setEnabled(true);
            admin.setNombre("Administrador VisionTech");
            admin.setCorreoElectronico("admin@visiontech.com");
            admin.setTelefono(999999999);

            Role adminRole = roleRepository.findByRol("ROLE_ADMIN");
            if (adminRole != null) {
                admin.getRoles().add(adminRole);
            }

            userRepository.save(admin);
            System.out.println("Usuario admin@visiontech.com creado correctamente");
        }

        // Usuario Tester
        if (userRepository.findOneByUsername("tester@visiontech.com") == null) {
            Users tester = new Users();
            tester.setUsername("tester@visiontech.com");
            tester.setPassword(passwordEncoder.encode("tester123"));
            tester.setEnabled(true);
            tester.setNombre("QA Tester VisionTech");
            tester.setCorreoElectronico("tester@visiontech.com");
            tester.setTelefono(911223344);

            Role testerRole = roleRepository.findByRol("ROLE_TESTER");
            if (testerRole != null) {
                tester.getRoles().add(testerRole);
            }

            userRepository.save(tester);
            System.out.println("Usuario tester@visiontech.com creado correctamente");
        }

        // Santiago Iglesias
        if (userRepository.findOneByUsername("santiago@visiontech.com") == null) {
            Users user1 = new Users();
            user1.setUsername("santiago@visiontech.com");
            user1.setPassword(passwordEncoder.encode("santiago123"));
            user1.setEnabled(true);
            user1.setNombre("Santiago Iglesias");
            user1.setCorreoElectronico("santiago@visiontech.com");
            user1.setTelefono(987654321);

            Role userRole = roleRepository.findByRol("ROLE_USER");
            if (userRole != null) {
                user1.getRoles().add(userRole);
            }

            userRepository.save(user1);
            System.out.println("Usuario santiago@visiontech.com creado correctamente");
        }

        // María García
        if (userRepository.findOneByUsername("maria@email.com") == null) {
            Users user2 = new Users();
            user2.setUsername("maria@email.com");
            user2.setPassword(passwordEncoder.encode("maria123"));
            user2.setEnabled(true);
            user2.setNombre("María García");
            user2.setCorreoElectronico("maria@email.com");
            user2.setTelefono(956789123);

            Role userRole = roleRepository.findByRol("ROLE_USER");
            if (userRole != null) {
                user2.getRoles().add(userRole);
            }

            userRepository.save(user2);
            System.out.println("Usuario maria@email.com creado correctamente");
        }

        // Luis Rodríguez
        if (userRepository.findOneByUsername("luis@email.com") == null) {
            Users user3 = new Users();
            user3.setUsername("luis@email.com");
            user3.setPassword(passwordEncoder.encode("luis123"));
            user3.setEnabled(true);
            user3.setNombre("Luis Rodríguez");
            user3.setCorreoElectronico("luis@email.com");
            user3.setTelefono(912345678);

            Role userRole = roleRepository.findByRol("ROLE_USER");
            if (userRole != null) {
                user3.getRoles().add(userRole);
            }

            userRepository.save(user3);
            System.out.println("Usuario luis@email.com creado correctamente");
        }
    }

    private void initializeRutas() {
        Users santiago = userRepository.findOneByUsername("santiago@visiontech.com");
        Users maria = userRepository.findOneByUsername("maria@email.com");
        Users luis = userRepository.findOneByUsername("luis@email.com");

        if (santiago != null && rutaRepository.count() == 0) {
            // Ruta 1 - Santiago
            Ruta ruta1 = new Ruta();
            ruta1.setNombreRuta("Parque Kennedy - Miraflores");
            ruta1.setInicio("-12.120000, -77.036000"); // Parque Kennedy
            ruta1.setDestino("-12.127000, -77.030000"); // Malecón de Miraflores
            ruta1.setDistanciaMetros(2500);
            ruta1.setTiempoRuta(25);
            ruta1.setFavorito(true);
            ruta1.setLongitud(-77.036);
            ruta1.setLatitud(-12.120);
            ruta1.setUsuario(santiago);
            rutaRepository.save(ruta1);

            // Ruta 2 - María
            Ruta ruta2 = new Ruta();
            ruta2.setNombreRuta("Circuito Barranco Lima");
            ruta2.setInicio("-12.140000, -77.025000"); // Plaza San Francisco Barranco
            ruta2.setDestino("-12.142000, -77.023000"); // Puente de los Suspiros
            ruta2.setDistanciaMetros(1800);
            ruta2.setTiempoRuta(18);
            ruta2.setFavorito(false);
            ruta2.setLongitud(-77.025);
            ruta2.setLatitud(-12.140);
            ruta2.setUsuario(maria);
            rutaRepository.save(ruta2);

            // Ruta 3 - Luis
            Ruta ruta3 = new Ruta();
            ruta3.setNombreRuta("Costa Verde Lima");
            ruta3.setInicio("-12.100000, -77.070000"); // Playa Redondo Miraflores
            ruta3.setDestino("-12.080000, -77.090000"); // Playa Makaha San Miguel
            ruta3.setDistanciaMetros(5000);
            ruta3.setTiempoRuta(45);
            ruta3.setFavorito(true);
            ruta3.setLongitud(-77.070);
            ruta3.setLatitud(-12.100);
            ruta3.setUsuario(luis);
            rutaRepository.save(ruta3);

            // Ruta 4 - Santiago (segunda ruta)
            Ruta ruta4 = new Ruta();
            ruta4.setNombreRuta("Centro Financiero San Isidro");
            ruta4.setInicio("-12.100000, -77.035000"); // Centro Empresarial San Isidro
            ruta4.setDestino("-12.105000, -77.038000"); // Parque El Olivar
            ruta4.setDistanciaMetros(3200);
            ruta4.setTiempoRuta(32);
            ruta4.setFavorito(false);
            ruta4.setLongitud(-77.035);
            ruta4.setLatitud(-12.100);
            ruta4.setUsuario(santiago);
            rutaRepository.save(ruta4);

            // Ruta 5 - María (segunda ruta)
            Ruta ruta5 = new Ruta();
            ruta5.setNombreRuta("Parque de la Amistad - Surco");
            ruta5.setInicio("-12.165000, -76.987000"); // Parque de la Amistad
            ruta5.setDestino("-12.160000, -76.975000"); // Jockey Plaza
            ruta5.setDistanciaMetros(4100);
            ruta5.setTiempoRuta(38);
            ruta5.setFavorito(true);
            ruta5.setLongitud(-76.987);
            ruta5.setLatitud(-12.165);
            ruta5.setUsuario(maria);
            rutaRepository.save(ruta5);

            System.out.println("Rutas inicializadas correctamente");
        }
    }

    private void initializeMetricas() {
        if (metricaRepository.count() == 0) {
            rutaRepository.findAll().forEach(ruta -> {
                // Métrica reciente
                Metrica metrica1 = new Metrica();
                metrica1.setNumeroPasos(ruta.getDistanciaMetros());
                metrica1.setCaloriasQuemadas(ruta.getDistanciaMetros() / 20); // Estimación
                metrica1.setTiempoEfectivoMinutos(ruta.getTiempoRuta());
                metrica1.setFecha(LocalDate.now().minusDays(1));
                metrica1.setRuta(ruta);
                metricaRepository.save(metrica1);

                // Métrica histórica
                Metrica metrica2 = new Metrica();
                metrica2.setNumeroPasos((int) (ruta.getDistanciaMetros() * 0.9));
                metrica2.setCaloriasQuemadas((int) (ruta.getDistanciaMetros() / 22));
                metrica2.setTiempoEfectivoMinutos(ruta.getTiempoRuta() + 5);
                metrica2.setFecha(LocalDate.now().minusDays(7));
                metrica2.setRuta(ruta);
                metricaRepository.save(metrica2);
            });
            System.out.println("Métricas inicializadas correctamente");
        }
    }

    private void initializeCondicionesAtmosfericas() {
        if (condicionAtmosfericaRepository.count() == 0) {
            rutaRepository.findAll().forEach(ruta -> {
                CondicionAtmosferica condicion = new CondicionAtmosferica();
                condicion.setHumedad(65 + (ruta.getIdRuta() % 20)); // Variación 65-85%
                condicion.setTemperatura(18.5 + (ruta.getIdRuta() % 8)); // Variación 18-26°C
                condicion.setVelocidadViento(5 + (ruta.getIdRuta() % 10)); // Variación 5-15 km/h
                condicion.setFechaHora(LocalDateTime.now().minusHours(ruta.getIdRuta()));
                condicion.setRuta(ruta);
                condicionAtmosfericaRepository.save(condicion);
            });
            System.out.println("Condiciones atmosféricas inicializadas correctamente");
        }
    }

    private void initializeIncidentes() {
        if (incidenteRepository.count() == 0) {
            String[] tipos = { "Caída", "Obstáculo", "Problema Respiratorio", "Deshidratación", "Lesión Muscular" };
            String[] gravedades = { "Baja", "Media", "Alta" };
            String[] descripciones = { "Tropiezo en vereda", "Árbol caído", "Fatiga extrema", "Sed intensa",
                    "Dolor en pierna" };

            rutaRepository.findAll().forEach(ruta -> {
                // Solo algunas rutas tienen incidentes
                if (ruta.getIdRuta() <= 3) {
                    Incidente incidente = new Incidente();
                    incidente.setTipo(tipos[ruta.getIdRuta() % tipos.length]);
                    incidente.setGravedad(gravedades[ruta.getIdRuta() % gravedades.length]);
                    incidente.setDescripcion(descripciones[ruta.getIdRuta() % descripciones.length]);
                    incidente.setRuta(ruta);
                    incidenteRepository.save(incidente);
                }
            });
            System.out.println("Incidentes inicializados correctamente");
        }
    }

    private void initializeContactosEmergencia() {
        if (contactoEmergenciaRepository.count() == 0) {
            userRepository.findAll().forEach(usuario -> {
                if (!usuario.getUsername().equals("admin@visiontech.com")) {
                    ContactoEmergencia contacto = new ContactoEmergencia();
                    contacto.setNombre("Dr. " + usuario.getNombre().split(" ")[0] + " Emergency");
                    contacto.setTelefono(51L + (usuario.getIdUsuario() * 100000000));
                    contacto.setCorreoElectronico("emergency" + usuario.getIdUsuario() + "@hotmail.com");
                    contacto.setUsuario(usuario);
                    contactoEmergenciaRepository.save(contacto);
                }
            });
            System.out.println("Contactos de emergencia inicializados correctamente");
        }
    }

    private void initializeNumerosEmergencia() {
        if (numeroEmergenciaRepository.count() == 0) {
            String[] tipos = { "Policía", "Bomberos", "SAMU", "Serenazgo" };
            String[] distritos = { "Miraflores", "Barranco", "San Isidro", "Surco", "La Molina" };
            int[] telefonos = { 105, 116, 106, 2419999, 3178200 };

            userRepository.findAll().forEach(usuario -> {
                if (!usuario.getUsername().equals("admin@visiontech.com")) {
                    NumeroEmergencia numero = new NumeroEmergencia();
                    numero.setTipoEmergencia(tipos[usuario.getIdUsuario().intValue() % tipos.length]);
                    numero.setDistrito(distritos[usuario.getIdUsuario().intValue() % distritos.length]);
                    numero.setTelefonoEmergencia(telefonos[usuario.getIdUsuario().intValue() % telefonos.length]);
                    numero.setUsuario(usuario);
                    numeroEmergenciaRepository.save(numero);
                }
            });
            System.out.println("Números de emergencia inicializados correctamente");
        }
    }

    // private void initializeNotificaciones() {
    //     if (notificacionRepository.count() == 0) {
    //         String[] titulos = { "Ruta Completada", "Meta Alcanzada", "Clima Favorable", "Recordatorio", "Nueva Ruta" };
    //         String[] contenidos = { "¡Excelente tiempo!", "500 pasos más", "Perfecto para correr", "Hora de entrenar",
    //                 "Ruta disponible" };

    //         rutaRepository.findAll().forEach(ruta -> {
    //             Notificacion notificacion = new Notificacion();
    //             notificacion.setTitulo(titulos[ruta.getIdRuta() % titulos.length]);
    //             notificacion.setContenido(contenidos[ruta.getIdRuta() % contenidos.length]);
    //             notificacion.setFechaHora(LocalDate.now().minusDays(ruta.getIdRuta()));
    //             notificacion.setRuta(ruta);
    //             notificacionRepository.save(notificacion);
    //         });
    //         System.out.println("Notificaciones inicializadas correctamente");
    //     }
    // }

    private void initializeRecomendaciones() {
        if (recomendacionRepository.count() == 0) {
            String[] comentarios = { "Excelente ruta", "Muy recomendable", "Perfecta para principiantes",
                    "Desafiante pero buena", "Hermosa vista" };

            rutaRepository.findAll().forEach(ruta -> {
                Recomendacion recomendacion = new Recomendacion();
                recomendacion.setComentario(comentarios[ruta.getIdRuta() % comentarios.length]);
                recomendacion.setPuntuacion(3 + (ruta.getIdRuta() % 3)); // Puntuación 3-5
                recomendacion.setRuta(ruta);
                recomendacionRepository.save(recomendacion);
            });
            System.out.println("Recomendaciones inicializadas correctamente");
        }
    }

    private void initializeTemasForoAndRespuestas() {
        if (temaForoRepository.count() == 0) {
            String[] titulos = { "Mejores rutas matutinas", "Tips para principiantes", "Equipamiento recomendado",
                    "Nutrición deportiva", "Lesiones comunes" };
            String[] comentarios = { "¿Cuáles recomiendan?", "Necesito consejos", "¿Qué zapatillas usar?",
                    "¿Qué comer antes?", "¿Cómo prevenir?" };

            userRepository.findAll().forEach(usuario -> {
                if (!usuario.getUsername().equals("admin@visiontech.com")) {
                    TemaForo tema = new TemaForo();
                    tema.setTituloTema(titulos[usuario.getIdUsuario().intValue() % titulos.length]);
                    tema.setComentario(comentarios[usuario.getIdUsuario().intValue() % comentarios.length]);
                    tema.setFechaCreacion(LocalDate.now().minusDays(usuario.getIdUsuario()));
                    tema.setEstadoCerrado(false);
                    tema.setUsuario(usuario);
                    temaForoRepository.save(tema);

                    // Respuestas a cada tema
                    String[] respuestas = { "Muy buena pregunta", "Yo recomiendo...", "En mi experiencia...",
                            "Totalmente de acuerdo", "Excelente punto" };

                    Respuesta respuesta = new Respuesta();
                    respuesta.setRespuesta(respuestas[usuario.getIdUsuario().intValue() % respuestas.length]);
                    respuesta.setFechaRespuesta(LocalDate.now().minusDays(usuario.getIdUsuario() - 1));
                    respuesta.setTemaForo(tema);
                    respuestaRepository.save(respuesta);
                }
            });
            System.out.println("Temas de foro y respuestas inicializados correctamente");
        }
    }
}
