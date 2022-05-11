import java.util.Scanner;
import java.text.DecimalFormat;
public class Uni05Ex05{
    public static void main(String[] args) {
        Scanner readLine = new Scanner (System.in);
        int n = readLine.nextInt();
        double sequencia = 8;
        DecimalFormat df = new DecimalFormat("0");
        
        if(n >= 2){

        
        n -= 1;
        System.out.print(df.format(sequencia)+ " ");
            for(int i = 0; i < n; i++){
                if(i % 2 == 0){
                 
                   System.out.print(df.format(sequencia+ 2)+ " ");
                }
                else{
             
                    System.out.print(df.format(sequencia * 2)+ " ");
                    sequencia = sequencia *2;
                }
            }
      
        }
        else{
            System.out.println("Valor invalido");
        }
        

        readLine.close();
    }
}