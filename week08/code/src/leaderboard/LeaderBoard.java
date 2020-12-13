package leaderboard;

import java.util.*;

class Leaderboard {

    private Map<Integer, Integer> scores ;

    public Leaderboard() {
        scores = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        if (scores.get(playerId) == null) {
            scores.put(playerId, score);
        } else {
            scores.put(playerId, scores.get(playerId) + score);
        }
    }

    public int top(int K) {
        List<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : scores.entrySet()) {
            list.add(entry.getValue());
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });
        int result = 0;
        for (int i = 0; i < K ; i++) {
            result += list.get(i);
        }
        return result;

    }

    public void reset(int playerId) {
        scores.put(playerId, 0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
