/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author lollo
 */
public class ControllerForModel implements IControllerForModel {

	private static ControllerForModel instance = null;

	private ControllerForModel() {
		//to-do
	}

	public IControllerForModel getInstance() {
		if (instance == null)
			instance = new ControllerForModel();
		return instance;
	}
}