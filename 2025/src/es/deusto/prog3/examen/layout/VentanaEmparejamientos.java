package es.deusto.prog3.examen.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import es.deusto.prog3.examen.domain.Emparejamiento;
import es.deusto.prog3.examen.domain.Jugador;

public class VentanaEmparejamientos extends JFrame {
	private JPanel mainPanel = new JPanel(new GridLayout(3,1));

	private static final long serialVersionUID = 1L;
	
	private int MAX_EMPAREJAMIENTOS = 3;	
	
	public VentanaEmparejamientos(Map<LocalDate, List<Emparejamiento>> emparejamientos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Emparejamientos Campeonato");
		setSize(800, 600);
		setLocationRelativeTo(null);
		
		
		
		DefaultListModel<LocalDate> modeloLista = new DefaultListModel<>();	
		for (LocalDate dia : emparejamientos.keySet()) {
			modeloLista.addElement(dia);
		}
		
		JList<LocalDate> jList = new JList<>(modeloLista);
		add(jList, BorderLayout.WEST);
		
		jList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					List<Emparejamiento> emparejamientosDia = emparejamientos.get(jList.getSelectedValue());
					mostrarEmparejamientos(emparejamientosDia);
					revalidate();
				}
			}
		});
		add(mainPanel, BorderLayout.CENTER);
		setVisible(true);
	}
	
	private void mostrarEmparejamientos(List<Emparejamiento> emparejamientosDia) {
		mainPanel.removeAll();
		for (int i = 0; i < emparejamientosDia.size(); i++) {
			JPanel filaEmparejamiento = new JPanel(new GridLayout(1,2));
			Jugador j1 = emparejamientosDia.get(i).getJugador1();
			Jugador j2 = emparejamientosDia.get(i).getJugador2();
			LocalTime hora = emparejamientosDia.get(i).getHora();
			
			filaEmparejamiento.add(createInfo(j1, hora));
			filaEmparejamiento.add(createInfo(j2, hora));
			
			mainPanel.add(filaEmparejamiento);

			revalidate();
			repaint();
		}
	}
	
	private ImageIcon cargarImagen(String imagen, Dimension dimension) {
		ImageIcon imageIcon = new ImageIcon(imagen);
		Image img = imageIcon.getImage();
		Image newimg = img.getScaledInstance((int) dimension.getWidth(), (int) dimension.getHeight(),  java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newimg);
	}
	
	private JPanel createInfo(Jugador j, LocalTime t) {
		JPanel mainJugador = new JPanel(new BorderLayout());
		mainJugador.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		JLabel norte =  new JLabel("Enfrentamiento ("+ t + ")");
		norte.setOpaque(true);
		norte.setBackground(Color.LIGHT_GRAY);
		norte.setFont(new Font("Arial", Font.BOLD, 16));
		
		
		String[] extensiones = {".png", ".jpg", ".jpeg"};
		ImageIcon icon = null;

		for (String ext : extensiones) {
		    String path = "C:\\Users\\oier.z\\Desktop\\202511-fuentes\\resources\\images\\profiles\\"+ j.getNombre().toLowerCase() +"_"+ j.getApellido().toLowerCase() + ext;
		    File f = new File(path);
		    if (f.exists()) {
		        icon = cargarImagen(path, new Dimension(50,50));
		    }
		}
		
		if(icon == null) {System.out.println("err imgn not found");}
		
		JLabel labelImagen = new JLabel(icon);
		labelImagen.setVerticalAlignment(JLabel.TOP);
		labelImagen.setBorder(BorderFactory.createEmptyBorder(10,0,0,0));

		mainJugador.add(labelImagen, BorderLayout.EAST);
		JPanel infoPanel = new JPanel(new GridLayout(4,1));
		infoPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
		JLabel nombre = new JLabel("Nombre: "+ j.getNombre());
		JLabel apellido = new JLabel("Apellido: "+ j.getApellido());
		JLabel puntuacion = new JLabel("Puntuación: "+ j.getPuntuacion());
		JLabel pais = new JLabel("País: "+ j.getPais());
		
		infoPanel.add(nombre);
		infoPanel.add(apellido);
		infoPanel.add(puntuacion);
		infoPanel.add(pais);
		
		mainJugador.add(norte, BorderLayout.NORTH);
		mainJugador.add(infoPanel, BorderLayout.CENTER);

		return mainJugador;
	}
}
