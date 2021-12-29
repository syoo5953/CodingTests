package BackJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackJoonPlusCycle {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String num = br.readLine();
            String firstNum = num;
            if(Integer.parseInt(num) < 0 || Integer.parseInt(num) > 99) {
                System.exit(0);
            }
            if(Integer.parseInt(num) < 10) {
                num = "0" + num;
            }
            int count = 0;
            if(Integer.parseInt(firstNum) < 10) {
                firstNum = "0" + firstNum;
            }

            while(true) {
                count++;
                char[] chars = firstNum.toCharArray();
                String addNumbers = (chars[0]-'0') + (chars[1]-'0') + "";
                if(Integer.parseInt(addNumbers) < 10) {
                    addNumbers = "0" + addNumbers;
                }
                String newNumber = chars[1] + "" + addNumbers.toCharArray()[1];
                if(newNumber.equals(num)) {
                    break;
                }
                firstNum = newNumber;
            }
            System.out.println(count);
        }
}
