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
            ArrayAddition arrayAddition = new ArrayAddition(a);
        } catch (MyArraySizeException ex){

        } catch (MyArrayDataException ex){

        }


    }


}



