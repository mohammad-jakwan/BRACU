from dataclasses import dataclass


@dataclass
class Employee:
    name: str
    workingPeriod: int

    @classmethod
    def employeeByJoiningYear(cls, name, year):
        workingPeriod = 2022 - year
        return cls(name, workingPeriod)

    @staticmethod
    def experienceCheck(workingPeroid, gender):
        if workingPeroid < 3:
            if gender is "male":
                return f"He is not experienced"
            else:
                return f"She is not experienced"
        else:
            if gender is "male":
                return f"He is experienced"
            else:
                return f"She is experienced"


employee1 = Employee("Dororo", 3)
employee2 = Employee.employeeByJoiningYear("Harry", 2016)
print(employee1.workingPeriod)
print(employee2.workingPeriod)
print(employee1.name)
print(employee2.name)
print(Employee.experienceCheck(2, "male"))
print(Employee.experienceCheck(3, "female"))
