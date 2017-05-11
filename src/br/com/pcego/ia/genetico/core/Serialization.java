/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pcego.ia.genetico.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Pcego
 */
public class Serialization {

    /**
     * Copia um objeto através de mecanismos de serialização.
     */
    @SuppressWarnings("unchecked")
    public static <T> T copy(T source) {
        try {

            ByteArrayOutputStream ostream = new ByteArrayOutputStream();
            ObjectOutputStream oostream = new ObjectOutputStream(ostream);

            oostream.writeObject(source);
            oostream.flush();
            // converte o objeto emum vetor de Bytes
            byte[] bytes = ostream.toByteArray();

            InputStream istream = new ByteArrayInputStream(bytes);
            ObjectInputStream oistream = new ObjectInputStream(istream);
            
            // retorna o objeto sem as referências do objeto original
            return (T) oistream.readObject();
            
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException(source.getClass().getName(), e);
        }
    }
}
