package es.deusto.prog3.examen.tabla;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import es.deusto.prog3.examen.domain.PiezaAjedrez; 

public class VentanaTablero extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private PiezaAjedrez[][] tablero;

	public VentanaTablero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Chess Master 2000");
		setSize(800, 650);
		setLocationRelativeTo(null);
		 
		inicializarTablero();
		
		JTable tablaJuego = new JTable(new TableModel(tablero));
		
		JScrollPane scrollPane = new JScrollPane(tablaJuego);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		add(scrollPane);
		
		TableCellRenderer tableHeaderRenderer = new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, 
															Object value, 
															boolean isSelected, 
															boolean hasFocus,
															int row, 
															int column) {
				JLabel label = new JLabel(value.toString());
				label.setHorizontalAlignment(JLabel.CENTER);
				label.setVerticalAlignment(JLabel.CENTER);
				label.setFont(new Font("Arial", Font.BOLD, 16));
				return label;
			}
		};
		
		tablaJuego.getTableHeader().setDefaultRenderer(tableHeaderRenderer);
		
		TableCellRenderer tableRenderer = new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, 
															Object value, 
															boolean isSelected, 
															boolean hasFocus,
															int row, 
															int column) {
				JLabel label = new JLabel(value.toString());
				if(column == 0 || column == table.getColumnCount() - 1 || row == table.getRowCount() - 1) {
					label.setHorizontalAlignment(JLabel.CENTER);
					label.setVerticalAlignment(JLabel.CENTER);
					label.setFont(new Font("Arial", Font.BOLD, 16));
				}
				else {
					if((row + column) % 2 != 0) {
						label.setBackground(new Color(120, 151, 88));
					}
					else {
						label.setBackground(new Color(239, 238, 211));
					}	
					
					if(value != null) {
						PiezaAjedrez p = (PiezaAjedrez) value;
						String imagenPieza = p.getImagen();
						label.setText("");
						label.setIcon(new ImageIcon(imagenPieza));
					}
					label.setHorizontalAlignment(JLabel.CENTER);
					label.setVerticalAlignment(JLabel.CENTER);
				}
				label.setOpaque(true);
				return label;
			}
		};

		tablaJuego.setDefaultRenderer(Object.class, tableRenderer);
		
		tablaJuego.addMouseListener(new MouseAdapter() {
		    @Override
			public void mouseClicked(MouseEvent e) {
		    	int fila = tablaJuego.rowAtPoint(e.getPoint());
		    	int columna = tablaJuego.columnAtPoint(e.getPoint());
		    	
		    	if (columna == 0 || columna == tablaJuego.getColumnCount()-1 || fila == tablaJuego.getRowCount()-1) {
		    		return;
		    	}
		    	tablero[fila][columna - 1] = PiezaAjedrez.PEON_BLANCO;
		    	tablaJuego.repaint();
		    }
		});
		// TAREA 1.4 Implementa aquí la tarea
		tablaJuego.setRowHeight(66);

		
		setVisible(true);
	}
	

	private void inicializarTablero() {
		tablero = new PiezaAjedrez[8][8];
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				tablero[i][j] = PiezaAjedrez.VACIO;
			}
		}
		
		tablero[0][5] = PiezaAjedrez.REY_BLANCO;
		tablero[1][0] = PiezaAjedrez.PEON_BLANCO;
		tablero[1][3] = PiezaAjedrez.PEON_NEGRO;
		tablero[1][7] = PiezaAjedrez.PEON_NEGRO;
		tablero[2][1] = PiezaAjedrez.PEON_BLANCO;
		tablero[4][7] = PiezaAjedrez.REY_NEGRO;
		tablero[6][4] = PiezaAjedrez.PEON_NEGRO;
		tablero[7][2] = PiezaAjedrez.TORRE_BLANCA;
	}
	
	Object[][] convertirAString(PiezaAjedrez[][] tablero) {
		Object[][] tableroString = new Object[8][8];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tableroString[i][j] = tablero[i][j].getSimbolo();
			}
		}
		
		return tableroString;
	}
	
}
