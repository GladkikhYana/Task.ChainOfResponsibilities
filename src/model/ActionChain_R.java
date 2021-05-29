package model;

import java.util.Random;

public class ActionChain_R {
    Handler_R chain;
    public static int SUCCESS = 1;
    public static int LOSS = 3;
    Random generate;
    int type=0; public ActionChain_R()
    {
        generate=new Random();
        buildChainN();
        buildChainP();
    }
    public void buildChainN()
    {
       chain = new NegativeHandler_R (new PositiveHandler_R(null));
    }
    public void buildChainP()
    {
        chain = new PositiveHandler_R (new NegativeHandler_R(null));
    }
    public boolean processN()
    {
    // вызов NegativeHandler
    int type = 3;
    return process(type);
    }
    public int chet()
    {
    type = generate.nextInt(5)+1;//генерация
    return type;
    }
    public boolean process(Integer a)
    { // вызов цепочки
        return chain.process(a);
    }
}

