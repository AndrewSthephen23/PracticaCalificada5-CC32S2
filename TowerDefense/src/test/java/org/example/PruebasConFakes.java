package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PruebasConFakes {

    private BaseDeDatosPuntuacion baseDeDatosDePuntuacion;

    //Configuro las bases de datos de puntuaciones antes de cada prueba y
    //e inicializo las instancias de la clase fake
    @BeforeEach
    public void setUp() {
        baseDeDatosDePuntuacion = new FakeBaseDeDatosPuntuacion();
    }

    //Prueba para verificar que se puede guardar y obtener la puntuación de un jugador
    @Test
    public void pruebaGuardarYObtenerPuntuacion() {
        baseDeDatosDePuntuacion.guardarPuntuacion("Jugador1", 100);
        int puntuacion = baseDeDatosDePuntuacion.obtenerPuntuacion("Jugador1");
        assertEquals(100, puntuacion);
    }

    //Prueba para verificar que se obtiene una puntuación de 0 para un jugador no existente
    @Test
    public void pruebaObtenerPuntuacionNoExistente() {
        int puntuacion = baseDeDatosDePuntuacion.obtenerPuntuacion("JugadorDesconocido");
        assertEquals(0, puntuacion);
    }

    @Test
    public void pruebaObtenerTodasLasPuntuaciones() {
        baseDeDatosDePuntuacion.guardarPuntuacion("Jugador1", 100);
        baseDeDatosDePuntuacion.guardarPuntuacion("Jugador2", 200);
        Map<String, Integer> puntuaciones = baseDeDatosDePuntuacion.obtenerTodasLasPuntuaciones();
        assertEquals(2, puntuaciones.size());
        assertEquals(100, puntuaciones.get("Jugador1"));
        assertEquals(200, puntuaciones.get("Jugador2"));
    }
}
