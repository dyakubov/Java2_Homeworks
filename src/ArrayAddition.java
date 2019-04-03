public class ArrayAddition {

    public ArrayAddition(String[][] s) throws MyArraySizeException, MyArrayDataException{
        System.out.println("Передача в метод arrayAddition() массива размером [" + s.length + "][" + s.length + "]");
        String[][] arr = new String[4][4];
        int sum;
        int current_row = 0;
        int current_col = 0;

        try {
            for (int i = 0; i < s.length; i++){
                for (int j = 0; j < s.length; j++){
                    arr[i][j] = s[i][j];
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new MyArraySizeException(ex.getMessage(), arr.length);
        } try {
            for (int i = 0; i < arr.length; i++) {
                current_row = i;
                for (int j = 0; j < arr.length - 1; j++) {
                    current_col = j;
                    sum = Integer.parseInt(arr[i][j] + arr[i][j + 1]);
                }
            }
        } catch (NumberFormatException ex){
            throw new MyArrayDataException(ex.getMessage(), current_row, current_col);
        }

    }

}
