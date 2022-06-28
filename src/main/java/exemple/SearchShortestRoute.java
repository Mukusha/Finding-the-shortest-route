package exemple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Поиск маршрута по алгоритму поиск в ширину (BFS)
 * ~ Так как в худшем случае алгоритм посещает все узлы графа,
 * ~ временная сложность алгоритма составляет O(K+L)
 */
public class SearchShortestRoute implements RouteFinder {
    private Point startPoint;
    private Point endPoint;

    //основная функция
    @Override
    public char[][] findRoute(char[][] map) {
        findStartEndPoint(map); // поиск стартовой и конечной точек (инициализация)
        return restoringRute(map, bfs(map)); //восстановление пути / внесение изменений в карту
    }

    //поиск стартовой и конечной точек (инициализация)
    private void findStartEndPoint(char[][] map) {
        char c;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                c=map[i][j];
                if (c=='@') { startPoint=new Point(i,j);}//startPoint.setX(i); startPoint.setY(j);
                if (c=='X') {endPoint=new Point(i,j);}//endPoint.setX(i); endPoint.setY(j);
            }
        }
        System.out.println("@ : "+startPoint.text());
        System.out.println("X : "+endPoint.text());
    }


    //поиск в ширину
    private Point[][] bfs(char[][] map){
       int n=map.length;
       int m = map[0].length;
       int[][] d =new int[n][m];
        int[][] delta={{0,-1},{0,1},{1,0},{-1,0}};
        boolean[][] used =new boolean[n][m]; //клали ли в очередь
        Queue<Point> queue = new LinkedList<>();//создаем очередь
        Point[][] P =new Point[n][m]; // для восстановления пути: записываем из какой точки пришли в текущую точку
        d[startPoint.getX()][startPoint.getY()]=0; //расстояние 0, так как мы уже в этой точке
        used[startPoint.getX()][startPoint.getY()]=true; //добавляем в список использованных
        queue.add(startPoint);// добавляем в очередь стартовую точку
        while (!queue.isEmpty()) {//  пока в очереди есть элементы
         Point currentPoint = queue.poll(); //берем элемент из очереди
         //выделяем соседние точки
            for (int i = 0; i < 4; i++) {
               int XNeighborCurrentPoint =currentPoint.getX()+delta[i][0];
               int YNeighborCurrentPoint = currentPoint.getY()+delta[i][1];
               if   (XNeighborCurrentPoint<0 || XNeighborCurrentPoint>=n || //смотрим что бы не вылетало за границы поля
                       YNeighborCurrentPoint<0 || YNeighborCurrentPoint>=m) continue;
               if  ( !used[XNeighborCurrentPoint][YNeighborCurrentPoint] && //смотрим, что бы точка не была в списке использованных
                     map[XNeighborCurrentPoint][YNeighborCurrentPoint]!='#' ) { //смотрим, что бы точка не обозначала препятствие
                   d[XNeighborCurrentPoint][YNeighborCurrentPoint]=d[currentPoint.getX()][currentPoint.getY()]+1;
                   used[XNeighborCurrentPoint][YNeighborCurrentPoint]=true; // использовали
                   queue.add(new Point(XNeighborCurrentPoint,YNeighborCurrentPoint));//добавляем в очередь
                   // System.out.println("new X = "+XNeighborCurrentPoint +" Y = "+YNeighborCurrentPoint);
                   P[XNeighborCurrentPoint][YNeighborCurrentPoint]=new Point(currentPoint.getX(), currentPoint.getY());
               }
            }
        }
        if (d[endPoint.getX()][endPoint.getY()] ==0) {
            System.out.println("Route not found!");
        }
        else {System.out.println("The length of the shortest route: "+d[endPoint.getX()][endPoint.getY()]);}


      /*  for (int[] ints : d) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                System.out.print(used[i][j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d[0].length; j++) {
                if (P[i][j]==null) {System.out.print("x = -  y = - | ");}
                else {
                System.out.print(P[i][j].text()+" | ");}
            }
            System.out.println();
        }*/
       return P;
    }

    //восстановление пути / внесение изменений в карту
    private char[][] restoringRute(char[][] map, Point[][] P){
        //как-то ускорить через steam APi

        //////
        Point curPoint= P[endPoint.getX()][endPoint.getY()]; //(curPoint.equals(startPoint))
        if (curPoint==null) return null;
        while (curPoint!= null) // //curPoint.getX()!=startPoint.getX() && curPoint.getY() !=startPoint.getY(
        {
            map[curPoint.getX()][curPoint.getY()]='+';
           // System.out.println(curPoint.text());
            curPoint=P[curPoint.getX()][curPoint.getY()];
        }
        map[startPoint.getX()][startPoint.getY()]='@';

        return map;

    }

    //вывод карты
    public void printMap(char[][] map)
    {

        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
