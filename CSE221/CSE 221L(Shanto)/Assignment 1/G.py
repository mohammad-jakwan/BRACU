# input number of trains.
num_trains = int(input())

# * Taking each train's schedules input.
train_schedules = [input().strip() for _ in range(num_trains)]

#! Splitting info of train schedules into changeable format.
# -------------------------------------------------------------------------------------
_schedules = []
for schedule in train_schedules:
    parts = schedule.split(" will departure for ")
    train_name = parts[0]
    destination_time = parts[1].split(" at ")
    destination = destination_time[0]
    departure_time = destination_time[1]
    _schedules.append((train_name, destination, departure_time, schedule))

# -------------------------------------------------------------------------------------

# TODO: Now we have, the schedules as a list of tuples.
# * - then by departure time (latest first), (1)
# * - Sort the schedules first by train name, (2)
# * - finally by input order (result)

sorted_schedules = _schedules[:]

# _________________________________________________________________________________________


# Sort by departure time (latest first)
for i in range(len(sorted_schedules)):
    for j in range(len(sorted_schedules) - 1):
        time1 = int(sorted_schedules[j][2].replace(":", ""))
        time2 = int(sorted_schedules[j + 1][2].replace(":", ""))
        if time1 < time2:  # ! if time1 is less than time2 then swap the schedules.
            sorted_schedules[j], sorted_schedules[j + 1] = (
                sorted_schedules[j + 1],
                sorted_schedules[j],
            )

# Sort by train name
for i in range(len(sorted_schedules)):
    for j in range(len(sorted_schedules) - 1):
        if sorted_schedules[j][0] > sorted_schedules[j + 1][0]:
            sorted_schedules[j], sorted_schedules[j + 1] = (
                sorted_schedules[j + 1],
                sorted_schedules[j],
            )

# sorted train schedules
for name, loc, time, schedule in sorted_schedules:
    print(schedule)
