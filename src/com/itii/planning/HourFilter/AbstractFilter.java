package com.itii.planning.HourFilter;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public abstract class AbstractFilter extends PlainDocument {

    private static final long serialVersionUID = 1L;

    protected boolean computeMax(Double max, String match) {
        if (max != 0) {
            return !(Double.parseDouble(match) > Math.abs(max));
        }
        return true;
    }

    protected boolean isOnlyOne(String caracter, String match, String reference) {
        if (reference.contains(".")) {
            return !match.contains(".");
        }
        return true;
    }

    boolean isValid(String match, String acceptedChars, Integer maxSize) {
        if (match == null) {
            return false;
        }

        if (!computeAcceptedChars(acceptedChars, match)) {
            return false;
        }

        if (maxSize > 0) {
            return getLength() < maxSize;
        }
        return true;
    }

    private boolean computeAcceptedChars(String acceptedChars, String match) {
        for (int i = 0; i < match.length(); ++i) {
            if (!acceptedChars.contains(String.valueOf(match.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    String getText(Integer offset, String insertText) {
        String text = "";
        try {
            text = getText(0, getLength());
        } catch (BadLocationException ignored) {}
        if (!text.equals("")) {
            text = text.substring(0, offset) + insertText + text.substring(offset, getLength());
        } else {
            text = insertText;
        }
        return text;
    }

    Integer[] getValues(String text, String separator, Integer size) {
        String numbers[] = text.split(separator);
        Integer[] values = new Integer[size];
        for (int i = 0; i < size; ++i) {
            values[i] = 0;
        }
        for (int i = 0; i < numbers.length; ++i) {
            if (!numbers[i].equals("")) {
                values[i] = Integer.parseInt(numbers[i]);
            }
        }
        return values;
    }
}
