# knapsack that store the found combination
knapsack = []


# what to do with found combination in knapsack
def found(n):
    for number in knapsack: print "%d +" % number,
    print n


# find combination
def find_combination(target, n):
    if n <= 0 or target <= 0: return
    if n == target: found(n)

    # find combinations with n
    knapsack.append(n)
    find_combination(target - n, n - 1)

    # find combinations without n
    knapsack.pop()
    find_combination(target, n - 1)

# find combination of 25 with 1..20
find_combination(25, 20)