
public class TestDriver { // Developer A
    public static void main(String[] args) {
        Rectangle shape1 = new Rectangle();
        shape1.setWidth(3);
        shape1.setHeight(4);
        Square shape2 = new Square();
        shape2.setEdge(3);

        System.out.println("The area of rectangle is " + (shape1).getArea());
        System.out.println("The area of square is " + (shape2).getArea());
        System.out.println("End of program");
    }
}

abstract class Shape {
    abstract float getArea();
}

// You are the developer
class Rectangle extends Shape {
    float height;
    float width;

    public float getHeight() {
        return height;
    }

    public void setHeight(float value) {
        height = value;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float value) {
        width = value;
    }

    public float getArea() {
        return height * width;
    }
}

class Square extends Shape {
    float edge;

    public float getEdge() {
        return edge;
    }

    public void setEdge(float value) {
        edge = value;
    }

    public float getArea() {
        return edge * edge;
    }

}