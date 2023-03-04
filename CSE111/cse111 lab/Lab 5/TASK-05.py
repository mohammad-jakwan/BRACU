# TODO: Design the Student and the Usis class so that the following output is produced.
#! Note:
# * 1. A student's email, password, and login status are None by default while creating an object of the Student class.
# *2. Your code should satisfy the conditions mentioned in the output only.


class Student:
    def __init__(self, name, id, dept):
        self.name = name
        self.id = id
        self.dept = dept
        self.email = None
        self.password = None
        self.login = None
        print("Student object is created!")


class Usis:
    def __init__(self):
        self.course = []
        print("USIS is ready to use!")

    def login(self, student):
        if student.email is None and student.password is None:
            print("Email and password needs to be set.")
        elif student.email != None and student.password != None:
            print("Login successful!")
            student.login = True

    def advising(self, student, *args):
        if student.login == None:
            print("Please login to advise courses!")
        elif student.login == True and len(args) == 0:
            print("You haven't selected any courses.")
        elif student.login == True and len(args) > 3:
            print("You need special approval to take more than 3 courses.")
        elif student.login == True and len(args) <= 3:
            for i in args:
                self.course.append(i)
            print("Advising successful!")

    def individualDetails(self, student):
        course = ""
        first = True
        for i in self.course:
            if first == True:
                course += i
                first = False
            else:
                course += "," + i

        return f"Name:{student.name}\nID: {student.id}\nDepartment:{student.dept}\nAdvised courses: {course}"


rakib = Student("Rakib", 12301455, "CSE")
print("1***********************")
usis_obj = Usis()
print("2***********************")
usis_obj.login(rakib)
print("3***********************")
usis_obj.advising(rakib)
print("4***********************")
rakib.email = "rakib@hotmail.com"
rakib.password = "1234"
print("5***********************")
usis_obj.login(rakib)
print("6***********************")
usis_obj.advising(rakib)
print("7***********************")
usis_obj.advising(rakib, "CSE110", "PHY111", "MAT110", "CSE260")
print("8***********************")
usis_obj.advising(rakib, "CSE110", "PHY111", "MAT110")
print("9***********************")
print(usis_obj.individualDetails(rakib))
