package inheritance;

public class Engineer extends Profession {
	static int countBuilding = 0;
	//Строим дом и увеличиваем количество построенных домов.
	public static House build() {
		House house = new House();
		countBuilding++;
		System.out.println("Еще один дом построен");
		return house;
	}
}