package Open_Closed_Principle.satisfy;

//Vậy nên ta sẽ tạo interface ServiceInterface với phương thức UseService 
//và được implement bởi các class là Vaccination và Deworming.
//Về sau, nếu muốn thêm service mới, ta chỉ cần tạo 1 class implement interface AnimalServiceInterface
//và sửa lại class InitializeService mà không làm ảnh hưởng đến class Service ban đầu

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
        InitializeService useService = new InitializeService(type);
        useService.animalServiceInterface.UseService(animal);
    }
}

interface AnimalServiceInterface{
	public void UseService(Animal animal);
} 

class VaccinationService implements AnimalServiceInterface{
	public void UseService(Animal animal) {
        //logic for "tiêm vắc xin"
        System.out.println("Vaccinating");
    }
}

class DewormingService implements AnimalServiceInterface{
	public void UseService(Animal animal) {
        //logic for "tẩy giun"
        System.out.println("Deworming");
    }
}

class InitializeService {
    AnimalServiceInterface animalServiceInterface;

	public InitializeService(String type) {
		try {
            if (type == "vaccinate") {
                this.animalServiceInterface = new VaccinationService();
            } else if (type == "deworming") {
                this.animalServiceInterface = new DewormingService();
            } 
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public class openclose {
    public static void main (String[] args) {
        Animal animal = new Animal("mocha", 4, 6);

        AnimalService service = new AnimalService(animal);
        service.UseService("deworming");
    }
}