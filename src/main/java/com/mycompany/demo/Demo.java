/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.demo;

/**
 *
 * @author quang
 */
import java.util.Scanner;

class Stack {
    private int maxSize;
    private String[] stackArray;
    private int top;
// constructor
    public Stack(int size) {
        maxSize = size;
        stackArray = new String[maxSize];
        top = -1;
    }
// them phan tu vao dau nx
    public void push(String value) {
       //dieu kien kiem tra nx full chua
       if (top < maxSize - 1) {
            stackArray[++top] = value;
        } else {
            System.out.println("Error: Stack overflow. Cannot push message: " + value);
        }
    }
// lay va tra ve pt o dinh nx
    public String pop() {
        if (top >= 0) {  //ktra co pt 0
            return stackArray[top--];                                           //neu co gt
        } else {
            System.out.println("Error: Stack underflow. Stack is empty.");    //neu ko gt
            return null;
        }
    }
//ktra 
    public boolean isEmpty() {
        return top == -1;
    }
}

class Queue { //bien
    private int maxSize;
    private String[] queueArray;       //luutru
    private int front;
    private int rear;
    private int size;
    //constructor
    public Queue(int size) {
        maxSize = size;                    //toida
        queueArray = new String[maxSize];
        front = 0;                              //1
        rear = -1;                              //r
        size = 0;                               //r
    }
//them 1 pt cuoi hd
    public void enqueue(String value) {
        if (size < maxSize) {                         //ktra full
            if (rear == maxSize - 1) {                 //dat=-1 -> dau mang
                rear = -1;
            }
            queueArray[++rear] = value;
            size++;
        } else {
            System.out.println("Error: Queue is full. Cannot enqueue message: " + value);  //full->fail
        }
    }
//lay pt tra ve pt dau
    public String dequeue() {
        if (size > 0) {                                               //ktra full
            String temp = queueArray[front++];
            if (front == maxSize) {                                   //neu o lastmag
                front = 0;                                            //dat=0backvedau
            }
            size--;
            return temp;
        } else {
            System.out.println("Error: Queue is empty. Cannot dequeue message.");  //rong->fail
            return null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

public class Demo {
    public static void main(String[] args) {
        int maxSize = 10; // xd kich thuoc toi da cua hdoi va nxep
        Queue queueClass = new Queue(maxSize);   //hd
        Stack classStack = new Stack(maxSize);   //nx
        Scanner scanner = new Scanner(System.in);  //doc du lieu banph

        // them tin nhan tu ban phim
        System.out.println("Enter messages (press 'end' to stop the program):");
        String userInput;      
        while (!(userInput = scanner.nextLine()).equals("end")) {         //luutru input
            if (userInput.length() <= 250) {
                queueClass.enqueue(userInput);
            } else {
                System.out.println("Error: Message exceeds 250 characters limit."
                        + " Please enter a shorter message.");
            }
        }

        // xep hang tn va day vao ngan xep
        while (!queueClass.isEmpty()) {              //lay tn tu hd day vao nx  // ktra isE 
            String message = queueClass.dequeue();
            if (message != null) {
                classStack.push(message);
            }
        }

        // Pop tin nhan  tu nx va hien thi
        while (!classStack.isEmpty()) {
            System.out.println("Message sent to stack: " + classStack.pop());    //sd pop lay tn tu dinh nx
        }

        scanner.close();
    }
}








