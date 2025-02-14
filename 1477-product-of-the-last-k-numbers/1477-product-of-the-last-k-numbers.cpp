class ProductOfNumbers {
public:
    vector<int> p;
    ProductOfNumbers() { p.push_back(1); }

    void add(int num) {
        if (num == 0) {
            p.clear();
            p.push_back(1); 
        } else {
            int ppro = p[p.size() - 1];
            p.push_back(ppro * num);
        }
    }

    int getProduct(int k) {

        int x = p.size();

        if (k >= x) {
            return 0;
        } else
            return p[x - 1] / p[x - k - 1];
    }
};

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers* obj = new ProductOfNumbers();
 * obj->add(num);
 * int param_2 = obj->getProduct(k);
 */