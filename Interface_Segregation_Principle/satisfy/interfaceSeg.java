package Interface_Segregation_Principle.satisfy;

//để giải quyết điều đó, 
//ta tách interface Hobbies Interface thành 2 interface là DogHobbiesInterface và 
//CatHobbiesInterface với các method phù hợp cho class cat và Dog 
//để chúng k gặp tình trạng không sử dụng hết method trong interface
interface DogHobbiesInterface {
	public void EatSausage();
	public void PlayWithSmallBall();
	public void Walk();
}

interface CatHobbiesInterface {
	public void EatSausage();
	public void PlayWithSmallBall();
}

class Cat implements CatHobbiesInterface {
	public void EatSausage() {
		System.out.println("really like sausage");
	}
	public void PlayWithSmallBall() {
		System.out.println("really like playing with ball");
	}
}

class Dog implements DogHobbiesInterface {
	public void EatSausage() {
		System.out.println("really like sausage");
	}
	public void PlayWithSmallBall() {
		System.out.println("really like playing with ball");
	}
	public void Walk() {
		System.out.println("really like walking");
	}
}


public class interfaceSeg {
    public static void main(String[] args) {
		Cat cat = new Cat();
		cat.EatSausage();
		cat.PlayWithSmallBall();

		System.out.println("");
		Dog dog = new Dog();
		dog.EatSausage();
		dog.PlayWithSmallBall();
		dog.Walk();
	}
}
