/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.oprofvalmor.cliente2.modelo;

/**
 *
 * @author old_adam
 */
public class Usuario {
    private static final Usuario instance = new Usuario();
    
    private String userId;
    
    public static Usuario getInstance() {
        return instance;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getUserId() {
        return userId;
    }
}
