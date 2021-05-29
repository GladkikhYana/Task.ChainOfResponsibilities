package model;

public class Player_R {
    private String name;
    private Integer count;
    private Integer number;
    public Player_R(String name, Integer number, Integer count)
    {
        this.name = name;
        this.number = number;
        this.count = count;
    }
    public boolean pay(Integer number)
    {
        //оплата
        if(number <= this.number)
        {
            this.number-=number;
            this.count--;
            return true;
        }
        else
            return false;
    }
    public Integer getCount()
    {

        return count;
    }
    public Integer getNumber()
    {
        return number;
    }
 public void addNumber(Integer number)
 {
     //кинуть монетку в автомат
     this.number+= number;
 }
 public void addCount(Integer count)
 {
     //кинуть монетку в кошелёк
     this.count+= count;
 }
 public void delCount(Integer count) {
        //убрать монетку из кошелька
     this.count-= count;
    }
}