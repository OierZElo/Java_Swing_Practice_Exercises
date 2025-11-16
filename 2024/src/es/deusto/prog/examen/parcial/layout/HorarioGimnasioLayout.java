// IAG (Claude 3.5 Sonnet y ChatGPT 4o)
// ADAPTADO: El código ha sido creado con Claude y refinado con ChatGPT 4o.
// La versión final ha sido convenientemente revisada para estar libre de errores.

package es.deusto.prog.examen.parcial.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import es.deusto.prog.examen.parcial.Actividad;
import es.deusto.prog.examen.parcial.Sesion;
import es.deusto.prog.examen.parcial.Sesion.DiaSemana;


public class HorarioGimnasioLayout extends JFrame {
	private static final int HORA_INICIO = 9;
	private static final int HORA_FIN = 14;
	private static final int HORAS_TOTALES = HORA_FIN - HORA_INICIO;



	private static final long serialVersionUID = 1L;
	private List<Actividad> actividades;

	public HorarioGimnasioLayout(List<Actividad> actividades) {
		this.actividades = actividades;

		//TODO: TAREA 1: Configurar el layaout del horario de actividades
		this.add(new JLabel("Añade aquí el horario de actividades", JLabel.CENTER));
		
		this.setTitle("Horario Semanal de Actividades");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		JPanel mainPanel = new JPanel(new GridLayout(HORAS_TOTALES + 1, DiaSemana.values().length, 5, 5));
		
		mainPanel.add(new JLabel(""));
		for(DiaSemana d : DiaSemana.values()) {
			JLabel labelDia = new JLabel(d.toString(), JLabel.CENTER);
			labelDia.setFont(new Font("Arial", Font.BOLD, 14));
			mainPanel.add(labelDia);
		}
		
		for (int i = 0; i < ((HORAS_TOTALES+1)*(DiaSemana.values().length)); i++) {
			JLabel labelDia;
			if(i % 6 == 0) {
				labelDia = new JLabel(String.format("%02d:00", (HORA_INICIO + i/6)), JLabel.CENTER);
			}else {
				int horaInicio = HORA_INICIO + i/6;
				DiaSemana diaSemana = DiaSemana.values()[i%6 - 1];

				labelDia = new JLabel();
				labelDia.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
				
				for(Actividad act : actividades) {
					Sesion s = act.getSesion(diaSemana, horaInicio);
					if (s != null) {
						labelDia = new JLabel(act.getTipo().toString(), JLabel.CENTER);
						labelDia.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
						labelDia.setBackground(act.getTipo().getColor());
						break;
					}
				}
			}
			labelDia.setFont(new Font("Arial", Font.BOLD, 14));
			labelDia.setOpaque(true);
			mainPanel.add(labelDia);
		}
		
		add(mainPanel, BorderLayout.CENTER);
	}
}