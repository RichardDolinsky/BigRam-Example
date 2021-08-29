package sk.bigRam.richard;


public class WorkMain {

	public static void main(String[] args) {

		Methods zotriedovac = new Methods();
		String veta = zotriedovac.loadFile();
		System.out.println(" ----------------------- ");
		Methods.populateHashMap(veta);
		System.out.println(zotriedovac.printValues());
		zotriedovac.loadFile();

	}

}
