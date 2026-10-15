package com.absolute.bonkers.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Sandwich {
  private final String bread;
  private final String filling;
  private final List<String> toppings;

  private Sandwich(Builder builder) {
    bread = builder.bread;
    filling = builder.filling;
    toppings = List.copyOf(builder.toppings);
  }

  public String getBread() {
    return bread;
  }

  public String getFilling() {
    return filling;
  }

  public List<String> getToppings() {
    return toppings;
  }

  public static final class Builder {
    private final String bread;
    private final String filling;
    private final List<String> toppings = new ArrayList<>();

    public Builder(String bread, String filling) {
      this.bread = requireText(bread, "bread");
      this.filling = requireText(filling, "filling");
    }

    public Builder addTopping(String topping) {
      toppings.add(requireText(topping, "topping"));
      return this;
    }

    public Sandwich build() {
      return new Sandwich(this);
    }

    private static String requireText(String value, String name) {
      Objects.requireNonNull(value, name + " must not be null");
      if (value.isBlank()) {
        throw new IllegalArgumentException(name + " must not be blank");
      }
      return value;
    }
  }
}
