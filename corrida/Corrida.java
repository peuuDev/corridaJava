package corrida;

public class Corrida {
    private Carro carro1;
    private Carro carro2;
    private int distanciaMaxima;
    
    public Corrida (Carro carro1, Carro carro2, int distanciaMaxima){
        this.carro1 = carro1;
        this.carro2 = carro2;
        this.distanciaMaxima = distanciaMaxima;
    }

    public Carro getCarro1() {
        return carro1;
    }

    public Carro getCarro2() {
        return carro2;
    }

    public int getDistanciaMaxima(){
        return this.distanciaMaxima;
    }

    //Método principal.
    public void iniciarCorrida(){
        
        //Exibir pista inicial com carros na posição 0
        exibirPista();
        
        while(true){
            //Atualizar velocidade.
            carro1.atualizarVelocidade();
            carro2.atualizarVelocidade();

            //Mover carro.
            carro1.mover(distanciaMaxima);
            carro2.mover(distanciaMaxima);
            
            //Exibir pista.
            exibirPista();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            //Verificar se tem vencedor.
            if (carro1.getDistancia() >= distanciaMaxima && carro2.getDistancia() >= distanciaMaxima){
                if (carro1.getDistancia() > carro2.getDistancia()){
                    System.out.println("Carro 1 venceu!");
                }else if (carro2.getDistancia() > carro1.getDistancia()){
                    System.out.println("Carro 2 venceu!");
                }else if (carro1.getDistancia() == carro2.getDistancia()){
                    System.out.println("Empate!");
                } 
                break;
            }else if (carro1.getDistancia() >= distanciaMaxima){
                System.out.println("Carro 1 venceu!");
                break;
            }else if (carro2.getDistancia() >= distanciaMaxima){
                System.out.println("Carro 2 venceu!");
                break;
            }
        }
    }

    public void desenharTracejo(int distanciaMaxima){
        String[] linhaTracejo = new String[distanciaMaxima + 1];
        for(int i = 0; i < linhaTracejo.length; i++){
            if (i % 6 < 4) {
                linhaTracejo[i] = "=";
            }else{
                linhaTracejo[i] = " ";
            }
            System.out.print(linhaTracejo[i]);
        }
    }
    //Mostrar pista.
    private void exibirPista(){
        // Efeito de tela fixa no terminal:

        // São códigos especiais (caracteres não imprimíveis) que, quando enviados ao console,
        // não são exibidos como texto, mas sim interpretados como comandos.

        // ANSI Escape: \033[H move o cursor para o topo, \033[2J limpa a tela
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Gerador de pista proporcional a distancia maxima estabelecida no construtor de Corrida.
        
        // Caso distanciaMaxima seja par.
        if (distanciaMaxima % 2 == 0) {
            for(int i = 0; i < (distanciaMaxima / 2); i++){
            System.out.print("- ");
            }
            System.out.println();
            carro1.desenhar(distanciaMaxima + 1);
            System.out.println();
            desenharTracejo(distanciaMaxima + 1);
            System.out.println();
            carro2.desenhar(distanciaMaxima + 1);
            System.out.println();
            for(int i = 0; i < (distanciaMaxima / 2); i++){
            System.out.print("- ");
            }
        }else { // Caso distanciaMaxima seja impar.
            for(int i = 0; i < (distanciaMaxima / 2) + 1; i++){
            System.out.print("- ");
            }
            System.out.println();
            carro1.desenhar(distanciaMaxima + 1);
            System.out.println();
            desenharTracejo(distanciaMaxima + 1);
            System.out.println();
            carro2.desenhar(distanciaMaxima + 1);
            System.out.println();
            for(int i = 0; i < (distanciaMaxima / 2) + 1; i++){
            System.out.print("- ");
            }
        }
        System.out.println();
        System.out.println("Carro 1: " + getCarro1().getDistancia());
        System.out.println("Carro 2: " + getCarro2().getDistancia());
    }
}
