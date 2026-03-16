/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.cola_BIS;

import java.util.LinkedList;
import javax.swing.AbstractListModel;

/**
 *
 * @author macarena
 */
public class MiModeloLista extends AbstractListModel<Documento> {

    private final LinkedList<Documento> cola;

    public MiModeloLista(LinkedList<Documento> cola) {
        this.cola = cola;
    }

    public void add(Documento d) {
        cola.add(d);
        int index = cola.size() - 1;
        fireIntervalAdded(this, index, index); //se notifica a la JList que se ha a?adido
    }

    public void removeFirst() {
        cola.removeFirst();
        fireIntervalRemoved(this, 0, 0); //se notifica a la JList que se ha eliminado
    }

    @Override
    public int getSize() {
        return cola.size();
    }

    @Override
    public Documento getElementAt(int index) {
        return cola.get(index);
    }
}
