package longestKeyPress;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> firstList= Arrays.asList(0,1);
        List<Integer> secondList= Arrays.asList(1,3);
        List<Integer> thirdList= Arrays.asList(2,5);
        List<Integer> fourthList= Arrays.asList(5,7);
        List<Integer> fifthList= Arrays.asList(4,10);

        List<List<Integer>> keyTimes = Arrays.asList(firstList,secondList,thirdList,fourthList,fifthList);
        char result = solution(keyTimes);
        System.out.println(result);

    }

    public static char solution(List<List<Integer>> keyTimes){
        System.out.println(keyTimes);
        int temp=0;
        int longestPress = 0;
        for(int i=0;i< keyTimes.size()-1;i++){
            if(keyTimes.get(i+1).get(1)-keyTimes.get(i).get(1)>temp) {
                temp=keyTimes.get(i+1).get(1)-keyTimes.get(i).get(1);
                longestPress=keyTimes.get(i+1).get(0);
            }
        }
        return (char) (longestPress+'a');
    }
}
