package org.example.task.race;

import org.example.system.io.Message;
import org.example.system.io.OutputView;
import org.example.track.TrackType;

import java.util.ArrayDeque;
import java.util.Optional;
import java.util.Queue;

public class RaceResult {
    private final Queue<RaceInfoDto> rankingQueue;
    private static final int INITIAL_RANK = 0;
    private static final int INITIAL_PREVIOUS_ELAPSED_TIME = -1;

    public RaceResult() {
        this.rankingQueue = new ArrayDeque<>();
    }

    public boolean matchWinner(String predict) {
        String predictedTrack = TrackType.from(predict).getName();

        RaceInfoDto winner = Optional.ofNullable(rankingQueue.peek())
                .orElseThrow(() -> new IllegalStateException(Message.NON_RACE_RESULT));

        return winner.trackName().equals(predictedTrack);
    }

    public synchronized void recordRanking(RaceInfoDto raceInfoDto) {
        rankingQueue.add(raceInfoDto);
    }

    public void printRanking() {
        int rank = INITIAL_RANK;
        int prevElapsedTime = INITIAL_PREVIOUS_ELAPSED_TIME;
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
