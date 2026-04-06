package todolist;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToDoList {
    static boolean isRunning=true;
    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner bleh = new Scanner(System.in);
    public static void main(String[] args) {
        while(isRunning){
            System.out.println("******************");
            System.out.println("    TO DO LIST    ");
            System.out.println("******************");
            System.out.println("******************");
            System.out.println("       MENU      ");
            System.out.println("1:ADD A TASK");
            System.out.println("2:VIEW TASK");
            System.out.println("3:MARK AS DONE");
            System.out.println("4:REMOVE TASK");
            System.out.println("5:SAVE TASKS");
            System.out.println("6:EXIT");
            int choice;
            try {
                System.out.print("Enter your choice(1-6):");
                choice = bleh.nextInt();
                bleh.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Enter a valid choice ");
                bleh.nextLine();
                continue;
            }

            switch(choice){
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTask();
                    break;
                case 3:
                    markTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    saveTask();
                    break;
                case 6:
                    isRunning = false;
                    break;
                default:
                    System.out.println("ENTER A VALID CHOICE!!!");
                    break;
            }
        }
    }

    private static void saveTask(){
        Path writePath = Paths.get("src/todolist/tasks.txt");
        int idx = 1;
        try{
            BufferedWriter writer = Files.newBufferedWriter(writePath,
                    StandardOpenOption.CREATE,StandardOpenOption.TRUNCATE_EXISTING);
            for (Task t : tasks){
                writer.write(idx + " " + t);
                writer.newLine();
                idx++;
            }
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void deleteTask() {
        System.out.print("Enter the id of the task you want to remove:");
        int remove = bleh.nextInt()-1;
        bleh.nextLine();
        tasks.remove(remove);
        System.out.println("Task removed Successfully");
    }

    private static void markTask() {
        System.out.print("Enter which number of task to mark: ");
        int id  = bleh.nextInt()-1;
        bleh.nextLine();
        Task task = tasks.get(id);
        if(task.getStatus()!= STATUS.COMPLETED) {
            task.markCompleted();
            System.out.println("***************");
            System.out.println("TASK COMPLETED");
        }else{
            System.out.println("Task is already completed");
        }
    }

    private static void viewTask() {
        int idx=1;
        System.out.println("***************");
        for (Task task : tasks) {
            System.out.println(idx + ":" + task);
            idx++;
        }
    }

    private static void addTask() {
        System.out.println("***************");
        System.out.print("Enter your task:");
        String task = bleh.nextLine();
        tasks.add(new Task(task));
        System.out.println("TASK ADDED");
    }
}
