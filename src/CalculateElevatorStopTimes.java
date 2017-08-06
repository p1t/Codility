import java.util.*;

public class CalculateElevatorStopTimes {

    // Codility的題目，計算電梯需要停幾次才能把所有隊列中的人都載完
    // 給予兩個陣列A與B，分別是隊列中的人的體重與目標樓層，參數M為大樓總共的樓層，參數X為電梯載運的人數限制，參數Y為電梯載運的重量限制
    // 每次電梯在不超過限制的情況下載人，順序要按照陣列中的順序，就算隊列中後面有人可以先塞，也不行。
    // 電梯在把這趟的人都送完後，會回到1樓載下一趟的人，直到所有人都載完。
    // 計算停靠次數要包含每趟載完後回到一樓的那次，但不包含最一開始停在一樓的那次。
    public static void main(String[] args) {
        int[] weight = {50, 60, 80, 100, 80, 60, 110 ,40, 50, 70, 40, 80};
        int[] targetFloor = {2, 3, 5, 2, 4, 3, 3, 4, 5, 2, 5, 5};
        int totalFloor = 5;
        int personLimit = 3;
        int weightLimit = 200;
        int stopTimes = 0;
        try{
            stopTimes = getElevatorStopTimes(weight, targetFloor, totalFloor, personLimit, weightLimit);
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("stopTimes = " + stopTimes);
    }

    // you can also use imports, for example:


    // you can write to stdout for debugging purposes, e.g.
    // System.out.println("this is a debug message");
    public static int getElevatorStopTimes(int[] A, int[] B, int M, int X, int Y) throws Exception{
        // write your code in Java SE 8
        Set<Integer> targetFloorSet = new HashSet<Integer>();
        int stopTimes = 0;
        int totalWeight = 0;
        int totalPerson = 0;
        for (int n = 0; n < A.length; n++) {
            totalWeight += A[n];
            totalPerson ++;
            if (totalPerson > X) {
                totalWeight = 0;
                totalPerson = 0;

                System.out.println("targetFloorSet = " + targetFloorSet);
                stopTimes += targetFloorSet.size() + 1;
                targetFloorSet.clear();

                targetFloorSet.add(B[n]);
                totalWeight += A[n];
                totalPerson ++;
            } else if (totalWeight > Y) {
                totalWeight = 0;
                totalPerson = 0;

                System.out.println("targetFloorSet = " + targetFloorSet);
                stopTimes += targetFloorSet.size() + 1;
                targetFloorSet.clear();

                targetFloorSet.add(B[n]);
                totalWeight += A[n];
                totalPerson ++;
            } else {
                targetFloorSet.add(B[n]);
            }

        }
        System.out.println("targetFloorSet = " + targetFloorSet);
        stopTimes += targetFloorSet.size() + 1;
        return stopTimes;
    }

}
