package appli1;


import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lortole
 */
public class Test1 extends JLabel {
    
    static boolean switch_text = true;
    public void switchText()
    {
        switch_text = !switch_text;
        if (switch_text)
        {
            super.setText("ON");
}
        else 
        {
            super.setText("OFF");
        }
    }
    
}
