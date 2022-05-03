package net.will.tdd.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameInverter {
    public String invertName(String name) {
        if (name == null || name.length() <= 0) {
            return "";
        }

        List<String> names = splitNames(name);
        if (names.size() == 1) {
            return names.get(0);
        }

        return formatName(removeHonorifics(names));
    }

    private String formatName(List<String> names) {
        String postNominal = "";
        if (names.size() > 2) {
            postNominal = getPostNominal(names);
        }

        String lastName = names.get(1);
        String firstName = names.get(0);
        return String.format("%s, %s %s", lastName, firstName, postNominal).trim();
    }

    private List<String> removeHonorifics(List<String> names) {
        if (names.size() > 1 && isHonorific(names.get(0))) {
            names.remove(0);
        }
        return names;
    }

    private String getPostNominal(List<String> names) {
        List<String> postNominalList = names.subList(2, names.size());
        String postNominal = "";
        for (String pn : postNominalList) {
            postNominal += pn + " ";
        }
        return postNominal.trim();
    }

    private boolean isHonorific(String word) {
        return word.matches("Mr\\.|Mrs\\.");
    }

    private ArrayList<String> splitNames(String name) {
        return new ArrayList<>(Arrays.asList(name.trim().split("\\s+")));
    }
}
