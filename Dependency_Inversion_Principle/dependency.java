package Dependency_Inversion_Principle;

//quay trở lại với ví dụ về class Animal, 
//bây giờ ta sẽ thêm method Save giúp lưu thông tin vào MySQL. 
//Tuy nhiên, như vậy vừa khiến cho chúng ta bị phụ thuộc vào việc 
//chỉ có thể lưu dữ liệu vào MySQL, hay nếu ta cần thay đổi qua database khác như MongoDB, 
//ta sẽ phải sửa lại code của Save và vô hình chung class Animal đang bị phụ thuộc vào class SaveToMySQL
/*class Animal{
	String name;
	float age;
	float weight;

	public Animal (String name, float age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
	}

    public void Save() {
        SaveToMySQL saveToMySQL = new SaveToMySQL(this);
        saveToMySQL.Save();
    } 
}

class SaveToMySQL {
    Animal animal;

    public SaveToMySQL(Animal animal) {
        this.animal = animal;
    }

	public void Save() {
        //logic for this
        System.out.println("save to MySQL successfully");
    }
}*/

//Để giải quyết vấn đề này, ta tạo interface SaveOptionInterface với method Save và
//class SaveToMySQL sẽ implement interface này. Bên cạnh đó, chỉnh lại code của method Save
//trong class animal để có thể sử dụng interface SaveOptionInterface.
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

interface SaveOptionInterface {
	public void Save(Animal animal);
} 

class SaveToMySQL implements SaveOptionInterface {
	public void Save(Animal animal) {
        //logic for this
        System.out.println("save to MySQL successfully");
    }
}

public class dependency {
    public static void main(String[] args) {
        Animal animal = new Animal("chocco", 3, 6);
        animal.Save(new SaveToMySQL());
    }
}
