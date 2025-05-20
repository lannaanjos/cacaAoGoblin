import java.util.Random;
import java.util.Scanner;

public class Principal {
    public static void limpaTerminal(){
        String os = System.getProperty("os.name");
        try{
            if(os.startsWith("Windows")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();   
            }
        } catch (Exception e){
            System.out.print("Erro ao limpar o terminal: " + e.getMessage());
        }
    }

    public static int montaJogo(){
        Random gerador = new Random();
        int caixaGoblin = gerador.nextInt(5) + 1;
        return caixaGoblin;
    }

    public static void partida(){
        //  Aleatoriza caixa em que o goblin está
        int caixaContendo = montaJogo();
        //  Mostra as caixas
        System.out.printf("|_1_| |_2_| |_3_| |_4_| |_5_|\n");
        //  Perguntas e respostas
        int escolha = 0;
        System.out.printf("Em que caixa você acha que o goblin está? ");
        escolha = Integer.parseInt(ScannerGlobal.leEntrada().nextLine());
        while (escolha != caixaContendo) {
            System.out.printf("Desculpe! O goblin está à espreita em outro lugar.\nEscolha outra caixa: ");
            escolha = Integer.parseInt(ScannerGlobal.leEntrada().nextLine());
        }
        System.out.printf("Bom trabalho! Você encontrou o goblin!!!\nDeseja jogar novamente? (S/N)\nSua resposta: ");
        String novamente = ScannerGlobal.leEntrada().nextLine();
        if(novamente.equalsIgnoreCase("s") || novamente.equalsIgnoreCase("sim")){
            System.out.printf("Beleza! Aperte enter para jogar novamente...");
            ScannerGlobal.leEntrada().nextLine();
            limpaTerminal();
            partida();
        } else {
            System.out.printf("Beleza! Aperte enter para voltar ao menu inicial...");
            ScannerGlobal.leEntrada().nextLine();
            limpaTerminal();
        }
    }

    public static void jogo(){
        System.out.printf("Digite seu nome: ");
        String nomeJogador = ScannerGlobal.leEntrada().nextLine();
        System.out.printf("%s, você acha que pode encontrar o goblin escondido nas caixas? (S/N)\nSua resposta: ", nomeJogador);
        String resposta = ScannerGlobal.leEntrada().nextLine();
        if(resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("Sim")){
            partida();
        } else {
            System.out.printf("Que pena!\nPressione enter para voltar ao menu inicial...\n");
            ScannerGlobal.leEntrada().nextLine();
            limpaTerminal();
        }
    }
    public static void main(String[] args){
        int escolha = 0;
        do {
            String asciiArt = "   ___      __                _____     __   ___    \n" +
            "  / _ |____/ /  ___   ___    / ___/__  / /  / (_)__ \n" +
            " / __ / __/ _ \\/ -_) / _ \\  / (_ / _ \\/ _ \\/ / / _ \\\n" +
            "/_/ |_\\__/_//_/\\__/  \\___/  \\___/\\___/_.__/_/_/_//_/";
            System.out.print(asciiArt);
            System.out.print("\n\n1. Entrar\n2. Sair\n\nSua escolha: ");
            escolha = Integer.parseInt(ScannerGlobal.leEntrada().nextLine());
            if(escolha == 1){
                limpaTerminal();
                jogo();
            } else if(escolha == 2){
                System.out.printf("Até mais!\nPrograma encerrado...");
            }
        } while(escolha != 2);
    }
}

class ScannerGlobal{
    static Scanner entrada = new Scanner(System.in);

    public static Scanner leEntrada(){
        return entrada;
    }
}
