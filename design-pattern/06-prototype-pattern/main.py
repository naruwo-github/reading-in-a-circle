import copy


class Prototype:
    def __init__(self):
        self._data = []

    def add_item(self, item):
        self._data.append(item)

    def get_data(self):
        return self._data

    def clone(self):
        return copy.deepcopy(self)


if __name__ == '__main__':
    prototype = Prototype()
    prototype.add_item('item1')
    prototype.add_item('item2')
    print(prototype.get_data())      # ['item1', 'item2']

    cloned_object = prototype.clone()
    print(cloned_object.get_data())  # ['item1', 'item2']

    cloned_object.add_item('item3')
    print(cloned_object.get_data())  # ['item1', 'item2', 'item3']

    print(prototype.get_data())      # ['item1', 'item2']
