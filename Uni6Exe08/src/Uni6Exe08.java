import java.util.Scanner;

public class Uni6Exe08 {
    public static void main(String[] args) {
        new Uni6Exe08();
    }
    public Uni6Exe08() {
        Scanner readLine = new Scanner(System.in);
        int[] array = CriarArrayAte20Posicoes(readLine);

    }
    public int[] CriarArrayAte20Posicoes(Scanner readLine){
        System.out.println("Digite o tamanho do array que você deseja:");
        int[] array;
        teste: while (true){
            int tamanho = readLine.nextInt();
            if (tamanho <= 20 && tamanho >= 1){
                array = new int[tamanho];
                break teste;
            }
            System.out.println("Tente novamente\n");
        }



        return array;
    }
}
