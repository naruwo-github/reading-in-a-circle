/*
このコードでは、Target クラスがターゲットインターフェースを定義し、Adapteeクラスがアダプティークラス（既存のクラス）を定義しています。
Adapter クラスがアダプタークラスを定義し、Target インターフェースを実装します。
アダプタークラスのコンストラクタで、アダプティークラスのポインタを受け取ります。
Adapter クラスの request() メソッドが呼ばれた場合、アダプティークラスの specificRequest() メソッドを呼び出します。
最後に、Adaptee クラスの specificRequest() メソッドが呼ばれることを確認するために、Adapter クラスのインスタンスを作成し、request() メソッドを呼び出します。
このコードを実行すると、以下のように出力されます。
*/

#include <iostream>

class Target
{
public:
    virtual void request() = 0;
};

class Adaptee
{
public:
    void specificRequest()
    {
        std::cout << "アダプティーのメソッドが呼ばれました。" << std::endl;
    }
};

class Adapter : public Target
{
private:
    Adaptee *adaptee;

public:
    Adapter(Adaptee *adaptee)
    {
        this->adaptee = adaptee;
    }

    void request()
    {
        adaptee->specificRequest();
    }
};

int main()
{
    Adaptee *adaptee = new Adaptee();
    Target *adapter = new Adapter(adaptee);
    adapter->request();
    return 0;
}
