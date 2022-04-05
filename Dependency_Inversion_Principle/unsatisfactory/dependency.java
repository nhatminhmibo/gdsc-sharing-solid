package Dependency_Inversion_Principle.unsatisfactory;

//quay trở lại với ví dụ về class Animal, 
//bây giờ ta sẽ thêm method Save() vào class Animal giúp lưu dữ liệu vào MySQL thông qua class SaveToMySQL. 
//Tuy nhiên, như vậy vừa khiến cho chúng ta bị phụ thuộc vào việc 
//chỉ có thể lưu dữ liệu vào MySQL, hay nếu ta cần thay đổi qua database khác như MongoDB, 
//ta sẽ phải sửa lại code của method Save() và vô tình class Animal đang bị phụ thuộc vào class SaveToMySQL

class Animal{
	String name;
	float age;
	float weight;

	public Animal (String name, float age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
	}

    public void Save() {
        SaveToPosgreSQL saveToMySQL = new SaveToPosgreSQL(this);
        saveToMySQL.Save();
    } 
}

class SaveToPosgreSQL {
    Animal animal;

    public SaveToPosgreSQL(Animal animal) {
        this.animal = animal;
    }

	public void Save() {
        //logic for this
        System.out.println("save to MySQL successfully");
    }
}

public class dependency {
    public static void main(String[] args) {
        Animal animal = new Animal("chocco", 3, 6);
        animal.Save();
    }
}