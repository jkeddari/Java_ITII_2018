package com.itii.planning.HourFilter;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;

public class alterHourFilter extends AbstractFilter {

    private static final long serialVersionUID = 1L;
    //public boolean isCorrect(int hour, int minute, int second)
    //protected JTextField _txtFilterHour;
    private boolean isCorrect(int hour, int minute) {

        return hour >= 0 && hour < 24 && minute >= 0 && minute < 60;
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (!isValid(str, "0123456789:", 5)) { /*5 pour HH:MM*/
            return;
        }
        String text = getText(offset, str);

        //System.out.println("text: "+str);
        //System.out.println("offset: "+offset);

        Integer[] values = getValues(text, ":", 3);



        if (offset == 2 || offset == 5 || offset == 8) {
            if (!str.equals(":")) {
                super.insertString(offset, ":" + str, attr);
            } else {
                super.insertString(offset, ":", attr);
            }
        } else {
            /*
            if (offset==0 && str.length() ==1 && Integer.parseInt(str) > 2){

                    super.insertString(offset,"0"+ str, attr);
                    offset++;
            }
            */
            if (isCorrect(values[0], values[1]/*, values[2])*/)) {
                super.insertString(offset, str, attr);
            }
        }
    }
}