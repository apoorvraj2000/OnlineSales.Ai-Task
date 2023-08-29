package org.example.task1.service;

import java.util.List;
import java.util.Random;
import org.example.task1.model.Outcome;

public class EventSimulatorService {
  private final List<Outcome> outcomes;
  private final Random random;

  public EventSimulatorService(List<Outcome> outcomes) {
    this.outcomes = outcomes;
    this.random = new Random();
  }

  public int simulateEvent() {
    int totalProbability = outcomes.stream().mapToInt(Outcome::getProbability).sum();
    int randomNumber = random.nextInt(totalProbability);

    int accumulatedProbability = 0;
    for (Outcome outcome : outcomes) {
      accumulatedProbability += outcome.getProbability();
      if (randomNumber < accumulatedProbability) {
        return outcome.getName();
      }
    }

    throw new IllegalStateException("Probabilities do not add up correctly");
  }
}
