
import java.util.Scanner;
import org.w3c.dom.Node;

class Node {
    String data;
    Node next;
    
  // initialize 
    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class ToDoList {
    private Node head;

    public ToDoList() {
        head = null;
    }

    //  Create the given task 
    
    public void addTask(String task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        System.out.println("Task '" + task + "' added to the list.");
    }

    // Delete a task from the list
    
    public void deleteTask(String task) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.data.equals(task)) {
            head = head.next;
            System.out.println("Task '" + task + "' deleted from the list.");
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(task)) {
                current.next = current.next.next;
                System.out.println("Task '" + task + "' deleted from the list.");
                return;
            }
            current = current.next;
        }
        System.out.println("Task '" + task + "' not found in the list.");
    }

    // View all tasks 
    
    public void viewTasks() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("To-Do List:");
        Node current = head;
        while (current != null) {
            System.out.println("- " + current.data);
            current = current.next;
        }
    }
}
     // To Do the List

public class NodeTodolist  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();
       
        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
           // New Line or Next Line
            
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            

            switch (choice) {
                case 1:
                    System.out.print("Enter task: ");
                    String task = scanner.nextLine();
                    toDoList.addTask(task);
                    break;
                case 2:
                // Task to Delete
                    System.out.print("Enter task to delete: ");
                    String taskToDelete = scanner.nextLine();
                    toDoList.deleteTask(taskToDelete);
                    break;
                case 3:
                    toDoList.viewTasks();
                    break;
                case 4:
                    System.out.println("Exit...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid. Please try again.");
            }
        }
    }
}
