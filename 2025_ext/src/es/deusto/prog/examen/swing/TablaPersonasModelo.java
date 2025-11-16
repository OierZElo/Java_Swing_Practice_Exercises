package es.deusto.prog.examen.swing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import es.deusto.prog.examen.Persona;

public class TablaPersonasModelo extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	private List<Persona> personas;
	private List<String> header = Arrays.asList("Nombre", "Email", "Abonos", "Actividades");

	public TablaPersonasModelo(List<Persona> personas) {
		this.personas = personas;
	}


	@Override
	public int getRowCount() {
		return personas.size();
	}

	@Override
	public int getColumnCount() {
		return header.size();
	}

	@Override
	public String getColumnName(int column) {
		return header.get(column);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Persona p = personas.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getNombre();
		case 1:
			return p.getEmail();
		case 2:
			return p.getTipoAbono();
		case 3:
			return p.getActividades().size();
		default:
			return null;
		}
	}
}