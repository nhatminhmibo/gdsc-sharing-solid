package Dependency_Inversion_Principle.satisfy;


//Để giải quyết vấn đề này, ta tạo interface SaveOptionInterface với method Save() và
//class SaveToMySQL sẽ implement interface này. Bên cạnh đó, chỉnh lại code của method Save()
//trong class Animal để nó có thể sử dụng interface SaveOptionInterface.
//Nếu tương lai ta cần thay đổi database, ta chỉ cần thêm class khác implement interface
//SaveOptionInterface => Class Animal không còn bị phụ thuộc nữa.

class Animal{
	String name;
	float age;
	float weight;

	public Animal (String name, float age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
	}

    public void Save(SaveOptionInterface saveOptionInterface) {
        saveOptionInterface.Save(this);
    } 
}

class SaveToPosgreSQL implements SaveOptionInterface {
	public void Save(Animal animal) {
        //logic for this
        System.out.println("save to MySQL successfully");
    }
}

interface SaveOptionInterface {
	public void Save(Animal animal);
} 

public class dependency {
    public static void main(String[] args) {
        Animal animal = new Animal("chocco", 3, 6);
        animal.Save(new SaveToPosgreSQL());
    }
}
