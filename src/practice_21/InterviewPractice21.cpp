#include <iostream>
#include <list>
using namespace std;

list<int> knapsack;

void found(int n)
{
	// reverse print
	for (list<int>::const_iterator item = knapsack.begin(); item != knapsack.end(); item++)
		printf("%d + ", *item);
	printf("%d\n", n);
}

void find_combination(int target, int n)
{
	if (n <= 0 || target <= 0) return;
	if (n == target) found(n);
	knapsack.push_back(n);
	find_combination(target - n, n - 1);
	knapsack.pop_back();
	find_combination(target, n - 1);
}

#if false

int main()
{
	find_combination(25, 20);
}

# endif
