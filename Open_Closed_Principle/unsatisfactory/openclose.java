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
    Animal animal;

    public AnimalService(Animal animal) {
        this.animal = animal;
    }

    public void UseService(String type) {
        if (type == "vaccinate") {
            VaccinationService vaccination = new VaccinationService();
            vaccination.UseService(animal);
        } else if (type == "deworming") {
            DewormingService deworming = new DewormingService();
            deworming.UseService(animal);
        } 
    }
}

class VaccinationService {
	public void UseService(Animal animal) {
        //logic for "tiêm vắc xin"
        System.out.println("Vaccinating");
    }
}

class DewormingService {
	public void UseService(Animal animal) {
        //logic for "tẩy giun"
        System.out.println("Deworming");
    }
}
public class openclose {
    public static void main(String[] args) {
        Animal animal = new Animal("gooooo", 1, 4);

        AnimalService service = new AnimalService(animal);
        service.UseService("vaccinate");
    }
}