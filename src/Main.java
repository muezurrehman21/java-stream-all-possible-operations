import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        /*--------------------Intermediate Operator-----------------------*/
        /* 1 . filter
        filters all numbers from a list that are greater than 5.*/
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> numberResult = numbers.stream()
                .filter(n-> n > 5)
                .collect(Collectors.toList());
        System.out.println(numberResult);

        /* 2. map
        Transform a List of String into a list of their uppercase */
        List<String> words = Arrays.asList("apple", "Mango", "banana");
        List<String> wordResult = words.stream()
                .map(word -> word.toUpperCase()) // we can do .map(String::toUpperCase())
                .collect(Collectors.toList());
        System.out.println(wordResult);
        /* 3. flatMap
        * given a list of lists of strings , flatern them into a single list of strings.
        * */
        List<List<String>> listOfLists =  Arrays.asList(
                Arrays.asList("one","two"),
                Arrays.asList("three","four")
        );
        List<String> listResult = listOfLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        //lambda function

//        List<String> listResult = listOfLists.stream()
//                .flatMap(list -> list.stream())
//                .collect(Collectors.toList());
        System.out.println(listResult);

        /* 4. distinct
        * remove duplicates from a list */
        List<Integer> numberDuplication = Arrays.asList(1,2,3,4,5,4,3,2,6,7);
        List<Integer> numberDuplicationResult = numberDuplication.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(numberDuplicationResult);

        /* 5. sorted
        sort a list of names in reverse alphabetical order
         */
        List<String> names = Arrays.asList("John", "Jane", "Alice", "Bob");
        List<String> namesResultForReverseOrder = names.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(namesResultForReverseOrder);
        List<String> namesResultForSortOrder = names.stream()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println(namesResultForSortOrder);

        /*6. peek
        * print each element in the list while converting them to uppercase */
        List<String> element = Arrays.asList("apple", "Mango", "banana");
        List<String> elementResult = element.stream()
                .peek(ele -> System.out.println(ele))
                .map(ele -> ele.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(elementResult);

        /* 7. limit
        * fetch first three elements from the list*/
        List<Integer> numberlist = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> numberlistResult = numberlist.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println(numberlistResult);

        /*8. skip
        * skip the first four element and collect the remaining elements from the list
        * */
        List<Integer> skiplist = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> skiplistResult = skiplist.stream()
                .skip(4)
                .collect(Collectors.toList());
        System.out.println(skiplistResult);






        /*--------------------------------Terminal Operations------------------------------------------*/

        /*9. foreach
        print each elements of a list of string
        */
        List<Integer> forEachList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        forEachList.stream()
                        .forEach(word -> System.out.print(word+ "  "));

        /*10. collect
        * Collect a list of integers into a set */
        List<Integer> Setlist = Arrays.asList(1,2,3,3,4,5,3,5,6,7,8);
        Set<Integer> SetlistResult = Setlist.stream()
                .collect(Collectors.toSet());
        System.out.println(SetlistResult);

        /*11. reduce
        * compute the product of all number in the list*/
        List<Integer> productlist = Arrays.asList(1,2,3);
        Optional<Integer> productlistResult = productlist.stream()
                .reduce((a,b)-> a*b);
        System.out.println(productlistResult.get());

        /*12. allmatch
        * check if a number in a list are positive */
        List<Integer> matchlist = Arrays.asList(1,2,3);
        boolean matchlistResult = matchlist.stream()
                .allMatch(n -> n>0);
        System.out.println(matchlistResult);

        /*13. anymatch
         * check if any number in a list is greater than 10 */
        List<Integer> anyMatchlist = Arrays.asList(1,2,3);
        boolean anyMatchlistResult = anyMatchlist.stream()
                .allMatch(n -> n>10);
        System.out.println(anyMatchlistResult);

        /*14. anymatch
         * check if a number in a list is non-negative */
        List<Integer> noneMatchlist = Arrays.asList(1,2,3);
        boolean noneMatchlistResult = noneMatchlist.stream()
                .noneMatch(n -> n<0);
        System.out.println(noneMatchlistResult);

        /*15. findFirst
        * find first word start with 'b'*/
        List<String> findFirst = Arrays.asList("apple", "Mango", "banana");
        Optional<String> findFirstResult = findFirst.stream()
                .filter(word -> word.startsWith("b"))
                .findFirst();
        System.out.println(findFirstResult.get());

        /*15. findAny
         * find any word start with 'b'*/
        List<String> findAny = Arrays.asList("apple", "Mango", "banana","bangan");
        Optional<String> findAnyResult = findAny.stream()
                .filter(word -> word.startsWith("b"))
                .findAny();
        System.out.println(findAnyResult.get());

        /*16. max and min
         * find max and min*/
        List<Integer> maxAndMin = Arrays.asList(1,2,3);
        Optional<Integer> maxResult = maxAndMin.stream()
                .max(Integer::compareTo);
//                .max((a,b)-> a.compareTo(b));
        System.out.println("Max : " + maxResult.get());

        Optional<Integer> minResult = maxAndMin.stream()
                .min(Integer::compareTo);
//        .min((a,b)-> a.compareTo(b));
        System.out.println("Min : "+ minResult.get());

        /*15. toArray
         * convert a list of string into array */
        List<String> listToArray = Arrays.asList("apple", "Mango", "banana","bangan");
        String[] listToArrayResult = listToArray.stream()
                .toArray(String[]::new);
//        .map(str -> str)  // Lambda function, though identity function in this case
//                .toArray(String[]::new);  // Convert to array
        System.out.println(Arrays.toString(listToArrayResult));


        /*--------------------------------Collectors----------------------------------------*/

        /*16. joining
        * concatenate all string in a list into a single string*/
        List<String> joining = Arrays.asList("apple", "Mango", "banana");
        String joiningResult = joining.stream()
                .collect(Collectors.joining("", "'","'"));//1st "" are just using to differentiate the index of the list and single colon is used as prefix and suffix which are requiement base
        System.out.println(joiningResult);

        /*17. Grouping by
        * Group a list of people by their city*/
        List<Person> people = Arrays.asList(
                new Person("john","New York"),
                new Person("Jane","London"),
                new Person("Jack", "New York")
        );
        Map<String, List<Person>> result = people.stream()
                .collect(Collectors.groupingBy(person -> person.getCity()));
        System.out.println(result);
    }
}

class Person{
    private String name;
    private String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return
                "name='" + name + '\'';
    }
}
