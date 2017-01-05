/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appli1;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author lortole
 */
public class Compteur implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    public Integer valeur;
    
    private PropertyChangeSupport propertySupport;
    
    public Compteur() {
        propertySupport = new PropertyChangeSupport(this);
    }
    
    public Integer getValeur() {
        return valeur;
    }
    
    public void setValeur(Integer value) {
        Integer oldValue = valeur;
        valeur = value;
        propertySupport.firePropertyChange(PROP_SAMPLE_PROPERTY, oldValue, valeur);
    }
    
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }
    
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }
    
    public void incr(){
        valeur++;
        setValeur(valeur);
    }
    
        public void decr(){
            valeur--;
        setValeur(valeur);
    }
        
        public void raz(){
            setValeur(0);
        }
    
}
