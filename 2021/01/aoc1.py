
def fluctuations(l):
    count = 0
    for i in range(len(l) - 1):
        if int(l[i]) < int(l[i + 1]):
            count += 1
    print(count)


with open('aoc1.txt') as f:
    lines = f.read().splitlines()

    fluctuations(lines)

    x = [sum([int(lines[i]), int(lines[i + 1]), int(lines[i + 2])]) for i in range(len(lines) - 2)]

    fluctuations(x)
