class StockSpanner {
    
    Stack<Integer> s;

    HashMap<Integer, Integer> map;

    public StockSpanner() {
        s = new Stack<>();
        map = new HashMap<>();
    }
    
    public int next(int price) {
        int count = 1;
        while(!s.isEmpty() && price >= s.peek()){
            count += map.get(s.pop());
        }
        s.push(price);
        map.put(price, count);

        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */