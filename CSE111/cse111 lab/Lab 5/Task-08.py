class Library:
    def __init__(self, location, book_availability):
        self.location = location
        self.borrower_info = {}
        self.book_availability = book_availability

    def details(self):
        print(f"{self.location} Library details")
        print("Borrower details:")
        print(self.borrower_info)
        print("Books availability:")
        print(self.book_availability)


class Reader:
    def __init__(self, name):
        self.name = name
        self.borrowed_books = {}

    def borrow(self, library, *book_types):
        for book_type in book_types:
            if book_type not in library.book_availability:
                print(f"{book_type} books are not available at the moment.")
                continue
            if library.book_availability[book_type] == 0:
                print(f"No {book_type} book is available at the moment.")
                continue
            if self.name not in library.borrower_info:
                library.borrower_info[self.name] = 0
            if library.borrower_info[self.name] + 1 > 5:
                print("You cannot borrow more than 5 books.")
                continue
            library.book_availability[book_type] -= 1
            library.borrower_info[self.name] += 1
            if book_type not in self.borrowed_books:
                self.borrowed_books[book_type] = 0
            self.borrowed_books[book_type] += 1
            print(f"{book_type} book is borrowed successfully.")

    def readerInfo(self, book_type=None):
        if book_type is None:
            print(
                f"{self.name}, you have {sum(self.borrowed_books.values())} book(s) with you."
            )
            for book_type, num_books in self.borrowed_books.items():
                print(f"Books on {book_type}: {num_books}")
        else:
            num_books = self.borrowed_books.get(book_type, 0)
            print(f"{self.name}, you have {num_books} {book_type} book(s) with you.")


L1 = Library(
    "Dhaka", {"Arts": 15, "Fiction": 135, "Politics": 2, "Science": 11, "Poetry": 15}
)
L1.details()
print("1----------------------")
r1 = Reader("Aladdin")
r1.borrow(L1, "Arts", "Fiction", "Fiction", "Politics")
print("2----------------------")
r1.borrow(L1, "Politics", "Fiction")
print("3----------------------")
r1.readerInfo()
print("4----------------------")
r1.readerInfo("Fiction")
print("5----------------------")
L1.details()
print("6----------------------")
r2 = Reader("Jasmine")
r2.borrow(L1, "Politics", "Poetry")
print("7----------------------")
r2.readerInfo()
print("8----------------------")
L1.details()
