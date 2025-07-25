class Solution {
    public boolean isNumber(String s) {
        boolean isDigit = false;
        boolean hasDecimal = false;
        boolean hasExp = false;
        boolean digitAfterExp = true;

        for(int i = 0; i < s.length(); i++){
            char a = s.charAt(i);

            if(Character.isDigit(a)){
                isDigit = true;
                if(hasExp) digitAfterExp = true;
            }

            else if(a == '+' || a == '-'){
                if(i != 0 && s.charAt(i -1) != 'e' && s.charAt(i - 1) != 'E'){
                       return false;
                }
            }

            else if(a == '.'){
                if(hasDecimal || hasExp){
                    return false;
                }
                hasDecimal = true;
            }

            else if(a == 'e' || a == 'E'){
                if(hasExp || !isDigit){
                    return false;
                }
                hasExp = true;
                digitAfterExp = false;
            }
            else {
                return false;
            }
        }
        return isDigit && digitAfterExp;
    }
}