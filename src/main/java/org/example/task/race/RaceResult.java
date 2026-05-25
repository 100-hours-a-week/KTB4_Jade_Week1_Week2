package org.example.task.race;

import java.util.concurrent.ConcurrentLinkedQueue;

public class RaceResult {
    private ConcurrentLinkedQueue<RaceInfoDto> rankingQueue;

    public RaceResult(ConcurrentLinkedQueue<RaceInfoDto> rankingQueue) {
        this.rankingQueue = rankingQueue;
    }

    public void recordRanking(RaceInfoDto raceInfoDto) {
        rankingQueue.add(raceInfoDto);
    }

    public void printRanking() {

    }

}