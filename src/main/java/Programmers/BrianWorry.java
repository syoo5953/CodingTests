package Programmers;

import java.util.*;
import java.util.regex.*;

public class BrianWorry {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        String sentence = "HaEaLaLaObWORLDb";
        solution39.solution(sentence);
    }
}

class Solution39 {
    public String solution(String sentence) {
        Set<String> charSet = new HashSet<String>();
        String regex = "([a-z])[A-Z]((?:(?!\\1)([a-z]?))[A-Z])?(\\3[A-Z])*\\1"; // TYPE B

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(sentence);
        System.out.println(m.find());

        while(m.find()) {
            if (charCnt(sentence, m.group(1).charAt(0)) != 2) {
                continue;
            }

            if(charSet.contains(m.group(1))) {
                return "invalid";
            }

            charSet.add(m.group(1));

            sentence = sentence.replaceFirst(m.group(), "." + m.group().replaceAll(m.group(1), "")+ ".");
        }

        regex = "[A-Z](([a-z])[A-Z])(\\2[A-Z])*"; // TYPE A
        p = Pattern.compile(regex);
        m = p.matcher(sentence);

        while(m.find()) {

            if(charSet.contains(m.group(2))) {
                return "invalid";
            }else

                charSet.add(m.group(2));

            sentence = sentence.replaceFirst(m.group(), "." + m.group().replaceAll(m.group(2), "")+ ".");
        }


        if(sentence.matches(".*[a-z].*")) {
            return "invalid";
        }

        return sentence.replaceAll("\\.+", " ").trim();

    }

    public static long charCnt(String s, char c) {
        return s.chars().filter(ch -> ch == c).count();
    }
}
