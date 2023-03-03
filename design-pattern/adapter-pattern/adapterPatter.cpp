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
        std::cout << "既存クラスのメソッドが呼ばれました。" << std::endl;
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
