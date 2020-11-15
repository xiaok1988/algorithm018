package xiaok1988.walkingrobotsimulation;

public class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int maxDistance = 0;
        int x = 0;
        int y = 0;
        int direction = 0; // 0 north, 1, west, 2, sorth, 3,east
        if (commands == null || commands.length == 0) {
            return maxDistance;
        }

        for (int i = 0; i < commands.length; i++) {
            int tempx = x;
            int tempy = y;
            if (commands[i] == -2) {
                if (direction == 3) {
                    direction = 0;
                } else {
                    direction++;
                }

            } else if (commands[i] == -1) {
                if (direction == 0) {
                    direction = 3;
                } else {
                    direction--;
                }
            } else {
                if (direction == 0) {
                    //north
                    tempy += commands[i];
                    int obstacley = tempy;
                    for (int j = 0; j < obstacles.length; j++) {
                        if (obstacles[j][0] == x && (obstacles[j][1] > y && obstacles[j][1] <= tempy) ) {
                            if (obstacley > obstacles[j][1] - 1) {
                                obstacley = obstacles[j][1] - 1; // 停在线路上最近的一个障碍物前面
                            }
                        }
                    }
                    y = Math.min(obstacley, tempy);
                } else if (direction == 1) {
                    //west
                    tempx -= commands[i];
                    int obstaclex = tempx;
                    for (int j = 0; j < obstacles.length; j++) {
                        if (obstacles[j][1] == y && (obstacles[j][0] >= tempx && obstacles[j][0] < x) ) {
                            if (obstaclex < obstacles[j][0] + 1) {
                                obstaclex = obstacles[j][0] + 1; // 停在线路上最近的一个障碍物前面
                            }
                        }
                    }
                    x = Math.max(obstaclex, tempx);

                } else if (direction == 2) {
                    //south
                    tempy -= commands[i];
                    int obstacley = tempy;
                    for (int j = 0; j < obstacles.length; j++) {
                        if (obstacles[j][0] == x && (obstacles[j][1] >= tempy && obstacles[j][1] < y) ) {
                            if (obstacley < obstacles[j][1] + 1) {
                                obstacley = obstacles[j][1] + 1; // 停在线路上最近的一个障碍物前面
                            }
                        }
                    }
                    y = Math.max(obstacley, tempy);
                } else {
                    //east
                    tempx += commands[i];
                    int obstaclex = tempx;
                    for (int j = 0; j < obstacles.length; j++) {
                        if (obstacles[j][1] == y && (obstacles[j][0] > x && obstacles[j][0] <= tempx) ) {
                            if (obstaclex > obstacles[j][0] - 1) {
                                obstaclex = obstacles[j][0] - 1; // 停在线路上最近的一个障碍物前面
                            }
                        }
                    }
                    x = Math.min(obstaclex, tempx);
                }

                int dist = x*x+y*y;
                if (dist > maxDistance) {
                    maxDistance = dist;
                }

            }


        }
        return maxDistance;
    }
}