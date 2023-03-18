package ro.raffa.curs.dto;

import java.util.HashMap;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TemaLista {

    @JsonProperty ("Lista Jocuri")
    private HashMap<Integer,String> lista=new HashMap<Integer,String>();

    public TemaLista() {
        String games2022="Monster Hunter Rise, The Anacrusis, God of War, Nobody Saves the World.";
        String games2021="New World, Ratchet & Clank: Rift Apart, Far Cry 6, Resident Evil Village";
        this.lista.put(2021,games2021);
        this.lista.put(2022,games2022);
    }


    

}
