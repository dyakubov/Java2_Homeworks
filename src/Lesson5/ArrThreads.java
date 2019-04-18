package Lesson5;

public class ArrThreads extends Thread{
    static final int size = 10;
    static final int h = size / 2;



    public void SingleFlow(){
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));

        }
        System.out.println("Однопоточный режим: " + (System.currentTimeMillis() - a) + " мс.");
    }

    public static void main(String[] args) {
        ArrThreads arrThreads = new ArrThreads();
        //arrThreads.SingleFlow();
        arrThreads.DoubleFlow();


    }



    public void DoubleFlow() {
        Thread mainThread = currentThread();
        // Создание массива
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        int shift = h;

        //Заполнение массива единицами
        for (int i = 0; i < arr.length; i++){
            arr[i] = 1;
        }

        new Thread(){
            Thread thread1 = ArrThreads.currentThread();

            @Override
            public void run() {
                System.out.println(thread1.getId());
            }



        }.start();

        new Thread(){
            Thread thread2 = ArrThreads.currentThread();
        }.start();





    }




}


