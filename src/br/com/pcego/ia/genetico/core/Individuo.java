/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pcego.ia.genetico.core;

import java.io.Serializable;

/**
 *
 * @author Pcego
 */
public class Individuo implements Comparable<Individuo>, Serializable{

    private String[] individuo;
    private int fa;
    private int fa_roleta;
    private int somatorio;

    public String[] getIndividuo() {
        return individuo;
    }

    public void setIndividuo(String[] individuo) {
        this.individuo = individuo;
    }

    public int getFa() {
        return fa;
    }

    public void setFa(int fa) {
        this.fa = fa;
    }

    public int getFa_roleta() {
        return fa_roleta;
    }

    public void setFa_roleta(int fa_roleta) {
        this.fa_roleta = fa_roleta;
    }

    public int getSomatorio() {
        return somatorio;
    }

    public void setSomatorio(int somatorio) {
        this.somatorio = somatorio;
    }

    
    public String converteVetor() {
        String resultado = "";
        for (int i = 0; i < 10; i++) {
            resultado += individuo[i];
        }
        return resultado;
    }
    
    // método que define o parametro de ordenação
    @Override
    public int compareTo(Individuo o) {
        if (this.fa < o.fa) {
            return -1;
        }
        if (this.fa > o.fa) {
            return 1;
        }
        return 0;
    }
}
