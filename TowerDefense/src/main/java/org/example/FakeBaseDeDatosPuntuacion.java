package org.example;
import java.util.HashMap;
import java.util.Map;

public class FakeBaseDeDatosPuntuacion implements BaseDeDatosPuntuacion{
    private Map<String, Integer> puntuaciones = new HashMap<>();

    //Guardo la puntuacion de un jugador en la base de datos
    @Override
    public void guardarPuntuacion(String nombreJugador, int puntuacion) {
        puntuaciones.put(nombreJugador, puntuacion);
    }

    //Obtengo la puntuacion de un jugador en la base da datos
    @Override
    public int obtenerPuntuacion(String nombreJugador) {
        return puntuaciones.getOrDefault(nombreJugador, 0);
    }

    // Obtengo todas las puntuaciones almacenadas en la base de datos
    @Override
    public Map<String, Integer> obtenerTodasLasPuntuaciones() {
        return new HashMap<>(puntuaciones);
    }
}
