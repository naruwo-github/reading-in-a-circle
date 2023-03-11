import 'abstraction.dart';
import 'implementor.dart';

class ShapeColorBridge {
  Color color;

  ShapeColorBridge(this.color);

  String drawCircle(num x, num y, num radius) {
    CircleShape circle = new CircleShape(x, y, radius, color);
    return circle.draw();
  }

  String drawRectangle(num x, num y, num width, num height) {
    RectangleShape rectangle = new RectangleShape(x, y, width, height, color);
    return rectangle.draw();
  }
}
