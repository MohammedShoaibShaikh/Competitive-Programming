#include <iostream>
#include <bits/stdc++.h>
#include <numeric>
#define ll long long
#define LL_MIN -1e18
using namespace std;

void solve() {
    // 1 <= N <= 100  ,[N <= 10^5]
    // 1 <= K <= (N * (N + 1)) / 2   ,[K <= 10^5]
    // -1000 <= ARR[i] <= 1000   , [-10^9 <= Arri <= 10^9]
    
    int n, k;
    cout << "Enter Size of Array N & Window K: ";
    cin >> n >> k;

    vector<int> arr(n);
    cout << "Enter Elements of Array: ";
    for(int i = 0; i < n; i++) cin >> arr[i];

    if(k <= 0 || k > n) {
        cout << "Invalid Input!" << "\n";
        return;
    }

    ll curr_total = 0;
    ll maxi = LL_MIN;
    for(int i = 0; i < n; i++) {
        if(i < k) curr_total += arr[i];
        if(i == k-1)  maxi = max(maxi, curr_total);
        else if(i >= k) {
            curr_total += arr[i];
            curr_total -= arr[i-k];
            maxi = max(maxi, curr_total);
        }
    }
    cout << "Max Sum is " << maxi << endl;
}

int main() {
    int t; // 1 <= T <= 50
    cout << "Enter Value of T: ";
    cin >> t;
    while(t--) {
        solve();
    }
    return 0;
}