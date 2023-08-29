package task1.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.example.task1.model.Outcome;
import org.example.task1.service.EventSimulatorService;
import org.junit.Test;

public class EventSimulatorServiceTest {
  @Test
  public void testSimulateEvent() {
    List<Outcome> outcomes = new ArrayList<>();
    outcomes.add(new Outcome(1, 20));
    outcomes.add(new Outcome(2, 30));
    outcomes.add(new Outcome(3, 50));

    EventSimulatorService eventSimulator = new EventSimulatorService(outcomes);


    Random randomMock = mock(Random.class);
    when(randomMock.nextInt(anyInt())).thenReturn(40);


    int simulatedOutcome = eventSimulator.simulateEvent();

    assertEquals(3, simulatedOutcome);
  }
}
