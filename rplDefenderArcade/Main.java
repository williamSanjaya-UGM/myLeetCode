package rplDefenderArcade;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String file="./src/input.txt";
        List<String> strings = stringListSupply1(file);
        List<String> stringList = stringListSupply2(file);
        List<String> stringList2 = stringListSupply3(file);

        DefenderArcade defenderArcade=new DefenderArcade();
        int result = defenderArcade.countArcades(stringList2);
        System.out.println(result);
    }

    private static List<String> stringListSupply1(String filename) {
        File inputFile = new File(filename);
        List<String> strings=new ArrayList<>();
        try{
            Scanner scanner=new Scanner(inputFile);
            while (scanner.hasNextLine()) {
                strings.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return strings;
    }

    private static List<String> stringListSupply2(String inputFile) {
        List<String> stringList = new ArrayList<>();
        try(FileInputStream fileStream =new FileInputStream(inputFile)) {
            StringBuilder sb = new StringBuilder();
            int c=0;
            while ((c= fileStream.read())!=-1) {
                sb.append(Character.toString(c));
            }
            // split by string new line
            String[] split = sb.toString().split("\r\n");
            stringList.addAll(Arrays.asList(split));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }

    private static List<String> stringListSupply3(String inputFile) {
        List<String>stringList = null;
        try {
            stringList = Files.readAllLines(Path.of(inputFile), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }
}
