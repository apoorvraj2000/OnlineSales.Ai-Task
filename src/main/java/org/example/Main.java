package org.example;

import java.util.*;
import org.example.task1.controller.EventSimulatorController;
import org.example.task1.dto.SimulatedOutcomeDto;
import org.example.task1.model.Outcome;
import org.example.task2.controller.ExpressionEvaluatorController;


public class Main {
  public static void main(String[] args) {
    System.out.println("--------------TASK 1-----------------------------------");
    EventSimulatorController eventSimulatorController = new EventSimulatorController();
    List<Outcome> coinOutcomes = new ArrayList<>();
    coinOutcomes.add(new Outcome(1, 35));//1-> Head
    coinOutcomes.add(new Outcome(2, 65));//2-> Tail

    SimulatedOutcomeDto coinResponse=eventSimulatorController.simulate(coinOutcomes);
    printOutput(coinResponse);

    List<Outcome> diceOutcomes = new ArrayList<>();
    diceOutcomes.add(new Outcome(1, 10));
    diceOutcomes.add(new Outcome(2, 30));
    diceOutcomes.add(new Outcome(3, 15));
    diceOutcomes.add(new Outcome(4, 15));
    diceOutcomes.add(new Outcome(5, 30));
    diceOutcomes.add(new Outcome(6, 0));
    SimulatedOutcomeDto diceResponse=eventSimulatorController.simulate(diceOutcomes);
    printOutput(diceResponse);

    System.out.println("--------------------TASK 2-------------------------------");
    List<String> request = new ArrayList<>();
    request.add("2 * 4 * 4");
    request.add("5 / (7 - 5)");
    request.add("sqrt(5^2 - 4^2)");
    request.add("sqrt(-3^2 - 4^2)");

    ExpressionEvaluatorController expressionEvaluatorController = new ExpressionEvaluatorController();
    expressionEvaluatorController.evaluateExpression(request);
  }

  private static void printOutput(SimulatedOutcomeDto simulatedOutcomeDto) {
    System.out.println("Outcome distribution after " + simulatedOutcomeDto.getTotalOccurrences() + " occurrences:");
    for (Outcome outcome : simulatedOutcomeDto.getOutcomes()) {
      int occurrences = simulatedOutcomeDto.getOccurrencesMap().getOrDefault(outcome.getName(), 0);
      System.out.println(outcome.getName() + ": " + occurrences + " times");
    }
  }
}