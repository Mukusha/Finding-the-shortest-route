package exemple;

/**
 * Класс описывающий точки
 */
public class Point {

    private final int x;
    private final int y;

    Point(int x, int y)
    {
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }


    public int getY() {
        return y;
    }

    public String text(){
        return "x = "+this.x+"  y = "+this.y;
    }

    public boolean equals(Point point) {
        if (point==null) return false;
        if (this.getX() == point.getX() && this.getY()==point.getY()) return true;
        return false;
    }
}
