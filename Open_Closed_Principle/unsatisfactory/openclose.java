package Open_Closed_Principle.unsatisfactory;


//chỉnh sủa ví dụ Single Responsibility bằng cách thêm 2 class Vaccination và Deworming
//giúp cho phép 2 dịch vụ là tiêm phòng và tẩy giun được sử dụng bởi class AnimalService. 
//tuy nhiên, nếu trong tương lai ta muốn thêm nhiều dịch vụ hơn nữa, 
//điều đó sẽ khiến ta phải sửa lại code của class Service, vi phạm tính chất open/close  

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

class AnimalService {
    public void Vaccinating(Animal animal) {
            //logic for "tiêm vắc xin"
            System.out.println("Vaccinating");
    }

    public void Deworming(Animal animal) {
        //logic for "tẩy giun"
        System.out.println("Deworming");
    }
}

class UseAnimalService {
    AnimalService animalService;
    Animal animal;

    public UseAnimalService(Animal animal) {
        this.animal = animal;
    } 

    public void UseService(String type) {
        if (type == "vaccinate") {
            animalService.Vaccinating(this.animal);
        } else if (type == "deworming") {
            animalService.Deworming(this.animal);
        }
    }
}

public class openclose {
    public static void main(String[] args) {
        Animal animal = new Animal("gooooo", 1, 4);

        UseAnimalService service = new UseAnimalService(animal);
        service.UseService("vaccinate");
    }
}