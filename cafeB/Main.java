package cafeB;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final int N=3;

    public static void main(String[] args) {
        String fileName=args[0];
        String dateArgs=args[2];
        String orderArgs=args[1];

        List<String> orderLists = getOrderLists(fileName);

        TreeMap<String, String> mapTime = patternMatcher(orderLists, dateArgs, orderArgs);

        SortedMap<String, String> resultMap = limitBy3Ascending(mapTime);

        outputResult(resultMap);
    }

    // if there is an infinite list
    private static List<String> getOrderLists(String file) {
        List<String> orderList = new ArrayList<>();
        try(FileInputStream fis=new FileInputStream(file)) {
            StringBuilder stringRead = new StringBuilder();
            int c=0;
            while((c= fis.read())!=-1) {
                stringRead.append(Character.toString(c));
            }
            String[] split = stringRead.toString().split("\r\n");
            orderList.addAll(Arrays.asList(split));
        }catch (IOException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    private static TreeMap<String, String> patternMatcher(List<String> orderLists, String dateArgs, String orderArgs) {
        TreeMap<String,String> mapTime=new TreeMap<>();

        Pattern patternDate=Pattern.compile(PatternRegex.patternDate.getPatterns());
        Pattern patternOrder=Pattern.compile(PatternRegex.patternOrders.getPatterns());
        Pattern patternFulfilled=Pattern.compile(PatternRegex.patternFulfilled.getPatterns());
        Pattern patternTime=Pattern.compile(PatternRegex.patternTime.getPatterns());
        for(String orderList:orderLists){
            Matcher mDate = patternDate.matcher(orderList);
            Matcher mOrder=patternOrder.matcher(orderList);
            Matcher mFulfilled=patternFulfilled.matcher(orderList);
            Matcher mTime=patternTime.matcher(orderList);

            if(mDate.find() && mFulfilled.find() && mOrder.find() && mTime.find()){
                String date = mDate.group(1);
                String fulfilled = mFulfilled.group(1);
                String order= mOrder.group(1);
                String time= mTime.group(0);
                if(date.equals(dateArgs) && !fulfilled.isEmpty() && order.equalsIgnoreCase(orderArgs) ) {
                    mapTime.put(time,orderList);
                }
            }
        }
        return mapTime;
    }

    private static SortedMap<String, String> limitBy3Ascending(TreeMap<String,String> mapTime) {
        SortedMap<String,String> resultMap=new TreeMap<>();
        int i=0;
        for(Map.Entry<String,String> entry:mapTime.descendingMap().entrySet()) {
            if(i++<N)
                resultMap.put(entry.getKey(),entry.getValue());
        }
        return resultMap;
    }

    private static void outputResult(SortedMap<String,String> resultMap) {
        for(Map.Entry<String,String> entry: resultMap.entrySet())
            System.out.println(entry.getValue());
    }
}
