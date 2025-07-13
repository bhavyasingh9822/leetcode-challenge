class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        for (String c : path.split("/")) {
            if (c.equals("") || c.equals(".")) {
   
                continue;
            } else if (c.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop(); 
                }
            } else {
                stack.push(c); 
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}