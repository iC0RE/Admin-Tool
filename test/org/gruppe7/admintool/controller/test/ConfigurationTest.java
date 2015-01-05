/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gruppe7.admintool.controller.test;

import config.Configuration;
import config.Configuration.Field;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author langep16
 */
public class ConfigurationTest {
    @Test
    public void testDefaultConfiguration(){
        testField(Field.Host);
        testField(Field.Port);
        testField(Field.Name);
        testField(Field.User);
        propertyStorage();
        propertyLoad();
    }
    
    private void testField(Field field){
        String value = Configuration.getValue(field);
        Assert.assertNotNull(value);
        Assert.assertFalse(value.isEmpty());
    }
    
    private void propertyStorage(){
        Configuration.storeProperties();
    }
    
    private void propertyLoad(){
        Configuration.setValue(Field.User, "Mustermann");
        Configuration.storeProperties();
        Configuration.loadProperties();
        String value = Configuration.getValue(Field.User);
        Assert.assertEquals("Mustermann", value);
    }
}
