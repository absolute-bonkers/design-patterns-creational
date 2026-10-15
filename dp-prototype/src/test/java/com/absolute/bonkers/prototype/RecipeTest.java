package com.absolute.bonkers.prototype;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.Test;

class RecipeTest {
  @Test
  void copiesPrototypeAndAllowsIndependentChanges() {
    Recipe original = new Recipe("Vegetable soup", List.of("carrot", "potato"));
    Recipe copy = original.copy();

    copy.setName("Spicy vegetable soup");
    copy.addIngredient("chili");

    assertThat(copy).isNotSameAs(original);
    assertThat(copy.getName()).isEqualTo("Spicy vegetable soup");
    assertThat(copy.getIngredients()).containsExactly("carrot", "potato", "chili");
    assertThat(original.getName()).isEqualTo("Vegetable soup");
    assertThat(original.getIngredients()).containsExactly("carrot", "potato");
  }

  @Test
  void returnsAnImmutableIngredientsView() {
    Recipe recipe = new Recipe("Toast", List.of("bread"));

    assertThrows(
        UnsupportedOperationException.class, () -> recipe.getIngredients().add("butter"));
  }

  @Test
  void rejectsInvalidRecipeData() {
    assertThrows(IllegalArgumentException.class, () -> new Recipe(" ", List.of("bread")));
    assertThrows(
        NullPointerException.class, () -> new Recipe("Toast", null));
    assertThrows(
        IllegalArgumentException.class, () -> new Recipe("Toast", List.of(" ")));
  }
}
