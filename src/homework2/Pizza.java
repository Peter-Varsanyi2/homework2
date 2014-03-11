package homework2;

import java.util.HashSet;
import java.util.Set;

public class Pizza {
	private Set<Ingredients> ingredients = new HashSet<Ingredients>();
	private Integer price;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pizza(String name) {
		this.name = name;
	}

	public Set<Ingredients> getIngredients() {
		return ingredients;
	}

	public void addIngredients(String ingredientName) {
		Ingredients ingredient = new Ingredients(ingredientName);
		this.ingredients.add(ingredient);
	}

	public String printIngredients() {
		StringBuilder builder = new StringBuilder();
		for (Ingredients ingredient : ingredients) {
			builder.append(ingredient.getName() + ", ");
		}
		builder.setLength(builder.length() - 2); // removing the trailing ', ' characters
		return builder.toString();
	}

	@Override
	public String toString() {
		return String.format("%-25s%d\n%s\n", name, price, printIngredients());
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
