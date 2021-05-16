package rplDefenderArcade;

import java.util.*;
import java.util.stream.Collectors;

public class DefenderArcade {
    public int countArcades (List<String> times) {
        int maxGames=0;
        System.out.println(times);
        List<List<String>> stringSplit = new ArrayList<>();
        for(String time:times) {
            stringSplit.add(Arrays.asList(time.split(" ")));
        }

        List<List<Integer>> timesList = stringSplit.stream()
                .map(strings -> strings.stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()))
                .sorted(Comparator.comparingInt(o -> o.get(0)))
                .collect(Collectors.toList());

        PriorityQueue<List<Integer>> playingQueue=new PriorityQueue<>(Comparator.comparingInt(o -> o.get(1)));

        for(List<Integer> timeList:timesList) {
            while (!playingQueue.isEmpty() && playingQueue.peek().get(1)<timeList.get(0)) {
                playingQueue.poll();
            }
            playingQueue.add(timeList);
            maxGames=Math.max(maxGames, playingQueue.size());
        }
        return maxGames;
    }
}
