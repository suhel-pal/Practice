#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the climbingLeaderboard function below.
def climbingLeaderboard(scores, alice):
    pos = 1
    current_score = scores[0]
    positions=[]
    for i in range(len(scores)):
        if current_score  == scores[i]:
            positions.append(pos)
        else:
            pos += 1
            current_score = scores[i]
            positions.append(pos)
    #print(positions)
    for i in range(len(alice)):
        alice_pos = findPosition(scores,positions,alice[i])
        alice[i] = alice_pos
    
    return alice

def findPosition(scores,positions,alice_score):
    '''pos = positions[len(positions)-1] + 1
    for i in range(len(scores)):
        if alice_score >= scores[i]:
            pos = positions[i]
            break
    return pos'''
    low = 0
    high = len(scores) - 1
    index = (high-low)//2
    while True:
        if high == low:
            if scores[low] > alice_score:
                return positions[low]+1
            else:
                return positions[low]
        
        if scores[index] == alice_score:
            return positions[index]

        if scores[index] < alice_score:
            if index > low :
                high = index - 1
                index = (high-low)//2
            elif index == low:
                return  positions[low]
        elif scores[index] > alice_score:
            if index < high :
                low = index + 1
                index = low + ((high-low)//2)
            elif index == high :
                return positions[high]+1


       

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    scores_count = int(input())

    scores = list(map(int, input().rstrip().split()))

    alice_count = int(input())

    alice = list(map(int, input().rstrip().split()))

    result = climbingLeaderboard(scores, alice)

    fptr.write('\n'.join(map(str, result)))
    fptr.write('\n')

    fptr.close()
