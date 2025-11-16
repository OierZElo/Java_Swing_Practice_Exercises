package es.deusto.prog.examen.threads;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.SwingUtilities;


public class MainThreads extends JFrame {

    private static final long serialVersionUID = 1L;

    private static final int COLUMNAS = 8;
    private static final int FILAS = 8;
    private ArrayList<Thread> hilos = new ArrayList<Thread>();

    private JPanel[][] paneles;

    public MainThreads() {
        setSize(640, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(FILAS, COLUMNAS));

        paneles = new JPanel[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
            	
                JPanel panel = new JPanel();
                panel.setBackground(Color.LIGHT_GRAY);
                panel.setOpaque(true);
                Border border = BorderFactory.createLineBorder(Color.BLACK);
                panel.setBorder(border);
                
                panelCentral.add(panel);
                paneles[i][j] = panel;   
                
                
            }
        }

        add(panelCentral, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        add(panelBotones, BorderLayout.SOUTH);

        JButton botonIniciar = new JButton("Iniciar");
        panelBotones.add(botonIniciar);

        JButton botonParar = new JButton("Parar");
        botonParar.setEnabled(false);
        panelBotones.add(botonParar);

        botonIniciar.addActionListener(e -> {
            botonIniciar.setEnabled(false);
            botonParar.setEnabled(true);
            
            for (int k = 0; k < paneles.length; k++) {
            	for (int i = 0; i < paneles[k].length; i++) {
            		final int fila = k;
                	final int columna = i;
                    Thread hiloPanel = new Thread(()->{
                    	while(!Thread.currentThread().isInterrupted()) {
                            try {
								Thread.sleep(periodoAleatorio());
							} catch (InterruptedException e1) {
								Thread.currentThread().interrupt();
							}
                    		cambiarEstado(fila, columna);
                    	}
                    });
                    hilos.add(hiloPanel);
                    hiloPanel.start();
				}
			}
        });

        botonParar.addActionListener(e -> {
            botonIniciar.setEnabled(true);
            botonParar.setEnabled(false);
            
            for (int i = 0; i < hilos.size(); i++) {
				hilos.get(i).interrupt();
			}
        });
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private int periodoAleatorio() {
        return (int) (Math.random() * 1500) + 500;
    }

    private void cambiarEstado(int fila, int columna) {
        if (paneles[fila][columna].getBackground().equals(Color.LIGHT_GRAY)) {
            paneles[fila][columna].setBackground(Color.RED);
        } else {
            paneles[fila][columna].setBackground(Color.LIGHT_GRAY);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainThreads::new);
    }
}
