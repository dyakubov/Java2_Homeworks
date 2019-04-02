public class Application {
    public static void main(String[] args) {
        String[][] a = {
                {"2", "3", "4", "4", "5"},
                {"2", "4", "5", "5", "6"},
                {"2", "3", "4", "4", "5"},
                {"2", "3", "4", "4", "5"},
                {"2", "3", "4", "4", "5"},
        };

        String[][] b = {
                {"2", "3", "4", "4"},
                {"2", "4", "5", "5"},
                {"2", "3", "4", "4"},
                {"2", "3", "4", "4"},
        };

        try {

            System.out.println("b");
            arrayAddition(b);
        } catch (MyArraySizeException ex){
            System.out.println("Поймали " + ex.getMessage());
        }


    }

    public static void arrayAddition(String[][] s) throws MyArraySizeException{
        String[][] arr = new String[4][4];
        try {
            for (int i = 0; i < s.length; i++){
                for (int j = 0; j < s.length; j++){
                    arr[i][j] = s[i][j];
                }
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            throw new MyArraySizeException("Упс");
        }


    }
}



