import 'abstraction.dart';

class CircleShape extends Shape {
  late num x, y, radius;

  CircleShape(num x, num y, num radius, Color color) : super(color) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  @override
  String draw() {
    return "Circle drawn at ($x, $y) with radius $radius and color ${color.fill()}";
  }
}

class RectangleShape extends Shape {
  late num x, y, width, height;

  RectangleShape(num x, num y, num width, num height, Color color)
      : super(color) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  @override
  String draw() {
    return "Rectangle drawn at ($x, $y) with width $width, height $height, and color ${color.fill()}";
  }
}

class RedColor implements Color {
  @override
  String fill() {
    return "Red";
  }
}

class BlueColor implements Color {
  @override
  String fill() {
    return "Blue";
  }
}
