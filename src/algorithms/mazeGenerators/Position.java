package algorithms.mazeGenerators;

public class Position {

    private int rowIndex;
    private int columnIndex;

    Position(int row, int column) {
        this.rowIndex = row;
        this.columnIndex = column;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }

    public void setColumnIndex(int newColumn) {
        this.columnIndex = newColumn;
    }

    public void setRowIndex(int newRow) {
        this.rowIndex = newRow;
    }

    @Override
    public String toString() {
        return "{" + rowIndex + "," + columnIndex + "}";
    }



}

