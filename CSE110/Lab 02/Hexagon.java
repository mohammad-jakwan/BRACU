public class Hexagon {

    public static void main(String[] args) {
        double side = 8; // Length of a side of the hexagon
        double height = 3; // Height of the hexagon

        // Calculate the apothem (radius of the inscribed circle)
        double apothem = height / Math.sqrt(3);

        // Calculate the area of the hexagon
        double area = (3 * Math.sqrt(3) * side * side) / 2;

        // Calculate the perimeter (circumference) of the hexagon
        double perimeter = 6 * side;

        System.out.println("Area of the hexagon: " + area);
        System.out.println("Perimeter of the hexagon: " + perimeter);
    }
}
