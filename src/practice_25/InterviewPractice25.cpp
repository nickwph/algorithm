#include <iostream>

int continumax(char *output_string, char *input_string)
{
	int max_length = 0;
	char *max_string = new char[sizeof(input_string)];

	while (true) {

		// skip all non-digit characters
		while (*input_string != 0 && (*input_string < '0' || *input_string > '9')) input_string++;
		if (*input_string == 0) break;

		// current char is digit
		int length = 0;
		char *temp_string = input_string;
		while (*input_string!=0 && *input_string >= '0' && *input_string <= '9') {
			length++;
			input_string++;
		}

		// check if this is longer
		if (length > max_length) {
			max_length = length;
			max_string = temp_string;
		}
	}

	// write maximum string to output and add null to end.
	int i;
	for (i = 0; i < max_length; i++) output_string[i] = max_string[i];
	output_string[i] = 0;

	return max_length;
}

#if false

int main()
{
	char input[] = "abcd12345ed125ss123456789";
	char *output = new char[sizeof(input)];
	int length = continumax(output, input);
	printf("Length: %d\n", length);
	printf("Output: %s\n", output);
}

#endif
