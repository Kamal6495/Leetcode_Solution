class ProductOfNumbers {
    List<Integer> p;

    public ProductOfNumbers() {
        p = new ArrayList<>();
        p.add(1);
    }

    public void add(int num) {

        if (num == 0) {
            p.clear();
            p.add(1);
        } else {
            int pproduct = p.get(p.size() - 1);
            p.add(num * pproduct);

        }
       // System.out.println(p.toString());
    }

    public int getProduct(int k) {
        int x = p.size();

        if (k >= x)
            return 0;
        return p.get(x - 1) / p.get(x - k - 1);

    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */