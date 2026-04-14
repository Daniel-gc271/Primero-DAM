import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDeportistas extends JFrame {

    // MODELO
    static class Jugador {
        private String nombre;
        private String posicion;
        private int edad;
        private boolean enForma;

        public Jugador(String nombre, String posicion, int edad, boolean enForma) {
            this.nombre = nombre;
            this.posicion = posicion;
            this.edad = edad;
            this.enForma = enForma;
        }

        @Override
        public String toString() {
            return String.format("Nombre: %s | Posición: %s | Edad: %d | En forma: %s",
                    nombre, posicion, edad, enForma ? "Sí" : "No");
        }
    }

    // VISTA Y CONTROL
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JComboBox<String> comboPosicion;
    private JCheckBox checkEnForma;
    private JButton btnAgregar;
    private JTextArea areaJugadores;
    private JLabel lblEstadoNombre;
    private JPanel panelCampo;

    private List<Jugador> jugadores = new ArrayList<>();

    public GestorDeportistas() {
        super("Gestión de Jugadores de Equipo Deportivo");

        setLayout(new BorderLayout(10, 10));
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel de formulario
        JPanel panelFormulario = new JPanel(new GridLayout(5, 2, 5, 5));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Nuevo Jugador"));

        txtNombre = new JTextField();
        txtEdad = new JTextField();
        comboPosicion = new JComboBox<>(new String[]{"Portero", "Defensa", "Centrocampista", "Delantero"});
        checkEnForma = new JCheckBox("Está en forma");
        btnAgregar = new JButton("Agregar jugador");
        lblEstadoNombre = new JLabel("Longitud nombre: 0");

        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);
        panelFormulario.add(new JLabel("Edad:"));
        panelFormulario.add(txtEdad);
        panelFormulario.add(new JLabel("Posición:"));
        panelFormulario.add(comboPosicion);
        panelFormulario.add(new JLabel(""));
        panelFormulario.add(checkEnForma);
        panelFormulario.add(lblEstadoNombre);
        panelFormulario.add(btnAgregar);

        add(panelFormulario, BorderLayout.NORTH);

        // Área de resultados
        areaJugadores = new JTextArea();
        areaJugadores.setEditable(false);
        add(new JScrollPane(areaJugadores), BorderLayout.CENTER);

        // Panel de juego/campo con ratón
        panelCampo = new JPanel();
        panelCampo.setPreferredSize(new Dimension(200, 100));
        panelCampo.setBackground(Color.GREEN);
        panelCampo.setToolTipText("Haz clic en el campo para registrar entrada");
        add(panelCampo, BorderLayout.SOUTH);

        // EVENTOS

        // Botón
        btnAgregar.addActionListener(e -> agregarJugador());

        // Campo de texto: mostrar longitud del nombre
        txtNombre.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                lblEstadoNombre.setText("Longitud nombre: " + txtNombre.getText().length());
            }
        });

        // Combo: cambia color según posición
        comboPosicion.addActionListener(e -> {
            String pos = (String) comboPosicion.getSelectedItem();
            switch (pos) {
                case "Portero" -> panelFormulario.setBackground(Color.CYAN);
                case "Defensa" -> panelFormulario.setBackground(Color.LIGHT_GRAY);
                case "Centrocampista" -> panelFormulario.setBackground(Color.ORANGE);
                case "Delantero" -> panelFormulario.setBackground(Color.PINK);
                default -> panelFormulario.setBackground(null);
            }
        });

        // Check: mostrar estado en consola
        checkEnForma.addItemListener(e -> {
            System.out.println("Jugador está en forma: " + (e.getStateChange() == ItemEvent.SELECTED));
        });

        // Mouse: clic en el campo
        panelCampo.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(GestorDeportistas.this,
                        "Entrada registrada en el campo (x=" + e.getX() + ", y=" + e.getY() + ")",
                        "Campo deportivo", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Ventana: advertencia al cerrar
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Aplicación cerrándose. Jugadores guardados: " + jugadores.size());
            }
        });

        setVisible(true);
    }

    private void agregarJugador() {
        try {
            String nombre = txtNombre.getText();
            int edad = Integer.parseInt(txtEdad.getText());
            String posicion = (String) comboPosicion.getSelectedItem();
            boolean enForma = checkEnForma.isSelected();

            Jugador nuevo = new Jugador(nombre, posicion, edad, enForma);
            jugadores.add(nuevo);
            actualizarListado();
            limpiarFormulario();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Edad no válida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarListado() {
        StringBuilder sb = new StringBuilder("📋 Lista de Jugadores:\n");
        for (Jugador j : jugadores) {
            sb.append(j).append("\n");
        }
        areaJugadores.setText(sb.toString());
    }

    private void limpiarFormulario() {
        txtNombre.setText("");
        txtEdad.setText("");
        checkEnForma.setSelected(false);
        comboPosicion.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GestorDeportistas::new);
    }
}
