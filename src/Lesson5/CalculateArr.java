package Lesson5;

public class CalculateArr {
    static final int size = 10000000;
    static final int h = size / 2;


    public static void main(String[] args) {
        singleThread(); //Однопоточное вычисление
        twoThreads(); //Двухпоточное вычисление

    }

    private static void singleThread() {
        float[] arr = new float[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("Время расчета одним потоком: " + (System.currentTimeMillis() - a) + " мс.");
    }



    private static void twoThreads() {
        float[] arr = new float[size];
        float[] a1 = new float[h];
        float[] a2 = new float[h];

        //Заполняем массив единицами
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        //Разбиваем массив на 2 части
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);


        //Поток для расчета первой части
        Runnable arrCalculator1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < a1.length; i++) {
                    a1[i] = (float) (a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        };

        //Поток для расчета второй части (со смещением)
        Runnable arrCalculator2 = new Runnable() {
            @Override
            public void run() {
                int ix = h;
                for (int i = 0; i < a2.length; i++) {
                    a2[i] = (float) (a2[i] * Math.sin(0.2f + ix / 5) * Math.cos(0.2f + ix / 5) * Math.cos(0.4f + ix / 2));
                    ix++;
                }
            }
        };

        Thread thread1 = new Thread(arrCalculator1);
        Thread thread2 = new Thread(arrCalculator2);

        //Стартуем потоки
        thread1.start();
        thread2.start();

        //Ожидаем выполнения обоих потоков
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Собираем массив обратно
        System.arraycopy(a1, 0, arr, 0, h);
        System.arraycopy(a2, 0, arr, h, h);

        System.out.println("Время расчета двумя потоками: " + (System.currentTimeMillis() - a) + " мс.");
    }
}

