package corrida;

import java.util.Random;

public class Carro {
    private String nome;
    private int distancia;
    
    private int velocidade;
    
    //Construtor carro.
    public Carro (String nome){
        this.nome = nome;
        this.distancia = 0;
        this.velocidade = 0;
    }
    
    //Método gerar nova velocidade.
    public void atualizarVelocidade() {
        Random r = new Random();
        velocidade = r.nextInt(4);
    }
    
    //Método que move o carro.
    public void mover(int distanciaMaxima){
        int novaDistancia = distancia + velocidade;
        distancia = novaDistancia;

        verDistancia(distanciaMaxima);
    }
    
    //Verificador de distancia maxima
    public void verDistancia(int distanciaMaxima){
        if (getDistancia() > distanciaMaxima) {
            setDistancia(distanciaMaxima);
        }
    }

    //Retorna a distancia atual.
    public int getDistancia(){
        return this.distancia;  
    }
    
    //Gera um novo valor para distancia.
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String getNome(){
        return nome;
    }

    //Visual do carro na pista.
    public void desenhar(int distanciaMaxima){
        String[] posicaoCarro = new String[distanciaMaxima + 1];
        posicaoCarro[distancia] = "#";
        for(int i = 0; i < posicaoCarro.length; i++){
            if (posicaoCarro[i] == null) {
            posicaoCarro[i] = " ";
            }
            System.out.print(posicaoCarro[i]);
        } 
    }
}