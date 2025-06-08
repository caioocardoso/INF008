package com.INF008.app;

import com.INF008.app.services.EventManager;

public class University {
    public static void main(String[] args) {
        EventManager.populateEvents();
        Menu.showMainMenu();
    }
}