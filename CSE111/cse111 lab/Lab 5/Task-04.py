# TODO: Design the program to get the output as shown.
# @ Subtasks:
# 1. You will need to create 2 classes: Team and Player
# 2. Make all the variables in the Team class private.
# 3. Make all the variables in the Player class public.
# 4. Write the required codes in the Team and Player classes
# ? Hints:
# * ● Create a list in team class to store the player’s name in that list
# * ● Use constructor overloading technique for Team class

#![You are not allowed to change the code below]


class Team:
    def __init__(self, *b):
        if len(b) == 0:
            self.__team = None
        else:
            self.__team = b[0]
        self.__player = []

    def setName(self, x):
        self.__team = x

    def addPlayer(self, y):
        self.__player.append(y.z)

    def printDetail(self):
        line = "=====================\n"
        line += f"Team: {self.__team}\nList of players:"
        print(line)
        print(self.__player)
        print("=====================")


class Player:
    def __init__(self, z):
        self.z = z


b = Team()
b.setName("Bangladesh")
mashrafi = Player("Mashrafi")
b.addPlayer(mashrafi)
tamim = Player("Tamim")
b.addPlayer(tamim)
b.printDetail()
a = Team("Australia")
ponting = Player("Ponting")
a.addPlayer(ponting)
lee = Player("Lee")
a.addPlayer(lee)
a.printDetail()
