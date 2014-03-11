package homework2;

import java.io.IOException;
import java.util.Properties;

public class PizzamenuTester {

	public static void main(String[] args) {
		Properties properties = new Properties();
		try {
			properties.load(Pizzamenu.class.getClassLoader().getResourceAsStream("pizza.properties"));
			Pizzamenu menu = new Pizzamenu(properties);
			menu.print();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
