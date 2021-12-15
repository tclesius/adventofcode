import numpy as np

with open('aoc7.txt') as f:
    lines = f.read().splitlines()
    positions = np.array([int(e) for line in lines for e in line.split(',')])

    print(np.min(np.array([np.sum(np.absolute(positions - i)) for i in range(np.max(positions))])))

    gauss = lambda n: int(((n ** 2) + n) / 2)

    print(np.min(np.array(
        [np.sum(np.array(list(map(gauss, np.absolute(positions - i).tolist())))) for i in range(np.max(positions))])))
