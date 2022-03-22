package Open_Closed_Principle.satisfy;

//Vậy nên ta sẽ tạo interface ServiceInterface với phương thức UseService 
//và được implement bởi các class là Vaccination và Deworming.
//Về sau, nếu muốn thêm service mới, ta chỉ cần tạo 1 class implement interface ServiceInterface
//và sửa lại class InitializeService mà không làm ảnh hưởng đến class Service ban đầu

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

    public void UseService(String type) {
        InitializeService useService = new InitializeService(type);
        useService.serviceInterface.UseService(animal);
    }
}

interface ServiceInterface{
	public void UseService(Animal animal);
} 

class Vaccination implements ServiceInterface{
	public void UseService(Animal animal) {
        //logic for "tiêm vắc xin"
        System.out.println("Vaccinating");
    }
}

class Deworming implements ServiceInterface{
	public void UseService(Animal animal) {
        //logic for "tẩy giun"
        System.out.println("Deworming");
    }
}

class InitializeService {
    ServiceInterface serviceInterface;

	public InitializeService(String type) {
		try {
            if (type == "vaccinate") {
                this.serviceInterface = new Vaccination();
            } else if (type == "deworming") {
                this.serviceInterface = new Deworming();
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

        Service service = new Service(animal);
        service.UseService("deworming");
    }
}