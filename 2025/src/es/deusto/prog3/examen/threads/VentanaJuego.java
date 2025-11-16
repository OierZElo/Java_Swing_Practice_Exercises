package es.deusto.prog3.examen.threads;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import es.deusto.prog3.examen.domain.PiezaAjedrez;


public class VentanaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private int TABLERO_ANCHO = 12;
	private int TABLERO_ALTO = 12;
	
	private int TIEMPO_JUEGO = 15; // segundos
	private int TIEMPO_PEON = 1000; // milisegundos
	
	private JButton[] botones;
	private JButton iniciarJuego;
	private JLabel labelTiempo;
	
	private ImageIcon imgPeon;
	private boolean peonCazado;
	
	private Thread hiloTiempo;
	private Thread hiloPeon;
	
	private int r;
	
	private int tiempo = TIEMPO_JUEGO;

	public VentanaJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Caza el peón");
		setSize(600, 600);
		setLocationRelativeTo(null);
		
		JPanel panelPrincipal = new JPanel();
		add(panelPrincipal, BorderLayout.CENTER);

		botones = new JButton[TABLERO_ANCHO * TABLERO_ALTO];
		panelPrincipal.setLayout(new GridLayout(TABLERO_ANCHO, TABLERO_ALTO));
		for (int i = 0; i < TABLERO_ANCHO * TABLERO_ALTO; i++) {
			botones[i] = new JButton();
			panelPrincipal.add(botones[i]);
			
			botones[i].addActionListener(e -> {
				clickBoton((JButton) e.getSource());
			});
		}
		
		JPanel panelInferior = new JPanel();
		add(panelInferior, BorderLayout.SOUTH);
		
		iniciarJuego = new JButton("Iniciar");
		panelInferior.add(iniciarJuego);
	
		
		
		iniciarJuego.addActionListener(e -> {
			tiempo = TIEMPO_JUEGO;
			botones[r].setIcon(null);
			actualizarTiempo(tiempo);
			iniciarJuego.setEnabled(false);
			peonCazado = false;
			
			hiloTiempo = new Thread(() -> {
				while(tiempo > 0) {
					try {
							Thread.sleep(1000);
							tiempo = tiempo -1;
							SwingUtilities.invokeLater(() -> actualizarTiempo(tiempo));
						
					} catch (InterruptedException e1) {
						Thread.currentThread().interrupt();
					}
				}
				SwingUtilities.invokeLater(()->mostrarFinJuego());
			});
			
			hiloPeon = new Thread(() -> {
				while(!Thread.currentThread().isInterrupted()) {
					try {
						r = ThreadLocalRandom.current().nextInt(0, botones.length);
						botones[r].setIcon(imgPeon);
						Thread.sleep(TIEMPO_PEON);
						botones[r].setIcon(null);
					} catch (InterruptedException e1) {
						Thread.currentThread().interrupt();
					}
				}
			});
			
			hiloPeon.start();
			hiloTiempo.start();
		});
		
		labelTiempo = new JLabel();
		labelTiempo.setHorizontalAlignment(JLabel.CENTER);
		add(labelTiempo, BorderLayout.NORTH);
		actualizarTiempo(TIEMPO_JUEGO);
		
		imgPeon = new ImageIcon(PiezaAjedrez.PEON_BLANCO.getImagen());
		
		setVisible(true);	
	}
	
	// método llamado cuando se hace click 
	private void clickBoton(JButton boton) {
		if (boton.getIcon() != null) {
			peonCazado = true;
			
			hiloTiempo.interrupt();
			hiloPeon.interrupt();
			
			mostrarEnhorabuena();
			iniciarJuego.setEnabled(true);
		}
	}
		
	// actualiza el label a partir del tiempo en segundos actual
	private void actualizarTiempo(int tiempoSegundos) {
		int minutos = (tiempoSegundos % 3600) / 60;
		int segundos = tiempoSegundos % 60;
		
		LocalTime tiempo = LocalTime.of(0, minutos, segundos);
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
		labelTiempo.setText("Tiempo restante: " + formato.format(tiempo));
	}
	
	// mostrar mensaje de fin de juego
	private void mostrarFinJuego() {
		hiloTiempo.interrupt();
		hiloPeon.interrupt();
		JOptionPane.showMessageDialog(VentanaJuego.this, "¡El tiempo se ha terminado!", "Fin del juego", JOptionPane.OK_OPTION);
		iniciarJuego.setEnabled(true);
	}
	
	private void mostrarEnhorabuena() {
		hiloTiempo.interrupt();
		hiloPeon.interrupt();
		JOptionPane.showMessageDialog(VentanaJuego.this, "¡Enhorabuena! Has conseguido cazar el péon", "¡Bien hecho!", JOptionPane.OK_OPTION);
	}
}
