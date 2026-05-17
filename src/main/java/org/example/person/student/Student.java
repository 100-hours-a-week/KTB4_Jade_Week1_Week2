package org.example.person.student;

import org.example.person.Person;

public class Student extends Person {
    private int attempts;
    private int passCount;
    private int failCount;

    public Student(String name) {
        super(name);
    }

    public void recordPass() {
        attempts++;
        passCount++;
    }

    public void recordFail() {
        attempts++;
        failCount++;
    }

    public void printFinalResult() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "\n================================\n" +
                " " + getName() + "님의 학습 기록\n" +
                " 총 도전 횟수: " + attempts + "번\n" +
                " 통과: " + passCount + "번 / 실패: " + failCount + "번\n" +
                "================================";
    }
}