opening= ("(", "[", "{")
closing = (")", "]", "}")
mapping = dict(zip(opening, closing))
def is_balanced(s):
    parens_stack = []
    for i in range(len(s)):
        if s[i] in opening:
            parens_stack.append(s[i])
        elif s[i] in closing:
            if len(parens_stack) == 0:
                return False
            if mapping[parens_stack[-1]] == s[i]:
                parens_stack.pop()
            else:
                return False
        else:
            return False
    return len(parens_stack) == 0


assert(is_balanced("([])") == True)
assert(is_balanced("[)}") == False)
assert(is_balanced("(((([[[[{{{}}}]]]]))))") == True)
