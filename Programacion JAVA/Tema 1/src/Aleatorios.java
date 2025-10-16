
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Daniel González
 */
public class Aleatorios {

    public static void main(String[] args) {
        double mathNumeroAleatorio = Math.random(); //Opcion a
        Random randomNumeroAleatorio = new Random(); //Opcion b
            double numeroAleatorioA = randomNumeroAleatorio.nextDouble(-10, 10);
            double numeroAleatorioB = randomNumeroAleatorio.nextDouble(-10, 10);
            System.out.printf("Operando con los numeros %f y %f\n",numeroAleatorioA,numeroAleatorioB);
            System.out.printf("%f+%f=%f\n",numeroAleatorioA,numeroAleatorioB,(numeroAleatorioA+numeroAleatorioB));
            System.out.printf("%f-%f=%f\n",numeroAleatorioA,numeroAleatorioB,(numeroAleatorioA-numeroAleatorioB));
            System.out.printf("%f*%f=%f\n",numeroAleatorioA,numeroAleatorioB,(numeroAleatorioA*numeroAleatorioB));
            if (numeroAleatorioB!=0) {
                System.out.printf("%f/%f=%f\n",numeroAleatorioA,numeroAleatorioB,(numeroAleatorioA/numeroAleatorioB));
            System.out.print(numeroAleatorioA);
            System.out.print("%");
            System.out.printf("%f=%f\n",numeroAleatorioB,(numeroAleatorioA/numeroAleatorioB));
        
    }
        

        
          

    }
}
