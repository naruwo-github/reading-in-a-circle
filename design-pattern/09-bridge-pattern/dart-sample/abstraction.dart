abstract class Shape {
  Color color;

  Shape(this.color);

  String draw();
}

abstract class Color {
  String fill();
}
