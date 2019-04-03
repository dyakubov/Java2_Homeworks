public class MyArrayDataException extends Exception {
    private int index;
    private int row;
    private int col;
    public MyArrayDataException (String message, int row, int col){
        super(message);
        this.row = row;
        this.col = col;

    }
}
