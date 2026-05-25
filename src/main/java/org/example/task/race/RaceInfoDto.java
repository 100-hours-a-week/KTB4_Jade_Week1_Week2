package org.example.task.race;

public record RaceInfoDto(String trackName, int lapsedTime) {
    @Override
    public String toString() {
        return trackName + " (" + lapsedTime + "초)";
    }
}
