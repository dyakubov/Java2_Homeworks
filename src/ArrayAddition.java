public class ArrayAddition {
    public void ArrayAddition(String[][] s) throws MyArraySizeException{
        String[][] arr = new String[4][4];
        try {
            arr = s;
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new MyArraySizeException("Некорректный размер массива. Требуется массиы размером [" + arr.length + "][" + arr.length + "]");
        }

    }
}
