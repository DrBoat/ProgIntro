public class Vector {
    double x; //Поле
    double y; //Поле

    Vector (final double x, final double y) {
        //Выделение памяти
        this.x = x;
        this.y = y;
        //Возврат this
    }

    Vector (Vector v) {
        x = v.x;
        y = v.y;
    }

    static Vector polar (double rho, double phi) {
        return new Vector(
                rho * Math.cos(phi),
                rho * Math.sin(phi)
        );
    }

    double length() {
        return Math.sqrt(
                this.x * this.x + this.y * this.y);
    }

    Vector add(Vector v2) {
        return new Vector(x + v2.x, y + v2.y);
    }

    Vector copy() {
        return new Vector(x, y);
    }

    public static void  main(String[] args) {
        Vector v1 = new Vector(2, 3);
        //Vector v2 = new Vector(1, 1);
        //Vector vs = v1.add(v2);
        System.out.println("1: " + v1.length());
        printLengt(v1.copy());
        System.out.println("3: " + v1.length());
    }

    public static void printLengt(Vector v) {
        Vector v1 = v.add(new Vector(1, 1))
                .add(new Vector(2, 3));
        System.out.println("2: " + v1.length());
    }
}
