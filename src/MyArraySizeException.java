public class MyArraySizeException extends Exception {
    private int length;
    public MyArraySizeException(String message, int length){
        super(message);
        this.length = length;
        System.out.println("Некорректный размер массива. Требуется массив размером [" + this.length + "][" + this.length + "]");
    }

}
