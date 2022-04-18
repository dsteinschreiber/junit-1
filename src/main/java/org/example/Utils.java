package org.example;

public class Utils {

    public static Integer sum(MyList<Integer> integerList) {

        Integer sum = 0;
        MyListElement<Integer> cursor = integerList.head;

        while (cursor != null) {
            sum = sum + cursor.value;
            cursor = cursor.next;
        }
        return sum;
    }

    public static Integer recursiveSum(MyList<Integer> integerList) {
        // RECURSIVE ALGORITHM
        // !!!
        // SIMPLEST FORM OF RECURSION


        if (integerList.isEmpty()) {         // base case
            return 0;
        } else {
            return integerList.head.value + recursiveSum(integerList.rest());      // recursion
        }
    }

    public static Integer product(MyList<Integer> integerList) {
        Integer product = 1;
        MyListElement<Integer> cursor = integerList.head;

        while (cursor != null) {
            product = product * cursor.value;
            cursor = cursor.next;
        }

        return product;
    }

    public static Integer recursiveProduct(MyList<Integer> integerList) {
        if (integerList.isEmpty()) {
            return 1;
        } else {
            return integerList.head.value * recursiveProduct(integerList.rest());
        }
    }


    public static Boolean anyPositive(MyList<Integer> integerList) {
        Boolean anyPositive = false;

        MyListElement<Integer> cursor = integerList.head;

        while (cursor != null) {
            if (cursor.value >= 0) {
                anyPositive = true;
                break;
            }
            cursor = cursor.next;
        }
        return anyPositive;
    }


    public static Boolean recursiveAnyPositive(MyList<Integer> integerList) {
        if (integerList.isEmpty()) {
            return false;
        } else {
            return integerList.head.value >= 0 || Utils.recursiveAnyPositive(integerList.rest());
        }
    }

    public static Boolean anyNegative(MyList<Integer> integerList) {
        Boolean anyNegative = false;

        MyListElement<Integer> cursor = integerList.head;

        while (cursor != null) {
            if (cursor.value < 0) {
                anyNegative = true;
                break;
            }
            cursor = cursor.next;
        }
        return anyNegative;
    }

    public static Boolean recursiveAnyNegative(MyList<Integer> integerList) {
        if (integerList.isEmpty()) {
            return false;
        } else {
            return integerList.head.value < 0 || Utils.recursiveAnyNegative(integerList.rest());
        }
    }


    public static Boolean anyZero(MyList<Integer> integerList) {
        Boolean anyZero = false;

        MyListElement<Integer> cursor = integerList.head;

        while (cursor != null) {
            if (cursor.value == 0) {
                anyZero = true;
                break;
            }
            cursor = cursor.next;
        }
        return anyZero;
    }

    public static Boolean recursiveAnyZero(MyList<Integer> integerList) {
        if (integerList.isEmpty()) {
            return false;
        } else {
            return integerList.head.value == 0 || Utils.recursiveAnyZero(integerList.rest());
        }
    }

    public static MyList<Integer> doubled(MyList<Integer> integerList) {
        MyList<Integer> doubledList = new MyList<>();

        MyListElement<Integer> cursor = integerList.head;

        while (cursor != null) {
            doubledList.append(cursor.value * 2);
            cursor = cursor.next;
        }

        return doubledList;
    }

    // Recursive template for mapping
    public static MyList<Integer> recursiveDoubled(MyList<Integer> intList) {
        if (intList.isEmpty()) {
            return new MyList<>();
        } else {
            return recursiveDoubled(intList.rest()).push(intList.head.value * 2);
        }
    }

    public static MyList<String> doubledStr(MyList<String> stringList) {
        MyList<String> doubledList = new MyList<>();

        MyListElement<String> cursor = stringList.head;

        while (cursor != null) {
            doubledList.append(cursor.value + " " + cursor.value);
            cursor = cursor.next;
        }

        return doubledList;
    }

    public static MyList<Integer> lengths(MyList<String> list) {
        MyList<Integer> result = new MyList<>();

        MyListElement<String> cursor = list.head;

        while (cursor != null) {
            result.append(cursor.value.length());
            cursor = cursor.next;
        }

        return result;
    }

    public static Boolean allPositive(MyList<Integer> list) {
        Boolean result = true;
        Integer positiveCount = 0;

        MyListElement<Integer> cursor = list.head;

        while (cursor != null) {
            if (cursor.value < 0) {
                return false;
            }
            cursor = cursor.next;
        }

        return result;
    }

    public static Boolean recursiveAllPositive(MyList<Integer> list) {
        if (list.isEmpty()) {
            return true;
        } else {
            return (list.head.value >= 0 && recursiveAllPositive(list.rest()));
        }
    }

    public static MyList<Integer> takeWhilePositive(MyList<Integer> intList) {
        MyList<Integer> result = new MyList<>();

        MyListElement<Integer> cursor = intList.head;

        while (cursor != null && cursor.value >= 0) {
            result.append(cursor.value);
            cursor = cursor.next;
        }
        return result;
    }

    public static MyList<Integer> filterPositive(MyList<Integer> intList) {
        MyList<Integer> result = new MyList<>();

        MyListElement<Integer> cursor = intList.head;

        while (cursor != null) {
            if (cursor.value >= 0) {
                result.append(cursor.value);
            }
            cursor = cursor.next;
        }
        return result;
    }
}


