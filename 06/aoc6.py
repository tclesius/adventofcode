import numpy as np


def fun(days):
    with open('aoc6.txt') as f:
        lines = f.read().splitlines()
        fish = np.array([int(e) + 1 for line in lines for e in line.split(',')])
        initial_gen = np.array([(fish == gen).sum() for gen in range(10)], dtype=np.int64)
        curr_gen = initial_gen
        fishcount = np.sum(initial_gen)

        for day in range(days + 1):
            if curr_gen[0] > 0:
                curr_gen[9] += curr_gen[0]
                curr_gen[7] += curr_gen[0]
                curr_gen[0] = 0
            curr_gen = np.roll(curr_gen, -1)
            fishcount += curr_gen[8]

        return fishcount


print(fun(days=80))
print(fun(days=256))
