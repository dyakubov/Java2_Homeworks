public class MyArrayDataException extends Exception {
    private int index;
    public MyArrayDataException (String message, int index){
        super(message);
        this.index = index;

    }
}
