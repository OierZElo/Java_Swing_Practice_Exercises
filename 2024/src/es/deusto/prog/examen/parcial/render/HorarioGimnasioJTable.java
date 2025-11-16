// IAG (Claude 3.5 Sonnet y ChatGPT 4o)
// ADAPTADO: El código ha sido creado con Claude y refinado con ChatGPT 4o.
// La versión final ha sido convenientemente revisada para estar libre de errores.

package es.deusto.prog.examen.parcial.render;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import es.deusto.prog.examen.parcial.Actividad;

public class HorarioGimnasioJTable extends JFrame {
    private static final long serialVersionUID = 1L;
    private List<Actividad> actividades;
    
    public HorarioGimnasioJTable(List<Actividad> actividades) {
    	this.actividades = actividades;
    	        
        HorarioGimnasioModel modeloTabla = new HorarioGimnasioModel(this.actividades);
        
        JTable tablaActividades = new JTable(modeloTabla);
        
		tablaActividades.setShowGrid(false);
		tablaActividades.getTableHeader().setReorderingAllowed(false);
		tablaActividades.setRowHeight(64);
		
		TableCellRenderer headerRenderer = new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel result = new JLabel(value.toString());
				
				result.setHorizontalAlignment(JLabel.CENTER);
				result.setFont(new Font("Arial", Font.BOLD, 18));
				result.setBackground(Color.WHITE);
				result.setOpaque(true);
				
				return result;
			}
		};
		
		tablaActividades.getTableHeader().setDefaultRenderer(headerRenderer);
		
		TableCellRenderer cellRenderer = new TableCellRenderer() {
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				JLabel result = new JLabel();
				
				if(column == 0) {
					result.setFont(new Font("Arial", Font.BOLD, 18));
					result.setHorizontalAlignment(JLabel.CENTER);
					result.setText((String) value);
				}
				else if (value instanceof Actividad) {
					Actividad actividad = (Actividad) value;
					String imgName = actividad.getTipo().toString().toLowerCase() + ".png";
					String imagePath = "resources/images/" + imgName;
					result.setIcon(new ImageIcon(imagePath));
					result.setBackground(actividad.getTipo().getColor());
					result.setToolTipText(actividad.getTipo().toString());
					result.setHorizontalAlignment(JLabel.CENTER);
					result.setOpaque(true);
				}
				else {
					result.setText("");
				}
				return result;
			}
		};

        tablaActividades.setDefaultRenderer(Object.class, cellRenderer);
        
        KeyAdapter keyAdapt = new KeyAdapter() {
        	@Override
            public void keyPressed(KeyEvent e) {
        		if(e.getKeyCode() == KeyEvent.VK_E && e.isControlDown()) {
        			 int result = JOptionPane.showConfirmDialog(
                             null,
                             "¿Estás seguro de que quieres salir?",
                             "Confirmación de salida",
                             JOptionPane.YES_NO_OPTION,
                             JOptionPane.QUESTION_MESSAGE);
        			 
        			 if (result == JOptionPane.YES_OPTION) {
                         System.exit(0);
                     }
        		}
        	}
		};
		
		tablaActividades.addKeyListener(keyAdapt);
		
		this.add(tablaActividades.getTableHeader(), BorderLayout.NORTH);
		this.add(tablaActividades, BorderLayout.CENTER);

		JLabel lblFooter = new JLabel("<html><a href=\"\">Icons created by Freepik - Flaticon (https://www.flaticon.com/authors/freepik)</a><html>", JLabel.RIGHT);
		lblFooter.setForeground(Color.BLUE);
		this.add(lblFooter, BorderLayout.SOUTH);

		this.setTitle("Horario Semanal de Actividades");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setSize(800, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
    }
}