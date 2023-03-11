import 'bridge.dart';
import 'implementor.dart';

void main() {
  ShapeColorBridge colorBridgeRed = new ShapeColorBridge(new RedColor());
  ShapeColorBridge colorBridgeBlue = new ShapeColorBridge(new BlueColor());

  print(colorBridgeRed.drawCircle(5, 10, 15));
  print(colorBridgeBlue.drawRectangle(20, 30, 40, 50));
}
