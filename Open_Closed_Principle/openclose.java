package Open_Closed_Principle;

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

//chỉnh sửa class Service ở ví dụ trước giúp cho phép 2 dịch vụ 
//là tiêm phòng và tẩy giun thông qua class ServiceType. 
//tuy nhiên, nếu trong tương lai ta muốn thêm nhiều dịch vụ hơn nữa, 
//điều đó sẽ khiến ta phải sửa lại code của class Service và ServiceType, vi phạm tính chất open/close    
/*class ServiceType {
    public void Vaccinate(Animal animal) {
        //logic for "tiêm vắc xin"
        System.out.println("Vaccinating");
    }
    public void Deworming(Animal animal) {
        //logic for "tẩy giun"
        System.out.println("Deworming");
    }
}

class Service {
    Animal animal;

    public Service(Animal animal) {
        this.animal = animal;
    }

    public void UseService(String type) {
        ServiceType serviceType = new ServiceType();
        if (type == "vaccinate") {
            serviceType.Vaccinate(animal);
        } else if (type == "deworming") {
            serviceType.Deworming(animal);
        } 
    }
}

public class openclose {
    public static void main(String[] args) {
        Animal animal = new Animal("gooooo", 1, 4);

        Service service = new Service(animal);
        service.UseService("vaccinate");
    }
}
*/

//Vậy nên ta sẽ tạo interface ServiceInterface 
//với phương thức UseService và được implement bởi các class là Vaccination và Deworming.
//Về sau, nếu muốn thêm service mới, ta chỉ cần tạo 1 class implement interface ServiceInterface
//và sửa lại class InitializeService mà không làm ảnh hưởng đến class Service ban đầu
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


public class openclose {
    public static void main (String[] args) {
        Animal animal = new Animal("mocha", 4, 6);

        Service service = new Service(animal);
        service.UseService("deworming");
    }
}