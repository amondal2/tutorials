def length_of_last_word(s):
    words = s.split(' ')
    for word in words[::-1]:
        if word != '':
            return len(word)
    return 0

assert(length_of_last_word('a ') == 1)
assert(length_of_last_word('hello world') == 5)
assert(length_of_last_word('agastya') == 7)
