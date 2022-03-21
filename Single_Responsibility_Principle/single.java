package Single_Responsibility_Principle;

//Ban đầu, ta có 1 class Animal với các thuộc tính và phương thức như bên dưới.
//Single responsibillity principle khuyến khích việc 1 class chi nên chứa 1 phương thức, 1 hành động hay 1 nhiệm vụ.

/*class Animal{
	private String name;
	private float age;
	private float weight;
	public Animal (String name, float age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
	}
	public void PrintInfo() {
        System.out.println("name: " + name + ", age: " + age + ", weight: " + weight);
    }
	public void UseService() {
        //logic with the service animal uses
        System.out.println("Use Service");
    }
}

class single {
    public static void main(String[] args) {
        Animal animal = new Animal("meow",2,5);
        animal.PrintInfo();
        animal.UseService();
    }
}*/

//cho nên ta sẽ tách các phương thức ở class trước thành các class riêng biệt, 
//mỗi class chỉ chịu trách nhiệm cho 1 nhiệm vụ cụ thể như hình bên trái
class Animal{
	String name;
	float age;
	float weight;

	public Animal (String name, float age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public void PrintInfo() {
        System.out.println("name: " + name + ", age: " + age + ", weight: " + weight);
    }
}

class Service {
    Animal animal;

    public Service(Animal animal) {
        this.animal = animal;
    }
	public void UseService() {
        //logic with the service animal uses
        System.out.println("Use Service");
    }
}

public class single {
    public static void main(String[] args) {
        Animal animal = new Animal("meow",2,5);
        animal.PrintInfo();

        Service service = new Service(animal);
        service.UseService();
    }
}

