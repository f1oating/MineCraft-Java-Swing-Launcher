package gui;

import javax.swing.*;

import back.DataVersions;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VersionListComboBox {
	
	private JComboBox<String> versionList;
	private DataVersions dataVersions;
	
	public JComboBox<String> createVersionListComboBox() {
		dataVersions = new DataVersions();
		versionList = new JComboBox<String>(dataVersions.getVersions());
        versionList.setSelectedIndex(dataVersions.getSelectedIndex());
        versionList.setMaximumRowCount(5);
        versionList.setBounds(new Rectangle(190, 500, 150, 30));
        versionList.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dataVersions.setSelectedText(versionList.getSelectedItem());
        	}
        });
        
        return versionList;
	}
	
}	