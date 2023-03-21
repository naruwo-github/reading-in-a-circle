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
class XXXSort implements SortStrategy {
  @override
  List<int> sort(List<int> dataset) {
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
  final sorter = Sorter(QuickSort());
  sorter.sort(dataset);

  sorter.setSortStrategy(MergeSort());
  sorter.sort(dataset);
}
