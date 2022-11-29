# Lab11Sort
Sorting Warmup Lab

# In the src folder is some code
Review the code provided. Answer the following questions by adding comments to your code! You are free to talk with other students, and seek better understanding to these questions. See below for reminders on types, variables, and input

# Step One
Answer the following questions as comments in your code:
1. Look at filter(). This is another sort of sorting--how is it filtering and what is it filtering by.
2. findFlight() uses both filter() and sort(). How might this make finding the flight easier, and do you think it always reduces time?
3. What are some uses of sorting for lists and why might you want to have a list sorted?

# Step Two: Coding: sorter(ArrayList<Plane> p)
Find the method `sorter(ArrayList<Plane> p)`.
We want sorter() to take in an Arraylist of planes and return those planes in sorted order by using Collections.sort(). In order for Collections.sort() to work, we need to write compare(Plane a, Plane b). To find where you want to code, find the comment that says "Student code". 
For our compare(), we want it to follow the following rules:
```
The order of comparisons should be airline, then city, then time.
There is a compareTo() method that you can use for the strings, but you will have to do the time comparisons completely by hand like this:
1. If a > b, return 1
2. If a < b, return -1
3. If a == b, return 0
```

For example, if someone calls
```java
Flights f = new Flights("src/Airport.csv");
ArrayList<Plane> test = f.FlightList;
f.sorter(test);                       
for(Plane p : test){
  System.out.println(p);
}
```
The output should look like this:
```
Airline: Alitalia
City: Milan
Time: 15:45

Airline: Alitalia
City: Toronto
Time: 5:45

Airline: British Airways
City: London
Time: 12:30

Airline: British Airways
City: London
Time: 12:30

Airline: Southwest
City: Denver
Time: 1:55

Airline: Southwest
City: Denver
Time: 2:55

Airline: Southwest
City: Denver
Time: 14:55

Airline: Southwest
City: Phoenix
Time: 6:15

Airline: Southwest
City: Phoenix
Time: 12:15

Airline: United
City: Dubai
Time: 12:35

Airline: United
City: Phoenix
Time: 4:35

Airline: United
City: Portland
Time: 13:35
```

# Step Three: Test sorter(ArrayList<Plane> p)
How do you test code? You simply add the lines to your java file (in the future, you will have test lines in separate files).

As such, we would recommend adding the example code from the previous step into main().

Also add your own tests!

# Submitting the Assignment
Make sure to submit the assignment for grading! If you haven't clicked through the canvas link in a while, we would suggest clicking through it again before submitting.

# Reminder on compareTo()
As is noted in Step 2, String has a built in compare to. When using this compareTo(), you will not need to do any extra work to interpret the output as numbers, it will return 0, 1, or -1. It is up to you to understand how you can use this, though. For example, we know that if our comparison results in a 0, our Strings must be the same. That must mean that we need to move on to checking the next comparison (like if the airlines are the same, check the cities). For our code, we are putting them in alphabetical order and numerical order, but you will likely also see reverse sorts in the future.
