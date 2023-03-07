#include <iostream>

class Singleton
{
public:
    // メソッドを呼び出す際にSingletonインスタンスを返す
    static Singleton &getInstance()
    {
        static Singleton instance;
        return instance;
    }

    // 何らかの処理を行うメソッド
    void doSomething()
    {
        std::cout << "Doing something in Singleton" << std::endl;
    }

private:
    // コンストラクタをプライベートにすることで、外部からのインスタンス化を禁止する
    Singleton() {}
    Singleton(const Singleton &);
    Singleton &operator=(const Singleton &);
};

int main()
{
    // Singletonインスタンスを取得して、何らかの処理を実行する
    Singleton &singletonInstance = Singleton::getInstance();
    singletonInstance.doSomething();
    return 0;
}
