package com.absolute.bonkers.builder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SandwichTest {
  @Test
  void buildsSandwichWithRequiredAndOptionalParts() {
    Sandwich sandwich =
        new Sandwich.Builder("sourdough", "roasted vegetables")
            .addTopping("spinach")
            .addTopping("tomato")
            .build();

    assertThat(sandwich.getBread()).isEqualTo("sourdough");
    assertThat(sandwich.getFilling()).isEqualTo("roasted vegetables");
    assertThat(sandwich.getToppings()).containsExactly("spinach", "tomato");
  }

  @Test
  void supportsSandwichWithoutOptionalToppings() {
    Sandwich sandwich = new Sandwich.Builder("rye", "cheese").build();

    assertThat(sandwich.getToppings()).isEmpty();
  }

  @Test
  void keepsBuiltSandwichImmutable() {
    Sandwich.Builder builder = new Sandwich.Builder("wheat", "egg");
    Sandwich sandwich = builder.addTopping("lettuce").build();

    builder.addTopping("tomato");

    assertThat(sandwich.getToppings()).containsExactly("lettuce");
    assertThrows(
        UnsupportedOperationException.class, () -> sandwich.getToppings().add("onion"));
  }

  @Test
  void rejectsMissingRequiredPartsAndBlankToppings() {
    assertThrows(
        NullPointerException.class, () -> new Sandwich.Builder(null, "cheese"));
    assertThrows(
        IllegalArgumentException.class, () -> new Sandwich.Builder(" ", "cheese"));
    assertThrows(
        IllegalArgumentException.class,
        () -> new Sandwich.Builder("rye", "cheese").addTopping(" "));
  }
}
