/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Converter;

/**
 *
 * @author lortole
 */
public class Monnaie 
{
    private String nom_pays;
    private String nom_monnaie;
    private String code_monnaie;
    private String taux_change;
    
    
    public String getCode_monnaie()
    {
        return code_monnaie;
    }
    
    public void setCode_monnaie(String code_monnaie)
    {
        this.code_monnaie = code_monnaie;
    }
    
    
}
