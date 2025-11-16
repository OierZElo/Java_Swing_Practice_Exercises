package es.deusto.prog.examen.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

import es.deusto.prog.examen.Persona;

public class TablaPersonas extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTable tablaPersonas;
    private JButton[] botones = {new JButton("SIMPLE"), new JButton("DUO"), new JButton("COMPLETO")};
    private String tipoElegido;

    public TablaPersonas(List<Persona> personas) {
        super("Tabla de personas");
        setSize(800, 600);

        JPanel main = new JPanel(new BorderLayout());
        JPanel panelBotones = new JPanel(new FlowLayout());
        TablaPersonasModelo modelo = new TablaPersonasModelo(personas);
        tablaPersonas = new JTable(modelo);

  
        for(int i = 0; i < botones.length; i++) {
        	panelBotones.add(botones[i]);
        	final int botonIndex = i;
        	botones[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					switch (botonIndex) {
					case 0: {
						tipoElegido = "SIMPLE";
						break;
					}
					case 1: {
						tipoElegido = "DUO";
						break;
					}
					case 2: {
						tipoElegido = "COMPLETO";
						break;
					}
					default:
					}
					tablaPersonas.repaint();
				}
			});
        }
        
        
        
        main.add(panelBotones, BorderLayout.NORTH);
        
        JScrollPane scrollPane = new JScrollPane(tablaPersonas);
        main.add(scrollPane, BorderLayout.CENTER);
        add(main);

        // TODO Tarea 1 - Swing: Añade aquí el código para la visualización
        
        TableCellRenderer cellRenderer = new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, 
															Object value, 
															boolean isSelected, 
															boolean hasFocus,
															int row, 
															int column) {
				JLabel tipoAbono;
				if(column == 2) {
						tipoAbono = new JLabel(value.toString());
						switch (value.toString()) {
						case "COMPLETO": {
							tipoAbono.setForeground(Color.green);
							break;
						}
						case "DUO": {
							tipoAbono.setForeground(Color.blue);
							break;
						}
						case "SIMPLE": {
							tipoAbono.setForeground(Color.yellow);
							break;
						}
						default:
						}
						tipoAbono.setOpaque(true);
					}
				else {
					tipoAbono = new JLabel(value.toString());
				}
		        tipoAbono.setBackground(Color.WHITE);
		        
			        if (column == 2 && value != null && value.toString().equals(tipoElegido)) {
			            tipoAbono.setBackground(Color.YELLOW);
			            tipoAbono.setForeground(Color.black);
		        }
		        
		        
				tipoAbono.setOpaque(true);
				return tipoAbono;
			}
		};
		tablaPersonas.setDefaultRenderer(Object.class, cellRenderer);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
