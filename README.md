This repository contains implementations of all possible operations using Java's Stream API. It includes various operations like filtering, mapping, reducing, and others. The purpose is to showcase the capabilities of the Stream API for working with collections in a functional style.

Prerequisites
Java 8 or higher
IDE of your choice (e.g., IntelliJ IDEA, Eclipse)
Setup
Clone this repository:

bash
Copy code
git clone https://github.com/your-username/stream-api-operations.git
Open the project in your preferred IDE.

Build the project using your IDE's build tools (Maven, Gradle, etc.).

Stream API Operations Implemented
This repository implements the following Stream API operations:

Intermediate Operations
Filter

Filters the elements based on a given condition (predicate).
Example:
java
Copy code
List<Integer> evenNumbers = numbers.stream()
                                   .filter(n -> n % 2 == 0)
                                   .collect(Collectors.toList());
Map

Transforms each element using a given function.
Example:
java
Copy code
List<String> uppercaseNames = names.stream()
                                   .map(String::toUpperCase)
                                   .collect(Collectors.toList());
FlatMap

Flattens multiple streams into one, typically used with collections of collections.
Example:
java
Copy code
List<String> allWords = sentences.stream()
                                 .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                                 .collect(Collectors.toList());
Distinct

Removes duplicate elements from the stream.
Example:
java
Copy code
List<Integer> uniqueNumbers = numbers.stream()
                                     .distinct()
                                     .collect(Collectors.toList());
Sorted

Sorts the elements based on natural order or a custom comparator.
Example:
java
Copy code
List<Integer> sortedNumbers = numbers.stream()
                                     .sorted()
                                     .collect(Collectors.toList());
Peek

Performs an action for each element as the stream is consumed. Primarily for debugging.
Example:
java
Copy code
List<String> processedNames = names.stream()
                                   .peek(System.out::println)
                                   .collect(Collectors.toList());
Limit

Truncates the stream to a given number of elements.
Example:
java
Copy code
List<String> firstThreeNames = names.stream()
                                    .limit(3)
                                    .collect(Collectors.toList());
Skip

Skips a given number of elements in the stream.
Example:
java
Copy code
List<String> skippedNames = names.stream()
                                 .skip(2)
                                 .collect(Collectors.toList());
Terminal Operations
Collect

Gathers the elements of the stream into a collection (e.g., List, Set).
Example:
java
Copy code
List<String> namesList = names.stream()
                              .collect(Collectors.toList());
Count

Returns the number of elements in the stream.
Example:
java
Copy code
long count = numbers.stream().count();
ForEach

Iterates over each element and performs an action.
Example:
java
Copy code
names.stream().forEach(System.out::println);
Reduce

Reduces the elements of the stream to a single value using a given binary operator.
Example:
java
Copy code
int sum = numbers.stream()
                 .reduce(0, Integer::sum);
AnyMatch

Returns true if any element matches a given predicate.
Example:
java
Copy code
boolean hasEven = numbers.stream()
                         .anyMatch(n -> n % 2 == 0);
AllMatch

Returns true if all elements match a given predicate.
Example:
java
Copy code
boolean allPositive = numbers.stream()
                             .allMatch(n -> n > 0);
NoneMatch

Returns true if no elements match a given predicate.
Example:
java
Copy code
boolean noneNegative = numbers.stream()
                              .noneMatch(n -> n < 0);
FindFirst

Returns the first element of the stream (if present).
Example:
java
Copy code
Optional<Integer> firstNumber = numbers.stream()
                                       .findFirst();
FindAny

Returns any element of the stream (if present), particularly useful in parallel streams.
Example:
java
Copy code
Optional<Integer> anyNumber = numbers.stream()
                                     .findAny();
Short-Circuit Operations
Limit

Limits the stream to a maximum of n elements.
FindFirst/FindAny

Terminates the stream when the desired element is found.
AnyMatch, AllMatch, NoneMatch

These operations can terminate early when their result is determined.
Usage
Each Stream API operation is implemented in a separate class with detailed examples. You can run the main class of each implementation to see how each operation works.

Example Usage
java
Copy code
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Filtering even numbers
        List<Integer> evenNumbers = numbers.stream()
                                           .filter(n -> n % 2 == 0)
                                           .collect(Collectors.toList());

        System.out.println(evenNumbers);
    }
}
License
This project is licensed under the MIT License.

This template should provide a clear and organized overview of the repository focused on Stream API operations in Java.
