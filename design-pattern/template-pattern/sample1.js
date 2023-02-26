class PaperTemplate {
  parentPrint() {
    console.log('Print A4 Paper')
  }
}

class ColorTemplate extends PaperTemplate {
  colorPrint() {
    super.parentPrint()
    console.log('Set the color of A4 paper red')
  }
}

const template = new ColorTemplate()
template.colorPrint()
