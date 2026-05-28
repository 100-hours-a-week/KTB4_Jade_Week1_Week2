package org.example.task.race;

import org.example.system.io.Message;
import org.example.system.io.OutputView;
import org.example.track.TrackType;

import java.util.ArrayDeque;
import java.util.Queue;

public class RaceResult {
    private final Queue<RaceInfoDto> rankingQueue;

    public RaceResult() {
        this.rankingQueue = new ArrayDeque<>();
    }

    public boolean matchWinner(String predict) {
        String predictedTrack = TrackType.from(predict).getName();
        RaceInfoDto winner = rankingQueue.peek();
        if (winner == null) {
            throw new IllegalStateException(Message.NON_RACE_RESULT);
        }
        return winner.trackName().equals(predictedTrack);
    }

    public synchronized void recordRanking(RaceInfoDto raceInfoDto) {
        rankingQueue.add(raceInfoDto);
    }

    public void printRanking() {
        int rank = 0;
        int prevElapsedTime = -1;
        OutputView.printRaceResult();
        for (RaceInfoDto dto : rankingQueue) {
            if(prevElapsedTime < dto.lapsedTime()) {
                rank++;
                prevElapsedTime = dto.lapsedTime();
            }
            OutputView.printRanking(rank, dto);
        }
    }

}