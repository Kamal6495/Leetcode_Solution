class NumberContainers {
public:
    unordered_map<int,int> num;
    unordered_map<int,set<int>> numindex;
    
    NumberContainers() {
        
    }
    
    void change(int index, int number) {

      if(num.find(index)!=num.end())
      {
        int x=num[index];

        numindex[x].erase(index);
        if(numindex[x].empty())
        numindex.erase(x);

      }

        num[index]=number;
        numindex[number].insert(index);

    }
    
  int find(int number) {
        if (numindex.find(number) != numindex.end() && !numindex[number].empty()) {

            return *numindex[number].begin();
        }
        return -1;
    }
};

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers* obj = new NumberContainers();
 * obj->change(index,number);
 * int param_2 = obj->find(number);
 */