/*
TC - O(n)
SC - O(1)  fixed 4 variables
*/
class Solution {
    public int calculate(String s) {

        s = s.trim();
        int num = 0;
        char lastSign = '+';
        int tail = 0; // maintain tail for * and /
        int calc = 0; // calculated value
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
             if((!Character.isDigit(c) && c != ' ') || i == s.length()-1){
                if (lastSign == '+') {
                    calc = calc + num;
                    tail = num;
                } else if (lastSign == '-') {
                    calc = calc - num;
                    tail = -num;
                } else if (lastSign == '*') {
                    calc = calc - tail + tail * num;
                    tail = tail * num;
                } else {
                    calc = calc - tail + tail / num;
                    tail = tail / num;
                }

                num = 0;
                lastSign = c;
            }

        }
        return calc;
    }
}