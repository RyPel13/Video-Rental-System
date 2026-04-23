# Video-Rental-System
•	Designed and implemented a multi-class video rental system in Java, modeling real-world rental operations for DVDs, Blu-rays, and video games using core OOP principles.

•	Applied inheritance to build a class hierarchy: a base Media class with specialized Video and Game subclasses, and a base Rental class extended by DailyRental — enabling code reuse and type-specific behavior without duplicating logic.

•	Demonstrated polymorphism through method overriding: the DailyRental subclass overrode getTotalFee() to implement a per-day pricing model with promo credit logic, transparently replacing flat-fee behavior wherever the method was called.

•	Enforced encapsulation by declaring all data fields private or protected, exposing state only through well-defined public getter/setter methods and constructors across all classes (Media, Payment, Rental, RentalBox).

•	Leveraged instanceof and type casting within RentalBox to apply polymorphic dispatch — dynamically determining daily rental fees based on the runtime type of media (DVD, Blu-ray, or Game).

•	Overrode equals(), hashCode(), and toString() in the Media class to implement value-based equality and human-readable output, following Java best-practice contracts for object identity.

