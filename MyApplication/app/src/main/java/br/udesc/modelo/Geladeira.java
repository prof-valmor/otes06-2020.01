package br.udesc.modelo;

public class Geladeira {
    private int temperaturaSelecionada;
    // Singleton pattern.
    private static Geladeira instance;
    private TemperaturaListener temperaturaListener;

    private Geladeira() {
        temperaturaSelecionada = 0;
    }

    public static Geladeira getInstance() {
        if(instance == null) {
            instance = new Geladeira();
        }
        return instance;
    }

    public void incrementarSelecaoDeTemperatura() {
        temperaturaSelecionada++;
        if(temperaturaSelecionada > 2) {
            temperaturaSelecionada = 0;
        }
        temperaturaListener.onTemperaturaChange(temperaturaSelecionada);
    }

    public void addTemperaturaListener(TemperaturaListener temperaturaListener) {
        this.temperaturaListener = temperaturaListener;
    }

    public int getTemperaturaSelecionada() {
        return temperaturaSelecionada;
    }
}
