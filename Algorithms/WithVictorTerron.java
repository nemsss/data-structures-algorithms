package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class WithVictorTerron {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        System.out.println(recursiveGrossProduct(list));
        list.add(5);
        System.out.println(recursiveGrossProduct(list));
        list.add(3); list.add(2);
        System.out.println(recursiveGrossProduct(list));

        //Using Reduction

        // creating a list of Strings
        List<Integer> numbers = Arrays.asList(3, 2, 5, 10);

        // The lambda expression passed to
        // reduce() method takes two Strings
        // and returns the the longer String.
        // The result of the reduce() method is
        // an Optional because the list on which
        // reduce() is called may be empty.
        Optional<Integer> grossProduct = numbers.stream()
                .reduce((num1, num2) -> num1 * num2);

        // Displaying the longest String
        grossProduct.ifPresent(System.out::println);
    }

    private static int recursiveGrossProduct(List<Integer> list) {
        int len = list.size();
        if(len == 0){ return 1;}
        if(len == 1){ return list.get(0);}

        list.set(len-2, (list.get(len-2) * list.get(len-1)));
        list.remove(len-1);
        return recursiveGrossProduct(list);
    }

    private static int grossProductWithReduce(List<Integer> numbers) {
        if(numbers.size() == 0){ return 1;}
        return numbers.stream()
                .reduce((num1, num2) -> num1 * num2).get();

        // Added '.get()' because the method returns an Optional value
    }
}
