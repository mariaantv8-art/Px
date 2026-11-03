package edu.course.lab02;

public class BankAccount {
    private int balance;
        public BankAccount(int initialBalance) {
        if (balance < 0 ){
            throw new IllegalArgumentException("сумма баланма должна быть больше нуля");
        }
        this.balance = initialBalance;
    }
public void deposit (int amount){
    if (amount <= 0){
        throw new IllegalArgumentException("сумма пополнения должна быть больше нуля");
    }
    this.balance += amount;
    }
public void withdraw (int amount){
    if (amount <= 0){
        throw new IllegalArgumentException("сумма снятия должна быть больше нуля ");
    }
    if (amount > this.balance){
        throw new IllegalArgumentException("сумма снятия должна быть меньше баланса");
    }
        this.balance -= amount;
}
public int getBalance(){
    return  this.balance;
}
}