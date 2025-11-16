package es.deusto.prog3.examen.tabla;

import javax.swing.table.AbstractTableModel;

import es.deusto.prog3.examen.domain.PiezaAjedrez;

public class TableModel extends AbstractTableModel {
	private PiezaAjedrez[][] tablero;
	private String[] columnas = { " ", "a", "b", "c", "d", "e", "f", "g", "h", " " };

	public TableModel(PiezaAjedrez[][] tablero) {
		this.tablero = tablero;
	}

	@Override
	public String getColumnName(int columnIndex) {
	    return columnas[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		return tablero.length + 1;
	}

	@Override
	public int getColumnCount() {
		return columnas.length;
	}

	@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (rowIndex == getRowCount() - 1) {
			return columnas[columnIndex];
		}

		if (columnIndex == 0 || columnIndex == getColumnCount() - 1) {
			return 8 - rowIndex;
		}
		
		return tablero[rowIndex][columnIndex - 1];
	}

}
