class Solution {
public:
    static bool compare(const vector<int> &a,const vector<int> &b){
        return a[0]<b[0];
    }
    vector<vector<int>> merge(vector<vector<int>>& ivl) {
        sort(ivl.begin(),ivl.end(),compare);
        
        vector<vector<int>> res;
        res.push_back(ivl[0]);
        for(int i=1;i<ivl.size();i++){
            if(res.back()[1]<ivl[i][0])
                res.push_back(ivl[i]);
            else
                res.back()[1]=max(res.back()[1],ivl[i][1]);
        }
        
        return res;
    }
};