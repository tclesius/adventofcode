import numpy as np

with open('aoc9-sm.txt') as f:
    lines = f.read().splitlines()
    m = np.array([list(map(int, list(n))) for n in lines])
    lowpoint_horizontal = np.full(m.shape, False)
    lowpoint_vertical = np.full(m.shape, False)

    # for y, row in enumerate(lowpoint):
    #    for x, e in enumerate(row):
    #        if

    for i, row in enumerate(m):
        for ri, r in enumerate(row):
            indice = [-1, 0, 1]
            if row[ri - 1:ri + 2].size > 0:
                sl = row[ri - 1:ri + 2]
                print(i, sum([ri],indice[np.argwhere(sl == np.min(sl))[0][0]]))
                lowpoint_horizontal[i, sum([ri], indice[np.argwhere(sl == np.min(sl))[0][0]])] = True
    print(lowpoint_horizontal)
    print(m)

    #

    # for i, row in enumerate(m.T):
    # lowpoint_vertical[np.argwhere(row == np.min(row))[0][0], i] = True
    # print(np.logical_and(lowpoint_horizontal, lowpoint_vertical))
    # print(lowpoint_vertical)
    # print(lowpoint_horizontal)
    # print(np.apply_over_axes((m == np.min(m))[0][0], m, [0]))
