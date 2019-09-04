#include "parkBicycle.h"
#include <vector>
#include <iostream>

using namespace std;
int ParkBicycle::findPark(vector<int>& bycs){
	int N = bycs.size();
	int prev = -1, fu = 0;
	int ans = 0;
//
//
	//find first and last used
	if(N == 0) return 0;
	int first = bycs.at(0), last = bycs.at(0);
	for(int i = 0; i < N; i++){
		if(bycs.at(i) < first){
			first = bycs.at(i);
		}
		if(bycs.at(i) > last){
			last = bycs.at(i);
		}
	}
	cout << "first is: " << first << endl;
	cout << "last is " << last << endl;

	//first and last may be -1
	if(first == last)
		return 0;
	int len = last - first + 1;
	cout << "len is " << len << endl;

	int occupyArr[last - first + 1];
	memset(occupyArr, 0, sizeof(occupyArr));
	for(int i = 0; i < N; i++){
			occupyArr[bycs.at(i) - first] = 1;
			cout << "set element at pos" <<bycs.at(i) - first <<" in occupy arr to 1"  << endl;
	}
	for(int i = 0; i < len; i++){
		cout << "element at "<<i << " is "<<occupyArr[i] << endl;
		}


	for(int i = 0; i < last - first + 1; i++){
		if(occupyArr[i] == 1)
			prev = i;
		else{
			while((fu < len && occupyArr[fu] == 0 )|| fu < i)
				fu++;
			int left = prev == -1? len : i - prev;
			int right = fu == len? len : fu - i;
			ans = max(ans, min(left,right));
		}
	}
	return ans;
}


int main(){
	ParkBicycle* t = new ParkBicycle();
	 vector<int>obj;//创建一个向量存储容器 int
	 obj.push_back(10);
	 obj.push_back(10);
//	 obj.push_back(0);
//	 obj.push_back(8);
//	 obj.push_back(2);
//	 obj.push_back(-1);
//	 obj.push_back(12);
//	 obj.push_back(11);
//	 obj.push_back(3);
//	 t->findPark(obj);
	cout << t->findPark(obj) << endl;
}
