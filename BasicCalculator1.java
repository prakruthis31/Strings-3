class Solution { // O(n) , O(n)
    public int calculate(String s) {
        s = s.trim();
        int n = s.length();
        char lastsign = '+';
        int num = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            }
            else if (ch == '(') {
                if (lastsign == '+') {
                    st.push(1);
                } else {
                    st.push(-1);
                }
                st.push(Integer.MAX_VALUE);
                num = 0;
                lastsign = '+';
            } else if (ch == ')') {
                if (lastsign == '+') {
                    st.push(num);
                } else {
                    st.push(-num);
                }
                
                int temp = 0;
                while (st.peek() != Integer.MAX_VALUE) {
                    temp = temp + st.pop();
                }
                
                st.pop(); // pop out the max_value '('
                temp = temp * st.pop(); // multiply calculated value with last sign on stack and push it onto stack
                st.push(temp);
                num = 0;
                lastsign = '+';
            }

            else if ((!Character.isDigit(ch) && ch != ' ')) {
                if (lastsign == '+') {
                    st.push(num);
                } else {
                    st.push(-num);
                }
                num = 0;
                lastsign = ch;
            }

        }
        int calc = 0;
        if (s.charAt(n - 1) != ')') {
            if (lastsign == '+') {
                st.push(num);
            } else {
                st.push(-num);
            }
        }
        while (!st.isEmpty()) {
            calc += st.pop();

        }

        return calc;

    }

}