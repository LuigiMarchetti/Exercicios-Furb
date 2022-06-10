import java.util.Scanner;

public class Uni6Exe08 {
    public static void main(String[] args) {
        new Uni6Exe08();
    }
    public Uni6Exe08() {
        Scanner readLine = new Scanner(System.in);
        double[] array = CriarArrayAte20Posicoes(readLine);
        array = InserirValoresVetor(array, readLine);
        ImprimirValoresArray(array);
    }
    public double[] CriarArrayAte20Posicoes(Scanner readLine){
        System.out.println("Digite o tamanho do array que você deseja:");
        double[] array;
        teste: while (true){
            int tamanho = readLine.nextInt();
            if (tamanho <= 20 && tamanho >= 1){
                array = new double[tamanho];
                break teste;
            }
            System.out.println("Tente novamente\n");
        }



        return array;
    }
    public double[] InserirValoresVetor(double[] array, Scanner readLine){
        for (int i = 0; i < array.length; i++){
            System.out.println("Digite um valor real para inserir no array:");
            array[i] = readLine.nextDouble();
        }
        return array;
    }
    public void ImprimirValoresArray(double[] array){
        double[] numeros = new double[array.length];
        System.out.println("Valor  |  Frequência:\n");
        for (int i = 0; i < array.length; i++){
            int frequencia = 0;
            int numeroRepetidos = 0;
            for (int j = 0; j < array.length; j++){
                if (array[j] == array[i]){
                    frequencia++;
                    numeros[i] = array[j];
                }
                if (numeros[j] == array[i]){
                    numeroRepetidos++;
                }
            }
            if (frequencia > 0 && numeroRepetidos == 1){
                System.out.println(String.format("%s    |    %s", array[i], frequencia));

            }
        }
    }
}
