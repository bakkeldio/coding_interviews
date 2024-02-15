class Solution {
    public String simplifyPath(String path) {
        

        String[] str = path.split("/");

        Stack<String> stack = new Stack<>();

        for (String s: str) {
            if (s.equals("..") && !stack.isEmpty()){
                stack.pop();
            } else if (!s.isEmpty() && !s.equals(".") && !s.equals("..")){
                stack.push(s);
            }
        }

        if (stack.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();

        for (String s: stack){
            sb.append("/" + s);
        }

        return sb.toString();

    }
}