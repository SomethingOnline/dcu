# #!/usr/bin/env python3

# class Student(object):

#     def __init__(self, name, sid, mark):
#         self.name = name
#         self.sid = sid
#         self.modlist = []
#         self.marklist = []
#         for line in mark:
#             self.modlist.append(line[0])
#             self.marklist.append(line[1])
#         self.modlist = ", ".join(sorted(self.modlist))
#         t = 0
#         for d in self.marklist:
#             d = int(d)
#             t += d
#         self.mark = t / len(self.marklist)
#     def __str__(self):
#         lines = []
#         lines.append(f"Name: {self.name}")
#         lines.append(f"ID: {self.sid}")
#         lines.append(f'Modules: {self.modlist}')
#         lines.append(f"Average mark: {int(round(self.mark, 0))}")
#         return '\n'.join(lines)

#!/usr/bin/env python3

class Student(object):

    def __init__(self, name, sid, modlist=None):
        self.name = name
        self.sid = sid
        if modlist == None:
            self.modlist = []
        else:
            self.modlist = modlist
    
    def average_mark(self):
        nums = []
        for i in self.modlist:
            nums.append(int(i[1]))
        t = 0
        for d in nums:
            t += d
        return round(t / len(self.modlist))
    def get_modules(self):
        modules = []
        for i in self.modlist:
            modules.append(i[0])
        return sorted(modules)
    def __str__(self):
        output = []
        output.append(f'Name: {self.name}')
        output.append(f'ID: {self.sid}')
        output.append(f'Modules: {", ".join(self.get_modules())}')
        output.append(f'Average mark: {self.average_mark()}')
        return '\n'.join(output)