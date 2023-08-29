package org.example.task2.worker;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {
  private final BlockingQueue<String> expressionQueue;

  public Worker(BlockingQueue<String> expressionQueue) {
    this.expressionQueue = expressionQueue;
  }

  @Override
  public void run() {
    while (true) {
      try {
        String expression = expressionQueue.take();
        if (expression.equals("end")) {
          break;
        }

        makeApiRequest(expression);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private void makeApiRequest(String expression) throws IOException, InterruptedException {
    System.out.println("Api is making request");
    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create("https://evaluate-expression.p.rapidapi.com/?expression=" + expression))
        .header("X-RapidAPI-Key", "686d5a0672mshff6525c3cb4d54fp1eb509jsnb6832e4c1397")
        .header("X-RapidAPI-Host", "evaluate-expression.p.rapidapi.com")
        .method("GET", HttpRequest.BodyPublishers.noBody())
        .build();
    HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(expression + " => " + response.body().toString());
  }
}
