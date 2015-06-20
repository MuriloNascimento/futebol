package com.m104.futebol.model.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.m104.futebol.model.entidades.Jogador;
import com.m104.futebol.model.entidades.Time;

public class JogadorAdapter extends XmlAdapter<Jogador, Jogador>{

    public Jogador marshal(Jogador v) throws Exception {  
        v.setTime(new Time(v.getTime().getId()));  
        return v;  
    }  
    public Jogador unmarshal(Jogador v) throws Exception {  
        return v;  
    } 
	
}
