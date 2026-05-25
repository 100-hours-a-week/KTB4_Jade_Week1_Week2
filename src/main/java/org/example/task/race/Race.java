package org.example.task.race;

import org.example.task.TaskStrategy;

import java.util.List;

public class Race implements TaskStrategy {
    private List<Runner> runners;
    private RaceResult raceResult;
    private static final Long GOAL_TIME = 10L;

    public Race(List<Runner> runners, RaceResult raceResult) {
        this.runners = runners;
        this.raceResult = raceResult;
    }

    @Override
    public boolean run() {
        //Runner 클래스 생성(Full/Ai/Cloud)
        //레이싱 시작시키기
        //최종 순위 출력 함수 호출.
    }

    @Override
    public String toString() {
        //소개글 작성
        return "";
    }

    @Override
    public void printDescription() {
        System.out.println(this);
    }
}
