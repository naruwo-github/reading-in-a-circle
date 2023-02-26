class Sprite {
  constructor() {
    this.x = 0
    this.y = 0
    this.image = null
  }

  draw(context) {
    context.drawImage(this.image, this.x, this.y)
  }

  getX() {
    return this.x
  }

  setX(x) {
    this.x = x
  }

  getY() {
    return this.y
  }

  setY(y) {
    this.y = y
  }

  getImage() {
    return this.image
  }

  setImage(image) {
    this.image = image
  }
}

// my plane
class MyPlane extends Sprite {
  //...
}

// enemy plane
class EnemyPlane extends Sprite {
  //...
}

