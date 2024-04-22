package iwamih31.DQcsv;

import javax.swing.table.AbstractTableModel;

public class Gold extends AbstractTableModel{

	private static int g;
	private static Object[ ][ ] list = {
		{"Gold = ", g},
	};

	Gold(){
		g = Main.getG();
		list = new Object[ ][ ]{
				{"Gold = ", g},};
	}

	public void setList(String[][] setList) {
		Gold.list = setList;
	}

	public static Object[][] getList() {
		return list;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return list[0][columnIndex].getClass();
	}

	@Override
	public String getColumnName(int column) {
		return String.valueOf(list[0][column]);
	}

	@Override
	public int getRowCount() {
		return list.length;
	}

	@Override
	public int getColumnCount() {
		return list[0].length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		g = Main.getG();
		return list[rowIndex][columnIndex];
	}

}
