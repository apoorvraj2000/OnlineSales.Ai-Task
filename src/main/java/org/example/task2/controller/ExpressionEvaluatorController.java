package org.example.task2.controller;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import org.example.task2.worker.Worker;

public class ExpressionEvaluatorController {
  private static final int MAX_CONCURRENT_REQUESTS = 50;
  public void evaluateExpression(List<String> request){
    ExecutorService executor = Executors.newFixedThreadPool(MAX_CONCURRENT_REQUESTS);
    BlockingQueue<String> expressionQueue = new LinkedBlockingQueue<>();

    for(String rqst : request)
      expressionQueue.add(rqst);

    for (int i = 0; i < MAX_CONCURRENT_REQUESTS; i++) {
      executor.submit(new Worker(expressionQueue));
    }

    executor.shutdown();
  }
}
