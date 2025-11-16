package es.deusto.ingenieria.prog3.checkin.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import es.deusto.ingenieria.prog3.checkin.domain.Seat;

public class AircraftTableModel extends AbstractTableModel {
	
	private List<Seat> seatsList;
	private Map<Integer, List<Seat>> seatsMap;	
	private List<String> header = Arrays.asList("", "A", "B", "C", "", "D", "E", "F");
	
	public AircraftTableModel(List<Seat> seats) {
		this.seatsList = seats;
		
		seatsMap = new HashMap<>();

		for (Seat seat : seats) {
			if (!seatsMap.containsKey(seat.getRow())) {
				seatsMap.put(seat.getRow(), new ArrayList<>() );
			}
			seatsMap.get(seat.getRow()).add(seat);		
		}
	}
	
	public List<Seat> getSeats() {
		return this.seatsList;
	}

	@Override
	public int getRowCount() {
		if (this.seatsMap != null) {
			return seatsMap.keySet().size();
		} else {
			return 0;
		}
	}

	@Override
	public int getColumnCount() {
		return header.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if(columnIndex == 0) {
			return rowIndex + 1;
		}
		else if (columnIndex == 4) {
			return "";
		}
		else if (columnIndex <= 3) {
			return seatsMap.get(rowIndex+1).get(columnIndex-1);
		}
		else {
			return seatsMap.get(rowIndex+1).get(columnIndex-2);
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return header.get(column);
	}
	
	@Override
	public boolean isCellEditable(int row, int column) {
		return false;
	}

}
