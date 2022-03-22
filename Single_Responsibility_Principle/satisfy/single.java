package Single_Responsibility_Principle.satisfy;

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
        Animal animal = new Animal("kichi",2,5);
        animal.PrintInfo();

        Service service = new Service(animal);
        service.UseService();
    }
}

