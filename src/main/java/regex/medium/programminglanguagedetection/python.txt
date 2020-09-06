
# You can use Lists as Stacks in Python
stack = [10,9,8,7,6,5]
# Original contents of the stack
print "Original Contents of the Stack"
print stack
# Appending to a list is the same as pushing to a stack
stack.append(1)
stack.append(2)
# In the two steps above we push 1 and 2 onto the stack
print "After pushing 1 and 2 onto the stack it looks like:"
print stack

# Now we explore the pop operation
poppedValue = stack.pop()

# Display the popped value
print "Popped Value:"
print poppedValue

# Now display what the stack looks like:
print "After the pop operation the stack looks like:"
print stack

# Now we explore the pop operation again
poppedValue = stack.pop()

# Display the popped value
print "Again, we pop a value from the top of the stack. Popped Value:"
print poppedValue

# Now display what the stack looks like:
print "After the second pop operation the stack looks like:"
print stack

@@@@


# Deques from collections are convenient to use as Queues
# It is not efficient to use lists because they are efficient for reading/appending/popping from the end
# But they are not so efficient for dequeing from the beginning
from collections import deque
queue = deque(["London","Paris","New York","Delhi"])
print "The Original Queue:"
print queue

# Now we also queue a few more cities
queue.append("Mumbai")
queue.append("Kolkata")
# Now display the queue after en-queueing these
print queue
# You will observe that Mumbai and Kolkata have been en-queued at the end of the queue

# Now let us start to De-que element from this queue
dequedElement1 = queue.popleft()
dequedElement2 = queue.popleft()
# Let us display the Dequeued Elements.
# Given that a Queue is a First In First Out (FIFO) data structure the de-queued elements will be London and Paris
print "Two cities were de-queued"
print "First Dequeued city:"
print dequedElement1
print "First Dequeued city:"
print dequedElement2

# You will notice how the first two cities have been removed from the Queue, in FIFO order
print "Current state of the queue after dequeing two cities:"
print queue


@@@@


class Node:

	def __init__(self,data=None,next=None):
		self.data = data
		self.next = next

	def __str__(self):
		return "Node[Data=" + `self.data` + "]"



class LinkedList:

	def __init__(self):
		self.head = None

	# Inserting new data at the end of the list
	# Iterate through the list till we encounter the last node.
	# A new node is created for this data element
	# And the last pointer points to this
	def insert(self,data):
		if (self.head == None):
			self.head = Node(data)
		else:
			current = self.head
			while (current.next != None) and (current.data == data):
                            current = current.next
			current.next = Node(data)

	# Deleting a given data value from the linked list
	# If the head contains this data value
	# Set head = node which comes next after the current head
	# Otherwise go to the node such that the node after it (next to it) contains the value we're looking for
	# set node.next = node.next.next
	# so, the node which dontains the specified value/data; is skipped
	def delete(self,data):
		current = self.head
		if current.data == data:
			self.head = current.next
		if current == None:
			return False
		else:
			while (current != None) and (current.next != None) and (current.next.data != data):
				current = current.next
			if (current != None) and (current.next != None) :
				current.next = current.next.next

	# Find a given data value in the linked list
	# Traverse the linked list till you either find the data value or you come to the end of the list

	def find(self,data):
		found = False
		current = self.head
		while ((current != None) and (current.data != data) and ( current.next != None)):
			current = current.next
 		if current != None:
			found = True
		return found

	# Display the linked list
	# Traverse the linked list till you reach its end
	# Display each node which you traverse
	def display(self):
		current = self.head
		string_representation = " "
		while current != None:
			string_representation +=  str(current) + "--->"
			current = current.next
		print string_representation

# Initialize a new linked list
print "Initializing linked list"
ll = LinkedList()

# Insert values in the linked list
print "Inserting values 1,2,3,9 in the Linked List"
ll.insert(1)
ll.insert(2)
ll.insert(3)
ll.insert(9)

# Display the linked list
print "Displaying the linked list"
ll.display()

# Delete an element from the linked list. Demonstrate the Delete function
print "Delete an element (data = 3) from the linked list"
ll.delete(3)

print "Display the linked list again. The value 3 is deleted. "
ll.display()

# Try to find the value 2 in the linked list (Demonstrating the Find function)
print "Try to find the value 2 in the linked list"
found = ll.find(2)
if found == True:
	print "The value 2 is present in the Linked List"
