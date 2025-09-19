class Spreadsheet {
    Map<String, Integer> cells= new HashMap<>();
    public Spreadsheet(int rows) {
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell,value);
    }
    
    public void resetCell(String cell) {
        cells.put(cell,0);
    }
    
    public int getValue(String formula) {
     int idx = formula.indexOf('+');
        String left = formula.substring(1, idx);
        String right = formula.substring(idx + 1);

        int one = Character.isDigit(left.charAt(0)) ? Integer.parseInt(left) : cells.getOrDefault(left, 0);
        int two = Character.isDigit(right.charAt(0)) ? Integer.parseInt(right) : cells.getOrDefault(right, 0);

        return one + two;
    }
}