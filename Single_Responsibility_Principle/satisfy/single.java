package Single_Responsibility_Principle.satisfy;

//cho nên ta sẽ tách các phương thức ở class trước thành các class riêng biệt, 
//mỗi class chỉ chịu trách nhiệm cho 1 nhiệm vụ cụ thể như hình bên trái
class Animal{
	String name;
	int age;
	float weight;

	public Animal (String name, int age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }
}

class Eating {
    Animal animal;

    public Eating(Animal animal) {
        this.animal = animal;
    }
	public void Eat() {
        System.out.println("eating");
    }
}

class Bathing {
    Animal animal;

    public Bathing(Animal animal) {
        this.animal = animal;
    }
	public void TakeBath() {
        System.out.println("bathing");
    }
}

public class single {
    public static void main(String[] args) {
        Animal animal = new Animal("kichi",2,5);

        Eating activity1 = new Eating(animal);
        activity1.Eat();

        Bathing activity2 = new Bathing(animal);
        activity2.TakeBath();
    }
}

