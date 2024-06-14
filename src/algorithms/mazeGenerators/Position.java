package algorithms.mazeGenerators;


import java.util.Objects;

public class Position {

    private int rowIndex;
    private int columnIndex;

    public Position(int row, int column) {
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


    public static Position fromString(String postionString){
        String positionStringWithoutBrackets = postionString.substring(1, postionString.length() -1);
        String[] res = positionStringWithoutBrackets.split(",");
        int row = Integer.parseInt(res[0]);
        int column = Integer.parseInt(res[1]);
        return new Position(row,column);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return rowIndex == position.rowIndex && columnIndex == position.columnIndex;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rowIndex, columnIndex);
    }

}

