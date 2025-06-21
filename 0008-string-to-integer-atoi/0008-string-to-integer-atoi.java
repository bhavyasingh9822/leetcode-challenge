class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;

        String temp = "";           // To build the number string
        char sign = '+';           // Default sign is positive
        int count = 0;             // To track if sign already occurred

        String trim = s.trim();    // Remove leading/trailing whitespace

        for (int i = 0; i < trim.length(); i++) {
            char ch = trim.charAt(i);

            // Stop parsing on encountering invalid symbols
            if ((ch != '+' && ch != '-') &&
                ((ch >= 33 && ch <= 47) || (ch >= 58 && ch <= 64) ||
                 (ch >= 91 && ch <= 96) || (ch >= 123 && ch <= 126))) {
                break;
            }

            // Stop if sign occurs after digits or has already been seen
            if ((temp.length() != 0 || count != 0) && (ch == '-' || ch == '+')) {
                break;
            }

            // Skip duplicate sign characters
            if (count != 0 && (ch == '-' || ch == '+')) {
                continue;
            }

            // Sign handling
            if (count == 0) {
                if (ch == '-') {
                    sign = '-';
                    count++;
                    continue;
                }
                if (ch == '+') {
                    sign = '+';
                    count++;
                    continue;
                }
            }

            // Stop on encountering letters
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                break;
            }

            // Append valid digit characters
            if (Character.isDigit(ch)) {
                temp += ch;
            } else {
                break;
            }
        }

        // Prepend sign to the number string
        temp = sign + temp;

        // Edge cases like "+" or "-" only
        if (trim.length() == 0 || temp.equals("+") || temp.equals("-")) {
            return 0;
        }

        int ans = 0;

        try {
            ans = Integer.parseInt(temp); // Try to convert to int
        } catch (Exception e) {
            // Handle overflow and underflow
            return sign == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return ans;
    }
}