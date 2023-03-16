class Train:
    def __init__(self, name, *args):
        self.name = name
        self.dic2 = {args[0]: 1, args[1]: 2, args[2]: 3, args[3]: 4}
        self.first = args[0]
        self.second = args[1]
        self.third = args[2]
        self.last = args[3]
        self.start = args[0]
        self.ending = args[3]
        self.dic1 = {}
        print(
            f"""Welcome aboard on {self.name}
Start: New York
Destination: Boston
"""
        )

    def addPassenger(self, *args):
        fare = 0

        for passenger in args:
            print(f"{passenger.name} welcome abroad")
            if passenger.start == None:
                passenger.start = self.start
            if passenger.ending == None:
                passenger.ending = self.ending
            if self.dic2[passenger.ending] - self.dic2[passenger.start] == 1:
                fare = 100
            elif self.dic2[passenger.ending] - self.dic2[passenger.start] == 2:
                fare = 200
            elif self.dic2[passenger.ending] - self.dic2[passenger.start] == 3:
                fare = 300

            self.dic1[passenger] = [
                passenger.name,
                passenger.start,
                passenger.ending,
                fare,
            ]

    def allPassengerDetails(self):
        for keys, value in self.dic1.items():
            print(
                f"Name: {value[0]} ,start: {value[1]} ,Destination: {value[2]} ,Fair: ${value[3]}"
            )


class Passenger:
    def __init__(self, name, start=None, ending=None):
        self.name = name
        self.start = start
        self.ending = ending


t1 = Train("T1-Express", "New York", "Manhattan", "Brooklyn", "Boston")
print("1========================")
p1 = Passenger("Naruto")
t1.addPassenger(p1)
p2 = Passenger("Sasuke", "Manhattan")
p3 = Passenger("Hinata", "Manhattan", "Brooklyn")
print("2========================")
t1.addPassenger(p2, p3)
print("3========================")
t1.allPassengerDetails()
print("4========================")
t2 = Train("Europe-Express", "London", "Paris", "Brussels", "Turkey")
print("5========================")
p4 = Passenger("Max", "London", "Brussels")
p5 = Passenger("Eleven", "Paris")
p6 = Passenger("Mike", "Brussels")
t2.addPassenger(p4, p5, p6)
print("6========================")
t2.allPassengerDetails()
