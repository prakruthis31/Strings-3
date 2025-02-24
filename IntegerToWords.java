class Solution { // TC O(1)
    String[] under20 = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen" }; // Added empty string so that At index 3 we'll have Three
    String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety" };
    String[] suffxes = { "", "Thousand", "Million", "Billion" };

    public String numberToWords(int num) {

        if(num==0) return "Zero";
        String result = "";
         int i=0; //idx on thousands
        while(num>0){
            int triplet = num%1000;
            if(triplet != 0){
                    result = helper(triplet).trim() + " " +  suffxes[i] + " " + result;
            }
            i++;
            num = num/1000;
            
        }
        return result.trim();
    }

    private String helper(int num){
        StringBuilder sb = new StringBuilder();
        if(num < 20){
            sb.append(under20[num]);
        }else if( num < 100){
            sb.append(tens[num/10]).append(" ").append(helper(num%10));
        }else{
             sb.append(under20[num/100]).append(" Hundred ").append(helper(num%100));
             
        }

        return sb.toString();
    }
}