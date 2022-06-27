import java.util.Scanner;

public class Trabalho {
    public static void main(String[] args) {
        new Trabalho();
    }
    public Trabalho(){
        Scanner scan = new Scanner(System.in);

        String[][] palavras = new String[5][2];
        char[][] mapa = new char[10][5];

        int opcao;

        mapa = mapaEntrada(mapa);
        palavras = palavrasEntrada(palavras);
        mapaPesquisa(mapa, palavras);
        palavrasRespostas(palavras);

        do {
            System.out.println("_____ Menu: Caça Palavras _____");
            System.out.println("1. listar Palavras");
            System.out.println("2. listar mapa");
            System.out.println("3. listar respostas");
            System.out.println("4. sair");
            System.out.print(" __ opç?o: ");
            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    palavrasImprimir(palavras);
                    break;
                case 2:
                    mapaImprimir(mapa);
                    break;
                case 3:
                    listaImprimir(palavras);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção ERRADA!...");
            }
        }while(opcao != 4);
        scan.close();
    }

    public void palavrasImprimir(String[][] palavras){
        for (int i = 0; i < palavras.length; i++) {
            System.out.println(palavras[i][0]);
        }
    }
    public String[][] palavrasEntrada(String[][] palavras){
        palavras[0][0] = "IFELSE";
        palavras[1][0] = "FORA";
        palavras[2][0] = "WHILE";
        palavras[3][0] = "OBJETO";
        palavras[4][0] = "VETOR";
        return palavras;
    }

    public char[][] mapaEntrada(char[][] mapa){
        mapa[0][0] = 'C'; mapa[0][1] = 'C'; mapa[0][2] = 'Q'; mapa[0][3] = 'W'; mapa[0][4] = 'E';
        mapa[1][0] = 'I'; mapa[1][1] = 'X'; mapa[1][2] = 'F'; mapa[1][3] = 'O'; mapa[1][4] = 'R';
        mapa[2][0] = 'F'; mapa[2][1] = 'F'; mapa[2][2] = 'R'; mapa[2][3] = 'G'; mapa[2][4] = 'F';
        mapa[3][0] = 'E'; mapa[3][1] = 'L'; mapa[3][2] = 'I'; mapa[3][3] = 'H'; mapa[3][4] = 'W';
        mapa[4][0] = 'L'; mapa[4][1] = 'S'; mapa[4][2] = 'F'; mapa[4][3] = 'O'; mapa[4][4] = 'U';
        mapa[5][0] = 'S'; mapa[5][1] = 'D'; mapa[5][2] = 'G'; mapa[5][3] = 'T'; mapa[5][4] = 'S';
        mapa[6][0] = 'E'; mapa[6][1] = 'J'; mapa[6][2] = 'H'; mapa[6][3] = 'E'; mapa[6][4] = 'T';
        mapa[7][0] = 'I'; mapa[7][1] = 'I'; mapa[7][2] = 'I'; mapa[7][3] = 'J'; mapa[7][4] = 'M';
        mapa[8][0] = 'X'; mapa[8][1] = 'C'; mapa[8][2] = 'K'; mapa[8][3] = 'B'; mapa[8][4] = 'G';
        mapa[9][0] = 'V'; mapa[9][1] = 'E'; mapa[9][2] = 'T'; mapa[9][3] = 'O'; mapa[9][4] = 'R';
        return mapa;
    }

    public void mapaImprimir(char[][] mapa){
        String linha;
        for (int i = 0; i < mapa.length; i++) {
            System.out.println("---------------------");
            linha = "";
            for (int j = 0; j < mapa[0].length; j++){
                linha +="| " + mapa[i][j] + " ";
            }
            linha += "|";
            System.out.println(linha);
            System.out.println("---------------------");
        }
    }
    public void mapaPesquisa(char[][] mapa, String[][] palavras){

        for (int palavra = 0; palavra < palavras.length; palavra++){ //Roda as palavras

            int numeroDoCaracter = 0;
            int localizacaoPrimeiroCaracterLinha = 0;
            int localizacaoPrimeiroCaracterColuna = 0;


            for (int coluna = 0; coluna < mapa.length; coluna++){ //Roda o caça palavras da esquerda pra direita
                for (int linha = 0; linha < mapa[0].length; linha++){
                    if (palavras[palavra][0].charAt(numeroDoCaracter) == mapa[coluna][linha]){
                        numeroDoCaracter++;
                        if (numeroDoCaracter == 1){
                            localizacaoPrimeiroCaracterLinha = linha;
                            localizacaoPrimeiroCaracterColuna = coluna;
                        }
                        if (numeroDoCaracter == palavras[palavra][0].length()){
                            palavras[palavra][1] = "[" + localizacaoPrimeiroCaracterColuna + "," + localizacaoPrimeiroCaracterLinha + "]";
                            numeroDoCaracter = 0;
                        }
                    }
                    else {
                        numeroDoCaracter = 0;
                    }
                }
            }
            numeroDoCaracter = 0;

            for (int coluna = 0; coluna < mapa.length; coluna++){ //Roda o caça palavras da direito pra esquerda
                for (int linha = mapa[0].length - 1; linha >= 0; linha--){
                    if (palavras[palavra][0].charAt(numeroDoCaracter) == mapa[coluna][linha]){
                        numeroDoCaracter++;
                        if (numeroDoCaracter == 1){
                            localizacaoPrimeiroCaracterLinha = linha;
                            localizacaoPrimeiroCaracterColuna = coluna;
                        }
                        if (numeroDoCaracter == palavras[palavra][0].length()){
                            palavras[palavra][1] = "[" + localizacaoPrimeiroCaracterColuna + "," + localizacaoPrimeiroCaracterLinha + "]";
                            numeroDoCaracter = 0;
                        }
                    }
                    else {
                        numeroDoCaracter = 0;
                    }
                }
            }
            numeroDoCaracter = 0;

            for (int linha = 0; linha < mapa[0].length; linha++){ //Roda o caça palavras de cima pra baixo
                for (int coluna = 0; coluna < mapa.length; coluna++){
                    if (palavras[palavra][0].charAt(numeroDoCaracter) == mapa[coluna][linha]){
                        numeroDoCaracter++;
                        if (numeroDoCaracter == 1){
                            localizacaoPrimeiroCaracterLinha = linha;
                            localizacaoPrimeiroCaracterColuna = coluna;
                        }
                        if (numeroDoCaracter == palavras[palavra][0].length()){
                            palavras[palavra][1] = "[" + localizacaoPrimeiroCaracterColuna + "," + localizacaoPrimeiroCaracterLinha + "]";
                            numeroDoCaracter = 0;
                        }
                    }
                    else {
                        numeroDoCaracter = 0;
                    }
                }
            }
            numeroDoCaracter = 0;

            for (int linha = 0; linha < mapa[0].length; linha++){ //Roda o caça palavras de baixo pra cima
                for (int coluna = mapa.length - 1; coluna >= 0; coluna--){
                    if (palavras[palavra][0].charAt(numeroDoCaracter) == mapa[coluna][linha]){
                        numeroDoCaracter++;
                        if (numeroDoCaracter == 1){
                            localizacaoPrimeiroCaracterLinha = linha;
                            localizacaoPrimeiroCaracterColuna = coluna;
                        }
                        if (numeroDoCaracter == palavras[palavra][0].length()){
                            palavras[palavra][1] = "[" + localizacaoPrimeiroCaracterColuna + "," + localizacaoPrimeiroCaracterLinha + "]";
                            numeroDoCaracter = 0;
                        }
                    }
                    else {
                        numeroDoCaracter = 0;
                    }
                }
            }

        }
    }
    public String[][] palavrasRespostas(String[][] palavras){
        for (int i = 0; i < palavras.length; i++)
            if(palavras[i][1] == null){
                palavras[i][1] ="Palavra NÃO encontrada";
            }
            else {
                palavras[i][1] += " - " + palavras[i][0];
            }

        return palavras;
    }
    public void listaImprimir(String[][] palavras){
        for (int i = 0; i < palavras.length; i++)
                System.out.println(palavras[i][1]);
    }
}