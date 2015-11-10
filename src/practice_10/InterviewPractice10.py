# function to reverse a sentence
def reverse_sentence(sentence):
    return ' '.join(reversed(sentence.split()))

# main
print reverse_sentence("I am a student.")
print reverse_sentence("Testing 1 2 3")