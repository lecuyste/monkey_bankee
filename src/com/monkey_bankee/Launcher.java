package com.monkey_bankee;

import com.monkey_bankee.gui.MainFrameLogin;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class Launcher {


    //Ouverture de la fenetre SWING
    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, InvocationTargetException, InterruptedException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.invokeAndWait(() -> {
            MainFrameLogin login = new MainFrameLogin();
            login.setVisible(true);
        });
    }
}