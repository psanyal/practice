def print_shape(steps):
    for i in range(0, steps+1):
        for j in range(0, i):
            print("#", end='')
        print('\n')

#print_shape(10)

def print_pyramid(steps):
    mid = int((steps + 1) / 2)
    for i in range(0, steps+1):
        for c in range(0, 2 * steps):
            if (mid - i <= c) and (mid + i >= c):
                print("#", end='')
            else:
                print(" ", end='')
        print('\n')

print_pyramid(5)