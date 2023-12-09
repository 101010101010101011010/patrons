package edu.ics4u.nicolas.sceneries;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.BufferedReader;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

import edu.ics4u.nicolas.App;

class StreamGobbler implements Runnable {
    private InputStream inputStream;
    private Consumer<String> consumer;

    public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
        this.inputStream = inputStream;
        this.consumer = consumer;
    }

    @Override
    public void run() {
        new BufferedReader(new InputStreamReader(inputStream)).lines()
          .forEach(consumer);
    }
}

public class StadiumScenery implements Scenery {
  public static void main(String[] args) {
    try {
      //Process process = new ProcessBuilder("cmd.exe", "/c", "chcp", "65001").start();

      Process process = Runtime.getRuntime().exec(String.format("cmd.exe /c chcp 65001"));
      StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
      ExecutorService executorService = Executors.newFixedThreadPool(1);
      Future<?> future = executorService.submit(streamGobbler);

      int exitCode = process.waitFor();
      
      System.out.println(exitCode);
    } catch (Exception e) {
      e.printStackTrace();
    }

    StadiumScenery stadiumScenery = new StadiumScenery();
    while (true) {
      try{
        TimeUnit.MILLISECONDS.sleep(250);
      } catch (Exception e) { }
      
      stadiumScenery.step(1);
      System.out.print("\033[H\033[2J");
      System.out.flush();
      System.out.println(stadiumScenery.render());
    }
  }

  private final String scene = "🚐__⇐__ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ __ ";

  private int offset = 0;

  @Override
  public String render() {
    String str = scene.substring(offset, scene.length());
    
    while (str.length() < printWidth) {
      str += scene;
    }

    return str.substring(0, printWidth);
  }

  @Override
  public void step(int fps) {
    offset = (offset - 1 + scene.length()) % scene.length(); // TODO: replace with speed of car
  }
}
