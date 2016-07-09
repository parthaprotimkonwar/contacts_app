package com.contacts.common;

/**
 * Created by pkonwar on 7/9/2016.
 */
public class Util {

    //All the 500 color code
    public static String[] colorCodes = {"#F44336", "#E91E63", "#9C27B0", "#673AB7", "#3F51B5", "#2196F3", "#03A9F4", "#00BCD4", "#009688",
                                        "#4CAF50", "#8BC34A", "#CDDC39", "#FFEB3B", "#FFC107", "#FF9800", "#FF5722", "#795548", "#9E9E9E", "#607D8B"};

    /**
     * Returns a COLOR ASCII Code.
     * @param name
     * @return
     */
    public static String findASCIIColorCode(String name) {
        if(name == null || name.isEmpty()) {
            return colorCodes[0];
        }
        int hashcode =Math.abs(name.hashCode());
        int index = hashcode%colorCodes.length;
        return colorCodes[index];
    }


    /**
     * Capitalize the first letter of a Word
     * partha --> Partha ; Partha -> Partha
     * @param word
     * @return
     */
    public static String capitalizeFirstLetterOfThisWord(String word) {
        if(word != null && word.length() > 0) {
            char[] wordArray = word.toCharArray();
            char afterModification =  wordArray[0] >= 97 && wordArray[0]<=122 ? wordArray[0] -= 32 : wordArray[0];
            wordArray[0] = afterModification;
            return String.valueOf(wordArray);
        }
        return null;
    }


    /**
     * Returns the first letter of this word.
     * @param word
     * @return
     */
    public static String firstLetterOfThisWord(String word) {
        if(word != null && word.length() > 0) {
            return String.valueOf(word.toCharArray()[0]);
        }
        return "D";
    }

}
