// ソートアルゴリズムを変更することができるため、柔軟性がある
// また、ソートアルゴリズムを追加する場合は、SortStrategyインターフェースを実装するだけで、新しいアルゴリズムを実装できる

abstract class SortStrategy {
  List<int> sort(List<int> dataset);
}

class QuickSort implements SortStrategy {
  @override
  List<int> sort(List<int> dataset) {
    // todo: 要確認 クイックソート使われてる？
    dataset.sort();
    return dataset;
  }
}

class MergeSort implements SortStrategy {
  @override
  List<int> sort(List<int> dataset) {
    // todo: 要確認 マージソートになっている？
    dataset.sort((a, b) => a.compareTo(b));
    return dataset;
  }
}

/**
 * 下記のノリでConcreteStrategyを実装していく

class XXXSort implements SortStrategy {
  @override
  List<int> sort(List<int> dataset) {
    // XXXソートを実装する
    dataset.sort(XXX);
    return dataset;
  }
}

 */

class Sorter {
  SortStrategy _sortStrategy;

  Sorter(this._sortStrategy);

  void setSortStrategy(SortStrategy sortStrategy) {
    _sortStrategy = sortStrategy;
  }

  List<int> sort(List<int> dataset) {
    return _sortStrategy.sort(dataset);
  }
}

void main() {
  final dataset = [3, 5, 1, 2, 4];

  final quickSort = QuickSort();
  final sorter = Sorter(quickSort);
  sorter.sort(dataset);

  final mergeSort = MergeSort();
  sorter.setSortStrategy(mergeSort);
  sorter.sort(dataset);
}
