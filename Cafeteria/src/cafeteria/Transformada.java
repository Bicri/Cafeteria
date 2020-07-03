/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafeteria;

import java.util.ArrayList;
import java.util.List;
import objetos.Orden;

/**
 *
 * @author isaac
 */
public class Transformada {
    
    private String cantidad = "", identificador="", platillo="";
    private List <Orden> listaorden = new ArrayList<>();
    
    public List separaProd(String p, int i)
    {
        if(i==p.length())
        {
            return listaorden;
        }
        else
        {
            for(i=i; i<p.length(); i++)
            {
                if(p.charAt(i)==' ')
                {
                    i++;
                    break;
                }
                else
                {
                    cantidad += p.charAt(i);
                }
            }
            for(i=i; i<p.length(); i++)
            {
                if(p.charAt(i)==' ')
                {
                    i++;
                    break;
                }
                else
                {
                    identificador += p.charAt(i);
                }
            }
            for(i=i; i<p.length();i++)
            {
                if(p.charAt(i)==',')
                {
                    i++;
                    break;
                }
                else
                {
                    platillo += p.charAt(i);
                }
            }
            listaorden.add(new Orden(Integer.parseInt(cantidad),identificador,platillo,0));
            cantidad=""; identificador=""; platillo="";
            separaProd(p, i);
        }
        return listaorden;
    }
    
    
}
