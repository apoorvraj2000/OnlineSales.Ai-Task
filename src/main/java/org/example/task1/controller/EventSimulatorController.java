package org.example.task1.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.task1.dto.SimulatedOutcomeDto;
import org.example.task1.model.Outcome;
import org.example.task1.service.EventSimulatorService;

public class EventSimulatorController {
  final int totalOccurrences = 1000;

  public SimulatedOutcomeDto simulate(List<Outcome> outcomes) {
    EventSimulatorService coinEventSimulator = new EventSimulatorService(outcomes);

    Map<Integer, Integer> occurrencesMap = new HashMap<>();

    for (int i = 0; i < totalOccurrences; i++) {
      int outcome = coinEventSimulator.simulateEvent();
      occurrencesMap.put(outcome, occurrencesMap.getOrDefault(outcome, 0) + 1);
    }

    SimulatedOutcomeDto simulatedOutcomeDto = new SimulatedOutcomeDto(outcomes, totalOccurrences, occurrencesMap);
    return simulatedOutcomeDto;
  }
}
