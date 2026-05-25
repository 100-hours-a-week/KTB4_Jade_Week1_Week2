package org.example.task.race;

public class Runner implements Runnable {
    private final String trackName;
    private long startRaceTime;
    private final RaceResult raceResult;

    public Runner(String trackName, RaceResult raceResult) {
        this.trackName = trackName;
        this.raceResult = raceResult;
    }

    @Override
    public void run() {
        //최종 목표 시간이 다 될 때까지 1~3초 단위의 랜덤 숫자 계속 할당받음
        //최종 목표 시간이 다 되었다면 Race에 순위 등록 후 "트랙name" + 도착~! 출력.
    }
}