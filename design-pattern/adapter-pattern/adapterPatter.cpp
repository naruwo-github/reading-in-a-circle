#include <iostream>

class Target
{
public:
    virtual void request() = 0;
};

class Adapted
{
public:
    void specificRequest()
    {
        std::cout << "既存クラスのメソッドが呼ばれました。" << std::endl;
    }
};

class Adapter : public Target
{
private:
    Adapted *adapted;

public:
    Adapter(Adapted *adapted)
    {
        this->adapted = adapted;
    }

    void request()
    {
        adapted->specificRequest();
    }
};

int main()
{
    Adapted *adapted = new Adapted();
    Target *adapter = new Adapter(adapted);
    adapter->request();
    return 0;
}
