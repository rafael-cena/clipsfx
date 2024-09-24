package org.example.clipsfx.db;

import siseventos.db.util.Conexao;

public class SingletonDB {
    static private Conexao conexao;

    private SingletonDB() {}

    static public boolean conectar () {
        conexao = new Conexao();
        conexao.conectar("jdbc:postgresql://localhost:5432/", "db_musics", "postgres", "postgres123");
        return conexao.getEstadoConexao();

    }

    public static Conexao getConexao() {
        return conexao;
    }
}
