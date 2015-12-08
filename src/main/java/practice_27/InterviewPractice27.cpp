#include <iostream>

int CountOne(int i)
{
	int count = 0;
	int comparand = 1; // to be compared
	while (comparand) {
		if (i & comparand) count++;
		comparand = comparand << 1; // shift it
	}
	return count;
}

int main()
{
	printf("%d\n", CountOne(10)); // 1010 -> 2
	printf("%d\n", CountOne(-10)); // 11111111 11111111 11111111 11110101 -> 30
}
