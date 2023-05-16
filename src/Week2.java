//Java program to store the queue into stack by implementing linked list

package demo;

class Node {
    private WeekDay data;
    private Node next;

    public Node(WeekDay data) {
        this.data = data;
        this.next = null;
    }

    public WeekDay getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class Stack {
    private Node top;

    public Stack() {
        top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(WeekDay data) {
        Node newNode = new Node(data);
        newNode.setNext(top);
        top = newNode;
    }

    public WeekDay pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        WeekDay data = top.getData();
        top = top.getNext();
        return data;
    }

    public WeekDay peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
        }

        return top.getData();
    }
}

public class Week2 {
    private Stack stack1;
    private Stack stack2;

    public Week2() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    public void addWeekDay(WeekDay weekDay) {
        stack1.push(weekDay);
    }

    public void transferStacks() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public void displayCalendar() {
        transferStacks();

        System.out.println("Calendar:");
        
        // Display the items in stack1
        while (!stack1.isEmpty()) {
            WeekDay weekDay = stack1.pop();
            System.out.println(weekDay.getDay() + ": " + weekDay.getDate());
            stack2.push(weekDay); // Push the item to stack2
        }
        
        // Display the items in stack2
        while (!stack2.isEmpty()) {
            WeekDay weekDay = stack2.pop();
            System.out.println(weekDay.getDay() + ": " + weekDay.getDate());
            stack1.push(weekDay); // Push the item back to stack1
        }
    }

    public static void main(String[] args) {
        // Creating Week2 object
        Week2 week = new Week2();

        // Creating WeekDay objects and add them to the Week2 object
        week.addWeekDay(new WeekDay("Sunday", ""));
        week.addWeekDay(new WeekDay("Monday", "1"));
        week.addWeekDay(new WeekDay("Tuesday", "2"));
        week.addWeekDay(new WeekDay("Wednesday", "3"));
        week.addWeekDay(new WeekDay("Thursday", ""));
        week.addWeekDay(new WeekDay("Friday", "4"));
        week.addWeekDay(new WeekDay("Saturday", "5"));

        // Displaying the calendar
        week.displayCalendar();
    }
}
