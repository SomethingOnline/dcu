#!/usr/bin/env python3

class Meeting(object):

    def __init__(self,hour, minute, duration):
        self.hour = hour
        self.minute = minute
        self.duration = duration
    def __str__(self):
        return f'{self.hour:02d}:{self.minute:02d} ({self.duration} minutes)'
    
class Schedule(object):

    def __init__(self):
        self.l = []
    def add(self, meeting):
        if meeting not in self.l:
            self.l.append(str(meeting))
    def __str__(self):
        lines = []
        lines.append("Schedule")
        lines.append("--------")
        for line in sorted(self.l):
            lines.append(line)
        lines.append(f'Meetings today: {len(self.l)}')
        return '\n'.join(lines)