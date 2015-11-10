#include <iostream>
using namespace std;

// function to reverse a word, in place
void reverse_word(string* word, int begin, int end)
{
	while (begin < end) {
		char letter = word->at(begin);
		word->at(begin) = word->at(end);
		word->at(end) = letter;
		begin++;
		end--;
	}
}

// function to reverse a sentence, in place
void reverse_sentence(string* sentence)
{
	int length = sentence->size();
	int pointer = 0;
	// for each character
	for (int i = 0; i < sentence->size(); i++) {
		// find word head
		if (pointer == -1) {
			if (sentence->at(i) != ' ') pointer = i;
			continue;
		}
		// find word tail
		if (sentence->at(i) == ' ') {
			reverse_word(sentence, pointer, i - 1);
			pointer = -1;
		}
		// end of string
		if (i == length - 1) {
			reverse_word(sentence, pointer, i - 1);
		}
	}
	// reverse letters for the whole sentence
	reverse_word(sentence, 0, sentence->size() - 1);
}

#if false

// main part
int main()
{
	string text = "I am a student.";
	reverse_sentence(&text);
	cout << text << endl;
}

#endif
