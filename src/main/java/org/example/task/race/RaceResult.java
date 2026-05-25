package org.example.task.race;

import org.example.system.io.Message;
import org.example.track.TrackType;

import java.util.concurrent.ConcurrentLinkedQueue;

public class RaceResult {
    private final ConcurrentLinkedQueue<RaceInfoDto> rankingQueue;

    public RaceResult() {
        this.rankingQueue = new ConcurrentLinkedQueue<>();
    }

    public boolean matchWinner(String predict) {
        String predictedTrack = TrackType.from(predict).getName();
        RaceInfoDto winner = rankingQueue.peek();
        if (winner == null) {
            throw new IllegalStateException(Message.NON_RACE_RESULT);
        }
        return winner.trackName().equals(predictedTrack);
    }

    public void recordRanking(RaceInfoDto raceInfoDto) {
        rankingQueue.add(raceInfoDto);
    }

    public void printRanking() {
        int rank = 1;
        for (RaceInfoDto dto : rankingQueue) {
            System.out.println(rank + "등: " + dto);
            rank++;
        }
    }

}