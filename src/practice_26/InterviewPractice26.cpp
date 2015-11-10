#include <iostream>

// reverse the string between start and end
void reverse_string(char* start_pointer, char* end_pointer)
{
	while (start_pointer < end_pointer) {
		char temp_char = *start_pointer;
		*start_pointer = *end_pointer;
		*end_pointer = temp_char;
		start_pointer++;
		end_pointer--;
	}
}

// solution 1
void left_rotate_string_1(char* string_pointer, int n)
{
	if (string_pointer == NULL) return;

	int length = strlen(string_pointer);
	if (n > length || n <= 0) return;

	char* first_start_pointer = string_pointer;
	char* first_end_pointer = string_pointer + n - 1;
	char* second_start_pointer = string_pointer + n;
	char* second_end_pointer = string_pointer + length - 1;
	reverse_string(first_start_pointer, first_end_pointer);
	reverse_string(second_start_pointer, second_end_pointer);
	reverse_string(first_start_pointer, second_end_pointer);
}

// solution 2
void left_rotate_string_2(char* string_pointer, int n)
{
	if (string_pointer == NULL) return;

	int length = strlen(string_pointer);
	if (n > length || n <= 0) return;

	char* pointer_1 = string_pointer;
	char* pointer_2 = string_pointer + n;
	char* pointer_end = string_pointer + length - 1;
	while (pointer_1 != pointer_2) {
		char temp_char = *pointer_1;
		*pointer_1 = *pointer_2;
		*pointer_2 = temp_char;
		if (pointer_1 != pointer_end) pointer_1++;
		if (pointer_2 != pointer_end) pointer_2++;
	}
}

#if false

// main
int main()
{
	char string_1[] = "abcdefghij";
	left_rotate_string_1(string_1, 3);
	printf("%s\n", string_1); // defghijabc

	char string_2[] = "abcdefghij";
	left_rotate_string_2(string_2, 3);
	printf("%s\n", string_2); // defghijabc
}

#endif
