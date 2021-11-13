package com.automationbytarun.browser;

import org.openqa.selenium.WebDriver;

public abstract class Browser {

    private boolean isHeadless;

    private boolean isRemote;

    private boolean isMaximized;

    private Integer pageLoadTimeOut;

    private boolean deleteCookies;

    public abstract void setPreferences();

    public abstract WebDriver loadBrowser(String path);

    public boolean isHeadless() {
        return isHeadless;
    }

    public void setHeadless(boolean headless) {
        isHeadless = headless;
    }

    public boolean isRemote() {
        return isRemote;
    }

    public void setRemote(boolean remote) {
        isRemote = remote;
    }

    public boolean isMaximized() {
        return isMaximized;
    }

    public void setMaximized(boolean maximized) {
        isMaximized = maximized;
    }

    public Integer getPageLoadTimeOut() {
        return pageLoadTimeOut;
    }

    public void setPageLoadTimeOut(Integer pageLoadTimeOut) {
        this.pageLoadTimeOut = pageLoadTimeOut;
    }

    public boolean isDeleteCookies() {
        return deleteCookies;
    }

    public void setDeleteCookies(boolean deleteCookies) {
        this.deleteCookies = deleteCookies;
    }
}
