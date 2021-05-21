/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.command;

import com.mycompany.presenter.PrincipalPresenter;

/**
 *
 * @author mayco
 */
public abstract class Command {
    public void execute(PrincipalPresenter presenter){};
}
