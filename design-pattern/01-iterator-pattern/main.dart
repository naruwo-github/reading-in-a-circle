class MyIterable {
  // Iterableインターフェースを実装する
  List<int> _list;

  MyIterable(this._list);

  Iterator<int> get iterator {
  // _MyIteratorクラスのインスタンスを返す
    return _MyIterator(_list);
  }
}

class _MyIterator implements Iterator<int> {
  // Iteratorインターフェースを実装する
  // moveNextメソッドで次の要素があるかどうかを判定し、currentプロパティで現在の要素を返す
  List<int> _list;
  int _currentIndex = 0;

  _MyIterator(this._list);

  bool moveNext() {
    if (_currentIndex < _list.length) {
      _currentIndex++;
      return true;
    }
    return false;
  }

  int get current {
    return _list[_currentIndex - 1];
  }
}

void main() {
  var iterable = MyIterable([1, 2, 3, 4, 5]);
  var iterator = iterable.iterator;

  while (iterator.moveNext()) {
    print(iterator.current);
  }
}
