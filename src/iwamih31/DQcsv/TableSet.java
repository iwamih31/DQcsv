package iwamih31.DQcsv;

import javax.swing.table.TableModel;

public class TableSet {
	TableModel tableModel;
	String tableName;
	public TableSet(TableModel tableModel, String tableName) {
		super();
		this.tableModel = tableModel;
		this.tableName = tableName;
	}
}
