package com.bravi.balanced.brackets;

import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Balanced {

    /**
     * Vefiry if sequence contains a balanced brackets
     * @param sequence
     * @return True if valid
     */
    public boolean isBalanced(String sequence) {

        if(sequence==null || sequence.isEmpty()){
            return false;
        }

        String splited[] = sequence.split("");

        if (splited.length % 2 != 0) {
            return false;
        }

        Map<String, String> values = new HashMap<String, String>();
        values.put("{", "}");
        values.put("[", "]");
        values.put("(", ")");

        List<String> aux = new ArrayList<>();
        aux.add(splited[0]);

        for (int i = 1; i < splited.length; i++) {

            if (!aux.isEmpty()) {
                int auxIndexLastValue = aux.size() - 1;
                String closedLastAux = values.get(aux.get(auxIndexLastValue));

                if (!splited[i].equals(closedLastAux)) {
                    aux.add(splited[i]);
                } else {
                    aux.remove(auxIndexLastValue);
                }
            }
        }

        if (!aux.isEmpty()) {
            return false;
        }
        return true;
    }

}
