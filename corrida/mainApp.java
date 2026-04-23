package corrida;

public class mainApp {
    public static void main(String[] args) {
        Carro c1 = new Carro("Carro 1");
        Carro c2 = new Carro("Carro 2");
        Corrida corrida = new Corrida(c1, c2, 150);
        corrida.iniciarCorrida();
    }
}