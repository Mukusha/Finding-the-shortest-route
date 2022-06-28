package exemple;

import java.util.Random;

/**
 * Тестирующий класс
 */

public class TestClass {
    public static void main(String[] args) {
        Random r = new Random();
        int n = (int) (Math.random() * 10)+1;
        int m = (int) (Math.random() * 100)+1;
//int n = 2100;
//int m = 2100;
        System.out.println("Dimension of the array: "+n+"x"+m);

        char [][] map = new char[n][m];
        // заполняем рандомно карту
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (r.nextBoolean()|| r.nextBoolean()) {map[i][j]='.';}
                else {map[i][j]='#';}
            }

        }
        //устанавливаем стартовую и финальную точку
        map[(int) (Math.random() * n)] [(int) (Math.random() * m)]='@';
        map[(int) (Math.random() * n)] [(int) (Math.random() * m)]='X';

        SearchShortestRoute str=new SearchShortestRoute();
        str.printMap(map);

        long start = System.currentTimeMillis();
        char[][] pp = str.findRoute(map);
        long finish = System.currentTimeMillis();
        long elapsed = finish - start;
        System.out.println("Time, ms: " + elapsed);

        if (pp!=null) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(pp[i][j]);
                }
                System.out.println();
            }
        }

    }

}
