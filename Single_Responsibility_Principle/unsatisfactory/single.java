package Single_Responsibility_Principle.unsatisfactory; 

//Ban đầu, ta có 1 class Animal với các thuộc tính và phương thức như bên dưới.
//Single responsibillity principle khuyến khích việc 1 class chi nên chứa 1 phương thức, 1 hành động hay 1 nhiệm vụ.
class Animal{
	private String name;
	private int age;
	private float weight;

	public Animal (String name, int age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
	}

	public void Eating() {
        System.out.println(name + " is eating");
    }
	public void Bathing() {
        System.out.println(name + " is taking bath");
    }
}

public class single {
    public static void main(String[] args) {
        Animal animal = new Animal("kichi",2,5);
        animal.Eating();
        animal.Bathing();
    }
}
