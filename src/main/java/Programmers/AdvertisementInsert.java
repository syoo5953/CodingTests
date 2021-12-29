package Programmers;

import java.util.Arrays;

public class AdvertisementInsert {
    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        String answer = solution17.solution(play_time, adv_time, logs);
        System.out.println("Answer = " + answer);
    }
}

class Solution17 {
    public String solution(String play_time, String adv_time, String[] logs) {
        int playTime = timeToSecond(play_time), advTime = timeToSecond(adv_time);
        int[] totalTime = new int[100 * 3600];

        for (String log : logs) {
            String[] splitTimes;
            splitTimes = log.split("-");
            int startTime = timeToSecond(splitTimes[0]);
            int finishTime = timeToSecond(splitTimes[1]);
            for (int i = startTime; i <= finishTime; i++) {
                totalTime[i] += 1;
            }
        }

        for (int i = 0; i < totalTime.length; i++) {
            if(totalTime[i] == 3) {
                int time = i - advTime;
                System.out.println(String.format("%02d:%02d:%02d", time / (60 * 60), (time / 60) % 60, time % 60));
            }
        }

        return null;
        //return String.format("%02d:%02d:%02d", maxStartTime / (60 * 60), (maxStartTime / 60) % 60, maxStartTime % 60);
    }

    int timeToSecond(String str) {
        int[] parse = Arrays.stream(str.split(":")).mapToInt(Integer::parseInt).toArray();
        return parse[0] * 60 * 60 + parse[1] * 60 + parse[2];
    }
}
