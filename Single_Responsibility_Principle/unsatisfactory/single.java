package Single_Responsibility_Principle.unsatisfactory; 

//Ban đầu, ta có 1 class Animal với các thuộc tính và phương thức như bên dưới.
//Single responsibillity principle khuyến khích việc 1 class chi nên chứa 1 phương thức, 1 hành động hay 1 nhiệm vụ.
class Animal{
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

public class single {
    public static void main(String[] args) {
        Animal animal = new Animal("kichi",2,5);
        animal.PrintInfo();
        animal.UseService();
    }
}