else:
	print "The value 2 is not present in the linked list"

# Try to find the value 20 in the linked list
print "Try to find the value 20 in the linked list"
found = ll.find(20)
if found == True:
	print "The value 20 is present in the Linked List"
else:
	print "The value 20 is not present in the linked list"


@@@@



class Node:

    # Constructor to initialize data
    # If data is not given by user,its taken as None
    def __init__(self, data=None, next=None, prev=None):
        self.data = data
        self.next = next
        self.prev = prev

    # __str__ returns string equivalent of Object
    def __str__(self):
        return "Node[Data = %s]" % (self.data,)

class DoubleLinkedList:

    def __init__(self):
        self.head = None
        self.tail = None

    def insert(self, data):
        if (self.head == None): # To imply that if head == None
            self.head = Node(data)
            self.tail = self.head
        else:
            current = self.head
            while(current.next != None):
                current = current.next
            current.next = Node(data, None, current)
            self.tail = current.next

    def delete(self, data):
        current = self.head
        # If given item is the first element of the linked list
        if current.data == data:
            self.head = current.next
            self.head.prev = None
            return True

        # In case the linked list is empty
        if current == None:
            return False

        # If the element is at the last
        if self.tail == data:
            self.tail = self.tail.prev
            self.tail.next = None
            return True

        # If the element is absent or in the middle of the linked list
        while current != None:
            if current.data == data :
                current.prev.next = current.next
                current.next.prev = current.prev
                return True
            current = current.next

        # The element is absent
        return False

    def find(self, data):
        current = self.head
        while current != None:
            if current.data == data :
                return True
            current = current.next
        return False

    def fwd_print(self):
        current = self.head
        if current == None:
            print("No elements")
            return False
        while (current!= None):
            print (current.data)
            current = current.next
        return True

    def rev_print(self):
        current = self.tail
        if (self.tail == None):
            print("No elements")
            return False

        while (current != None):
            print (current.data)
            current = current.prev
        return True

# Initializing list
l = DoubleLinkedList()

# Inserting Values
l.insert(1)
l.insert(2)
l.insert(3)
l.insert(4)

# Forward Print
l.fwd_print()

# Reverse Print
l.rev_print()

# Try to find 3 in the list
if (l.find(3)):
    print("Found")
else :
    print("Not found")

# Delete 3 from the list
l.delete(3)

# Forward Print
l.fwd_print()

# Reverse Print
l.rev_print()

# Now if we find 3, we will not get it in the list
if (l.find(3)):
    print("Found")
else :
    print("Not found")


@@@

def cube(n):
    '''
    a ** b means a^b.
    eg : 2**3 = 2 x 2 x 2 = 8
    '''
    return n ** 3

def string_operation(s):
    '''
    String is an immutable object. So whatever operations we perform on strings
    a new string is generated and the original string stays the same.
    '''
    # Capitalize makes the first letter of the string capital
    print('Capitalized String :', s.capitalize())

    # To find a substring in a given string, python has a function called find().
    # If the substring is present in the string, it returns index of its first entry, otherwise -1.
    print('To find whether the string has the phrase "oper" in it', s.find('oper'))

    # The index function returns the first index location where the substring is contained.
    # It raises a ValueError if the substring is not there. That's why we use find().
    if (s.find('oper') != -1):
        print('Index of "oper"', s.index('oper'))

    print('True if all the characters are alphanumeric and the string is not empty', s.isalpha())

    print('True if all the characters are digits otherwise false', s.isdigit())

    print('Generates a new string with characters capitalized', s.upper())

def volume(length=10, breadth=10, height=10):
    '''
    In the function header we have assigned default values of length, breadth and height
    that is to say if the function is called with only 2 parameters given, then the
    value of height will be taken as 10.
    '''
    return(length * breadth * height)

def main():
    # Print the cube of a number
    num = int(input("Enter a number : "))
    print("The cube of the number is :", cube(num))

    # String Operations
    n = input("Enter a string : ")
    string_operation(n)

    # Volume of a cuboid
    l = int(input("Enter length : "))
    b = int(input("Enter Breadth : "))
    h = int(input("Enter Height : "))
    print("Volume of cuboid :", volume(l, b, h))

if (__name__ == '__main__'): main()
