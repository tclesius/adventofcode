def row(input, index):
    return [line[index] for line in input]


def gamma_rate(input):
    return int(
        str.encode(''.join(
            ['1' if row(input, i).count('1') > row(input, i).count('0') else '0' for i in range(len(input[0]))])), 2)


def epsilon_rate(input):
    return int(
        str.encode(''.join(
            ['1' if row(input, i).count('0') > row(input, i).count('1') else '0' for i in range(len(input[0]))])), 2)


def oxygen_generator_rating(input, counter=0):
    if len(input) == 1:
        return int(str.encode(input[0]), 2)
    else:
        if row(input, counter).count('1') >= row(input, counter).count('0'):
            return oxygen_generator_rating([e for e in input if e[counter] == '1'], counter + 1)
        else:
            return oxygen_generator_rating([e for e in input if e[counter] == '0'], counter + 1)


def co2_scrubber_rating(input, counter=0):
    if len(input) == 1:
        return int(str.encode(input[0]), 2)
    else:
        if row(input, counter).count('1') >= row(input, counter).count('0'):
            return co2_scrubber_rating([e for e in input if e[counter] == '0'], counter + 1)
        else:
            return co2_scrubber_rating([e for e in input if e[counter] == '1'], counter + 1)


with open('aoc3.txt') as f:
    lines = f.read().splitlines()

    power_consumption = gamma_rate(lines) * epsilon_rate(lines)
    print(power_consumption)

    life_support_rating = oxygen_generator_rating(lines) * co2_scrubber_rating(lines)
    print(life_support_rating)
