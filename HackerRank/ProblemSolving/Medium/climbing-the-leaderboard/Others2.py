n = int(input().strip())
scores = list(reversed(sorted(list(set([int(scores_temp) for scores_temp in input().strip().split(' ')])))))
m = int(input().strip())
alice = [int(alice_temp) for alice_temp in input().strip().split(' ')]

for x in alice:
    while len(scores) > 0 and scores[-1] <= x:
        del scores[-1]
    
    print(len(scores) + 1)
