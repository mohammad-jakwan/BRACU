class BracuStudent:
    def __init__(self, name, location):
        self.student_name = name
        self.home = location
        self.bus_pass = False

    def show_details(self):
        print(f"Student Name: {self.student_name}\nLives in {self.home}")
        print(f"Have Bus Pass? {self.bus_pass}")

    def get_pass(self):
        if self.bus_pass == False:
            self.bus_pass = True


class BracuBus:
    def __init__(self, route, max=2):
        self.bus_route = route
        self.maximum_passenger = max
        self.student_list = []
        self.count = 0

    def show_details(self):
        print(
            f"Bus Route: {self.bus_route}\nPassengers Count: {self.count} (Max: {self.maximum_passenger})"
        )
        print(f"Passengers on Board: {self.student_list}")

    def board(self, *student):
        if student == ():
            print("No passenger!")
        else:
            for i in student:
                if i.bus_pass == False:
                    print("You don't have bus pass!")
                else:
                    if i.home != self.bus_route:
                        print("You got on wrong bus!")
                    else:
                        if self.count < self.maximum_passenger:
                            print(f"{i.student_name} boarded the bus.")
                            self.student_list.append(i.student_name)
                            self.count += 1
                        else:
                            print("Bus is full!")


st1 = BracuStudent("Afif", "Mirpur")
print("1===========================")
st2 = BracuStudent("Shanto", "Motijheel")
st3 = BracuStudent("Taskin", "Mirpur")
st1.show_details()
st2.show_details()
print("2===========================")
st3.show_details()
print("3===========================")
bus1 = BracuBus("Mirpur")
bus2 = BracuBus("Azimpur", 5)
bus1.show_details()
bus2.show_details()
print("4===========================")
st2.get_pass()
st3.get_pass()
print("5===========================")
st2.show_details()
st3.show_details()
print("6===========================")
bus1.board()
print("7===========================")
bus1.board(st1, st2)
print("8===========================")
st1.get_pass()
st2.home = "Mirpur"
st1.show_details()
st2.show_details()
print("9===========================")
bus1.board(st1, st2, st3)
print("10===========================")
bus1.show_details()
