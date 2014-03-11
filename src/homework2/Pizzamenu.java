package homework2;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pizzamenu {
	
	private Set<Pizza> pizzas = new HashSet<Pizza>();
	private Logger logger;
	
	/**
	 * Gets the pizza name from key.
	 *
	 * @param key the key
	 * @return the pizza name from key
	 */
	public String getPizzaNameFromKey(String key) {
		String[] splitData = key.split("\\.");
		if (splitData.length == 3) {
			return splitData[1];	
		} 
		return null;
		
	}
	
	/**
	 * Gets the pizza by name.
	 *
	 * @param name the name
	 * @return the pizza by name
	 */
	public Pizza getPizzaByName(String name) {
		Pizza pizzaByName = null;
		for(Pizza pizza : pizzas) {
			if (pizza.getName().equals(name)) {
				pizzaByName = pizza;
			}
		}
		if (pizzaByName == null) {
			pizzaByName = new Pizza(name);
			pizzas.add(pizzaByName);
		}
		return pizzaByName;
	}
	
	public Pizzamenu(Properties properties) {
		logger = LoggerFactory.getLogger(Pizzamenu.class);
		for (String key : properties.stringPropertyNames()) {
			
			if (key.endsWith("price")) {
				int price = Integer.parseInt(properties.getProperty(key));
				getPizzaByName(getPizzaNameFromKey(key)).setPrice(price);
				
			}
			if (key.contains("ingredient")) {
				String ingredientName = properties.getProperty(key);
				getPizzaByName(getPizzaNameFromKey(key)).addIngredients(ingredientName);
				
			}
			logger.debug("The following key (" + key + ") has been processed with the value of " + properties.getProperty(key));
		}
		logger.info(pizzas.size()+" pizzas has been processed");
	}
	
	public void print() {
		System.out.println("Pizza menu\n=================================================");
		for(Pizza pizza : pizzas) {
			System.out.println(pizza);
		}
		System.out.println("=================================================");
	}
}
