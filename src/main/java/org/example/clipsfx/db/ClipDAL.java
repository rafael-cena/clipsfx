package org.example.clipsfx.db;

import org.example.clipsfx.db.Clip;
import siseventos.db.util.Conexao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClipDAL {

    public boolean inserir(Clip clip) {
        String insert = """
                    INSERT INTO clip(
                    clp_id, clp_artista, clp_titulo, clp_duracao, clp_pubdata, clp_url)
                    VALUES (DEFAULT, '#1', '#2', #3, '#4', '#5');""";
        insert = insert.replace("#1", clip.getArtista());
        insert = insert.replace("#2", clip.getTitulo());
        insert = insert.replace("#3", ""+clip.getDuracao());
        insert = insert.replace("#4", clip.getPubdata().toString());
        insert = insert.replace("#5", clip.getUrl());

        return SingletonDB.getConexao().manipular(insert);
    }

    public boolean alterar(Clip clip) {
        String update = """
                UPDATE clip
                	SET clp_artista='#1', clp_titulo='#2', clp_duracao=#3, clp_pubdata='#4', clp_url='#5'
                	WHERE clp_id=#6;
                """;
        update = update.replace("#1", clip.getArtista());
        update = update.replace("#2", clip.getTitulo());
        update = update.replace("#3", ""+clip.getDuracao());
        update = update.replace("#4", clip.getPubdata().toString());
        update = update.replace("#5", clip.getUrl());
        update = update.replace("#6", ""+clip.getId());

        return SingletonDB.getConexao().manipular(update);
    }

    public boolean apagar (Clip clip) {
        return SingletonDB.getConexao().manipular("DELETE FROM clip WHERE clp_id="+clip.getId());
    }

    public Clip get (int id) {
        Clip clip = null;
        ResultSet resultSet = SingletonDB.getConexao().consultar("SELECT * FROM clip WHERE clp_id="+id);
        try {
            if (resultSet.next())
                clip = new Clip(id, resultSet.getString("clp_artista"), resultSet.getString("clp_titulo"),
                        resultSet.getInt("clp_duracao"), resultSet.getDate("clp_pubdata").toLocalDate(), resultSet.getString("clp_url"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return clip;
    }

    public List<Clip> get (String filtro) {
        List<Clip> clips = new ArrayList<>();
        String select = "SELECT * FROM clip";
        if (!filtro.isEmpty())
            select+=" WHERE "+filtro;
        ResultSet resultSet = SingletonDB.getConexao().consultar(select);
        try {
            while (resultSet.next())
                clips.add(new Clip(resultSet.getInt("clp_id"), resultSet.getString("clp_artista"), resultSet.getString("clp_titulo"),
                        resultSet.getInt("clp_duracao"), resultSet.getDate("clp_pubdata").toLocalDate(), resultSet.getString("clp_url")));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return clips;
    }
}
