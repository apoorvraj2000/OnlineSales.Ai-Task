package org.example.task1.dto;

import java.util.List;
import java.util.Map;
import org.example.task1.model.Outcome;

public class SimulatedOutcomeDto {
  private final List<Outcome> outcomes;

  private final int totalOccurrences;

  private final Map<Integer, Integer> occurrencesMap;

  public SimulatedOutcomeDto(List<Outcome> outcomes, int totalOccurrences, Map<Integer, Integer> occurrencesMap) {
    this.outcomes = outcomes;
    this.totalOccurrences = totalOccurrences;
    this.occurrencesMap = occurrencesMap;
  }

  public List<Outcome> getOutcomes() {
    return outcomes;
  }


  public int getTotalOccurrences() {
    return totalOccurrences;
  }


  public Map<Integer, Integer> getOccurrencesMap() {
    return occurrencesMap;
  }

}
