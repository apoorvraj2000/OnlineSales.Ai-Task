package task1.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.task1.dto.SimulatedOutcomeDto;
import org.example.task1.model.Outcome;
import org.example.task1.service.EventSimulatorService;
import org.junit.Before;
import org.junit.Test;

public class EventSimulatorControllerTest {
  private List<Outcome> outcomes;

  @Before
  public void setup() {
    outcomes = new ArrayList<>();
    outcomes.add(new Outcome(1, 10));
    outcomes.add(new Outcome(2, 30));
    outcomes.add(new Outcome(3, 15));
    outcomes.add(new Outcome(4, 15));
    outcomes.add(new Outcome(5, 30));
    outcomes.add(new Outcome(6, 0));
  }

  @Test
  public void testSimulate() {
    int totalOccurrences = 1000;
    SimulatedOutcomeDto simulatedOutcomeDto = simulate(outcomes, totalOccurrences);

    assertEquals(outcomes, simulatedOutcomeDto.getOutcomes());

    assertEquals(totalOccurrences, simulatedOutcomeDto.getTotalOccurrences());

    assertFalse(simulatedOutcomeDto.getOccurrencesMap().isEmpty());

    int sumOccurrences = simulatedOutcomeDto.getOccurrencesMap().values().stream()
        .mapToInt(Integer::intValue)
        .sum();
    assertEquals(totalOccurrences, sumOccurrences);
  }

  private SimulatedOutcomeDto simulate(List<Outcome> outcomes, int totalOccurrences) {
    EventSimulatorService coinEventSimulator = new EventSimulatorService(outcomes);

    Map<Integer, Integer> occurrencesMap = new HashMap<>();

    for (int i = 0; i < totalOccurrences; i++) {
      int outcome = coinEventSimulator.simulateEvent();
      occurrencesMap.put(outcome, occurrencesMap.getOrDefault(outcome, 0) + 1);
    }

    return new SimulatedOutcomeDto(outcomes, totalOccurrences, occurrencesMap);
  }
}
