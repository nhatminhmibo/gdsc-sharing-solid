package Liskov_Substitution_Principle.unsatisfactory;


//ta sẽ qua một ví dụ khác, ở đây ta có class RubberDuck (con vịt cao su)
//được kế thừa từ class Duck 
//và class Rubber này overide lại method CanQuack() của class Duck 
//bằng cách sửa giá trị trả về sẽ có trường hợp là false cho method đó 
//(mặc dù ở class Duck, method Quack luôn trả về true). 
//Tuy nhiên con vịt nào mà chả quack được, 
//đó là điều hiểu nhiên và việc class RubberDuck overide method CanQuack() đã vi phạm tính chất Liskov

class Duck {
    //some attribute
    public boolean CanQuack(Duck duck) {
        System.out.println("quackkkkkkkk");
        return true;
    }
}

class RubberDuck extends Duck {
    public boolean CanQuack(Duck duck) {
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
        Duck duck = new Duck();
        RubberDuck rubberDuck = new RubberDuck();

        duck.CanQuack(duck); //object duck gọi method CanQuack với param là duck thì CanQuack = true
        rubberDuck.CanQuack(duck); //object rubberDuck gọi method CanQuack, mặc dù param vẫn là duck bình thường như CanQuack = false => vô lý

    }
}