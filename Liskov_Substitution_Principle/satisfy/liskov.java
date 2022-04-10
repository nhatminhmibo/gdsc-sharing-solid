package Liskov_Substitution_Principle.satisfy;


//ta sửa lại bằng cách không cho class Rubber kế thừa từ class Duck 
//và đưa method quack() của class Duck vào interface QuackableInterface 
//để class RubberDuck có thể implements interface này và overide lại method quack() cho phù hợp

class Duck {
    //some attribute
    public boolean CanQuack(Duck duck) {
        System.out.println("quackkkkkkkk");
        return true;
    }
}

interface QuackableInterface {
	public boolean CanQuack();
}

class RubberDuck implements QuackableInterface {
	public boolean CanQuack() { 
		boolean SomeoneSqueezeDuck = true;

		if (SomeoneSqueezeDuck) {
			System.out.println("quackkkkkkkk");
            return true;
		}
        
		System.out.println("can't quackkkkkkkkkk");
        return false;
    }
}

public class liskov {
    public static void main(String[] args) {
        new RubberDuck().CanQuack();
    }
}