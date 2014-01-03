/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fr.miage.orleans.actions.main;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Damien
 */
public class loadHomePage  extends ActionSupport{
    private String bouh;

    public String getBouh() {
        return bouh;
    }

    public void setBouh(String bouh) {
        this.bouh = bouh;
    }
    public loadHomePage() {
    }
    
    @Override
    public String execute() throws Exception {
        this.bouh = "YOUPI";
        return SUCCESS;
    }
    
}
