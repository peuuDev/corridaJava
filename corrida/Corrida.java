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

            //Verificar se tem vencedor.
            if (carro1.getDistancia() >= distanciaMaxima && carro2.getDistancia() >= distanciaMaxima){
                if (carro1.getDistancia() > carro2.getDistancia()){
                    System.out.println("Carro 1 venceu!");
                }else if (carro2.getDistancia() > carro1.getDistancia()){
                    System.out.println("Carro 2 venceu!");
                }else if (carro1.getDistancia() == carro2.getDistancia()){
                    System.out.println("Empate!");
                } break;
            }else if (carro1.getDistancia() >= distanciaMaxima){
                System.out.println("Carro 1 venceu!");
                break;
            }else if (carro2.getDistancia() >= distanciaMaxima){
                System.out.println("Carro 2 venceu!");
                break;
            }
            
        }
    }

    //Mostrar pista.
    private void exibirPista(){
        if (distanciaMaxima % 2 == 0) {
            for(int i = 0; i < (distanciaMaxima / 2); i++){
            System.out.print("- ");
            }
            System.out.println();
            carro1.desenhar(distanciaMaxima + 1);
            System.out.println();
            carro2.desenhar(distanciaMaxima + 1);
            System.out.println();
            for(int i = 0; i < (distanciaMaxima / 2); i++){
            System.out.print("- ");
            }
        }else {
            for(int i = 0; i < (distanciaMaxima / 2) + 1; i++){
            System.out.print("- ");
            }
            System.out.println();
            carro1.desenhar(distanciaMaxima + 1);
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