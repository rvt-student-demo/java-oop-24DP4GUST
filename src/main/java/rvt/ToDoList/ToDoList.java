package rvt.ToDoList;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    private ArrayList<String> tasks;
    private final String fileName = "todo.csv";

    public ToDoList() {
        this.tasks = new ArrayList<>();
        loadFromFile();
    }

    private void loadFromFile() {
        File file = new File(fileName);
        if (!file.exists()) {
            return;
        }
        
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    tasks.add(parts[1].trim());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Fails nav atrasts!");
        }
    }

    private int getActivity() {
        return tasks.size();
    }

    public void add(String task) {
        tasks.add(task);
        updateList();
    }

    private boolean updateList() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (int i = 0; i < tasks.size(); i++) {
                writer.println((i + 1) + "," + tasks.get(i));
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void newrow(int id) {
        if (id >= 1 && id <= tasks.size()) {
            tasks.remove(id - 1);
            updateList();
        }
    }

    public void printList() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ", " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        ToDoList list = new ToDoList();
        
        list.add("do a homework");
        list.add("exercise 30 min");
        list.add("go for a walk");
        
        System.out.println("Pirms dzēšanas:");
        list.printList();
        
        list.newrow(2);
        
        System.out.println("\nPēc dzēšanas:");
        list.printList();
    }
}