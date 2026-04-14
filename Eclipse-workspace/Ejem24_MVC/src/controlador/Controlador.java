package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import modelo.Jugador;
import vista.InterfazGrafico;

public class Controlador implements ActionListener, KeyListener, ItemListener, MouseListener, WindowListener {

	private InterfazGrafico interfaz; 
	private List<Jugador> jugadores = new ArrayList<>();
	
	
	
	public void setInterfaz(InterfazGrafico interfaz) {
		this.interfaz=interfaz;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if (e.getSource()==interfaz.getBtnAgregar())
		{
			try {
		        String nombre = interfaz.getTxtNombre().getText();
		        int edad = Integer.parseInt(interfaz.getTxtEdad().getText());
		        String posicion = (String) interfaz.getComboPosicion().getSelectedItem();
		        boolean enForma = interfaz.getCheckEnForma().isSelected();
		
		        Jugador nuevo = new Jugador(nombre, posicion, edad, enForma);
		        jugadores.add(nuevo);
		        actualizarListado();
		        limpiarFormulario();
		    } catch (NumberFormatException ex) {
		        JOptionPane.showMessageDialog(interfaz, "Edad no válida", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		} else if (e.getSource()==interfaz.getComboPosicion())
		{
	            String pos = (String) interfaz.getComboPosicion().getSelectedItem();
	            switch (pos) {
	                case "Portero" -> interfaz.getPanelCampo().setBackground(Color.CYAN);
	                case "Defensa" -> interfaz.getPanelCampo().setBackground(Color.LIGHT_GRAY);
	                case "Centrocampista" -> interfaz.getPanelCampo().setBackground(Color.ORANGE);
	                case "Delantero" -> interfaz.getPanelCampo().setBackground(Color.PINK);
	                default -> interfaz.getPanelCampo().setBackground(null);
	            }
	        
		}
			
	}
	
	 private void actualizarListado() {
	        StringBuilder sb = new StringBuilder("📋 Lista de Jugadores:\n");
	        for (Jugador j : jugadores) {
	            sb.append(j).append("\n");
	        }
	        interfaz.getAreaJugadores().setText(sb.toString());
	    }
	 
	 private void limpiarFormulario() {
	        interfaz.getTxtNombre().setText("");
	        interfaz.getTxtEdad().setText("");
	        interfaz.getCheckEnForma().setSelected(false);
	        interfaz.getComboPosicion().setSelectedIndex(0);
	    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		interfaz.getLblEstadoNombre().setText("Longitud nombre: " + interfaz.getTxtNombre().getText().length());
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
	    System.out.println("Jugador está en forma: " + (e.getStateChange() == ItemEvent.SELECTED));
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(interfaz,
                "Entrada registrada en el campo (x=" + e.getX() + ", y=" + e.getY() + ")",
                "Campo deportivo", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Aplicación cerrándose. Jugadores guardados: " + jugadores.size());
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
