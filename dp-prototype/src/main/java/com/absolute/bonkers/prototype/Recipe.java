package com.absolute.bonkers.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Recipe {
  private String name;
  private final List<String> ingredients;

  public Recipe(String name, List<String> ingredients) {
    this.name = requireText(name, "name");
    Objects.requireNonNull(ingredients, "ingredients must not be null");
    this.ingredients = new ArrayList<>();
    ingredients.forEach(ingredient -> this.ingredients.add(requireText(ingredient, "ingredient")));
  }

  private Recipe(Recipe prototype) {
    name = prototype.name;
    ingredients = new ArrayList<>(prototype.ingredients);
  }

  public String getName() {
    return name;
  }

  public List<String> getIngredients() {
    return List.copyOf(ingredients);
  }

  public void setName(String name) {
    this.name = requireText(name, "name");
  }

  public void addIngredient(String ingredient) {
    ingredients.add(requireText(ingredient, "ingredient"));
  }

  public Recipe copy() {
    return new Recipe(this);
  }

  private static String requireText(String value, String name) {
    Objects.requireNonNull(value, name + " must not be null");
    if (value.isBlank()) {
      throw new IllegalArgumentException(name + " must not be blank");
    }
    return value;
  }
}
