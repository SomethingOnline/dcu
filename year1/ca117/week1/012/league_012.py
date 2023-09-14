#!/usr/bin/env python3

import sys
leagues = sys.stdin.readlines()
a = []
teams = []
num = []
for league in leagues:
    league = league.strip().split()
    i = 1
    while i < len(league) and not league[i].isnumeric():
        i += 1
    team = " ".join(league[1:i])
    nums = " ".join(league[i:])
    nums = nums.split()
    num.append(nums)
    teams.append(team)
    a.append(len(team))

maxClubLen = max(a)
print(f'{"POS":>3s}', f'{"CLUB":{maxClubLen}s}', f'{"P":>2s}', f'{"W":>3s}', f'{"D":>3s}', f'{"L":>3s}', f'{"GF":>3s}', f'{"GA":>3s}', f'{"GD":>3s}', f'{"PTS":>3s}')
for league, club, nums in zip(leagues, teams, num):
    league = league.strip().split()
    print(f'{league[0]:>3s}', f'{club:<{maxClubLen}s}', f'{nums[0]:<3s}', f'{nums[1]:>2s}', f'{nums[2]:>3s}', f'{nums[3]:>3s}', f'{nums[4]:>3s}', f'{nums[5]:>3s}', f'{nums[6]:>3s}', f'{nums[7]:>3s}')
