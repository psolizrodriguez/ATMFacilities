package com.facilities.view.atm;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import com.facilities.model.atm.ATM;

public class ComboBoxRenderer extends DefaultListCellRenderer{

    public Component getListCellRendererComponent(
                                   JList list,
                                   Object value,
                                   int index,
                                   boolean isSelected,
                                   boolean cellHasFocus) {
        if (value instanceof ATM) {
            value = ((ATM)value).getAtmId();
        }
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        return this;
    }
	

}
