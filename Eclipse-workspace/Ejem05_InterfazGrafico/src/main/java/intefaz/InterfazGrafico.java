package intefaz;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class InterfazGrafico extends JFrame {
	public InterfazGrafico(String tit, int width, int height) {
		setFrame(tit, width, height);

		

	}

	private void setFrame(String tit, int width, int height) {
		setTitle(tit);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	};
	private void initComponents() {
		JTextField nombreUsuario = new JTextField();
		JButton botonLogin = new JButton();
		botonLogin.setText("Ejecutar");
		botonLogin.addActionListener();
		add(botonLogin, BorderLayout.SOUTH);
		add(nombreUsuario, BorderLayout.NORTH);
		
	}
}