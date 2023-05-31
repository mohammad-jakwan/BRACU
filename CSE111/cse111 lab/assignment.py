class Product:
    def __init__(self, name, quantity, price):
        self.name = name
        self.quantity = quantity
        self.price = price
    
    def calculate_price(self):
        return self.price * self.quantity
    
    def __str__(self):
        return f"{self.name} (${self.price}) x {self.quantity}"
    
    
class OnlineStoreItem(Product):
    def __init__(self, name, quantity, price, shipping_weight):
        super().__init__(name, quantity, price)
        self.shipping_weight = shipping_weight
    
    def calculate_shipping_cost(self):
        return 2.5 * self.shipping_weight
    
    def __str__(self):
        return f"{super().__str__()} ({self.shipping_weight} lbs)"
    
    
class Customer:
    def __init__(self, name, email, address, phone_number):
        self.name = name
        self.email = email
        self.address = address
        self.phone_number = phone_number
        
    def __str__(self):
        return f"Name : {self.name}\nEmail : {self.email}\nAddress : {self.address}\nPhone : {self.phone_number}"
    
    
class Order:
    def __init__(self, customer, products, quantities):
        self.customer = customer
        self.products = products
        self.quantities = quantities
    
    def calculate_total(self):
        total = 0
        for product, quantity in zip(self.products, self.quantities):
            total += product.price * quantity
        return total
    
    def remove_product(self, product):
        index = self.products.index(product)
        del self.products[index]
        del self.quantities[index]
    
    def __str__(self):
        output = f"Order for {self.customer.name}:\n"
        output += "Name x Stock x Ordered\n"
        for product, quantity in zip(self.products, self.quantities):
            output += f"{product} x {product.quantity} x {quantity}\n"
        output += f"Total: ${self.calculate_total():.2f}"
        return output
    
    
class OnlineStore:
    def __init__(self):
        self.name = "My Online Store"
        self.products = []
        self.customers = []
        self.orders = []
    
    def add_product(self, product, quantity):
        product.quantity = quantity
        self.products.append(product)
    
    def remove_product(self, product):
        self.products.remove(product)
    
    def register_customer(self, customer):
        self.customers.append(customer)
    
    def place_order(self, customer, products, quantities):
        order = Order(customer, products, quantities)
        for product, quantity in zip(products, quantities):
            index = self.products.index(product)
            self.products[index].quantity -= quantity
        self.orders.append(order)
        return order
    
    def __str__(self):
        output = f"{self.name}\nProducts in stock:\n"
        for product in self.products:
            output += str(product) + f" x {product.quantity}\n"
        return output
    
    def customers_info(self):
        print(f"Total Customer : {len(self.customers)}")
        for customer in self.customers:
            print(customer)



# Driver code
# Create some products
product1 = OnlineStoreItem("Apple", 0.5, 0, 0.2)
product2 = Product("Banana", 0.3, 0)
product3 = OnlineStoreItem("Orange", 0.4, 0,
0.3)
# Create an online store
store = OnlineStore()
# Add the products to the store
store.add_product(product1, 100)
store.add_product(product2, 50)
store.add_product(product3, 75)
# View all products in the store
print("1=====================")
print(store)
print("2=====================")
# Create a new customer
customer1 = Customer("Alice",
"alice@example.com", "123 Main St.","555-1234")
# Register the customer with the store
store.register_customer(customer1)
store.customers_info()
print("3=====================")
# Place an order for the customer
order1 = store.place_order(customer1, [product1,
Output:
1=====================
Products:
Apple ($0.50) x 100
Banana ($0.30) x 50
Orange ($0.40) x 75
2=====================
Total Customer : 1
Name : Alice
Email : alice@example.com
Address : 123 Main St.
Phone : 555-1234
3=====================
Order for Alice:
Apple ($0.50) x 100 x 50
Banana ($0.30) x 50 x 25
Total: $65.00
4=====================
Order for Alice:
Banana ($0.30) x 50 x 25
Total: $15.00
4=====================product2], [50, 25])
# View the order
print(order1)
print("4=====================")
# Remove a product from the order
order1.remove_product(product1)
# View the updated order
print(order1)
print("4=====================")