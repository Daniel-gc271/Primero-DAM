/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mapas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author goncalda
 */
public class InventarioApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Map<String, Integer> inventario = new HashMap<>();
        
        //Añadir entradas al inventario
        inventario.put("Raton",125 );
        inventario.put("Teclados", 87 );
        inventario.put("Monitor", 15 );
        inventario.put("Alfombrillas", 215 );
        inventario.put("RAM", 0 );
        inventario.put("SSD", 0 );
        System.out.println("Inventario completo");
        System.out.println(inventario);
        System.out.println("Clave concreta");
        int unidades=inventario.get("Alfombrillas");
        System.out.println("Unidades de teclado: "+unidades);
        System.out.println("Todas las keys");
        Set<String> setClaves =inventario.keySet();
        System.out.println(setClaves);
        System.out.println("Todos los values");
        Collection<Integer> listaUnidades = inventario.values();
        System.out.println(listaUnidades);
        
        Integer val=0;        
        //Inventario promedio
        for (Map.Entry<String, Integer> entry : inventario.entrySet()) {
             val += entry.getValue();
        }
        
        //Añadir ratones
        Double media = (double) val/inventario.size();
        System.out.println("Media cantidad: "+(media));
        
        
        Integer ratonesCount = inventario.get("Raton") +3;
        inventario.replace("Raton", ratonesCount);
//        inventario.put("Raton", 3);
        //Quitar cosas con value 0
        System.out.println("Quitar productos con value == 0");
        for (Map.Entry<String, Integer> entry : new HashMap<>(inventario).entrySet()) {
            if (entry.getValue()==0) {inventario.remove(entry.getKey());}
        }
        //Comprobar si contiene
        Boolean hayWC,hayM;
        hayWC=inventario.containsKey("Webcam");
        hayM=inventario.containsKey("Monitor");
        System.out.printf("Contiene Webcam: %b; Contiene moitor: %b",hayWC,hayM);
        System.out.println("Inventario completo");
        System.out.println(inventario);
    }

}
