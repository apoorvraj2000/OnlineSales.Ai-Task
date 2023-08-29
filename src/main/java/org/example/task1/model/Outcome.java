package org.example.task1.model;

public class Outcome {
  private final int name;
  private final int probability;

  public Outcome(int name, int probability) {
    this.name = name;
    this.probability = probability;
  }

  public int getName() {
    return name;
  }

  public int getProbability() {
    return probability;
  }
}
