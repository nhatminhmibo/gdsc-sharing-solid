package Liskov_Substitution_Principle;

class Duck {
    //some attribute
    public boolean Quack(Duck duck) {
        System.out.println("quackkkkkkkk");
        return true;
    }
}

class Person {
    public boolean SqueezeDuck(RubberDuck duck) {
        return false;
        //return true;
    }
}

//ta sẽ qua một ví dụ khác, ở đây ta có class RubberDuck (con vịt cao su)
//được kế thừa từ class Duck (coi như class Duck đã tồn tại) 
//và class Rubber này overide lại phương thức quack() của class Duck 
//bằng cách sửa giá trị trả về thành false cho phương thức đó 
//(mặc dù ở class Duck, phương thức Quack luôn trả về true). 
//Tuy nhiên con vịt nào mà chẳng quack được, 
//đó là điều hiểu nhiên và việc class RubberDuck overide phương thức quack đã vi phạm tính chất Liskov
/*
class RubberDuck extends Duck {
    public boolean Quack(Duck duck) {
        Person person = new Person();
		if (person.SqueezeDuck(this)) {
			System.out.println("quackkkkkkkk");
            return true;
		}
		System.out.println("can't quackkkkkkkkkk");
        return false;
    }
}

public class liskov {
    public static void main(String[] args) {
        Duck duck = new Duck();
        RubberDuck rubberDuck = new RubberDuck();

        duck.Quack(duck);
        rubberDuck.Quack(duck);

    }
}
*/

//ta sửa lại bằng cách không cho class Rubber kế thừa từ class Duck 
//và đưa method quack() của class Duck vào interface QuackableInterface 
//để class RubberDuck có thể implements interface này và overide lại method quack() cho phù hợp

interface QuackableInterface {
	public boolean Quack();
}

class RubberDuck implements QuackableInterface {
	public boolean Quack() { 
		Person person = new Person();
		if (person.SqueezeDuck(this)) {
			System.out.println("quackkkkkkkk");
            return true;
		}
		System.out.println("can't quackkkkkkkkkk");
        return false;
    }
}

public class liskov {
    public static void main(String[] args) {
        new RubberDuck().Quack();
    }
}