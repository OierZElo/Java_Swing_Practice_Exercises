package es.deusto.prog.examen.parcial.render;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import es.deusto.prog.examen.parcial.Actividad;
import es.deusto.prog.examen.parcial.Sesion.DiaSemana;

public class HorarioGimnasioModel extends AbstractTableModel {
	
    private static final int HORA_INICIO = 9;
    private static final int HORA_FIN = 14;
    private List<Actividad> actividades;
    
    public HorarioGimnasioModel(List<Actividad> actividades) {
        this.actividades = actividades;
    }

	@Override
	public int getRowCount() {
		return HORA_FIN - HORA_INICIO;
	}

	@Override
	public int getColumnCount() {
		return DiaSemana.values().length + 1;
	}
	
	@Override
    public String getColumnName(int column) {
        if (column > 0) {
        	return DiaSemana.values()[column - 1].toString();
        } else {
            return "";
        }
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return String.format("%02d:00", HORA_INICIO + rowIndex);
		}
		else {
			DiaSemana dia = DiaSemana.values()[columnIndex - 1];
			int hora = HORA_INICIO + rowIndex;
			for(Actividad act : actividades) {
				if(act.getSesion(dia, hora) != null) {
					return act;
				}
			}
		}
		return "";
	}
	
	@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

}
