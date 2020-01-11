# Car Hierarchy


Design and implement a hierarchy of classes for a Car concept


1. Currently the market has three main types of car: Electric, Hybrid, Gas Burning
    - define a abstract class/interface of these types of car - (iheritance or IS-A)

2. Every car should has at least 5 properties which describe it (color, max speed, etc...) - (encapsulation)

3. Every car should has at least 6 methods which gives an ability to interact with it (start engine, turn right, etc...)
    - a car method can call another car method (what should be done before car can move?)

3. Every car consist of different parts like engine, trasmission, doors, etc...
    - define classes for a car internal parts
    - declare properties in the car classes for these parts to implement HAS-A relationship

    - hint: every type of car has its own engine type...

4. There is other classification for a car type: Sedan, Hatchback, Crossover, Liftback, etc...
    - how would you add this classification for the hierarchy?