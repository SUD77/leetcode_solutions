class Solution {
    public String addBinary(String a, String b) {
         int i = a.length() - 1;
        int j = b.length() - 1;
        
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int sum = 0;
        while(i >= 0 && j >= 0) {
            sum = a.charAt(i--) - '0' + b.charAt(j--) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        while(i >= 0) {
            sum = a.charAt(i--) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        while(j >= 0) {
            sum = b.charAt(j--) - '0' + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }
        
        if(carry != 0) sb.append(carry);
        
        return sb.reverse().toString();
        
    }
}