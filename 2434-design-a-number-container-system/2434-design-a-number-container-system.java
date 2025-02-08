class NumberContainers {
   private Map<Integer, Integer> num; 
    private Map<Integer, TreeSet<Integer>> numindex;


    public NumberContainers() {
          num = new HashMap<>();
        numindex = new TreeMap<>();
    }
    
    public void change(int index, int number) {
            if (num.containsKey(index)) {
        int oldNumber = num.get(index);
        numindex.get(oldNumber).remove(index);
        if (numindex.get(oldNumber).isEmpty()) {
            numindex.remove(oldNumber); // Remove the entry if the set is empty
        }
    }
    
    // Update the index with the new number
    num.put(index, number);

    // Manually check and insert into numindex instead of using computeIfAbsent
    if (!numindex.containsKey(number)) {
        numindex.put(number, new TreeSet<>());
    }
    numindex.get(number).add(index);

    }
    public int find(int number) {
        if (numindex.containsKey(number) && !numindex.get(number).isEmpty()) {
            return numindex.get(number).first(); // Retrieve smallest index
        }
        return -1;
    }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */