package org.example.task.race;

import org.example.system.util.RandomNumberUtil;

public class Runner implements Runnable {
    private final String trackName;
    private final RaceResult raceResult;
    private static final long ONE_SECOND_MILLIS = 1000L;
    private long startTime;

    public Runner(String trackName, RaceResult raceResult) {
        this.trackName = trackName;
        this.raceResult = raceResult;
    }

    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        race();
        finish();
    }

    private void race() {
        int nowDistance = 0;

        while (nowDistance < RaceRules.GOAL_DISTANCE) {
            waitOneSecond();

            int randomMove = generateMoveDistance();
            nowDistance = move(nowDistance, randomMove);

            printCurrentDistance(nowDistance);
        }
    }

    private void waitOneSecond() {
        try {
            Thread.sleep(ONE_SECOND_MILLIS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException(trackName + " 경주가 중단되었습니다.", e);
        }
    }

    private int generateMoveDistance() {
        return RandomNumberUtil.generate(
                RaceRules.MIN_MOVE,
                RaceRules.MAX_MOVE
        );
    }

    private int move(int nowDistance, int moveDistance) {
        return Math.min(
                nowDistance + moveDistance,
                RaceRules.GOAL_DISTANCE
        );
    }

    private void printCurrentDistance(int nowDistance) {
        System.out.println(trackName + ": " + nowDistance + "/" + RaceRules.GOAL_DISTANCE);
    }

    private void finish() {
        raceResult.recordRanking(new RaceInfoDto(trackName, (int)getElapsedSeconds(startTime)));
        System.out.println("⛳️ " + trackName + " 도착~!");
    }

    private long getElapsedSeconds(long startTime) {
        return (System.currentTimeMillis() - startTime) / 1000;
    }
}