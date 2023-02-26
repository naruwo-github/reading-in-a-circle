// node class
class Node {
  constructor(name) {
    this.name = name
    this.childNodes = new Array()
  }

  getName() {
    return this.name
  }

  setName(name) {
    this.name = name
  }

  getChildNodes() {
    return this.childNodes
  }

  add(node) {
    this.childNodes.push(node)
  }
}

// tree class
class Tree {
  constructor(name) {
    this.name = name
    this.root = new Node(name)
  }

  getName() {
    return this.name
  }

  setName(name) {
    this.name = name
  }

  getRoot() {
    return this.root
  }
}
